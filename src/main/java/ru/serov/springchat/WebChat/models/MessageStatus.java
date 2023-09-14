package ru.serov.springchat.WebChat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "message_status")
@IdClass(MessageStatusId.class)
public class MessageStatus {
//    CREATE TABLE message_status(
//            message_id INT NOT NULL , -- id сообщения --
//            user_id INT NOT NULL, -- id пользователя --
//            is_read BOOLEAN NOT NULL, -- Прочитано ли сообщение --
//            PRIMARY KEY (message_id, user_id),
//    FOREIGN KEY (message_id) REFERENCES messages(message_id),
//    FOREIGN KEY (user_id) REFERENCES users(user_id)
//            );

    @Id
    @ManyToOne
    @JoinColumn(name = "massage_id")
    @NotEmpty
    private Messages message;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotEmpty
    private User user;

    @Column(name = "is_read")
    @NotEmpty
    private boolean is_read;

    public MessageStatus() {
    }

    public MessageStatus(Messages messages, User user, boolean is_read) {
        this.message = messages;
        this.user = user;
        this.is_read = is_read;
    }

    public Messages getMessages() {
        return message;
    }
    public void setMessages(Messages messages) {
        this.message = messages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }
}
