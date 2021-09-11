package com.hutao.myhelpset.tool.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注册消息注解
 * @author kangdi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RegisterEvent {
    String[] handlerEventMap() default {};
}
