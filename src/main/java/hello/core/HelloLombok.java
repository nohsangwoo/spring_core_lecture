package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("nohsangwoo");
        helloLombok.setAge(34);


        // lombok의 @ToString기능을 이용한 멤버 변수 출력.
        System.out.println(helloLombok.toString());
    }



}
