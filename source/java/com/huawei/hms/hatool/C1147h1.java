package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.h1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1147h1 implements InterfaceC1168o1 {

    /* renamed from: a */
    private List<C1129b1> f1465a;

    /* renamed from: b */
    private AbstractC1155k0 f1466b;

    /* renamed from: c */
    private AbstractC1179t0 f1467c;

    /* renamed from: d */
    private InterfaceC1168o1 f1468d;

    /* renamed from: e */
    private String f1469e = "";

    /* renamed from: f */
    private String f1470f;

    public C1147h1(String str) {
        this.f1470f = str;
    }

    @Override // com.huawei.hms.hatool.InterfaceC1168o1
    /* renamed from: a */
    public JSONObject mo1439a() {
        String str;
        List<C1129b1> list = this.f1465a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f1466b == null || this.f1467c == null || this.f1468d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f1466b.mo1439a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject mo1439a = this.f1468d.mo1439a();
            mo1439a.put("properties", this.f1467c.mo1439a());
            try {
                mo1439a.put("events_global_properties", new JSONObject(this.f1469e));
            } catch (JSONException unused) {
                mo1439a.put("events_global_properties", this.f1469e);
            }
            jSONObject2.put("events_common", mo1439a);
            JSONArray jSONArray = new JSONArray();
            Iterator<C1129b1> it = this.f1465a.iterator();
            while (it.hasNext()) {
                JSONObject mo1439a2 = it.next().mo1439a();
                if (mo1439a2 != null) {
                    jSONArray.put(mo1439a2);
                } else {
                    C1182v.m1785e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", jSONArray);
            try {
                String m1641a = C1163n.m1641a(C1156k1.m1601a(jSONObject2.toString().getBytes(Utf8Charset.NAME)), this.f1470f);
                if (TextUtils.isEmpty(m1641a)) {
                    C1182v.m1785e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", m1641a);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        C1182v.m1785e("hmsSdk", str);
        return null;
    }

    /* renamed from: a */
    public void m1552a(AbstractC1155k0 abstractC1155k0) {
        this.f1466b = abstractC1155k0;
    }

    /* renamed from: a */
    public void m1553a(C1157l c1157l) {
        this.f1468d = c1157l;
    }

    /* renamed from: a */
    public void m1554a(AbstractC1179t0 abstractC1179t0) {
        this.f1467c = abstractC1179t0;
    }

    /* renamed from: a */
    public void m1555a(String str) {
        if (str != null) {
            this.f1469e = str;
        }
    }

    /* renamed from: a */
    public void m1556a(List<C1129b1> list) {
        this.f1465a = list;
    }
}
