package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PromiseImpl implements Promise {
    private static final String DEFAULT_ERROR = "EUNSPECIFIED";
    private Callback mReject;
    private Callback mResolve;

    public PromiseImpl(Callback callback, Callback callback2) {
        this.mResolve = callback;
        this.mReject = callback2;
    }

    @Override // com.lynx.jsbridge.Promise
    public void resolve(Object obj) {
        Callback callback = this.mResolve;
        if (callback != null) {
            callback.invoke(obj);
        }
    }

    @Override // com.lynx.jsbridge.Promise
    @Deprecated
    public void reject(String str) {
        reject(DEFAULT_ERROR, str);
    }

    @Override // com.lynx.jsbridge.Promise
    public void reject(String str, String str2) {
        if (this.mReject != null) {
            if (str == null) {
                str = DEFAULT_ERROR;
            }
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putString("code", str);
            javaOnlyMap.putString("message", str2);
            this.mReject.invoke(javaOnlyMap);
        }
    }
}
