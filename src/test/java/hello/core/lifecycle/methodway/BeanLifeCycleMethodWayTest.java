package hello.core.lifecycle.methodway;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleMethodWayTest {

    @Test
    public void lifeCycleTestForMethodWay() {
        // 좀더 세밀하게 사용할때 필요함?AnnotationConfigApplicationContext의 상위 클래스가 ConfigurableApplicationContext임
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfigForMethodWay.class);
        NetworkClientMethodWay client = ac.getBean(NetworkClientMethodWay.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfigForMethodWay {
        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClientMethodWay networkClient() {
            NetworkClientMethodWay networkClient = new NetworkClientMethodWay();
            networkClient.setUrl("https://www.molluhub.com");
            return networkClient;
        }
    }
}
