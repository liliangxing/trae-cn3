package com.bytedance.helios.statichook.api;

/* loaded from: classes3.dex */
public interface ActionInvoker {
    void postInvoke(int i, String str, String str2, Object obj, Object[] objArr, Object obj2, ExtraInfo extraInfo, boolean z);

    Result preInvoke(int i, String str, String str2, Object obj, Object[] objArr, String str3, ExtraInfo extraInfo);
}
