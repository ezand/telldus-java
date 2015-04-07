package org.ezand.telldus.cli.repository;

import java.util.List;

import org.ezand.telldus.cli.utils.TelldusException;
import org.ezand.telldus.cli.data.Device;
import org.ezand.telldus.cli.data.Sensor;

public interface TelldusRepository {
	List<Device> getDevices() throws TelldusException;

	String getDeviceState(int id) throws TelldusException;

	boolean turnDeviceOn(int id) throws TelldusException;

	boolean turnDeviceOff(int id) throws TelldusException;

	int dimDevice(int id, int level) throws TelldusException;

	List<Sensor> getSensors() throws TelldusException;
}
