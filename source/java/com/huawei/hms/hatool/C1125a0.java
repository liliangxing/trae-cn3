package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.common.util.ByteConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.a0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1125a0 implements InterfaceRunnableC1142g {

    /* renamed from: a */
    private Context f1397a = AbstractC1173q0.m1707i();

    /* renamed from: b */
    private String f1398b;

    /* renamed from: c */
    private JSONObject f1399c;

    /* renamed from: d */
    private String f1400d;

    /* renamed from: e */
    private String f1401e;

    /* renamed from: f */
    private String f1402f;

    /* renamed from: g */
    private String f1403g;

    /* renamed from: h */
    private Boolean f1404h;

    public C1125a0(String str, JSONObject jSONObject, String str2, String str3, long j) {
        this.f1398b = str;
        this.f1399c = jSONObject;
        this.f1400d = str2;
        this.f1401e = str3;
        this.f1402f = String.valueOf(j);
        if (AbstractC1190z.m1825i(str2, "oper")) {
            C1170p0 m1813a = C1188y.m1811a().m1813a(str2, j);
            this.f1403g = m1813a.m1676a();
            this.f1404h = Boolean.valueOf(m1813a.m1678b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        C1182v.m1775a("hmsSdk", "Begin to run EventRecordTask...");
        int m1705h = AbstractC1173q0.m1705h();
        int m1424k = AbstractC1126a1.m1424k(this.f1400d, this.f1401e);
        if (C1131c0.m1454a(this.f1397a, "stat_v2_1", m1705h * ByteConstants.f354MB)) {
            C1182v.m1781c("hmsSdk", "stat sp file reach max limited size, delete it");
            C1133d.m1466a(this.f1397a, "stat_v2_1", new String[0]);
            return;
        }
        C1129b1 c1129b1 = new C1129b1();
        c1129b1.m1443b(this.f1398b);
        c1129b1.m1440a(this.f1399c.toString());
        c1129b1.m1447d(this.f1401e);
        c1129b1.m1445c(this.f1402f);
        c1129b1.m1449f(this.f1403g);
        Boolean bool = this.f1404h;
        c1129b1.m1448e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject m1446d = c1129b1.m1446d();
            String m1648a = AbstractC1165n1.m1648a(this.f1400d, this.f1401e);
            String m1464a = C1133d.m1464a(this.f1397a, "stat_v2_1", m1648a, "");
            try {
                jSONArray = !TextUtils.isEmpty(m1464a) ? new JSONArray(m1464a) : new JSONArray();
            } catch (JSONException unused) {
                C1182v.m1783d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(m1446d);
            C1133d.m1469b(this.f1397a, "stat_v2_1", m1648a, jSONArray.toString());
            if (jSONArray.toString().length() > m1424k * 1024) {
                C1136e.m1472a().m1479a(this.f1400d, this.f1401e);
            }
        } catch (JSONException unused2) {
            C1182v.m1785e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
