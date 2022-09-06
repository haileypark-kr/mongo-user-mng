package com.example.mongousermng.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mongousermng.domain.user.RoleType;
import com.example.mongousermng.domain.user.User;
import com.example.mongousermng.dto.user.UserRoleUpdateDto;
import com.example.mongousermng.dto.user.UserSignupDto;
import com.example.mongousermng.exception.UserAlreadyExistsException;
import com.example.mongousermng.repository.user.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	public void signup(UserSignupDto userSignupDto) {
		if (!userRepository.existsByUserId(userSignupDto.getUserId())) {
			userRepository.save(
				User.builder()
					.userId(userSignupDto.getUserId())
					.userName(userSignupDto.getUserName())
					.encryptedPassword(bcryptPasswordEncoder.encode(userSignupDto.getPassword()))
					.role(RoleType.USER.name()) // 회원가입 시 기본 role은 USER
					.build());

		} else {
			throw new UserAlreadyExistsException(userSignupDto.getUserId());
		}

	}

	public void changeRole(UserRoleUpdateDto updateDto) {

		Optional<User> userOptional = userRepository.findByUserId(updateDto.getUserId());
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setRole(updateDto.getRole().name());

			userRepository.save(user);

		} else {
			throw new IllegalStateException("user not exists");
		}

	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

		Optional<User> userOptional = userRepository.findByUserId(userId);
		if (!userOptional.isPresent()) {
			throw new UsernameNotFoundException(userId);
		}

		User user = userOptional.get();

		return org.springframework.security.core.userdetails.User.builder()
			.username(user.getUserId())
			.password(user.getEncryptedPassword())
			.roles(user.getRole())
			.build();

	}
}
