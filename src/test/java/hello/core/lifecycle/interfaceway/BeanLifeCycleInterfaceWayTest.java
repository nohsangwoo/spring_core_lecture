package hello.core.lifecycle.interfaceway;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleInterfaceWayTest {

    @Test
    public void lifeCycleTest() {
        // 좀더 세밀하게 사용할때 필요함?AnnotationConfigApplicationContext의 상위 클래스가 ConfigurableApplicationContext임
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfigInterfaceWay.class);
        NetworkClientCycleInterfaceWay client = ac.getBean(NetworkClientCycleInterfaceWay.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfigInterfaceWay {
        @Bean
        public NetworkClientCycleInterfaceWay networkClientForInterfaceLifecycle() {
            NetworkClientCycleInterfaceWay networkClient = new NetworkClientCycleInterfaceWay();
            networkClient.setUrl("https://www.molluhub.com");
            return networkClient;
        }
    }
}
