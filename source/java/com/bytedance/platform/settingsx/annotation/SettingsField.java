package com.bytedance.platform.settingsx.annotation;

import com.bytedance.platform.settingsx.api.DefaultNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface SettingsField {
    boolean defaultBoolean() default false;

    double defaultDouble() default 0.0d;

    float defaultFloat() default 0.0f;

    int defaultInt() default 0;

    long defaultLong() default 0;

    Class<?> defaultObject() default DefaultNull.class;

    String defaultString() default "";

    int forceBlockIndex() default -1;

    String value();
}
