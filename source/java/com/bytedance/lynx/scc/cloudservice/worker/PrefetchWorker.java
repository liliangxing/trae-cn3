package com.bytedance.lynx.scc.cloudservice.worker;

import com.bytedance.lynx.scc.cloudservice.SccCloudServiceManager;
import com.bytedance.lynx.scc.cloudservice.network.UrlRequest;
import com.bytedance.lynx.scc.cloudservice.network.UrlResponse;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class PrefetchWorker implements Callable<UrlResponse> {
    private final int mCSMaxWaitMs;
    private final EventTracker mEventTracker;
    private final String mUrl;

    public PrefetchWorker(String url, int csMaxWaitMs, EventTracker eventTracker) {
        this.mUrl = url;
        this.mCSMaxWaitMs = csMaxWaitMs;
        this.mEventTracker = eventTracker;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public UrlResponse call() {
        this.mEventTracker.onPrefetchStart();
        UrlRequest urlRequest = new UrlRequest(this.mUrl);
        urlRequest.setMethod("GET");
        urlRequest.setParamMap(new HashMap());
        urlRequest.setTimeoutMs(this.mCSMaxWaitMs);
        UrlResponse sendSync = SccCloudServiceManager.getNetAdapter().sendSync(urlRequest, false);
        this.mEventTracker.onPrefetchEnd(sendSync.getStatusCode());
        return sendSync;
    }
}
