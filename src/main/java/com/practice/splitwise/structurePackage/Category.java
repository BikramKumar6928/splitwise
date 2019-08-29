package com.practice.splitwise.structurePackage;

public enum Category {
	FOOD("Food","food"),
	TRAVEL("Travel","travel"),
	HOUSE("House","house"),

	;


	Category(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}

	private String name;
	private String icon;

}
