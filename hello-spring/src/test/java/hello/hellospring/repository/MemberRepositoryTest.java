package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepositoryImpl memberRepository = new MemberRepositoryImpl();

    //clear 시켜주는 메서드
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        memberRepository.save(member);
        //Optional 타입에서 값 꺼낼때에는 get으로 꺼내기 가능!
        Member result = memberRepository.findById(member.getId()).get();

        assertThat(result).isEqualTo(member);
    }


    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("member1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("member1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("member1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
