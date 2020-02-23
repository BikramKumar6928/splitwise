package com.practice.splitwise.beans.enums;

import java.io.Serializable;

public enum Category  implements Serializable {
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
