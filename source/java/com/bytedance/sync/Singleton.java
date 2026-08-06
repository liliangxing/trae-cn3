package com.bytedance.sync;

/* loaded from: classes5.dex */
public abstract class Singleton<T> {
    private volatile T mInstance;

    protected abstract T create(Object... objArr);

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
