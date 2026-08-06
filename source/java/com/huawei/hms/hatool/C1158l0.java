package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.l0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1158l0 {

    /* renamed from: a */
    private String f1505a;

    /* renamed from: b */
    private String f1506b;

    /* renamed from: c */
    private String f1507c;

    /* renamed from: d */
    private List<C1129b1> f1508d;

    /* renamed from: e */
    private String f1509e;

    public C1158l0(String str, String str2, String str3, List<C1129b1> list, String str4) {
        this.f1505a = str;
        this.f1506b = str2;
        this.f1507c = str3;
        this.f1508d = list;
        this.f1509e = str4;
    }

    /* renamed from: a */
    private String m1608a(String str, String str2) {
        String str3;
        String m1419f = AbstractC1126a1.m1419f(str, str2);
        if (TextUtils.isEmpty(m1419f)) {
            C1182v.m1776a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else {
            if (!"diffprivacy".equals(str2)) {
                return "";
            }
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", m1419f);
    }

    /* renamed from: a */
    private byte[] m1609a(C1147h1 c1147h1) {
        String str;
        try {
            JSONObject mo1439a = c1147h1.mo1439a();
            if (mo1439a != null) {
                return C1156k1.m1601a(mo1439a.toString().getBytes(Utf8Charset.NAME));
            }
            C1182v.m1785e("hmsSdk", "uploadEvents is null");
            return new byte[0];
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            C1182v.m1785e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            C1182v.m1785e("hmsSdk", str);
            return new byte[0];
        }
    }

    /* renamed from: b */
    private void m1610b() {
        if (C1131c0.m1454a(AbstractC1173q0.m1707i(), "backup_event", 5242880)) {
            C1182v.m1783d("hmsSdk", "backup file reach max limited size, delete it");
            C1133d.m1466a(AbstractC1173q0.m1707i(), "backup_event", new String[0]);
        } else {
            JSONArray m1611c = m1611c();
            String m1649a = AbstractC1165n1.m1649a(this.f1505a, this.f1506b, this.f1509e);
            C1182v.m1781c("hmsSdk", "Update data cached into backup,spKey: " + m1649a);
            C1133d.m1469b(AbstractC1173q0.m1707i(), "backup_event", m1649a, m1611c.toString());
        }
    }

    /* renamed from: c */
    private JSONArray m1611c() {
        JSONArray jSONArray = new JSONArray();
        Iterator<C1129b1> it = this.f1508d.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next().m1446d());
            } catch (JSONException unused) {
                C1182v.m1781c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    /* renamed from: d */
    private C1147h1 m1612d() {
        return C1154k.m1585a(this.f1508d, this.f1505a, this.f1506b, this.f1509e, this.f1507c);
    }

    /* renamed from: a */
    public void m1613a() {
        InterfaceRunnableC1142g c1135d1;
        C1128b0 m1437c;
        String str;
        String m1608a = m1608a(this.f1505a, this.f1506b);
        if (!TextUtils.isEmpty(m1608a) || "preins".equals(this.f1506b)) {
            if (!"_hms_config_tag".equals(this.f1505a) && !"_openness_config_tag".equals(this.f1505a)) {
                m1610b();
            }
            C1147h1 m1612d = m1612d();
            if (m1612d != null) {
                byte[] m1609a = m1609a(m1612d);
                if (m1609a.length == 0) {
                    str = "request body is empty";
                } else {
                    c1135d1 = new C1139f(m1609a, m1608a, this.f1505a, this.f1506b, this.f1509e, this.f1508d);
                    m1437c = C1128b0.m1436b();
                }
            } else {
                c1135d1 = new C1135d1(this.f1508d, this.f1505a, this.f1509e, this.f1506b);
                m1437c = C1128b0.m1437c();
            }
            m1437c.m1438a(c1135d1);
            return;
        }
        str = "collectUrl is empty";
        C1182v.m1785e("hmsSdk", str);
    }
}
