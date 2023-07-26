package org.example;

import com.example.infrastructure.InfrastructureApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        SpringApplication infrastructure = new SpringApplication(infrastructureConfig.class);
        infrastructure.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        ConfigurableApplicationContext infrastructureContext = infrastructure.run();


        SpringApplication adapter =new SpringApplication(AdapterConfig.class);
        adapter.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        adapter.addInitializers(new FirstAppInitializer(infrastructureContext));
        ConfigurableApplicationContext adapterContext = adapter.run();
    }
}

@SpringBootApplication(scanBasePackages = "com.example.adapter")
class AdapterConfig{
}

@SpringBootApplication(scanBasePackages = "com.example.infrastructure")
class infrastructureConfig{
}