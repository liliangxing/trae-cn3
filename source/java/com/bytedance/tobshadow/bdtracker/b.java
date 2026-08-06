package com.bytedance.tobshadow.bdtracker;

/* loaded from: classes5.dex */
public abstract class b<T> {
    public volatile T a;

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = a(objArr);
                }
            }
        }
        return this.a;
    }
}
