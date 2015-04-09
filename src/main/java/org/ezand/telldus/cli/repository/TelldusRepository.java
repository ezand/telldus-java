package org.ezand.telldus.cli.repository;

import java.util.List;

import org.ezand.telldus.cli.data.Device;
import org.ezand.telldus.cli.data.Sensor;
import org.ezand.telldus.cli.data.State;
import org.ezand.telldus.cli.utils.TelldusException;

public interface TelldusRepository {
	List<Device> getDevices() throws TelldusException;

	State getDeviceState(int id) throws TelldusException;

	State turnDeviceOn(int id) throws TelldusException;

	State turnDeviceOff(int id) throws TelldusException;

	State dimDevice(int id, int level) throws TelldusException;

	List<Sensor> getSensors() throws TelldusException;
}
