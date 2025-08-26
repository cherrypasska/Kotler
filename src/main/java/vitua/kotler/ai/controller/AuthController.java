package vitua.kotler.ai.controller;

import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;
import vitua.kotler.ai.dto.JwtAuthenticationResponse;
import vitua.kotler.ai.dto.SignUpRequestDto;
import vitua.kotler.ai.service.AuthenticationService;
import vitua.kotler.ai.dto.SignInRequestDto;
import vitua.kotler.ai.dto.RefreshRequestDto;

/**
 * Контроллер для обработки операций аутентификации пользователей.
 * Предоставляет эндпоинты для регистрации, входа в систему и обновления токена.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    /**
     * Регистрирует нового пользователя на основе переданных данных.
     *
     * @param request DTO с информацией для регистрации пользователя
     * @return {@link JwtAuthenticationResponse} — объект, содержащий JWT access/refresh токены
     */
    @PostMapping("/reg")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequestDto request) {
        return authenticationService.signUp(request);
    }

    /**
     * Аутентифицирует пользователя на основе логина и пароля.
     *
     * @param request DTO с учетными данными пользователя
     * @return {@link JwtAuthenticationResponse} — объект с новыми JWT access/refresh токенами
     */
    @PostMapping("/login")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequestDto request) {
        return authenticationService.signIn(request);
    }

    /**
     * Обновляет access-токен по действующему refresh-токену.
     *
     * @param request DTO с refresh-токеном
     * @return {@link JwtAuthenticationResponse} — новый access/refresh токен
     */
    @PostMapping("/refresh")
    public JwtAuthenticationResponse refresh(@RequestBody @Valid RefreshRequestDto request) {
        return authenticationService.refresh(request);
    }
}