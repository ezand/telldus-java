package org.ezand.telldus.cli.utils;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ezand.telldus.core.TelldusException;
import org.ezand.telldus.core.domain.Device;
import org.ezand.telldus.core.domain.Sensor;

import com.google.common.base.Splitter;

public class CliResultParser {
	private static final Pattern DIM_RESULT_PATTERN = Pattern.compile("Dimming device: (\\d) (.*) to (\\d{1,3}) - (.*)");

	/**
	 * @param devices as a concatenated String.
	 * @return a list of {@link Device} objects.
	 */
	public static List<Device> parseDevices(final String devices) {
		return isEmpty(devices) ? newArrayList() : stream(devices.split("\n"))
				.map(d -> new Device(Splitter.on("\t").withKeyValueSeparator("=").split(d)))
				.collect(toList());
	}

	/**
	 * @param sensors as a concatenated String.
	 * @return a list of {@link Sensor} objects.
	 */
	public static List<Sensor> parseSensors(final String sensors) {
		return isEmpty(sensors) ? newArrayList() : stream(sensors.split("\n"))
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
	 * @throws TelldusException if dim result can't be retrieved.
	 */
	public static int parseDimResult(final String result) {
		final Matcher matcher = DIM_RESULT_PATTERN.matcher(result.trim());
		if (!matcher.find()) {
			throw new TelldusException(format("Could not get dim result from '%s'", result));
		}
		return parseInt(matcher.group(3));
	}
}
