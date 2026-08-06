package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.exception.IBDException;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.net.FrescoTTNetFetcher;
import com.facebook.net.ImageNetworkCallback;
import com.facebook.net.NetUtils;
import com.facebook.net.ResponseWrap;
import com.facebook.net.RetryInterceptManager;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.alog.middleware.ALogService;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.push.PushClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoTraceListener extends BaseRequestListener {
    public static final String ALOGTAG = "Fresco";
    private static final String CLIENT_CRONET = "CronetClient";
    public static final String CLIENT_MDL = "MDLClient";
    private static final String CLIENT_TT_OK3 = "TTOkhttp3Client";
    public static final String IMAGE_MONITOR_DATA = "image_monitor_data";
    private static final String NW_SESSION_TRACE = "Nw-Session-Trace";
    private static final String REMOTEIP = "x-net-info.remoteaddr";
    public static final String TAG = "FrescoTraceListener";
    private static ExecutorService sExecutor = Executors.newFixedThreadPool(1, new ThreadFactory() { // from class: com.optimize.statistics.FrescoTraceListener.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "fresco-trace-monitor");
        }
    });
    private ImageNetworkCallback mImageCallBack = new ImageNetworkCallback() { // from class: com.optimize.statistics.FrescoTraceListener.2
        public void onImageErrorCallBack(long j, long j2, ResponseWrap responseWrap, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
            handleImageNetMonitor(j, j2, responseWrap, httpRequestInfo, th, jSONObject);
        }

        public void onImageOkCallBack(long j, long j2, ResponseWrap responseWrap, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
            handleImageNetMonitor(j, j2, responseWrap, httpRequestInfo, th, jSONObject);
        }

        private void handleImageNetMonitor(long j, long j2, ResponseWrap responseWrap, HttpRequestInfo httpRequestInfo, Throwable th, JSONObject jSONObject) {
            Object remove = jSONObject.remove("requestId");
            Object remove2 = jSONObject.remove(DBDefinition.RETRY_COUNT);
            Object remove3 = jSONObject.remove("queue_time");
            Object remove4 = jSONObject.remove("fetch_time");
            Object remove5 = jSONObject.remove("netClientType");
            FrescoMonitor.imageNetCallBack(j, j2, responseWrap.url, httpRequestInfo, th, jSONObject);
            try {
                if (remove instanceof String) {
                    String str = (String) remove;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    int intValue = remove2 instanceof Integer ? ((Integer) remove2).intValue() : -1;
                    long longValue = remove3 instanceof Long ? ((Long) remove3).longValue() : -1L;
                    long longValue2 = remove4 instanceof Long ? ((Long) remove4).longValue() : -1L;
                    try {
                        RequestInfo requestInfo = (RequestInfo) FrescoTraceListener.this.mRequestInfoMap.get(str);
                        if (requestInfo == null) {
                            return;
                        }
                        JSONObject jSONObject2 = requestInfo.extra;
                        jSONObject2.put(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, true);
                        jSONObject2.put("http_status", jSONObject.optInt("http_status", 0));
                        jSONObject2.put("retry_count", intValue);
                        jSONObject2.put("queue_duration", longValue);
                        jSONObject2.put("download_duration", longValue2);
                        if ((remove5 instanceof String) && !TextUtils.isEmpty((String) remove5)) {
                            jSONObject2.put("netClientType", remove5);
                        }
                        FrescoTraceListener.packageRequestParameters(httpRequestInfo, jSONObject2);
                        FrescoTraceListener.packageResponseHeader(responseWrap, jSONObject2);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    };
    private ConcurrentHashMap<String, RequestInfo> mRequestInfoMap = new ConcurrentHashMap<>();

    public void onProducerEvent(String str, String str2, String str3) {
    }

    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
    }

    public boolean requiresExtraMap(String str) {
        return true;
    }

    public FrescoTraceListener() {
        FrescoTTNetFetcher.setImageCallBack(this.mImageCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void packageResponseHeader(ResponseWrap responseWrap, JSONObject jSONObject) {
        String str;
        String str2;
        try {
            if (responseWrap.ssResponse != null) {
                Header firstHeader = responseWrap.ssResponse.raw().getFirstHeader(NW_SESSION_TRACE);
                Header firstHeader2 = responseWrap.ssResponse.raw().getFirstHeader(REMOTEIP);
                str2 = firstHeader != null ? responseWrap.ssResponse.raw().getFirstHeader(NW_SESSION_TRACE).getValue() : "";
                if (firstHeader2 != null) {
                    str = responseWrap.ssResponse.raw().getFirstHeader(REMOTEIP).getValue();
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put("nw-session-trace", str2);
                    jSONObject.put("server_ip", str != null ? str : "");
                }
                str = "";
                if (str2 == null) {
                }
                jSONObject.put("nw-session-trace", str2);
                jSONObject.put("server_ip", str != null ? str : "");
            }
            if (responseWrap.response != null) {
                str2 = responseWrap.response.header(NW_SESSION_TRACE);
                str = responseWrap.response.header(NetworkUtils.PNAME_REMOTE_ADDRESS);
            } else if (responseWrap.headers != null) {
                str2 = (String) responseWrap.headers.get(NW_SESSION_TRACE);
                str = "";
            } else {
                str = "";
                str2 = str;
            }
            if (str2 == null) {
            }
            jSONObject.put("nw-session-trace", str2);
            jSONObject.put("server_ip", str != null ? str : "");
        } catch (Exception e) {
            if (StatLogUtils.IsDebug()) {
                StatLogUtils.m26e("packageResponseHeader " + Log.getStackTraceString(e));
            }
            e.printStackTrace();
        }
    }

    protected static void packageRequestParameters(HttpRequestInfo httpRequestInfo, JSONObject jSONObject) {
        if (httpRequestInfo == null || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("requestStart", httpRequestInfo.requestStart);
            jSONObject2.put("responseBack", httpRequestInfo.responseBack);
            jSONObject2.put("completeReadResponse", httpRequestInfo.completeReadResponse);
            jSONObject2.put("requestEnd", httpRequestInfo.requestEnd);
            jSONObject2.put("recycleCount", httpRequestInfo.recycleCount);
            if (httpRequestInfo.httpClientType == 0) {
                jSONObject2.put("timing_dns", httpRequestInfo.dnsTime);
                jSONObject2.put("timing_connect", httpRequestInfo.connectTime);
                jSONObject2.put("timing_ssl", httpRequestInfo.sslTime);
                jSONObject2.put("timing_send", httpRequestInfo.sendTime);
                jSONObject2.put("timing_wait", httpRequestInfo.ttfbMs);
                jSONObject2.put("timing_receive", httpRequestInfo.receiveTime);
                jSONObject2.put("timing_total", httpRequestInfo.totalTime);
                jSONObject2.put("timing_isSocketReused", httpRequestInfo.isSocketReused);
                jSONObject2.put("timing_totalSendBytes", httpRequestInfo.sentByteCount);
                jSONObject2.put("timing_totalReceivedBytes", httpRequestInfo.receivedByteCount);
                jSONObject2.put("timing_remoteIP", httpRequestInfo.remoteIp);
                jSONObject2.put(MonitorConstants.REQUEST_LOG, httpRequestInfo.requestLog);
            }
            if (httpRequestInfo.extraInfo != null) {
                jSONObject2.put("req_info", httpRequestInfo.extraInfo);
            }
            jSONObject2.put("download", httpRequestInfo.downloadFile);
            jSONObject.put("net_timing_detail", jSONObject2);
            if (HttpClient.isCronetClientEnable()) {
                jSONObject.put("netClientType", CLIENT_CRONET);
            } else {
                jSONObject.put("netClientType", CLIENT_TT_OK3);
            }
        } catch (JSONException e) {
            if (StatLogUtils.IsDebug()) {
                StatLogUtils.m26e("packageRequestParameters " + Log.getStackTraceString(e));
            }
            e.printStackTrace();
        }
    }

    private static String formatString(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    private static boolean isCanceledInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("Canceled") || str.contains("canceled");
    }

    public ImageNetworkCallback getImageNetworkCallback() {
        return this.mImageCallBack;
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        long time = getTime();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("FrescoMonitor#onRequestStart");
        }
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.requestId = str;
        requestInfo.requestStartTime = time;
        requestInfo.callerContext = obj;
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            if (FrescoMonitor.isReportImageMonitorDataEnabled()) {
                try {
                    jSONObject.put(IMAGE_MONITOR_DATA, new JSONObject());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            requestInfo.extra = jSONObject;
        }
        this.mRequestInfoMap.put(str, requestInfo);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public void onRequestSuccess(final ImageRequest imageRequest, final String str, boolean z) {
        final long time = getTime();
        sExecutor.submit(new Runnable() { // from class: com.optimize.statistics.FrescoTraceListener.3
            @Override // java.lang.Runnable
            public void run() {
                FrescoTraceListener.this.onRequestSuccessInternal(imageRequest, str, time);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0227  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onRequestSuccessInternal(ImageRequest imageRequest, String str, long j) {
        boolean optBoolean;
        int i;
        int i2;
        char c;
        int i3;
        String str2;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("FrescoMonitor#onImageLoaded");
        }
        RequestInfo remove = this.mRequestInfoMap.remove(str);
        if (remove == null) {
            return;
        }
        JSONObject jSONObject = remove.extra;
        if (FrescoMonitor.isReportHitCacheEnabled()) {
            optBoolean = imageRequest.getSourceUriType() == 0;
        } else {
            optBoolean = jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false);
        }
        boolean z = optBoolean;
        if (jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false) && FrescoMonitor.isEnableMonitorLog()) {
            ALogService.dSafely(ALOGTAG, formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms}", Long.valueOf(j), imageRequest.getSourceUri().toString(), str, Long.valueOf(getCurrentTime(Long.valueOf(remove.requestStartTime), j))));
        }
        try {
        } catch (JSONException e) {
            e = e;
        }
        try {
            if (remove.callerContext instanceof String) {
                jSONObject.put(FrescoMonitorConst.SCENE_TAG, remove.callerContext);
            } else if (remove.callerContext != null && !TextUtils.isEmpty(remove.callerContext.toString())) {
                jSONObject.put(FrescoMonitorConst.SCENE_TAG, remove.callerContext.toString());
            }
            SizeDeterminer sizeDeterminer = imageRequest.getSizeDeterminer();
            if (sizeDeterminer != null && sizeDeterminer.getView() != null) {
                Context context = sizeDeterminer.getView().getContext();
                if (context instanceof Activity) {
                    jSONObject.put("page_tag", ((Activity) context).getClass().getSimpleName());
                }
            }
            jSONObject.put("duration", getCurrentTime(Long.valueOf(remove.requestStartTime), j));
            jSONObject.put(FrescoMonitorConst.LOAD_STATUS, "success");
            jSONObject.put(FrescoMonitorConst.TIMESTAMP, Long.valueOf(remove.requestStartTime));
            jSONObject.put(FrescoMonitorConst.LOG_TYPE, FrescoMonitorConst.MONITOR_IMAGE_V2);
        } catch (JSONException e2) {
            e = e2;
            i = 0;
            FLog.e(TAG, e, "", new Object[i]);
            if (hookMonitor(imageRequest, str, remove.callerContext, jSONObject, true, z, false)) {
            }
        }
        try {
            jSONObject.put(FrescoMonitorConst.LOG_VERSION, 1);
            jSONObject.put("uri", imageRequest.getSourceUri().toString());
            jSONObject.put(FrescoMonitorConst.IMAGE_SDK_VERSION, BuildConfig.FRESCOVERSION);
            jSONObject.put(FrescoMonitorConst.RETRY_OPEN, RetryInterceptManager.inst().isOpen() ? 1 : 0);
            jSONObject.put(FrescoMonitorConst.SOURCE_URI_TYPE, imageRequest.getSourceUriType());
            jSONObject.put("network_quality", TTNetInit.getEffectiveConnectionType());
        } catch (JSONException e3) {
            e = e3;
            i = 0;
            FLog.e(TAG, e, "", new Object[i]);
            if (hookMonitor(imageRequest, str, remove.callerContext, jSONObject, true, z, false)) {
            }
        }
        if (hookMonitor(imageRequest, str, remove.callerContext, jSONObject, true, z, false)) {
            uriQueryParamToExtra(jSONObject);
            if (z) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject(IMAGE_MONITOR_DATA);
                    if (optJSONObject != null) {
                        i3 = 0;
                        try {
                            optJSONObject.put("image_status", 0);
                            if (optJSONObject.opt("image_origin") == null) {
                                optJSONObject.put("image_origin", 7);
                            }
                            optJSONObject.put("disk_cache_type", ImageMonitorUtils.mapCacheChoiceToDiskCacheType(imageRequest.getCacheChoice()));
                            jSONObject.put(FrescoMonitorConst.IMAGE_ORIGIN_SOURCE, optJSONObject.opt("image_origin"));
                        } catch (JSONException e4) {
                            e = e4;
                            i2 = i3;
                            FLog.e(TAG, e, "", new Object[i2]);
                            if (ExceedTheLimitBitmapMonitor.isExceedTheLimitBitmapMonitorEnabled()) {
                            }
                            c = 1;
                            FrescoMonitor.onImageLoaded(true, str, jSONObject);
                            if (jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false)) {
                                Object[] objArr = new Object[5];
                                objArr[0] = Long.valueOf(j);
                                objArr[c] = imageRequest.getSourceUri().toString();
                                objArr[2] = str;
                                objArr[3] = Long.valueOf(getCurrentTime(Long.valueOf(remove.requestStartTime), j));
                                objArr[4] = jSONObject.optString(FrescoMonitorConst.SCENE_TAG);
                                ALogService.dSafely(ALOGTAG, formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms, scene_tag: %s}", objArr));
                            }
                            if (FrescoSystrace.isTracing()) {
                            }
                        }
                    } else {
                        i3 = 0;
                    }
                    jSONObject.put(FrescoMonitorConst.APPLIED_IMAGE_PX_COUNT, calAppliedImagePxCount(jSONObject));
                    jSONObject.put(FrescoMonitorConst.INTENDED_IMAGE_PX_COUNT, calIntendedImagePxCount(jSONObject));
                    jSONObject.put(FrescoMonitorConst.VIEW_NEEDED_IMAGE_PX_COUNT, calViewNeedImagePxCount(imageRequest));
                    jSONObject.put(FrescoMonitorConst.VIEW_SIZE, calViewImageSize(imageRequest));
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("BitmapMemoryCacheProducer");
                        long j2 = 0;
                        if (optJSONObject2 != null) {
                            int i4 = optJSONObject2.getInt("producer_end") - optJSONObject2.getInt("producer_start");
                            str2 = "producer_start";
                            j2 = 0 + i4;
                        } else {
                            str2 = "producer_start";
                        }
                        if (optJSONObject.optJSONObject("EncodedMemoryCacheProducer") != null) {
                            j2 += r3.getInt("producer_end") - r3.getInt(str2);
                        }
                        if (optJSONObject.optJSONObject("DiskCacheProducer") != null) {
                            j2 += r0.getInt("producer_end") - r0.getInt(str2);
                        }
                        jSONObject.put(FrescoMonitorConst.CACHE_SEEK_DURATION, j2);
                    }
                } catch (JSONException e5) {
                    e = e5;
                    i2 = 0;
                }
                if (ExceedTheLimitBitmapMonitor.isExceedTheLimitBitmapMonitorEnabled()) {
                    ExceedTheLimitBitmapMonitor.checkAndReport(imageRequest, jSONObject.optString(FrescoMonitorConst.IMAGE_TYPE), jSONObject.optInt(FrescoMonitorConst.IMAGE_COUNT), jSONObject.optString("biz_tag"), jSONObject.optString(FrescoMonitorConst.SCENE_TAG), jSONObject.optString(FrescoMonitorConst.APPLIED_IMAGE_SIZE), jSONObject.optLong(FrescoMonitorConst.FILE_SIZE), jSONObject.optString(FrescoMonitorConst.IMAGE_RAM_SIZE));
                }
                c = 1;
                FrescoMonitor.onImageLoaded(true, str, jSONObject);
            } else {
                c = 1;
            }
            if (jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false) && FrescoMonitor.isEnableMonitorLog()) {
                Object[] objArr2 = new Object[5];
                objArr2[0] = Long.valueOf(j);
                objArr2[c] = imageRequest.getSourceUri().toString();
                objArr2[2] = str;
                objArr2[3] = Long.valueOf(getCurrentTime(Long.valueOf(remove.requestStartTime), j));
                objArr2[4] = jSONObject.optString(FrescoMonitorConst.SCENE_TAG);
                ALogService.dSafely(ALOGTAG, formatString("time %d: onRequestSuccess: {url: %s, requestId: %s, elapsedTime: %d ms, scene_tag: %s}", objArr2));
            }
            if (FrescoSystrace.isTracing()) {
                return;
            }
            FrescoSystrace.endSection();
        }
    }

    private Pair<Integer, Integer> segmentAndCheckSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("x");
        if (split.length != 2) {
            return null;
        }
        try {
            return new Pair<>(Integer.valueOf(Integer.parseInt(split[0])), Integer.valueOf(Integer.parseInt(split[1])));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private long calAppliedImagePxCount(JSONObject jSONObject) {
        Pair<Integer, Integer> segmentAndCheckSize;
        String optString = jSONObject.optString(FrescoMonitorConst.APPLIED_IMAGE_SIZE);
        if (optString == null || (segmentAndCheckSize = segmentAndCheckSize(optString)) == null) {
            return 0L;
        }
        return ((Integer) segmentAndCheckSize.first).intValue() * ((Integer) segmentAndCheckSize.second).intValue();
    }

    private long calIntendedImagePxCount(JSONObject jSONObject) {
        Pair<Integer, Integer> segmentAndCheckSize;
        String optString = jSONObject.optString(FrescoMonitorConst.INTENDED_IMAGE_SIZE);
        if (optString == null || (segmentAndCheckSize = segmentAndCheckSize(optString)) == null) {
            return 0L;
        }
        return ((Integer) segmentAndCheckSize.first).intValue() * ((Integer) segmentAndCheckSize.second).intValue();
    }

    private long calViewNeedImagePxCount(ImageRequest imageRequest) {
        Pair size;
        SizeDeterminer sizeDeterminer = imageRequest.getSizeDeterminer();
        if (sizeDeterminer == null || (size = sizeDeterminer.getSize()) == null) {
            return 0L;
        }
        return ((Integer) size.first).intValue() * ((Integer) size.second).intValue();
    }

    private String calViewImageSize(ImageRequest imageRequest) {
        Pair size;
        SizeDeterminer sizeDeterminer = imageRequest.getSizeDeterminer();
        return (sizeDeterminer == null || (size = sizeDeterminer.getSize()) == null) ? "" : size.first + "*" + size.second;
    }

    private boolean isNeedReport(ImageRequest imageRequest, JSONObject jSONObject) {
        if (FrescoMonitor.isNeedReportAllSourceUriType()) {
            return true;
        }
        if (FrescoMonitor.isReportHitCacheEnabled()) {
            return imageRequest.getSourceUriType() == 0;
        }
        return jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false);
    }

    public void onRequestFailure(final ImageRequest imageRequest, final String str, final Throwable th, boolean z) {
        final long time = getTime();
        sExecutor.submit(new Runnable() { // from class: com.optimize.statistics.FrescoTraceListener.4
            @Override // java.lang.Runnable
            public void run() {
                FrescoTraceListener.this.onRequestFailureInternal(imageRequest, str, time, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onRequestFailureInternal(ImageRequest imageRequest, String str, long j, Throwable th) {
        String str2;
        boolean optBoolean;
        String str3;
        char c;
        char c2;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("FrescoMonitor#onRequestFailure");
        }
        RequestInfo remove = this.mRequestInfoMap.remove(str);
        if (remove == null) {
            return;
        }
        JSONObject jSONObject = remove.extra;
        if (FrescoMonitor.isEnableMonitorLog()) {
            String th2 = th != null ? th.toString() : "";
            str2 = "";
            String formatString = formatString("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(j), imageRequest.getSourceUri().toString(), str, Long.valueOf(getCurrentTime(Long.valueOf(remove.requestStartTime), j)), th2);
            if (!isCanceledInfo(th2)) {
                ALogService.eSafely(ALOGTAG, formatString, th);
            }
        } else {
            str2 = "";
        }
        if (FrescoMonitor.isReportHitCacheEnabled()) {
            optBoolean = imageRequest.getSourceUriType() == 0;
        } else {
            optBoolean = jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false);
        }
        boolean z = optBoolean;
        int checkHttpRequestException = th == null ? 200 : NetUtils.checkHttpRequestException(th, (String[]) null);
        try {
            if (remove.callerContext instanceof String) {
                jSONObject.put(FrescoMonitorConst.SCENE_TAG, remove.callerContext);
            } else if (remove.callerContext != null && !TextUtils.isEmpty(remove.callerContext.toString())) {
                jSONObject.put(FrescoMonitorConst.SCENE_TAG, remove.callerContext.toString());
            }
            jSONObject.put(FrescoMonitorConst.LOAD_STATUS, "fail");
            jSONObject.put("duration", getCurrentTime(Long.valueOf(remove.requestStartTime), j));
            jSONObject.put(FrescoMonitorConst.ERR_CODE, checkHttpRequestException);
            String errMsg = getErrMsg(th);
            if (TextUtils.isEmpty(errMsg)) {
                errMsg = Log.getStackTraceString(th);
            }
            jSONObject.put(FrescoMonitorConst.ERR_DESC, errMsg);
            jSONObject.put(FrescoMonitorConst.TIMESTAMP, Long.valueOf(remove.requestStartTime));
            jSONObject.put(FrescoMonitorConst.LOG_TYPE, FrescoMonitorConst.MONITOR_IMAGE_V2);
            try {
                jSONObject.put(FrescoMonitorConst.LOG_VERSION, 1);
                jSONObject.put("uri", imageRequest.getSourceUri().toString());
                jSONObject.put(FrescoMonitorConst.IMAGE_SDK_VERSION, BuildConfig.FRESCOVERSION);
                jSONObject.put(FrescoMonitorConst.RETRY_OPEN, RetryInterceptManager.inst().isOpen() ? 1 : 0);
                jSONObject.put(FrescoMonitorConst.SOURCE_URI_TYPE, imageRequest.getSourceUriType());
                jSONObject.put("network_quality", TTNetInit.getEffectiveConnectionType());
                str3 = str2;
            } catch (JSONException e) {
                e = e;
                str3 = str2;
                FLog.e(TAG, e, str3, new Object[0]);
                String str4 = str3;
                hookMonitor(imageRequest, str, remove.callerContext, jSONObject, false, z, false);
                uriQueryParamToExtra(jSONObject);
                if (z) {
                }
                if (FrescoMonitor.isEnableMonitorLog()) {
                }
                if (FrescoSystrace.isTracing()) {
                }
            }
        } catch (JSONException e2) {
            e = e2;
        }
        String str42 = str3;
        hookMonitor(imageRequest, str, remove.callerContext, jSONObject, false, z, false);
        uriQueryParamToExtra(jSONObject);
        if (z) {
            c = 0;
            c2 = 1;
        } else {
            int imageMonitorDataStatus = ImageMonitorUtils.getImageMonitorDataStatus(th);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(IMAGE_MONITOR_DATA);
                if (optJSONObject != null) {
                    optJSONObject.put("image_status", imageMonitorDataStatus);
                    c2 = 1;
                    try {
                        optJSONObject.put("image_load_error_code", ImageMonitorUtils.getImageLoadErrorCode(th, checkHttpRequestException != 1));
                        optJSONObject.put("disk_cache_type", ImageMonitorUtils.mapCacheChoiceToDiskCacheType(imageRequest.getCacheChoice()));
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        c = 0;
                        FrescoMonitor.onImageLoaded(false, str, jSONObject);
                        if (FrescoMonitor.isEnableMonitorLog()) {
                        }
                        if (FrescoSystrace.isTracing()) {
                        }
                    }
                } else {
                    c2 = 1;
                }
            } catch (JSONException e4) {
                e = e4;
                c2 = 1;
            }
            c = 0;
            FrescoMonitor.onImageLoaded(false, str, jSONObject);
        }
        if (FrescoMonitor.isEnableMonitorLog()) {
            String th3 = th != null ? th.toString() : str42;
            Object[] objArr = new Object[6];
            objArr[c] = Long.valueOf(j);
            objArr[c2] = imageRequest.getSourceUri().toString();
            objArr[2] = str;
            objArr[3] = Long.valueOf(getCurrentTime(Long.valueOf(remove.requestStartTime), j));
            objArr[4] = th3;
            objArr[5] = jSONObject.optString(FrescoMonitorConst.SCENE_TAG);
            String formatString2 = formatString("time %d: onRequestFailure: {url: %s, requestId: %s, elapsedTime: %d ms, throwable: %s, scene_tag: %s}", objArr);
            if (!isCanceledInfo(th3)) {
                ALogService.eSafely(ALOGTAG, formatString2, th);
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private static String getErrMsg(Throwable th) {
        return ((th instanceof CronetIOException) || (th instanceof HttpResponseException)) ? th.getMessage() : th instanceof IBDException ? ((IBDException) th).getErrorMessage() : null;
    }

    private static int getErrCodeFromThrowable(Throwable th) {
        if (th == null) {
            return 200;
        }
        if (th instanceof IBDException) {
            return ((IBDException) th).getErrorCode();
        }
        return NetUtils.checkHttpRequestException(th);
    }

    public void onRequestCancellation(final String str) {
        final long time = getTime();
        sExecutor.submit(new Runnable() { // from class: com.optimize.statistics.FrescoTraceListener.5
            @Override // java.lang.Runnable
            public void run() {
                FrescoTraceListener.this.onRequestCancellationInternal(str, time);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestCancellationInternal(String str, long j) {
        RequestInfo remove = this.mRequestInfoMap.remove(str);
        if (remove == null) {
            return;
        }
        int i = 1;
        if (FrescoMonitor.isEnableMonitorLog()) {
            ALogService.dSafely(ALOGTAG, formatString("time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(j), str, Long.valueOf(getCurrentTime(Long.valueOf(remove.requestStartTime), j))));
        }
        JSONObject jSONObject = remove.extra;
        try {
            jSONObject.put(FrescoMonitorConst.LOAD_STATUS, "cancel");
            jSONObject.put("duration", getCurrentTime(Long.valueOf(remove.requestStartTime), j));
            jSONObject.put(FrescoMonitorConst.TIMESTAMP, Long.valueOf(remove.requestStartTime));
            if (!RetryInterceptManager.inst().isOpen()) {
                i = 0;
            }
            jSONObject.put(FrescoMonitorConst.RETRY_OPEN, i);
        } catch (JSONException e) {
            FLog.e(TAG, e, "", new Object[0]);
        }
        hookMonitor(null, str, remove.callerContext, jSONObject, false, jSONObject.optBoolean(FrescoMonitorConst.IS_NETWORK_DOWNLOAD, false), true);
        uriQueryParamToExtra(jSONObject);
    }

    public void onRequestIntermediateResult(final ImageRequest imageRequest, final String str, final boolean z) {
        final long time = getTime();
        sExecutor.submit(new Runnable() { // from class: com.optimize.statistics.FrescoTraceListener.6
            @Override // java.lang.Runnable
            public void run() {
                FrescoTraceListener.this.onRequestIntermediateResultInternal(imageRequest, str, z, time);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestIntermediateResultInternal(ImageRequest imageRequest, String str, boolean z, long j) {
        RequestInfo requestInfo = this.mRequestInfoMap.get(str);
        if (requestInfo != null && requestInfo.isFirstIntermediateResult) {
            requestInfo.isFirstIntermediateResult = false;
            JSONObject jSONObject = requestInfo.extra;
            if (jSONObject == null) {
                return;
            }
            try {
                jSONObject.put(FrescoMonitorConst.FIRST_INTERMEDIATE_RESULT, getCurrentTime(Long.valueOf(requestInfo.requestStartTime), j));
            } catch (JSONException unused) {
            }
        }
    }

    public void onProducerStart(String str, String str2) {
        long time = getTime();
        RequestInfo requestInfo = this.mRequestInfoMap.get(str);
        if (requestInfo == null) {
            return;
        }
        requestInfo.producerStartTimeMap.put(str + str2, Long.valueOf(time));
        JSONObject jSONObject = requestInfo.extra;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(IMAGE_MONITOR_DATA);
                if (optJSONObject != null) {
                    optJSONObject.put(str2, new JSONObject());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        String str3;
        String str4;
        String str5;
        Long l;
        JSONException jSONException;
        JSONObject jSONObject;
        String str6;
        long j;
        JSONObject jSONObject2;
        JSONObject optJSONObject;
        long longValue;
        long time = getTime();
        RequestInfo requestInfo = this.mRequestInfoMap.get(str);
        if (requestInfo == null) {
            return;
        }
        Map<String, Long> map2 = requestInfo.producerStartTimeMap;
        if (map2.isEmpty()) {
            return;
        }
        Long remove = map2.remove(str + str2);
        JSONObject jSONObject3 = requestInfo.extra;
        if (jSONObject3 == null) {
            return;
        }
        try {
            jSONObject = jSONObject3.optJSONObject(IMAGE_MONITOR_DATA);
        } catch (JSONException e) {
            str3 = FrescoMonitorConst.THUMB_DECODE_DURATION;
            str4 = FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA;
            str5 = FrescoMonitorConst.PREVIEW_HASH_USED;
            l = remove;
            jSONException = e;
            jSONObject = null;
        }
        if (jSONObject != null) {
            str5 = FrescoMonitorConst.PREVIEW_HASH_USED;
            try {
                optJSONObject = jSONObject.optJSONObject(str2);
            } catch (JSONException e2) {
                e = e2;
                str3 = FrescoMonitorConst.THUMB_DECODE_DURATION;
                str4 = FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA;
                l = remove;
            }
            if (optJSONObject != null) {
                jSONObject2 = jSONObject;
                try {
                    longValue = remove.longValue();
                    str3 = FrescoMonitorConst.THUMB_DECODE_DURATION;
                    str4 = FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA;
                } catch (JSONException e3) {
                    e = e3;
                    str3 = FrescoMonitorConst.THUMB_DECODE_DURATION;
                    str4 = FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA;
                }
                try {
                    optJSONObject.put("producer_start", longValue - Long.valueOf(requestInfo.requestStartTime).longValue());
                    l = remove;
                    try {
                        optJSONObject.put("producer_end", time - requestInfo.requestStartTime);
                        jSONObject = jSONObject2;
                    } catch (JSONException e4) {
                        e = e4;
                        jSONObject = jSONObject2;
                        jSONException = e;
                        jSONException.printStackTrace();
                        if (map != null) {
                        }
                    }
                } catch (JSONException e5) {
                    e = e5;
                    l = remove;
                    jSONObject = jSONObject2;
                    jSONException = e;
                    jSONException.printStackTrace();
                    if (map != null) {
                    }
                }
                if (map != null) {
                    return;
                }
                boolean equals = "NetworkFetchProducer".equals(str2);
                Object obj = PushClient.DEFAULT_REQUEST_ID;
                if (equals) {
                    try {
                        String str7 = map.get(FrescoMonitorConst.CONTENT_LENGTH);
                        String str8 = map.get("image_size");
                        long parseLong = !TextUtils.isEmpty(str7) ? Long.parseLong(str7) : -1L;
                        long parseLong2 = !TextUtils.isEmpty(str8) ? Long.parseLong(str8) : -1L;
                        jSONObject3.put(FrescoMonitorConst.FILE_SIZE, parseLong2);
                        jSONObject3.put(FrescoMonitorConst.CONTENT_LENGTH, parseLong);
                        if (parseLong != parseLong2) {
                            obj = "0";
                        }
                        jSONObject3.put(FrescoMonitorConst.FILE_CONSISTENT, obj);
                        jSONObject3.put("hit_cdn_cache", map.get("hit_cdn_cache"));
                        jSONObject3.put(FrescoMonitorConst.X_RESPONSE_CACHE, map.get(FrescoMonitorConst.X_RESPONSE_CACHE));
                        jSONObject3.put(FrescoMonitorConst.IMAGEX_DEMOTION, map.get(FrescoMonitorConst.IMAGEX_DEMOTION));
                        jSONObject3.put(FrescoMonitorConst.IMAGEX_WANT_FMT, map.get(FrescoMonitorConst.IMAGEX_WANT_FMT));
                        jSONObject3.put(FrescoMonitorConst.IMAGEX_TRUE_FMT, map.get(FrescoMonitorConst.IMAGEX_TRUE_FMT));
                        jSONObject3.put(FrescoMonitorConst.IMAGEX_CONSISTENCY, map.get(FrescoMonitorConst.IMAGEX_CONSISTENCY));
                        jSONObject3.put(FrescoMonitorConst.IMAGEX_IS_PREFETCH, map.get(FrescoMonitorConst.IMAGEX_IS_PREFETCH));
                    } catch (NumberFormatException e6) {
                        e = e6;
                    } catch (JSONException e7) {
                        e = e7;
                    }
                    try {
                        getHeaders(jSONObject3).put(FrescoMonitorConst.RESPONSE_HEADER_X_RESPONSE_CACHE, map.get(FrescoMonitorConst.X_RESPONSE_CACHE));
                        String str9 = str4;
                        if (!TextUtils.isEmpty(map.get(str9))) {
                            getHeaders(jSONObject3).put(str9, map.get(str9));
                        }
                        jSONObject3.put(FrescoMonitorConst.IMAGEX_CUSTOM_PARAM, map.get(FrescoMonitorConst.IMAGEX_CUSTOM_PARAM));
                    } catch (NumberFormatException e8) {
                        e = e8;
                        e.printStackTrace();
                        if (SimplayerImageStrategy.isUploadLog()) {
                            return;
                        } else {
                            return;
                        }
                    } catch (JSONException e9) {
                        e = e9;
                        e.printStackTrace();
                        if (SimplayerImageStrategy.isUploadLog()) {
                        }
                    }
                } else if ("BlurhashProducer".equals(str2)) {
                    try {
                        jSONObject3.put(FrescoMonitorConst.BLURHASH_DECODE_DURATION, map.get(FrescoMonitorConst.BLURHASH_DECODE_DURATION));
                        jSONObject3.put(FrescoMonitorConst.BLURHASH_DURATION, time - requestInfo.requestStartTime);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                } else if ("DiskCacheWriteProducer".equals(str2)) {
                    try {
                        jSONObject3.put(FrescoMonitorConst.IMAGE_TYPE, (String) map.get("imageType"));
                        Object obj2 = (String) map.get("encodedImageSize");
                        if ("-1x-1".equals(obj2) || "unknown".equals(obj2)) {
                            obj2 = (String) map.get("bitmapSize");
                        }
                        jSONObject3.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, obj2);
                    } catch (JSONException e11) {
                        e11.printStackTrace();
                    }
                } else if ("DecodeProducer".equals(str2)) {
                    try {
                        Object obj3 = (String) map.get("requestedImageSize");
                        if ("unknown".equals(obj3)) {
                            obj3 = "0x0";
                        }
                        jSONObject3.put(FrescoMonitorConst.INTENDED_IMAGE_SIZE, obj3);
                        Object obj4 = (String) map.get("encodedImageSize");
                        if ("-1x-1".equals(obj4) || "unknown".equals(obj4)) {
                            obj4 = (String) map.get("bitmapSize");
                        }
                        jSONObject3.put(FrescoMonitorConst.EXTRA_IS_CROP, map.get(FrescoMonitorConst.EXTRA_IS_CROP));
                        jSONObject3.put(FrescoMonitorConst.EXTRA_REGION_TO_DECODE, map.get(FrescoMonitorConst.EXTRA_REGION_TO_DECODE));
                        jSONObject3.put(FrescoMonitorConst.SAMPLE_SIZE, map.get(FrescoMonitorConst.SAMPLE_SIZE));
                        jSONObject3.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, obj4);
                        Long l2 = l;
                        jSONObject3.put(FrescoMonitorConst.DECODE_DURATION, time - l.longValue());
                        jSONObject3.put(FrescoMonitorConst.IMAGE_TYPE, map.get("imageFormat"));
                        jSONObject3.put(FrescoMonitorConst.IMAGE_RAM_SIZE, map.get("bitmapRamSize"));
                        jSONObject3.put(FrescoMonitorConst.IMAGE_COUNT, Integer.parseInt(map.get("imageCount")));
                        Object obj5 = (String) map.get(FrescoMonitorConst.HEIC_HDR_TYPE);
                        if (!LynxConstants.LYNX_DEFAULT_COMPONENT_ID.equals(obj5)) {
                            jSONObject3.put(FrescoMonitorConst.HEIC_HDR_TYPE, obj5);
                            jSONObject3.put(FrescoMonitorConst.USE_TTHEIF_RGBA_102, FrescoCacheMonitorUtil.isUseHeicHdrRgba102());
                        }
                        jSONObject3.put(FrescoMonitorConst.EXTRA_BITMAP_CONFIG, map.get(FrescoMonitorConst.EXTRA_BITMAP_CONFIG));
                        if (jSONObject != null) {
                            jSONObject.put("decode_queue_duration", Long.parseLong(map.get("queueTime")));
                        }
                        jSONObject3.put(FrescoMonitorConst.IMAGE_QUALITY, map.get("imageQuality"));
                        jSONObject3.put(FrescoMonitorConst.HEIC_SYS_FIRST, map.get(FrescoMonitorConst.HEIC_SYS_FIRST));
                        jSONObject3.put(FrescoMonitorConst.HEIC_CUSTOM_DECODER, map.get(FrescoMonitorConst.HEIC_CUSTOM_DECODER));
                        try {
                            String str10 = map.get(FrescoMonitorConst.HEIC_DECODE_ERROR);
                            if (str10 != null) {
                                jSONObject3.put(FrescoMonitorConst.ERR_CODE, Integer.parseInt(str10));
                            }
                        } catch (Exception e12) {
                            e12.printStackTrace();
                        }
                        String str11 = str3;
                        if (map.get(str11) != null) {
                            jSONObject3.put(FrescoMonitorConst.THUMB_FILE_SIZE, map.get(FrescoMonitorConst.THUMB_FILE_SIZE));
                            jSONObject3.put(str11, map.get(str11));
                            j = time;
                            jSONObject3.put(FrescoMonitorConst.THUMB_DOWNLOAD_DURATION, System.currentTimeMillis() - requestInfo.requestStartTime);
                        } else {
                            j = time;
                        }
                        String str12 = str5;
                        if (map.get(str12) != null && PushClient.DEFAULT_REQUEST_ID.equals(map.get(str12))) {
                            jSONObject3.put(str12, map.get(str12));
                            jSONObject3.put(FrescoMonitorConst.PREVIEW_HASH_ALGO, map.get(FrescoMonitorConst.PREVIEW_HASH_ALGO));
                            jSONObject3.put(FrescoMonitorConst.PREVIEW_HASH_DURATION, map.get(FrescoMonitorConst.PREVIEW_HASH_DURATION));
                            jSONObject3.put(FrescoMonitorConst.PREVIEW_HASH_ERROR, map.get(FrescoMonitorConst.PREVIEW_HASH_ERROR));
                            jSONObject3.put(FrescoMonitorConst.PREVIEW_HASH_DECODE_DURATION, map.get(FrescoMonitorConst.PREVIEW_HASH_DECODE_DURATION));
                        }
                        if (PushClient.DEFAULT_REQUEST_ID.equalsIgnoreCase(map.get(FrescoMonitorConst.SR_HEIC_OPT))) {
                            String str13 = map.get(FrescoMonitorConst.SR_DURATION);
                            jSONObject3.put(FrescoMonitorConst.SR_HEIC_OPT, map.get(FrescoMonitorConst.SR_HEIC_OPT));
                            jSONObject3.put(FrescoMonitorConst.SR_MODE, map.get(FrescoMonitorConst.SR_MODE));
                            jSONObject3.put(FrescoMonitorConst.SR_STATUS, map.get(FrescoMonitorConst.SR_STATUS));
                            jSONObject3.put(FrescoMonitorConst.SR_DURATION, str13);
                            jSONObject3.put(FrescoMonitorConst.SR_WIDTH, map.get(FrescoMonitorConst.SR_WIDTH));
                            jSONObject3.put(FrescoMonitorConst.SR_HEIGHT, map.get(FrescoMonitorConst.SR_HEIGHT));
                            jSONObject3.put(FrescoMonitorConst.SR_STRETCH, map.get(FrescoMonitorConst.SR_STRETCH));
                            jSONObject3.put(FrescoMonitorConst.SR_SCALE_TYPE, map.get(FrescoMonitorConst.SR_SCALE_TYPE));
                            jSONObject3.put(FrescoMonitorConst.SR_IS_ENABLE_ALL, map.get(FrescoMonitorConst.SR_IS_ENABLE_ALL));
                            jSONObject3.put(FrescoMonitorConst.SR_MAX_WIDTH, map.get(FrescoMonitorConst.SR_MAX_WIDTH));
                            jSONObject3.put(FrescoMonitorConst.SR_MAX_HEIGHT, map.get(FrescoMonitorConst.SR_MAX_HEIGHT));
                            jSONObject3.put(FrescoMonitorConst.SR_ERROR, map.get(FrescoMonitorConst.SR_ERROR));
                            if (!TextUtils.isEmpty(str13)) {
                                jSONObject3.put(FrescoMonitorConst.DECODE_DURATION, (j - l2.longValue()) - Integer.parseInt(str13));
                            }
                        }
                    } catch (NumberFormatException e13) {
                        e13.printStackTrace();
                    } catch (JSONException e14) {
                        e14.printStackTrace();
                    }
                } else if ("BackgroundThreadHandoffProducer".equals(str2)) {
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("pause_time", map.get("pendingTime"));
                        } catch (JSONException e15) {
                            e15.printStackTrace();
                        }
                    }
                } else if ("PostprocessorProducer".equals(str2)) {
                    try {
                        if (!PushClient.DEFAULT_REQUEST_ID.equalsIgnoreCase(map.get(FrescoMonitorConst.SR_HEIC_OPT))) {
                            jSONObject3.put(FrescoMonitorConst.SR_HEIC_OPT, map.get(FrescoMonitorConst.SR_HEIC_OPT));
                            jSONObject3.put(FrescoMonitorConst.SR_MODE, map.get(FrescoMonitorConst.SR_MODE));
                            jSONObject3.put(FrescoMonitorConst.SR_STATUS, map.get(FrescoMonitorConst.SR_STATUS));
                            jSONObject3.put(FrescoMonitorConst.SR_DURATION, map.get(FrescoMonitorConst.SR_DURATION));
                            jSONObject3.put(FrescoMonitorConst.SR_WIDTH, map.get(FrescoMonitorConst.SR_WIDTH));
                            jSONObject3.put(FrescoMonitorConst.SR_HEIGHT, map.get(FrescoMonitorConst.SR_HEIGHT));
                            jSONObject3.put(FrescoMonitorConst.SR_STRETCH, map.get(FrescoMonitorConst.SR_STRETCH));
                            jSONObject3.put(FrescoMonitorConst.SR_SCALE_TYPE, map.get(FrescoMonitorConst.SR_SCALE_TYPE));
                            jSONObject3.put(FrescoMonitorConst.SR_IS_ENABLE_ALL, map.get(FrescoMonitorConst.SR_IS_ENABLE_ALL));
                            jSONObject3.put(FrescoMonitorConst.SR_MAX_WIDTH, map.get(FrescoMonitorConst.SR_MAX_WIDTH));
                            jSONObject3.put(FrescoMonitorConst.SR_MAX_HEIGHT, map.get(FrescoMonitorConst.SR_MAX_HEIGHT));
                            jSONObject3.put(FrescoMonitorConst.SR_ERROR, map.get(FrescoMonitorConst.SR_ERROR));
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    try {
                        jSONObject3.put(FrescoMonitorConst.SHARP_MODE, map.get(FrescoMonitorConst.SHARP_MODE));
                        jSONObject3.put(FrescoMonitorConst.SHARP_STATUS, map.get(FrescoMonitorConst.SHARP_STATUS));
                        jSONObject3.put(FrescoMonitorConst.SHARP_DURATION, map.get(FrescoMonitorConst.SHARP_DURATION));
                        jSONObject3.put(FrescoMonitorConst.SHARP_ERROR, map.get(FrescoMonitorConst.SHARP_ERROR));
                        jSONObject3.put(FrescoMonitorConst.SHARP_WT, map.get(FrescoMonitorConst.SHARP_WT));
                        jSONObject3.put(FrescoMonitorConst.SHARP_THR, map.get(FrescoMonitorConst.SHARP_THR));
                        jSONObject3.put(FrescoMonitorConst.SHARP_OVRT, map.get(FrescoMonitorConst.SHARP_OVRT));
                        jSONObject3.put(FrescoMonitorConst.SHARP_ADAPTIVE, map.get(FrescoMonitorConst.SHARP_ADAPTIVE));
                        jSONObject3.put(FrescoMonitorConst.SHARP_G0, map.get(FrescoMonitorConst.SHARP_G0));
                        jSONObject3.put(FrescoMonitorConst.SHARP_LC_WT_THR, map.get(FrescoMonitorConst.SHARP_LC_WT_THR));
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
                if (SimplayerImageStrategy.isUploadLog() || (str6 = map.get(FrescoMonitorConst.STRATEGY_CENTER)) == null || str6.isEmpty()) {
                    return;
                }
                try {
                    jSONObject3.put(FrescoMonitorConst.STRATEGY_CENTER, str6);
                } catch (JSONException e18) {
                    e18.printStackTrace();
                }
                if (SimplayerImageStrategy.isOpenLog()) {
                    Log.d("SimplayerImageStrategy", "onProducerFinishWithSuccess, strategy_center:" + str6);
                    return;
                }
                return;
            }
            str3 = FrescoMonitorConst.THUMB_DECODE_DURATION;
            str4 = FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA;
        } else {
            str3 = FrescoMonitorConst.THUMB_DECODE_DURATION;
            str4 = FrescoMonitorConst.RESPONSE_HEADER_X_IMAGEX_EXTRA;
            str5 = FrescoMonitorConst.PREVIEW_HASH_USED;
        }
        jSONObject2 = jSONObject;
        l = remove;
        jSONObject = jSONObject2;
        if (map != null) {
        }
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        JSONObject jSONObject;
        Map<String, String> map2;
        long j;
        Throwable th2;
        long time = getTime();
        RequestInfo requestInfo = this.mRequestInfoMap.get(str);
        if (requestInfo == null || (jSONObject = requestInfo.extra) == null) {
            return;
        }
        if (map == null) {
            map2 = new HashMap<>();
            map2.put("image_size", LynxConstants.LYNX_DEFAULT_COMPONENT_ID);
            map2.put("queue_time", LynxConstants.LYNX_DEFAULT_COMPONENT_ID);
            map2.put("fetch_time", LynxConstants.LYNX_DEFAULT_COMPONENT_ID);
        } else {
            map2 = map;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(IMAGE_MONITOR_DATA);
        if ("NetworkFetchProducer".equals(str2)) {
            try {
                jSONObject.put("fail_phase", "download");
                jSONObject.put("download_duration", -1);
                String str3 = map2.get(FrescoMonitorConst.CONTENT_LENGTH);
                String str4 = map2.get("image_size");
                String str5 = map2.get("queue_time");
                long parseLong = !TextUtils.isEmpty(str3) ? Long.parseLong(str3) : -1L;
                long parseLong2 = !TextUtils.isEmpty(str4) ? Long.parseLong(str4) : -1L;
                long parseLong3 = TextUtils.isEmpty(str5) ? -1L : Long.parseLong(str5);
                jSONObject.put(FrescoMonitorConst.FILE_SIZE, parseLong2);
                jSONObject.put(FrescoMonitorConst.CONTENT_LENGTH, parseLong);
                jSONObject.put("queue_duration", parseLong3);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if ("DecodeProducer".equals(str2)) {
            try {
                jSONObject.put("fail_phase", "decode");
                jSONObject.put("download_duration", map2.get("fetch_time"));
                if (optJSONObject != null) {
                    optJSONObject.put("decode_queue_duration", Long.parseLong(map2.get("queueTime")));
                }
                jSONObject.put(FrescoMonitorConst.HEIC_SYS_FIRST, map2.get(FrescoMonitorConst.HEIC_SYS_FIRST));
                jSONObject.put(FrescoMonitorConst.HEIC_CUSTOM_DECODER, map2.get(FrescoMonitorConst.HEIC_CUSTOM_DECODER));
            } catch (NumberFormatException e3) {
                e3.printStackTrace();
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        StringBuilder sb = new StringBuilder(str);
        Map<String, Long> map3 = requestInfo.producerStartTimeMap;
        if (map3.isEmpty()) {
            return;
        }
        Long remove = map3.remove(sb.append(str2).toString());
        if (FrescoMonitor.isEnableMonitorLog()) {
            String th3 = th.toString();
            j = time;
            String formatString = formatString("time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(time), str, str2, Long.valueOf(getCurrentTime(remove, j)), map2, th3);
            if (isCanceledInfo(th3)) {
                ALogService.eSafely(ALOGTAG, formatString);
                th2 = th;
            } else {
                th2 = th;
                ALogService.eSafely(ALOGTAG, formatString, th2);
            }
            FLog.e(ALOGTAG, formatString, th2);
        } else {
            j = time;
        }
        if (optJSONObject != null) {
            try {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
                if (optJSONObject2 != null) {
                    optJSONObject2.put("producer_start", remove.longValue() - Long.valueOf(requestInfo.requestStartTime).longValue());
                    optJSONObject2.put("producer_end", j - requestInfo.requestStartTime);
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
    }

    public void onUltimateProducerReached(String str, String str2, boolean z) {
        JSONObject jSONObject;
        RequestInfo requestInfo = this.mRequestInfoMap.get(str);
        if (requestInfo == null || (jSONObject = requestInfo.extra) == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(IMAGE_MONITOR_DATA);
            if (optJSONObject != null) {
                optJSONObject.put("image_origin", ImageMonitorUtils.mapProducerNameToImageMonitorOrigin(str2));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private long getCurrentTime(Long l, long j) {
        if (l != null) {
            return j - l.longValue();
        }
        return -1L;
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

    private String encodeUrl(String str) {
        List list;
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Pair parseUrlWithValueList = UrlUtils.parseUrlWithValueList(str, linkedHashMap);
            if (parseUrlWithValueList == null) {
                return str;
            }
            UrlBuilder urlBuilder = new UrlBuilder(((String) parseUrlWithValueList.first) + ((String) parseUrlWithValueList.second));
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null && entry.getKey() != null && (list = (List) entry.getValue()) != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            urlBuilder.addParam((String) entry.getKey(), (String) it.next());
                        }
                    }
                }
            }
            return urlBuilder.build();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private JSONObject shallowCopy(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException unused) {
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hookMonitor(ImageRequest imageRequest, String str, Object obj, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        Pair<Boolean, Map<String, Object>> pair;
        JSONObject shallowCopy = shallowCopy(jSONObject);
        IMonitorHook monitorHook = FrescoMonitor.getMonitorHook();
        if (monitorHook != null) {
            try {
                pair = monitorHook.onMonitorCompleted(imageRequest, obj, str, shallowCopy, z);
            } catch (Exception unused) {
                pair = null;
            }
            if (pair != null) {
                z4 = ((Boolean) pair.first).booleanValue();
                Map map = (Map) pair.second;
                if (map != null) {
                    try {
                        for (String str2 : map.keySet()) {
                            jSONObject.put(str2, map.get(str2));
                        }
                    } catch (JSONException unused2) {
                    }
                }
                if (!FrescoCacheMonitorUtil.isOptListenerAnr()) {
                    Iterator<IMonitorHookV2> it = FrescoMonitor.sNewMonitorHookV2s.iterator();
                    boolean z6 = z4;
                    while (it.hasNext()) {
                        Pair<Boolean, Map<String, Object>> onMonitorCompleted = it.next().onMonitorCompleted(imageRequest, obj, str, shallowCopy, z, z3);
                        if (onMonitorCompleted != null) {
                            if (!z6) {
                                z6 = ((Boolean) onMonitorCompleted.first).booleanValue();
                            }
                            Map map2 = (Map) onMonitorCompleted.second;
                            if (map2 != null) {
                                try {
                                    for (String str3 : map2.keySet()) {
                                        jSONObject.put(str3, map2.get(str3));
                                    }
                                } catch (JSONException unused3) {
                                }
                            }
                        }
                    }
                    return z6;
                }
                synchronized (FrescoMonitor.sMonitorHookV2s) {
                    Iterator<IMonitorHookV2> it2 = FrescoMonitor.sMonitorHookV2s.iterator();
                    z5 = z4;
                    while (it2.hasNext()) {
                        Pair<Boolean, Map<String, Object>> onMonitorCompleted2 = it2.next().onMonitorCompleted(imageRequest, obj, str, shallowCopy, z, z3);
                        if (onMonitorCompleted2 != null) {
                            if (!z5) {
                                z5 = ((Boolean) onMonitorCompleted2.first).booleanValue();
                            }
                            Map map3 = (Map) onMonitorCompleted2.second;
                            if (map3 != null) {
                                try {
                                    for (String str4 : map3.keySet()) {
                                        jSONObject.put(str4, map3.get(str4));
                                    }
                                } catch (JSONException unused4) {
                                }
                            }
                        }
                    }
                }
                return z5;
            }
        }
        z4 = z2;
        if (!FrescoCacheMonitorUtil.isOptListenerAnr()) {
        }
    }

    private JSONObject uriQueryParamToExtra(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("uri", null);
            String optString2 = jSONObject.optString("biz_tag", null);
            if (!TextUtils.isEmpty(optString)) {
                Uri parse = Uri.parse(optString);
                if (optString2 == null) {
                    String queryParameter = parse.getQueryParameter("biz_tag");
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = parse.getQueryParameter(FrescoMonitorConst.URI_QUERY_PARAM_FROM);
                    }
                    if (queryParameter != null) {
                        jSONObject.put("biz_tag", queryParameter);
                    }
                }
                String queryParameter2 = parse.getQueryParameter(FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_FLIGHT_ID);
                String queryParameter3 = parse.getQueryParameter(FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_VID);
                if (!TextUtils.isEmpty(queryParameter2) || !TextUtils.isEmpty(queryParameter3)) {
                    JSONObject extra = getExtra(jSONObject);
                    extra.put(FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_FLIGHT_ID, queryParameter2);
                    extra.put(FrescoMonitorConst.URI_QUERY_PARAM_IMAGEX_VID, queryParameter3);
                }
            }
        } catch (JSONException e) {
            FLog.e(TAG, "uriQueryParamToExtra error", new Object[]{e.getMessage()});
        }
        return jSONObject;
    }

    private JSONObject getExtra(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("extra");
            if (optJSONObject != null) {
                return optJSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("extra", jSONObject2);
            return jSONObject2;
        } catch (JSONException e) {
            FLog.e(TAG, "construct extra error", new Object[]{e.getMessage()});
            return null;
        }
    }

    private JSONObject getHeaders(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("headers");
            if (optJSONObject != null) {
                return optJSONObject;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("headers", jSONObject2);
            return jSONObject2;
        } catch (JSONException e) {
            FLog.e(TAG, "construct headers error", new Object[]{e.getMessage()});
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RequestInfo {
        Object callerContext;
        JSONObject extra;
        String requestId;
        long requestStartTime;
        Map<String, Long> producerStartTimeMap = new HashMap();
        boolean isFirstIntermediateResult = true;

        RequestInfo() {
        }
    }

    public static Map<String, String> handleDemotion(SsResponse<TypedInput> ssResponse) {
        String str;
        String str2;
        String str3;
        HashMap hashMap = new HashMap();
        String headerForName = getHeaderForName(ssResponse.headers(), "ImageX-Demotion");
        if (headerForName == null) {
            headerForName = "undefined";
        }
        String headerForName2 = getHeaderForName(ssResponse.headers(), "ImageX-Fmt");
        String[] split = headerForName2 == null ? null : headerForName2.split("2");
        if (split == null || split.length <= 0) {
            str = "undefined";
            str2 = str;
        } else {
            str2 = split[0];
            str = split.length > 1 ? split[1] : "undefined";
        }
        if ("undefined".equals(str2) || "undefined".equals(str)) {
            str3 = LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
        } else {
            str3 = str2.equalsIgnoreCase(str) ? PushClient.DEFAULT_REQUEST_ID : "0";
        }
        hashMap.put(FrescoMonitorConst.IMAGEX_DEMOTION, headerForName);
        hashMap.put(FrescoMonitorConst.IMAGEX_WANT_FMT, str2);
        hashMap.put(FrescoMonitorConst.IMAGEX_TRUE_FMT, str);
        hashMap.put(FrescoMonitorConst.IMAGEX_CONSISTENCY, str3);
        return hashMap;
    }

    private static String getHeaderForName(List<Header> list, String str) {
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
}
