package org.ezand.telldus.cli.utils;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ezand.telldus.cli.data.Device;
import org.ezand.telldus.cli.data.Sensor;

import com.google.common.base.Splitter;

public class CliResultParser {
	private static final Pattern DIM_RESULT_PATTERN = Pattern.compile("Dimming device: (\\d) (.*) to (\\d{1,3}) - (.*)");

	/**
	 * @param devices as a concatenated String.
	 * @return a list of {@link Device} objects.
	 */
	public static List<Device> parseDevices(final String devices) {
		return stream(devices.split("\n"))
				.map(d -> new Device(Splitter.on("\t").withKeyValueSeparator("=").split(d)))
				.collect(toList());
	}

	/**
	 * @param sensors as a concatenated String.
	 * @return a list of {@link Sensor} objects
	 */
	public static List<Sensor> parseSensors(final String sensors) {
		return stream(sensors.split("\n"))
				.map(d -> new Sensor(Splitter.on("\t").withKeyValueSeparator("=").split(d)))
				.collect(toList());
	}

	/**
	 * @param result as a String.
	 * @return true if switch-operation was successful, false otherwise.
	 */
	public static boolean parseSwitchResult(final String result) {
		return result.substring(result.lastIndexOf("- ") + 2).trim().equalsIgnoreCase("success");
	}

	/**
	 * @param result as a String.
	 * @return the dim-level value.
	 */
	public static int parseDimResult(final String result) {
		final Matcher matcher = DIM_RESULT_PATTERN.matcher(result.trim());
		if (!matcher.find()) {
			throw new TelldusException("Could not get dim result");
		}
		return parseInt(matcher.group(3));
	}
}
