package com.chat.chat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chat.Model.User;
import com.chat.chat.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String mail, @RequestParam String password) {
        return userService.login(mail, password);
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/groups")
    public ResponseEntity<List<Long>> getGroups(@RequestParam Long id) {
        return userService.getGroups(id);
    }

    @PostMapping("/add-to-group")
    public ResponseEntity<String> addToGroup(@RequestParam Long aid, @RequestParam Long uid, @RequestParam Long gid) {
        return userService.addToGroup(aid, uid, gid);
    }

    @PostMapping("/remove-from-group")
    public ResponseEntity<String> removeFromGroup(@RequestParam Long aid, @RequestParam Long uid, @RequestParam Long gid) {
        return userService.removeFromGroup(aid, uid, gid);
    }

    @PostMapping("/exit-from-group")
    public ResponseEntity<String> exitFromGroup(@RequestParam Long uid, @RequestParam Long gid) {
        return userService.exitFromGroup(uid, gid);
    }
}
