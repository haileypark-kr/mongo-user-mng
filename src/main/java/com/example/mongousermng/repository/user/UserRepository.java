package com.example.mongousermng.repository.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.mongousermng.domain.user.User;

public interface UserRepository extends MongoRepository<User, String> {

	Optional<User> findByUserId(String userId);

	Boolean existsByUserId(String userId);
}
