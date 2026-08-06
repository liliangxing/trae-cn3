package com.bytedance.retrofit2.ttnet;

import com.bytedance.retrofit2.client.Request;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public interface IHttpCallThrottleControl {
    boolean maybeDropRequestOrAsyncDelay(Request request, Executor executor, Runnable runnable) throws Exception;

    void maybeDropRequestOrBlockingDelay(Request request) throws Exception;

    void notifyRequestCompleted(Request request);

    default Request setOriginalRequestProperties(Request request) {
        return request;
    }
}
