package com.example.mongousermng.domain.user;

public enum RoleType {

	USER,
	ADMIN,
	;

	public static RoleType findByName(String name) {
		for (RoleType type : RoleType.values()) {
			if (type.name().equals(name)) {
				return type;
			}
		}

		return USER;
	}
}
