package no.ezand.telldus.cli;

import static com.google.common.collect.Sets.newHashSet;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Device {
	private static final Set<String> DEVICE_KEYS = newHashSet("id", "name", "lastsentcommand", "type");

	private final Integer id;
	private final String name;
	private final LastSentCommand lastSentCommand;
	private final Map<String, String> properties;

	public Device(final Map<String, String> properties) {
		this.id = parseInt(properties.get("id"));
		this.name = properties.get("name");
		this.lastSentCommand = LastSentCommand.fromName(properties.get("lastsentcommand"));
		this.properties = properties.entrySet().stream()
				.filter(e -> !DEVICE_KEYS.contains(e.getKey()))
				.collect(toMap(Entry::getKey, Entry::getValue));
	}

	// TODO Remove
	public Device(Integer id) {
		this.id = id;
		this.name = null;
		this.lastSentCommand = null;
		this.properties = null;
	}

	public Integer getId() {
		return id;
	}

	public LastSentCommand getLastSentCommand() {
		return lastSentCommand;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return "Device{" +
				"id=" + id +
				", name='" + name + '\'' +
				", lastSentCommand=" + lastSentCommand +
				", properties=" + properties +
				'}';
	}
}
