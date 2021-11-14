package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        int result = discountPolicy.discount(member, 10000);

        Assertions.assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 되면 안된다.")
    void vip_x(){
        Member member = new Member(1L,"memberA",Grade.BASIC);

        int result = discountPolicy.discount(member, 10000);
        Assertions.assertThat(result).isEqualTo(0);
    }

}