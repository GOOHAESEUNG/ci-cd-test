package groom.buddy.character;

import groom.buddy.member.Member;
import groom.buddy.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {

    private final MemberService memberService;
    private final CharacterService characterService;

    @PostMapping("/create")
    public ResponseEntity<?> createCharacter(
            @RequestHeader("kakaoId") Long kakaoId,
            @RequestParam("characterType") Character.CharacterType characterType,
            @RequestParam("characterName") String characterName) {

        // 1. kakaoId를 통해 멤버 조회
        Member member = memberService.findByKakaoId(kakaoId);
        if (member == null) {
            return new ResponseEntity<>("회원이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        // 2. 캐릭터 생성 및 설정
        Character character = characterService.createCharacter(characterType, characterName);
        character.setMember(member);
        member.setCharacter(character);

        // 3. 멤버 정보 업데이트
        memberService.save(member);

        return ResponseEntity.ok(character);
    }
}