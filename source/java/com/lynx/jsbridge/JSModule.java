package com.lynx.jsbridge;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.core.JSProxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JSModule {
    private final String mModuleName;
    private final JSProxy mProxy;

    public JSModule(String str, JSProxy jSProxy) {
        this.mModuleName = str;
        this.mProxy = jSProxy;
    }

    public void fire(String str, JavaOnlyArray javaOnlyArray) {
        if (javaOnlyArray == null) {
            javaOnlyArray = new JavaOnlyArray();
        }
        this.mProxy.callFunction(this.mModuleName, str, javaOnlyArray);
    }
}
