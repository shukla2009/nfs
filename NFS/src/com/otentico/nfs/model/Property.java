package com.otentico.nfs.model;

public class Property {
	private String key;
	private String value;

	public Property(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
}
