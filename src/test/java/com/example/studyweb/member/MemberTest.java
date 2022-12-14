package com.example.studyweb.member;

import com.example.studyweb.member.dto.MemberDTO;
import com.example.studyweb.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberTest {
    @Autowired
    private MemberService memberService;

    public MemberDTO newMember() {
        MemberDTO member = new MemberDTO("hj@naver.com", "1234", "농부가천직", "대학생");
        return member;
    }

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("회원가입 테스트")
    public void memberSaveTest() {

        Long savedId = memberService.save(newMember());
        MemberDTO memberDTO = memberService.findById(savedId);
        assertThat(newMember().getEmail()).isEqualTo(memberDTO.getEmail());
    }

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("로그인 테스트")
    public void loginTest() {
        final String email = "로그인용이메일1";
        final String password = "로그인용비번1";
        String nickname = "로그인용닉네임1";
        String category = "로그인용전화번호1";
        MemberDTO memberDTO = new MemberDTO(email, password, nickname, category);
        Long savedId = memberService.save(memberDTO);
        //로그인 객체 생성 후 로그인
        MemberDTO loginMemberDTO = new MemberDTO();
        loginMemberDTO.setEmail(email);
        loginMemberDTO.setPassword(password);
        MemberDTO loginResult = memberService.login(loginMemberDTO);
        //로그인 결과가 not null 이면 테스트 통과
        assertThat(loginResult).isNotNull();
    }

    @Test
    @DisplayName("회원 데이터 저장")
    public void memberSave() {
        memberService.save(newMember());
    }
}
