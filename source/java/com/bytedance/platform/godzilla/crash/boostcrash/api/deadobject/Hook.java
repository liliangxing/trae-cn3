package com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject;

/* loaded from: classes4.dex */
public abstract class Hook {
    protected Object mRawObject;

    public abstract void onHook();

    protected void setRawObject(Object obj) {
        this.mRawObject = obj;
    }
}
