package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import java.util.List;

/* renamed from: com.bytedance.sdk.open.aweme.commonbase.net.interceptor.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0106c implements OpenInterceptor.Chain {

    /* renamed from: a */
    private final List<OpenInterceptor> f42a;

    /* renamed from: b */
    private final int f43b;

    /* renamed from: c */
    private final OpenHostRequest f44c;

    public C0106c(List<OpenInterceptor> list, int i, OpenHostRequest openHostRequest) {
        this.f42a = list;
        this.f43b = i;
        this.f44c = openHostRequest;
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor.Chain
    public OpenHostResponse proceed(OpenHostRequest openHostRequest) throws Exception {
        if (this.f43b >= this.f42a.size()) {
            throw new AssertionError();
        }
        C0106c c0106c = new C0106c(this.f42a, this.f43b + 1, openHostRequest);
        OpenInterceptor openInterceptor = this.f42a.get(this.f43b);
        if (openInterceptor == null) {
            throw new NullPointerException("interceptor " + this.f43b + " is null");
        }
        OpenHostResponse intercept = openInterceptor.intercept(c0106c);
        if (intercept == null) {
            throw new NullPointerException("interceptor " + openInterceptor + " returned null");
        }
        if (intercept.body != null) {
            return intercept;
        }
        throw new IllegalStateException("interceptor " + openInterceptor + " returned a ssResponse with no body");
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor.Chain
    public OpenHostRequest request() {
        return this.f44c;
    }
}
