package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //멤버저장소에서 멤버를 찾아야함.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인정책으로.
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //주문 생성 요청이 오면 회원정보를 먼저 조회 하고  아이디 이름 등급
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책에다가 회원을 넘겨.

        return new Order(memberId, itemName, itemPrice, discountPrice); // 그리고 최종 생성된 주문을 반환.
    }


}
