package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        C1130c.m1450a();
    }

    public static boolean getInitFlag() {
        return AbstractC1124a.m1411b();
    }

    public static void init(Context context, boolean z, boolean z2, boolean z3, String str, String str2) {
        new C1127b(context).m1431a(z).m1434c(z2).m1433b(z3).m1429a(0, str).m1429a(1, str).m1430a(str2).m1432a();
    }

    public static void onEvent(Context context, String str, String str2) {
        AbstractC1124a.m1409a(context, str, str2);
    }

    public static void onReport() {
        AbstractC1124a.m1412c();
    }

    public static void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        AbstractC1124a.m1410b(i, str, linkedHashMap);
    }

    public static void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        AbstractC1124a.m1408a(i, str, linkedHashMap);
    }
}
