package com.example.studyweb.member.dto;

import com.example.studyweb.member.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String category;

    public MemberDTO(String email, String password, String nickname, String category) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.category = category;
    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setEmail(memberEntity.getEmail());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setNickname(memberEntity.getNickname());
        memberDTO.setCategory(memberDTO.getCategory());
        return memberDTO;
    }
}
