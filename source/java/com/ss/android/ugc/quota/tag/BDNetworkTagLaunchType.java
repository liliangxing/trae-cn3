package com.ss.android.ugc.quota.tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes7.dex */
public @interface BDNetworkTagLaunchType {
    public static final int COLD_LAUNCH = 0;
    public static final int HOT_LAUNCH = 2;
    public static final int NORMAL = -1;
    public static final int UNSPECIFIED = -999;
    public static final int WARM_LAUNCH = 1;
}
