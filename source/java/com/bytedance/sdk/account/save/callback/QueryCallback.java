package com.bytedance.sdk.account.save.callback;

import com.bytedance.sdk.account.save.entity.LoginInfo;

/* loaded from: classes5.dex */
public interface QueryCallback {
    void onError(int i, String str);

    void onSuccess(LoginInfo loginInfo);
}
