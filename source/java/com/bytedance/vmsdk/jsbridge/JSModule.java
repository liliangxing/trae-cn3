package com.bytedance.vmsdk.jsbridge;

import android.content.Context;

/* loaded from: classes6.dex */
public abstract class JSModule {
    protected Context mContext;
    protected Object mParam;

    public JSModule(Context context) {
        this(context, null);
    }

    public JSModule(Context context, Object obj) {
        this.mContext = context;
        this.mParam = obj;
    }
}
