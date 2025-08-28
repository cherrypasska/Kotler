package vitua.kotler.ai.service;

import vitua.kotler.ai.dto.ChatDto;
import vitua.kotler.ai.dto.MessageDto;
import vitua.kotler.ai.entity.ChatEntity;
import vitua.kotler.ai.repository.MessageRepository;

import java.util.List;
import java.util.Optional;

public interface ChatService {

    ChatDto createChat(ChatDto chat);

    List<ChatDto> getAllChatsByUser(Long userId);

    MessageDto sendMessage(MessageDto messageDto);

    List<MessageDto> getMessagesByChat(Long chatId);

    void validateChatOwnership(Long chatId, Long userId);

    Optional<ChatEntity> getChatById(Long chatId);
}
