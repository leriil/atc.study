package atc.study.utils;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

public class TomcatCustomizer implements EmbeddedServletContainerCustomizer {

    private final int port;

    public TomcatCustomizer(int port) {
        this.port = port;
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(port);
    }

}