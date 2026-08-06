package me.ele.lancet.base.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes8.dex */
public @interface Proxy {
    boolean globalProxyClass() default true;

    boolean proxySubclass() default false;

    String value();
}
