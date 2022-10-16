package com.example.studyweb.member.service;

import com.example.studyweb.member.dto.MemberDTO;
import com.example.studyweb.member.entity.MemberEntity;
import com.example.studyweb.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        Long savedId = memberRepository.save(memberEntity).getId();
        return savedId;
    }

    public MemberDTO login(MemberDTO memberDTO) {

        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByEmail(memberDTO.getEmail());
        if (optionalMemberEntity.isPresent()) {
            MemberEntity loginEntity = optionalMemberEntity.get();
            if (loginEntity.getPassword().equals(memberDTO.getPassword())) {
                return MemberDTO.toMemberDTO(loginEntity);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            MemberEntity memberEntity = optionalMemberEntity.get();
            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            return  memberDTO;
        } else {
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity member: memberEntityList) {
//            MemberDTO memberDTO = MemberDTO.toMemberDTO(member);
 //           memberDTOList.add(memberDTO);
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        }
        return memberDTOList;
    }
}
