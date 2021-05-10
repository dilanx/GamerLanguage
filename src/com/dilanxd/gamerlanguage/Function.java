package com.dilanxd.gamerlanguage;

import java.util.List;

public class Function {
	
	private List<String> code;
	
	private String[] argumentVars;

	public Function(List<String> code, String[] argumentVars) {
		this.code = code;
		this.argumentVars = argumentVars;
	}

	public List<String> getCode() {
		return code;
	}

	public String[] getArgumentVars() {
		return argumentVars;
	}
	
}
