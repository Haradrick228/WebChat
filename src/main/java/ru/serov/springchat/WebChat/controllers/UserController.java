package ru.serov.springchat.WebChat.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.serov.springchat.WebChat.models.User;
import ru.serov.springchat.WebChat.service.ChatService;

import java.util.List;

@Controller
public class UserController {

    private final ChatService chatService;

    @Autowired
    public UserController(ChatService chatService) {
        this.chatService = chatService;
    }

    @ResponseBody
    @GetMapping("/api/user")
    public List<User> getUser(){
        return chatService.getUser(); //Jackson конвертирует объекты в json
    }
}
