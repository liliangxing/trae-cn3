package com.bytedance.ies.uikit.util;

import com.bytedance.ies.uikit.layout.ICallBack;

/* loaded from: classes4.dex */
public class SafeViewManager {
    public static boolean SafeViewSetting;
    private static ICallBack callBack;

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static ICallBack getCallBack() {
        return callBack;
    }
}
