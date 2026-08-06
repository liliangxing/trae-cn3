package com.bytedance.retrofit2;

import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes4.dex */
public interface LegacyLogRecorder {
    @Deprecated
    void generateOldFormatLog(JSONObject jSONObject) throws JSONException;

    @Deprecated
    void setAccountRetryCallbackDuration(long j);

    @Deprecated
    void setBdTuringCallbackDuration(long j);

    @Deprecated
    void setKernelDns(long j);

    @Deprecated
    void setKernelPush(long j);

    @Deprecated
    void setKernelReceiveBody(long j);

    @Deprecated
    void setKernelSend(long j);

    @Deprecated
    void setKernelTCPConnect(long j);

    @Deprecated
    void setKernelTTFB(long j);

    @Deprecated
    void setKernelTls(long j);

    @Deprecated
    void setKernelTotal(long j);

    @Deprecated
    void setNetworkKernelRawRequestLog(String str);

    @Deprecated
    void setRequestEnd(long j);

    @Deprecated
    void setRequestEndAppResumeState(long j);
}
