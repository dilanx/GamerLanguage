package com.dilanxd.gamerlanguage.compiler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GamerLanguage {


	public static Map<String, Function> code;
	public static Scanner scanner;

	public static void main(String[] args) throws IOException {
		
		if (args.length < 1) {

			System.err.println("Anti pog number of args. Provide a file name to compile plz.");
			return;

		}

		File file = new File(args[0]);

		if (!file.exists()) {

			System.err.println("Imagine giving me a file that doesn't exist. What a shame.");
			return;

		}

		List<String> lines = Files.readAllLines(file.toPath());

		scanner = new Scanner(System.in);
		
		code = Cleaner.parse(lines);
		Runner.runBlock(Binding.FUNC_MAIN, null);
		
		scanner.close();

	}


}
