package groom.buddy.missionRecord;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import groom.buddy.character.CharacterResponseDTO;
import groom.buddy.character.CharacterResponseDTOForMission;
import groom.buddy.member.MemberInfoDTO;
import groom.buddy.mission.MissionResponseDTO;
import lombok.Data;

@Data
public class MissionRecordResponseDTO {

    private Long id;
    private String content;
    private String feedback;

    //미션에 매핑되어있는 영역의 미션들이 모두 완수 되었는지에 대한 여부
    private boolean allCompleted;

    //미션 정보
    @JsonManagedReference
    private MissionResponseDTO missionResponseDTO;

    private MemberInfoDTO memberInfoDTO;

    private CharacterResponseDTOForMission characterResponseDTOForMission;
}
