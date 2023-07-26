package org.example;

import com.example.infrastructure.repository.ReportEntityRepository;
import com.example.infrastructure.repository.impl.ReportRepositoryImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public class FirstAppInitializer implements ApplicationContextInitializer {

    private ConfigurableApplicationContext applicationContextInfrastructure;

    public FirstAppInitializer(ConfigurableApplicationContext applicationContextInfrastructure) {
        this.applicationContextInfrastructure = applicationContextInfrastructure;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry = applicationContext.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(ReportRepositoryImpl.class);
        registry.registerSingleton("ReportRepository",new ReportRepositoryImpl(applicationContextInfrastructure.getBean(ReportEntityRepository.class)));

    }
}
