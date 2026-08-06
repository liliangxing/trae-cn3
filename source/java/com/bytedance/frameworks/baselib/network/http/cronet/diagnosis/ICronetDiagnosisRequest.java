package com.bytedance.frameworks.baselib.network.http.cronet.diagnosis;

/* loaded from: classes2.dex */
public interface ICronetDiagnosisRequest {

    /* loaded from: classes2.dex */
    public interface Callback {
        void onNetDiagnosisRequestComplete(String str);
    }

    void cancel();

    void doExtraCommand(String str, String str2);

    void start();
}
