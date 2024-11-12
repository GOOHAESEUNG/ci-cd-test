package groom.buddy.character;

import groom.buddy.member.Member;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CharacterType characterType; // 캐릭터 타입

    private String characterName; // 캐릭터 이름

    private int level = 1; // 기본 레벨

    @OneToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore  // 순환 참조 방지
    private Member member;


    public enum CharacterType {
        CHICK,
        CAT,
        RABBIT,
        BEAR
    }
}
