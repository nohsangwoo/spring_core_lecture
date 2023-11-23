# 스프링 코어 - 김영한 강의 학습

# 스타터 팩같은게 있음
![img_1.png](img_1.png)
- ref: https://start.spring.io/
- 사진의 조건대로 설정.

# file > setting

![img.png](img.png)
Build and Run 부분을 IntelliJ IDEA로 변경 (속도가 더 빠름)

![img_2.png](img_2.png)

![img_3.png](img_3.png)


# 단축키
- alt + insert = generate
- alt + enter = 자동수정
- ctrl + shift + enter = 자동완성시 세미클론을 포함하여 출려됨
- CTRL + shift + t = 테스트 코드 자동완성
- ctrl + e = recent file
- iter for문 자동생성
- ctrl + shift + t(클래스명을 타겟으로 잡은상태에서) = 테스트 자동생성
- sout 시리즈 = 출력관련
- psvm = main() method declaration
- 
# 테스트 코드 짜는방법
- MemeberServiceTest
- 
![img_4.png](img_4.png)

![img_5.png](img_5.png)

![img_6.png](img_6.png)

# Ioc, DI
![img_7.png](img_7.png)


![img_8.png](img_8.png)

![img_9.png](img_9.png)

![img_10.png](img_10.png)

# appConfig.xml 설정 방법 및 사용방법 (XmlAppContext테스트 파일로 사용방법 숙지)


# bean meta infomation
![img_11.png](img_11.png)


# 스프링빈은 항상 무상태로 설계해야한다.


# 최근의 스프링부트는 컴포넌트 스캔을 기본으로 제공하는데, 스프링의 기본설정에 최대한 맞추어 사용하는것을 권장
- 간혹 includeFilter, excludeFilter를 사용하기는 한다.

# 빈등록을 중복으로 지정했을때

자동 등록 빈 vs 자동 등록 빈 :  에러남

수동 등록 빈 vs 자동 등록 빈 : 수동 등록된 빈이 우선권을 가짐.(수동등록된 빈이 자동 등록된 빈을 오버라이딩 한다.)

그러나 이런종류의 내용들은 사이드이펙트의 확률을 높이기에 애초에 중복되게 설정을 안하는게 좋다
(최근의 스프링부트에서는 수동빈과 자동빈 등록이 충돌나면 오류가 발생하도록 기본값을 변경했다고 한다.)

- 아래와 같이 설정하면 수동빈이 자동빈을 오버라이딩하도록 설정할 수 있다.(추천하지 않음)
![img_12.png](img_12.png)


# 의존관계 주입 방법
1. 생성자 주입
![img_14.png](img_14.png)

2. 수정자 주입(setter 주입)
![img_15.png](img_15.png)

3. 필드 주입
- 외부에서 변경이 불가능하기때문에 테스트가 어려기때문에 필드주입은 권장되지 않음, 
![img_16.png](img_16.png)
- 필드 주입 예시를위한 임시 AppConfig 변경사항.
![img_17.png](img_17.png)
4. 일반 메서드 주입
- 한번에 여러필드를 주입받을 수 있다.
- 다만 일반적으로 잘 사용되지 않음. 그냥 알아만 두자.
![img_18.png](img_18.png)

생성자 주입을 권장하니 생성자 주입을 사용하자(사이드 이펙트 관리차원에서 여러 통계의 결과)

# 의존 관계 주입은 스프링 컨테이터가 관리하는 스프링 빈이어야지만 동작한다(당연한 이야기)


# lombok 설치 및 사용세팅 (검색하면 많이 나옴)

# lombok을 이용하는 이유
- getter, setter등을 자동으로 만들어준다.
- java단에서 귀찮은것들을 자동으로 설정해줌.
- @ToString은 자동으로 모는 멤버 변수들의 내용을 출력해주는 것
- @RequiredArgsConstructor은 생성자 주입을 자동으로 만들어줌.
- 등등...

# 생성자 주입 빈이 중복으로 등록됐을때 해결방법
1. Autowired 필드명 매칭
![img_19.png](img_19.png)
2. @Component 등록시 @Qualifier로 구분이름을 지정하고 주입시 @Qualifier을 사용하여 빈 이름 매칭
![img_20.png](img_20.png)
![img_21.png](img_21.png)
![img_22.png](img_22.png)
3. @Primary 사용
- @Primary로 우선권을 지정하여 중복시 우선선택되게 설정할 수 있다.
![img_23.png](img_23.png)


