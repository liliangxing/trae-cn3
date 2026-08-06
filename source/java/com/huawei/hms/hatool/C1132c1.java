package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.util.ByteConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.c1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1132c1 {
    /* renamed from: a */
    public static Map<String, List<C1129b1>> m1456a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> m1465a = C1133d.m1465a(context, str);
        m1462b(m1465a);
        return m1458a(m1465a);
    }

    /* renamed from: a */
    public static Map<String, List<C1129b1>> m1457a(Context context, String str, String str2) {
        Map<String, List<C1129b1>> m1456a;
        Map<String, List<C1129b1>> m1456a2;
        int m1705h = AbstractC1173q0.m1705h() * ByteConstants.f354MB;
        if (C1131c0.m1454a(context, "cached_v2_1", m1705h)) {
            C1182v.m1786f("hmsSdk", "cached event reach max size, delete it");
            C1133d.m1466a(context, "cached_v2_1", new String[0]);
        }
        if (C1131c0.m1454a(context, "stat_v2_1", m1705h)) {
            C1182v.m1786f("hmsSdk", "stat event reach max size, delete it");
            C1133d.m1466a(context, "stat_v2_1", new String[0]);
        }
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            C1182v.m1775a("hmsSdk", "read all event records");
            m1456a = m1456a(context, "stat_v2_1");
            m1456a2 = m1456a(context, "cached_v2_1");
        } else {
            String m1648a = AbstractC1165n1.m1648a(str, str2);
            m1456a = m1461b(context, "stat_v2_1", m1648a);
            m1456a2 = m1461b(context, "cached_v2_1", m1648a);
        }
        return m1459a(m1456a, m1456a2);
    }

    /* renamed from: a */
    private static Map<String, List<C1129b1>> m1458a(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                m1460a(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, List<C1129b1>> m1459a(Map<String, List<C1129b1>> map, Map<String, List<C1129b1>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    /* renamed from: a */
    private static void m1460a(String str, String str2, Map<String, List<C1129b1>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                C1129b1 c1129b1 = new C1129b1();
                try {
                    c1129b1.m1441a(jSONArray.getJSONObject(i));
                    arrayList.add(c1129b1);
                } catch (JSONException unused) {
                    C1182v.m1785e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            C1182v.m1785e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    /* renamed from: b */
    public static Map<String, List<C1129b1>> m1461b(Context context, String str, String str2) {
        String m1464a = C1133d.m1464a(context, str, str2, "");
        HashMap hashMap = new HashMap();
        m1460a(str2, m1464a, hashMap);
        return hashMap;
    }

    /* renamed from: b */
    private static void m1462b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> m1650a = AbstractC1165n1.m1650a(AbstractC1173q0.m1693b());
        while (it.hasNext()) {
            if (!m1650a.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
