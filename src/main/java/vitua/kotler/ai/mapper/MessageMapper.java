package vitua.kotler.ai.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vitua.kotler.ai.dtos.MessageDto;
import vitua.kotler.ai.entitys.MessageEntity;

@Component
@RequiredArgsConstructor
public class MessageMapper {
    public static MessageEntity toEntity(MessageDto messageDto) {
        return MessageEntity.builder()
                .messageText(messageDto.getMessageText())
                .messageType(messageDto.getMessageType())
                .chatId(messageDto.getChatId())
                .build();
    }

    public MessageDto toDto(MessageEntity saved) {
        return MessageDto.builder()
                .messageText(saved.getMessageText())
                .messageType(saved.getMessageType())
                .chatId(saved.getChatId())
                .id(saved.getId())
                .build();
    }
}
