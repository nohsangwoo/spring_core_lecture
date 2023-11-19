package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // 이 클래스에서 객체를 가져올 수 있는방법은 getInstance밖에 없음
    public static SingletonService getInstance() {
        return instance;
    }

    
    // 외부에서 new SingletonService로 객체 생성을 막음
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
