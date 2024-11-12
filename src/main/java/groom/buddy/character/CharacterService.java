package groom.buddy.character;

import groom.buddy.member.Member;
import groom.buddy.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final MemberRepository memberRepository;

    @Transactional
    // 캐릭터 생성
    public Character createCharacter(Character.CharacterType characterType, String characterName) {

        // 새로운 캐릭터 생성 및 설정
        Character character = new Character();
        character.setCharacterType(characterType);
        character.setCharacterName(characterName);
        character.setLevel(1);

        // 캐릭터 저장 후 멤버에 설정
        characterRepository.save(character);

        return character;
    }
    /**
     * 캐릭터의 레벨을 증가시키는 메서드
     */
//    @Transactional
//    public Character levelUpCharacter(Member member) {
//        Character character = characterRepository.findByMember(member)
//                .orElseThrow(() -> new IllegalArgumentException("해당 유저의 캐릭터가 존재하지 않습니다."));
//
//        character.setLevel(character.getLevel() + 1);
//        return characterRepository.save(character);
//    }
}