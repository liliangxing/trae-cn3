package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/* renamed from: com.xiaomi.push.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1695k {
    /* renamed from: a */
    public static void m3440a(Context context) {
    }

    /* renamed from: a */
    public static boolean m3443a(Context context, String str, boolean z) {
        m3440a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    /* renamed from: a */
    public static void m3441a(Context context, String str, boolean z) {
        m3440a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }

    /* renamed from: a */
    public static void m3442a(Map<String, String> map, String str, String str2) {
        if (map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }
}
