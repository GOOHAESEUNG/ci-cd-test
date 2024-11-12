package groom.buddy.member;

import groom.buddy.area.Area;
import jakarta.persistence.*;
import lombok.Data;
import groom.buddy.character.Character;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long kakaoId;

    private String nickname;
    private String profileImageUrl;


    //캐릭터 매핑
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "character_id")
    private Character character = null; // 기본값을 null로 설정

    //영역 매핑
    @OneToMany(mappedBy = "member")
    private List<Area> areas = new ArrayList<>();


}