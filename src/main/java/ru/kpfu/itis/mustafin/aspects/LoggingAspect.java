package ru.kpfu.itis.mustafin.aspects;

import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(public * ru.kpfu.itis.mustafin..*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        final Logger log = LoggerFactory.getLogger(pjp.getTarget().getClass());
        final Object[] args = pjp.getArgs();
        final String methodName = pjp.getSignature().getName();

        if (!isUtilMethod(methodName)) {
            log.debug("{}(): {}", methodName, args);
        }

        final Object result = pjp.proceed();

        if (!isUtilMethod(methodName)) {
            log.debug("{}(): result={}", methodName, result);
        }
        return result;
    }

    private boolean isUtilMethod(String name) {
        return name.startsWith("get")
                || name.startsWith("set")
                || name.equals("toString")
                || name.equals("equals")
                || name.equals("hashCode");
    }

}
