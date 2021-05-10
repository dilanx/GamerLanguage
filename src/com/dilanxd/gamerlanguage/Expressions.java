package com.dilanxd.gamerlanguage;

public class Expressions {

	public static Object get(String blockName, String phrase, int startIndex) {

		char start = phrase.charAt(startIndex);

		if (start == '"') {

			String ans = "";

			for (int i = startIndex + 1; i < phrase.length(); i++) {

				char c = phrase.charAt(i);

				if (c == '"') {

					return ans;

				}

				else {

					ans += c;

				}

			}

		}

		String word = "";

		for (int i = startIndex; i < phrase.length(); i++) {

			char c = phrase.charAt(i);

			if (c == '?' || c == ' ' || c == ',') break;

			word += c;

		}
		
		String var = blockName + ":" + word;
		if (Variables.has(var)) {
			return Variables.get(var);
		}

		if (start == Binding.TRUE) return true;
		if (start == Binding.FALSE) return false;

		double perhapsNumber = 0;

		try {

			perhapsNumber = Double.parseDouble(word);
			return perhapsNumber;

		} catch (NumberFormatException e) {

			return null;

		}

	}

}
