package com.bytedance.crash;

import com.bytedance.crash.service.IHttpService;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;

/* loaded from: classes3.dex */
public class NpthNetworkApi {
    private static IRequestHeaderProvider headerProvider;
    private static IHttpService httpService;
    private static INetworkCallback networkCallback;

    public static void setHttpService(IHttpService iHttpService) {
        httpService = iHttpService;
    }

    public static IHttpService getHttpService() {
        return httpService;
    }

    public static void setRequestHeaderProvider(IRequestHeaderProvider iRequestHeaderProvider) {
        headerProvider = iRequestHeaderProvider;
    }

    public static IRequestHeaderProvider getRequestHeaderProvider() {
        return headerProvider;
    }

    public static void setNetworkCallback(INetworkCallback iNetworkCallback) {
        networkCallback = iNetworkCallback;
    }

    public static INetworkCallback getNetworkCallback() {
        return networkCallback;
    }
}
