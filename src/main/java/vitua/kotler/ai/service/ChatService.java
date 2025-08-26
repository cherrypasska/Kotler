package vitua.kotler.ai.service;

import vitua.kotler.ai.dto.ChatDto;
import vitua.kotler.ai.dto.MessageDto;
import vitua.kotler.ai.repository.MessageRepository;

import java.util.List;

public interface ChatService {

    ChatDto createChat(ChatDto chat);

    List<ChatDto> getAllChatsByUser(Long userId);

    MessageDto sendMessage(MessageDto messageDto);

    List<MessageDto> getMessagesByChat(Long chatId);
}
