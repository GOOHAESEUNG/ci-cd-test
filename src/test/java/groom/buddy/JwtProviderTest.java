package groom.buddy;

import static org.junit.jupiter.api.Assertions.*;

import groom.buddy.member.JwtProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JwtProviderTest {

    private JwtProvider jwtProvider;
    private Long testKakaoId = 123456L; // 테스트용 사용자 ID

    @BeforeEach
    public void setUp() {
        jwtProvider = new JwtProvider(); // JwtProvider 인스턴스 생성
    }

    @Test
    public void testCreateAndValidateAccessToken() {
        // Access Token 생성
        String accessToken = jwtProvider.createAccessToken(testKakaoId);
        assertNotNull(accessToken, "Access Token이 생성되어야 합니다.");

        // Access Token 검증
        boolean isValid = jwtProvider.validateToken(accessToken);
        assertTrue(isValid, "Access Token이 유효해야 합니다.");

        // Access Token에서 사용자 ID 추출
        Long extractedId = jwtProvider.getUserIdFromToken(accessToken);
        assertEquals(testKakaoId, extractedId, "Access Token에서 올바른 사용자 ID를 추출해야 합니다.");
    }

    @Test
    public void testCreateAndValidateRefreshToken() {
        // Refresh Token 생성
        String refreshToken = jwtProvider.createRefreshToken(testKakaoId);
        assertNotNull(refreshToken, "Refresh Token이 생성되어야 합니다.");

        // Refresh Token 검증
        boolean isValid = jwtProvider.validateToken(refreshToken);
        assertTrue(isValid, "Refresh Token이 유효해야 합니다.");

        // Refresh Token에서 사용자 ID 추출
        Long extractedId = jwtProvider.getUserIdFromToken(refreshToken);
        assertEquals(testKakaoId, extractedId, "Refresh Token에서 올바른 사용자 ID를 추출해야 합니다.");
    }

    @Test
    public void testInvalidToken() {
        // 유효하지 않은 토큰 검증
        String invalidToken = "invalidToken";
        boolean isValid = jwtProvider.validateToken(invalidToken);
        assertFalse(isValid, "잘못된 토큰은 유효하지 않아야 합니다.");
    }
}