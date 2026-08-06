package com.bytedance.retrofit2;

import android.util.Log;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CallServerInterceptor<T> implements TTInternalInterceptor, IMetricsCollect, IRequestInfo {
    private volatile boolean mCanceled;

    @Nullable
    private Throwable mCreationFailure;
    private volatile boolean mExecuted;
    private Request mOriginalRequest;

    @Nullable
    private volatile SsCall mRawCall;
    private final RequestFactory<T> mRequestFactory;
    private volatile long mThrottleNetSpeed;

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
    }

    public CallServerInterceptor(RequestFactory<T> requestFactory) {
        this.mRequestFactory = requestFactory;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain chain) throws Exception {
        Response putCacheResponse;
        Request request = chain.request();
        this.mOriginalRequest = request;
        request.getMetrics().callServerInterceptorStart();
        this.mOriginalRequest.getMetrics().setPriorityLevel(this.mOriginalRequest.getPriorityLevel());
        this.mOriginalRequest.getMetrics().requestPriorityLevel = this.mOriginalRequest.getRequestPriorityLevel();
        synchronized (this) {
            if (this.mExecuted) {
                throw new IllegalStateException("Already executed.");
            }
            this.mExecuted = true;
        }
        Throwable th = this.mCreationFailure;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            throw new Exception(this.mCreationFailure);
        }
        Response cacheResponse = this.mRequestFactory.cacheServer != null ? this.mRequestFactory.cacheServer.getCacheResponse(this.mOriginalRequest) : null;
        if (cacheResponse != null) {
            this.mOriginalRequest.getMetrics().recordInterceptorRequestEnd();
            this.mOriginalRequest.getMetrics().lowestInterceptorRequestEnd();
        }
        if (cacheResponse == null) {
            try {
                this.mRawCall = createRawCall(this.mOriginalRequest);
                if (this.mThrottleNetSpeed > 0) {
                    this.mRawCall.setThrottleNetSpeed(this.mThrottleNetSpeed);
                }
                if (this.mCanceled) {
                    this.mRawCall.cancel();
                }
                List<Header> headers = this.mOriginalRequest.headers("content-encoding");
                if (headers != null && headers.size() > 0) {
                    this.mOriginalRequest.getMetrics().requestCompressType = this.mOriginalRequest.headers("content-encoding").get(0).getValue();
                }
                try {
                    this.mOriginalRequest.getMetrics().recordInterceptorRequestEnd();
                    this.mOriginalRequest.getMetrics().lowestInterceptorRequestEnd();
                    this.mOriginalRequest.getMetrics().executeSsCallStart();
                    cacheResponse = executeCall(this.mRawCall);
                    this.mOriginalRequest.getMetrics().executeSsCallEnd();
                    this.mOriginalRequest.getMetrics().lowestInterceptorResponseStart();
                    this.mOriginalRequest.getMetrics().recordInterceptorResponseStart(this);
                    this.mOriginalRequest.getMetrics().retrofit.misc.executeSsCallSuccess = true;
                    if (this.mRequestFactory.cacheServer != null && (putCacheResponse = this.mRequestFactory.cacheServer.putCacheResponse(this.mOriginalRequest, cacheResponse)) != null) {
                        cacheResponse = putCacheResponse;
                    }
                } catch (Throwable th2) {
                    this.mOriginalRequest.getMetrics().executeSsCallEnd();
                    this.mOriginalRequest.getMetrics().lowestInterceptorResponseStart();
                    this.mOriginalRequest.getMetrics().recordInterceptorResponseStart(this);
                    throw th2;
                }
            } catch (IOException e) {
                e = e;
                this.mCreationFailure = e;
                throw e;
            } catch (RuntimeException e2) {
                e = e2;
                this.mCreationFailure = e;
                throw e;
            } catch (Throwable th3) {
                this.mCreationFailure = th3;
                if (th3 instanceof Exception) {
                    throw th3;
                }
                throw new Exception(th3);
            }
        }
        List<Header> headers2 = cacheResponse.headers("content-encoding");
        if (headers2 != null) {
            this.mOriginalRequest.getMetrics().responseCompressType = headers2.get(0).getValue();
        }
        return parseResponse(cacheResponse, this.mOriginalRequest.getMetrics());
    }

    private SsCall createRawCall(Request request) throws IOException {
        return this.mRequestFactory.clientProvider.get().newSsCall(request);
    }

    private Response executeCall(SsCall ssCall) throws IOException {
        return ssCall.execute();
    }

    SsResponse<T> parseResponse(Response response, RetrofitMetrics retrofitMetrics) throws IOException {
        if (response == null) {
            throw new IOException("SsResponse is null");
        }
        TypedInput body = response.getBody();
        int status = response.getStatus();
        if (status < 200 || status >= 300) {
            return SsResponse.error(body, response);
        }
        if (status == 204 || status == 205) {
            return SsResponse.success(null, response);
        }
        if (retrofitMetrics != null) {
            try {
                retrofitMetrics.toSsResponseStart();
            } catch (Throwable th) {
                if (retrofitMetrics != null) {
                    retrofitMetrics.responseConvertSuccess = false;
                }
                Log.i("ToResponseLog", "toResponse failed");
                throw th;
            }
        }
        try {
            return SsResponse.success(this.mRequestFactory.toResponse(body), response);
        } finally {
            if (retrofitMetrics != null) {
                retrofitMetrics.toSsResponseEnd();
            }
        }
    }

    public Request request() {
        return this.mOriginalRequest;
    }

    public synchronized boolean isExecuted() {
        return this.mExecuted;
    }

    public synchronized void resetExecuted() {
        this.mExecuted = false;
    }

    public void cancel() {
        this.mCanceled = true;
        if (this.mRawCall != null) {
            this.mRawCall.cancel();
        }
    }

    public void cancelNormalRequest(boolean z, Throwable th, boolean z2) {
        cancel();
        this.mCanceled = z;
    }

    public boolean setThrottleNetSpeed(long j) {
        this.mThrottleNetSpeed = j;
        if (this.mRawCall != null) {
            return this.mRawCall.setThrottleNetSpeed(j);
        }
        return false;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        if (this.mRawCall instanceof IRequestInfo) {
            return ((IRequestInfo) this.mRawCall).getRequestInfo();
        }
        return null;
    }
}
