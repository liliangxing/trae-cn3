package com.bytedance.push.settings.annotation;

import com.bytedance.push.settings.ITypeConverter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes4.dex */
public @interface TypeConverter {
    Class<? extends ITypeConverter> value();
}
