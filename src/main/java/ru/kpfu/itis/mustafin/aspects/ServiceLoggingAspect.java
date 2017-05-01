package ru.kpfu.itis.mustafin.aspects;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class ServiceLoggingAspect {

    private final Logger LOGGER = Logger.getLogger(String.valueOf(ServiceLoggingAspect.class));

    public void beforeMethod(){
        LOGGER.info("------Мои логи--------");
    }

    public Object methodExecutionLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        LOGGER.info("Start invoking "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params "
                + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("End of invoking method: " + (end - start) + "ms");
        return result;
    }

    public void afterMethod(){
        LOGGER.info("------Мои логи--------");
    }
}
