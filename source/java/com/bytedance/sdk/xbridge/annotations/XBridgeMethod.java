package com.bytedance.sdk.xbridge.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes5.dex */
public @interface XBridgeMethod {
    @Deprecated
    String biz() default "";

    String name();

    String namespace() default "";

    String owner() default "";
}
