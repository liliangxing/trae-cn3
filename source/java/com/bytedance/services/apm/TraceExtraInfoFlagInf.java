package com.bytedance.services.apm;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface TraceExtraInfoFlagInf {
    public static final int GET_IO = 2;
    public static final int GET_NET = 1;
    public static final int GET_THREAD = 3;
}
