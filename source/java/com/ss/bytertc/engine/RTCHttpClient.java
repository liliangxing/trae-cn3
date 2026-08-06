package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public interface RTCHttpClient {

    /* loaded from: classes7.dex */
    public interface RtcHttpCallback {
        void run(int code, String data);
    }

    void GetAsync(String url, RtcHttpCallback callback, int timeoutMillisecond);

    void PostAsync(String url, String content, RtcHttpCallback callback, int timeoutMillisecond);
}
