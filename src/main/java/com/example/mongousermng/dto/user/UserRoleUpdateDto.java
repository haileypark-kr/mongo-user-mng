package com.example.mongousermng.dto.user;

import com.example.mongousermng.domain.user.RoleType;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRoleUpdateDto {
	private String userId;
	private RoleType role;

}
