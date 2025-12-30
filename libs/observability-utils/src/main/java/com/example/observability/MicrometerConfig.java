package main.java.com.example.observability;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfig {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> configureMetrics() {
        return registry -> {
            registry.config().commonTags("application", "order-service");
        };
    }
}
