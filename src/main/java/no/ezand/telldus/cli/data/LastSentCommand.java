package no.ezand.telldus.cli.data;

public enum LastSentCommand {
	ON, OFF, DIMMED;

	public static LastSentCommand fromName(final String name) {
		return name == null ? null : valueOf(name);
	}
}
