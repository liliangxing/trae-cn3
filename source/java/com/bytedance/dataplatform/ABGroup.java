package com.bytedance.dataplatform;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ABGroup {
    double percent();

    String vid();
}
