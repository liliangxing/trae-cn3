package com.bytedance.sdk.account.twiceverify;

import java.util.Map;

/* loaded from: classes5.dex */
public interface TwiceVerifyResultCallback {
    void onFail();

    void onSuccess(String str, String str2, Map<String, String> map, Map<String, Object> map2);
}
