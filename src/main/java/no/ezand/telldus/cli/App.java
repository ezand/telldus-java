package no.ezand.telldus.cli;

public class App {
	public static void main(String[] args) throws Exception {
		new App();
	}

	public App() throws Exception {
		final CliRepository repository = new CliRepository();
		System.out.println("Devices:\n" + repository.getDevices());
		System.out.println("Sensors:\n" + repository.getSensors());

		System.out.println("\n\nTurn on: " + repository.turnDeviceOn(2));
		Thread.sleep(1000);
		System.out.println("Turn off: " + repository.turnDeviceOff(2));
		Thread.sleep(1000);
		System.out.println("Turn on: " + repository.turnDeviceOn(2));
		Thread.sleep(1000);

		System.out.println("\n\nDim: " + repository.dimDevice(1, 180));

		System.out.println("\n\nDevice state: " + repository.getDeviceState(1));
		System.out.println("Device state: " + repository.getDeviceState(2));
		System.out.println("Device state: " + repository.getDeviceState(3));
		System.out.println("Device state: " + repository.getDeviceState(4));
		System.out.println("Device state: " + repository.getDeviceState(5));
	}
}
