package com.hutao.myhelpset.tool.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * View注解
 * @author: hutao
 * @date: 2021/9/8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RegisterView {
    int id() default -1;
    String tag() default "";
}
