package com.bytedance.news.common.settings.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface AbSettingGetter {
    boolean defaultBoolean() default false;

    float defaultFloat() default 0.0f;

    int defaultInt() default 0;

    long defaultLong() default 0;

    String defaultString() default "";

    String desc();

    String expiredDate();

    boolean isSticky() default false;

    boolean isTransient() default false;

    String key();

    String owner();
}
