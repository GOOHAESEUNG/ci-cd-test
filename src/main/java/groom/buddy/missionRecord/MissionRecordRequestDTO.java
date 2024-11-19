package groom.buddy.missionRecord;

import groom.buddy.mission.MissionResponseDTO;
import lombok.Data;

@Data
public class MissionRecordRequestDTO {

    private String content;
    private String feedback;
}
