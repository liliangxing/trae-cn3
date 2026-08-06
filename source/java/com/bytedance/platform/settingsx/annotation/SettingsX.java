package com.bytedance.platform.settingsx.annotation;

import com.bytedance.platform.settingsx.Migration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes4.dex */
public @interface SettingsX {
    @Deprecated
    Class<? extends Migration> migrations() default Migration.class;

    String settingsId() default "";

    String storageKey() default "";
}
