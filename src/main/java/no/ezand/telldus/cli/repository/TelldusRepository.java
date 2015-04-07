package no.ezand.telldus.cli.repository;

import java.util.List;

import no.ezand.telldus.cli.utils.TelldusException;
import no.ezand.telldus.cli.data.Device;
import no.ezand.telldus.cli.data.Sensor;

public interface TelldusRepository {
	List<Device> getDevices() throws TelldusException;

	String getDeviceState(int id) throws TelldusException;

	boolean turnDeviceOn(int deviceId) throws TelldusException;

	boolean turnDeviceOff(int deviceId) throws TelldusException;

	int dimDevice(int deviceId, int level) throws TelldusException;

	List<Sensor> getSensors() throws TelldusException;
}
