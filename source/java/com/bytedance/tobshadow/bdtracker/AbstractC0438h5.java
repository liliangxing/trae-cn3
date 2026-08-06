package com.bytedance.tobshadow.bdtracker;

/* renamed from: com.bytedance.tobshadow.bdtracker.h5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0438h5<T> {

    /* renamed from: a */
    public volatile T f657a;

    /* renamed from: a */
    public abstract T mo455a(Object... objArr);

    /* renamed from: b */
    public final T m456b(Object... objArr) {
        if (this.f657a == null) {
            synchronized (this) {
                if (this.f657a == null) {
                    this.f657a = mo455a(objArr);
                }
            }
        }
        return this.f657a;
    }
}
