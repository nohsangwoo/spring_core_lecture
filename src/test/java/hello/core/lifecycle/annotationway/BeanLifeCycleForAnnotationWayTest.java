package hello.core.lifecycle.annotationway;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleForAnnotationWayTest {

    @Test
    public void lifeCycleTestForAnnotationWay() {
        // 좀더 세밀하게 사용할때 필요함?AnnotationConfigApplicationContext의 상위 클래스가 ConfigurableApplicationContext임
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfigForAnnotationWay.class);
        NetworkClientForAnnotationWay client = ac.getBean(NetworkClientForAnnotationWay.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfigForAnnotationWay {
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClientForAnnotationWay networkClient() {
            NetworkClientForAnnotationWay networkClient = new NetworkClientForAnnotationWay();
            networkClient.setUrl("https://www.molluhub.com");
            return networkClient;
        }
    }
}
