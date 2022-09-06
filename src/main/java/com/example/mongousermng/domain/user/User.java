package com.example.mongousermng.domain.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "users")
public class User implements Serializable {
	private static final long serialVersionUID = -7724037488092239003L;

	@Id
	private String id;

	@NotBlank
	@Size(max = 20)
	private String userId; // 사용자 ID

	@NotBlank
	@Size(max = 20)
	private String userName; // 사용자 이름

	@NotBlank
	private String encryptedPassword; // 암호화된 비밀번호

	private String role;

}
