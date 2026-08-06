package com.bytedance.mt.protector.annotation;

import com.bytedance.mt.protector.ProtectorExceptionHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface CatchAllException {
    Class<?> handleClass() default ProtectorExceptionHandler.class;

    String handleStaticMethod() default "handlerThrowable";

    String tag() default "ProtectorExceptionHandlerTag";
}
