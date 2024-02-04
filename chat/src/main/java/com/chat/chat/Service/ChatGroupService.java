package com.chat.chat.Service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.chat.chat.Model.ChatGroup;
import com.chat.chat.Model.User;

public interface ChatGroupService {
	public ResponseEntity<Long> createGroup(ChatGroup c);
	public ResponseEntity<String> dismantleGroup(Long id);
	public ResponseEntity<String> changeDesc(String desc,Long id);
	public ResponseEntity<String> changeGroupName(String name,Long id);

}
