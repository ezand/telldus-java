package no.ezand.telldus.cli.utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import no.ezand.telldus.cli.utils.TelldusException;

public class CommandExecutor {
	public static String execute(String... command) {
		try {
			final ProcessBuilder builder = new ProcessBuilder(command);
			final Process process = builder.start();
			final InputStream is = process.getInputStream();

			try (final Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.name())) {
				return scanner.useDelimiter("/A").next();
			}
		} catch (final Exception e) {
			throw new TelldusException(e);
		}
	}
}
