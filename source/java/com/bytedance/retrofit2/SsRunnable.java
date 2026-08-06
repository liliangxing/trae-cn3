package com.bytedance.retrofit2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface SsRunnable extends Runnable {
    int getRequestDelayTime();

    RetrofitMetrics getRetrofitMetrics();

    boolean isStreaming();

    int priority();
}
