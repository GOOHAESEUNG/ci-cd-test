package groom.buddy.member;

import groom.buddy.kakao.KakaoUserInfoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/join-test")
    public ResponseEntity<?> joinTest(@RequestBody KakaoUserInfoResponseDto kakaoUserInfo) {
        Member member = memberService.saveOrUpdateMember(kakaoUserInfo);
        return ResponseEntity.ok(member);
    }
}