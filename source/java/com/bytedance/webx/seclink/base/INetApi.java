package com.bytedance.webx.seclink.base;

import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface INetApi {

    /* loaded from: classes6.dex */
    public interface NetListener {
        void onFail(String str);

        void onSuccess(String str);
    }

    String execute(String str, JSONObject jSONObject) throws Exception;

    void post(String str, JSONObject jSONObject, NetListener netListener);
}
