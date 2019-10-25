package my.home.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import my.home.shop.models.ChatMessage;

public interface ChatMessagesRepository extends JpaRepository<ChatMessage, Long> {
}
