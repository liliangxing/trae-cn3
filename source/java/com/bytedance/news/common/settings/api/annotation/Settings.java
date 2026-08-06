package com.bytedance.news.common.settings.api.annotation;

import com.bytedance.news.common.settings.api.Migration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface Settings {
    Class<? extends Migration>[] migrations() default {};

    String settingsId() default "";

    String storageKey();
}
