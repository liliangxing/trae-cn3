package com.bytedance.retrofit2.client;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface SsCall {
    void cancel();

    Response execute() throws IOException;

    Request getRequest();

    boolean setThrottleNetSpeed(long j);
}
