package vitua.kotler.ai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vitua.kotler.ai.dto.ChatDto;
import vitua.kotler.ai.dto.MessageDto;
import vitua.kotler.ai.entity.ChatEntity;
import vitua.kotler.ai.entity.MessageEntity;
import vitua.kotler.ai.mapper.ChatMapper;
import vitua.kotler.ai.mapper.MessageMapper;
import vitua.kotler.ai.repository.ChatRepository;
import vitua.kotler.ai.repository.MessageRepository;
import vitua.kotler.ai.service.ChatService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final MessageRepository messageRepository;

    private final ChatRepository chatRepository;

    private final ChatMapper chatMapper;

    private final MessageMapper messageMapper;

    @Override
    public ChatDto createChat(ChatDto chat) {
        ChatEntity chatEntity = chatMapper.dtoToEntity(chat);
        ChatEntity saved = chatRepository.save(chatEntity);
        return chatMapper.entityToDto(saved);
    }

    @Override
    public List<ChatDto> getAllChatsByUser(Long userId) {
        return chatRepository.findAll().stream()
                .filter(chat -> chat.getIdUser().equals(userId))
                .map(chatMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto sendMessage(MessageDto messageDto) {
        MessageEntity entity = MessageMapper.toEntity(messageDto);
        MessageEntity saved = messageRepository.save(entity);
        return MessageMapper.toDto(saved);
    }

    @Override
    public List<MessageDto> getMessagesByChat(Long chatId) {
        return messageRepository.findAll().stream()
                .filter(msg -> msg.getChatId().equals(chatId))
                .map(MessageMapper::toDto)
                .collect(Collectors.toList());
    }
}
