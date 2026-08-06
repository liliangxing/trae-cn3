package com.bytedance.bdturing.loginverify;

import android.app.Activity;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ILoginVerifyDepend {
    void startLogin(Activity activity, JSONObject jSONObject, LoginVerifyCallBack loginVerifyCallBack);
}
