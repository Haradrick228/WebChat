package ru.serov.springchat.WebChat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.serov.springchat.WebChat.models.ChatParticipants;
@Repository
public interface ChatParticipantsRepository extends JpaRepository<ChatParticipants, Integer> {
}
