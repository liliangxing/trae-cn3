package com.monitor.cloudmessage.callback;

/* loaded from: classes7.dex */
public interface IABTestConsumer extends IConsumerResultCallback {
    boolean isUpdateABTestInfoInSP();

    void notifyABTestModelUpdate(String str, Object obj);

    void notifyABTestSPUpdate(String str, Object obj);
}
