package com.bytedance.ug.sdk.share.impl.utils;

import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ALog {
    /* renamed from: d */
    public static void m457d(String str, String str2) {
        ShareConfigManager.getInstance().onALogEvent(3, str, str2);
    }

    /* renamed from: v */
    public static void m460v(String str, String str2) {
        ShareConfigManager.getInstance().onALogEvent(2, str, str2);
    }

    /* renamed from: e */
    public static void m458e(String str, String str2) {
        ShareConfigManager.getInstance().onALogEvent(6, str, str2);
    }

    /* renamed from: i */
    public static void m459i(String str, String str2) {
        ShareConfigManager.getInstance().onALogEvent(4, str, str2);
    }

    /* renamed from: w */
    public static void m461w(String str, String str2) {
        ShareConfigManager.getInstance().onALogEvent(5, str, str2);
    }
}
