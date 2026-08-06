package com.bytedance.router;

/* loaded from: classes4.dex */
public interface OpenResultCallback {
    void onActionResult(Object obj);

    void onFail(String str, String str2);

    void onIntercept(String str);

    void onMatched(String str);

    void onMissed(String str);

    void onSuccess();
}
