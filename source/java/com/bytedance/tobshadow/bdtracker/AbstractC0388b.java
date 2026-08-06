package com.bytedance.tobshadow.bdtracker;

/* renamed from: com.bytedance.tobshadow.bdtracker.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0388b<T> {

    /* renamed from: a */
    public volatile T f451a;

    /* renamed from: a */
    public abstract T mo276a(Object... objArr);

    /* renamed from: b */
    public final T m277b(Object... objArr) {
        if (this.f451a == null) {
            synchronized (this) {
                if (this.f451a == null) {
                    this.f451a = mo276a(objArr);
                }
            }
        }
        return this.f451a;
    }
}
