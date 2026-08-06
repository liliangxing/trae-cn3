package com.ss.android.socialbase.downloader.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface MainThread {
}
