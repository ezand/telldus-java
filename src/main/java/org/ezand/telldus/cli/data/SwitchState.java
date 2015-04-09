package org.ezand.telldus.cli.data;

public enum SwitchState {
	ON, OFF;

	public String lowerName() {
		return name().toLowerCase();
	}
}
