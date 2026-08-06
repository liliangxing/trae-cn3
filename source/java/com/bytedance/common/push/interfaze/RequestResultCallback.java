package com.bytedance.common.push.interfaze;

/* loaded from: classes3.dex */
public interface RequestResultCallback {
    void onRequestResult(boolean z, String str);

    void onUserAgree(boolean z);

    void onUserReject();
}
