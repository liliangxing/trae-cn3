package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
class ci implements Comparable<ci> {
    protected int a;

    /* renamed from: a, reason: collision with other field name */
    private long f255a;

    /* renamed from: a, reason: collision with other field name */
    String f256a;

    /* renamed from: a, reason: collision with other field name */
    private final LinkedList<ca> f257a;

    public ci() {
        this(null, 0);
    }

    public ci(String str) {
        this(str, 0);
    }

    public ci(String str, int i) {
        this.f257a = new LinkedList<>();
        this.f255a = 0L;
        this.f256a = str;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void a(ca caVar) {
        if (caVar != null) {
            this.f257a.add(caVar);
            int a = caVar.a();
            if (a > 0) {
                this.a += caVar.a();
            } else {
                int i = 0;
                for (int size = this.f257a.size() - 1; size >= 0 && this.f257a.get(size).a() < 0; size--) {
                    i++;
                }
                this.a += a * i;
            }
            if (this.f257a.size() > 30) {
                this.a -= this.f257a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f256a + Constants.COLON_SEPARATOR + this.a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ci ciVar) {
        if (ciVar == null) {
            return 1;
        }
        return ciVar.a - this.a;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f255a);
        jSONObject.put("wt", this.a);
        jSONObject.put("host", this.f256a);
        JSONArray jSONArray = new JSONArray();
        Iterator<ca> it = this.f257a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m9695a());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    public synchronized ci a(JSONObject jSONObject) {
        this.f255a = jSONObject.getLong("tt");
        this.a = jSONObject.getInt("wt");
        this.f256a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f257a.add(new ca().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
