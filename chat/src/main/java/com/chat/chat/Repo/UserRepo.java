package com.chat.chat.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.chat.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	public User findByEmail(String email);

}
