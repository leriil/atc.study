package atc.study;

import atc.study.utils.TomcatCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource(value = "spring/app.xml")
public class App {

    @Value("${server.port}")
    private int port;

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new TomcatCustomizer(port);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
