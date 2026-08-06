package com.bytedance.apm6.foundation.safety;

/* loaded from: classes3.dex */
public class ApmInternalException extends Exception {
    public ApmInternalException() {
    }

    public ApmInternalException(String str) {
        super(str);
    }

    public ApmInternalException(String str, Throwable th) {
        super(str, th);
    }

    public ApmInternalException(Throwable th) {
        super(th);
    }
}
