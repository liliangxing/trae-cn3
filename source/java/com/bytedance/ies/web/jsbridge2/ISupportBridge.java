package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public interface ISupportBridge {
    void importFrom(ISupportBridge iSupportBridge);

    void onRegisterMethod(String str);

    void onUnregisterMethod(String str);
}
