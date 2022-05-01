package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMemberA = memberService.findMember(1L);
        System.out.println("findMemberA = " + findMemberA.getName());
        System.out.println("memberA = " + memberA.getName());

    }
}
