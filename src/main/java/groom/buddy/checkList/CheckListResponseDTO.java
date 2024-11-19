package groom.buddy.checkList;

import groom.buddy.area.AreaInfoDTO;
import groom.buddy.member.MemberInfoDTO;
import lombok.Data;

@Data
public class CheckListResponseDTO {
    private Long id;
    private int fistQ;
    private int secondQ;
    private int thirdQ;
    private int fourthQ;
    private int fifthQ;
    private int sixthQ;
    private int seventhQ;
    private int eighthQ;
    private AreaInfoDTO area;
    private MemberInfoDTO member;
}
