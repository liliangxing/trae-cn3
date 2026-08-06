package com.bytedance.forest;

import android.net.Uri;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.SecureMode;
import com.bytedance.forest.model.URIQueryParamKeys;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.forest.utils.CacheIdentifier;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.ThreadUtils;
import com.bytedance.geckox.statistic.monitor.MonitorManager;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ResourceReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\t\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Jd\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\b0\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0002J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0002JP\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\b0\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J8\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002JU\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00072 \u0010\u0018\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\b\u0018\u00010\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\"J!\u0010#\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b&J7\u0010'\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\b\b\u0001\u0010*\u001a\u00020\u001aH\u0000¢\u0006\u0002\b+J\b\u0010,\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/forest/InternalReporter;", "", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "assemble", "", "", "", "resLoaderInfo", "resInfo", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "resLoadError", "generateResError", "generateResInfo", "request", "Lcom/bytedance/forest/model/Request;", "report", "", "eventName", "category", "Lorg/json/JSONObject;", "extra", "data", "sample", "", "report2Component", "event", "report2Custom", "metrics", "report2WholeChain", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/bytedance/forest/model/Response;)Lkotlin/Unit;", "reportFetchResult", "reportFetchResult$forest_release", "reportForestConsume", "e", "", "reportForestConsume$forest_release", "reportForestLoadSecure", "channel", "bundle", "mode", "reportForestLoadSecure$forest_release", "transform2MetricsJSONObject", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class InternalReporter {
    private static final String FOREST_LOAD_SECURE_EVENT = "res_gecko_loader_secure";
    private static final String LOAD_EVENT = "res_loader_perf";
    private static final String LOAD_FAILED_EVENT = "res_loader_error";
    private static final String LOAD_TEMPLATE_EVENT = "res_loader_perf_template";
    private static final String LOAD_TEMPLATE_FAILED_EVENT = "res_loader_error_template";
    public static final String TAG = "InternalResourceReporter";
    private final ForestPipelineContext context;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy uniqueId$delegate = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.forest.InternalReporter$Companion$uniqueId$2
        public final String invoke() {
            return new StringBuilder().append(Forest.INSTANCE.getApp().hashCode()).append('-').append(InternalReporter.INSTANCE.hashCode()).append('-').append(System.currentTimeMillis()).toString();
        }
    });

    /* compiled from: ResourceReporter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/forest/InternalReporter$Companion;", "", "()V", "FOREST_LOAD_SECURE_EVENT", "", "LOAD_EVENT", "LOAD_FAILED_EVENT", "LOAD_TEMPLATE_EVENT", "LOAD_TEMPLATE_FAILED_EVENT", "TAG", "uniqueId", "getUniqueId", "()Ljava/lang/String;", "uniqueId$delegate", "Lkotlin/Lazy;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        public final String getUniqueId() {
            Lazy lazy = InternalReporter.uniqueId$delegate;
            Companion companion = InternalReporter.INSTANCE;
            return (String) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public InternalReporter(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        this.context = forestPipelineContext;
    }

    public final void reportFetchResult$forest_release(final Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        ThreadUtils.INSTANCE.runInReportThread(new Runnable() { // from class: com.bytedance.forest.InternalReporter$reportFetchResult$1
            @Override // java.lang.Runnable
            public final void run() {
                Map generateResInfo;
                Map generateResError;
                Map assemble;
                Request request = response.getRequest();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("res_loader_name", "forest");
                linkedHashMap.put("res_loader_version", BuildConfig.FOREST_SDK_VERSION);
                generateResInfo = InternalReporter.this.generateResInfo(request, response);
                generateResError = InternalReporter.this.generateResError(response);
                assemble = InternalReporter.this.assemble(linkedHashMap, generateResInfo, response, generateResError);
                JSONObject jSONObject = new JSONObject(generateResInfo);
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
                for (Map.Entry entry2 : generateResError.entrySet()) {
                    jSONObject.put((String) entry2.getKey(), entry2.getValue());
                }
                boolean contains = CollectionsKt.listOf(new Scene[]{Scene.LYNX_TEMPLATE, Scene.WEB_MAIN_DOCUMENT}).contains(request.getScene());
                JSONObject jSONObject2 = new JSONObject(request.getCustomParams());
                if (!response.getIsSucceed()) {
                    InternalReporter.this.report(contains ? ReportConst.Event.RES_LOADER_ERROR_TEMPLATE : ReportConst.Event.RES_LOADER_ERROR, jSONObject, response, jSONObject2, assemble, 0);
                }
                InternalReporter.this.report(contains ? ReportConst.Event.RES_LOADER_PERF_TEMPLATE : ReportConst.Event.RES_LOADER_PERF, jSONObject, response, jSONObject2, assemble, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> generateResInfo(Request request, Response response) {
        String cacheIdentifier;
        Uri parse;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("res_src", request.getOriginUrl());
        linkedHashMap.put(URIQueryParamKeys.KEY_ACCESS_KEY, request.getGeckoModel().getAccessKey());
        linkedHashMap.put(URIQueryParamKeys.KEY_CHANNEL, request.getGeckoModel().getChannel());
        linkedHashMap.put(URIQueryParamKeys.KEY_BUNDLE, request.getGeckoModel().getBundle());
        linkedHashMap.put("res_version", Long.valueOf(response.getVersion()));
        linkedHashMap.put("res_state", response.getIsSucceed() ? "success" : "failed");
        linkedHashMap.put("gecko_sync_update", Boolean.valueOf(request.getWaitGeckoUpdate()));
        linkedHashMap.put("cdn_cache_enable", Boolean.valueOf(request.getEnableCDNCache()));
        linkedHashMap.put("load_to_memory", Boolean.valueOf(request.getLoadToMemory()));
        String name = request.getScene().name();
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
        if (name == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        linkedHashMap.put("res_scene", lowerCase);
        String name2 = request.getGeckoSource().name();
        Locale locale2 = Locale.ENGLISH;
        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ENGLISH");
        if (name2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = name2.toLowerCase(locale2);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        linkedHashMap.put("gecko_config_from", lowerCase2);
        linkedHashMap.put("res_trace_id", request.getGroupId());
        linkedHashMap.put("cold_start_unique_id", INSTANCE.getUniqueId());
        linkedHashMap.put("is_async", Boolean.valueOf(request.getIsASync()));
        boolean z = false;
        boolean z2 = response.getFrom() == ResourceFrom.MEMORY;
        linkedHashMap.put("is_memory", Boolean.valueOf(z2));
        linkedHashMap.put(WebViewMonitorConstant.Web.RES_FROM, z2 ? response.getSourceType(response.getOriginFrom()) : Response.getSourceType$default(response, null, 1, null));
        String extension$forest_release = response.getExtension$forest_release();
        if (extension$forest_release == null) {
            extension$forest_release = "unknown";
        }
        linkedHashMap.put("res_type", extension$forest_release);
        List<FetcherType> fetcherSequence = request.getFetcherSequence();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fetcherSequence, 10));
        Iterator<T> it = fetcherSequence.iterator();
        while (it.hasNext()) {
            String name3 = ((FetcherType) it.next()).name();
            Locale locale3 = Locale.ENGLISH;
            Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.ENGLISH");
            if (name3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase3 = name3.toLowerCase(locale3);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
            arrayList.add(lowerCase3);
        }
        linkedHashMap.put("fetcher_list", arrayList);
        String filePath = response.getFilePath();
        if (filePath != null) {
            try {
                linkedHashMap.put(WebViewMonitorConstant.Web.RES_SIZE, Long.valueOf(Long.valueOf(new File(filePath).length()).longValue()));
            } catch (Exception e) {
                ForestLogger.print$default(this.context.getLogger(), 6, ResourceReporter.TAG, "get file length error", false, e, null, 40, null);
                Unit unit = Unit.INSTANCE;
            }
        }
        linkedHashMap.put("is_preload", Boolean.valueOf(response.getRequest().getIsPreload()));
        String str = "";
        if (request.getScene() == Scene.LYNX_IMAGE && request.getEnableRequestReuse() && !response.getIsPreloaded() && !request.getIsPreload()) {
            try {
                Result.Companion companion = Result.Companion;
                ImagePipeline imagePipeline = Fresco.getImagePipeline();
                if (response.getIsSucceed()) {
                    parse = new Uri.Builder().scheme("file").authority("").path(response.getFilePath()).build();
                } else {
                    parse = Uri.parse(request.getOriginUrl());
                }
                response.setPreloaded(imagePipeline.isInBitmapMemoryCache(parse));
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
        linkedHashMap.put("is_preloaded", Boolean.valueOf(response.getIsPreloaded()));
        if ((response instanceof ProcessedResponse) && ((ProcessedResponse) response).getIsProcessSucceed()) {
            z = true;
        }
        linkedHashMap.put("is_post_processed", Boolean.valueOf(z));
        linkedHashMap.put("is_request_reused", Boolean.valueOf(response.getIsRequestReused()));
        linkedHashMap.put("enable_request_reuse", Boolean.valueOf(response.getRequest().getEnableRequestReuse()));
        linkedHashMap.put("has_been_paused", Boolean.valueOf(response.getHasBeenPaused()));
        linkedHashMap.put("is_cdn_cache_negotiation", Boolean.valueOf(response.getIsNegotiation()));
        linkedHashMap.put("is_cdn_redirection", Boolean.valueOf(response.getIsRedirection()));
        ForestNetAPI.HttpResponse httpResponse = response.getHttpResponse();
        linkedHashMap.put("http_code", httpResponse != null ? Integer.valueOf(httpResponse.getResponseHttpCode()) : ArgusConstants.NULL_PLACE_HOLDER);
        linkedHashMap.put("is_stream_loaded", Boolean.valueOf(response.getIsStreamLoaded()));
        linkedHashMap.put("use_gkfs", Boolean.valueOf(response.getUseGkFS()));
        CacheIdentifier cacheKey$forest_release = response.getRequest().getCacheKey$forest_release();
        if (cacheKey$forest_release != null && (cacheIdentifier = cacheKey$forest_release.toString()) != null) {
            str = cacheIdentifier;
        }
        linkedHashMap.put("cache_identity", str);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> generateResError(Response response) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("net_library_error_code", Integer.valueOf(response.getErrorInfo().getNetLibraryErrorCode()));
        linkedHashMap.put("http_status_code", Integer.valueOf(response.getErrorInfo().getHttpStatusCode()));
        linkedHashMap.put("res_loader_error_code", Integer.valueOf(response.getErrorInfo().getErrorCode()));
        linkedHashMap.put("res_error_msg", response.getErrorInfo().toString());
        linkedHashMap.put("gecko_error_code", Integer.valueOf(response.getErrorInfo().getGeckoErrorCode()));
        linkedHashMap.put("gecko_error_msg", response.getErrorInfo().getGeckoError());
        linkedHashMap.put("gecko_library_read_error_code", Integer.valueOf(response.getErrorInfo().getGecko_library_read_error_code()));
        linkedHashMap.put("gecko_library_read_error_msg", response.getErrorInfo().getGecko_library_read_error_msg());
        linkedHashMap.put("gecko_cdn_library_read_error_code", Integer.valueOf(response.getErrorInfo().getGecko_cdn_library_read_error_code()));
        linkedHashMap.put("gecko_cdn_library_read_error_msg", response.getErrorInfo().getGecko_cdn_library_read_error_msg());
        linkedHashMap.put("builtin_error_msg", response.getErrorInfo().getBuiltinError());
        linkedHashMap.put("cdn_error_msg", response.getErrorInfo().getCdnError());
        linkedHashMap.put("memory_error", response.getErrorInfo().getMemoryError());
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report(String eventName, JSONObject category, Response response, JSONObject extra, Map<String, Map<String, Object>> data, int sample) {
        Request request = response.getRequest();
        JSONObject report2Component = report2Component(eventName, category, extra);
        if (request.getIsPreload()) {
            if (report2Component == null) {
                report2Component = transform2MetricsJSONObject();
            }
            report2Custom(eventName, category, report2Component, extra, response, sample);
            return;
        }
        report2WholeChain(eventName, data, request.getCustomParams(), response);
    }

    private final Unit report2WholeChain(String eventName, Map<String, Map<String, Object>> data, Map<String, ? extends Object> extra, Response response) {
        if (data == null) {
            return null;
        }
        ResourceReporter.INSTANCE.onReportResult$forest_release(eventName, data, extra, response, this.context);
        return Unit.INSTANCE;
    }

    private final void report2Custom(String event, JSONObject category, JSONObject metrics, JSONObject extra, Response response, int sample) {
        ResourceReporter.INSTANCE.customReport$forest_release(response, event, category, metrics, extra, sample, this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Map<String, Object>> assemble(Map<String, Object> resLoaderInfo, Map<String, Object> resInfo, Response response, Map<String, Object> resLoadError) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("res_loader_info", resLoaderInfo);
        linkedHashMap.put("res_info", resInfo);
        linkedHashMap.put("res_load_perf", this.context.getPerformanceInfo$forest_release());
        linkedHashMap.put("res_load_error", resLoadError);
        return linkedHashMap;
    }

    private final JSONObject report2Component(String event, JSONObject category, JSONObject extra) {
        if (!MonitorManager.inst().hasInit()) {
            return null;
        }
        JSONObject transform2MetricsJSONObject = transform2MetricsJSONObject();
        MonitorManager.inst().monitorEvent(event, category, transform2MetricsJSONObject, extra);
        return transform2MetricsJSONObject;
    }

    private final JSONObject transform2MetricsJSONObject() {
        String removeSuffix;
        long longValue;
        JSONObject jSONObject = new JSONObject();
        try {
            ConcurrentHashMap<String, Long> performanceInfo$forest_release = this.context.getPerformanceInfo$forest_release();
            Set<Map.Entry<String, Long>> entrySet = performanceInfo$forest_release.entrySet();
            Intrinsics.checkExpressionValueIsNotNull(entrySet, "performance.entries");
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
                String str = (String) key;
                boolean z = false;
                String str2 = "_finish";
                if (StringsKt.endsWith$default(str, "_start", false, 2, (Object) null)) {
                    removeSuffix = StringsKt.removeSuffix(str, "_start");
                    z = true;
                } else {
                    removeSuffix = StringsKt.removeSuffix(str, "_finish");
                }
                if (jSONObject.opt(removeSuffix) == null) {
                    StringBuilder append = new StringBuilder().append(removeSuffix);
                    if (!z) {
                        str2 = "_start";
                    }
                    String sb = append.append(str2).toString();
                    if (performanceInfo$forest_release.containsKey(sb)) {
                        if (z) {
                            Long l = performanceInfo$forest_release.get(sb);
                            if (l == null) {
                                Intrinsics.throwNpe();
                            }
                            long longValue2 = l.longValue();
                            Object value = entry.getValue();
                            Intrinsics.checkExpressionValueIsNotNull(value, "it.value");
                            longValue = longValue2 - ((Number) value).longValue();
                        } else {
                            long longValue3 = ((Number) entry.getValue()).longValue();
                            Long l2 = performanceInfo$forest_release.get(sb);
                            if (l2 == null) {
                                Intrinsics.throwNpe();
                            }
                            Intrinsics.checkExpressionValueIsNotNull(l2, "performance[reverse]!!");
                            longValue = longValue3 - l2.longValue();
                        }
                        jSONObject.put(removeSuffix, longValue);
                    }
                }
            }
        } catch (Exception e) {
            ForestLogger.print$default(this.context.getLogger(), 6, ResourceReporter.TAG, "assemble duration error", false, e, null, 40, null);
        }
        return jSONObject;
    }

    public static /* synthetic */ void reportForestConsume$forest_release$default(InternalReporter internalReporter, Response response, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        internalReporter.reportForestConsume$forest_release(response, th);
    }

    public final void reportForestConsume$forest_release(final Response response, final Throwable e) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        ThreadUtils.INSTANCE.runInBackground(new Function0<Unit>() { // from class: com.bytedance.forest.InternalReporter$reportForestConsume$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m465invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m465invoke() {
                Request request = Response.this.getRequest();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resource_url", request.getOriginUrl());
                jSONObject.put("source_type", Response.getSourceType$default(Response.this, null, 1, null));
                jSONObject.put("load_to_memory", request.getLoadToMemory());
                jSONObject.put("access_key", request.getGeckoModel().getAccessKey());
                jSONObject.put("channel", request.getGeckoModel().getChannel());
                jSONObject.put("bundle", request.getGeckoModel().getBundle());
                jSONObject.put("version", Response.this.getVersion());
                jSONObject.put("resource_tag", request.getScene());
                String name = request.getGeckoSource().name();
                Locale locale = Locale.ENGLISH;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
                if (name == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                jSONObject.put("config_source", lowerCase);
                jSONObject.put("group_id", request.getGroupId());
                jSONObject.put("sdk_version", BuildConfig.FOREST_SDK_VERSION);
                Response response2 = Response.this;
                jSONObject.put("memory_source", response2.getSourceType(response2.getOriginFrom()));
                jSONObject.put(CpuReportEvent.PERF_DATA_TYPE, Response.this.getDataType());
                JSONObject jSONObject2 = new JSONObject();
                if (e != null && MonitorManager.inst().hasInit()) {
                    MonitorManager.inst().monitorEvent("forest_resource_consume_error", jSONObject, jSONObject2, null);
                }
                if (MonitorManager.inst().hasInit()) {
                    MonitorManager.inst().monitorEvent("forest_resource_consume", jSONObject, jSONObject2, null);
                }
            }
        });
    }

    public final void reportForestLoadSecure$forest_release(final Response response, final ForestPipelineContext context, final String channel, final String bundle, @SecureMode final int mode) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        ThreadUtils.INSTANCE.runInReportThread(new Runnable() { // from class: com.bytedance.forest.InternalReporter$reportForestLoadSecure$1
            @Override // java.lang.Runnable
            public final void run() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("channel", channel);
                jSONObject.put("bundle", bundle);
                jSONObject.put("loader", GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG);
                jSONObject.put("mode", mode);
                ResourceReporter.INSTANCE.customReport$forest_release(response, "res_gecko_loader_secure", jSONObject, new JSONObject(), new JSONObject(), 0, context);
            }
        });
    }
}
