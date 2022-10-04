package com.example.studyweb.member.entity;

import com.example.studyweb.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 20)
    private String password;

    @Column(length = 20)
    private String nickname;

    @Column(length = 20)
    private String category;

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setNickname(memberDTO.getNickname());
        memberEntity.setCategory(memberDTO.getCategory());
        return memberEntity;
    }
}
