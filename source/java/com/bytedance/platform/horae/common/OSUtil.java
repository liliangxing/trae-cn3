package com.bytedance.platform.horae.common;

import android.os.Build;

/* loaded from: classes4.dex */
public final class OSUtil {
    private OSUtil() {
    }

    public static boolean isAndroidPHigher() {
        return Build.VERSION.SDK_INT >= 28 || (Build.VERSION.SDK_INT == 27 && Build.VERSION.PREVIEW_SDK_INT > 0);
    }
}
