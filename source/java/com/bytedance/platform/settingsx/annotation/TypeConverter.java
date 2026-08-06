package com.bytedance.platform.settingsx.annotation;

import com.bytedance.platform.settingsx.api.ITypeConverter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface TypeConverter {
    Class<? extends ITypeConverter> value();
}
