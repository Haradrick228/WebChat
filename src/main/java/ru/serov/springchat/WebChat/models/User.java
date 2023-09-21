package ru.serov.springchat.WebChat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;


import java.util.List;

@Entity
@Table(name = "users")
public class User {

//    CREATE TABLE users(
//            user_id INT GENERATED BY DEFAULT AS IDENTITY NOT NULL,-- Номер пользователя --
//            username VARCHAR(30) NOT NULL UNIQUE,-- Логин пользователя --
//    password varchar(30) NOT NULL, -- Пароль пользователя --
//    PRIMARY KEY (user_id)
//);
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Column(name = "username", unique = true)
    @Size(min = 1, max = 30, message = "Username must have 1-30 character")
    @NotBlank
    private String username;

    @Column(name = "password")
    @Size(min = 1, max = 30, message = "Password must have 1-30 character")
    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Chat> chats;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
