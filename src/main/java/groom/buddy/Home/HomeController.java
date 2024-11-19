package groom.buddy.Home;

import groom.buddy.area.AreaService;
import groom.buddy.character.CharacterResponseDTOForMission;
import groom.buddy.member.Member;
import groom.buddy.member.MemberInfoDTO;
import groom.buddy.member.MemberService;
import groom.buddy.mission.Mission;
import groom.buddy.mission.MissionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final AreaService areaService;

    @GetMapping("")
    public ResponseEntity<?> home(@RequestHeader("kakaoId") Long kakaoId) {
        // 1. 멤버 조회
        Member member = memberService.findByKakaoId(kakaoId);
        if (member == null) {
            return new ResponseEntity<>("회원이 존재하지 않습니다.", HttpStatus.NOT_FOUND);
        }

        // 2. 유저 닉네임 가져오기
        String memberName = member.getNickname();

        // 3. 현재 진행 중인 영역의 미션 수행률 가져오기
        Double missionProgressPercentage = areaService.progressPercentage(kakaoId);

        // 4. 유저 캐릭터 정보 가져오기
        CharacterResponseDTOForMission characterDTO = null;
        if (member.getCharacter() != null) {
            characterDTO = new CharacterResponseDTOForMission();
            characterDTO.setId(member.getCharacter().getId());
            characterDTO.setCharacterType(member.getCharacter().getCharacterType().toString());
            characterDTO.setCharacterName(member.getCharacter().getCharacterName());
            characterDTO.setLevel(member.getCharacter().getLevel());
        }

        // 5. 진행 중인 첫 번째 미션 가져오기
        Mission firstMission = member.getMissions().stream()
                .filter(mission -> !mission.isCompleted())
                .findFirst()
                .orElse(null);

        MissionResponseDTO missionDTO = null;
        if (firstMission != null) {
            missionDTO = new MissionResponseDTO();
            missionDTO.setMissionName(firstMission.getMission_name());
            missionDTO.setAreaName(firstMission.getArea().getAreaType().name());
            missionDTO.setCompleted(firstMission.isCompleted());
        }

        // 6. 응답 DTO 생성
        HomeResponseDTO responseDTO = new HomeResponseDTO();
        responseDTO.setMember_nickname(memberName);
        responseDTO.setMissionProPer(missionProgressPercentage);
        responseDTO.setCharacter(characterDTO);
        responseDTO.setMission(missionDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/mypage")
    public ResponseEntity<?> mypage(@RequestHeader("kakaoId") Long kakaoId) {
        Member member = memberService.findByKakaoId(kakaoId);

        MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
        memberInfoDTO.setNickname(member.getNickname());
        memberInfoDTO.setKakaoId(kakaoId);
        memberInfoDTO.setId(kakaoId);

        return ResponseEntity.ok(memberInfoDTO);
    }
}
