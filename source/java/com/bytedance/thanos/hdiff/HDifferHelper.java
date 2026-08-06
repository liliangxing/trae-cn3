package com.bytedance.thanos.hdiff;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes5.dex */
public class HDifferHelper {
    private static float sCurrentProcess = -1.0f;

    private static native int patch(String str, String str2, String str3);

    static {
        System.loadLibrary("hdiffpatch");
    }

    public static synchronized int hpatch(String str, String str2, String str3) {
        synchronized (HDifferHelper.class) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (!new File(str).exists()) {
                    return 302;
                }
                if (!new File(str2).exists()) {
                    return 303;
                }
                return patch(str, str2, str3);
            }
            return 301;
        }
    }
}
