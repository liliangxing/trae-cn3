package com.lynx.tasm.image.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface CacheChoice {
    public static final int BITMAP = 1;
    public static final int DISK = 0;
}
