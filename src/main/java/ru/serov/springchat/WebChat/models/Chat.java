package ru.serov.springchat.WebChat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.util.List;


@Entity
@Table(name = "chat")
public class Chat {
//    CREATE TABLE chat(
//            chat_id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,-- id чата--
//            name varchar(20) NOT NULL, -- Заголовок чата --
//    user_id INT NOT NULL,--id пользователя создавшего чат--
//    PRIMARY KEY (chat_id),
//    FOREIGN KEY (user_id) REFERENCES users(user_id) -- Внешний ключ к таблице users --
//            );

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chat_id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 1, max = 30, message = "Min size is 1, max size is 30")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "chat")
    private List<ChatParticipants> participants;

    @OneToMany(mappedBy = "chat")
    private List<Messages> messages;

    public Chat() {
    }

    public Chat(String name, User user, List<ChatParticipants> participants, List<Messages> messages) {
        this.name = name;
        this.user = user;
        this.participants = participants;
        this.messages = messages;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ChatParticipants> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ChatParticipants> participants) {
        this.participants = participants;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
