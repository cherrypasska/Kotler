package vitua.kotler.ai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * DTO для запроса аутентификации пользователя.
 * <p>
 * Содержит данные, необходимые для входа пользователя в систему — имя пользователя и пароль.
 */
@Data
public class SignInRequestDto {

    /**
     * Имя пользователя.
     */
    @Size(max = 50, message = "Имя пользователя должно содержать до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    /**
     * Пароль пользователя.
     */
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;
}

