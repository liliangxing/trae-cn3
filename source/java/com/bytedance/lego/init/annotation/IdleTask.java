package com.bytedance.lego.init.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface IdleTask {
    String desc();

    String id();

    boolean mustRunInMainThread();

    int priority() default 0;
}
