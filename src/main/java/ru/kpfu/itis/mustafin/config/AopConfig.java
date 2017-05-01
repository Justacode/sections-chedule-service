package ru.kpfu.itis.mustafin.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAspectJAutoProxy
@ImportResource("classpath:aop-config.xml")
public class AopConfig {

}
