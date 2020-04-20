package com.test.context;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.test.model.UserDataModel;

public class Context {
	private UserDataModel userData;
	public static Map<String, String> tempValues = new LinkedHashMap<String, String>();

	public UserDataModel getUserData() {
		return userData;
	}

	public void setUserData(UserDataModel userData) {
		this.userData = userData;
	}

	public String getContextParam(String key) {
		return tempValues.get(key);
	}

	public void setContextParam(String key, String value) {
		tempValues.put(key, value);
	}
}
