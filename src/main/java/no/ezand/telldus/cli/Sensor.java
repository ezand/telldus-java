package no.ezand.telldus.cli;

import static com.google.common.collect.Sets.newHashSet;
import static java.lang.Integer.parseInt;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.stream.Collectors.toMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sensor {
	private static final Set<String> DEVICE_KEYS = newHashSet("id", "model", "protocol", "type", "time");
	private static final DateTimeFormatter formatter = ofPattern("yyyy-MM-dd HH:mm:ss"); // TODO how does this fit other sensors?

	private final int id;
	private final SensorProtocol protocol;
	private final SensorModel model;
	private final LocalDateTime lastUpdated;
	private final Map<String, String> properties;

	public Sensor(final Map<String, String> properties) {
		this.id = parseInt(properties.get("id"));
		this.protocol = SensorProtocol.fromName(properties.get("protocol"));
		this.model = SensorModel.fromName(properties.get("model"));
		this.lastUpdated = properties.get("time") == null ? null : LocalDateTime.from(formatter.parse(properties.get("time")));
		this.properties = properties.entrySet().stream()
				.filter(e -> !DEVICE_KEYS.contains(e.getKey()))
				.collect(toMap(Entry::getKey, Entry::getValue));
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public SensorModel getModel() {
		return model;
	}

	public SensorProtocol getProtocol() {
		return protocol;
	}

	@Override
	public String toString() {
		return "Sensor{" +
				"id=" + id +
				", model=" + model +
				", protocol=" + protocol +
				", lastUpdated=" + lastUpdated +
				", properties=" + properties +
				'}';
	}
}
