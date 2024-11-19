package groom.buddy.checkList;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import groom.buddy.area.Area;
import groom.buddy.member.Member;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "check_lists")
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference // 순환 참조 방지
    private Member member;

    @OneToOne
    @JoinColumn(name = "area_id")
    @JsonBackReference // 순환 참조 방지
    private Area area;

    private int fistQ;
    private int secondQ;
    private int thirdQ;
    private int fourthQ;
    private int fifthQ;
    private int sixthQ;
    private int seventhQ;
    private int eighthQ;
}


