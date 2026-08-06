package com.bytedance.router.annotation;

/* loaded from: classes4.dex */
public @interface Interceptor {
    String assign_name() default "";

    String author() default "";

    String desc() default "Default Interceptor";

    int priority() default 0;

    String scope() default "";
}
