package ru.kpfu.itis.mustafin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.kpfu.itis.mustafin")
@EnableAspectJAutoProxy
public class CoreConfig {
}
