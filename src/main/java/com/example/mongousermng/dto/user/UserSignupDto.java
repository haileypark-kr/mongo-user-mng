package com.example.mongousermng.dto.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserSignupDto {
	private String userId;
	private String userName;
	private String password;

}
