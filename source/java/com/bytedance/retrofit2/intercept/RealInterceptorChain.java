package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallServerInterceptor;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RealInterceptorChain implements Interceptor.Chain {
    private static volatile boolean proceedWithoutHookEnabled;
    private static boolean sLogObjectRefineEnabled;
    private final Call call;
    private int calls;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request prevRequest;

    public RealInterceptorChain(List<Interceptor> list, int i, Request request, Call call) {
        this.interceptors = list;
        this.index = i;
        this.prevRequest = request;
        this.call = call;
    }

    public static void setLogObjectRefineEnabled(boolean z) {
        sLogObjectRefineEnabled = z;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Request request() {
        return this.prevRequest;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceed(Request request) throws Exception {
        request.setMetrics(this.prevRequest.getMetrics());
        if (request.getMetrics() != null) {
            request.getMetrics().recordInterceptorRequestEnd();
        }
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        int i = this.calls + 1;
        this.calls = i;
        if (i > 1) {
            for (Interceptor interceptor : this.interceptors) {
                if (interceptor instanceof CallServerInterceptor) {
                    ((CallServerInterceptor) interceptor).resetExecuted();
                }
            }
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, this.index + 1, request, this.call);
        Interceptor interceptor2 = this.interceptors.get(this.index);
        if (!sLogObjectRefineEnabled) {
            RetrofitLogger.m332d("RealInterceptorChain", "interceptor = " + (interceptor2 != null ? interceptor2.toString() : "") + " url = " + request.getUrl());
        }
        if (interceptor2 == null) {
            throw new NullPointerException("interceptor " + this.index + " is null");
        }
        if (request.getMetrics() != null) {
            request.getMetrics().recordInterceptorRequestStart(interceptor2);
            request.getMetrics().beforeInterceptorExecute(interceptor2);
        }
        try {
            try {
                SsResponse intercept = interceptor2.intercept(realInterceptorChain);
                if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor2 + " returned null");
                }
                if (intercept.raw() != null) {
                    return intercept;
                }
                throw new IllegalStateException("interceptor " + interceptor2 + " returned a ssResponse with no body");
            } catch (Exception e) {
                throw e;
            }
        } finally {
            if (request.getMetrics() != null) {
                request.getMetrics().recordInterceptorResponseEnd(null);
                if (this.index > 0) {
                    request.getMetrics().recordInterceptorResponseStart(this.interceptors.get(this.index - 1));
                }
                request().getMetrics().afterInterceptorExecute(null);
            }
        }
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceedWithoutHook(Request request) throws Exception {
        request.setMetrics(this.prevRequest.getMetrics());
        if (request.getMetrics() != null) {
            request.getMetrics().recordInterceptorRequestEnd();
        }
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        int i = this.calls + 1;
        this.calls = i;
        if (i > 1) {
            for (Interceptor interceptor : this.interceptors) {
                if (interceptor instanceof CallServerInterceptor) {
                    ((CallServerInterceptor) interceptor).resetExecuted();
                }
            }
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.interceptors, this.index + 1, request, this.call);
        Interceptor interceptor2 = this.interceptors.get(this.index);
        if (!sLogObjectRefineEnabled) {
            RetrofitLogger.m332d("RealInterceptorChain", "interceptor = " + (interceptor2 != null ? interceptor2.toString() : "") + " url = " + request.getUrl());
        }
        if (interceptor2 == null) {
            throw new NullPointerException("interceptor " + this.index + " is null");
        }
        if (request.getMetrics() != null) {
            request.getMetrics().recordInterceptorRequestStart(interceptor2);
            request.getMetrics().beforeInterceptorExecute(interceptor2);
        }
        try {
            try {
                SsResponse intercept = interceptor2.intercept(realInterceptorChain);
                if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor2 + " returned null");
                }
                if (intercept.raw() != null) {
                    return intercept;
                }
                throw new IllegalStateException("interceptor " + interceptor2 + " returned a ssResponse with no body");
            } catch (Exception e) {
                throw e;
            }
        } finally {
            if (request.getMetrics() != null) {
                request.getMetrics().recordInterceptorResponseEnd(null);
                if (this.index > 0) {
                    request.getMetrics().recordInterceptorResponseStart(this.interceptors.get(this.index - 1));
                }
                request().getMetrics().afterInterceptorExecute(null);
            }
        }
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public RetrofitMetrics metrics() {
        return this.prevRequest.getMetrics();
    }

    public static void setProceedWithoutHookEnabled(boolean z) {
        proceedWithoutHookEnabled = z;
    }

    public static boolean isProceedWithoutHookEnabled() {
        return proceedWithoutHookEnabled;
    }
}
