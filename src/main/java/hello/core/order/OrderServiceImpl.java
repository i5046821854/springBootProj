package hello.core.order;

import hello.core.Member;
import hello.core.MemberRepository;
import hello.core.MemoryMemberRepository;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FIxDiscountPolicy;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();

    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberID);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberID, itemName, itemPrice, discountPrice);
    }
}
