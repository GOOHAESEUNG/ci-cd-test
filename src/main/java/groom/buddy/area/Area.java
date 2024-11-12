package groom.buddy.area;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groom.buddy.member.Member;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AreaType areaType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @JsonIgnore  // 순환 참조 방지
    private Member member;

    public enum AreaType {
        DALIY_LIFE,
        SELF_MANAGEMENT,
        MONEY_MANAGEMENT,
        SOCIETY
    }
}
