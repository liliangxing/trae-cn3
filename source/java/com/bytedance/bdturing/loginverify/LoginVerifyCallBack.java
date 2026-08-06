package com.bytedance.bdturing.loginverify;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface LoginVerifyCallBack {
    void onFail(int i, JSONObject jSONObject);

    void onSuccess(String str);
}
