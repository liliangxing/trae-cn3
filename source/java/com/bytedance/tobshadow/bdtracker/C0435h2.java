package com.bytedance.tobshadow.bdtracker;

import android.accounts.Account;
import android.content.Context;

/* renamed from: com.bytedance.tobshadow.bdtracker.h2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0435h2 {

    /* renamed from: a */
    public volatile C0466l5 f647a;

    /* renamed from: b */
    public Account f648b;

    /* renamed from: c */
    public C0472m4 f649c;

    /* renamed from: a */
    public C0466l5 m454a(C0467m c0467m, Context context, C0407d2 c0407d2) {
        if (this.f647a == null) {
            synchronized (C0435h2.class) {
                if (this.f647a == null) {
                    if (context == null) {
                        throw new IllegalArgumentException("context == null");
                    }
                    if (this.f649c == null) {
                        this.f649c = new C0472m4(c0467m, context);
                    }
                    if (this.f647a == null) {
                        this.f647a = new C0466l5(c0467m, context, c0407d2, this.f649c);
                        if (this.f648b != null) {
                            this.f647a.m510a(this.f648b);
                        }
                    }
                }
            }
        }
        return this.f647a;
    }
}
