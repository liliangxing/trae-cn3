package com.ss.android.ugc.dex.maindexslimming.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes7.dex */
public @interface MainDexIgnore {
    public static final int IGNORE_ALL = 2317;
    public static final int IGNORE_CLASS = 1;
    public static final int IGNORE_CLASS_RUNTIME_ANNOTATION = 2;
    public static final int IGNORE_FIELDS = 12;
    public static final int IGNORE_FIELDS_INSTANCE = 4;
    public static final int IGNORE_FIELDS_INSTANCE_RUNTIME_ANNOTATION = 16;
    public static final int IGNORE_FIELDS_STATIC = 8;
    public static final int IGNORE_FIELDS_STATIC_RUNTIME_ANNOTATION = 32;
    public static final int IGNORE_METHODS = 2304;
    public static final int IGNORE_METHODS_INSTANCE = 64;
    public static final int IGNORE_METHODS_INSTANCE_CODE = 256;
    public static final int IGNORE_METHODS_INSTANCE_PARAMETERS_RUNTIME_ANNOTATION = 1024;
    public static final int IGNORE_METHODS_INSTANCE_RUNTIME_ANNOTATION = 512;
    public static final int IGNORE_METHODS_STATIC = 128;
    public static final int IGNORE_METHODS_STATIC_CODE = 2048;
    public static final int IGNORE_METHODS_STATIC_PARAMETERS_RUNTIME_ANNOTATION = 8192;
    public static final int IGNORE_METHODS_STATIC_RUNTIME_ANNOTATION = 4096;

    int value() default 2317;
}
