package com.llce.gmis.entity;


public enum UserRole {

	STUDENT(0),
	TRACHER(1);
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	private UserRole(int v) {
		this.value = v;
	}
	
	public static UserRole valueOf(int x) {
		switch (x) {
		case 0: return STUDENT;
		case 1: return TRACHER;
	
		}
		throw new RuntimeException("Invalid UserRole value.");
	}
}
