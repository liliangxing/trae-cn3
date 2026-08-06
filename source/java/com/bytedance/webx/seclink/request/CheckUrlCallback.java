package com.bytedance.webx.seclink.request;

/* loaded from: classes6.dex */
public interface CheckUrlCallback {
    void onFail(String str, String str2);

    void onSuccess(String str, CheckUrlResponse checkUrlResponse);
}
