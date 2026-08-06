package com.bytedance.tobshadow.bdtracker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.bytedance.tobshadow.bdtracker.y5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0557y5 {

    /* renamed from: a */
    public static final C0550x5 f1261a = new C0550x5();

    /* renamed from: b */
    public static final Map<String, String> f1262b = new ConcurrentHashMap();

    /* renamed from: a */
    public static String m756a(String str) {
        Map<String, String> map = f1262b;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String m754a = f1261a.m754a(str);
        if (m754a != null) {
            map.put(str, m754a);
        }
        return m754a;
    }
}
