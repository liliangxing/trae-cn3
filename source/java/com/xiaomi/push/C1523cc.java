package com.xiaomi.push;

import android.text.TextUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cc */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1523cc {

    /* renamed from: a */
    private String f1154a;

    /* renamed from: a */
    private final ArrayList<C1522cb> f1155a = new ArrayList<>();

    public C1523cc(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f1154a = str;
    }

    public C1523cc() {
    }

    /* renamed from: a */
    public synchronized void m1805a(C1522cb c1522cb) {
        int i = 0;
        while (true) {
            if (i >= this.f1155a.size()) {
                break;
            }
            if (this.f1155a.get(i).m1794a(c1522cb)) {
                this.f1155a.set(i, c1522cb);
                break;
            }
            i++;
        }
        if (i >= this.f1155a.size()) {
            this.f1155a.add(c1522cb);
        }
    }

    /* renamed from: a */
    public synchronized C1522cb m1800a() {
        for (int size = this.f1155a.size() - 1; size >= 0; size--) {
            C1522cb c1522cb = this.f1155a.get(size);
            if (c1522cb.m1793a()) {
                C1526cf.m1812a().m1827a(c1522cb.m1779a());
                return c1522cb;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1154a);
        sb.append(UpdateDialogNewBase.TYPE);
        Iterator<C1522cb> it = this.f1155a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public ArrayList<C1522cb> m1803a() {
        return this.f1155a;
    }

    /* renamed from: a */
    public synchronized void m1806a(boolean z) {
        for (int size = this.f1155a.size() - 1; size >= 0; size--) {
            C1522cb c1522cb = this.f1155a.get(size);
            if (z) {
                if (c1522cb.m1799c()) {
                    this.f1155a.remove(size);
                }
            } else if (!c1522cb.mo1798b()) {
                this.f1155a.remove(size);
            }
        }
    }

    /* renamed from: a */
    public String m1802a() {
        return this.f1154a;
    }

    /* renamed from: a */
    public synchronized JSONObject m1804a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.f1154a);
        JSONArray jSONArray = new JSONArray();
        Iterator<C1522cb> it = this.f1155a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().m1783a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    /* renamed from: a */
    public synchronized C1523cc m1801a(JSONObject jSONObject) {
        this.f1154a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f1155a.add(new C1522cb(this.f1154a).m1778a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
