package com.bytedance.ies.web.jsbridge2;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IXBridgeStatefulProxy<R> {

    /* loaded from: classes4.dex */
    public interface Callback {
        void onFailed(Throwable th);

        void onRawResult(JSONObject jSONObject);

        void onSucceed(Object obj);
    }

    Callback getCallBack();

    CallContext getCallContext();
}
