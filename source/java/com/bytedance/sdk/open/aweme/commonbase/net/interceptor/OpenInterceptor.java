package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;

/* loaded from: classes5.dex */
public interface OpenInterceptor {

    /* loaded from: classes5.dex */
    public interface Chain {
        OpenHostResponse proceed(OpenHostRequest openHostRequest) throws Exception;

        OpenHostRequest request();
    }

    OpenHostResponse intercept(Chain chain) throws Exception;
}
