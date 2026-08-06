package com.bytedance.helios.statichook.api;

/* loaded from: classes3.dex */
public class Result {
    private boolean intercept;
    private Object returnValue;

    public Result(boolean z, Object obj) {
        this.intercept = z;
        this.returnValue = obj;
    }

    public boolean isIntercept() {
        return this.intercept;
    }

    public void setIntercept(boolean z) {
        this.intercept = z;
    }

    public Object getReturnValue() {
        return this.returnValue;
    }

    public void setReturnValue(Object obj) {
        this.returnValue = obj;
    }
}
