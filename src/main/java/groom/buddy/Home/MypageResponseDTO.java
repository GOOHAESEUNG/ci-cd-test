package groom.buddy.Home;

import groom.buddy.member.MemberInfoDTO;
import lombok.Data;

@Data
public class MypageResponseDTO {
    private MemberInfoDTO member;
    private String email;
}
