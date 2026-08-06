package com.bytedance.lego.init.annotation;

import com.bytedance.lego.init.model.InitPeriod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface InitTask {
    boolean afterPrivacyPopupWindow() default false;

    String[] dependon() default {};

    String desc();

    InitPeriod earliestPeriod() default InitPeriod.APP_ATTACHBASE2SUPER;

    int getExecutePriority() default 0;

    String id();

    InitPeriod latestPeriod() default InitPeriod.NONE;

    String moduleName() default "";

    boolean mustRunInMainThread() default true;

    String[] runInProcess() default {"all"};
}
