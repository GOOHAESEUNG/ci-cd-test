package groom.buddy.member;

import groom.buddy.kakao.KakaoService;
import groom.buddy.kakao.KakaoUserInfoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private KakaoService kakaoService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/kakao")
    public ResponseEntity<String> kakaoLogin(@RequestParam("code") String code) {
        // 1. Access Token 받아오기
        String accessToken = kakaoService.getAccessToken(code);

        // 2. 사용자 정보 받아오기
        KakaoUserInfoResponseDto kakaoUserInfo = kakaoService.getUserInfo(accessToken);

        // 3. 사용자 정보 저장
        memberService.saveOrUpdateMember(kakaoUserInfo);

        return ResponseEntity.ok("로그인 및 저장 성공");
    }
}