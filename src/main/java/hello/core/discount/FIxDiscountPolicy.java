package hello.core.discount;

import hello.core.Grade;
import hello.core.Member;

public class FIxDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;


    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return discountFixAmount;
        else
            return 0;
    }
}
