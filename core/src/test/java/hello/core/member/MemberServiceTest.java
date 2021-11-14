package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
        //각 테스트 전체 무조건 실행
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    @DisplayName("회원가입 테스트")
    void join() {
        //given == 이런 환경이 주어졌을떄.
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when == 이렇게 했을때.
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then == 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
