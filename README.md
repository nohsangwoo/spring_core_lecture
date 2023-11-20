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