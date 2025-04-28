package com.dna.umc_springboot.domain.mapping;

import com.dna.umc_springboot.domain.Member;
import com.dna.umc_springboot.domain.Mission;
import com.dna.umc_springboot.domain.common.BaseEntity;
import com.dna.umc_springboot.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private MissionStatus status;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;


}
