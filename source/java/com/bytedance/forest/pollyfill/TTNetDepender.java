package com.bytedance.forest.pollyfill;

import android.webkit.WebResourceRequest;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.applog.server.Api;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.ForestConcurrentList;
import com.bytedance.forest.model.HttpResponseCache;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.pollyfill.TTNetDepender;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.RepoUtils;
import com.bytedance.forest.utils.ResponseCacheManager;
import com.bytedance.forest.utils.ThreadUtils;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.MediaType;

/* compiled from: TTNetDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nH\u0016J \u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001c2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J6\u0010\u001d\u001a\u00020\u00062\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010 \u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J \u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/forest/pollyfill/TTNetDepender;", "Lcom/bytedance/forest/pollyfill/INetDepender;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "cancel", "", "fetchTask", "Lcom/bytedance/forest/pollyfill/FetchTask;", "checkHeadersMatch", "", "cachedHeaders", "", "", "requestHeaders", "commit", "httpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "forestBuffer", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "fetchFile", "onlyLocal", "getMediaType", "Lokhttp3/MediaType;", "headers", "getMimeTypeAndEncoding", "Lkotlin/Pair;", "handleHeaders", "", "needRestore", "handleRedirectionCase", "tryFetchFromCache", "httpRequest", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "mustRevalidate", "tryFetchOnline", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTNetDepender implements INetDepender {
    public static final String FOREST_APPEND_PREFIX = "forest-append-";
    public static final String FOREST_APPEND_REQUEST_TIME = "forest-append-on-request";
    public static final String TAG = "TTNetDepender";
    private final ForestPipelineContext context;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean sweepCDNCache = new AtomicBoolean(false);
    private static final ConcurrentHashMap<String, FetchTask> loadingRequests = new ConcurrentHashMap<>();
    private static ForestNetAPI netAPI = new DefaultForestNetAPI();

    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001aJ'\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0003J\r\u0010\f\u001a\u00020\"H\u0000¢\u0006\u0002\b&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/forest/pollyfill/TTNetDepender$Companion;", "", "()V", "FOREST_APPEND_PREFIX", "", "FOREST_APPEND_REQUEST_TIME", "TAG", "loadingRequests", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/forest/pollyfill/FetchTask;", "netAPI", "Lcom/bytedance/forest/pollyfill/ForestNetAPI;", "sweepCDNCache", "Ljava/util/concurrent/atomic/AtomicBoolean;", "checkExpired", "", "url", "file", "Ljava/io/File;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Ljava/lang/String;Ljava/io/File;Lcom/bytedance/forest/utils/ForestPipelineContext;)Ljava/lang/Boolean;", "createHttpRequest", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "request", "Lcom/bytedance/forest/model/Request;", "createHttpRequest$forest_release", "getHttpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "httpRequest", "getHttpResponse$forest_release", "setNetAPI", "", "shouldBeHandledByForest", "webResourceRequest", "Landroid/webkit/WebResourceRequest;", "sweepCDNCache$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void sweepCDNCache$forest_release() {
            if (TTNetDepender.sweepCDNCache.compareAndSet(false, true)) {
                long currentTimeMillis = System.currentTimeMillis();
                long cdnCacheDiskMaxAge$forest_release = Forest.INSTANCE.getCdnCacheDiskMaxAge$forest_release() * 24 * 60 * 60 * 1000;
                File[] listFiles = CDNFetchDepender.INSTANCE.getDirectory().listFiles();
                if (listFiles == null) {
                    listFiles = new File[0];
                }
                for (File file : listFiles) {
                    Intrinsics.checkExpressionValueIsNotNull(file, "file");
                    String name = file.getName();
                    OfflineUtil offlineUtil = OfflineUtil.INSTANCE;
                    Intrinsics.checkExpressionValueIsNotNull(name, "name");
                    if (offlineUtil.isFileExpiredByHttpProtocol(name)) {
                        LogUtils.i$default(LogUtils.INSTANCE, TTNetDepender.TAG, "clean file: " + name + " cause overdue", false, null, null, null, 60, null);
                        RepoUtils.INSTANCE.delete(name);
                        file.delete();
                    } else if (cdnCacheDiskMaxAge$forest_release > 0 && OfflineUtil.INSTANCE.isFileExpiredByUsageTime(file, cdnCacheDiskMaxAge$forest_release)) {
                        LogUtils.i$default(LogUtils.INSTANCE, TTNetDepender.TAG, "clean file: " + name + " cause last usage time overdue", false, null, null, null, 60, null);
                        RepoUtils.INSTANCE.delete(name);
                        file.delete();
                    }
                }
                RepoUtils.INSTANCE.trim();
                LogUtils.i$default(LogUtils.INSTANCE, TTNetDepender.TAG, "sweep cached files cost:" + (System.currentTimeMillis() - currentTimeMillis), true, null, null, null, 56, null);
                TTNetDepender.sweepCDNCache.set(false);
            }
        }

        public final Boolean checkExpired(String url, File file, ForestPipelineContext context) {
            final String str;
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(context, "context");
            if (file == null || (str = file.getName()) == null) {
                str = "";
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            ResponseCacheManager.traverseAndFetchCacheIf$default(ResponseCacheManager.INSTANCE, url, context.getLogger(), null, new Function1<HttpResponseCache, Pair<? extends Boolean, ? extends Boolean>>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$Companion$checkExpired$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Pair<Boolean, Boolean> invoke(HttpResponseCache httpResponseCache) {
                    Intrinsics.checkParameterIsNotNull(httpResponseCache, "responseCache");
                    if (Intrinsics.areEqual(httpResponseCache.getCacheKey(), str)) {
                        objectRef.element = Boolean.valueOf(httpResponseCache.isStale());
                        return new Pair<>(true, false);
                    }
                    if (httpResponseCache.isCachedInMemory()) {
                        Ref.ObjectRef objectRef2 = objectRef;
                        Boolean bool = (Boolean) objectRef2.element;
                        objectRef2.element = Boolean.valueOf(httpResponseCache.isStale() | (bool != null ? bool.booleanValue() : false));
                    }
                    return new Pair<>(false, false);
                }
            }, null, 4, null);
            return (Boolean) objectRef.element;
        }

        public final ForestNetAPI.HttpRequest createHttpRequest$forest_release(String url, Request request, ForestPipelineContext context) {
            ForestNetAPI.HttpRequest createHttpRequest;
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(context, "context");
            Object webResourceRequest = request.getWebResourceRequest();
            if (webResourceRequest instanceof WebResourceRequest) {
                WebResourceRequest webResourceRequest2 = (WebResourceRequest) webResourceRequest;
                if (shouldBeHandledByForest(webResourceRequest2)) {
                    for (Map.Entry<String, String> entry : request.getInjectedHttpHeaders().entrySet()) {
                        if (!webResourceRequest2.getRequestHeaders().containsKey(entry.getKey())) {
                            Map<String, String> requestHeaders = webResourceRequest2.getRequestHeaders();
                            Intrinsics.checkExpressionValueIsNotNull(requestHeaders, "webReq.requestHeaders");
                            requestHeaders.put(entry.getKey(), entry.getValue());
                        }
                    }
                    createHttpRequest = TTNetDepender.netAPI.createHttpRequest(webResourceRequest2, url, context);
                } else {
                    createHttpRequest = null;
                }
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (LoaderUtils.INSTANCE.isNotNullOrEmpty(request.getInjectedUserAgent())) {
                    String injectedUserAgent = request.getInjectedUserAgent();
                    if (injectedUserAgent == null) {
                        Intrinsics.throwNpe();
                    }
                    linkedHashMap.put("user-agent", injectedUserAgent);
                }
                linkedHashMap.putAll(request.getInjectedHttpHeaders());
                createHttpRequest = TTNetDepender.netAPI.createHttpRequest(url, linkedHashMap, context);
            }
            if (createHttpRequest == null) {
                return null;
            }
            if (request.getIsPreload()) {
                createHttpRequest.addSpecificPreloadHeader$forest_release(request.getPreloadFrom());
            }
            return createHttpRequest;
        }

        private final boolean shouldBeHandledByForest(WebResourceRequest webResourceRequest) {
            String method = webResourceRequest.getMethod();
            Intrinsics.checkExpressionValueIsNotNull(method, "webResourceRequest.method");
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
            if (method == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = method.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return Intrinsics.areEqual(lowerCase, "get");
        }

        public final ForestNetAPI.HttpResponse getHttpResponse$forest_release(final Response response, ForestNetAPI.HttpRequest httpRequest, ForestPipelineContext context) {
            final ForestNetAPI.HttpResponse httpResponse;
            Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
            Intrinsics.checkParameterIsNotNull(httpRequest, "httpRequest");
            Intrinsics.checkParameterIsNotNull(context, "context");
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = RangesKt.coerceAtLeast(response.getRequest().getLoadRetryTimes(), 1);
            if (intRef.element <= 0) {
                ForestLogger.printOptimize$default(context.getLogger(), 6, TTNetDepender.TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$Companion$getHttpResponse$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "remainedCDNTryCount less than zero, request:" + Response.this.getRequest();
                    }
                }, 24, null);
            }
            ForestNetAPI.HttpResponse.Companion.ForestNetException th = null;
            while (intRef.element > 0) {
                intRef.element--;
                try {
                    httpResponse = TTNetDepender.netAPI.get(httpRequest, context);
                } catch (ForestNetAPI.HttpResponse.Companion.ForestNetException e) {
                    th = e;
                    ForestLogger.print$default(context.getLogger(), 6, TTNetDepender.TAG, "Forest defined exception", true, th, null, 32, null);
                } catch (Throwable th2) {
                    th = th2;
                    ForestLogger.print$default(context.getLogger(), 6, TTNetDepender.TAG, "net error", true, th, null, 32, null);
                }
                if (!httpResponse.shouldRetry()) {
                    return httpResponse;
                }
                ForestLogger.printOptimize$default(context.getLogger(), 5, TTNetDepender.TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$Companion$getHttpResponse$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "net request should retry, cause by:" + ForestNetAPI.HttpResponse.this.getResponseHttpCode() + ". Headers:" + ForestNetAPI.HttpResponse.this.getResponseHttpHeader() + ". remainedCDNTryCount:" + intRef.element;
                    }
                }, 24, null);
            }
            if (th == null) {
                return null;
            }
            throw th;
        }

        public final void setNetAPI(ForestNetAPI netAPI) {
            Intrinsics.checkParameterIsNotNull(netAPI, "netAPI");
            TTNetDepender.netAPI = netAPI;
        }
    }

    public TTNetDepender(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        this.context = forestPipelineContext;
    }

    @Override // com.bytedance.forest.pollyfill.INetDepender
    public void fetchFile(Response response, final FetchTask fetchTask, boolean onlyLocal) {
        FetchTask putIfAbsent;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(fetchTask, "fetchTask");
        final Request request = response.getRequest();
        String url = request.getUrl();
        final ForestNetAPI.HttpRequest createHttpRequest$forest_release = INSTANCE.createHttpRequest$forest_release(url, request, this.context);
        if (createHttpRequest$forest_release == null) {
            ForestLogger.printOptimize$default(this.context.getLogger(), 4, TAG, true, null, LogReportNode.CDN_REQUEST_EMPTY_ERROR, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$fetchFile$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "create request failed, " + ForestNetAPI.HttpRequest.this;
                }
            }, 8, null);
            response.setSucceed(false);
            fetchTask.onFailure$forest_release(true, new Throwable("create request failed, " + createHttpRequest$forest_release));
            return;
        }
        fetchTask.setUnique$forest_release(createHttpRequest$forest_release);
        boolean mustRevalidate = fetchTask.getMustRevalidate();
        if (!mustRevalidate && !fetchTask.getOnlyLocal() && (putIfAbsent = loadingRequests.putIfAbsent(createHttpRequest$forest_release.toString(), fetchTask)) != null) {
            ForestLogger.printOptimize$default(this.context.getLogger(), 4, TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$fetchFile$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "another same request is executing, waiting for " + createHttpRequest$forest_release.getUrl() + " finish";
                }
            }, 28, null);
            if (putIfAbsent.registerSubTask$forest_release(fetchTask)) {
                ForestLogger.print$default(this.context.getLogger(), 4, TAG, "request hit by loading cache", false, null, null, 56, null);
                return;
            }
            ForestLogger.print$default(this.context.getLogger(), 6, TAG, "request hit by loading cache but failed", true, null, null, 48, null);
        }
        try {
            if (response.getRequest().getEnableCDNCache() && !mustRevalidate) {
                try {
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_CACHE_START}, null, 2, null);
                    boolean tryFetchFromCache = tryFetchFromCache(createHttpRequest$forest_release, response, onlyLocal, mustRevalidate);
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_ttnet_load_cache_finish"}, null, 2, null);
                    if (!tryFetchFromCache) {
                        tryFetchFromCache = DownloadDepender.INSTANCE.fetchCache(url, response, this.context);
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_downloader_load_cache_finish"}, null, 2, null);
                    }
                    if (tryFetchFromCache) {
                        fetchTask.onSuccess$forest_release();
                        if (response.getFilePath() != null) {
                            new File(response.getFilePath()).setLastModified(System.currentTimeMillis());
                            loadingRequests.remove(createHttpRequest$forest_release.toString());
                            return;
                        }
                        return;
                    }
                } finally {
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_CACHE_FINISH}, null, 2, null);
                }
            } else {
                ForestLogger.printOptimize$default(this.context.getLogger(), 4, TAG, true, null, LogReportNode.CDN_DISABLE_FETCH_CACHE, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$fetchFile$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "can not use cdn cache for " + ForestNetAPI.HttpRequest.this.getUrl();
                    }
                }, 8, null);
            }
            if (onlyLocal) {
                response.setSucceed(false);
                fetchTask.onFailure$forest_release(true, new Throwable("only local but no cache found"));
                loadingRequests.remove(createHttpRequest$forest_release.toString());
                return;
            }
            tryFetchOnline(createHttpRequest$forest_release, fetchTask, response);
        } catch (Throwable th) {
            String str = "exception occurred:" + th + ", msg=" + th.getMessage() + ", request:" + createHttpRequest$forest_release;
            ForestLogger.print$default(this.context.getLogger(), 6, TAG, str, true, th, null, 32, null);
            loadingRequests.remove(createHttpRequest$forest_release.toString());
            fetchTask.onFailure$forest_release(false, new Throwable(str));
            ForestLogger.printOptimize$default(this.context.getLogger(), 6, TAG, false, th, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$fetchFile$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "download failed request:" + Request.this;
                }
            }, 20, null);
        }
    }

    @Override // com.bytedance.forest.pollyfill.INetDepender
    public void cancel(FetchTask fetchTask) {
        Intrinsics.checkParameterIsNotNull(fetchTask, "fetchTask");
        Object unique = fetchTask.getUnique();
        if (!(unique instanceof ForestNetAPI.HttpRequest)) {
            unique = null;
        }
        ForestNetAPI.HttpRequest httpRequest = (ForestNetAPI.HttpRequest) unique;
        if (httpRequest != null) {
            httpRequest.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkHeadersMatch(Map<String, String> cachedHeaders, Map<String, String> requestHeaders) {
        String str;
        if (cachedHeaders == null) {
            return false;
        }
        String str2 = cachedHeaders.get(OfflineUtil.VARY_HEADER);
        List<String> list = null;
        if (str2 != null) {
            if (!(!StringsKt.isBlank(str2))) {
                str2 = null;
            }
            if (str2 != null) {
                list = StringsKt.split$default(str2, new String[]{","}, false, 0, 6, (Object) null);
            }
        }
        if (list != null && (!list.isEmpty())) {
            for (String str3 : list) {
                if (!StringsKt.isBlank(str3)) {
                    String str4 = cachedHeaders.get(FOREST_APPEND_PREFIX + str3);
                    if (requestHeaders == null || (str = requestHeaders.get(str3)) == null) {
                        str = "";
                    }
                    if (!Intrinsics.areEqual(str4, str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final boolean tryFetchFromCache(final ForestNetAPI.HttpRequest httpRequest, final Response response, final boolean onlyLocal, final boolean mustRevalidate) {
        ResponseCacheManager.INSTANCE.traverseAndFetchCacheIf(httpRequest.getUrl(), this.context.getLogger(), new Function1<String, Unit>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                ForestPipelineContext forestPipelineContext;
                Intrinsics.checkParameterIsNotNull(str, Api.COL_TAG);
                forestPipelineContext = TTNetDepender.this.context;
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{str}, null, 2, null);
            }
        }, new Function1<HttpResponseCache, Pair<? extends Boolean, ? extends Boolean>>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Pair<Boolean, Boolean> invoke(HttpResponseCache httpResponseCache) {
                Map<String, String> map;
                ForestPipelineContext forestPipelineContext;
                ForestPipelineContext forestPipelineContext2;
                ForestPipelineContext forestPipelineContext3;
                ForestNetAPI.HttpRequest createHttpRequest;
                ForestPipelineContext forestPipelineContext4;
                ForestPipelineContext forestPipelineContext5;
                ForestPipelineContext forestPipelineContext6;
                ForestPipelineContext forestPipelineContext7;
                ForestPipelineContext forestPipelineContext8;
                ForestPipelineContext forestPipelineContext9;
                ForestPipelineContext forestPipelineContext10;
                ForestPipelineContext forestPipelineContext11;
                boolean z;
                boolean commit;
                ForestPipelineContext forestPipelineContext12;
                ForestPipelineContext forestPipelineContext13;
                ForestPipelineContext forestPipelineContext14;
                ForestPipelineContext forestPipelineContext15;
                ForestPipelineContext forestPipelineContext16;
                ForestPipelineContext forestPipelineContext17;
                ForestPipelineContext forestPipelineContext18;
                ForestPipelineContext forestPipelineContext19;
                ForestPipelineContext forestPipelineContext20;
                ForestPipelineContext forestPipelineContext21;
                ForestPipelineContext forestPipelineContext22;
                ForestPipelineContext forestPipelineContext23;
                ForestPipelineContext forestPipelineContext24;
                ForestPipelineContext forestPipelineContext25;
                ForestPipelineContext forestPipelineContext26;
                boolean checkHeadersMatch;
                Intrinsics.checkParameterIsNotNull(httpResponseCache, "cache");
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = null;
                if (response.getRequest().isWebRequest()) {
                    map = httpResponseCache.provideHeaders();
                    checkHeadersMatch = TTNetDepender.this.checkHeadersMatch(map, httpRequest.getHeaders$forest_release());
                    if (!checkHeadersMatch) {
                        return new Pair<>(false, false);
                    }
                } else {
                    map = null;
                }
                if (mustRevalidate || httpResponseCache.isStale()) {
                    forestPipelineContext = TTNetDepender.this.context;
                    ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, TTNetDepender.TAG, true, null, LogReportNode.CDN_CACHE_EXPIRED_OR_REVALIDATE, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.1
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "request must revalidate or disk cache expired, " + httpRequest.getUrl();
                        }
                    }, 8, null);
                    if (!response.getRequest().getEnableNegotiation()) {
                        forestPipelineContext24 = TTNetDepender.this.context;
                        ForestLogger.print$default(forestPipelineContext24.getLogger(), 6, TTNetDepender.TAG, "negotiation disabled, do not start revalidate", false, null, null, 56, null);
                        return new Pair<>(false, false);
                    }
                    if (map == null) {
                        map = httpResponseCache.provideHeaders();
                    }
                    if (map == null) {
                        forestPipelineContext23 = TTNetDepender.this.context;
                        ForestLogger.print$default(forestPipelineContext23.getLogger(), 6, TTNetDepender.TAG, "stale cache but no headers found", true, null, null, 48, null);
                        return new Pair<>(false, false);
                    }
                    if (onlyLocal) {
                        forestPipelineContext22 = TTNetDepender.this.context;
                        ForestLogger.print$default(forestPipelineContext22.getLogger(), 6, TTNetDepender.TAG, "only local, do not start revalidate", false, null, null, 56, null);
                        return new Pair<>(false, false);
                    }
                    forestPipelineContext2 = TTNetDepender.this.context;
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext2, new String[]{"cdn_ttnet_prepare_negotiation_start"}, null, 2, null);
                    HashMap hashMap = new HashMap();
                    Map headers$forest_release = httpRequest.getHeaders$forest_release();
                    if (headers$forest_release == null) {
                        headers$forest_release = new LinkedHashMap();
                    }
                    for (Map.Entry entry : headers$forest_release.entrySet()) {
                        hashMap.put(entry.getKey(), entry.getValue());
                    }
                    String str = map.get("last-modified");
                    if (str != null) {
                    }
                    String str2 = map.get("etag");
                    if (str2 != null) {
                    }
                    HashMap hashMap2 = hashMap;
                    if (GeckoXAdapter.INSTANCE.isCDNMultiVersionResource(httpRequest.getUrl())) {
                        ForestNetAPI forestNetAPI = TTNetDepender.netAPI;
                        String addCDNMultiVersionCommonParams = CDNFetchDepender.INSTANCE.addCDNMultiVersionCommonParams(httpRequest.getUrl());
                        forestPipelineContext21 = TTNetDepender.this.context;
                        createHttpRequest = forestNetAPI.createHttpRequest(addCDNMultiVersionCommonParams, hashMap2, forestPipelineContext21);
                    } else {
                        ForestNetAPI forestNetAPI2 = TTNetDepender.netAPI;
                        String url = httpRequest.getUrl();
                        forestPipelineContext3 = TTNetDepender.this.context;
                        createHttpRequest = forestNetAPI2.createHttpRequest(url, hashMap2, forestPipelineContext3);
                    }
                    forestPipelineContext4 = TTNetDepender.this.context;
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext4, new String[]{"cdn_ttnet_prepare_negotiation_finish"}, null, 2, null);
                    if (createHttpRequest == null) {
                        forestPipelineContext20 = TTNetDepender.this.context;
                        ForestLogger.printOptimize$default(forestPipelineContext20.getLogger(), 6, TTNetDepender.TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.2
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "revalidate rejected, url: " + httpRequest.getUrl();
                            }
                        }, 24, null);
                        httpResponseCache.invalidate(false);
                        return new Pair<>(false, true);
                    }
                    forestPipelineContext5 = TTNetDepender.this.context;
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext5, new String[]{"cdn_ttnet_negotiation_request_start"}, null, 2, null);
                    TTNetDepender.Companion companion = TTNetDepender.INSTANCE;
                    Response response2 = response;
                    forestPipelineContext6 = TTNetDepender.this.context;
                    final ForestNetAPI.HttpResponse httpResponse$forest_release = companion.getHttpResponse$forest_release(response2, createHttpRequest, forestPipelineContext6);
                    forestPipelineContext7 = TTNetDepender.this.context;
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext7, new String[]{"cdn_ttnet_negotiation_request_finish"}, null, 2, null);
                    createHttpRequest.setUrl(httpRequest.getUrl());
                    if (httpResponse$forest_release != null && httpResponse$forest_release.isCacheValid()) {
                        forestPipelineContext13 = TTNetDepender.this.context;
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext13, new String[]{"cdn_ttnet_write_cache_start"}, null, 2, null);
                        forestPipelineContext14 = TTNetDepender.this.context;
                        ForestLogger.printOptimize$default(forestPipelineContext14.getLogger(), 4, TTNetDepender.TAG, true, null, "cdn_ttnet_write_cache", new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.3
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "request is valid " + httpRequest.getUrl();
                            }
                        }, 8, null);
                        forestPipelineContext15 = TTNetDepender.this.context;
                        ForestLogger.print$default(forestPipelineContext15.getLogger(), 4, TTNetDepender.TAG, "header of revalidate response is " + httpResponse$forest_release.getResponseHttpHeader(), false, null, null, 56, null);
                        Response response3 = response;
                        File provideFile = httpResponseCache.provideFile();
                        response3.setFilePath(provideFile != null ? provideFile.getPath() : null);
                        forestPipelineContext16 = TTNetDepender.this.context;
                        objectRef.element = httpResponseCache.provideForestBuffer(forestPipelineContext16, response.getRequest());
                        if (((InMemoryByteBuffer) objectRef.element) == null) {
                            HttpResponseCache.invalidate$default(httpResponseCache, false, 1, null);
                            forestPipelineContext19 = TTNetDepender.this.context;
                            ForestLogger.printOptimize$default(forestPipelineContext19.getLogger(), 6, TTNetDepender.TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.4
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    StringBuilder append = new StringBuilder("forest buffer is null. cache file:").append(response.getFilePath()).append(", exists:");
                                    String filePath = response.getFilePath();
                                    return append.append(filePath != null ? new File(filePath).isFile() : false).toString();
                                }
                            }, 24, null);
                            return new Pair<>(false, true);
                        }
                        z = !httpResponse$forest_release.getResponseHttpHeader().isEmpty();
                        Map<String, String> restoreResponseHeaders = OfflineUtil.INSTANCE.restoreResponseHeaders(map);
                        if (z) {
                            forestPipelineContext18 = TTNetDepender.this.context;
                            ForestLogger.printOptimize$default(forestPipelineContext18.getLogger(), 4, TTNetDepender.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.5
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "headers have changed: " + httpRequest.getUrl();
                                }
                            }, 28, null);
                            restoreResponseHeaders.putAll(httpResponse$forest_release.getResponseHttpHeader());
                            try {
                                httpResponseCache.updateFromOnline(httpResponse$forest_release, (InMemoryByteBuffer) objectRef.element, response);
                            } catch (Throwable unused) {
                                httpResponseCache.invalidate(false);
                            }
                        }
                        forestPipelineContext17 = TTNetDepender.this.context;
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext17, new String[]{"cdn_ttnet_write_cache_finish"}, null, 2, null);
                        response.setHttpResponse(httpResponse$forest_release);
                        response.setNegotiation(true);
                        response.setCache(true);
                        TTNetDepender.this.handleHeaders(restoreResponseHeaders, response, false, (InMemoryByteBuffer) objectRef.element);
                    } else if (httpResponse$forest_release != null && httpResponse$forest_release.isCacheChanged()) {
                        forestPipelineContext8 = TTNetDepender.this.context;
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext8, new String[]{"cdn_ttnet_write_cache_start"}, null, 2, null);
                        forestPipelineContext9 = TTNetDepender.this.context;
                        ForestLogger.printOptimize$default(forestPipelineContext9.getLogger(), 4, TTNetDepender.TAG, true, null, LogReportNode.CDN_REQUEST_IS_VALID, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.6
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "content changed: " + httpRequest.getUrl();
                            }
                        }, 8, null);
                        forestPipelineContext10 = TTNetDepender.this.context;
                        InMemoryByteBuffer obtainInMemoryByteBuffer$forest_release = forestPipelineContext10.obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.7
                            @Override // com.bytedance.forest.model.BytesProvider
                            public boolean isMultiProvider() {
                                return BytesProvider.DefaultImpls.isMultiProvider(this);
                            }

                            @Override // com.bytedance.forest.model.BytesProvider
                            public InputStream provideInputStream() {
                                return ForestNetAPI.HttpResponse.this.provideInputStream();
                            }
                        }, response.getRequest());
                        obtainInMemoryByteBuffer$forest_release.initCache$forest_release(OfflineUtil.INSTANCE.getResponseSize(httpResponse$forest_release.getResponseHttpHeader()));
                        objectRef.element = obtainInMemoryByteBuffer$forest_release;
                        if (response.getRequest().getNeedLocalFile()) {
                            commit = TTNetDepender.this.commit(httpResponse$forest_release, (InMemoryByteBuffer) objectRef.element, response);
                            if (!commit) {
                                forestPipelineContext12 = TTNetDepender.this.context;
                                ForestLogger.print$default(forestPipelineContext12.getLogger(), 6, TTNetDepender.TAG, "store file failed.", true, null, null, 48, null);
                                return new Pair<>(false, true);
                            }
                        }
                        if (!response.getRequest().getNeedLocalFile()) {
                            ThreadUtils.INSTANCE.postInSingleThread(new Runnable() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.9
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ConcurrentHashMap concurrentHashMap;
                                    InMemoryByteBuffer inMemoryByteBuffer = (InMemoryByteBuffer) objectRef.element;
                                    if (inMemoryByteBuffer != null) {
                                        TTNetDepender.this.commit(httpResponse$forest_release, inMemoryByteBuffer, response);
                                    }
                                    concurrentHashMap = TTNetDepender.loadingRequests;
                                    concurrentHashMap.remove(httpRequest.toString());
                                }
                            });
                        }
                        forestPipelineContext11 = TTNetDepender.this.context;
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext11, new String[]{"cdn_ttnet_write_cache_finish"}, null, 2, null);
                        response.setHttpResponse(httpResponse$forest_release);
                        TTNetDepender.this.handleHeaders(httpResponse$forest_release.getResponseHttpHeader(), response, false, (InMemoryByteBuffer) objectRef.element);
                        httpResponseCache.invalidate(false);
                        response.setNegotiation(true);
                        response.setCache(false);
                        z = true;
                    } else {
                        httpResponseCache.invalidate(false);
                        return new Pair<>(false, true);
                    }
                    response.setSucceed(true);
                    response.setInMemoryBuffer$forest_release((InMemoryByteBuffer) objectRef.element);
                    return new Pair<>(true, Boolean.valueOf(z));
                }
                InMemoryByteBuffer inMemoryByteBuffer = (InMemoryByteBuffer) objectRef.element;
                if (inMemoryByteBuffer == null) {
                    forestPipelineContext26 = TTNetDepender.this.context;
                    inMemoryByteBuffer = httpResponseCache.provideForestBuffer(forestPipelineContext26, response.getRequest());
                }
                if (inMemoryByteBuffer != null) {
                    objectRef.element = inMemoryByteBuffer;
                    forestPipelineContext25 = TTNetDepender.this.context;
                    ForestLogger.printOptimize$default(forestPipelineContext25.getLogger(), 4, TTNetDepender.TAG, true, null, LogReportNode.CDN_HIT_DISK_RESPONSE_CACHE, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchFromCache$2.10
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "request hit by disk response cache, " + httpRequest.getUrl();
                        }
                    }, 8, null);
                    response.setSucceed(true);
                    Response response4 = response;
                    File provideFile2 = httpResponseCache.provideFile();
                    response4.setFilePath(provideFile2 != null ? provideFile2.getPath() : null);
                    response.setCache(true);
                    response.setInMemoryBuffer$forest_release((InMemoryByteBuffer) objectRef.element);
                    response.setHttpHeader(map);
                    TTNetDepender.this.handleHeaders(map, response, true, (InMemoryByteBuffer) objectRef.element);
                    return new Pair<>(true, false);
                }
                return new Pair<>(false, false);
            }
        }, null);
        return response.getIsSucceed();
    }

    private final void tryFetchOnline(final ForestNetAPI.HttpRequest httpRequest, FetchTask fetchTask, final Response response) {
        ForestNetAPI.HttpRequest httpRequest2;
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_DOWNLOAD_START}, null, 2, null);
        if (!GeckoXAdapter.INSTANCE.isCDNMultiVersionResource(httpRequest.getUrl()) || (httpRequest2 = netAPI.createHttpRequest(CDNFetchDepender.INSTANCE.addCDNMultiVersionCommonParams(httpRequest.getUrl()), httpRequest.getHeaders$forest_release(), this.context)) == null) {
            httpRequest2 = httpRequest;
        }
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_DOWNLOAD_INTERNAL_START}, null, 2, null);
        final ForestNetAPI.HttpResponse httpResponse$forest_release = INSTANCE.getHttpResponse$forest_release(response, httpRequest2, this.context);
        if (httpResponse$forest_release == null) {
            response.setSucceed(false);
            String str = "fetch rejected, request:" + response.getRequest() + ", headers:" + httpRequest.getHeaders$forest_release();
            ForestLogger.print$default(this.context.getLogger(), 6, TAG, str, true, null, null, 48, null);
            fetchTask.onFailure$forest_release(true, new Throwable(str));
            loadingRequests.remove(httpRequest.toString());
            return;
        }
        httpResponse$forest_release.setRequest(httpRequest);
        ForestLogger.print$default(this.context.getLogger(), 4, TAG, "receive response: http code is " + httpResponse$forest_release.getResponseHttpCode() + ", time stamp: " + System.currentTimeMillis(), true, null, LogReportNode.CDN_RESPONSE_FROM_ONLINE, 16, null);
        if (handleRedirectionCase(httpResponse$forest_release, response, fetchTask)) {
            loadingRequests.remove(httpRequest.toString());
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_DOWNLOAD_FINISH}, null, 2, null);
            return;
        }
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_DOWNLOAD_FINISH}, null, 2, null);
        response.setHttpResponse(httpResponse$forest_release);
        if (!httpResponse$forest_release.isSuccessful()) {
            ForestLogger.printOptimize$default(this.context.getLogger(), 6, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchOnline$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "fetch failed, url: " + ForestNetAPI.HttpRequest.this.getUrl() + ", code:" + httpResponse$forest_release.getResponseHttpCode() + ", message:" + httpResponse$forest_release.getErrorMsg();
                }
            }, 24, null);
            response.setSucceed(false);
            fetchTask.onFailure$forest_release(true, new Throwable("fetch failed, url: " + httpRequest.getUrl() + ", code:" + httpResponse$forest_release.getResponseHttpCode() + ", message:" + httpResponse$forest_release.getErrorMsg()));
            loadingRequests.remove(httpRequest.toString());
            return;
        }
        final InMemoryByteBuffer obtainInMemoryByteBuffer$forest_release = this.context.obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchOnline$bytesProvider$1
            private volatile boolean isInputStreamProvided;

            @Override // com.bytedance.forest.model.BytesProvider
            public boolean isMultiProvider() {
                return BytesProvider.DefaultImpls.isMultiProvider(this);
            }

            /* renamed from: isInputStreamProvided, reason: from getter */
            public final boolean getIsInputStreamProvided() {
                return this.isInputStreamProvided;
            }

            public final void setInputStreamProvided(boolean z) {
                this.isInputStreamProvided = z;
            }

            @Override // com.bytedance.forest.model.BytesProvider
            public InputStream provideInputStream() {
                ForestPipelineContext forestPipelineContext;
                if (this.isInputStreamProvided) {
                    forestPipelineContext = TTNetDepender.this.context;
                    ForestLogger.print$default(forestPipelineContext.getLogger(), 6, ForestBuffer.TAG, "repeatedly calling provide input stream", true, null, null, 48, null);
                    return null;
                }
                this.isInputStreamProvided = true;
                return httpResponse$forest_release.provideInputStream();
            }
        }, response.getRequest());
        obtainInMemoryByteBuffer$forest_release.initCache$forest_release(OfflineUtil.INSTANCE.getResponseSize(httpResponse$forest_release.getResponseHttpHeader()));
        if (response.getRequest().getNeedLocalFile() && !commit(httpResponse$forest_release, obtainInMemoryByteBuffer$forest_release, response)) {
            ForestLogger.printOptimize$default(this.context.getLogger(), 6, TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchOnline$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "store file failed, url: " + ForestNetAPI.HttpRequest.this.getUrl();
                }
            }, 28, null);
            response.setSucceed(false);
            fetchTask.onFailure$forest_release(true, new Throwable("store file failed, url: " + httpRequest.getUrl()));
            loadingRequests.remove(httpRequest.toString());
            return;
        }
        response.setSucceed(true);
        response.setInMemoryBuffer$forest_release(obtainInMemoryByteBuffer$forest_release);
        handleHeaders(httpResponse$forest_release.getResponseHttpHeader(), response, false, obtainInMemoryByteBuffer$forest_release);
        fetchTask.onSuccess$forest_release();
        ForestLogger.printOptimize$default(this.context.getLogger(), 4, TAG, true, null, Timing.CDN_FINISH, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchOnline$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "request fetch task succeeded, " + ForestNetAPI.HttpRequest.this.getUrl();
            }
        }, 8, null);
        if (!obtainInMemoryByteBuffer$forest_release.isCacheProvided$forest_release()) {
            ForestLogger.print$default(this.context.getLogger(), 6, TAG, "request cache provide failed", true, null, null, 48, null);
            loadingRequests.remove(httpRequest.toString());
        } else if (!response.getRequest().getEnableCDNCache() || !httpResponse$forest_release.supportCache()) {
            ForestLogger.print$default(this.context.getLogger(), 4, TAG, "not support cache", false, null, null, 56, null);
            loadingRequests.remove(httpRequest.toString());
        } else if (response.getRequest().getNeedLocalFile()) {
            loadingRequests.remove(httpRequest.toString());
        } else {
            ThreadUtils.INSTANCE.postInSingleThread(new Runnable() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$tryFetchOnline$4
                @Override // java.lang.Runnable
                public final void run() {
                    ConcurrentHashMap concurrentHashMap;
                    TTNetDepender.this.commit(httpResponse$forest_release, obtainInMemoryByteBuffer$forest_release, response);
                    concurrentHashMap = TTNetDepender.loadingRequests;
                    concurrentHashMap.remove(httpRequest.toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean commit(ForestNetAPI.HttpResponse httpResponse, InMemoryByteBuffer forestBuffer, Response response) {
        Object obj;
        if (!forestBuffer.isCacheProvided$forest_release()) {
            ForestLogger.print$default(this.context.getLogger(), 6, TAG, "forest buffer does not provide cache", false, null, null, 56, null);
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(new HttpResponseCache(httpResponse, forestBuffer, response));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        final HttpResponseCache httpResponseCache = (HttpResponseCache) obj;
        if (httpResponseCache == null) {
            return false;
        }
        ResponseCacheManager.traverseAndFetchCacheIf$default(ResponseCacheManager.INSTANCE, httpResponse.getRequest().getUrl(), this.context.getLogger(), null, new Function1<HttpResponseCache, Pair<? extends Boolean, ? extends Boolean>>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$commit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Pair<Boolean, Boolean> invoke(final HttpResponseCache httpResponseCache2) {
                ForestConcurrentList.ForestListNode tryInsertToNext;
                ForestPipelineContext forestPipelineContext;
                ForestPipelineContext forestPipelineContext2;
                Intrinsics.checkParameterIsNotNull(httpResponseCache2, "cache");
                if (httpResponseCache2.getVaryNum() > httpResponseCache.getVaryNum()) {
                    return new Pair<>(false, false);
                }
                if (Intrinsics.areEqual(httpResponseCache2.getCacheKey(), httpResponseCache.getCacheKey())) {
                    forestPipelineContext2 = TTNetDepender.this.context;
                    ForestLogger.printOptimize$default(forestPipelineContext2.getLogger(), 6, TTNetDepender.TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$commit$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "cache key collision, cached url = " + httpResponseCache2.getUrl() + ", caching url = " + httpResponseCache.getUrl();
                        }
                    }, 24, null);
                    return new Pair<>(true, false);
                }
                do {
                    tryInsertToNext = httpResponseCache2.tryInsertToNext(httpResponseCache);
                    if (tryInsertToNext == null) {
                        break;
                    }
                    if (tryInsertToNext == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.model.HttpResponseCache");
                    }
                    HttpResponseCache httpResponseCache3 = (HttpResponseCache) tryInsertToNext;
                    if (httpResponseCache3.getVaryNum() > httpResponseCache.getVaryNum()) {
                        httpResponseCache2 = httpResponseCache3;
                    }
                } while (tryInsertToNext != null);
                forestPipelineContext = TTNetDepender.this.context;
                ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, TTNetDepender.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$commit$1.3
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "cache added into list, " + httpResponseCache.getCacheKey();
                    }
                }, 28, null);
                return new Pair<>(true, true);
            }
        }, new Function1<ForestConcurrentList<HttpResponseCache>, Boolean>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$commit$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return Boolean.valueOf(invoke((ForestConcurrentList<HttpResponseCache>) obj2));
            }

            public final boolean invoke(ForestConcurrentList<HttpResponseCache> forestConcurrentList) {
                ForestPipelineContext forestPipelineContext;
                Intrinsics.checkParameterIsNotNull(forestConcurrentList, "list");
                forestConcurrentList.insertToHead(httpResponseCache);
                forestPipelineContext = TTNetDepender.this.context;
                ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, TTNetDepender.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$commit$2.1
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "cache added into list, " + httpResponseCache.getCacheKey();
                    }
                }, 28, null);
                return true;
            }
        }, 4, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleHeaders(Map<String, String> headers, Response response, boolean needRestore, InMemoryByteBuffer forestBuffer) {
        Long longOrNull;
        if (headers != null) {
            if (needRestore) {
                headers = OfflineUtil.INSTANCE.restoreResponseHeaders(headers);
            }
            Map<String, String> map = headers;
            if (map != null) {
                response.setHttpHeader(map);
                Pair<String, String> mimeTypeAndEncoding = getMimeTypeAndEncoding(map);
                String str = (String) mimeTypeAndEncoding.component1();
                String str2 = (String) mimeTypeAndEncoding.component2();
                response.setDataType$forest_release(str);
                response.setCharset$forest_release(str2);
                String str3 = map.get(CDNFetchDepender.KEY_VERSION);
                response.setVersion((str3 == null || (longOrNull = StringsKt.toLongOrNull(str3)) == null) ? 0L : longOrNull.longValue());
                if (response.getRequest().isWebRequest()) {
                    response.setWebResourceResponseFromTTNet(OfflineUtil.INSTANCE.generateWebResourceResponse(str, str2, forestBuffer.provideInputStream(response), response.getRequest().getUrl(), map));
                }
            }
        }
    }

    private final boolean handleRedirectionCase(ForestNetAPI.HttpResponse httpResponse, final Response response, FetchTask fetchTask) {
        int responseHttpCode = httpResponse.getResponseHttpCode();
        if (300 <= responseHttpCode && 399 >= responseHttpCode) {
            response.setRedirection(true);
            final String str = httpResponse.getResponseHttpHeader().get(BatteryTypeInf.BATTERY_LOC_API);
            if (str != null) {
                ForestLogger.printOptimize$default(this.context.getLogger(), 4, TAG, true, null, LogReportNode.CDN_REQUEST_REDIRECT, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.TTNetDepender$handleRedirectionCase$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "redirect to " + str + ", source url: " + response.getRequest().getOriginUrl();
                    }
                }, 8, null);
                fetchTask.onRedirection$forest_release(str);
                return true;
            }
        }
        return false;
    }

    private final Pair<String, String> getMimeTypeAndEncoding(Map<String, String> headers) {
        String str;
        Charset charset;
        MediaType mediaType = getMediaType(headers);
        String str2 = mediaType == null ? "text/html" : mediaType.type() + "/" + mediaType.subtype();
        if (mediaType == null || (charset = mediaType.charset()) == null || (str = charset.toString()) == null) {
            str = "";
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "mediaType?.charset()?.toString() ?: \"\"");
        return TuplesKt.to(str2, str);
    }

    private final MediaType getMediaType(Map<String, String> headers) {
        String str;
        if (headers == null || (str = headers.get("content-type")) == null) {
            str = "text/html; charset=UTF-8";
        }
        return MediaType.parse(str);
    }
}
