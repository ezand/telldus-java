package no.ezand.telldus.cli;

import java.util.List;

public interface TelldusRepository {
	List<Device> getDevices() throws TelldusException;

	String getDeviceState(int id) throws TelldusException;

	boolean turnDeviceOn(int deviceId) throws TelldusException;

	boolean turnDeviceOff(int deviceId) throws TelldusException;

	int dimDevice(int deviceId, int level) throws TelldusException;

	List<Sensor> getSensors() throws TelldusException;
}
