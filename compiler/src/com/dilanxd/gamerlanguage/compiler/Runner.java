package com.dilanxd.gamerlanguage.compiler;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static Object runBlock(String blockName, Object[] args) {

		Function func = GamerLanguage.code.get(blockName);

		List<String> block = func.getCode();

		String[] funcArgs = func.getArgumentVars();

		if (funcArgs != null) {

			for (int i = 0; i < funcArgs.length; i++) {

				String a = funcArgs[i];

				// recursion not supported atm

				Variables.set(blockName + ":" + a, args[i]);

			}

		}

		int l = 0;
		int loopScope = 0;

		while (l < block.size()) {

			String wholeLine = block.get(l);
			String scope = wholeLine.split("!")[0];
			String line = wholeLine.substring(scope.length() + 1);
			String lineNoStrConst = Cleaner.removeStringConstants(line);

			/* VAR ASSIGN AND FUNC CALL */

			String varAssign = " " + Binding.VAR_ASSIGN + " ";

			if (lineNoStrConst.contains(varAssign)) {

				String[] data = line.split(" ");
				String key = data[0];
				// gab mains gab but 5
				String varName = blockName + ":" + data[2];

				if (Variables.has(varName)) {
					
					if (data.length >= 5) {
						
						if (data[3].equals("but")) {
							
							
							double d1 = (double) Variables.get(varName);
							double d2 = (double) Expressions.get(blockName, data[4], 0);
							
							Variables.set(blockName + ":" + data[0], d1 + d2);
							l++;
							continue;
							
						}
						
					}
					
				}
				
				

				Object val = Expressions.get(blockName, line, key.length() + varAssign.length());

				if (val == null) {

					String funcPhrase = line.substring(key.length() + varAssign.length());

					String funcKey = funcPhrase;

					if (funcPhrase.contains(" as ")) {

						funcKey = funcPhrase.split(" as ")[0];
						funcPhrase = funcPhrase.substring(funcKey.length() + 4);

						List<Integer> spacesThatMatter = new ArrayList<>();

						spacesThatMatter.add(0);

						boolean inQuotes = false;

						for (int i = 0; i < funcPhrase.length(); i++) {

							char c = funcPhrase.charAt(i);

							if (c == '"') {

								inQuotes = !inQuotes;

							} else {

								if (!inQuotes && c == ' ') {

									spacesThatMatter.add(i + 1);

								}

							}

						}

						Object[] sendingArgs = new Object[spacesThatMatter.size()];

						for (int i = 0; i < sendingArgs.length; i++) {

							sendingArgs[i] = Expressions.get(blockName, funcPhrase, spacesThatMatter.get(i));

						}

						val = Runner.runBlock(funcKey, sendingArgs);

					} else {

						val = Runner.runBlock(funcKey, null);

					}

				}

				Variables.set(blockName + ":" + key, val);

				l++;

				continue;

			}

			String inc = " " + Binding.VAR_NUM_INC_START;
			String dec = " " + Binding.VAR_NUM_DEC_START;

			if (lineNoStrConst.contains(inc) || lineNoStrConst.contains(dec)) {

				String key = line.split(" ")[0];

				boolean increase = lineNoStrConst.contains(inc);

				int to = 1;

				for (int i = key.length() + (increase ? inc.length() : dec.length());
				i < line.length(); i++) {

					String rest = line.substring(i);

					if ((increase && rest.equals(Binding.VAR_NUM_INC_END))
							|| (!increase && rest.equals(Binding.VAR_NUM_DEC_END))) {
						break;
					}

					to++;

				}

				String varName = blockName + ":" + key;
				double var = (double) Variables.get(varName);
				var += (to * (increase ? 1 : -1));				
				Variables.set(varName, var);

			}

			/* CONDITION */

			String ifStatement = Binding.IF_START + " ";

			if (lineNoStrConst.startsWith(ifStatement)) {

				boolean shouldCont = Condition.checkIf(blockName, line, 1);

				if (shouldCont) {

					l++;
					continue;

				} else {

					l = findNextOfSameScope(l, scope, block);
					continue;

				}

			}


			/* LOOPS */

			String whileLoop = Binding.LOOP_WHILE + " ";

			if (lineNoStrConst.startsWith(whileLoop)) {

				boolean shouldCont = Condition.checkIf(blockName, line, 2);


				if (shouldCont) {

					loopScope++;
					l++;
					continue;

				} else {

					l = findNextOfSameScope(l, scope, block);
					continue;

				}

			}

			if (lineNoStrConst.equals(Binding.LOOP_BREAK) && loopScope > 0) {

				String lastScope;
				int prev;

				int sub = 1;

				do {

					lastScope = Integer.toString(Integer.parseInt(scope) - sub);

					prev = findPrevOfSameScope(l, lastScope, block);
					sub++;

				} while (!Cleaner.removeScopeIndicator(block.get(prev)).startsWith(whileLoop));

				int next = findNextOfSameScope(prev, lastScope, block);

				l = next + 1;
				loopScope--;
				continue;

			}

			if (lineNoStrConst.equals(Binding.BLOCK_END) && loopScope > 0) {

				int prev = findPrevOfSameScope(l, scope, block);

				String p = Cleaner.removeScopeIndicator(block.get(prev));

				if (p.startsWith(whileLoop)) {

					l = prev;
					loopScope--;
					continue;

				}

			}



			/* PRINT AND RETURN */

			String print = Binding.PRINT + " ";

			if (lineNoStrConst.startsWith(print)) {

				Object val = Expressions.get(blockName, line, print.length());

				String[] data = line.split(" ");

				String dest = data[data.length - 1];

				if (dest.equals(Binding.PRINT_STDOUT)) {

					System.out.println(val.toString());

				}

				l++;
				continue;

			}

			String input = Binding.INPUT + " ";

			if (lineNoStrConst.startsWith(input)) {

				String[] data = line.split(" ");
				
				String var = blockName + ":" + data[5];

				// read stats from chat into gamer

				if (data[3].equals(Binding.INPUT_STDIN)) {

					if (data[1].equals(Binding.INPUT_STR)) {

						String s = GamerLanguage.scanner.nextLine();
						
						Variables.set(var, s);

					}
					
					else if (data[1].equals(Binding.INPUT_NUM)) {
						
						double d = GamerLanguage.scanner.nextDouble();
						
						Variables.set(var, d);
						
					}

				}

			}


			String ret = Binding.RETURN + " ";

			if (lineNoStrConst.startsWith(ret)) {

				Object val = Expressions.get(blockName, line, ret.length());

				return val;

			}


			if (lineNoStrConst.startsWith(Binding.EXIT)) {

				int code = 0;

				if (lineNoStrConst.contains(" ")) {

					try {

						code = Integer.parseInt(lineNoStrConst.split(" ")[1]);

					} catch (NumberFormatException e) {

					}

				}

				System.exit(code);

				return null;

			}


			l++;




		}

		return null;

	}

	public static int findNextOfSameScope(int curLine, String scope, List<String> block) {

		for (int i = curLine + 1; i < block.size(); i++) {

			if (block.get(i).startsWith(scope + "!")) {
				return i;

			}

		}

		return -1;

	}

	public static int findPrevOfSameScope(int curLine, String scope, List<String> block) {

		for (int i = curLine - 1; i >= 0; i--) {

			if (block.get(i).startsWith(scope + "!")) {
				return i;
			}

		}

		return -1;

	}

}
