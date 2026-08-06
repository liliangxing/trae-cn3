package com.bytedance.ug.sdk.deeplink.utils;

import com.bytedance.ug.sdk.deeplink.HostCommonServices;

/* loaded from: classes4.dex */
public class Logger {
    private static final String TAG_PREFIX = "ZlinkApi_";

    public static void w(String str, String str2) {
        log(5, str, str2, null);
    }

    public static void d(String str, String str2) {
        log(3, str, str2, null);
    }

    public static void i(String str, String str2) {
        log(4, str, str2, null);
    }

    public static void e(String str, String str2) {
        log(6, str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        log(6, str, str2, th);
    }

    private static void log(int i, String str, String str2, Throwable th) {
        if (HostCommonServices.getZlinkDepend() != null) {
            HostCommonServices.getZlinkDepend().log(i, TAG_PREFIX + str, str2, th);
        }
    }
}
