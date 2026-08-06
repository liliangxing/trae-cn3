package com.vivo.push.restructure.request.p023a.p024a;

import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: JsonParcel.java */
/* renamed from: com.vivo.push.restructure.request.a.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1341a {

    /* renamed from: a */
    private int f606a;

    /* renamed from: b */
    private int f607b;

    /* renamed from: c */
    private JSONArray f608c;

    public C1341a() {
        this.f606a = 0;
        this.f608c = new JSONArray();
    }

    public C1341a(String str) throws JSONException {
        this.f606a = 0;
        JSONArray jSONArray = new JSONArray(str);
        this.f608c = jSONArray;
        this.f606a = 0;
        this.f607b = jSONArray.length();
    }

    /* renamed from: a */
    public final void m887a(int i) {
        this.f608c.put(i);
    }

    /* renamed from: a */
    public final void m888a(long j) {
        this.f608c.put(j);
    }

    /* renamed from: a */
    public final void m890a(String str) {
        this.f608c.put(str);
    }

    /* renamed from: a */
    public final void m892a(boolean z) {
        this.f608c.put(z);
    }

    /* renamed from: a */
    public final <T extends InterfaceC1343c> void m891a(List<T> list) {
        if (list != null) {
            this.f608c.put(list.size());
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                this.f608c.put(it.next().mo677a());
            }
            return;
        }
        this.f608c.put((Object) null);
    }

    /* renamed from: a */
    public final int m886a() throws JSONException {
        int i = this.f606a;
        if (i >= this.f607b) {
            return 0;
        }
        JSONArray jSONArray = this.f608c;
        this.f606a = i + 1;
        return jSONArray.getInt(i);
    }

    /* renamed from: b */
    public final long m893b() throws JSONException {
        int i = this.f606a;
        if (i >= this.f607b) {
            return 0L;
        }
        JSONArray jSONArray = this.f608c;
        this.f606a = i + 1;
        return jSONArray.getLong(i);
    }

    /* renamed from: c */
    public final String m894c() throws JSONException {
        int i = this.f606a;
        if (i >= this.f607b) {
            return null;
        }
        JSONArray jSONArray = this.f608c;
        this.f606a = i + 1;
        return jSONArray.getString(i);
    }

    /* renamed from: d */
    public final boolean m895d() throws JSONException {
        int i = this.f606a;
        if (i >= this.f607b) {
            return false;
        }
        JSONArray jSONArray = this.f608c;
        this.f606a = i + 1;
        return jSONArray.getBoolean(i);
    }

    /* renamed from: e */
    public final String m896e() {
        JSONArray jSONArray = this.f608c;
        return jSONArray != null ? jSONArray.toString() : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final <T extends InterfaceC1343c> void m889a(InterfaceC1343c.a<T> aVar, List<T> list) throws JSONException {
        InterfaceC1343c interfaceC1343c;
        int i = this.f606a;
        if (i < this.f607b ? this.f608c.isNull(i) : true) {
            this.f606a++;
            return;
        }
        JSONArray jSONArray = this.f608c;
        int i2 = this.f606a;
        this.f606a = i2 + 1;
        int i3 = jSONArray.getInt(i2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.f606a;
            if (i5 < this.f607b) {
                JSONArray jSONArray2 = this.f608c;
                this.f606a = i5 + 1;
                interfaceC1343c = aVar.mo682a(jSONArray2.getString(i5));
            } else {
                interfaceC1343c = null;
            }
            list.add(interfaceC1343c);
        }
    }
}
