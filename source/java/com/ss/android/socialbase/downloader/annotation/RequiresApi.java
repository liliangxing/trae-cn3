package com.ss.android.socialbase.downloader.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface RequiresApi {
    int api() default 1;

    int value() default 1;
}
