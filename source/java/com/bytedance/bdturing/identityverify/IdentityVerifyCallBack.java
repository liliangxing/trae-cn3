package com.bytedance.bdturing.identityverify;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IdentityVerifyCallBack {
    boolean onH5Close(JSONObject jSONObject);

    void onOpenLoginPage();

    boolean progressFinish(int i, JSONObject jSONObject);
}
