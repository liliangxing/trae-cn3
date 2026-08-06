package com.ss.android.ugc.quota;

/* loaded from: classes7.dex */
public class Lazy<T> {
    private volatile boolean hasInitialized = false;
    private volatile boolean hasSetInitialValue = false;
    private T value;

    protected T initialValue() {
        return null;
    }

    public T get() {
        T t = this.value;
        return t != null ? t : setInitialValue();
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
