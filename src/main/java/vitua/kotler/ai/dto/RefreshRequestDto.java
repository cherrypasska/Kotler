package vitua.kotler.ai.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO для запроса обновления токена.
 */
@Data
public class RefreshRequestDto {

    /**
     * Refresh токен для получения нового access токена
     */
    @NotBlank(message = "Refresh токен не может быть пустым")
    private String refreshToken;
}