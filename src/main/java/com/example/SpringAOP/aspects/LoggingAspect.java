package com.example.SpringAOP.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
    /**
     * Логирование успешно завершения методов, отмеченных аннотацией @TrackUserAction
     * @param joinPoint точка вызова метода
     * @param returning данные, возвращаемые методом
     */
    @AfterReturning(value = "@annotation(TrackUserAction)", returning = "returning")
    public void log(JoinPoint joinPoint, Object returning){
        System.out.println("Метод " + joinPoint.getSignature().getName() + " был вызван\nВернул  " +
                returning.getClass());
    }
    /**
     * Логирование методов, отмеченных аннотацией @TrackUserAction в случаи выбрасывания исключения
     * @param joinPoint точка вызова аспекта
     * @param ex исключение, которое выбросил метод
     */
    @AfterThrowing(value = "@annotation(TrackUserAction)", throwing = "ex")
    public void logEx(JoinPoint joinPoint, Exception ex){
        System.out.println("Метод " + joinPoint.getSignature().getName() + " вернул исключение " + ex.getClass() +
                ex.getMessage());
    }

}


