package com.bytedance.apm.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes3.dex */
public @interface ReportModeInf {
    public static final int DEGRADE = 2;
    public static final int NORMAL = 0;
    public static final int SMOOTH = 1;
}
