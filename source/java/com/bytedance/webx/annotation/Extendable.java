package com.bytedance.webx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes6.dex */
public @interface Extendable {
    boolean isOverload() default false;

    boolean isProtected() default false;

    String returnTypeVariable() default "";
}
