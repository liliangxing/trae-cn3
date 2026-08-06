package com.unicom.online.account.kernel;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* renamed from: com.unicom.online.account.kernel.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1193y {
    /* renamed from: a */
    public static String m572a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            boolean z = true;
            for (Map.Entry<?, ?> entry : m573a(new JSONObject(str).toString()).entrySet()) {
                stringBuffer.append(z ? "" : str2).append((String) entry.getKey()).append("=").append(entry.getValue() != null ? entry.getValue() : "");
                z = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static TreeMap<?, ?> m573a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            TreeMap<?, ?> treeMap = new TreeMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                treeMap.put(next, jSONObject.getString(next));
            }
            return treeMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
