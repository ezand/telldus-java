package no.ezand.telldus.cli.repository;

import static java.lang.String.valueOf;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

import no.ezand.telldus.cli.utils.CommandExecutor;
import no.ezand.telldus.cli.utils.TelldusException;
import no.ezand.telldus.cli.data.Device;
import no.ezand.telldus.cli.data.LastSentCommand;
import no.ezand.telldus.cli.data.Sensor;
import no.ezand.telldus.cli.utils.CliResultParser;

public class CliRepository implements TelldusRepository {
	private final String tdtool;
	private final Properties properties = new Properties();

	public CliRepository() throws Exception {
		properties.load(getClass().getResourceAsStream("/telldus.properties"));
		tdtool = properties.getProperty("tdtool.path");
	}

	@Override
	public List<Device> getDevices() {
		return CliResultParser.parseDevices(CommandExecutor.execute(tdtool, "--list-devices"));
	}

	@Override
	public List<Sensor> getSensors() throws TelldusException {
		return CliResultParser.parseSensors(CommandExecutor.execute(tdtool, "--list-sensors"));
	}

	@Override
	public String getDeviceState(final int id) {
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

	@Override
	public boolean turnDeviceOn(final int deviceId) {
		return CliResultParser.parseSwitchResult(CommandExecutor.execute(tdtool, "--on", valueOf(deviceId)));
	}

	@Override
	public boolean turnDeviceOff(final int deviceId) {
		return CliResultParser.parseSwitchResult(CommandExecutor.execute(tdtool, "--off", valueOf(deviceId)));
	}

	@Override
	public int dimDevice(int deviceId, int level) throws TelldusException {
		return CliResultParser.parseDimResult(CommandExecutor.execute(tdtool, "--dimlevel", valueOf(level), "--dim", valueOf(deviceId)));
	}
}
