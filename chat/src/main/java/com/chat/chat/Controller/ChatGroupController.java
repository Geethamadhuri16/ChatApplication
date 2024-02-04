package com.chat.chat.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.Model.ChatGroup;
import com.chat.chat.Service.ChatGroupService;

@RestController
@RequestMapping("/chat")

public class ChatGroupController {
	
	@Autowired
	private ChatGroupService service;
	
	@PostMapping("/createGroup")
	public ResponseEntity<Long> createGroup(@RequestBody ChatGroup c){
		return service.createGroup(c)	;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> dismantleGroup(Long id){
		return service.dismantleGroup(id);
	}
	
	@RequestMapping("/changeDesc/{desc}/{id}")
	public ResponseEntity<String> changeDesc(@PathVariable ("desc")String desc,@PathVariable ("id") Long id){
		return service.changeDesc(desc, id);
		
	}
	
	@RequestMapping("/changeName/{name}/{id}")
	public ResponseEntity<String> changeGroupName(@PathVariable ("name") String name,@PathVariable ("id") Long id){
		return service.changeGroupName(name, id);
		
	}
	
	

}
