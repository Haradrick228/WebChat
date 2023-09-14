package ru.serov.springchat.WebChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.serov.springchat.WebChat.models.Messages;
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
}
