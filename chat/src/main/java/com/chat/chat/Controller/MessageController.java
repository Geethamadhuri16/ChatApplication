package com.chat.chat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.Model.Message;
import com.chat.chat.Service.MessageService;

@RestController

@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendMessage(Message m){
		return service.sendMessage(m);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delMessage(Long id){
		return service.delMessage(id);
		
	}
	
	@GetMapping("/getchat/{senderId}/{receiverId}")
	public ResponseEntity<List<Message>> getPersonalChat(@PathVariable Long senderId,@PathVariable Long receiverId){
		return service.chat(senderId, receiverId);
	}
	
	@GetMapping("/groupChat/{gid}")
	public ResponseEntity<List<Message>> chatInGroup(@PathVariable  Long gid){
		return service.chatInGroup(gid);
	}
	
	

}
