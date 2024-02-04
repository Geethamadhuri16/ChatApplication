package com.chat.chat.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.chat.chat.Model.User;

public interface UserService {
	public ResponseEntity<Boolean> login(String mail,String password);
	public ResponseEntity<Long> register(User u);
	public ResponseEntity<List<Long>> getGroups(Long id);
	public ResponseEntity<String> addToGroup(Long aid,Long uid,Long gid);
	public ResponseEntity<String> removeFromGroup(Long aid,Long uid,Long gid);
	public ResponseEntity<String> exitFromGroup(Long uid,Long gid);
	

}
