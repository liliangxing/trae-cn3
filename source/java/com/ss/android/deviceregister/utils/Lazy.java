package com.ss.android.deviceregister.utils;

/* loaded from: classes7.dex */
public abstract class Lazy<T> {
    private volatile boolean hasSetValue = false;
    private volatile T value;

    protected abstract T initialValue();

    public T get() {
        if (this.value != null) {
            return this.value;
        }
        return setInitialValue();
    }

    public void set(T t) {
        this.value = t;
        this.hasSetValue = true;
    }

    public boolean hasInitialized() {
        return this.hasSetValue;
    }

    private T setInitialValue() {
        if (this.value != null) {
            return this.value;
        }
        synchronized (this) {
            if (this.value != null) {
                return this.value;
            }
            this.value = initialValue();
            return this.value;
        }
    }
}
