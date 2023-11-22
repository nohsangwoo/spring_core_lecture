package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleInterfaceTest {

    @Test
    public void lifeCycleForInterfaceTest() {
        // 좀더 세밀하게 사용할때 필요함?AnnotationConfigApplicationContext의 상위 클래스가 ConfigurableApplicationContext임
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfigForInterfaceLifeCycle.class);
        NetworkClientForInterfaceLifeCycle client = ac.getBean(NetworkClientForInterfaceLifeCycle.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfigForInterfaceLifeCycle {
        @Bean
        public NetworkClientForInterfaceLifeCycle networkClientForInterfaceLifecycle() {
            NetworkClientForInterfaceLifeCycle networkClient = new NetworkClientForInterfaceLifeCycle();
            networkClient.setUrl("https://www.molluhub.com");
            return networkClient;
        }
    }
}
