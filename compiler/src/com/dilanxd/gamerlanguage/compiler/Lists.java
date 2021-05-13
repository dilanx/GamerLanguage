package com.dilanxd.gamerlanguage.compiler;

import java.util.List;

public class Lists {
	
	public static int index(List<Object> list, String blockName, String pos) {
		
		if (Variables.has(blockName + ":" + pos)) {
			
			return Integer.parseInt(Double.toString((double) Variables.get(blockName + ":" + pos)).split("\\.")[0]);
			
		}
		
		if (pos.equals(Binding.LIST_LOC_END)) {
			
			return -1;
			
		}
		
		try {
			
			return Integer.parseInt(pos);
			
		} catch (NumberFormatException ex) {
			
			return 0;
			
		}
		
	}
	
}
