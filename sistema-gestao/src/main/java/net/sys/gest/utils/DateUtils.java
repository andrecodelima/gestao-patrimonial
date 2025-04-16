package net.sys.gest.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now();
	}
	
	public static String format(LocalDateTime dateTime) {
		return dateTime.format(FORMATTER);
	}
	
	public static LocalDateTime parse(String dateTime) {
		return LocalDateTime.parse(dateTime, FORMATTER);
	}
	
}
