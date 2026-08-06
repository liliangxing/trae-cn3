package com.lynx.jsbridge;

import android.content.Context;
import com.lynx.react.bridge.JavaOnlyArray;

/* loaded from: classes6.dex */
public abstract class LynxModule {
    protected Context mContext;
    protected Object mExtraData;
    protected Object mParam;

    /* loaded from: classes6.dex */
    public interface AuthValidator {
        boolean verify(String str, String str2, JavaOnlyArray javaOnlyArray);
    }

    public void destroy() {
    }

    public LynxModule(Context context) {
        this(context, null);
    }

    public LynxModule(Context context, Object obj) {
        this.mContext = context;
        this.mParam = obj;
    }

    public void setExtraData(Object obj) {
        this.mExtraData = obj;
    }
}
