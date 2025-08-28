package vitua.kotler.ai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vitua.kotler.ai.dto.ChatDto;
import vitua.kotler.ai.dto.MessageDto;
import vitua.kotler.ai.entity.ChatEntity;
import vitua.kotler.ai.entity.MessageEntity;
import vitua.kotler.ai.controller.UnauthorizedException;
import vitua.kotler.ai.mapper.ChatMapper;
import vitua.kotler.ai.mapper.MessageMapper;
import vitua.kotler.ai.repository.ChatRepository;
import vitua.kotler.ai.repository.MessageRepository;
import vitua.kotler.ai.service.ChatService;

import java.util.List;
import java.util.Optional;
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
        return chatRepository.findById(userId).stream()
                .map(chatMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto sendMessage(MessageDto messageDto) {
        MessageEntity entity = messageMapper.toEntity(messageDto);
        MessageEntity saved = messageRepository.save(entity);
        return messageMapper.toDto(saved);
    }

    @Override
    public List<MessageDto> getMessagesByChat(Long chatId) {
        return messageRepository.findById(chatId).stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void validateChatOwnership(Long chatId, Long userId) {
        Optional<ChatEntity> chat = chatRepository.findById(chatId);
        if (chat.isEmpty()) {
            throw new UnauthorizedException("Чат не найден");
        }
        if (!chat.get().getIdUser().equals(userId)) {
            throw new UnauthorizedException("У вас нет доступа к этому чату");
        }
    }

    @Override
    public Optional<ChatEntity> getChatById(Long chatId) {
        return chatRepository.findById(chatId);
    }
}