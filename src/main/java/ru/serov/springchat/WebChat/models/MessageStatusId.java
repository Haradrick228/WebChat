package ru.serov.springchat.WebChat.models;

import java.io.Serializable;
import java.util.Objects;

public class MessageStatusId implements Serializable {
    private int message;
    private int user;

    public MessageStatusId(int message, int user) {
        this.message = message;
        this.user = user;
    }

    public MessageStatusId() {
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageStatusId that = (MessageStatusId) o;
        return message == that.message && user == that.user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, user);
    }
    // Геттеры и сеттеры для полей message и user

    // Реализация equals и hashCode
}

