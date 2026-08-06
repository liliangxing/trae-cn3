package com.optimize.statistics;

import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface ImageTraceListener {
    @Deprecated
    void imageNetCallBack(long j, long j2, String str, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject);

    void onImageLoaded(boolean z, String str, JSONObject jSONObject);
}
