package org.ezand.telldus.cli.utils;

import static java.util.Optional.empty;
import static java.util.Optional.of;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

public class CommandExecutor {
	/**
	 * Natively execute the tdtool command.
	 *
	 * @param command array of the command and its parameters
	 * @return command result as a String. Optional.empty if result is empty.
	 * @throws TelldusException if the command fails fatally.
	 */
	public static Optional<String> execute(final String... command) {
		try {
			final ProcessBuilder builder = new ProcessBuilder(command);
			final Process process = builder.start();
			final InputStream is = process.getInputStream();

			try (final Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
				return scanner.hasNext() ? of(scanner.useDelimiter("/A").next()) : empty();
			}
		} catch (final Exception e) {
			throw new TelldusException(e);
		}
	}
}
