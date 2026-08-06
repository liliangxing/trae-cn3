package com.hihonor.push.sdk;

import com.bytedance.webx.event.EventManager;

/* renamed from: com.hihonor.push.sdk.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0912c {
    /* renamed from: a */
    public static void m756a(String str) {
        String str2;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "";
                break;
            } else {
                if (!stackTrace[i].getClass().equals(C0912c.class)) {
                    String className = stackTrace[i].getClassName();
                    str2 = className.substring(className.lastIndexOf(46) + 1);
                    break;
                }
                i++;
            }
        }
        m757a("HonorPush_" + str2, str, null);
    }

    /* renamed from: a */
    public static void m757a(String str, String str2, Throwable th) {
        if (str2.length() > 4000) {
            int i = 0;
            while (i < str2.length()) {
                int length = str2.length();
                int i2 = i + EventManager.REGION_ENTRY_REDIRECT;
                if (length > i2) {
                    str2.substring(i, i2);
                } else {
                    str2.substring(i);
                }
                i = i2;
            }
        }
    }
}
