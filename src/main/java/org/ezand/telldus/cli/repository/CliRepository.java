package org.ezand.telldus.cli.repository;

import static java.lang.String.valueOf;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.ezand.telldus.cli.utils.CliResultParser.parseDevices;
import static org.ezand.telldus.cli.utils.CliResultParser.parseDimResult;
import static org.ezand.telldus.cli.utils.CliResultParser.parseSensors;
import static org.ezand.telldus.cli.utils.CliResultParser.parseSwitchResult;
import static org.ezand.telldus.cli.utils.CommandExecutor.execute;
import static org.ezand.telldus.core.domain.Type.DIMMER;
import static org.ezand.telldus.core.domain.Type.SWITCH;
import static org.ezand.telldus.core.domain.Type.UNKNOWN;

import java.util.List;

import org.ezand.telldus.core.TelldusException;
import org.ezand.telldus.core.domain.Device;
import org.ezand.telldus.core.domain.Sensor;
import org.ezand.telldus.core.domain.State;
import org.ezand.telldus.core.repository.TelldusRepository;
import org.ezand.telldus.core.util.RichBoolean;

public class CliRepository implements TelldusRepository {
	private final String tdtool;

	public CliRepository(final String tdtool) {
		this.tdtool = tdtool;
	}

	/**
	 * @return a list of {@link Device} objects.
	 * @throws TelldusException if tdtool-command fails fatally.
	 */
	@Override
	public List<Device> getDevices() throws TelldusException {
		return parseDevices(execute(tdtool, "--list-devices").orElse(EMPTY));
	}

	/**
	 * @return a list of {@link Sensor} objects.
	 * @throws TelldusException if tdtool-command fails fatally.
	 */
	@Override
	public List<Sensor> getSensors() throws TelldusException {
		return parseSensors(execute(tdtool, "--list-sensors").orElse(EMPTY));
	}

	/**
	 * @param id the device id.
	 * @return a {@link State} object containing the device type and state.
	 * The state will be the dim level for dimmers and a {@link RichBoolean} instance for switches.
	 * @throws TelldusException if tdtool-command fails fatally.
	 */
	@Override
	public State<?> getDeviceState(final int id) throws TelldusException {
		final Device device = getDevices().stream().filter(d -> d.getId() == id).findFirst().orElseThrow(() -> new TelldusException("State unknown"));
		final RichBoolean value = new RichBoolean(device.getLastSentCommand().name());
		switch (device.getLastSentCommand()) {
			case ON:
			case OFF:
				return new State<>(SWITCH, value);
			case DIMMED:
				return new State<>(DIMMER, device.getProperties().get("dimlevel"));
			default:
				return new State<>(UNKNOWN, "Unknown state");
		}
	}

	/**
	 * Will try to switch the device on. If the command fails, the current state of the device will be returned.
	 *
	 * @param id the device id.
	 * @return a {@link RichBoolean} instance with a positive value if device was switched on successfully, a negative value otherwise.
	 * @throws TelldusException if tdtool-command fails fatally.
	 */
	@Override
	public State<RichBoolean> turnDeviceOn(final int id) throws TelldusException {
		final boolean success = parseSwitchResult(execute(tdtool, "--on", valueOf(id)).orElse(EMPTY));
		return new State<>(SWITCH, new RichBoolean(success || ((RichBoolean) getDeviceState(id).getState()).asBoolean()));
	}

	/**
	 * Will try to switch the device off. If the command fails, the current state of the device will be returned.
	 *
	 * @param id the device id.
	 * @return a {@link RichBoolean} instance with a negative value if device was switched off successfully, a positive value otherwise.
	 * @throws TelldusException if tdtool-command fails fatally.
	 */
	@Override
	public State<RichBoolean> turnDeviceOff(final int id) throws TelldusException {
		final boolean success = parseSwitchResult(execute(tdtool, "--off", valueOf(id)).orElse(EMPTY));
		//noinspection SimplifiableConditionalExpression
		return new State<>(SWITCH, new RichBoolean(success ? false : ((RichBoolean) getDeviceState(id).getState()).asBoolean()));
	}

	/**
	 * Will try to dim the device. If the command fails, the current state of the device will be returned.
	 *
	 * @param id    the device id.
	 * @param level the dim-level value (0-255).
	 * @return the current dim-level value (0-255) after the operation is finished.
	 * @throws TelldusException if tdtool-command fails fatally or if the dim value
	 *                          could not be retrieved from the command result.
	 */
	@Override
	public State<String> dimDevice(final int id, final int level) throws TelldusException {
		return new State<>(DIMMER, valueOf(parseDimResult(execute(tdtool, "--dimlevel", valueOf(level), "--dim", valueOf(id)).orElse(EMPTY))));
	}
}
