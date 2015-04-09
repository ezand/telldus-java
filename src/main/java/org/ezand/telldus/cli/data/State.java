package org.ezand.telldus.cli.data;

public class State {
	private final Type type;
	private final String state;

	public State(final Type type, final String state) {
		this.type = type;
		this.state = state;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "State{" +
				"state='" + state + '\'' +
				", type=" + type +
				'}';
	}

	public Type getType() {
		return type;
	}
}
