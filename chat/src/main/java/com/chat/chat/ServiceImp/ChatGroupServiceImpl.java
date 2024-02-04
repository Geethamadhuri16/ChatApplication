package com.chat.chat.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chat.chat.Model.ChatGroup;
import com.chat.chat.Repo.ChatGrouprepo;
import com.chat.chat.Service.ChatGroupService;

@Service
public class ChatGroupServiceImpl implements ChatGroupService {
	@Autowired
	private ChatGrouprepo repo;

	@Override
	public ResponseEntity<Long> createGroup(ChatGroup c) {
		try {
			repo.save(c);
			return new ResponseEntity<>(c.getId(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		
	}

	@Override
	public ResponseEntity<String> dismantleGroup(Long id,Long uid) {
		ChatGroup c=repo.findById(id).orElse(null);
		boolean b=c.getAdmins().contains(uid);
		try {
			if(c!=null && b) {
				repo.delete(c);
				return new ResponseEntity<>("Deleted",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("No such group exists or u dont have access",HttpStatus.NOT_FOUND);
	
			}
			
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}

	@Override
	public ResponseEntity<String> changeDesc(String desc, Long id) {
		ChatGroup c=repo.findById(id).orElse(null);
		try {
			if(c!=null) {
				c.setDescription(desc);
				repo.save(c);
				return new ResponseEntity<>("Changed",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("No such group exists",HttpStatus.NOT_FOUND);
	
			}
			
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}

	@Override
	public ResponseEntity<String> changeGroupName(String name, Long id) {
		ChatGroup c=repo.findById(id).orElse(null);
		try {
			if(c!=null) {
				c.setGroupName(name);
				repo.save(c);
				return new ResponseEntity<>("Changed",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("No such group exists",HttpStatus.NOT_FOUND);
	
			}
			
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
	}
	

}
