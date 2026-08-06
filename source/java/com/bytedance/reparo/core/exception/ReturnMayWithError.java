package com.bytedance.reparo.core.exception;

import java.lang.Throwable;

/* loaded from: classes4.dex */
public class ReturnMayWithError<V, T extends Throwable> {
    private T mError;
    private V mReturnValue;

    public ReturnMayWithError(V v, T t) {
        this.mError = t;
        this.mReturnValue = v;
    }

    public V getValueIgnoreError() {
        return this.mReturnValue;
    }

    public V getValueMayError() throws Throwable {
        T t = this.mError;
        if (t != null) {
            throw t;
        }
        return this.mReturnValue;
    }
}
