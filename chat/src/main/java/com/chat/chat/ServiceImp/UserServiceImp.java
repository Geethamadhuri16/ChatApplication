package com.chat.chat.ServiceImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chat.chat.Model.ChatGroup;
import com.chat.chat.Model.User;
import com.chat.chat.Repo.ChatGrouprepo;
import com.chat.chat.Repo.UserRepo;
import com.chat.chat.Service.UserService;
@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepo repo;
	@Autowired
	private ChatGrouprepo crepo;
	//login

	@Override
	public ResponseEntity<Boolean> login(String mail, String password) {
		User u=repo.findByEmail(mail);
		System.out.println(u);
		try {
			if(u!=null) {
				if(u.getPassword().equals(password)) {
					return new ResponseEntity<>(true,HttpStatus.OK);
				}else {
					return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
					
				}
				
				
			}else {
				return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e){
			return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//register

	@Override
	public ResponseEntity<Long> register(User u) {
		try {
			repo.save(u);
			return new ResponseEntity<>(u.getId(),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//get all groups

	@Override
	public ResponseEntity<List<Long>> getGroups(Long id) {
		User u=repo.findById(id).orElse(null);
		try {
			if(u!=null) {
				return new ResponseEntity<>(u.getChatgroups(),HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//add to group

	@Override
	public ResponseEntity<String> addToGroup(Long aid,Long uid, Long gid) {
		User u=repo.findById(uid).orElse(null);
		ChatGroup c=crepo.findById(gid).orElse(null);
		boolean isAdmin=c.getAdmins().contains(aid);
		try {
			if(u!=null && c!=null && isAdmin) {
				List<Long> gids=u.getChatgroups();
				gids.add(gid);
				u.setChatgroups(gids);
				repo.save(u);
			//	c.addMember(u);
				Set<User> members=c.getMembers();
				members.add(u);
				crepo.save(c);
				
				return new ResponseEntity<>("added",HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//removefromgrp

	@Override
	public ResponseEntity<String> removeFromGroup(Long aid,Long uid, Long gid) {
		User u=repo.findById(uid).orElse(null);
		ChatGroup c=crepo.findById(gid).orElse(null);
		boolean isAdmin=c.getAdmins().contains(aid);
		try {
			if(u!=null && c!=null && isAdmin) {
				List<Long> gids=u.getChatgroups();
				gids.remove(gid);
				u.setChatgroups(gids);
				repo.save(u);
				//c.removeMember(u);
				Set<User> members=c.getMembers();
				members.remove(u);
				crepo.save(c);
				return new ResponseEntity<>("removed",HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> exitFromGroup(Long uid, Long gid) {
		User u=repo.findById(uid).orElse(null);
		ChatGroup c=crepo.findById(gid).orElse(null);
		try {
			if(u!=null && c!=null) {
				List<Long> gids=u.getChatgroups();
				gids.remove(gid);
				u.setChatgroups(gids);
				repo.save(u);
				//c.removeMember(u);
				Set<User> members=c.getMembers();
				members.remove(u);
				crepo.save(c);
				return new ResponseEntity<>("left",HttpStatus.OK);
				
			}else {
				return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

	
	

}
