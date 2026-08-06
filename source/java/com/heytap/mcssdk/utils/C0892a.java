package com.heytap.mcssdk.utils;

/* renamed from: com.heytap.mcssdk.utils.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0892a {

    /* renamed from: a */
    private static final String f616a = "file";

    /* renamed from: b */
    private static final String f617b = "ro.crypto.type";

    /* renamed from: a */
    private static String m645a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m646a() {
        return "file".equals(m645a(f617b));
    }
}
