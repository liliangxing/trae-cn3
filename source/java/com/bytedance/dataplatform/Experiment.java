package com.bytedance.dataplatform;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface Experiment {
    String desc();

    String key();

    String layer() default "";

    String methodName() default "";

    String name() default "";

    String[] option() default {};

    String owner();

    double start() default -1.0d;
}
