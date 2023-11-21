package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("service") // 빈 중복 이름 등록 테스트
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;



    //생성자에 @Autowired를 사용하면, 스프링이 자동으로 생성자 주입 해줌.
    // ac.getBean(MemberRepository.class)를 한것과 같은 효과.
    // required = false는 기본주입 설정된 생성자가 없어도 동작하게 만들어주는 옵션.
    @Autowired(required = false)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
