package com.fatihsahin.annotations.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // Bu class'ın AOP Aspect olduğunu belirtir.
@Component // Spring'in bu class'ı Bean olarak yönetmesini sağlar.
public class LoggingAspect {

    @Around("execution(* com.fatihsahin.annotations.services.impl.StudentServiceImpl.*(..))")
    public Object logServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        // Çalışacak Service methodunun adını alıyoruz.
        String methodName = joinPoint.getSignature().getName();

        // Methodun çalışmaya başladığı zamanı alıyoruz.
        long startTime = System.currentTimeMillis();

        System.out.println("[INFO] " + methodName + "() başladı.");

        try {

            // Gerçek Service methodunu çalıştırıyoruz.
            Object result = joinPoint.proceed();

            // Method başarılı şekilde tamamlandı.
            System.out.println("[INFO] " + methodName + "() başarılı.");

            // Gerçek methodun sonucunu geri döndürüyoruz.
            return result;

        } catch (Throwable exception) {

            // Method hata verirse hata logluyoruz.
            System.out.println(
                    "[ERROR] " + methodName
                            + "() hata verdi: "
                            + exception.getMessage()
            );

            // Hatayı tekrar dışarı gönderiyoruz.
            throw exception;

        } finally {

            // Methodun bitiş zamanını alıyoruz.
            long endTime = System.currentTimeMillis();

            // Methodun ne kadar sürdüğünü hesaplıyoruz.
            long duration = endTime - startTime;

            System.out.println(
                    "[INFO] " + methodName
                            + "() tamamlandı. Süre: "
                            + duration
                            + " ms"
            );
        }
    }
}