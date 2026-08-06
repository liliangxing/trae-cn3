package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import java.util.List;

/* loaded from: classes5.dex */
public class c implements OpenInterceptor.Chain {
    private final List<OpenInterceptor> a;
    private final int b;
    private final OpenHostRequest c;

    public c(List<OpenInterceptor> list, int i, OpenHostRequest openHostRequest) {
        this.a = list;
        this.b = i;
        this.c = openHostRequest;
    }

    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor.Chain
    public OpenHostResponse proceed(OpenHostRequest openHostRequest) throws Exception {
        if (this.b >= this.a.size()) {
            throw new AssertionError();
        }
        c cVar = new c(this.a, this.b + 1, openHostRequest);
        OpenInterceptor openInterceptor = this.a.get(this.b);
        if (openInterceptor == null) {
            throw new NullPointerException("interceptor " + this.b + " is null");
        }
        OpenHostResponse intercept = openInterceptor.intercept(cVar);
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
        return this.c;
    }
}
