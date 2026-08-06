package com.bytedance.lego.init.annotation;

import com.bytedance.lego.init.model.ExecutionPeriod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface PeriodTask {
    String desc();

    ExecutionPeriod executionPeriod();

    String id();
}
