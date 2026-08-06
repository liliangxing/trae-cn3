package com.bytedance.mt.protector;

/* loaded from: classes4.dex */
public class ThrowableDisposerResult {
    private int ResultType;
    private Object result;

    public ThrowableDisposerResult(int i, Object obj) {
        this.ResultType = i;
        this.result = obj;
    }

    public int getResultType() {
        return this.ResultType;
    }

    public Object getResult() {
        return this.result;
    }
}
