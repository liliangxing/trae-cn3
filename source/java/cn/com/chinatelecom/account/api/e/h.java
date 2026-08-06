package cn.com.chinatelecom.account.api.e;

import android.content.Context;

/* loaded from: classes2.dex */
public class h {
    private static i a = new k();

    public static String a() {
        return a.a(true);
    }

    public static String a(Context context, long j, String str) {
        return a.a(context, j, str);
    }

    public static String a(Context context, String str, String str2, String str3, long j, String str4) {
        return a.a(context, str, str2, str3, j, true, str4);
    }

    public static String a(String str, String str2) {
        return a.a(str, str2);
    }

    public static String b() {
        return a.a(false);
    }

    public static String b(Context context, String str, String str2, String str3, long j, String str4) {
        return a.a(context, str, str2, str3, j, false, str4);
    }
}
