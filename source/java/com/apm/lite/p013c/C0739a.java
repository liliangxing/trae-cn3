package com.apm.lite.p013c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apm.lite.C0749e;
import com.apm.lite.p013c.p014a.C0740a;
import com.apm.lite.p013c.p015b.C0743b;
import com.apm.lite.p023k.C0794q;

/* renamed from: com.apm.lite.c.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0739a {

    /* renamed from: a */
    private static volatile C0739a f393a;

    /* renamed from: b */
    private C0743b f394b;

    /* renamed from: c */
    private SQLiteDatabase f395c;

    private C0739a() {
    }

    /* renamed from: a */
    public static C0739a m438a() {
        if (f393a == null) {
            synchronized (C0739a.class) {
                if (f393a == null) {
                    f393a = new C0739a();
                }
            }
        }
        return f393a;
    }

    /* renamed from: b */
    private void m439b() {
        if (this.f394b == null) {
            m440a(C0749e.m565g());
        }
    }

    /* renamed from: a */
    public synchronized void m440a(Context context) {
        try {
            this.f395c = new C0741b(context).getWritableDatabase();
        } catch (Throwable th) {
            C0794q.m893b(th);
        }
        this.f394b = new C0743b();
    }

    /* renamed from: a */
    public synchronized void m441a(C0740a c0740a) {
        m439b();
        C0743b c0743b = this.f394b;
        if (c0743b != null) {
            c0743b.mo447a(this.f395c, c0740a);
        }
    }

    /* renamed from: a */
    public synchronized boolean m442a(String str) {
        m439b();
        C0743b c0743b = this.f394b;
        if (c0743b == null) {
            return false;
        }
        return c0743b.m448a(this.f395c, str);
    }
}
