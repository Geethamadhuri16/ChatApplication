package com.chat.chat.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.chat.chat.Model.Message;

public interface MessageService {
	
	public ResponseEntity<String> sendMessage(Message m);
	public ResponseEntity<String> delMessage(Long id);
	public ResponseEntity<List<Message>> chat(Long senderId,Long ReceiverId);
	public ResponseEntity<List<Message>> chatInGroup(Long gid);

}
