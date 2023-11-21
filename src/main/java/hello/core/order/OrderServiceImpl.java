package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("service")  // 빈 중복 이름 등록 테스트
@Component
public class OrderServiceImpl implements OrderService{


    // final은 생성자 주입또는 초기 값설정으로만 값을 설정할 수 있다.
    // 또한 값이 있어야함을 강제한다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }



    // AutoConfig와 관계가 있음. (생성자 위에 설정해야함)
    // 자동 의존관계 주입
    // @Component로 설정된 MemoryMemberRepository와 RateDiscountPolocy를 자동으로 인식해서 주입해준다.
    // 만약 생성자가 한개라면 @Autowired를 생략 할 수 있다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("OrderServiceImpl. memberRepository: " + memberRepository);
        System.out.println("OrderServiceImpl. discountPolicy: " + discountPolicy);

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
