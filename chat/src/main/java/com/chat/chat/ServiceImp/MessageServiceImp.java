package com.chat.chat.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chat.chat.Repo.ChatGrouprepo;
import com.chat.chat.Model.ChatGroup;
import com.chat.chat.Model.Message;
import com.chat.chat.Model.User;
import com.chat.chat.Repo.MessageRepo;
import com.chat.chat.Repo.UserRepo;
import com.chat.chat.Service.MessageService;
@Service
public class MessageServiceImp implements MessageService {
	@Autowired
	private MessageRepo repo;
	
	@Autowired
	private ChatGrouprepo crepo;

	@Autowired
	private UserRepo urepo;
	
	@Override
	public ResponseEntity<String> sendMessage(Message m) {
		try {
			repo.save(m);
			return new ResponseEntity<>("sent",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<String> delMessage(Long id) {
		Message m=repo.findById(id).orElse(null);
		try {
			if(m!=null) {
				repo.delete(m);
				return new ResponseEntity<>("deleted",HttpStatus.OK);

			}else {
				return new ResponseEntity<>("Message is already deleted",HttpStatus.NO_CONTENT);

			}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<Message>> chat(Long senderId, Long ReceiverId) {
		User sender=urepo.findById(senderId).orElse(null);
		User receiver=urepo.findById(ReceiverId).orElse(null);
		
		try {
			List<Message> messages=repo.findBySenderAndReceiverOrderByIdAsc(sender, receiver);
			if(messages==null) {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

			}else {
				return new ResponseEntity<>(messages,HttpStatus.OK);

			}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<List<Message>> chatInGroup(Long gid) {
		ChatGroup c=crepo.findById(gid).orElse(null);
		try {
			if(c!=null) {
				List<Message> messages=c.getMessages();
				return new ResponseEntity<>(messages,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
				
			}
			
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
