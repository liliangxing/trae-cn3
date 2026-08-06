package com.bytedance.push.settings.annotation;

import com.bytedance.push.settings.IDefaultValueProvider;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface DefaultValueProvider {
    Class<? extends IDefaultValueProvider> value();
}
