package com.bytedance.services.apm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface LaunchTypeInf {
    public static final int FIRST_INSTALL_COLD_LAUNCH = 1;
    public static final int NOT_FIRST_INSTALL_COLD_LAUNCH = 2;
}
