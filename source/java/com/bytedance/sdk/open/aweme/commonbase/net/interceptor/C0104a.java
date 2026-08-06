package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.sdk.open.aweme.commonbase.net.C0102a;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;

/* renamed from: com.bytedance.sdk.open.aweme.commonbase.net.interceptor.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0104a implements OpenInterceptor {
    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor
    public OpenHostResponse intercept(OpenInterceptor.Chain chain) {
        OpenHostRequest request = chain.request();
        OpenNetworkService openNetworkService = (OpenNetworkService) OpenServiceManager.getInst().getService(OpenNetworkService.class);
        if (openNetworkService == null) {
            openNetworkService = new C0102a();
        }
        return openNetworkService.newCall(request).execute();
    }
}
