package com.vivo.push.restructure.p019a.p020a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.util.C1380g;
import com.vivo.push.util.C1393t;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMessageNodeMonitor.java */
/* renamed from: com.vivo.push.restructure.a.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1315a<T> {

    /* renamed from: a */
    protected T f559a;

    /* renamed from: b */
    private String f560b;

    /* renamed from: e */
    private InterfaceC1323i f563e;

    /* renamed from: g */
    private AbstractC1315a f565g;

    /* renamed from: c */
    private long f561c = -1;

    /* renamed from: d */
    private int f562d = -1;

    /* renamed from: f */
    private boolean f564f = false;

    /* renamed from: a */
    protected abstract int mo834a(T t);

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TT;Lcom/vivo/push/restructure/a/a/i;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC1315a(String str, InterfaceC1314a interfaceC1314a, C1324j c1324j) {
        this.f560b = str;
        this.f559a = interfaceC1314a;
        this.f563e = c1324j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m833d() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f562d = mo834a((AbstractC1315a<T>) this.f559a);
        this.f561c = System.currentTimeMillis() - currentTimeMillis;
        int i = this.f562d;
        if (i != 0) {
            InterfaceC1323i interfaceC1323i = this.f563e;
            if (interfaceC1323i != null) {
                interfaceC1323i.mo844a(this, this.f559a, i);
                return;
            }
            return;
        }
        AbstractC1315a abstractC1315a = this.f565g;
        if (abstractC1315a != null) {
            abstractC1315a.m835a();
            return;
        }
        InterfaceC1323i interfaceC1323i2 = this.f563e;
        if (interfaceC1323i2 != null) {
            interfaceC1323i2.mo846a((InterfaceC1323i) this.f559a);
        }
    }

    /* renamed from: b */
    public synchronized String mo838b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f560b);
            jSONObject.put(MonitorConstants.CODE, this.f562d);
            jSONObject.put("cost", this.f561c);
        } catch (Exception e) {
            C1393t.m1036a("AbstractMessageNodeMoni", e);
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public final void m837a(AbstractC1315a abstractC1315a) {
        if (this != abstractC1315a) {
            this.f565g = abstractC1315a;
        }
    }

    /* renamed from: a */
    public final void m836a(long j) {
        this.f561c = j;
    }

    /* renamed from: c */
    public final JSONArray m839c() {
        JSONArray jSONArray = new JSONArray();
        for (AbstractC1315a<T> abstractC1315a = this; abstractC1315a != null; abstractC1315a = abstractC1315a.f565g) {
            try {
                jSONArray.put(abstractC1315a.mo838b());
            } catch (Exception e) {
                C1393t.m1036a("AbstractMessageNodeMoni", e);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public final void m835a() {
        if (this.f564f) {
            C1380g.m996a().execute(new RunnableC1316b(this));
        } else {
            m833d();
        }
    }
}
