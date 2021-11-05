package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemberRepositoryImpl memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemberRepositoryImpl();
        memberService = new MemberService(memberRepository);

    }


    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long savedId = memberService.join(member);
        //then
        Member result = memberService.findOne(savedId).get();
        Assertions.assertThat(member.getName()).isEqualTo(result.getName());
    }

    @Test
    public void 중복회원예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

}