package com.bytedance.platform.settingsx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface AppSettingGetter {
    boolean defaultBoolean() default false;

    double defaultDouble() default 0.0d;

    float defaultFloat() default 0.0f;

    int defaultInt() default 0;

    long defaultLong() default 0;

    String defaultString() default "";

    String desc();

    int forceBlockIndex() default -1;

    @Deprecated
    boolean isHeaderBlock() default false;

    boolean isSticky() default false;

    boolean isTransient() default false;

    String key();

    String owner();
}
