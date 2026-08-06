package com.bytedance.bdinstall.util;

/* loaded from: classes3.dex */
public abstract class InstanceHolder<T> {
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
