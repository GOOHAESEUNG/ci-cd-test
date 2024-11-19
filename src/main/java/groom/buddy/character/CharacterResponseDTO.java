package groom.buddy.character;

import groom.buddy.member.MemberInfoDTO;
import lombok.Data;

@Data
public class CharacterResponseDTO {
    private Long id;
    private String characterType;
    private String characterName;
    private int level;
    private MemberInfoDTO member;
}
