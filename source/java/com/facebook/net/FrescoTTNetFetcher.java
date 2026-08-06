package com.facebook.net;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.frameworks.baselib.network.http.exception.ClientProtocolException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.exception.NoHttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowApiHttpException;
import com.bytedance.frameworks.baselib.network.http.exception.NotAllowUseNetworkException;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.fresco.cloudcontrol.CloudControl;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.webx.addr.AddressParam;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.blurhash.BlurHashConfig;
import com.facebook.imagepipeline.blurhash.BlurHashListener;
import com.facebook.imagepipeline.blurhash.BlurHashMapUtils;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.exception.BDErrorCodeConst;
import com.facebook.imagepipeline.exception.BDException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.net.ExpiredUrlException;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.TTDiskCacheProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.net.RetryInterceptManager;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.imageloader.api.Callback;
import com.ss.android.ugc.aweme.imageloader.api.IRequest;
import com.ss.android.ugc.aweme.imageloader.api.ImageLoaderApi;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class FrescoTTNetFetcher extends BaseNetworkFetcher<TTNetFetchState> {
    public static final String BLURHASH_DECODE_DURATION = "blurhash_decode_duration";
    public static final String BLURHASH_PRODUCER_NAME = "BlurhashProducer";
    public static boolean DEBUG_MDL = false;
    private static final String FETCH_TIME = "fetch_time";
    public static final String HEADER_LENGTH = "X-Length";
    public static final String HEADER_MD5 = "X-Md5";
    public static final String HEADER_TYPE = "Content-Type";
    public static final String HIT_CACHE = "hit_cdn_cache";
    public static final String IMAGEX_CONSISTENCY = "imagex_consistency";
    private static final String IMAGEX_CUSTOM_PARAM = "customParam";
    public static final String IMAGEX_DEMOTION = "imagex_demotion";
    public static final String IMAGEX_IS_PREFETCH = "is_prefetch_image";
    public static final String IMAGEX_TRUE_FMT = "imagex_true_fmt";
    public static final String IMAGEX_WANT_FMT = "imagex_want_fmt";
    private static final int IMAGE_REQUEST_ORDER_ERROR = -1;
    private static final int IMAGE_REQUEST_ORDER_FIRST = 1;
    private static final int IMAGE_REQUEST_ORDER_ZERO = 0;
    private static final String IMAGE_SIZE = "image_size";
    private static final int NET_CDN_CACHE_VERIFY_EXCEPTION = 1001;
    private static final int NET_CLIENT_PROTOCOL_EXCEPTION = 1002;
    private static final int NET_NOT_ALLOW_API_HTTP_EXCEPTION = 1005;
    private static final int NET_NOT_ALLOW_USE_NETWORK_EXCEPTION = 1006;
    private static final int NET_NOT_AVAILABLE_EXCEPTION = 1003;
    private static final int NET_NO_HTTP_RESPONSE_EXCEPTION = 1004;
    private static final int NET_OTHERS_EXCEPTION = 1000;
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TAG = "FrescoTTNetFetcher";
    private static final String TOTAL_TIME = "total_time";
    private static final String X_IMAGEX_EXTRA = "x-imagex-extra";
    public static final String X_RESPONSE_CACHE = "x_response_cache";
    private static RequestUrlCallBack mRequestUrlCallBack;
    private static IRequestUrlReplace mRequestUrlReplace;
    private static FetcherInterceptorProvider sFetcherInterceptorProvider;
    private static ImageNetworkCallback sImageCallBack;
    private Executor mCancellationExecutor;
    private boolean mEnableNetworkPriority;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface FetcherInterceptor {
        Pair<InputStream, Long> intercepterStream(InputStream inputStream, String str, long j) throws Exception;

        String intercepterUrl(String str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface FetcherInterceptorProvider {
        FetcherInterceptor getInterceptor();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface IRequestUrlReplace {
        String replaceRequestUrl(String str, Object obj, int i, int i2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface RequestUrlCallBack {
        boolean canRequestUrl(Uri uri);
    }

    @Deprecated
    public static void setDebugOk3(boolean z) {
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public /* bridge */ /* synthetic */ FetchState createFetchState(Consumer consumer, ProducerContext producerContext) {
        return createFetchState((Consumer<EncodedImage>) consumer, producerContext);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class TTNetFetchState extends FetchState {
        public Runnable completeRunnable;
        public long fetchCompleteTime;
        public String hitCdnCache;
        public String imagexConsistency;
        public String imagexDemotion;
        public String imagexTrueFmt;
        public String imagexWantFmt;
        public long requestStartTime;
        public int retryCount;
        public long submitTime;
        public long tempFileLength;
        public String xImageXExtra;
        public String xResponseCache;

        public TTNetFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
            this.retryCount = 0;
            if (consumer instanceof TTDiskCacheProducer.DiskCacheConsumer) {
                if (((TTDiskCacheProducer.DiskCacheConsumer) consumer).getTempEncodedImage() != null) {
                    this.tempFileLength = r1.getTempEncodedImage().getSize();
                }
            }
        }
    }

    public static void setImageCallBack(ImageNetworkCallback imageNetworkCallback) {
        sImageCallBack = imageNetworkCallback;
    }

    public static void setRequestUrlCallBack(RequestUrlCallBack requestUrlCallBack) {
        mRequestUrlCallBack = requestUrlCallBack;
    }

    public static void setRequestUrlReplace(IRequestUrlReplace iRequestUrlReplace) {
        mRequestUrlReplace = iRequestUrlReplace;
    }

    public FrescoTTNetFetcher() {
        this((Executor) new SsHttpExecutor());
    }

    public FrescoTTNetFetcher(Executor executor) {
        this(false, executor);
    }

    public FrescoTTNetFetcher(boolean z) {
        this(z, new SsHttpExecutor());
    }

    public FrescoTTNetFetcher(boolean z, Executor executor) {
        this.mEnableNetworkPriority = z;
        this.mCancellationExecutor = executor;
        FLog.m442e(TAG, "init FrescoTTNetFetcher");
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public TTNetFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new TTNetFetchState(consumer, producerContext);
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void fetch(TTNetFetchState tTNetFetchState, NetworkFetcher.Callback callback) {
        ImageLoaderApi imageLoaderApi;
        if (tTNetFetchState == null) {
            return;
        }
        try {
            imageLoaderApi = (ImageLoaderApi) getImplByName("ImageLoaderImpl");
        } catch (Exception e) {
            e.printStackTrace();
            imageLoaderApi = null;
        }
        if (imageLoaderApi != null && imageLoaderApi.canFetchForUri(tTNetFetchState.getUri(), (Map) null)) {
            if (DEBUG_MDL) {
                Log.d(TAG, "FrescoTTNetFetcher, fetch: fetchWithMDL");
            }
            fetchWithMDL(tTNetFetchState, callback, false);
        } else {
            if (DEBUG_MDL) {
                Log.d(TAG, "FrescoTTNetFetcher, fetch: fetchWithTtnet");
            }
            fetchWithTtnet(tTNetFetchState, callback, false);
        }
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public void onFetchCompletion(TTNetFetchState tTNetFetchState, int i) {
        tTNetFetchState.completeRunnable.run();
    }

    @Override // com.facebook.imagepipeline.producers.BaseNetworkFetcher, com.facebook.imagepipeline.producers.NetworkFetcher
    public Map<String, String> getExtraMap(TTNetFetchState tTNetFetchState, int i) {
        Map<String, String> customParam;
        HashMap hashMap = new HashMap(1);
        hashMap.put(IMAGE_SIZE, Integer.toString(i));
        hashMap.put("hit_cdn_cache", tTNetFetchState.hitCdnCache);
        hashMap.put(X_RESPONSE_CACHE, tTNetFetchState.xResponseCache);
        hashMap.put(IMAGEX_DEMOTION, tTNetFetchState.imagexDemotion);
        hashMap.put(IMAGEX_WANT_FMT, tTNetFetchState.imagexWantFmt);
        hashMap.put(IMAGEX_TRUE_FMT, tTNetFetchState.imagexTrueFmt);
        hashMap.put(IMAGEX_CONSISTENCY, tTNetFetchState.imagexConsistency);
        hashMap.put(X_IMAGEX_EXTRA, tTNetFetchState.xImageXExtra);
        if (tTNetFetchState.getContext() != null && tTNetFetchState.getContext().getImageRequest() != null && (customParam = tTNetFetchState.getContext().getImageRequest().getCustomParam()) != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str : customParam.keySet()) {
                    jSONObject.put(str, customParam.get(str));
                }
                hashMap.put(IMAGEX_CUSTOM_PARAM, jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
        if (tTNetFetchState.getContext() != null) {
            hashMap.put(IMAGEX_IS_PREFETCH, Boolean.toString(tTNetFetchState.getContext().isPrefetch()));
        }
        return hashMap;
    }

    public static Object getImplByName(String str) throws Exception {
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.imageloader.impl." + str);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchWithMDL(final TTNetFetchState tTNetFetchState, final NetworkFetcher.Callback callback, boolean z) {
        tTNetFetchState.submitTime = System.currentTimeMillis();
        Uri uri = tTNetFetchState.getUri();
        if (uri == null) {
            return;
        }
        final String uri2 = uri.toString();
        if (StringUtils.isEmpty(uri2)) {
            return;
        }
        try {
            LinkedList linkedList = new LinkedList();
            if (tTNetFetchState.tempFileLength > 0) {
                linkedList.add(new Header("Range", "bytes=" + tTNetFetchState.tempFileLength + "-"));
            }
            Map<String, String> httpHeader = tTNetFetchState.getContext().getImageRequest().getHttpHeader();
            if (httpHeader == null) {
                httpHeader = new HashMap<>();
            }
            httpHeader.put("Range", "bytes=" + tTNetFetchState.tempFileLength + "-");
            HashMap hashMap = new HashMap();
            hashMap.put("read:timeout", String.valueOf(RetryInterceptManager.inst().getMDLReadTimeOut(tTNetFetchState.retryCount)));
            hashMap.put("task:connect_timeout", String.valueOf(RetryInterceptManager.inst().getMDLConnectTimeOut(tTNetFetchState.retryCount)));
            hashMap.put("task:retrycount", String.valueOf(tTNetFetchState.retryCount));
            hashMap.put("task:priority", String.valueOf(tTNetFetchState.getContext().getPriority()));
            final long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("task:prefetch", tTNetFetchState.getContext().getImageRequest().isPrefetch() ? "1" : AddressParam.TYPE_DISAPPROVE);
            if (tTNetFetchState.getBackupUris() != null && tTNetFetchState.getBackupUris().size() > 0) {
                List<Uri> backupUris = tTNetFetchState.getBackupUris();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < backupUris.size(); i++) {
                    if (i == backupUris.size() - 1) {
                        if (backupUris.get(i) != null) {
                            sb.append(backupUris.get(i));
                        }
                    } else if (backupUris.get(i) != null) {
                        sb.append(backupUris.get(i) + ",");
                    }
                }
                hashMap.put("task:backurl", sb.toString());
            }
            final IRequest fetchImage = ((ImageLoaderApi) getImplByName("ImageLoaderImpl")).fetchImage(uri2, httpHeader, hashMap, (String) null);
            final HashMap hashMap2 = new HashMap();
            if (FrescoCacheMonitorUtil.isAddMDLCancel()) {
                addCancelCallback(tTNetFetchState, fetchImage);
            }
            fetchImage.start(new Callback() { // from class: com.facebook.net.FrescoTTNetFetcher.1
                long completeReadResponse = -1;

                public void onInfos(int i2, String str, String str2) {
                    if (FrescoTTNetFetcher.DEBUG_MDL) {
                        Log.d(FrescoTTNetFetcher.TAG, "onInfos: type = " + i2 + ", key = " + str + ", value = " + str2);
                    }
                }

                public void onHeaders(int i2, int i3, Map<String, String> map) {
                    if (FrescoTTNetFetcher.DEBUG_MDL) {
                        Log.d(FrescoTTNetFetcher.TAG, "onHeaders: code = " + i2 + ", httpCode = " + i3 + ", headers = " + map);
                    }
                    hashMap2.putAll(map);
                    map.get(FrescoTTNetFetcher.HEADER_MD5);
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[Catch: Exception -> 0x004f, all -> 0x0088, TRY_LEAVE, TryCatch #0 {Exception -> 0x004f, blocks: (B:23:0x0042, B:14:0x0056, B:20:0x0069, B:21:0x0073), top: B:22:0x0042 }] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[Catch: Exception -> 0x004f, all -> 0x0088, TRY_ENTER, TryCatch #0 {Exception -> 0x004f, blocks: (B:23:0x0042, B:14:0x0056, B:20:0x0069, B:21:0x0073), top: B:22:0x0042 }] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResponse(final int i2, InputStream inputStream, int i3) {
                    if (FrescoTTNetFetcher.DEBUG_MDL) {
                        Log.d(FrescoTTNetFetcher.TAG, "onResponse: code = " + i2 + ", response = " + inputStream + ", responseLength = " + i3);
                    }
                    try {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            System.currentTimeMillis();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    } catch (Exception e) {
                        e = e;
                        inputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        try {
                            StreamParser.safeClose(inputStream);
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                        throw th;
                    }
                    if (inputStream == null) {
                        try {
                            StreamParser.safeClose((Closeable) null);
                            return;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            return;
                        }
                    }
                    final long j = i3;
                    if (j >= 0) {
                        try {
                            if (tTNetFetchState.tempFileLength > 0 && i2 != 206) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                            callMDLHandleException(fetchImage, -1, i2, e);
                            StreamParser.safeClose(inputStream);
                            return;
                        }
                        if (j > 0) {
                            throw new BDException(BDErrorCodeConst.BD_ERROR_CODE_DATA_PARSE, BDErrorCodeConst.BD_ERROR_MSG_DATA_PARSE);
                        }
                        tTNetFetchState.completeRunnable = new Runnable() { // from class: com.facebook.net.FrescoTTNetFetcher.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(FrescoTTNetFetcher.IMAGE_SIZE, j);
                                    FrescoTTNetFetcher.this.handleMDLFetchState(hashMap2, (String) hashMap2.get(FrescoTTNetFetcher.HEADER_MD5), tTNetFetchState);
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    tTNetFetchState.requestStartTime = currentTimeMillis;
                                    tTNetFetchState.fetchCompleteTime = currentTimeMillis2;
                                    ResponseWrap responseWrap = new ResponseWrap();
                                    responseWrap.url = uri2;
                                    responseWrap.headers = hashMap2;
                                    jSONObject.put("http_status", i2);
                                    jSONObject.put("requestId", tTNetFetchState.getId());
                                    jSONObject.put("retryCount", tTNetFetchState.retryCount);
                                    FrescoTTNetFetcher.this.handleRequestTime(jSONObject, tTNetFetchState);
                                    FrescoTTNetFetcher.this.handleRequest(tTNetFetchState, true, tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime);
                                    jSONObject.put("netClientType", "MDLClient");
                                    if (FrescoTTNetFetcher.sImageCallBack != null) {
                                        FrescoTTNetFetcher.sImageCallBack.onImageOkCallBack(tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime, tTNetFetchState.submitTime, responseWrap, null, null, jSONObject);
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                        };
                        callback.onResponse(inputStream, (int) j);
                        StreamParser.safeClose(inputStream);
                        return;
                    }
                    j = 0;
                    if (j > 0) {
                    }
                }

                public void onFailure(int i2, int i3, String str, Throwable th) {
                    if (FrescoTTNetFetcher.DEBUG_MDL) {
                        Log.d(FrescoTTNetFetcher.TAG, "onFailure: code = " + i3 + ", message = " + str + ", throwable = " + th);
                    }
                    this.completeReadResponse = System.currentTimeMillis();
                    callMDLHandleException(fetchImage, i2, i3, new Exception(str));
                }

                public void onCancellation() {
                    if (FrescoTTNetFetcher.DEBUG_MDL) {
                        Log.d(FrescoTTNetFetcher.TAG, "onCancellation----");
                    }
                }

                private void callMDLHandleException(IRequest iRequest, int i2, int i3, Exception exc) {
                    if (i2 >= 0 && tTNetFetchState.retryCount < RetryInterceptManager.inst().getMDLRetryCount()) {
                        tTNetFetchState.retryCount++;
                        FrescoTTNetFetcher.this.fetchWithMDL(tTNetFetchState, callback, false);
                        return;
                    }
                    long j = tTNetFetchState.submitTime;
                    long j2 = tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime;
                    if (j2 <= 0) {
                        j2 = System.currentTimeMillis() - tTNetFetchState.submitTime;
                    }
                    long j3 = j2;
                    ResponseWrap responseWrap = new ResponseWrap();
                    responseWrap.url = uri2;
                    if (FrescoTTNetFetcher.sImageCallBack != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("requestId", tTNetFetchState.getId());
                            jSONObject.put("retryCount", tTNetFetchState.retryCount);
                            jSONObject.put("http_status", i3);
                            jSONObject.put("netClientType", "MDLClient");
                            FrescoTTNetFetcher.sImageCallBack.onImageErrorCallBack(j3, j, responseWrap, null, exc, jSONObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        if (callback != null) {
                            if (FrescoTTNetFetcher.DEBUG_MDL) {
                                Log.d(FrescoTTNetFetcher.TAG, "callMDLHandleException: type = " + i2);
                            }
                            if (iRequest != null && iRequest.isCanceled()) {
                                callback.onCancellation();
                            } else {
                                callback.onFailure(exc);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            FLog.m430d(TAG, "fetchWithMDL: t = " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchWithTtnet(TTNetFetchState tTNetFetchState, NetworkFetcher.Callback callback, boolean z) {
        IDownloadImage iDownloadImage;
        FetcherInterceptor fetcherInterceptor;
        String str;
        boolean z2;
        int i;
        int i2;
        Pair<Integer, Integer> size;
        tTNetFetchState.submitTime = System.currentTimeMillis();
        Uri uri = tTNetFetchState.getUri();
        if (uri == null) {
            return;
        }
        RequestUrlCallBack requestUrlCallBack = mRequestUrlCallBack;
        if (requestUrlCallBack != null && !requestUrlCallBack.canRequestUrl(tTNetFetchState.getUri())) {
            try {
                ExpiredUrlException expiredUrlException = new ExpiredUrlException("The expired url does not request network");
                if (callback != null) {
                    callback.onFailure(expiredUrlException);
                }
                handleException(null, tTNetFetchState, expiredUrlException, null);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        FetcherInterceptorProvider fetcherInterceptorProvider = sFetcherInterceptorProvider;
        FetcherInterceptor interceptor = fetcherInterceptorProvider != null ? fetcherInterceptorProvider.getInterceptor() : null;
        String uri2 = uri.toString();
        if (mRequestUrlReplace != null && tTNetFetchState.getContext() != null && tTNetFetchState.getContext().getImageRequest() != null && tTNetFetchState.getContext().getImageRequest().isNeedReplaceUri()) {
            SizeDeterminer sizeDeterminer = tTNetFetchState.getContext().getImageRequest().getSizeDeterminer();
            if (sizeDeterminer == null || sizeDeterminer.getSize() == null || (size = sizeDeterminer.getSize()) == null) {
                i = 0;
                i2 = 0;
            } else {
                i2 = ((Integer) size.first).intValue();
                i = ((Integer) size.second).intValue();
            }
            uri2 = mRequestUrlReplace.replaceRequestUrl(uri2, tTNetFetchState.getContext().getCallerContext(), i2, i);
        }
        if (interceptor != null) {
            uri2 = interceptor.intercepterUrl(uri2);
        }
        String str2 = uri2;
        if (StringUtils.isEmpty(str2)) {
            return;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Pair parseUrl = UrlUtils.parseUrl(str2, linkedHashMap);
            String handleHttps = handleHttps((String) parseUrl.first, z);
            String str3 = (String) parseUrl.second;
            if (RetryInterceptManager.inst().isOpen()) {
                iDownloadImage = (IDownloadImage) RetryInterceptManager.inst().getRetrofitService(handleHttps, IDownloadImage.class);
            } else {
                iDownloadImage = (IDownloadImage) RetrofitUtils.createSsService(handleHttps, IDownloadImage.class);
            }
            FrescoRequestContext frescoRequestContext = new FrescoRequestContext(tTNetFetchState.getBackupUris(), tTNetFetchState.retryCount);
            LinkedList linkedList = new LinkedList();
            if (tTNetFetchState.tempFileLength > 0) {
                fetcherInterceptor = interceptor;
                linkedList.add(new Header("Range", "bytes=" + tTNetFetchState.tempFileLength + "-"));
            } else {
                fetcherInterceptor = interceptor;
            }
            if (tTNetFetchState.getContext() == null || tTNetFetchState.getContext().getImageRequest() == null) {
                str = null;
            } else {
                ImageRequest imageRequest = tTNetFetchState.getContext().getImageRequest();
                String publicKey = imageRequest.getPublicKey();
                String urlKey = imageRequest.getUrlKey();
                if (!TextUtils.isEmpty(publicKey) && !TextUtils.isEmpty(urlKey)) {
                    String encryptByPublicKey = EncryptUtil.encryptByPublicKey(publicKey, urlKey);
                    if (!TextUtils.isEmpty(encryptByPublicKey)) {
                        linkedList.add(new Header("imagex-decrypt-key", encryptByPublicKey));
                    }
                }
                str = urlKey;
            }
            try {
                if (CloudControl.getInitConfig().isEnableAddRequestHeader()) {
                    linkedList.add(new Header("Accept", "image/" + CloudControl.getExpectImageFormat()));
                }
            } catch (IllegalStateException unused) {
            }
            Map<String, String> httpHeader = tTNetFetchState.getContext().getImageRequest().getHttpHeader();
            if (httpHeader != null) {
                for (Map.Entry<String, String> entry : httpHeader.entrySet()) {
                    linkedList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
            if (iDownloadImage != null) {
                Call<TypedInput> dealAndGetCall = dealAndGetCall(linkedHashMap, str3, iDownloadImage, frescoRequestContext, linkedList, tTNetFetchState);
                addCancelCallback(tTNetFetchState, dealAndGetCall);
                NetworkParams.CdnConnectionQualitySamplerHook cdnConnectionQualitySamplerHook = NetworkParams.getCdnConnectionQualitySamplerHook();
                if (cdnConnectionQualitySamplerHook == null || !cdnConnectionQualitySamplerHook.cdnShouldSampling(str2)) {
                    z2 = false;
                } else {
                    CdnDeviceBandwidthSampler.getInstance().startSampling();
                    z2 = true;
                }
                dealAndGetCall.enqueue(new C03712(tTNetFetchState, fetcherInterceptor, str, z, frescoRequestContext, callback, z2, dealAndGetCall));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.net.FrescoTTNetFetcher$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C03712 implements ExpandCallback<TypedInput> {
        final /* synthetic */ Call val$call;
        final /* synthetic */ NetworkFetcher.Callback val$callback;
        final /* synthetic */ TTNetFetchState val$fetchState;
        final /* synthetic */ FetcherInterceptor val$finalInterceptor;
        final /* synthetic */ boolean val$finalIsCdnSampling;
        final /* synthetic */ RequestContext val$requestContext;
        final /* synthetic */ String val$urlKey;
        final /* synthetic */ boolean val$useHttps;
        HttpRequestInfo reqInfo = null;
        long completeReadResponse = -1;

        public void onAsyncPreRequest(RequestBuilder requestBuilder) {
        }

        public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
        }

        C03712(TTNetFetchState tTNetFetchState, FetcherInterceptor fetcherInterceptor, String str, boolean z, RequestContext requestContext, NetworkFetcher.Callback callback, boolean z2, Call call) {
            this.val$fetchState = tTNetFetchState;
            this.val$finalInterceptor = fetcherInterceptor;
            this.val$urlKey = str;
            this.val$useHttps = z;
            this.val$requestContext = requestContext;
            this.val$callback = callback;
            this.val$finalIsCdnSampling = z2;
            this.val$call = call;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0188 A[Catch: all -> 0x00bd, Exception -> 0x00c2, TRY_LEAVE, TryCatch #9 {all -> 0x00bd, blocks: (B:70:0x00aa, B:72:0x00b2, B:34:0x00c7, B:50:0x00e9, B:52:0x010b, B:54:0x0126, B:56:0x012c, B:58:0x013c, B:60:0x014e, B:39:0x0188, B:47:0x01ae, B:48:0x01b8, B:66:0x0112, B:68:0x0170), top: B:69:0x00aa }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x01ae A[Catch: all -> 0x00bd, Exception -> 0x00c2, TRY_ENTER, TryCatch #9 {all -> 0x00bd, blocks: (B:70:0x00aa, B:72:0x00b2, B:34:0x00c7, B:50:0x00e9, B:52:0x010b, B:54:0x0126, B:56:0x012c, B:58:0x013c, B:60:0x014e, B:39:0x0188, B:47:0x01ae, B:48:0x01b8, B:66:0x0112, B:68:0x0170), top: B:69:0x00aa }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x01db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAsyncResponse(final Call<TypedInput> call, final SsResponse<TypedInput> ssResponse) {
            Throwable th;
            InputStream in;
            long length;
            InputStream inputStream;
            long j;
            String headerForName;
            long j2;
            long j3;
            InputStream inputStream2 = null;
            try {
                try {
                    try {
                        this.completeReadResponse = System.currentTimeMillis();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e) {
                    e = e;
                }
                if (ssResponse == null) {
                    if (this.val$finalIsCdnSampling) {
                        CdnDeviceBandwidthSampler.getInstance().stopSampling();
                    }
                    try {
                        StreamParser.safeClose((Closeable) null);
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return;
                    }
                }
                FrescoTTNetFetcher.this.processResponse(this.val$fetchState, ssResponse);
                TypedInput typedInput = (TypedInput) ssResponse.body();
                if (!ssResponse.isSuccessful()) {
                    throw new IOException("Unexpected HTTP code " + ssResponse.code());
                }
                FetcherInterceptor fetcherInterceptor = this.val$finalInterceptor;
                if (fetcherInterceptor != null) {
                    Pair<InputStream, Long> intercepterStream = fetcherInterceptor.intercepterStream(typedInput.in(), ssResponse.raw().getUrl(), typedInput.length());
                    InputStream inputStream3 = (InputStream) intercepterStream.first;
                    try {
                        length = ((Long) intercepterStream.second).longValue();
                        in = inputStream3;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream2 = inputStream3;
                        callHandleException(ssResponse, e);
                        if (this.val$finalIsCdnSampling) {
                        }
                        StreamParser.safeClose(inputStream2);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream2 = inputStream3;
                        if (this.val$finalIsCdnSampling) {
                        }
                        try {
                            StreamParser.safeClose(inputStream2);
                            throw th;
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                            throw th;
                        }
                    }
                } else {
                    in = typedInput.in();
                    length = typedInput.length();
                }
                if (!TextUtils.isEmpty(this.val$urlKey)) {
                    try {
                        inputStream = new ByteArrayInputStream(AESEncrypt.decrypt(AESEncrypt.toByteArray(in), this.val$urlKey));
                    } catch (Exception e3) {
                        FLog.m430d(FrescoTTNetFetcher.TAG, "onAsyncResponse: decrypt e = " + e3);
                        e3.printStackTrace();
                    }
                    if (length >= 0) {
                        try {
                            try {
                            } catch (Throwable th6) {
                                th = th6;
                                inputStream2 = inputStream;
                                if (this.val$finalIsCdnSampling) {
                                    CdnDeviceBandwidthSampler.getInstance().stopSampling();
                                }
                                StreamParser.safeClose(inputStream2);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            inputStream2 = inputStream;
                            callHandleException(ssResponse, e);
                            if (this.val$finalIsCdnSampling) {
                                CdnDeviceBandwidthSampler.getInstance().stopSampling();
                            }
                            StreamParser.safeClose(inputStream2);
                            return;
                        }
                        if (this.val$fetchState.tempFileLength <= 0 || ssResponse.code() == 206) {
                            j = length;
                            final String headerForName2 = FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), FrescoTTNetFetcher.HEADER_MD5);
                            FrescoTTNetFetcher.this.handleFetchState(ssResponse, headerForName2, this.val$fetchState);
                            headerForName = FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), "x-imagex-blurhash");
                            if (TextUtils.isEmpty(headerForName)) {
                                j2 = 0;
                            } else {
                                try {
                                    BlurHashConfig blurHashOptions = this.val$fetchState.getContext().getImageRequest().getBlurHashOptions();
                                    WeakReference<BlurHashListener> listener = BlurHashMapUtils.getListener(this.val$fetchState.getUri());
                                    try {
                                        j3 = Long.parseLong(FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), FrescoTTNetFetcher.HEADER_LENGTH));
                                    } catch (Exception e5) {
                                        FLog.m430d(FrescoTTNetFetcher.TAG, "onAsyncResponse: contentLengthStr parser exception is: " + e5);
                                        j3 = -1;
                                    }
                                    if (listener != null && listener.get() != null && ImageBlurhashStrategy.getStrategy().isUseBlurhash(this.val$fetchState.getUri(), j3)) {
                                        long onBlurHashReady = listener.get().onBlurHashReady(headerForName, blurHashOptions);
                                        if (this.val$fetchState.getListener() != null) {
                                            HashMap hashMap = new HashMap(1);
                                            hashMap.put(FrescoTTNetFetcher.BLURHASH_DECODE_DURATION, String.valueOf(onBlurHashReady));
                                            this.val$fetchState.getListener().onProducerFinishWithSuccess(this.val$fetchState.getId(), FrescoTTNetFetcher.BLURHASH_PRODUCER_NAME, hashMap);
                                        }
                                    }
                                } catch (Exception e6) {
                                    FLog.m430d(FrescoTTNetFetcher.TAG, "onAsyncResponse: blurhash exception is " + e6);
                                }
                                j2 = 0;
                            }
                            if (j <= j2) {
                                throw new BDException(BDErrorCodeConst.BD_ERROR_CODE_DATA_PARSE, BDErrorCodeConst.BD_ERROR_MSG_DATA_PARSE);
                            }
                            final long j4 = j;
                            this.val$fetchState.completeRunnable = new Runnable() { // from class: com.facebook.net.FrescoTTNetFetcher.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put(FrescoTTNetFetcher.IMAGE_SIZE, j4);
                                        try {
                                            IMetricsCollect iMetricsCollect = call;
                                            if (iMetricsCollect instanceof IMetricsCollect) {
                                                iMetricsCollect.doCollect();
                                            }
                                            Object extraInfo = ssResponse.raw().getExtraInfo();
                                            if (extraInfo instanceof HttpRequestInfo) {
                                                C03712.this.reqInfo = (HttpRequestInfo) extraInfo;
                                            }
                                        } catch (Throwable th7) {
                                            th7.printStackTrace();
                                        }
                                        FrescoTTNetFetcher.this.checkLegal(C03712.this.val$fetchState, headerForName2, C03712.this.val$useHttps, ssResponse.headers(), j4);
                                        if (C03712.this.reqInfo != null) {
                                            long currentTimeMillis = System.currentTimeMillis();
                                            C03712.this.val$fetchState.requestStartTime = C03712.this.reqInfo.requestStart;
                                            C03712.this.val$fetchState.fetchCompleteTime = currentTimeMillis;
                                            C03712.this.reqInfo.completeReadResponse = C03712.this.completeReadResponse;
                                            C03712.this.reqInfo.requestEnd = currentTimeMillis;
                                            FrescoTTNetFetcher.getOutIp(C03712.this.reqInfo, ssResponse.headers(), C03712.this.val$requestContext, null);
                                            C03712.this.val$fetchState.retryCount += FrescoTTNetFetcher.this.getRetryCount(C03712.this.reqInfo);
                                            jSONObject.put("retryCount", C03712.this.val$fetchState.retryCount);
                                        }
                                        ResponseWrap responseWrap = new ResponseWrap();
                                        responseWrap.ssResponse = ssResponse;
                                        responseWrap.url = ssResponse.raw().getUrl();
                                        jSONObject.put("http_status", ssResponse.code());
                                        jSONObject.put("requestId", C03712.this.val$fetchState.getId());
                                        FrescoTTNetFetcher.this.handleRequestTime(jSONObject, C03712.this.val$fetchState);
                                        if (FrescoTTNetFetcher.sImageCallBack != null) {
                                            FrescoTTNetFetcher.sImageCallBack.onImageOkCallBack(C03712.this.val$fetchState.fetchCompleteTime - C03712.this.val$fetchState.submitTime, C03712.this.val$fetchState.submitTime, responseWrap, C03712.this.reqInfo, null, jSONObject);
                                        }
                                        FrescoTTNetFetcher.this.handleRequest(C03712.this.val$fetchState, true, C03712.this.val$fetchState.fetchCompleteTime - C03712.this.val$fetchState.submitTime);
                                    } catch (JSONException unused) {
                                    }
                                }
                            };
                            this.val$callback.onResponse(inputStream, (int) j);
                            if (this.val$finalIsCdnSampling) {
                                CdnDeviceBandwidthSampler.getInstance().stopSampling();
                            }
                            StreamParser.safeClose(inputStream);
                            return;
                        }
                    }
                    j = 0;
                    final String headerForName22 = FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), FrescoTTNetFetcher.HEADER_MD5);
                    FrescoTTNetFetcher.this.handleFetchState(ssResponse, headerForName22, this.val$fetchState);
                    headerForName = FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), "x-imagex-blurhash");
                    if (TextUtils.isEmpty(headerForName)) {
                    }
                    if (j <= j2) {
                    }
                }
                inputStream = in;
                if (length >= 0) {
                }
                j = 0;
                final String headerForName222 = FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), FrescoTTNetFetcher.HEADER_MD5);
                FrescoTTNetFetcher.this.handleFetchState(ssResponse, headerForName222, this.val$fetchState);
                headerForName = FrescoTTNetFetcher.getHeaderForName(ssResponse.headers(), "x-imagex-blurhash");
                if (TextUtils.isEmpty(headerForName)) {
                }
                if (j <= j2) {
                }
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
        }

        public void onFailure(Call<TypedInput> call, Throwable th) {
            this.completeReadResponse = System.currentTimeMillis();
            if (this.val$finalIsCdnSampling) {
                CdnDeviceBandwidthSampler.getInstance().stopSampling();
            }
            callHandleException(null, th instanceof Exception ? (Exception) th : new Exception(th.getMessage(), th.getCause()));
        }

        private void callHandleException(SsResponse ssResponse, Exception exc) {
            Exception exc2;
            HttpResponseException httpResponseException;
            if (FrescoTTNetFetcher.DEBUG_MDL) {
                Log.d(FrescoTTNetFetcher.TAG, "callHandleException:  e = " + exc);
            }
            if (exc == null) {
                return;
            }
            if (exc instanceof RetryInterceptManager.RetryWrapException) {
                RetryInterceptManager.RetryWrapException retryWrapException = (RetryInterceptManager.RetryWrapException) exc;
                exc2 = retryWrapException.f367e;
                this.val$fetchState.retryCount += retryWrapException.retryCount;
            } else {
                exc2 = exc;
            }
            boolean z = true;
            if (exc instanceof RetryHttpsException) {
                FrescoTTNetFetcher.this.fetchWithTtnet(this.val$fetchState, this.val$callback, true);
                return;
            }
            if (RetryInterceptManager.inst().isOpen()) {
                if (this.val$fetchState.retryCount < FrescoTTNetFetcher.this.getMaxRetryCount(this.val$fetchState)) {
                    this.val$fetchState.retryCount++;
                    FrescoTTNetFetcher.this.fetchWithTtnet(this.val$fetchState, this.val$callback, false);
                    return;
                }
            }
            if ((exc2 instanceof HttpResponseException) && (httpResponseException = (HttpResponseException) exc2) != null && httpResponseException.getStatusCode() == 304) {
                z = false;
            }
            if (exc2 instanceof CronetIOException) {
                CronetIOException cronetIOException = (CronetIOException) exc2;
                HttpRequestInfo requestInfo = cronetIOException.getRequestInfo();
                if (requestInfo instanceof HttpRequestInfo) {
                    this.reqInfo = requestInfo;
                } else {
                    HttpRequestInfo httpRequestInfo = new HttpRequestInfo();
                    this.reqInfo = httpRequestInfo;
                    httpRequestInfo.httpClientType = 0;
                    this.reqInfo.requestLog = cronetIOException.getRequestLog();
                }
            }
            if (z) {
                try {
                    if (this.reqInfo == null) {
                        IRequestInfo iRequestInfo = this.val$call;
                        if (iRequestInfo instanceof IRequestInfo) {
                            Object requestInfo2 = iRequestInfo.getRequestInfo();
                            if (requestInfo2 instanceof HttpRequestInfo) {
                                this.reqInfo = (HttpRequestInfo) requestInfo2;
                            }
                        }
                    }
                    if (this.reqInfo == null) {
                        IMetricsCollect iMetricsCollect = this.val$call;
                        if ((iMetricsCollect instanceof IMetricsCollect) && ssResponse != null) {
                            iMetricsCollect.doCollect();
                            this.reqInfo = (HttpRequestInfo) ssResponse.raw().getExtraInfo();
                        }
                    }
                    FrescoTTNetFetcher.getOutIp(this.reqInfo, ssResponse != null ? ssResponse.headers() : null, this.val$requestContext, exc2);
                    HttpRequestInfo httpRequestInfo2 = this.reqInfo;
                    if (httpRequestInfo2 != null) {
                        httpRequestInfo2.requestEnd = System.currentTimeMillis();
                        if (this.reqInfo.completeReadResponse <= 0) {
                            this.reqInfo.completeReadResponse = this.completeReadResponse;
                        }
                        if (this.reqInfo.extraInfo != null) {
                            try {
                                this.reqInfo.extraInfo.put("ex", exc2.getMessage());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    FrescoTTNetFetcher.this.handleException(ssResponse, this.val$fetchState, exc2, this.reqInfo);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                if (this.val$callback != null) {
                    Call call = this.val$call;
                    if (call != null && call.isCanceled()) {
                        this.val$callback.onCancellation();
                    } else {
                        this.val$callback.onFailure(exc2);
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class SimpleNetFetchState {
        private List<Uri> backUris;
        private int mCurrentPos;
        private int retryCount;
        private Uri uri;

        static /* synthetic */ int access$1208(SimpleNetFetchState simpleNetFetchState) {
            int i = simpleNetFetchState.mCurrentPos;
            simpleNetFetchState.mCurrentPos = i + 1;
            return i;
        }

        public SimpleNetFetchState(Uri uri) {
            this(uri, null, 0);
        }

        public SimpleNetFetchState(Uri uri, List<Uri> list, int i) {
            this.mCurrentPos = 0;
            this.uri = uri;
            this.backUris = list;
            this.retryCount = i;
        }

        public Uri getUri() {
            List<Uri> list = this.backUris;
            if (list == null) {
                return this.uri;
            }
            int i = this.retryCount;
            if (i == 0) {
                int i2 = this.mCurrentPos;
                return i2 == 0 ? this.uri : list.get(i2 - 1);
            }
            if (this.mCurrentPos <= i) {
                return this.uri;
            }
            return list.get((r2 / (i + 1)) - 1);
        }

        public List<Uri> getBackUris() {
            return this.backUris;
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public int getMaxRetryCount() {
            int i = this.retryCount;
            if (i == 0) {
                List<Uri> list = this.backUris;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            int i2 = i + 1;
            List<Uri> list2 = this.backUris;
            return i2 * (list2 != null ? 1 + list2.size() : 1);
        }
    }

    public void fetchSimpleWithTtnet(final SimpleNetFetchState simpleNetFetchState, final Map<String, String> map, final Priority priority, final NetworkFetcher.Callback callback, final boolean z) {
        LinkedHashMap linkedHashMap;
        Pair parseUrl;
        IDownloadImage iDownloadImage;
        boolean z2;
        Uri uri = simpleNetFetchState.getUri();
        if (uri == null) {
            return;
        }
        FetcherInterceptorProvider fetcherInterceptorProvider = sFetcherInterceptorProvider;
        final FetcherInterceptor interceptor = fetcherInterceptorProvider != null ? fetcherInterceptorProvider.getInterceptor() : null;
        String uri2 = uri.toString();
        if (interceptor != null) {
            uri2 = interceptor.intercepterUrl(uri2);
        }
        if (StringUtils.isEmpty(uri2)) {
            return;
        }
        try {
            linkedHashMap = new LinkedHashMap();
            parseUrl = UrlUtils.parseUrl(uri2, linkedHashMap);
        } catch (Exception e) {
            e = e;
        }
        try {
            String handleHttps = handleHttps((String) parseUrl.first, z);
            String str = (String) parseUrl.second;
            if (RetryInterceptManager.inst().isOpen()) {
                iDownloadImage = (IDownloadImage) RetryInterceptManager.inst().getRetrofitService(handleHttps, IDownloadImage.class);
            } else {
                iDownloadImage = (IDownloadImage) RetrofitUtils.createSsService(handleHttps, IDownloadImage.class);
            }
            IDownloadImage iDownloadImage2 = iDownloadImage;
            FrescoRequestContext frescoRequestContext = new FrescoRequestContext(simpleNetFetchState.getBackUris(), simpleNetFetchState.getRetryCount());
            LinkedList linkedList = new LinkedList();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    linkedList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
            if (iDownloadImage2 != null) {
                Call<TypedInput> dealAndGetSimpleCall = dealAndGetSimpleCall(linkedHashMap, str, iDownloadImage2, frescoRequestContext, linkedList, priority);
                NetworkParams.CdnConnectionQualitySamplerHook cdnConnectionQualitySamplerHook = NetworkParams.getCdnConnectionQualitySamplerHook();
                if (cdnConnectionQualitySamplerHook == null || !cdnConnectionQualitySamplerHook.cdnShouldSampling(uri2)) {
                    z2 = false;
                } else {
                    CdnDeviceBandwidthSampler.getInstance().startSampling();
                    z2 = true;
                }
                final boolean z3 = z2;
                dealAndGetSimpleCall.enqueue(new ExpandCallback<TypedInput>() { // from class: com.facebook.net.FrescoTTNetFetcher.3
                    HttpRequestInfo reqInfo = null;
                    long completeReadResponse = -1;

                    public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                    }

                    public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                    }

                    public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                        InputStream in;
                        long length;
                        InputStream inputStream = null;
                        try {
                            try {
                                this.completeReadResponse = System.currentTimeMillis();
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        } catch (Exception unused) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (ssResponse == null) {
                            if (z3) {
                                CdnDeviceBandwidthSampler.getInstance().stopSampling();
                            }
                            try {
                                StreamParser.safeClose((Closeable) null);
                                return;
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                                return;
                            }
                        }
                        FrescoTTNetFetcher.this.processResponse(null, ssResponse);
                        TypedInput typedInput = (TypedInput) ssResponse.body();
                        if (!ssResponse.isSuccessful()) {
                            throw new IOException("Unexpected HTTP code " + ssResponse.code());
                        }
                        FetcherInterceptor fetcherInterceptor = interceptor;
                        if (fetcherInterceptor != null) {
                            Pair<InputStream, Long> intercepterStream = fetcherInterceptor.intercepterStream(typedInput.in(), ssResponse.raw().getUrl(), typedInput.length());
                            in = (InputStream) intercepterStream.first;
                            try {
                                length = ((Long) intercepterStream.second).longValue();
                            } catch (Exception unused2) {
                                inputStream = in;
                                if (z3) {
                                    CdnDeviceBandwidthSampler.getInstance().stopSampling();
                                }
                                StreamParser.safeClose(inputStream);
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = in;
                                if (z3) {
                                    CdnDeviceBandwidthSampler.getInstance().stopSampling();
                                }
                                try {
                                    StreamParser.safeClose(inputStream);
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                                throw th;
                            }
                        } else {
                            in = typedInput.in();
                            length = typedInput.length();
                        }
                        if (length <= 0) {
                            throw new BDException(BDErrorCodeConst.BD_ERROR_CODE_DATA_PARSE, BDErrorCodeConst.BD_ERROR_MSG_DATA_PARSE);
                        }
                        callback.onResponse(in, (int) length);
                        if (z3) {
                            CdnDeviceBandwidthSampler.getInstance().stopSampling();
                        }
                        StreamParser.safeClose(in);
                    }

                    public void onFailure(Call<TypedInput> call, Throwable th) {
                        this.completeReadResponse = System.currentTimeMillis();
                        if (z3) {
                            CdnDeviceBandwidthSampler.getInstance().stopSampling();
                        }
                        if (simpleNetFetchState.mCurrentPos < simpleNetFetchState.getMaxRetryCount() - 1) {
                            SimpleNetFetchState.access$1208(simpleNetFetchState);
                            FrescoTTNetFetcher.this.fetchSimpleWithTtnet(simpleNetFetchState, map, priority, callback, z);
                        } else {
                            callback.onFailure(th);
                        }
                    }
                });
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.net.FrescoTTNetFetcher$6 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C03756 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$common$Priority;

        static {
            int[] iArr = new int[Priority.values().length];
            $SwitchMap$com$facebook$imagepipeline$common$Priority = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$common$Priority[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected Call<TypedInput> dealAndGetSimpleCall(Map<String, String> map, String str, IDownloadImage iDownloadImage, RequestContext requestContext, List<Header> list, Priority priority) {
        if (this.mEnableNetworkPriority) {
            int i = C03756.$SwitchMap$com$facebook$imagepipeline$common$Priority[priority.ordinal()];
            if (i == 1) {
                return iDownloadImage.downloadFileForLow(false, -1, str, map, list, requestContext);
            }
            if (i == 2) {
                return iDownloadImage.downloadFileForNormal(false, -1, str, map, list, requestContext);
            }
            if (i == 3) {
                return iDownloadImage.downloadFileForHigh(false, -1, str, map, list, requestContext);
            }
            if (i == 4) {
                return iDownloadImage.downloadFileForImmediate(false, -1, str, map, list, requestContext);
            }
            return iDownloadImage.downloadFileForNormal(false, -1, str, map, list, requestContext);
        }
        return iDownloadImage.downloadFileForNormal(false, -1, str, map, list, requestContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFetchState(SsResponse<TypedInput> ssResponse, String str, TTNetFetchState tTNetFetchState) {
        tTNetFetchState.hitCdnCache = AddressParam.TYPE_DISAPPROVE;
        List<Header> cdnCacheHeaders = getCdnCacheHeaders(ssResponse);
        if (!CollectionUtils.isEmpty(cdnCacheHeaders)) {
            for (Header header : cdnCacheHeaders) {
                if (header != null) {
                    String value = header.getValue();
                    if ((!TextUtils.isEmpty(value) && value.toLowerCase(Locale.US).contains("hit")) || ("Via".equals(header.getName()) && ("cHs f".equals(value) || "cRs f".equals(value)))) {
                        tTNetFetchState.hitCdnCache = "1";
                        break;
                    }
                }
            }
        } else {
            tTNetFetchState.hitCdnCache = "-1";
        }
        try {
            Header firstHeader = ssResponse.raw().getFirstHeader("x-response-cache");
            if (firstHeader != null) {
                tTNetFetchState.xResponseCache = firstHeader.getValue();
            } else {
                tTNetFetchState.xResponseCache = "undefined";
            }
            String headerForName = getHeaderForName(ssResponse.headers(), "X-Crop-Rs");
            if (!TextUtils.isEmpty(headerForName)) {
                String replace = headerForName.replace("(", "").replace(")", "").replace("-", ",").replace(",", " ");
                if (checkXCropRs(Rect.unflattenFromString(replace))) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("regionToDecode", replace);
                    tTNetFetchState.setEncodeImageExtraInfo(hashMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tTNetFetchState.setNeedMd5(!TextUtils.isEmpty(str) && RetryInterceptManager.inst().isMd5Open());
        handleDemotion(ssResponse, tTNetFetchState);
        String headerForName2 = getHeaderForName(ssResponse.headers(), X_IMAGEX_EXTRA);
        tTNetFetchState.xImageXExtra = headerForName2 != null ? headerForName2 : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMDLFetchState(Map<String, String> map, String str, TTNetFetchState tTNetFetchState) {
        tTNetFetchState.hitCdnCache = AddressParam.TYPE_DISAPPROVE;
        String[] strArr = {"X-Cache", "X-Cache-new", "X-Cache-Status", "via", "X-Via-Ucdn", "X-Cache-Lookup", "X-Response-Cache", "Ctl-Cache-Status", "Via"};
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            String str2 = map.get(strArr[i]);
            if (!TextUtils.isEmpty(str2) && str2.toLowerCase(Locale.US).contains("hit")) {
                tTNetFetchState.hitCdnCache = "1";
                break;
            }
        }
        try {
            String str3 = map.get("X-Response-Cache");
            if (!TextUtils.isEmpty(str3)) {
                tTNetFetchState.xResponseCache = str3;
            } else {
                tTNetFetchState.xResponseCache = "undefined";
            }
            String str4 = map.get("X-Crop-Rs");
            if (!TextUtils.isEmpty(str4)) {
                String replace = str4.replace("(", "").replace(")", "").replace("-", ",").replace(",", " ");
                if (checkXCropRs(Rect.unflattenFromString(replace))) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("regionToDecode", replace);
                    tTNetFetchState.setEncodeImageExtraInfo(hashMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && RetryInterceptManager.inst().isMd5Open()) {
            z = true;
        }
        tTNetFetchState.setNeedMd5(z);
        handleMDLDemotion(map, tTNetFetchState);
        String str5 = map.get(X_IMAGEX_EXTRA);
        if (TextUtils.isEmpty(str5)) {
            str5 = map.get("X-Imagex-Extra");
        }
        tTNetFetchState.xImageXExtra = str5 != null ? str5 : "";
    }

    private List<Header> getCdnCacheHeaders(SsResponse<TypedInput> ssResponse) {
        String[] strArr = {"X-Cache", "X-Cache-new", "X-Cache-Status", "via", "X-Via-Ucdn", "X-Cache-Lookup", "X-Response-Cache", "Ctl-Cache-Status", "Via"};
        for (int i = 0; i < 9; i++) {
            List<Header> headers = ssResponse.raw().headers(strArr[i]);
            if (headers != null && headers.size() > 0) {
                return headers;
            }
        }
        return null;
    }

    private void handleDemotion(SsResponse<TypedInput> ssResponse, TTNetFetchState tTNetFetchState) {
        String headerForName = getHeaderForName(ssResponse.headers(), "ImageX-Demotion");
        if (headerForName == null) {
            headerForName = "undefined";
        }
        tTNetFetchState.imagexDemotion = headerForName;
        String headerForName2 = getHeaderForName(ssResponse.headers(), "ImageX-Fmt");
        String[] split = headerForName2 == null ? null : headerForName2.split("2");
        if (split != null && split.length > 0) {
            tTNetFetchState.imagexWantFmt = split[0];
            if (split.length > 1) {
                tTNetFetchState.imagexTrueFmt = split[1];
            } else {
                tTNetFetchState.imagexTrueFmt = "undefined";
            }
        } else {
            tTNetFetchState.imagexWantFmt = "undefined";
            tTNetFetchState.imagexTrueFmt = "undefined";
        }
        if (!"undefined".equals(tTNetFetchState.imagexWantFmt) && !"undefined".equals(tTNetFetchState.imagexTrueFmt)) {
            tTNetFetchState.imagexConsistency = tTNetFetchState.imagexWantFmt.equalsIgnoreCase(tTNetFetchState.imagexTrueFmt) ? "1" : AddressParam.TYPE_DISAPPROVE;
        } else {
            tTNetFetchState.imagexConsistency = "-1";
        }
    }

    private void handleMDLDemotion(Map<String, String> map, TTNetFetchState tTNetFetchState) {
        String str = map.get("ImageX-Demotion");
        if (str == null) {
            str = "undefined";
        }
        tTNetFetchState.imagexDemotion = str;
        String str2 = map.get("Imagex-Fmt");
        String[] split = str2 == null ? null : str2.split("2");
        if (split != null && split.length > 0) {
            tTNetFetchState.imagexWantFmt = split[0];
            if (split.length > 1) {
                tTNetFetchState.imagexTrueFmt = split[1];
            } else {
                tTNetFetchState.imagexTrueFmt = "undefined";
            }
        } else {
            tTNetFetchState.imagexWantFmt = "undefined";
            tTNetFetchState.imagexTrueFmt = "undefined";
        }
        if (!"undefined".equals(tTNetFetchState.imagexWantFmt) && !"undefined".equals(tTNetFetchState.imagexTrueFmt)) {
            tTNetFetchState.imagexConsistency = tTNetFetchState.imagexWantFmt.equalsIgnoreCase(tTNetFetchState.imagexTrueFmt) ? "1" : AddressParam.TYPE_DISAPPROVE;
        } else {
            tTNetFetchState.imagexConsistency = "-1";
        }
    }

    private boolean checkXCropRs(Rect rect) {
        return rect != null && !rect.isEmpty() && rect.left >= 0 && rect.top >= 0;
    }

    private void addCancelCallback(TTNetFetchState tTNetFetchState, final Call<TypedInput> call) {
        tTNetFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.net.FrescoTTNetFetcher.4
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    FrescoTTNetFetcher.this.mCancellationExecutor.execute(new Runnable() { // from class: com.facebook.net.FrescoTTNetFetcher.4.1
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
    }

    private void addCancelCallback(TTNetFetchState tTNetFetchState, final IRequest iRequest) {
        tTNetFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.net.FrescoTTNetFetcher.5
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public void onCancellationRequested() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    FrescoTTNetFetcher.this.mCancellationExecutor.execute(new Runnable() { // from class: com.facebook.net.FrescoTTNetFetcher.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            iRequest.cancel();
                        }
                    });
                } else {
                    iRequest.cancel();
                }
            }
        });
    }

    protected Call<TypedInput> dealAndGetCall(Map<String, String> map, String str, IDownloadImage iDownloadImage, RequestContext requestContext, List<Header> list, TTNetFetchState tTNetFetchState) {
        boolean isEnableNetworkPriority = (tTNetFetchState == null || tTNetFetchState.getContext() == null || tTNetFetchState.getContext().getImageRequest() == null) ? false : tTNetFetchState.getContext().getImageRequest().isEnableNetworkPriority();
        if (this.mEnableNetworkPriority || isEnableNetworkPriority) {
            int i = C03756.$SwitchMap$com$facebook$imagepipeline$common$Priority[tTNetFetchState.getContext().getPriority().ordinal()];
            if (i == 1) {
                return iDownloadImage.downloadFileForLow(false, -1, str, map, list, requestContext);
            }
            if (i == 2) {
                return iDownloadImage.downloadFileForNormal(false, -1, str, map, list, requestContext);
            }
            if (i == 3) {
                return iDownloadImage.downloadFileForHigh(false, -1, str, map, list, requestContext);
            }
            if (i == 4) {
                return iDownloadImage.downloadFileForImmediate(false, -1, str, map, list, requestContext);
            }
            return iDownloadImage.downloadFileForNormal(false, -1, str, map, list, requestContext);
        }
        return iDownloadImage.downloadFileForNormal(false, -1, str, map, list, requestContext);
    }

    protected String getUrl(TTNetFetchState tTNetFetchState) {
        Uri uri = tTNetFetchState.getUri();
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        if (StringUtils.isEmpty(uri2)) {
            return null;
        }
        return uri2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getMaxRetryCount(TTNetFetchState tTNetFetchState) {
        List<Uri> backupUris = tTNetFetchState.getBackupUris();
        if (backupUris == null || backupUris.isEmpty()) {
            return 0;
        }
        return backupUris.size();
    }

    protected InputStream processResponse(TTNetFetchState tTNetFetchState, SsResponse<TypedInput> ssResponse) throws IOException {
        if (!ssResponse.isSuccessful()) {
            throw new IOException("Unexpected HTTP code " + ssResponse.code());
        }
        return ((TypedInput) ssResponse.body()).in();
    }

    protected void checkLegal(TTNetFetchState tTNetFetchState, String str, boolean z, List<Header> list, long j) {
        long j2;
        if (z) {
            return;
        }
        try {
            j2 = Long.parseLong(getHeaderForName(list, HEADER_LENGTH));
        } catch (Exception unused) {
            j2 = -1;
        }
        if (j2 != -1 && j != -1 && j2 != j && RetryInterceptManager.inst().isContentLengthOpen()) {
            throw new RetryHttpsException("content-length does not match！！");
        }
        String headerForName = getHeaderForName(list, "Content-Type");
        if ((TextUtils.isEmpty(headerForName) || !headerForName.contains(LynxResourceModule.IMAGE_TYPE)) && RetryInterceptManager.inst().isContentTypeOpen()) {
            throw new RetryHttpsException("content-type does not match！！");
        }
        String md5 = tTNetFetchState.getMd5();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(md5) && !str.equals(md5)) {
            throw new RetryHttpsException("MD5 does not match！！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getOutIp(BaseHttpRequestInfo baseHttpRequestInfo, List<Header> list, RequestContext requestContext, Exception exc) {
        if (baseHttpRequestInfo == null) {
            return;
        }
        try {
            if (StringUtils.isEmpty(baseHttpRequestInfo.remoteIp)) {
                String str = null;
                if (list != null && list.size() > 0) {
                    for (Header header : list) {
                        if ("x-snssdk.remoteaddr".equalsIgnoreCase(header.getName())) {
                            str = header.getValue();
                        }
                    }
                }
                if (StringUtils.isEmpty(str) && requestContext != null) {
                    str = requestContext.remoteIp;
                }
                if (StringUtils.isEmpty(str)) {
                    str = getHostAddress(exc);
                }
                if (StringUtils.isEmpty(str) || baseHttpRequestInfo == null) {
                    return;
                }
                baseHttpRequestInfo.remoteIp = str;
                if (baseHttpRequestInfo.reqContext != null) {
                    baseHttpRequestInfo.reqContext.remoteIp = str;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getHeaderForName(List<Header> list, String str) {
        String str2 = null;
        if (list != null && list.size() > 0) {
            for (Header header : list) {
                if (str.equalsIgnoreCase(header.getName())) {
                    str2 = header.getValue();
                }
            }
        }
        return str2;
    }

    private String handleHttps(String str, boolean z) {
        return z ? str.replace("http://", "https://") : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRetryCount(HttpRequestInfo httpRequestInfo) {
        JSONObject jSONObject = httpRequestInfo.extraInfo;
        if (jSONObject == null) {
            return 0;
        }
        Object remove = jSONObject.remove("retryCount");
        if (remove instanceof Integer) {
            return ((Integer) remove).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[Catch: JSONException -> 0x0056, TRY_ENTER, TryCatch #0 {JSONException -> 0x0056, blocks: (B:2:0x0000, B:5:0x000c, B:8:0x0013, B:9:0x001f, B:12:0x0027, B:15:0x002e, B:16:0x003a, B:19:0x0043, B:22:0x004a, B:25:0x0053, B:27:0x0037, B:28:0x001c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRequestTime(JSONObject jSONObject, TTNetFetchState tTNetFetchState) {
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
    public void handleException(SsResponse ssResponse, TTNetFetchState tTNetFetchState, Throwable th, HttpRequestInfo httpRequestInfo) {
        if (tTNetFetchState != null) {
            try {
                long j = tTNetFetchState.submitTime;
                long j2 = tTNetFetchState.fetchCompleteTime - tTNetFetchState.submitTime;
                if (j2 <= 0) {
                    j2 = System.currentTimeMillis() - tTNetFetchState.submitTime;
                }
                long j3 = j2;
                String str = null;
                if (StringUtils.isEmpty((String) null)) {
                    if (ssResponse != null) {
                        str = ssResponse.raw().getUrl();
                    } else {
                        str = tTNetFetchState.getUri().toString();
                    }
                }
                if (Logger.debug() && th != null) {
                    Logger.d(TAG, "exception for ttnet response url = " + str + " exception = " + th.toString());
                }
                handleRequest(tTNetFetchState, false, j3);
                ResponseWrap responseWrap = new ResponseWrap();
                responseWrap.ssResponse = ssResponse;
                responseWrap.url = str;
                if (sImageCallBack != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestId", tTNetFetchState.getId());
                    jSONObject.put("retryCount", tTNetFetchState.retryCount);
                    jSONObject.put("http_status", getErrorCode(th));
                    sImageCallBack.onImageErrorCallBack(j3, j, responseWrap, httpRequestInfo, th, jSONObject);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private int getErrorCode(Throwable th) {
        if (th instanceof NetworkNotAvailabeException) {
            return 1003;
        }
        if (th instanceof CronetIOException) {
            return getErrCodeFromRequestLog(((CronetIOException) th).getRequestLog());
        }
        if (th instanceof HttpResponseException) {
            return ((HttpResponseException) th).getStatusCode();
        }
        if (th instanceof CdnCacheVerifyException) {
            return 1001;
        }
        if (th instanceof ClientProtocolException) {
            return 1002;
        }
        if (th instanceof NoHttpResponseException) {
            return 1004;
        }
        if (th instanceof NotAllowApiHttpException) {
            return 1005;
        }
        return th instanceof NotAllowUseNetworkException ? 1006 : 1000;
    }

    private int getErrCodeFromRequestLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("response");
            if (optJSONObject != null) {
                return optJSONObject.optInt("code");
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
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

    private int getImageRequestOrder(TTNetFetchState tTNetFetchState) {
        Uri uri;
        if (tTNetFetchState != null && tTNetFetchState.getContext() != null && tTNetFetchState.getContext().getCallerContext() != null) {
            Object callerContext = tTNetFetchState.getContext().getCallerContext();
            if ((callerContext instanceof TTCallerContext) && (uri = tTNetFetchState.getUri()) != null) {
                return ((TTCallerContext) callerContext).getUrlIndex(uri.toString());
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRequest(TTNetFetchState tTNetFetchState, boolean z, long j) {
        if (getImageRequestOrder(tTNetFetchState) == 1) {
            ImageStrategy.getInstance().handleImageRequest(tTNetFetchState.getUri().toString(), z, j, true);
        } else if (getImageRequestOrder(tTNetFetchState) == 0) {
            ImageStrategy.getInstance().handleImageRequest(tTNetFetchState.getUri().toString(), z, j, false);
        }
    }

    public static void setFetcherInterceptorProvider(FetcherInterceptorProvider fetcherInterceptorProvider) {
        sFetcherInterceptorProvider = fetcherInterceptorProvider;
    }
}
