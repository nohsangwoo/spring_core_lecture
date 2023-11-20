package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // includeFilters: 컴포넌트 스캔 대상을 추가로 지정함.
        // hello.core.member의 하위 경로만 component scan의 대상이 된다.)
        //  basePackages = {"hello.core", "hello.service"}, 이렇게 여러개를 지정할 수도 있다.
        basePackages = "hello.core.member",
        // 지정한 클래스가 있는 디렉토리 레벨의 바로 윗단 경로의 모든 하위 경로
        // 지정하지 않으면 @ComponentScan가 붙은 모든 클래스파일의 위치레벨에서 위와 같은조건으로 탐색.
        // 추천하는 방법은 포함하는 패키지들의 최상단에 설정파일을 두는 것
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  Configuration.class)

)
public class AutoAppConfig {
    @Bean(name =  "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
