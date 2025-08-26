package vitua.kotler.ai.service;

import vitua.kotler.ai.dto.JwtAuthenticationResponse;
import vitua.kotler.ai.dto.RefreshRequestDto;
import vitua.kotler.ai.dto.SignInRequestDto;
import vitua.kotler.ai.dto.SignUpRequestDto;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequestDto request);

    JwtAuthenticationResponse signIn(SignInRequestDto request);

    JwtAuthenticationResponse refresh(RefreshRequestDto request);
}
