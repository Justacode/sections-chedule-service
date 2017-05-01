package ru.kpfu.itis.mustafin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.kpfu.itis.mustafin.services")
public class CoreConfig {
}
