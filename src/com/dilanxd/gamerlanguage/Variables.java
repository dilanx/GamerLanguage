package com.dilanxd.gamerlanguage;

import java.util.HashMap;
import java.util.Map;

public class Variables {
	
	private static Map<String, Object> vars = new HashMap<>();
	
	public static boolean has(String key) {
		return vars.containsKey(key);
	}
	
	public static Object get(String key) {
		return vars.get(key);
	}
	
	public static void set(String key, Object val) {
		vars.put(key, val);
	}
	
}
