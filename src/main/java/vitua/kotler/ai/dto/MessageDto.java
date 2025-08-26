package vitua.kotler.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vitua.kotler.ai.entity.enums.MessageType;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private Long id;

    private Long chatId;

    private MessageType messageType;

    private String messageText;
}
