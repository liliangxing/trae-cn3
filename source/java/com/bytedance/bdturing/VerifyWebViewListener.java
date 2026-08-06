package com.bytedance.bdturing;

/* loaded from: classes3.dex */
public interface VerifyWebViewListener {
    void onLoadPageFail(int i, String str);

    void onLoadPageSuccess();

    void onReceivedError(int i, String str, String str2);
}
