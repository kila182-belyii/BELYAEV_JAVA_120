package my.home.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import my.home.shop.models.ChatMessage;
import my.home.shop.repositories.ChatMessagesRepository;

@Service
public class ChatMessageServiceImp implements ChatMessageService {

    @Autowired
    private ChatMessagesRepository chatMessagesRepository;

    @Override
    public ChatMessage saveChatMessage(ChatMessage chatMessage) {
        return chatMessagesRepository.save(chatMessage);
    }
}
