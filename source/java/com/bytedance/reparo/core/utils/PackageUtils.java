package com.bytedance.reparo.core.utils;

import android.app.Application;

/* loaded from: classes4.dex */
public class PackageUtils {
    public static boolean isApkInDebug(Application application) {
        return (application.getApplicationInfo().flags & 2) != 0;
    }
}
