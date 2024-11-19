package groom.buddy.member;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import groom.buddy.area.Area;
import groom.buddy.checkList.CheckList;
import groom.buddy.mission.Mission;
import groom.buddy.missionRecord.MissionRecord;
import jakarta.persistence.*;
import lombok.Data;
import groom.buddy.character.Character;
import lombok.ToString;

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

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    @ToString.Exclude // 순환 참조 방지
    @JsonBackReference // 순환 참조 방지
    private Character character;

    @OneToMany(mappedBy = "member")
    @JsonManagedReference // 직렬화 순환 참조 방지
    private List<Area> areas = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @JsonManagedReference // 직렬화 순환 참조 방지
    private List<CheckList> checkLists = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<MissionRecord> missionRecords = new ArrayList<>();
}
