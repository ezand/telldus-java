package no.ezand.telldus.cli;

public enum SensorProtocol {
	MANDOLYN;

	public static SensorProtocol fromName(final String name) {
		return name == null ? null : valueOf(name.toUpperCase());
	}
}
