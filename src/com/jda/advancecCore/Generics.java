package com.jda.advancecCore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jda.util.Utility;

public class Generics {
	private static String fullName;
	private static String phoneNumber;
	private static String fileData;
	private static Pattern p;
	private static Matcher m;

	private static String getfileData() throws IOException {

		return new String(Files.readAllBytes(Paths.get("/home/bridgelabz/Desktop/pattern.txt")));
	}

	public static void getInput() {
		System.out.println(
		      "Hello Sir/Madam , I request you to please enter your full name so that I can test if I am working correctly or not:");
		fullName = Utility.getString();
		System.out.println("Ab itna kar dia hai toh phone number bhi daal hi do ji");
		phoneNumber = Utility.getString();
	}

	public static void replaceName() {
		p = Pattern.compile("<<\\w+>>");
		m = p.matcher(fileData);
		if (m.find()) {
			fileData = m.replaceAll(fullName.split(" ")[0]);
		}
	}

	public static void replaceFullName() {
		p = Pattern.compile("<{2}\\w+\\s\\w+>}");
		m = p.matcher(fileData);
		if (m.find()) {
			fileData = m.replaceAll(fullName);
		}
	}

	public static void replaceDate() {
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter dtmformat = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		p = Pattern.compile("[0-9]{2}/[0-9]{2}/[0-9]{4}");
		m = p.matcher(fileData);
		if (m.find()) {
			fileData = m.replaceAll(dtmformat.format(time));
		}
	}

	public static void replacePhoneNumber() {
		p = Pattern.compile("x{10}");
		m = p.matcher(fileData);
		if (m.find()) {
			fileData = m.replaceAll(phoneNumber);
		}

	}

	public static void main(String[] args) throws IOException {
		fileData = getfileData();
	//	getfileData();
		getInput();
		replaceName();
		replaceFullName();
		replaceDate();
		replacePhoneNumber();
		System.out.println(fileData);
	}

}
