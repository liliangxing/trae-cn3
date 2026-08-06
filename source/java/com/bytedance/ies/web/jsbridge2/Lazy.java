package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public abstract class Lazy<T> {
    private volatile boolean hasInitialized = false;
    private volatile boolean hasSetInitialValue = false;
    private T value;

    protected abstract T initialValue();

    public T get() {
        if (this.value != null || this.hasInitialized) {
            return this.value;
        }
        return setInitialValue();
    }

    public void set(T t) {
        this.value = t;
        this.hasInitialized = true;
    }

    public boolean hasInitialized() {
        return this.hasInitialized;
    }

    private T setInitialValue() {
        if (this.hasSetInitialValue) {
            return this.value;
        }
        synchronized (this) {
            if (this.hasSetInitialValue) {
                return this.value;
            }
            this.value = initialValue();
            this.hasSetInitialValue = true;
            return this.value;
        }
    }
}
