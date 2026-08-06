package com.bytedance.retrofit2;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SsHttpCall<T> implements Call<T>, IMetricsCollect, IRequestInfo {

    @Nullable
    private static ICustomInterceptorControl sCustomInterceptorControl;
    private static IHttpCallPriorityControl sPriorityControl;

    @Nullable
    private static IRequestFlagHandler sRequestFlagHandler;
    private static IHttpCallThrottleControl sThrottleControl;
    private final Object[] args;
    private final CallServerInterceptor callServerInterceptor;
    private final RetrofitMetrics metrics;
    private Request originalRequest;
    private final RequestFactory<T> requestFactory;
    private Request delayRequest = null;

    @Nullable
    private Throwable requestException = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ICustomInterceptorControl {
        List<Interceptor> getInterceptors(Request request, List<Interceptor> list);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IHttpCallPriorityControl {
        int getPriority(String str, int i);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IRequestFlagHandler {
        int getPriorityInContext(Request request);

        Request handleFlag(Request request);

        boolean shouldBypassInterceptor(Request request);

        boolean shouldUseCustomInterceptor(Request request);
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
    }

    public static void setCustomInterceptorControl(ICustomInterceptorControl iCustomInterceptorControl) {
        sCustomInterceptorControl = iCustomInterceptorControl;
    }

    public static void setThrottleControl(IHttpCallThrottleControl iHttpCallThrottleControl) {
        sThrottleControl = iHttpCallThrottleControl;
    }

    public static void setPriorityControl(IHttpCallPriorityControl iHttpCallPriorityControl) {
        sPriorityControl = iHttpCallPriorityControl;
    }

    public static void setRequestFlagHandler(IRequestFlagHandler iRequestFlagHandler) {
        sRequestFlagHandler = iRequestFlagHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SsHttpCall(RequestFactory<T> requestFactory, Object[] objArr) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callServerInterceptor = new CallServerInterceptor(requestFactory);
        RetrofitMetrics cloneMetrics = requestFactory.getRetrofitMetrics().cloneMetrics();
        this.metrics = cloneMetrics;
        cloneMetrics.bizInvokeRetrofitRequestInterfaceEnd();
    }

    private synchronized void ensureOriginalRequestCreated() {
        if (this.originalRequest != null) {
            return;
        }
        try {
            this.metrics.toRequestStart();
            this.originalRequest = this.requestFactory.toRequest(null, this.args);
            this.metrics.toRequestEnd();
            Request request = this.originalRequest;
            if (request != null) {
                request.setMetrics(this.metrics);
                if (Logger.debug()) {
                    Logger.d("ToRequestLog", "originalRequest build success, path: " + this.originalRequest.getPath());
                }
                return;
            }
            throw new RuntimeException("Unable to create request.");
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean isStreaming() {
        return Boolean.valueOf(this.requestFactory.isResponseStreaming);
    }

    @Override // com.bytedance.retrofit2.Call
    @Deprecated
    public SsResponse<T> execute() throws Exception {
        this.metrics.ssHttpCallApiStart(false);
        ensureOriginalRequestCreated();
        try {
            IHttpCallThrottleControl iHttpCallThrottleControl = sThrottleControl;
            if (iHttpCallThrottleControl != null) {
                Request originalRequestProperties = iHttpCallThrottleControl.setOriginalRequestProperties(this.originalRequest);
                this.originalRequest = originalRequestProperties;
                this.delayRequest = originalRequestProperties;
                sThrottleControl.maybeDropRequestOrBlockingDelay(originalRequestProperties);
            }
            this.metrics.requestRealStart();
            return getResponseWithInterceptorChain();
        } catch (Throwable th) {
            try {
                this.requestException = th;
                this.metrics.retrofit.misc.requestException = new WeakReference<>(th);
                throw th;
            } finally {
                IHttpCallThrottleControl iHttpCallThrottleControl2 = sThrottleControl;
                if (iHttpCallThrottleControl2 != null) {
                    iHttpCallThrottleControl2.notifyRequestCompleted(this.delayRequest);
                }
                this.metrics.bizReceiveResponseHeader();
                this.metrics.ssHttpCallApiEnd();
                this.metrics.markRetrofitLayerLogCollected();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class AsyncRequestRunnable implements SsRunnable {
        private final Callback<T> callback;
        private final ExpandCallback expandCallback;

        @Override // com.bytedance.retrofit2.SsRunnable
        public int getRequestDelayTime() {
            return 0;
        }

        AsyncRequestRunnable(Callback<T> callback) {
            this.callback = callback;
            this.expandCallback = callback instanceof ExpandCallback ? (ExpandCallback) callback : null;
        }

        @Override // java.lang.Runnable
        public void run() {
            SsResponse responseWithInterceptorChain;
            try {
                SsHttpCall.this.metrics.requestRealStart();
                responseWithInterceptorChain = SsHttpCall.this.getResponseWithInterceptorChain();
                if (SsHttpCall.sThrottleControl != null) {
                    SsHttpCall.sThrottleControl.notifyRequestCompleted(SsHttpCall.this.delayRequest);
                }
                SsHttpCall.this.metrics.bizReceiveResponseHeader();
                SsHttpCall.this.metrics.enqueueCallbackStart();
            } catch (Throwable th) {
                try {
                    SsHttpCall.this.requestException = th;
                    SsHttpCall.this.metrics.retrofit.misc.requestException = new WeakReference<>(th);
                    if (SsHttpCall.sThrottleControl != null) {
                        SsHttpCall.sThrottleControl.notifyRequestCompleted(SsHttpCall.this.delayRequest);
                    }
                    SsHttpCall.this.metrics.bizReceiveResponseHeader();
                    SsHttpCall.this.metrics.enqueueCallbackStart();
                    try {
                        if (SsHttpCall.this.requestException != null) {
                            callFailure(SsHttpCall.this.requestException);
                        } else {
                            callSuccess(null);
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    if (SsHttpCall.sThrottleControl != null) {
                        SsHttpCall.sThrottleControl.notifyRequestCompleted(SsHttpCall.this.delayRequest);
                    }
                    SsHttpCall.this.metrics.bizReceiveResponseHeader();
                    SsHttpCall.this.metrics.enqueueCallbackStart();
                    try {
                        if (SsHttpCall.this.requestException != null) {
                            callFailure(SsHttpCall.this.requestException);
                        } else {
                            callSuccess(null);
                        }
                        SsHttpCall.this.metrics.enqueueCallbackEnd();
                        SsHttpCall.this.metrics.markRetrofitLayerLogCollected();
                        throw th2;
                    } finally {
                    }
                }
            }
            try {
                if (SsHttpCall.this.requestException != null) {
                    callFailure(SsHttpCall.this.requestException);
                } else {
                    callSuccess(responseWithInterceptorChain);
                }
                SsHttpCall.this.metrics.enqueueCallbackEnd();
                SsHttpCall.this.metrics.markRetrofitLayerLogCollected();
            } finally {
            }
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int priority() {
            int priorityInContext;
            if (SsHttpCall.sRequestFlagHandler == null || (priorityInContext = SsHttpCall.sRequestFlagHandler.getPriorityInContext(SsHttpCall.this.originalRequest)) == -999) {
                if (SsHttpCall.sPriorityControl == null || SsHttpCall.this.originalRequest == null) {
                    return SsHttpCall.this.originalRequest != null ? SsHttpCall.this.originalRequest.getPriorityLevel() : SsHttpCall.this.requestFactory.priorityLevel;
                }
                int priority = SsHttpCall.sPriorityControl.getPriority(SsHttpCall.this.originalRequest.getPath(), SsHttpCall.this.requestFactory.priorityLevel);
                SsHttpCall.this.metrics.setPriorityLevel(priority);
                return priority;
            }
            SsHttpCall.this.metrics.setPriorityLevel(priorityInContext);
            return priorityInContext;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public boolean isStreaming() {
            return SsHttpCall.this.isStreaming().booleanValue();
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public RetrofitMetrics getRetrofitMetrics() {
            return SsHttpCall.this.getRetrofitMetrics();
        }

        private void callFailure(Throwable th) {
            try {
                this.callback.onFailure(SsHttpCall.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        private void callSuccess(SsResponse<T> ssResponse) {
            try {
                this.callback.onResponse(SsHttpCall.this, ssResponse);
                ExpandCallback expandCallback = this.expandCallback;
                if (expandCallback != null) {
                    expandCallback.onAsyncResponse(SsHttpCall.this, ssResponse);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.retrofit2.Call
    public void enqueue(Callback<T> callback) {
        Throwable th;
        if (callback == null) {
            throw new NullPointerException("callback == null");
        }
        if (isExecuted()) {
            throw new IllegalStateException("Already executed.");
        }
        this.metrics.ssHttpCallApiStart(true);
        AsyncRequestRunnable asyncRequestRunnable = new AsyncRequestRunnable(callback);
        try {
            ensureOriginalRequestCreated();
            IHttpCallThrottleControl iHttpCallThrottleControl = sThrottleControl;
            if (iHttpCallThrottleControl != null) {
                Request originalRequestProperties = iHttpCallThrottleControl.setOriginalRequestProperties(this.originalRequest);
                this.originalRequest = originalRequestProperties;
                this.delayRequest = originalRequestProperties;
                if (sThrottleControl.maybeDropRequestOrAsyncDelay(originalRequestProperties, this.requestFactory.httpExecutor, asyncRequestRunnable)) {
                    if (th != null) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.requestFactory.httpExecutor.execute(asyncRequestRunnable);
            this.metrics.ssHttpCallApiEnd();
            if (this.requestException == null) {
                return;
            }
        } catch (Throwable th2) {
            try {
                this.requestException = th2;
                th2.printStackTrace();
                this.metrics.retrofit.misc.requestException = new WeakReference<>(th2);
                this.metrics.enqueueCallbackStart();
                try {
                    callback.onFailure(this, th2);
                    this.metrics.enqueueCallbackEnd();
                    IHttpCallThrottleControl iHttpCallThrottleControl2 = sThrottleControl;
                    if (iHttpCallThrottleControl2 != null) {
                        iHttpCallThrottleControl2.notifyRequestCompleted(this.delayRequest);
                    }
                    this.metrics.ssHttpCallApiEnd();
                    if (this.requestException == null) {
                        return;
                    }
                } catch (Throwable th3) {
                    this.metrics.enqueueCallbackEnd();
                    throw th3;
                }
            } finally {
                this.metrics.ssHttpCallApiEnd();
                if (this.requestException != null) {
                    this.metrics.markNetworkKernelLogCollected();
                    this.metrics.markRetrofitLayerLogCollected();
                }
            }
        }
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
    }

    @Override // com.bytedance.retrofit2.Call
    public synchronized boolean isExecuted() {
        boolean z;
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        if (callServerInterceptor != null) {
            z = callServerInterceptor.isExecuted();
        }
        return z;
    }

    @Override // com.bytedance.retrofit2.Call
    public void cancel() {
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        if (callServerInterceptor != null) {
            callServerInterceptor.cancel();
        }
    }

    @Deprecated
    public void cancelNormalRequest(boolean z, Throwable th, boolean z2) {
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        if (callServerInterceptor != null) {
            callServerInterceptor.cancelNormalRequest(z, th, z2);
        }
    }

    @Override // com.bytedance.retrofit2.Call
    public boolean isCanceled() {
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        return callServerInterceptor != null && callServerInterceptor.isCanceled();
    }

    @Override // com.bytedance.retrofit2.Call
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SsHttpCall<T> m813clone() {
        return new SsHttpCall<>(this.requestFactory, this.args);
    }

    @Override // com.bytedance.retrofit2.Call
    public Request request() {
        Request request;
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        if (callServerInterceptor != null && (request = callServerInterceptor.request()) != null) {
            return request;
        }
        ensureOriginalRequestCreated();
        return this.originalRequest;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        if (callServerInterceptor != null) {
            return callServerInterceptor.getRequestInfo();
        }
        return null;
    }

    public T toResponseBody(TypedInput typedInput) throws IOException {
        return this.requestFactory.toResponse(typedInput);
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.metrics;
    }

    SsResponse getResponseWithInterceptorChain() throws Exception {
        SsResponse proceed;
        if (Logger.debug()) {
            Logger.d("SsHttpCall", "real send " + this.originalRequest.getPath());
        }
        List<Interceptor> constructInterceptorList = constructInterceptorList();
        if (Logger.debug()) {
            this.originalRequest = addDebugMetricsInfoToRequest(this.originalRequest);
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(constructInterceptorList, 0, this.originalRequest, this);
        if (RealInterceptorChain.isProceedWithoutHookEnabled()) {
            proceed = realInterceptorChain.proceedWithoutHook(this.originalRequest);
        } else {
            proceed = realInterceptorChain.proceed(this.originalRequest);
        }
        proceed.setRetrofitMetrics(this.metrics);
        return proceed;
    }

    public boolean setThrottleNetSpeed(long j) {
        CallServerInterceptor callServerInterceptor = this.callServerInterceptor;
        if (callServerInterceptor != null) {
            return callServerInterceptor.setThrottleNetSpeed(j);
        }
        return false;
    }

    private Request addDebugMetricsInfoToRequest(Request request) {
        if (request.getMetrics().stateDelayTime < 0) {
            return request;
        }
        Request.Builder newBuilder = request.newBuilder();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders());
        arrayList.add(new Header("state-delay", String.valueOf(request.getMetrics().stateDelayTime)));
        newBuilder.headers(arrayList);
        return newBuilder.build();
    }

    private List<Interceptor> constructInterceptorList() {
        IRequestFlagHandler iRequestFlagHandler;
        LinkedList linkedList = new LinkedList();
        IRequestFlagHandler iRequestFlagHandler2 = sRequestFlagHandler;
        if (iRequestFlagHandler2 != null) {
            this.originalRequest = iRequestFlagHandler2.handleFlag(this.originalRequest);
        }
        if (sCustomInterceptorControl != null && (iRequestFlagHandler = sRequestFlagHandler) != null && iRequestFlagHandler.shouldUseCustomInterceptor(this.originalRequest)) {
            List<Interceptor> interceptors = sCustomInterceptorControl.getInterceptors(this.originalRequest, this.requestFactory.interceptors);
            if (interceptors != null) {
                linkedList.addAll(interceptors);
            }
        } else if (shouldAddInterceptors(this.originalRequest)) {
            linkedList.addAll(this.requestFactory.interceptors);
        }
        linkedList.add(this.callServerInterceptor);
        return linkedList;
    }

    private boolean shouldAddInterceptors(Request request) {
        if (request.isPureRequest()) {
            return false;
        }
        IRequestFlagHandler iRequestFlagHandler = sRequestFlagHandler;
        return iRequestFlagHandler == null || !iRequestFlagHandler.shouldBypassInterceptor(request);
    }
}
