package com.bytedance.bdinstall.util;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class Singleton<T> {
    private final AtomicBoolean isInit = new AtomicBoolean(false);
    private volatile T mInstance;

    protected abstract T create(Object... objArr);

    public final T get(Object... objArr) {
        if (!this.isInit.get() && this.mInstance == null) {
            synchronized (this) {
                if (!this.isInit.get() && this.mInstance == null) {
                    this.mInstance = create(objArr);
                    this.isInit.set(true);
                }
            }
        }
        return this.mInstance;
    }
}
