package com.facebook.net;

import android.net.Uri;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.net.FrescoTTNetFetcher;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoOkhttpFetcher extends BaseNetworkFetcher<FrescoTTNetFetcher.TTNetFetchState> {
    private static final String FETCH_TIME = "fetch_time";
    public static final String HIT_CACHE = "hit_cdn_cache";
    private static final int IMAGE_REQUEST_ORDER_ERROR = -1;
    private static final int IMAGE_REQUEST_ORDER_FIRST = 1;
    private static final int IMAGE_REQUEST_ORDER_ZERO = 0;
    private static final String IMAGE_SIZE = "image_size";
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TAG = "FrescoOkhttpFetcher";
    private static final String TOTAL_TIME = "total_time";
    private static ImageNetworkCallback sImageCallBack;
    private Executor mCancellationExecutor;

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return createFetchState((Consumer<EncodedImage>) consumer, producerContext);
    }

    public FrescoOkhttpFetcher() {
        this(new SsHttpExecutor());
    }

    public FrescoOkhttpFetcher(Executor executor) {
        this.mCancellationExecutor = executor;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public FrescoTTNetFetcher.TTNetFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FrescoTTNetFetcher.TTNetFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(FrescoTTNetFetcher.TTNetFetchState tTNetFetchState, NetworkFetcher.Callback callback) {
        if (tTNetFetchState == null) {
            return;
        }
        fetchWithOK3(tTNetFetchState, callback);
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public Map<String, String> getExtraMap(FrescoTTNetFetcher.TTNetFetchState tTNetFetchState, int i) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(IMAGE_SIZE, Integer.toString(i));
        hashMap.put("hit_cdn_cache", tTNetFetchState.hitCdnCache);
        return hashMap;
    }

    public static void setImageCallBack(ImageNetworkCallback imageNetworkCallback) {
        sImageCallBack = imageNetworkCallback;
    }

    private void fetchWithOK3(FrescoTTNetFetcher.TTNetFetchState tTNetFetchState, NetworkFetcher.Callback callback) {
        tTNetFetchState.submitTime = System.currentTimeMillis();
        Uri uri = tTNetFetchState.getUri();
        Request.Builder builder = new Request.Builder();
        if (tTNetFetchState.tempFileLength > 0) {
            builder.header("Range", "bytes=" + tTNetFetchState.tempFileLength + "-");
        }
        String filterUrl = NetworkParams.filterUrl(uri.toString());
        if (StringUtils.isEmpty(filterUrl)) {
            filterUrl = uri.toString();
        }
        fetchWithRequest(tTNetFetchState, callback, FrescoOkHttpClient.getIns().newCall(builder.cacheControl(new CacheControl.Builder().noStore().build()).url(filterUrl).get().build()), 0);
    }

    protected void fetchWithRequest(final FrescoTTNetFetcher.TTNetFetchState tTNetFetchState, final NetworkFetcher.Callback callback, final Call call, final int i) {
        boolean z;
        final Request request = call.request();
        tTNetFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.net.FrescoOkhttpFetcher.1
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    FrescoOkhttpFetcher.this.mCancellationExecutor.execute(new Runnable() { // from class: com.facebook.net.FrescoOkhttpFetcher.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            call.cancel();
                        }
                    });
                } else {
                    call.cancel();
                }
            }
        });
        NetworkParams.CdnConnectionQualitySamplerHook cdnConnectionQualitySamplerHook = NetworkParams.getCdnConnectionQualitySamplerHook();
        if (cdnConnectionQualitySamplerHook == null || !cdnConnectionQualitySamplerHook.cdnShouldSampling(request.url().toString())) {
            z = false;
        } else {
            CdnDeviceBandwidthSampler.getInstance().startSampling();
            z = true;
        }
        final boolean z2 = z;
        call.enqueue(new Callback() { // from class: com.facebook.net.FrescoOkhttpFetcher.2
            public void onResponse(Call call2, final Response response) throws IOException {
                ResponseBody responseBody = null;
                try {
                    try {
                        try {
                            tTNetFetchState.requestStartTime = System.currentTimeMillis();
                            ResponseBody body = response.body();
                            if (!response.isSuccessful()) {
                                FrescoOkhttpFetcher.this.handleException(response, tTNetFetchState, call2, new IOException("Unexpected HTTP code " + response), callback, i);
                                if (z2) {
                                    CdnDeviceBandwidthSampler.getInstance().stopSampling();
                                }
                                if (body != null) {
                                    try {
                                        body.close();
                                        return;
                                    } catch (Exception e) {
                                        FLog.m483w(FrescoOkhttpFetcher.TAG, "Exception when closing response body", e);
                                        return;
                                    }
                                }
                                return;
                            }
                            final long contentLength = body.contentLength();
                            if (contentLength < 0 || (tTNetFetchState.tempFileLength > 0 && response.code() != 206)) {
                                contentLength = 0;
                            }
                            tTNetFetchState.completeRunnable = new Runnable() { // from class: com.facebook.net.FrescoOkhttpFetcher.2.1
                                /* JADX WARN: Can't wrap try/catch for region: R(8:1|(7:13|14|4|5|(1:7)|9|10)|3|4|5|(0)|9|10) */
                                /* JADX WARN: Removed duplicated region for block: B:7:0x006e A[Catch: JSONException -> 0x0089, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0089, blocks: (B:5:0x001b, B:7:0x006e), top: B:4:0x001b }] */
                                @Override // java.lang.Runnable
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public void run() {
                                    String header;
                                    tTNetFetchState.fetchCompleteTime = System.currentTimeMillis();
                                    Response response2 = response;
                                    if (response2 != null) {
                                        try {
                                            header = response2.header("x-snssdk.remoteaddr");
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put(FrescoOkhttpFetcher.IMAGE_SIZE, contentLength);
                                        HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
                                        httpRequestInfo.remoteIp = header;
                                        ResponseWrap responseWrap = new ResponseWrap();
                                        responseWrap.response = response;
                                        responseWrap.url = request.url().toString();
                                        jSONObject.put("http_status", response.code());
                                        jSONObject.put("requestId", tTNetFetchState.getId());
                                        FrescoOkhttpFetcher.this.handleRequestTime(jSONObject, tTNetFetchState);
                                        if (FrescoOkhttpFetcher.sImageCallBack != null) {
                                            FrescoOkhttpFetcher.sImageCallBack.onImageOkCallBack(tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime, tTNetFetchState.submitTime, responseWrap, httpRequestInfo, null, jSONObject);
                                        }
                                        FrescoOkhttpFetcher.this.handleRequest(tTNetFetchState, true, tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime);
                                    }
                                    header = null;
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put(FrescoOkhttpFetcher.IMAGE_SIZE, contentLength);
                                    HttpRequestInfo httpRequestInfo2 = new HttpRequestInfo();
                                    httpRequestInfo2.remoteIp = header;
                                    ResponseWrap responseWrap2 = new ResponseWrap();
                                    responseWrap2.response = response;
                                    responseWrap2.url = request.url().toString();
                                    jSONObject2.put("http_status", response.code());
                                    jSONObject2.put("requestId", tTNetFetchState.getId());
                                    FrescoOkhttpFetcher.this.handleRequestTime(jSONObject2, tTNetFetchState);
                                    if (FrescoOkhttpFetcher.sImageCallBack != null) {
                                    }
                                    FrescoOkhttpFetcher.this.handleRequest(tTNetFetchState, true, tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime);
                                }
                            };
                            callback.onResponse(body.byteStream(), (int) contentLength);
                            if (z2) {
                                CdnDeviceBandwidthSampler.getInstance().stopSampling();
                            }
                            if (body != null) {
                                body.close();
                            }
                        } catch (Exception e2) {
                            FrescoOkhttpFetcher.this.handleException(response, tTNetFetchState, call2, e2, callback, i);
                            if (z2) {
                                CdnDeviceBandwidthSampler.getInstance().stopSampling();
                            }
                            if (0 != 0) {
                                responseBody.close();
                            }
                        }
                    } catch (Exception e3) {
                        FLog.m483w(FrescoOkhttpFetcher.TAG, "Exception when closing response body", e3);
                    }
                } catch (Throwable th) {
                    if (z2) {
                        CdnDeviceBandwidthSampler.getInstance().stopSampling();
                    }
                    if (0 != 0) {
                        try {
                            responseBody.close();
                        } catch (Exception e4) {
                            FLog.m483w(FrescoOkhttpFetcher.TAG, "Exception when closing response body", e4);
                        }
                    }
                    throw th;
                }
            }

            public void onFailure(Call call2, IOException iOException) {
                if (z2) {
                    CdnDeviceBandwidthSampler.getInstance().stopSampling();
                }
                FrescoOkhttpFetcher.this.handleException(null, tTNetFetchState, call2, iOException, callback, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleException(Response response, FrescoTTNetFetcher.TTNetFetchState tTNetFetchState, Call call, Exception exc, NetworkFetcher.Callback callback, int i) {
        String str;
        String str2;
        try {
            callback.onFailure(exc);
            if (tTNetFetchState != null) {
                String str3 = null;
                if (response != null) {
                    try {
                        str = response.header("x-snssdk.remoteaddr");
                        try {
                            str3 = response.request().url().toString();
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        str = null;
                    }
                    String str4 = str;
                    str2 = str3;
                    str3 = str4;
                } else {
                    str2 = null;
                }
                if (StringUtils.isEmpty(str3)) {
                    str3 = getHostAddress(exc);
                }
                long j = tTNetFetchState.submitTime;
                long j2 = tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime;
                if (j2 <= 0) {
                    j2 = System.currentTimeMillis() - tTNetFetchState.submitTime;
                }
                long j3 = j2;
                if (StringUtils.isEmpty(str2)) {
                    str2 = tTNetFetchState.getUri().toString();
                }
                if (Logger.debug() && exc != null) {
                    Logger.d("FrescoTTNetFetcher", "exception for ok3 response url = " + str2 + " exception = " + exc.toString());
                }
                HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
                httpRequestInfo.remoteIp = str3;
                ResponseWrap responseWrap = new ResponseWrap();
                responseWrap.response = response;
                responseWrap.url = str2;
                if (sImageCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestId", tTNetFetchState.getId());
                    jSONObject.put("retryCount", i);
                    sImageCallBack.onImageErrorCallBack(j3, j, responseWrap, httpRequestInfo, exc, jSONObject);
                }
                try {
                    handleRequest(tTNetFetchState, false, j3);
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[Catch: JSONException -> 0x0056, TRY_ENTER, TryCatch #0 {JSONException -> 0x0056, blocks: (B:2:0x0000, B:5:0x000c, B:8:0x0013, B:9:0x001f, B:12:0x0027, B:15:0x002e, B:16:0x003a, B:19:0x0043, B:22:0x004a, B:25:0x0053, B:27:0x0037, B:28:0x001c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRequestTime(JSONObject jSONObject, FrescoTTNetFetcher.TTNetFetchState tTNetFetchState) {
        try {
            if (tTNetFetchState.requestStartTime != 0 && tTNetFetchState.submitTime != 0) {
                jSONObject.put(QUEUE_TIME, tTNetFetchState.requestStartTime - tTNetFetchState.submitTime);
                if (tTNetFetchState.fetchCompleteTime != 0 && tTNetFetchState.requestStartTime != 0) {
                    jSONObject.put(FETCH_TIME, tTNetFetchState.fetchCompleteTime - tTNetFetchState.requestStartTime);
                    if (tTNetFetchState.fetchCompleteTime != 0 && tTNetFetchState.submitTime != 0) {
                        jSONObject.put(TOTAL_TIME, tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime);
                        return;
                    }
                    jSONObject.put(TOTAL_TIME, -1L);
                }
                jSONObject.put(FETCH_TIME, -1L);
                if (tTNetFetchState.fetchCompleteTime != 0) {
                    jSONObject.put(TOTAL_TIME, tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime);
                    return;
                }
                jSONObject.put(TOTAL_TIME, -1L);
            }
            jSONObject.put(QUEUE_TIME, -1L);
            if (tTNetFetchState.fetchCompleteTime != 0) {
                jSONObject.put(FETCH_TIME, tTNetFetchState.fetchCompleteTime - tTNetFetchState.requestStartTime);
                if (tTNetFetchState.fetchCompleteTime != 0) {
                }
                jSONObject.put(TOTAL_TIME, -1L);
            }
            jSONObject.put(FETCH_TIME, -1L);
            if (tTNetFetchState.fetchCompleteTime != 0) {
            }
            jSONObject.put(TOTAL_TIME, -1L);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRequest(FrescoTTNetFetcher.TTNetFetchState tTNetFetchState, boolean z, long j) {
        if (getImageRequestOrder(tTNetFetchState) == 1) {
            ImageStrategy.getInstance().handleImageRequest(tTNetFetchState.getUri().toString(), z, j, true);
        } else if (getImageRequestOrder(tTNetFetchState) == 0) {
            ImageStrategy.getInstance().handleImageRequest(tTNetFetchState.getUri().toString(), z, j, false);
        }
    }

    private int getImageRequestOrder(FrescoTTNetFetcher.TTNetFetchState tTNetFetchState) {
        Uri uri;
        if (tTNetFetchState != null && tTNetFetchState.getContext() != null && tTNetFetchState.getContext().getCallerContext() != null) {
            Object callerContext = tTNetFetchState.getContext().getCallerContext();
            if ((callerContext instanceof TTCallerContext) && (uri = tTNetFetchState.getUri()) != null) {
                return ((TTCallerContext) callerContext).getUrlIndex(uri.toString());
            }
        }
        return -1;
    }

    private static String getHostAddress(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            String[] split = th.getMessage().split("\\|");
            if (split != null && split.length >= 2) {
                if (Logger.debug()) {
                    Logger.d(TAG, "getHostAddress remoteIp = " + split[0]);
                }
                return split[0];
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return "";
    }
}
