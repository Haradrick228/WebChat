package ru.serov.springchat.WebChat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
