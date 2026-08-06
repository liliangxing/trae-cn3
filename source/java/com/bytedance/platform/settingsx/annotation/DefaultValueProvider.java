package com.bytedance.platform.settingsx.annotation;

import com.bytedance.platform.settingsx.api.IDefaultValueProvider;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface DefaultValueProvider {
    Class<? extends IDefaultValueProvider> value();
}
