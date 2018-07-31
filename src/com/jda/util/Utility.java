package com.jda.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
	private static Scanner sc = new Scanner(System.in);

	public static String getString() {
		String str = sc.nextLine();
		return str;
	}

	public static int getInt() {
		int i = sc.nextInt();
		return i;
	}

	public static List<String> allFilesInFolder(String path) {
		File folder = new File(path);
		File[] allFiles = folder.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".json");
			}
		});
		List<String> Files = new ArrayList<>();
		for (int i = 0; i < allFiles.length; i++) {
			Files.add(allFiles[i].getName());
		}
		return Files;
	}
}
