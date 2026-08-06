package com.huawei.secure.android.common.webview;

/* loaded from: classes6.dex */
public interface WebViewLoadCallBack {

    /* loaded from: classes6.dex */
    public enum ErrorCode {
        HTTP_URL,
        URL_NOT_IN_WHITE_LIST,
        OTHER
    }

    void onCheckError(String str, ErrorCode errorCode);
}
