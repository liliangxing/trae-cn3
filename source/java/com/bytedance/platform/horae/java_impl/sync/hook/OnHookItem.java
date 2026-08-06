package com.bytedance.platform.horae.java_impl.sync.hook;

/* loaded from: classes4.dex */
public abstract class OnHookItem {
    protected String mChanel;
    protected OnHookPointTrigger mOnHookPointTrigger;

    public abstract void onHook();

    public OnHookItem(String str, OnHookPointTrigger onHookPointTrigger) {
        this.mChanel = str;
        this.mOnHookPointTrigger = onHookPointTrigger;
    }
}
