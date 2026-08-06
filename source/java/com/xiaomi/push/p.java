package com.xiaomi.push;

/* loaded from: classes7.dex */
public class p {
    public static String a(String str, String str2) {
        try {
            return (String) q.a(null, "android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m9528a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
