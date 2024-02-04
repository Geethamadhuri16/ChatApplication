package com.chat.chat.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chat.chat.Model.Message;
import com.chat.chat.Model.User;

public interface MessageRepo extends JpaRepository<Message, Long> {

    List<Message> findBySenderAndReceiverOrderByIdAsc(User sender, User receiver);
}
