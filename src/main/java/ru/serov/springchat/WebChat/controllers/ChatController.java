package ru.serov.springchat.WebChat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.Validate;
import ru.serov.springchat.WebChat.models.Chat;
import ru.serov.springchat.WebChat.models.User;
import ru.serov.springchat.WebChat.service.ChatService;


@Controller
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @GetMapping("/hello")
    public String testVoid(){

        System.out.println("hello");
        chatService.addInfoToChat();
        return "hello";
    }



}
