package com.apm.lite.runtime;

import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0792o;
import com.apm.lite.p023k.C0794q;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import java.io.File;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.runtime.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0830k {

    /* renamed from: a */
    protected static JSONObject f715a = new JSONObject();

    /* renamed from: a */
    public static void m1152a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String m1016a = C0810a.m1016a(jSONObject);
            File file = new File(C0792o.m875j(C0749e.m565g()), "apmlite/configCrash/configNative");
            if (m1016a != null) {
                JSONObject jSONObject2 = new JSONObject(m1016a);
                f715a = jSONObject2;
                C0786i.m791a(file, m1158b(jSONObject2), false);
            } else {
                f715a = new JSONObject();
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
    }

    /* renamed from: a */
    public static boolean m1153a(String str, C0825f c0825f) {
        if (f715a == null) {
            return false;
        }
        if (c0825f == null) {
            c0825f = new C0825f();
        }
        JSONObject optJSONObject = f715a.optJSONObject(str);
        if (optJSONObject == null || m1154a(optJSONObject.optJSONArray("disable"), c0825f)) {
            return false;
        }
        return m1154a(optJSONObject.optJSONArray(StrategyConstants.ENABLE), c0825f);
    }

    /* renamed from: a */
    private static boolean m1154a(JSONArray jSONArray, C0825f c0825f) {
        if (C0789l.m821a(jSONArray)) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
            } else if (m1155a(optJSONObject, c0825f)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1155a(JSONObject jSONObject, C0825f c0825f) {
        StringBuilder sb;
        Iterator<String> keys = jSONObject.keys();
        boolean z = false;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                if (next.startsWith("header_")) {
                    if (!m1156a(jSONObject.optJSONObject(next), c0825f.mo1141b(next.substring(7)))) {
                        sb = new StringBuilder("not match ");
                        C0794q.m887a((Object) sb.append(next).toString());
                        return false;
                    }
                    z = true;
                } else {
                    if (!next.startsWith("java_")) {
                        C0794q.m887a((Object) ("no rules match " + next));
                    } else if (!m1156a(jSONObject.optJSONObject(next), c0825f.mo1013a(next.substring(5)))) {
                        sb = new StringBuilder("not match ");
                        C0794q.m887a((Object) sb.append(next).toString());
                        return false;
                    }
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m1156a(JSONObject jSONObject, Object obj) {
        JSONArray optJSONArray = jSONObject.optJSONArray("values");
        if (optJSONArray.length() == 0) {
            return false;
        }
        String optString = jSONObject.optString(AirActionConstant.ActionId.ACTION_ID_OPERATOR);
        String valueOf = String.valueOf(obj);
        if (optString.equals("=")) {
            return valueOf.equals(String.valueOf(optJSONArray.opt(0)));
        }
        if (optString.equals("in")) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (String.valueOf(optJSONArray.opt(i)).equals(valueOf)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private static JSONArray m1157b(JSONArray jSONArray, C0825f c0825f) {
        JSONArray jSONArray2 = new JSONArray();
        if (C0789l.m821a(jSONArray)) {
            return jSONArray2;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                C0738c.m435a();
                C0738c.m436a("NPTH_CATCH", new IllegalArgumentException("err config: " + jSONArray));
            } else if (m1155a(optJSONObject, c0825f)) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    /* renamed from: b */
    public static JSONObject m1158b(JSONObject jSONObject) {
        StringBuilder sb;
        Iterator<String> keys = jSONObject.keys();
        C0825f c0825f = new C0825f();
        JSONObject jSONObject2 = new JSONObject();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"configType".equals(next)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject == null) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", new IllegalArgumentException("err config with key: " + next));
                } else {
                    if (m1154a(optJSONObject.optJSONArray("disable"), c0825f)) {
                        sb = new StringBuilder("match diable ");
                    } else {
                        JSONArray m1157b = m1157b(optJSONObject.optJSONArray(StrategyConstants.ENABLE), c0825f);
                        if (C0789l.m821a(m1157b)) {
                            sb = new StringBuilder("not match ");
                        } else {
                            try {
                                jSONObject2.put(next, new JSONObject().put(StrategyConstants.ENABLE, m1157b));
                            } catch (JSONException unused) {
                            }
                        }
                    }
                    C0794q.m887a((Object) sb.append(next).toString());
                }
            }
        }
        return jSONObject2;
    }
}