# custom annotation
1. 설정하는 곳
- MainDiscountPolicy annotation file
![img_25.png](img_25.png)
- RateDiscountPolicy class
![img_26.png](img_26.png)
2. 사용하는 곳
- OrderServiceImpl
![img_24.png](img_24.png)


# 조회한 빈이 모두 필요한 경우
![img_27.png](img_27.png)


# 빈 생명주기 콜백 시작
- DB같은예로 connection pull이 나지 않게하기위해선 
모든 작업 후 일정 조건에따라 안전하게 연결을 끊어줘야한다.


# 스프링 빈 라이프 사이클
1. 스프링 컨테이너 생성
2. 스프링 빈 생성
3. 의존관계 주입
4. 초기화 콜백
5. 사용
6. 소멸전 콜백
7. 스프링 종료
- 객체의 생성과 초기화는 분리하는것이 좋다
생성자는 필수정보(파라미터)를 받고, 메모리를 할당해서 객체를 생성하는 책임을 가진다.
초기화는 이렇게 생성된 값들을 활용해서 외부 커넥션을 연결하는등의 무거운 동작을 수행한다
즉 유지보수 관점에서도 좋으니 의도대로 사용하자.

![img_28.png](img_28.png)


# 빈 라이프 사이클 - 인터페이스 (InitializingBean, DisposableBean) 등록 방법
![img_29.png](img_29.png)


# 빈 라이프 사이클  - 빈등록 초기화, 소멸 메소드 등록 방법
- 메소드 등록
![img_30.png](img_30.png)
- 초기화, 소멸 메소드 빈에 등록방법
![img_31.png](img_31.png)
- close와 shutdown이라는 메소드명이 있으면 자동으로 destoryMethod로 등록됨(@Bean등록시)
![img_32.png](img_32.png)


# 빈 라이프 사이클 - annotation 등록 방법(권장)
- 이방법을 주로 사용하는 것 을 권장한다.
- @PostConstruct, @PreDestroy 등록 방법
![img_33.png](img_33.png)[
- 사용방법(그냥 빈 등록하면 끝)
![img_34.png](img_34.png)


# 빈 스코프란?
![img_35.png](img_35.png)

# 싱글톤 빈 요청
![img_36.png](img_36.png)


# 프로토 타입 빈 요청
- 한번 사용되고 버려지는 빈
- 매번 새로운 빈을 만들어서 사용한다(싱글톤이 유지안됨)
![img_37.png](img_37.png)
![img_38.png](img_38.png)
- 사용법 (호출되는 클래스의 종류가 다른것을 확인 할 수 있다.)
- close또한 빈이 관리하는것이 아니라 작동안하기때문에 destroy기능이 있다면 메소드를 직접 호출해줘야한다.
![img_41.png](img_41.png)
![img_40.png](img_40.png)
![img_42.png](img_42.png)


# 프로토 타입 빈 - 싱글톤 빈과 함께 사용시 Provider로 문제 해결
싱글톤 빈과 프로토 타입 빈을 함께 사용할때, 어떻게 하면 사용할 대 마다 항상 새로운 프로토 타입 빈을 생성할 수 있을까?
- 근데 굳이 사용할 일이 없다 대부분의 경우 싱글톤으로 해결 가능한 일이 대부분.

- 지정한 빈을 컨테이너에서 대신 찾아주는 DL 서비스를 제공하는것이
'ObjectProvider'
![img_43.png](img_43.png)


- JSR-330 Provider(330이 맞음.)
![img_44.png](img_44.png)
- ![img_45.png](img_45.png)

# 웹 스코프
![img_46.png](img_46.png)

- request 스코프
![img_47.png](img_47.png)
- web환경에서 동작테스트를 위한 세팅
![img_48.png](img_48.png)
- MyLogger예제
![img_49.png](img_49.png)
![img_50.png](img_50.png)

- 스프링에의해서 임시로 주입되는 myLogger클래스(예제용)
![img_52.png](img_52.png)
![img_51.png](img_51.png)


# 다음코스
![img_53.png](img_53.png)
![img_54.png](img_54.png)