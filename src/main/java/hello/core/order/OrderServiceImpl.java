package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("service")  // 빈 중복 이름 등록 테스트
@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {


    // final은 생성자 주입또는 초기 값설정으로만 값을 설정할 수 있다.
    // 또한 값이 있어야함을 강제한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // @RequiredArgsConstructor에 의해 생성자 주입이 대체될 수 있음
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }



    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
