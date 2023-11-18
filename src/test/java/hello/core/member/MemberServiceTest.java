package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    // test가 실행되기 전에 무조건 사전에 실행되는 내용
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        // given ~ 가 주어졌을때
        Member member = new Member(1L,"memberA", Grade.VIP);

        // when 이렇게 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then 이렇게 된다.
        // 검증하기위한 좋은 도구가 많음 (Assertions)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
