package hello.core.lifecycle.annotationway;

public class NetworkClientForAnnotationWay {

    private String url;

    public NetworkClientForAnnotationWay() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }


    // 의존관계 주입이 끝나면 호출됨
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }


    // 생명주기가 끝날때 호출됨
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
