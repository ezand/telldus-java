package org.ezand.telldus.cli.repository;

import static java.lang.String.valueOf;
import static org.ezand.telldus.cli.utils.CliResultParser.parseDevices;
import static org.ezand.telldus.cli.utils.CliResultParser.parseDimResult;
import static org.ezand.telldus.cli.utils.CliResultParser.parseSensors;
import static org.ezand.telldus.cli.utils.CliResultParser.parseSwitchResult;

import java.util.List;
import java.util.Optional;

import org.ezand.telldus.cli.data.Device;
import org.ezand.telldus.cli.data.LastSentCommand;
import org.ezand.telldus.cli.data.Sensor;
import org.ezand.telldus.cli.utils.CommandExecutor;
import org.ezand.telldus.cli.utils.TelldusException;

public class CliRepository implements TelldusRepository {
	private final String tdtool;

	public CliRepository(final String tdtool) {
		this.tdtool = tdtool;
	}

	/**
	 * @return a list of {@link Device} objects.
	 */
	@Override
	public List<Device> getDevices() {
		return parseDevices(CommandExecutor.execute(tdtool, "--list-devices"));
	}

	/**
	 * @return a list of {@link Sensor} objects.
	 * @throws TelldusException if tdtool-command fails.
	 */
	@Override
	public List<Sensor> getSensors() throws TelldusException {
		return parseSensors(CommandExecutor.execute(tdtool, "--list-sensors"));
	}

	/**
	 * @param id the device id.
	 * @return the device state as a String.
	 * @throws TelldusException if tdtool-command fails.
	 */
	@Override
	public String getDeviceState(final int id) throws TelldusException {
		final Optional<Device> optional = getDevices().stream().filter(d -> d.getId() == id).findFirst();
		final Device device = optional.orElseThrow(() -> new TelldusException("State unknown"));
		switch (device.getLastSentCommand()) {
			case ON:
				return LastSentCommand.ON.name();
			case OFF:
				return LastSentCommand.OFF.name();
			case DIMMED:
				return LastSentCommand.DIMMED.name() + " dim_level=" + device.getProperties().get("dimlevel");
			default:
				return "Unknown state";
		}
	}

	/**
	 * @param id the device id.
	 * @return true if device was successfully switched on, false otherwise.
	 * @throws TelldusException if tdtool-command fails.
	 */
	@Override
	public boolean turnDeviceOn(final int id) throws TelldusException {
		return parseSwitchResult(CommandExecutor.execute(tdtool, "--on", valueOf(id)));
	}

	/**
	 * @param id the device id.
	 * @return true if device was successfully switched off, false otherwise.
	 * @throws TelldusException if tdtool-command fails.
	 */
	@Override
	public boolean turnDeviceOff(final int id) {
		return parseSwitchResult(CommandExecutor.execute(tdtool, "--off", valueOf(id)));
	}

	/**
	 * @param id the device id.
	 * @param level the dim-level value (0-255).
	 * @return the curretn dim-level value (0-255) after the operation is finished.
	 * @throws TelldusException if tdtool-command fails.
	 */
	@Override
	public int dimDevice(final int id, final int level) throws TelldusException {
		return parseDimResult(CommandExecutor.execute(tdtool, "--dimlevel", valueOf(level), "--dim", valueOf(id)));
	}
}
