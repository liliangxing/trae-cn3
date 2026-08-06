package com.bytedance.vmsdk.jsbridge;

/* loaded from: classes6.dex */
public interface Promise {
    @Deprecated
    void reject(String str);

    void reject(String str, String str2);

    void resolve(Object obj);
}
