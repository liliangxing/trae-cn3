package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.ci */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1529ci implements Comparable<C1529ci> {

    /* renamed from: a */
    protected int f1178a;

    /* renamed from: a */
    private long f1179a;

    /* renamed from: a */
    String f1180a;

    /* renamed from: a */
    private final LinkedList<C1521ca> f1181a;

    public C1529ci() {
        this(null, 0);
    }

    public C1529ci(String str) {
        this(str, 0);
    }

    public C1529ci(String str, int i) {
        this.f1181a = new LinkedList<>();
        this.f1179a = 0L;
        this.f1180a = str;
        this.f1178a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void m1858a(C1521ca c1521ca) {
        if (c1521ca != null) {
            this.f1181a.add(c1521ca);
            int m1774a = c1521ca.m1774a();
            if (m1774a > 0) {
                this.f1178a += c1521ca.m1774a();
            } else {
                int i = 0;
                for (int size = this.f1181a.size() - 1; size >= 0 && this.f1181a.get(size).m1774a() < 0; size--) {
                    i++;
                }
                this.f1178a += m1774a * i;
            }
            if (this.f1181a.size() > 30) {
                this.f1178a -= this.f1181a.remove().m1774a();
            }
        }
    }

    public String toString() {
        return this.f1180a + Constants.COLON_SEPARATOR + this.f1178a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(C1529ci c1529ci) {
        if (c1529ci == null) {
            return 1;
        }
        return c1529ci.f1178a - this.f1178a;
    }

    /* renamed from: a */
    public synchronized JSONObject m1857a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f1179a);
        jSONObject.put("wt", this.f1178a);
        jSONObject.put("host", this.f1180a);
        JSONArray jSONArray = new JSONArray();
        Iterator<C1521ca> it = this.f1181a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m1776a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized C1529ci m1856a(JSONObject jSONObject) {
        this.f1179a = jSONObject.getLong("tt");
        this.f1178a = jSONObject.getInt("wt");
        this.f1180a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f1181a.add(new C1521ca().m1775a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
