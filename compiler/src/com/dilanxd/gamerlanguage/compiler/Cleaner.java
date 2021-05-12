package com.dilanxd.gamerlanguage.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cleaner {

	public static Map<String, Function> parse(List<String> all) { 

		Map<String, Function> code = new HashMap<>();

		String curName = null;
		String[] args = null;
		List<String> cur = null;

		int scope = 0;

		for (String line : all) {

			line = line.trim().replaceAll("\t", "");
			if (line.isEmpty()) continue;

			String funcStart = Binding.FUNC_START + " ";

			if (line.startsWith(funcStart)) {

				if (line.contains(": ")) {

					String[] data = line.substring(funcStart.length()).split(": ");

					curName = data[0];

					args = data[1].trim().split(" ");

				} else {
					
					curName = line.substring(funcStart.length());
					
					args = null;
					
				}

				cur = new ArrayList<String>();
				continue;

			}

			if (line.equals(Binding.FUNC_END)) {

				Function func = new Function(cur, args);

				code.put(curName, func);
				continue;

			}

			if (curName != null) {

				if (line.equals(Binding.BLOCK_END)) {

					scope--;

				}

				cur.add(scope + "!" + line);

				if (line.endsWith("?")) {


					scope++;

				}

			}

		}

		return code;



	}

	public static String removeScopeIndicator(String phrase) {

		String scope = phrase.split("!")[0];

		return phrase.substring(scope.length() + 1);

	}

	public static String removeStringConstants(String phrase) {

		String newPhrase = "";

		int length = phrase.length();
		boolean inQuote = false;
		for (int i = 0; i < length; i++) {

			char c = phrase.charAt(i);

			if (c == '"') {

				inQuote = !inQuote;

			} else {

				if (!inQuote)
					newPhrase += c;

			}

		}

		return newPhrase;

	}

}
