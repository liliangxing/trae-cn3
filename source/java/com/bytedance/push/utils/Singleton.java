package com.bytedance.push.utils;

/* loaded from: classes4.dex */
public abstract class Singleton<T> {
    private volatile T mInstance;

    protected abstract T create(Object... objArr);

    public final void resetInstance() {
        this.mInstance = null;
    }

    public final T get(Object... objArr) {
        if (this.mInstance == null) {
            synchronized (this) {
                if (this.mInstance == null) {
                    this.mInstance = create(objArr);
                }
            }
        }
        return this.mInstance;
    }
}
