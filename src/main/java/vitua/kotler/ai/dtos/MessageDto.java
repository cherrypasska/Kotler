package vitua.kotler.ai.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vitua.kotler.ai.entitys.enums.MessageType;

/**
 * DTO для представления сообщения в чате.
 * Содержит информацию о сообщении, его типе и принадлежности к чату.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO для представления сообщения в чате")
public class MessageDto {

    @Schema(
            description = "Уникальный идентификатор сообщения",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "ID чата, к которому принадлежит сообщение",
            example = "5",
            required = true
    )
    private Long chatId;

    @Schema(
            description = "Тип сообщения",
            example = "TEXT",
            allowableValues = {"TEXT", "IMAGE", "FILE", "SYSTEM"},
            defaultValue = "TEXT"
    )
    private MessageType messageType;

    @Schema(
            description = "Текст сообщения",
            example = "Привет! Как дела?",
            required = true,
            maxLength = 1000
    )
    private String messageText;
}