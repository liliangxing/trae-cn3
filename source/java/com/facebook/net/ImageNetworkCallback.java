package com.facebook.net;

import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface ImageNetworkCallback {
    void onImageErrorCallBack(long j, long j2, ResponseWrap responseWrap, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject);

    void onImageOkCallBack(long j, long j2, ResponseWrap responseWrap, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject);
}
