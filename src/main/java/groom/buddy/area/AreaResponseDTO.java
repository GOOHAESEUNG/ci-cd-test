package groom.buddy.area;

import groom.buddy.member.MemberInfoDTO;
import lombok.Data;

@Data
public class AreaResponseDTO {
    private Long id;
    private String areaType;
    private MemberInfoDTO member; // Member 관련 정보 포함

}

