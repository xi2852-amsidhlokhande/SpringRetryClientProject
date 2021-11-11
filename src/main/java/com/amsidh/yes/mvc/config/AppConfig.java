package com.amsidh.yes.mvc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;
import org.springframework.retry.listener.RetryListenerSupport;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

@Configuration
@Slf4j
public class AppConfig {

    /*@Bean
    public RetryListener retryListeners() {
        return new RetryListener() {
            @Override
            public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
                Field labelField = ReflectionUtils.findField(retryCallback.getClass(), "val$label");
                ReflectionUtils.makeAccessible(labelField);
                String label = (String) ReflectionUtils.getField(labelField, retryCallback);
                log.info("Starting retryable method {}", label);
                return true;
            }

            @Override
            public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
                log.info("Finished retryable method {}", retryContext.getAttribute("context.name"));
            }

            @Override
            public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
                log.info("Retryable method {} threw {}th exception {}", retryContext.getAttribute("context.name"), retryContext.getRetryCount(), throwable.toString());
            }
        };
    }*/


    @Bean
    public RetryListenerSupport getRetryListenerSupport(){
        return new RetryListenerSupport(){
            @Override
            public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
                log.info("Retryable method {} threw {}th exception {}", context.getAttribute("context.name"), context.getRetryCount(), throwable.toString());
            }
        };
    }
}
