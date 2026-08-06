package com.huawei.secure.android.common.ssl.util;

import android.content.Context;

/* loaded from: classes6.dex */
public class ContextUtil {
    private static Context a;

    public static Context getInstance() {
        return a;
    }

    public static void setContext(Context context) {
        if (context == null || a != null) {
            return;
        }
        a = context.getApplicationContext();
    }
}
