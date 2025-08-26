package vitua.kotler.ai.dto;

import lombok.*;

/**
 * DTO для ответа аутентификации, содержащий JWT токен доступа.
 * <p>
 * Используется для передачи клиенту JWT после успешной авторизации или регистрации.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    /**
     * JWT токен доступа, который клиент должен использовать для авторизации последующих запросов.
     */
    private String token;

    /**
     * refresh JWT токен доступа, который клиент должен использовать для авторизации последующих запросов.
     */
    private String refreshToken;
}
