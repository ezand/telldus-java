package no.ezand.telldus.cli.data;

import static java.util.Arrays.stream;

public enum SensorModel {
	TEMPERATURE("temperature"),
	TEMPERATURE_HUMIDITY("temperaturehumidity");

	private final String key;

	SensorModel(final String key) {
		this.key = key;
	}

	public static SensorModel fromName(final String name) {
		return name == null ? null : stream(values()).filter(p -> p.key.equals(name)).distinct().findFirst().get();
	}
}
