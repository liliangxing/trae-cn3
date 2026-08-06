package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxGetUIResult {
    private final int errCode;
    private final String errMsg;
    private final JavaOnlyArray uiArray;

    private LynxGetUIResult(JavaOnlyArray javaOnlyArray, int i, String str) {
        this.uiArray = javaOnlyArray;
        this.errCode = i;
        this.errMsg = str;
    }

    public boolean succeed() {
        return this.errCode == 0;
    }

    public ReadableArray getUiArray() {
        return this.uiArray;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    private static LynxGetUIResult create(JavaOnlyArray javaOnlyArray, int i, String str) {
        return new LynxGetUIResult(javaOnlyArray, i, str);
    }
}
