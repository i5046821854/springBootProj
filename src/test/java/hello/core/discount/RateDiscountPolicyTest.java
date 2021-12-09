package hello.core.discount;

import hello.core.Grade;
import hello.core.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat; //asstions.assertThat 은 static으로 써주는 것이 좋음
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인")  //테스트에 이름 부여
    void vip_o(){
        Member member = new Member(1L, "memberVip", Grade.VIP);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }

    @Test
    @DisplayName("일반은 10% 할인 적용 안됨")
    void vip_x(){
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }
}