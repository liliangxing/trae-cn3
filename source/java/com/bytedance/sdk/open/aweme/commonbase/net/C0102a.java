package com.bytedance.sdk.open.aweme.commonbase.net;

import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.core.net.OpenNetHeaders;

/* renamed from: com.bytedance.sdk.open.aweme.commonbase.net.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0102a implements OpenNetworkService {

    /* renamed from: com.bytedance.sdk.open.aweme.commonbase.net.a$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private class b implements IOpenHostNetCall {

        /* renamed from: a */
        private OpenHostRequest f40a;

        private b(OpenHostRequest openHostRequest) {
            this.f40a = openHostRequest;
        }

        @Override // com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall
        public void cancel() {
        }

        @Override // com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall
        public OpenHostResponse execute() {
            return new OpenHostResponse(-1, "please implement OpenNetworkService", this.f40a.getUrl(), OpenNetHeaders.empty, null, new Exception("please implement OpenNetworkService"));
        }

        @Override // com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall
        public OpenHostRequest getRequest() {
            return this.f40a;
        }
    }

    @Override // com.bytedance.sdk.open.aweme.core.OpenNetworkService
    public IOpenHostNetCall newCall(OpenHostRequest openHostRequest) {
        return new b(openHostRequest);
    }
}
