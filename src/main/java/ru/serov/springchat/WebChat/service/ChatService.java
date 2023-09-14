package ru.serov.springchat.WebChat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.serov.springchat.WebChat.models.*;
import ru.serov.springchat.WebChat.repositories.*;


@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatParticipantsRepository chatParticipantsRepository;
    private final MessagesRepository messagesRepository;
    private final MessageStatusRepository messageStatusRepository;
    private final UserRepository userRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository, ChatParticipantsRepository chatParticipantsRepository, MessagesRepository messagesRepository,
                       MessageStatusRepository messageStatusRepository,
                       UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.chatParticipantsRepository = chatParticipantsRepository;
        this.messagesRepository = messagesRepository;
        this.messageStatusRepository = messageStatusRepository;
        this.userRepository = userRepository;
    }

    public void addInfoToChat(){
        User user = new User();
        user.setUsername("exampleUser");
        user.setPassword("examplePassword");
        userRepository.save(user);

        Chat chat = new Chat();
        chat.setName("exampleChat");
        chat.setUser(user);
        chatRepository.save(chat);

        ChatParticipants chatParticipants = new ChatParticipants();
        chatParticipants.setChat(chat);
        chatParticipants.setUser(user);
        chatParticipantsRepository.save(chatParticipants);

        Messages messages = new Messages();
        messages.setChat(chat);
        messages.setContext("Some context");
        messages.setUser(user);
        messagesRepository.save(messages);

        MessageStatus messageStatus = new MessageStatus();
        messageStatus.setMessages(messages);
        messageStatus.setUser(user);
        messageStatus.setIs_read(true);
        messageStatusRepository.save(messageStatus);
    }
}


