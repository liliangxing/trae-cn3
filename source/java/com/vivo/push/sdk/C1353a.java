package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.AbstractC1202ab;
import com.vivo.push.restructure.p019a.C1330b;
import com.vivo.push.util.C1380g;
import com.vivo.push.util.C1393t;

/* compiled from: CommandWorker.java */
/* renamed from: com.vivo.push.sdk.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1353a extends AbstractC1202ab {

    /* renamed from: c */
    private static C1353a f628c;

    /* renamed from: d */
    private String f629d = "";

    private C1353a() {
    }

    /* renamed from: a */
    public static synchronized C1353a m908a() {
        C1353a c1353a;
        synchronized (C1353a.class) {
            if (f628c == null) {
                f628c = new C1353a();
            }
            c1353a = f628c;
        }
        return c1353a;
    }

    /* renamed from: a */
    public final void m911a(String str) {
        this.f629d = str;
    }

    /* renamed from: b */
    public final String m912b() {
        return this.f629d;
    }

    /* renamed from: a */
    public final void m910a(Intent intent) {
        if (intent == null || this.f327a == null) {
            C1393t.m1048d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.f327a);
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = intent;
        m580a(obtain);
    }

    @Override // com.vivo.push.AbstractC1202ab
    /* renamed from: b */
    public final void mo581b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent == null || this.f327a == null) {
            C1393t.m1048d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.f327a);
            return;
        }
        C1330b c1330b = new C1330b(intent);
        try {
            C1393t.m1048d("CommandWorker", "received msg : ".concat(String.valueOf(c1330b.mo819a())));
            C1380g.m996a().execute(new RunnableC1354b(this, c1330b));
        } catch (Exception e) {
            C1393t.m1034a("CommandWorker", "handle message err : " + e.getMessage());
        }
    }
}
