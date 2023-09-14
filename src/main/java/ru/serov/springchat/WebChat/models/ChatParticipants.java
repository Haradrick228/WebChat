package ru.serov.springchat.WebChat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "chat_participants")
public class ChatParticipants {

//    CREATE TABLE chat_participants(
//            chat_id INT NOT NULL, -- id группы чата --
//            user_id INT NOT NULL, -- Пользователи, которые учавствует в переписке чата --
//                    PRIMARY KEY (chat_id, user_id),
//    FOREIGN KEY (chat_id) REFERENCES chat(chat_id),
//    FOREIGN KEY (user_id) REFERENCES users(user_id)
//            );

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private int party_id;


    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ChatParticipants() {
    }

    public ChatParticipants(Chat chat, User user) {
        this.chat = chat;
        this.user = user;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}