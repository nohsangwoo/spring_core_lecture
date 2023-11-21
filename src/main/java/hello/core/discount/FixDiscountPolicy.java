package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;


// OrderServiceImpl에서 기본 생성자를 주입받아서 사용하는데 DiscountPolicy의 인터페이스에 의존하고있다.
// 이때 DiscountPolicy를 구현한 클래스중 한개만 선택해서 @Component로 지정해야한다.
// 구현클래스가 여러개고 이중으로 @Component를 등록한다면 아래와 비슷한 에러를 출력한다.
// org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'orderServiceImpl' defined in file [
// @Component
public class FixDiscountPolicy implements DiscountPolicy{

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            // 1000원 할인
            return 1000;
        } else {
            return 0;
        }
    }
}
