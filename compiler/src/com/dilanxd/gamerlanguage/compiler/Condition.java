package com.dilanxd.gamerlanguage.compiler;

public class Condition {


	// update start depending on how many words until condition starts
	public static boolean checkIf(String blockName, String line, int start) {

		String[] data = line.split(" ");

		int condCheck = start + 1;

		if (data[condCheck].equals(Binding.NOT)) {

			condCheck++;

		}

		boolean ans = preCheckIf(blockName, line, data, start, condCheck);
		
		if (condCheck == start + 2) return !ans;
		return ans;

	}

	private static boolean preCheckIf(String blockName, String line, String[] data, int condCheckStart, int condCheck) {

		
		Object left = Variables.get(blockName + ":" + data[condCheckStart]);
		
		if (data[condCheck].equals(Binding.COND_BOOL)) {


			String cond = " " + Binding.COND_BOOL + " ";
			Object right = Expressions.get(blockName, line, line.split(cond)[0].length() + cond.length());	
			
			return ((boolean) left) == ((boolean) right);

		}

		else if (data[condCheck].equals(Binding.COND_NUM)) {

			String cond = " " + Binding.COND_NUM + " ";
			

			if (data[condCheck + 1].equals(Binding.COND_NUM_E)) {

				cond += Binding.COND_NUM_E + " ";
				Object right = Expressions.get(blockName, line, conditionExpression(line, cond));

				return ((double) left) == ((double) right);

			}

			if (data[condCheck + 1].equals(Binding.COND_NUM_LT)) {

				cond += Binding.COND_NUM_LT + " ";
				Object right = Expressions.get(blockName, line, conditionExpression(line, cond));
				
				return ((double) left) < ((double) right);

			}
			
			if (data[condCheck + 1].equals(Binding.COND_NUM_GT)) {

				cond += Binding.COND_NUM_GT + " ";
				Object right = Expressions.get(blockName, line, conditionExpression(line, cond));

				return ((double) left) > ((double) right);

			}

		}
		
		else if (data[condCheck].equals(Binding.COND_STR)) {
			
			String cond = " " + Binding.COND_STR + " ";
			Object right = Expressions.get(blockName, line, line.split(cond)[0].length() + cond.length());	

			return ((String) left).equals((String) right);
			
		}
		
		return false;
		
	}

	public static int conditionExpression(String line, String cond) {

		return line.split(cond)[0].length() + cond.length();

	}

}
