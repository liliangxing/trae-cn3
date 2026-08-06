package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxUIMethodInvoker<T extends LynxBaseUI> {
    void invoke(T t, String str, ReadableMap readableMap, Callback callback);
}
