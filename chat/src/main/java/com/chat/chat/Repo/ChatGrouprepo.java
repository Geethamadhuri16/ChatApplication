package com.chat.chat.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.chat.Model.ChatGroup;

public interface ChatGrouprepo extends JpaRepository<ChatGroup, Long> {
	

}
