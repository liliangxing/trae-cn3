package com.bytedance.common.wschannel.channel.impl.p007ok.policy;

import okhttp3.Response;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface RetryPolicy {
    public static final long CANCEL = -1;

    long getRandomInterval();

    long getRetryIntervalWithResponse(Response response);

    void reset();
}
