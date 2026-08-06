package com.bytedance.forest;

import android.app.Application;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.ResourceFetchScheduler;
import com.bytedance.forest.chain.ResourceFetcherChain;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.chain.fetchers.MemoryFetcher;
import com.bytedance.forest.interceptor.GlobalInterceptor;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.ForestConfig;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.RequestOperation;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.ResourceConfig;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.Status;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.pollyfill.TTNetDepender;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.PostProcessOperation;
import com.bytedance.forest.postprocessor.PostProcessParams;
import com.bytedance.forest.postprocessor.PostProcessRequest;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.forest.postprocessor.ResourceProcessChain;
import com.bytedance.forest.preload.PreLoader;
import com.bytedance.forest.preload.PreloadResult;
import com.bytedance.forest.utils.CacheIdentifier;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.forest.utils.MemoryCacheItem;
import com.bytedance.forest.utils.MemoryManager;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.ThreadUtils;
import com.bytedance.forest.utils.UriParserKt;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Forest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 ]2\u00020\u0001:\u0001]B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'J\u0018\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"J.\u0010-\u001a\n\u0012\u0004\u0012\u0002H/\u0018\u00010.\"\b\b\u0000\u0010/*\u00020\u00012\u0006\u0010&\u001a\u00020'2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H/00J4\u00101\u001a\u00020,2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020)03H\u0002JB\u00104\u001a\u0004\u0018\u00010,\"\b\b\u0000\u0010/*\u00020\u00012\u0006\u0010&\u001a\u00020'2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H/002\u0018\u00102\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/05\u0012\u0004\u0012\u00020)03J,\u00106\u001a\u0004\u0018\u00010,2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020)03J\u0015\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020,H\u0001¢\u0006\u0002\b9J+\u0010:\u001a\b\u0012\u0004\u0012\u0002H/05\"\b\b\u0000\u0010/*\u00020\u00012\f\u00108\u001a\b\u0012\u0004\u0012\u0002H/0.H\u0001¢\u0006\u0002\b;J,\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020)03H\u0002J\u001c\u0010>\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0006\u0010?\u001a\u00020)J\u0012\u0010@\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'Jx\u0010A\u001a\u0016\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0C\u0018\u00010B2\b\u0010E\u001a\u0004\u0018\u00010F2\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0006\u0012\u0004\u0018\u00010'0B2\u0006\u0010H\u001a\u00020\u001e2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\"\b\u0002\u0010M\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010N\u0018\u000103j\u0004\u0018\u0001`OH\u0002J(\u0010\u001f\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020P2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'H\u0007J:\u0010\u001f\u001a\u00020)2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010R\u001a\u00020\u001e2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'H\u0007J\\\u0010\u001f\u001a\u00020)2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010R\u001a\u00020\u001e2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'2\"\b\u0002\u0010M\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010N\u0018\u000103j\u0004\u0018\u0001`OJH\u0010\u001f\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010!\u001a\u00020\"2\b\u0010S\u001a\u0004\u0018\u00010F2\"\b\u0002\u0010M\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010N\u0018\u000103j\u0004\u0018\u0001`OH\u0007J\u0092\u0001\u0010\u001f\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010S\u001a\u0004\u0018\u00010F2\u0006\u0010T\u001a\u00020U2\u000e\b\u0002\u0010V\u001a\b\u0012\u0002\b\u0003\u0018\u00010N2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010K\u001a\u00020L2\"\b\u0002\u0010M\u001a\u001c\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010N\u0018\u000103j\u0004\u0018\u0001`OH\u0007J(\u0010Y\u001a\u00020 2\u0006\u0010Z\u001a\u00020 2\u0006\u0010[\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J,\u0010\\\u001a\u00020)2\u0006\u0010#\u001a\u00020$2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020)032\u0006\u0010=\u001a\u00020 H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006^"}, d2 = {"Lcom/bytedance/forest/Forest;", "", "application", "Landroid/app/Application;", "config", "Lcom/bytedance/forest/model/ForestConfig;", "(Landroid/app/Application;Lcom/bytedance/forest/model/ForestConfig;)V", "getApplication", "()Landroid/app/Application;", "getConfig", "()Lcom/bytedance/forest/model/ForestConfig;", "geckoXAdapter", "Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "getGeckoXAdapter", "()Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "memoryManager", "Lcom/bytedance/forest/utils/MemoryManager;", "getMemoryManager$forest_release", "()Lcom/bytedance/forest/utils/MemoryManager;", "preLoader", "Lcom/bytedance/forest/preload/PreLoader;", "getPreLoader", "()Lcom/bytedance/forest/preload/PreLoader;", "preLoader$delegate", "Lkotlin/Lazy;", "sessionManager", "Lcom/bytedance/forest/SessionManager;", "getSessionManager$forest_release", "()Lcom/bytedance/forest/SessionManager;", "checkRequestReuseValid", "", "preload", "Lcom/bytedance/forest/model/Response;", "params", "Lcom/bytedance/forest/model/RequestParams;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "checkRequestValid", "url", "", "closeSession", "", "sessionId", "createSyncRequest", "Lcom/bytedance/forest/model/RequestOperation;", "createSyncRequestWithProcessor", "Lcom/bytedance/forest/postprocessor/PostProcessOperation;", "T", "Lcom/bytedance/forest/postprocessor/PostProcessParams;", "fetchAsyncInner", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchAsyncWithProcessor", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "fetchResourceAsync", "fetchSync", "operation", "fetchSync$forest_release", "fetchSyncWithProcessor", "fetchSyncWithProcessor$forest_release", "finishWithCallback", ApmTrafficStats.TTNET_RESPONSE, "isPreloaded", "onLowMemory", "openSession", "parseSubResourceConfig", "", "", "Lcom/bytedance/forest/model/ResourceConfig;", "json", "Lorg/json/JSONObject;", "envParams", "disableCdn", "netWorker", "Lcom/bytedance/forest/pollyfill/NetWorker;", "maxAge", "", "postProcessorBuilder", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "Lcom/bytedance/forest/PostProcessorBuilder;", "Lcom/bytedance/forest/model/PreloadConfig;", "containerId", "withSubResources", "subRes", "type", "Lcom/bytedance/forest/model/PreloadType;", "processor", "from", "userAgent", "reuseResponse", "originResponse", "waited", "triggerCallback", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Forest {
    public static Application app;
    private static int cdnCacheDiskMaxAge;
    private static boolean enableKEVAOpt;
    private static ForestEnvData envData;
    private final Application application;
    private final ForestConfig config;
    private final GeckoXAdapter geckoXAdapter;
    private final MemoryManager memoryManager;

    /* renamed from: preLoader$delegate, reason: from kotlin metadata */
    private final Lazy preLoader;
    private final SessionManager sessionManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CopyOnWriteArrayList<WeakReference<Forest>> instanceRefs = new CopyOnWriteArrayList<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ResourceFrom.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ResourceFrom.GECKO.ordinal()] = 1;
            iArr[ResourceFrom.CDN.ordinal()] = 2;
            iArr[ResourceFrom.BUILTIN.ordinal()] = 3;
            int[] iArr2 = new int[Scene.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Scene.WEB_MAIN_DOCUMENT.ordinal()] = 1;
            iArr2[Scene.WEB_CHILD_RESOURCE.ordinal()] = 2;
            iArr2[Scene.LYNX_FONT.ordinal()] = 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PreLoader getPreLoader() {
        return (PreLoader) this.preLoader.getValue();
    }

    @JvmStatic
    public static final void setCDNCacheDiskMaxAge(int i) {
        INSTANCE.setCDNCacheDiskMaxAge(i);
    }

    @JvmStatic
    public static final void sweepCDNDiskCachedFiles() {
        INSTANCE.sweepCDNDiskCachedFiles();
    }

    public final boolean isPreloaded(String str) {
        return isPreloaded$default(this, str, null, 2, null);
    }

    public final void preload(PreloadConfig preloadConfig) {
        preload$default(this, preloadConfig, null, null, 6, null);
    }

    public final void preload(PreloadConfig preloadConfig, String str) {
        preload$default(this, preloadConfig, str, null, 4, null);
    }

    public final void preload(String str, RequestParams requestParams) {
        preload$default(this, str, requestParams, false, null, null, 28, null);
    }

    public final void preload(String str, RequestParams requestParams, JSONObject jSONObject) {
        preload$default(this, str, requestParams, jSONObject, null, 8, null);
    }

    public final void preload(String str, RequestParams requestParams, boolean z) {
        preload$default(this, str, requestParams, z, null, null, 24, null);
    }

    public final void preload(String str, RequestParams requestParams, boolean z, String str2) {
        preload$default(this, str, requestParams, z, str2, null, 16, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType) {
        preload$default(this, str, jSONObject, preloadType, null, null, null, null, null, 0, null, 1016, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor<?> forestPostProcessor) {
        preload$default(this, str, jSONObject, preloadType, forestPostProcessor, null, null, null, null, 0, null, 1008, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor<?> forestPostProcessor, String str2) {
        preload$default(this, str, jSONObject, preloadType, forestPostProcessor, str2, null, null, null, 0, null, 992, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor<?> forestPostProcessor, String str2, String str3) {
        preload$default(this, str, jSONObject, preloadType, forestPostProcessor, str2, str3, null, null, 0, null, 960, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor<?> forestPostProcessor, String str2, String str3, String str4) {
        preload$default(this, str, jSONObject, preloadType, forestPostProcessor, str2, str3, str4, null, 0, null, 896, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor<?> forestPostProcessor, String str2, String str3, String str4, String str5) {
        preload$default(this, str, jSONObject, preloadType, forestPostProcessor, str2, str3, str4, str5, 0, null, 768, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor<?> forestPostProcessor, String str2, String str3, String str4, String str5, int i) {
        preload$default(this, str, jSONObject, preloadType, forestPostProcessor, str2, str3, str4, str5, i, null, 512, null);
    }

    public Forest(Application application, ForestConfig forestConfig) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(forestConfig, "config");
        this.application = application;
        this.config = forestConfig;
        this.geckoXAdapter = new GeckoXAdapter(application, this);
        this.memoryManager = new MemoryManager(forestConfig.getMaxNormalMemorySize(), forestConfig.getMaxPreloadMemorySize());
        this.preLoader = LazyKt.lazy(new Function0<PreLoader>() { // from class: com.bytedance.forest.Forest$preLoader$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PreLoader m461invoke() {
                return new PreLoader(Forest.this);
            }
        });
        app = application;
        CopyOnWriteArrayList<WeakReference<Forest>> copyOnWriteArrayList = instanceRefs;
        if (copyOnWriteArrayList.isEmpty()) {
            OfflineUtil.INSTANCE.cleanGkFS$forest_release(application);
        }
        copyOnWriteArrayList.add(new WeakReference<>(this));
        this.sessionManager = new SessionManager(application);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final ForestConfig getConfig() {
        return this.config;
    }

    public final GeckoXAdapter getGeckoXAdapter() {
        return this.geckoXAdapter;
    }

    /* renamed from: getMemoryManager$forest_release, reason: from getter */
    public final MemoryManager getMemoryManager() {
        return this.memoryManager;
    }

    /* compiled from: Forest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0007J\u001c\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0006\u0010)\u001a\u00020\"J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\nH\u0007J\u000e\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u0010J\b\u0010.\u001a\u00020\"H\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/bytedance/forest/Forest$Companion;", "", "()V", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "cdnCacheDiskMaxAge", "", "getCdnCacheDiskMaxAge$forest_release", "()I", "setCdnCacheDiskMaxAge$forest_release", "(I)V", "enableKEVAOpt", "", "getEnableKEVAOpt$forest_release", "()Z", "setEnableKEVAOpt$forest_release", "(Z)V", "envData", "Lcom/bytedance/forest/model/ForestEnvData;", "getEnvData$forest_release", "()Lcom/bytedance/forest/model/ForestEnvData;", "setEnvData$forest_release", "(Lcom/bytedance/forest/model/ForestEnvData;)V", "instanceRefs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/forest/Forest;", "getInstanceRefs", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "injectEnv", "", ReportConst.JSBConfigParam.ENV, "isPreloaded", "url", "", "params", "Lcom/bytedance/forest/model/RequestParams;", "onLowMemory", "setCDNCacheDiskMaxAge", "maxAgeInDay", "setKEVAOptimize", "enable", "sweepCDNDiskCachedFiles", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        @Deprecated(message = "Using instance scope check instead of global scope", replaceWith = @ReplaceWith(expression = "forest.isPreloaded(url)", imports = {}))
        public final boolean isPreloaded(String str) {
            return isPreloaded$default(this, str, null, 2, null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Application getApp() {
            Application application = Forest.app;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException("app");
            }
            return application;
        }

        public final void setApp(Application application) {
            Intrinsics.checkParameterIsNotNull(application, "<set-?>");
            Forest.app = application;
        }

        public final ForestEnvData getEnvData$forest_release() {
            return Forest.envData;
        }

        public final void setEnvData$forest_release(ForestEnvData forestEnvData) {
            Forest.envData = forestEnvData;
        }

        public final void injectEnv(ForestEnvData env) {
            setEnvData$forest_release(env);
        }

        public static /* synthetic */ boolean isPreloaded$default(Companion companion, String str, RequestParams requestParams, int i, Object obj) {
            if ((i & 2) != 0) {
                requestParams = null;
            }
            return companion.isPreloaded(str, requestParams);
        }

        @Deprecated(message = "Using instance scope check instead of global scope", replaceWith = @ReplaceWith(expression = "forest.isPreloaded(url)", imports = {}))
        public final boolean isPreloaded(String url, RequestParams params) {
            Object obj;
            List split$default;
            Intrinsics.checkParameterIsNotNull(url, "url");
            CacheIdentifier.Companion companion = CacheIdentifier.INSTANCE;
            if (params == null) {
                Set<String> set = null;
                params = new RequestParams(null, 1, null);
                try {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(Uri.parse(url));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                Uri uri = (Uri) obj;
                if (uri != null) {
                    String safeGetQueryParameter = UriParserKt.safeGetQueryParameter(uri, "forest_key_include");
                    if (safeGetQueryParameter != null && (split$default = StringsKt.split$default(safeGetQueryParameter, new String[]{","}, false, 0, 6, (Object) null)) != null) {
                        if (!(true ^ split$default.isEmpty())) {
                            split$default = null;
                        }
                        if (split$default != null) {
                            set = CollectionsKt.toSet(split$default);
                        }
                    }
                    params.setCacheKeySensitiveQueries(set);
                    params.setCacheKeyUASensitive(Intrinsics.areEqual(uri.getQueryParameter("forest_key_ua_include"), "1"));
                }
            }
            CacheIdentifier obtain$default = CacheIdentifier.Companion.obtain$default(companion, url, params, (Forest) null, 4, (Object) null);
            if (obtain$default != null) {
                return PreLoader.INSTANCE.isPreloaded(obtain$default);
            }
            return false;
        }

        public final CopyOnWriteArrayList<WeakReference<Forest>> getInstanceRefs() {
            return Forest.instanceRefs;
        }

        public final void onLowMemory() {
            Iterator<T> it = getInstanceRefs().iterator();
            while (it.hasNext()) {
                Forest forest = (Forest) ((WeakReference) it.next()).get();
                if (forest != null) {
                    forest.onLowMemory();
                }
            }
        }

        @JvmStatic
        public final void sweepCDNDiskCachedFiles() {
            TTNetDepender.INSTANCE.sweepCDNCache$forest_release();
        }

        public final int getCdnCacheDiskMaxAge$forest_release() {
            return Forest.cdnCacheDiskMaxAge;
        }

        public final void setCdnCacheDiskMaxAge$forest_release(int i) {
            Forest.cdnCacheDiskMaxAge = i;
        }

        @JvmStatic
        public final void setCDNCacheDiskMaxAge(int maxAgeInDay) {
            setCdnCacheDiskMaxAge$forest_release(maxAgeInDay);
        }

        public final boolean getEnableKEVAOpt$forest_release() {
            return Forest.enableKEVAOpt;
        }

        public final void setEnableKEVAOpt$forest_release(boolean z) {
            Forest.enableKEVAOpt = z;
        }

        public final void setKEVAOptimize(boolean enable) {
            setEnableKEVAOpt$forest_release(enable);
        }
    }

    public static /* synthetic */ boolean isPreloaded$default(Forest forest, String str, RequestParams requestParams, int i, Object obj) {
        if ((i & 2) != 0) {
            requestParams = null;
        }
        return forest.isPreloaded(str, requestParams);
    }

    public final boolean isPreloaded(String url, RequestParams params) {
        Object obj;
        List split$default;
        Intrinsics.checkParameterIsNotNull(url, "url");
        CacheIdentifier.Companion companion = CacheIdentifier.INSTANCE;
        if (params == null) {
            Set<String> set = null;
            params = new RequestParams(null, 1, null);
            try {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(Uri.parse(url));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Uri uri = (Uri) obj;
            if (uri != null) {
                String safeGetQueryParameter = UriParserKt.safeGetQueryParameter(uri, "forest_key_include");
                if (safeGetQueryParameter != null && (split$default = StringsKt.split$default(safeGetQueryParameter, new String[]{","}, false, 0, 6, (Object) null)) != null) {
                    if (!(true ^ split$default.isEmpty())) {
                        split$default = null;
                    }
                    if (split$default != null) {
                        set = CollectionsKt.toSet(split$default);
                    }
                }
                params.setCacheKeySensitiveQueries(set);
                params.setCacheKeyUASensitive(Intrinsics.areEqual(uri.getQueryParameter("forest_key_ua_include"), "1"));
            }
        }
        CacheIdentifier obtain = companion.obtain(url, params, this);
        if (obtain != null) {
            return getPreLoader().isPreloaded$forest_release(obtain);
        }
        return false;
    }

    private final boolean checkRequestValid(String url, RequestParams params) {
        if (LoaderUtils.INSTANCE.isNotNullOrEmpty(params.getChannel()) && LoaderUtils.INSTANCE.isNotNullOrEmpty(params.getBundle())) {
            return true;
        }
        List<String> prefixList = params.getPrefixList();
        if (!(prefixList == null || prefixList.isEmpty())) {
            return true;
        }
        if (!StringsKt.isBlank(url)) {
            Uri parse = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
            if (parse.isHierarchical()) {
                return true;
            }
        }
        return false;
    }

    public final void onLowMemory() {
        this.memoryManager.clearAllCache();
    }

    public final <T> RequestOperation fetchAsyncWithProcessor(String url, PostProcessParams<T> params, final Function1<? super ProcessedResponse<T>, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        return fetchResourceAsync(url, params, new Function1<Response, Unit>() { // from class: com.bytedance.forest.Forest$fetchAsyncWithProcessor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response) {
                Intrinsics.checkParameterIsNotNull(response, "resp");
                ProcessedResponse processedResponse = (ProcessedResponse) (!(response instanceof ProcessedResponse) ? null : response);
                if (processedResponse == null) {
                    processedResponse = new ProcessedResponse(response, null);
                    processedResponse.getErrorInfo().setError(ErrorInfo.Type.PostProcess, 2, "Can not cast from " + response.getClass() + " to " + processedResponse.getClass());
                }
                callback.invoke(processedResponse);
            }
        });
    }

    public final RequestOperation fetchResourceAsync(final String url, final RequestParams params, final Function1<? super Response, Unit> callback) {
        Forest forest;
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestLogger forestLogger = null;
        final ForestPipelineContext forestPipelineContext = new ForestPipelineContext(this.application, forestLogger, 2, forestLogger);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.RES_LOAD_START, "res_load_internal_start"}, null, 2, null);
        ForestLogger logger = forestPipelineContext.getLogger();
        Object obj = params.getCustomParams().get("rl_container_uuid");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            str = params.getGroupId();
        }
        logger.setContainerId(str);
        forestPipelineContext.getLogger().setReport(this.config.getALog());
        forestPipelineContext.getLogger().setRequestUrl(url);
        ForestLogger.print$default(forestPipelineContext.getLogger(), 4, "fetchResourceAsync", "resource async load start.", true, null, Timing.RES_LOAD_START, 16, null);
        if (!checkRequestValid(url, params)) {
            String str2 = url + " is invalid and no channel/bundle/prefix in params";
            ForestLogger.print$default(forestPipelineContext.getLogger(), 6, null, str2, false, null, null, 58, null);
            Response response = new Response(new Request(url, this, params.getCustomParams(), null, false, false, false, false, false, false, false, false, false, false, 0, null, false, null, false, false, false, null, false, false, false, null, null, false, false, 0, false, null, null, false, false, null, -8, 15, null), false, null, null, null, null, false, false, false, 0L, null, forestPipelineContext.getLogger(), 2046, null);
            response.getErrorInfo().setPipelineError(str2);
            callback.invoke(response);
            return null;
        }
        if (params.getIsPreload()) {
            forest = this;
        } else {
            forest = this;
            final CacheIdentifier obtain = CacheIdentifier.INSTANCE.obtain(url, params, forest);
            ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchResourceAsync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "prepare to reuse request in fetchResourceAsync, key:" + CacheIdentifier.this;
                }
            }, 24, null);
            if (params.getEnableRequestReuse() || getPreLoader().isPreloaded$forest_release(obtain)) {
                params.setEnableRequestReuse(true);
                final RequestOperation requestOperation = new RequestOperation(params, url, this, null, Status.FETCHING);
                getPreLoader().fetchCache$forest_release(obtain, params.getIgnoreWaitReusedRequest(), forestPipelineContext.getLogger(), forest.memoryManager, new Function1<PreloadResult, Unit>() { // from class: com.bytedance.forest.Forest$fetchResourceAsync$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((PreloadResult) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PreloadResult preloadResult) {
                        boolean checkRequestReuseValid;
                        RequestOperation fetchAsyncInner;
                        final Response reuseResponse;
                        final Response response2 = preloadResult != null ? preloadResult.getResponse() : null;
                        checkRequestReuseValid = Forest.this.checkRequestReuseValid(response2, params, forestPipelineContext);
                        if (checkRequestReuseValid) {
                            Forest forest2 = Forest.this;
                            if (response2 == null) {
                                Intrinsics.throwNpe();
                            }
                            reuseResponse = forest2.reuseResponse(response2, preloadResult.isWait(), params, forestPipelineContext);
                            ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, "res_load_internal_finish", new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchResourceAsync$2.1
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "request reused in fetchResourceAsync, reused:" + Response.this;
                                }
                            }, 8, null);
                            ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, "res_load_internal_finish", new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchResourceAsync$2.2
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "request reused in fetchResourceAsync, origin:" + Response.this;
                                }
                            }, 8, null);
                            ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{"res_load_internal_finish"}, null, 2, null);
                            Forest.this.triggerCallback(forestPipelineContext, callback, reuseResponse);
                            GlobalInterceptor.INSTANCE.onFetchFinished$forest_release(reuseResponse, forestPipelineContext);
                            forestPipelineContext.getReporter().reportFetchResult$forest_release(reuseResponse);
                            return;
                        }
                        ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, LogReportNode.PRELOAD_REQUEST_REUSED_FAILED, new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchResourceAsync$2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                StringBuilder append = new StringBuilder("request reused failed in fetchResourceAsync, originResp:").append(response2).append(", required processor=");
                                RequestParams requestParams = params;
                                if (!(requestParams instanceof PostProcessParams)) {
                                    requestParams = null;
                                }
                                PostProcessParams postProcessParams = (PostProcessParams) requestParams;
                                return append.append(postProcessParams != null ? postProcessParams.getProcessor$forest_release() : null).toString();
                            }
                        }, 8, null);
                        fetchAsyncInner = Forest.this.fetchAsyncInner(url, params, forestPipelineContext, new Function1<Response, Unit>() { // from class: com.bytedance.forest.Forest$fetchResourceAsync$2.4
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Response) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Response response3) {
                                Intrinsics.checkParameterIsNotNull(response3, "newResp");
                                requestOperation.setStatus(Status.FINISHED);
                                callback.invoke(response3);
                            }
                        });
                        requestOperation.setChain$forest_release(fetchAsyncInner.getChain());
                    }
                });
                return requestOperation;
            }
        }
        return forest.fetchAsyncInner(url, params, forestPipelineContext, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response reuseResponse(Response originResponse, boolean waited, RequestParams params, ForestPipelineContext context) {
        ProcessedResponse response;
        InMemoryBuffer inMemoryBuffer$forest_release;
        WebResourceResponse webResourceResponse;
        Object obj;
        ProcessedResponse processedResponse;
        if (params instanceof PostProcessParams) {
            if (originResponse instanceof ProcessedResponse) {
                processedResponse = new ProcessedResponse((ProcessedResponse) originResponse);
            } else {
                Request request = originResponse.getRequest();
                ForestPostProcessor processor$forest_release = ((PostProcessParams) params).getProcessor$forest_release();
                if (processor$forest_release != null) {
                    processedResponse = new ProcessedResponse(originResponse, new PostProcessRequest(request, processor$forest_release), null);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.ForestPostProcessor<kotlin.Any>");
                }
            }
            response = processedResponse;
        } else {
            response = new Response(originResponse, context.getLogger());
        }
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"req_reuse_start"}, null, 2, null);
        response.setRequestReused(true);
        response.setDataType$forest_release(originResponse.getDataType());
        response.setCharset$forest_release(originResponse.getCharset());
        response.setImageReference$forest_release(originResponse.getImageReference$forest_release());
        response.setHttpResponse(originResponse.getHttpResponse());
        response.setHttpHeader(originResponse.getHttpHeader());
        response.setRedirection(originResponse.getIsRedirection());
        response.setNegotiation(originResponse.getIsNegotiation());
        response.setUseGkFS(originResponse.getUseGkFS());
        response.getErrorInfo().copyFrom(originResponse.getErrorInfo(), new ErrorInfo.Type[0]);
        response.getRequest().setPreload(false);
        response.getRequest().setEnableRequestReuse(true);
        response.getRequest().setScene(params.getResourceScene());
        response.getRequest().setGroupId(params.getGroupId());
        response.getRequest().setCustomParams(params.getCustomParams());
        if (response.getRequest().getScene() == Scene.LYNX_IMAGE && response.getImage() != null) {
            response.setPreloaded(true);
        }
        MemoryCacheItem cache = response.getRequest().getForest().memoryManager.getCache(response.getRequest().getCacheKey$forest_release(), response.getRequest().getEnableRequestReuse());
        if (cache == null || (inMemoryBuffer$forest_release = cache.getBuffer()) == null) {
            inMemoryBuffer$forest_release = originResponse.getInMemoryBuffer$forest_release();
        }
        if (inMemoryBuffer$forest_release != null) {
            inMemoryBuffer$forest_release.setContext$forest_release(context);
            if (!inMemoryBuffer$forest_release.isCacheReady$forest_release() && response.getRequest().getLoadToMemory()) {
                try {
                    Result.Companion companion = Result.Companion;
                    inMemoryBuffer$forest_release.tryLoadToMemory$forest_release(response);
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    response.getErrorInfo().setError(ErrorInfo.Type.Pipeline, 4, th2 + " occurred, " + th2.getMessage());
                }
            } else if (!waited) {
                response.setPreloaded(true);
            }
            response.setInMemoryBuffer$forest_release(inMemoryBuffer$forest_release);
        }
        if (originResponse.getWebResourceResponseFromTTNet() != null) {
            OfflineUtil offlineUtil = OfflineUtil.INSTANCE;
            String dataType = response.getDataType();
            String charset = response.getCharset();
            InMemoryBuffer inMemoryBuffer$forest_release2 = response.getInMemoryBuffer$forest_release();
            InputStream provideInputStream = inMemoryBuffer$forest_release2 != null ? inMemoryBuffer$forest_release2.provideInputStream(response) : null;
            String url = response.getRequest().getUrl();
            ForestNetAPI.HttpResponse httpResponse = response.getHttpResponse();
            webResourceResponse = offlineUtil.generateWebResourceResponse(dataType, charset, provideInputStream, url, httpResponse != null ? httpResponse.getResponseHttpHeader() : null);
        } else {
            webResourceResponse = null;
        }
        response.setWebResourceResponseFromTTNet(webResourceResponse);
        if (!waited && response.getIsPreloaded() && response.getFrom() != ResourceFrom.MEMORY) {
            response.setOriginFrom(originResponse.getFrom());
            response.setFrom(ResourceFrom.MEMORY);
        }
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"req_reuse_finish"}, null, 2, null);
        return response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestOperation fetchAsyncInner(String url, RequestParams params, final ForestPipelineContext context, final Function1<? super Response, Unit> callback) {
        GlobalInterceptor.INSTANCE.onFetchStart$forest_release(url, params);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{Timing.INIT_START, Timing.REQ_BUILD_START}, null, 2, null);
        Request buildRequest = RequestFactory.INSTANCE.buildRequest(url, this, params, true, context);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{Timing.REQ_BUILD_FINISH}, null, 2, null);
        GlobalInterceptor.INSTANCE.onRequestCreated$forest_release(buildRequest);
        ProcessedResponse response = new Response(buildRequest, false, null, null, null, null, false, false, false, 0L, null, context.getLogger(), 2046, null);
        if (buildRequest instanceof PostProcessRequest) {
            response = new ProcessedResponse(response, (PostProcessRequest) buildRequest, null);
        }
        ForestLogger.print$default(context.getLogger(), 3, "fetchResourceAsync", "start request", true, null, Timing.REQ_BUILD_FINISH, 16, null);
        ResourceFetcherChain createFetcherChain$forest_release = ResourceFetchScheduler.INSTANCE.createFetcherChain$forest_release(buildRequest, response, new ResourceProcessChain(buildRequest, context), context);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"init_finish"}, null, 2, null);
        final RequestOperation requestOperation = new RequestOperation(params, url, this, createFetcherChain$forest_release, Status.FETCHING);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"res_pipeline_start"}, null, 2, null);
        createFetcherChain$forest_release.fetch$forest_release(new Function1<Response, Unit>() { // from class: com.bytedance.forest.Forest$fetchAsyncInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response2) {
                Intrinsics.checkParameterIsNotNull(response2, "it");
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"res_load_internal_finish", "res_pipeline_finish"}, null, 2, null);
                requestOperation.setStatus(Status.FINISHED);
                Forest.this.finishWithCallback(response2, context, callback);
            }
        });
        return requestOperation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finishWithCallback(final Response response, ForestPipelineContext context, Function1<? super Response, Unit> callback) {
        ForestLogger.printOptimize$default(context.getLogger(), 4, "fetchResourceAsync", true, null, "res_load_internal_finish", new Function0<String>() { // from class: com.bytedance.forest.Forest$finishWithCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                return "response:" + Response.this;
            }
        }, 8, null);
        Set<Map.Entry<String, String>> entrySet = context.getCdnHeadersInfo$forest_release().entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "context.cdnHeadersInfo.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map<String, Object> customParams = response.getRequest().getCustomParams();
            Object key = entry.getKey();
            Intrinsics.checkExpressionValueIsNotNull(key, "entry.key");
            Object value = entry.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "entry.value");
            customParams.put(key, value);
        }
        triggerCallback(context, callback, response);
        GlobalInterceptor.INSTANCE.onFetchFinished$forest_release(response, context);
        context.getReporter().reportFetchResult$forest_release(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerCallback(final ForestPipelineContext context, final Function1<? super Response, Unit> callback, final Response response) {
        if (context.getCallFromMainThread()) {
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"res_callback_switch_thread_start"}, null, 2, null);
            ThreadUtils.INSTANCE.runInUI(new Runnable() { // from class: com.bytedance.forest.Forest$triggerCallback$1
                @Override // java.lang.Runnable
                public final void run() {
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(ForestPipelineContext.this, new String[]{"res_callback_switch_thread_finish", Timing.RES_LOAD_FINISH, "callback_execute_start"}, null, 2, null);
                    callback.invoke(response);
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(ForestPipelineContext.this, new String[]{"callback_execute_finish"}, null, 2, null);
                }
            });
        } else {
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{Timing.RES_LOAD_FINISH, "callback_execute_start"}, null, 2, null);
            callback.invoke(response);
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"callback_execute_finish"}, null, 2, null);
        }
    }

    public final RequestOperation createSyncRequest(String url, RequestParams params) {
        PostProcessOperation createSyncRequestWithProcessor;
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        LogUtils.d$default(LogUtils.INSTANCE, "createSyncRequest", "url:" + url + " params:" + params, false, null, null, null, 60, null);
        if (!checkRequestValid(url, params)) {
            LogUtils.e$default(LogUtils.INSTANCE, null, "url is blank or no channel/bundle/prefix in params", null, 5, null);
            return null;
        }
        PostProcessParams postProcessParams = (PostProcessParams) (params instanceof PostProcessParams ? params : null);
        return (postProcessParams == null || (createSyncRequestWithProcessor = createSyncRequestWithProcessor(url, postProcessParams)) == null) ? new RequestOperation(params, url, this, null, null, 24, null) : createSyncRequestWithProcessor;
    }

    public final <T> PostProcessOperation<T> createSyncRequestWithProcessor(String url, PostProcessParams<T> params) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        LogUtils.d$default(LogUtils.INSTANCE, "createSyncRequestWithProcessor", "url:" + url + " params:" + params, false, null, null, null, 60, null);
        if (!checkRequestValid(url, params)) {
            LogUtils.e$default(LogUtils.INSTANCE, null, url + " is invalid and no channel/bundle/prefix in params", null, 5, null);
            return null;
        }
        return new PostProcessOperation<>(params, url, this, null, null, 24, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Response fetchSync$forest_release(RequestOperation operation) {
        final Response response;
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        final RequestParams requestParams = operation.getRequestParams();
        ForestLogger forestLogger = null;
        final ForestPipelineContext forestPipelineContext = new ForestPipelineContext(this.application, forestLogger, 2, forestLogger);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.RES_LOAD_START, "res_load_internal_start"}, null, 2, null);
        ForestLogger logger = forestPipelineContext.getLogger();
        Object obj = requestParams.getCustomParams().get("rl_container_uuid");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            str = requestParams.getGroupId();
        }
        logger.setContainerId(str);
        forestPipelineContext.getLogger().setReport(this.config.getALog());
        forestPipelineContext.getLogger().setRequestUrl(operation.getUrl());
        ForestLogger.print$default(forestPipelineContext.getLogger(), 4, "fetchSync", "resource sync load start.", true, null, Timing.RES_LOAD_START, 16, null);
        if (!requestParams.getIsPreload()) {
            final CacheIdentifier obtain = CacheIdentifier.INSTANCE.obtain(operation.getUrl(), operation.getRequestParams(), this);
            ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchSync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public final String invoke() {
                    return "prepare to reuse request in fetchSync, key:" + CacheIdentifier.this;
                }
            }, 24, null);
            if (requestParams.getEnableRequestReuse() || getPreLoader().isPreloaded$forest_release(obtain)) {
                requestParams.setEnableRequestReuse(true);
                final PreloadResult fetchCacheSync$forest_release = getPreLoader().fetchCacheSync$forest_release(obtain, requestParams.getIgnoreWaitReusedRequest(), forestPipelineContext.getLogger(), this.memoryManager);
                if (fetchCacheSync$forest_release != null && (response = fetchCacheSync$forest_release.getResponse()) != null) {
                    if (!checkRequestReuseValid(response, requestParams, forestPipelineContext)) {
                        response = null;
                    }
                    if (response != null) {
                        final Response reuseResponse = reuseResponse(response, fetchCacheSync$forest_release.isWait(), requestParams, forestPipelineContext);
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.RES_LOAD_FINISH}, null, 2, null);
                        ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, Timing.RES_LOAD_FINISH, new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchSync$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "request reused in fetchSync, reused:" + Response.this;
                            }
                        }, 8, null);
                        ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "preload", true, null, Timing.RES_LOAD_FINISH, new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchSync$3$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "request reused in fetchSync, origin:" + Response.this;
                            }
                        }, 8, null);
                        GlobalInterceptor.INSTANCE.onFetchFinished$forest_release(reuseResponse, forestPipelineContext);
                        forestPipelineContext.getReporter().reportFetchResult$forest_release(reuseResponse);
                        return reuseResponse;
                    }
                }
                ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "fetchSync", true, null, LogReportNode.PRELOAD_REQUEST_REUSED_FAILED, new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchSync$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        StringBuilder sb = new StringBuilder("request reused failed, resp:");
                        PreloadResult preloadResult = PreloadResult.this;
                        StringBuilder append = sb.append(preloadResult != null ? preloadResult.getResponse() : null).append(", required processor=");
                        RequestParams requestParams2 = requestParams;
                        if (!(requestParams2 instanceof PostProcessParams)) {
                            requestParams2 = null;
                        }
                        PostProcessParams postProcessParams = (PostProcessParams) requestParams2;
                        return append.append(postProcessParams != null ? postProcessParams.getProcessor$forest_release() : null).toString();
                    }
                }, 8, null);
            }
        }
        GlobalInterceptor.INSTANCE.onFetchStart$forest_release(operation.getUrl(), operation.getRequestParams());
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.INIT_START, Timing.REQ_BUILD_START}, null, 2, null);
        Request buildRequest = RequestFactory.INSTANCE.buildRequest(operation.getUrl(), this, operation.getRequestParams(), false, forestPipelineContext);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{Timing.REQ_BUILD_FINISH}, null, 2, null);
        GlobalInterceptor.INSTANCE.onRequestCreated$forest_release(buildRequest);
        ForestLogger.print$default(forestPipelineContext.getLogger(), 4, "fetchSync", "start request", true, null, Timing.REQ_BUILD_FINISH, 16, null);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ProcessedResponse response2 = new Response(buildRequest, false, null, null, null, null, false, false, false, 0L, null, forestPipelineContext.getLogger(), 2046, null);
        if (buildRequest instanceof PostProcessRequest) {
            response2 = new ProcessedResponse(response2, (PostProcessRequest) buildRequest, null);
        }
        objectRef.element = response2;
        ResourceFetcherChain createFetcherChain$forest_release = ResourceFetchScheduler.INSTANCE.createFetcherChain$forest_release(buildRequest, (Response) objectRef.element, new ResourceProcessChain(buildRequest, forestPipelineContext), forestPipelineContext);
        operation.setChain$forest_release(createFetcherChain$forest_release);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, new String[]{"init_finish"}, null, 2, null);
        createFetcherChain$forest_release.fetch$forest_release(new Function1<Response, Unit>() { // from class: com.bytedance.forest.Forest$fetchSync$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Response) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response3) {
                Intrinsics.checkParameterIsNotNull(response3, "it");
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(ForestPipelineContext.this, new String[]{"res_load_internal_finish", Timing.RES_LOAD_FINISH}, null, 2, null);
                objectRef.element = response3;
            }
        });
        operation.setStatus(Status.FINISHED);
        ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 4, "fetchSync", true, null, "res_load_internal_finish", new Function0<String>() { // from class: com.bytedance.forest.Forest$fetchSync$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final String invoke() {
                return "response:" + ((Response) objectRef.element);
            }
        }, 8, null);
        Set<Map.Entry<String, String>> entrySet = forestPipelineContext.getCdnHeadersInfo$forest_release().entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "context.cdnHeadersInfo.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map<String, Object> customParams = ((Response) objectRef.element).getRequest().getCustomParams();
            Object key = entry.getKey();
            Intrinsics.checkExpressionValueIsNotNull(key, "entry.key");
            Object value = entry.getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "entry.value");
            customParams.put(key, value);
        }
        forestPipelineContext.getReporter().reportFetchResult$forest_release((Response) objectRef.element);
        GlobalInterceptor.INSTANCE.onFetchFinished$forest_release((Response) objectRef.element, forestPipelineContext);
        return (Response) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
    
        if (r4.isFile() == true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006f, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
    
        if (r12.getInMemoryBuffer$forest_release() != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0067, code lost:
    
        if (r4.isFile() == true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x006d, code lost:
    
        if (r12.getInMemoryBuffer$forest_release() == null) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkRequestReuseValid(Response preload, RequestParams params, ForestPipelineContext context) {
        File file;
        ResourceFrom resourceFrom;
        boolean z;
        if (preload == null || !preload.getIsSucceed()) {
            return false;
        }
        if (preload.getRequest().getScene() == Scene.LYNX_IMAGE && preload.getImage() != null) {
            return true;
        }
        String filePath = preload.getFilePath();
        if (filePath != null) {
            if (!LoaderUtils.INSTANCE.isNotNullOrEmpty(filePath)) {
                filePath = null;
            }
            if (filePath != null) {
                file = new File(filePath);
                ResourceFrom from = preload.getFrom();
                resourceFrom = from == ResourceFrom.MEMORY ? from : null;
                if (resourceFrom == null) {
                    resourceFrom = preload.getOriginFrom();
                }
                if (resourceFrom != null) {
                    int i = WhenMappings.$EnumSwitchMapping$0[resourceFrom.ordinal()];
                    if (i == 1) {
                        if (file != null) {
                            z = file.isFile();
                        }
                        z = false;
                    } else if (i == 2) {
                        if (MemoryFetcher.INSTANCE.checkExpired(preload.getRequest().getOriginUrl(), preload.getAssembleHttpResponseIf304$forest_release(), file, context, preload.getRequest().getCustomHttpMaxAge())) {
                            preload.getRequest().getForest().memoryManager.removeCache(preload.getRequest().getCacheKey$forest_release());
                        } else if (file != null) {
                        }
                        z = false;
                    } else if (i == 3) {
                        z = LoaderUtils.INSTANCE.isNotNullOrEmpty(preload.getFilePath());
                    }
                    if (!z) {
                        return false;
                    }
                    if ((preload instanceof ProcessedResponse) && ((ProcessedResponse) preload).getIsProcessSucceed()) {
                        if (!(params instanceof PostProcessParams)) {
                            return false;
                        }
                        if (preload.getRequest() == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.PostProcessRequest<*>");
                        }
                        if (!Intrinsics.areEqual(((PostProcessRequest) r12).getPostProcessor$forest_release().getClass(), ((PostProcessParams) params).getProcessor$forest_release().getClass())) {
                            return false;
                        }
                    }
                    return true;
                }
                if (file != null) {
                }
            }
        }
        file = null;
        ResourceFrom from2 = preload.getFrom();
        if (from2 == ResourceFrom.MEMORY) {
        }
        if (resourceFrom == null) {
        }
        if (resourceFrom != null) {
        }
        if (file != null) {
        }
    }

    public final <T> ProcessedResponse<T> fetchSyncWithProcessor$forest_release(PostProcessOperation<T> operation) {
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        Response fetchSync$forest_release = fetchSync$forest_release(operation);
        ProcessedResponse<T> processedResponse = (ProcessedResponse) (!(fetchSync$forest_release instanceof ProcessedResponse) ? null : fetchSync$forest_release);
        if (processedResponse != null) {
            return processedResponse;
        }
        ProcessedResponse<T> processedResponse2 = new ProcessedResponse<>(fetchSync$forest_release, null);
        processedResponse2.getErrorInfo().setError(ErrorInfo.Type.PostProcess, 2, "Can not cast from " + fetchSync$forest_release.getClass() + " to " + processedResponse2.getClass());
        return processedResponse2;
    }

    /* renamed from: getSessionManager$forest_release, reason: from getter */
    public final SessionManager getSessionManager() {
        return this.sessionManager;
    }

    public static /* synthetic */ String openSession$default(Forest forest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return forest.openSession(str);
    }

    public final String openSession(String sessionId) {
        return this.sessionManager.openSession(sessionId);
    }

    public final void closeSession(String sessionId) {
        Intrinsics.checkParameterIsNotNull(sessionId, "sessionId");
        this.sessionManager.closeSession(sessionId);
    }

    public static /* synthetic */ void preload$default(Forest forest, PreloadConfig preloadConfig, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        forest.preload(preloadConfig, str, str2);
    }

    public final void preload(final PreloadConfig config, final String containerId, final String sessionId) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        ThreadUtils.INSTANCE.runInBackgroundIfNeed(new Runnable() { // from class: com.bytedance.forest.Forest$preload$1
            @Override // java.lang.Runnable
            public final void run() {
                PreLoader preLoader;
                preLoader = Forest.this.getPreLoader();
                preLoader.preload$forest_release(config, containerId, sessionId);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void preload$default(Forest forest, String str, RequestParams requestParams, JSONObject jSONObject, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = null;
        }
        forest.preload(str, requestParams, jSONObject, (Function1<? super String, ? extends ForestPostProcessor<?>>) function1);
    }

    public final void preload(final String url, final RequestParams params, JSONObject subRes, Function1<? super String, ? extends ForestPostProcessor<?>> postProcessorBuilder) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        ThreadUtils.INSTANCE.runInBackgroundIfNeed(new Runnable() { // from class: com.bytedance.forest.Forest$preload$2
            @Override // java.lang.Runnable
            public final void run() {
                PreLoader preLoader;
                preLoader = Forest.this.getPreLoader();
                String str = url;
                if (str == null) {
                    str = "";
                }
                preLoader.preload$forest_release(str, params);
            }
        });
        if (subRes == null) {
            return;
        }
        PreloadType preloadType = params.getResourceScene() == Scene.WEB_MAIN_DOCUMENT ? PreloadType.WEB : PreloadType.LYNX;
        subRes.remove("type");
        Uri parse = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
        PreloadConfig preloadConfig = new PreloadConfig((String) null, preloadType, parseSubResourceConfig(subRes, UriParserKt.getEnvParameters(parse), false, NetWorker.TTNet, params.getCustomHttpMaxAge(), postProcessorBuilder));
        preloadConfig.setFrom(params.getPreloadFrom());
        preloadConfig.setInjectUserAgent(params.getInjectedUserAgent());
        preload(preloadConfig, params.getGroupId(), params.getSessionId());
    }

    public static /* synthetic */ void preload$default(Forest forest, String str, JSONObject jSONObject, PreloadType preloadType, ForestPostProcessor forestPostProcessor, String str2, String str3, String str4, String str5, int i, Function1 function1, int i2, Object obj) {
        ForestPostProcessor forestPostProcessor2;
        String str6;
        String str7;
        String str8;
        String str9;
        Function1 function12;
        if ((i2 & 8) != 0) {
            forestPostProcessor2 = null;
        } else {
            forestPostProcessor2 = forestPostProcessor;
        }
        if ((i2 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str2;
        }
        if ((i2 & 32) != 0) {
            str7 = null;
        } else {
            str7 = str3;
        }
        if ((i2 & 64) != 0) {
            str8 = null;
        } else {
            str8 = str4;
        }
        if ((i2 & 128) != 0) {
            str9 = null;
        } else {
            str9 = str5;
        }
        int i3 = (i2 & 256) != 0 ? 0 : i;
        if ((i2 & 512) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        forest.preload(str, jSONObject, preloadType, forestPostProcessor2, str6, str7, str8, str9, i3, function12);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    public final void preload(String url, JSONObject subRes, PreloadType type, ForestPostProcessor<?> processor, String containerId, String sessionId, String from, String userAgent, int maxAge, Function1<? super String, ? extends ForestPostProcessor<?>> postProcessorBuilder) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        String str = url;
        if ((str == null || str.length() == 0) && subRes == null) {
            return;
        }
        if (url == null) {
            Intrinsics.throwNpe();
        }
        ResourceConfig resourceConfig = new ResourceConfig(url, true, null, false, NetWorker.TTNet, processor, 12, null);
        resourceConfig.setMaxAge(maxAge);
        if (subRes != null) {
            subRes.remove("type");
        }
        Uri parse = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(url)");
        PreloadConfig preloadConfig = new PreloadConfig(resourceConfig, type, parseSubResourceConfig(subRes, UriParserKt.getEnvParameters(parse), false, NetWorker.TTNet, maxAge, postProcessorBuilder));
        preloadConfig.setFrom(from);
        preloadConfig.setInjectUserAgent(userAgent);
        preload(preloadConfig, containerId, sessionId);
    }

    static /* synthetic */ Map parseSubResourceConfig$default(Forest forest, JSONObject jSONObject, Map map, boolean z, NetWorker netWorker, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return forest.parseSubResourceConfig(jSONObject, map, z, netWorker, i, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, List<ResourceConfig>> parseSubResourceConfig(JSONObject json, Map<String, String> envParams, boolean disableCdn, NetWorker netWorker, int maxAge, Function1<? super String, ? extends ForestPostProcessor<?>> postProcessorBuilder) {
        Object obj;
        Throwable th;
        Object obj2;
        int i;
        Object obj3;
        Throwable th2;
        int i2;
        StringBuilder sb;
        Object obj4;
        Long valueOf;
        if (json == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = json.keys();
        Intrinsics.checkExpressionValueIsNotNull(keys, "subConfigs.keys()");
        loop0: while (keys.hasNext()) {
            String next = keys.next();
            try {
                Result.Companion companion = Result.Companion;
                obj2 = json.get(next);
            } catch (Throwable th3) {
                th = th3;
            }
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.json.JSONArray");
            }
            JSONArray jSONArray = (JSONArray) obj2;
            ArrayList arrayList = new ArrayList(jSONArray.length());
            Intrinsics.checkExpressionValueIsNotNull(next, "subType");
            linkedHashMap.put(next, arrayList);
            int length = jSONArray.length();
            boolean z = false;
            int i3 = 0;
            while (i3 < length) {
                Object obj5 = jSONArray.get(i3);
                if (obj5 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                }
                JSONObject jSONObject = (JSONObject) obj5;
                try {
                    Result.Companion companion2 = Result.Companion;
                    sb = new StringBuilder();
                    obj4 = jSONObject.get("url");
                } catch (Throwable th4) {
                    th = th4;
                    i = i3;
                }
                if (obj4 == null) {
                    i = i3;
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    break loop0;
                }
                String removeSuffix = StringsKt.removeSuffix(sb.append((String) obj4).append('?').append(CollectionsKt.joinToString$default(envParams.entrySet(), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString(), "?");
                boolean optBoolean = jSONObject.optBoolean(PreloadConfig.SUB_KEY_ENABLE_MEMORY, z);
                i = i3;
                try {
                    valueOf = Long.valueOf((long) jSONObject.optDouble("size", 0.0d));
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    boolean optBoolean2 = jSONObject.optBoolean("disableCdn", disableCdn);
                    String optString = jSONObject.optString("netWorker", netWorker.name());
                    Intrinsics.checkExpressionValueIsNotNull(optString, "item.optString(\"netWorker\", netWorker.name)");
                    ResourceConfig resourceConfig = new ResourceConfig(removeSuffix, optBoolean, valueOf, optBoolean2, NetWorker.valueOf(optString), (ForestPostProcessor<?>) ((!Intrinsics.areEqual(jSONObject.optString("processType", ""), "templateBundle") || postProcessorBuilder == null) ? null : (ForestPostProcessor) postProcessorBuilder.invoke("templateBundle")));
                    try {
                        resourceConfig.setMaxAge(jSONObject.optInt("maxAge", maxAge));
                        obj3 = Result.constructor-impl(Boolean.valueOf(arrayList.add(resourceConfig)));
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    Result.Companion companion3 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    th2 = Result.exceptionOrNull-impl(obj3);
                    if (th2 != null) {
                    }
                    i3 = i2 + 1;
                    z = false;
                }
                th2 = Result.exceptionOrNull-impl(obj3);
                if (th2 != null) {
                    try {
                        i2 = i;
                        LogUtils.d$default(LogUtils.INSTANCE, "PreloadAPI", "Parse " + i2 + " in sub resource config of " + next + " failed, caused by " + th2.getMessage(), true, null, null, null, 56, null);
                    } catch (Throwable th8) {
                        th = th8;
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        th = Result.exceptionOrNull-impl(obj);
                        if (th == null) {
                        }
                    }
                } else {
                    i2 = i;
                }
                i3 = i2 + 1;
                z = false;
                th = th6;
                Result.Companion companion32 = Result.Companion;
                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                th2 = Result.exceptionOrNull-impl(obj3);
                if (th2 != null) {
                }
                i3 = i2 + 1;
                z = false;
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
            th = Result.exceptionOrNull-impl(obj);
            if (th == null) {
                LogUtils.d$default(LogUtils.INSTANCE, "PreloadAPI", "Parse sub resource config of " + next + " failed, caused by " + th.getMessage(), true, null, null, null, 56, null);
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ void preload$default(Forest forest, String str, RequestParams requestParams, boolean z, String str2, String str3, int i, Object obj) {
        String str4;
        String str5;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i & 16) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        forest.preload(str, requestParams, z2, str4, str5);
    }

    public final void preload(String url, RequestParams params, boolean withSubResources, String containerId, String sessionId) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        preload(url, params, withSubResources, containerId, sessionId, (Function1<? super String, ? extends ForestPostProcessor<?>>) null);
    }

    public static /* synthetic */ void preload$default(Forest forest, String str, RequestParams requestParams, boolean z, String str2, String str3, Function1 function1, int i, Object obj) {
        String str4;
        String str5;
        Function1 function12;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str4 = null;
        } else {
            str4 = str2;
        }
        if ((i & 16) != 0) {
            str5 = null;
        } else {
            str5 = str3;
        }
        if ((i & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        forest.preload(str, requestParams, z2, str4, str5, (Function1<? super String, ? extends ForestPostProcessor<?>>) function12);
    }

    public final void preload(final String url, final RequestParams params, final boolean withSubResources, final String containerId, final String sessionId, final Function1<? super String, ? extends ForestPostProcessor<?>> postProcessorBuilder) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(params, "params");
        ThreadUtils.INSTANCE.runInBackgroundIfNeed(new Runnable() { // from class: com.bytedance.forest.Forest$preload$task$1
            /* JADX WARN: Code restructure failed: missing block: B:62:0x01b6, code lost:
            
                r0 = com.bytedance.forest.model.PreloadType.LYNX.name();
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:33:0x011f A[Catch: all -> 0x023c, TRY_ENTER, TryCatch #0 {all -> 0x023c, blocks: (B:24:0x00ee, B:26:0x0107, B:30:0x0117, B:33:0x011f, B:40:0x0162, B:42:0x0168, B:43:0x016b, B:47:0x0184, B:52:0x0199, B:55:0x01a5, B:57:0x01ac, B:62:0x01b6, B:63:0x01c8, B:64:0x01d8, B:67:0x01eb, B:68:0x01e9, B:70:0x01bf, B:71:0x01cd, B:72:0x01d2, B:73:0x01d3, B:74:0x01d6, B:76:0x0212, B:78:0x0232, B:81:0x013d, B:83:0x0150, B:84:0x015a, B:85:0x015f, B:88:0x0160), top: B:23:0x00ee }] */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0168 A[Catch: all -> 0x023c, TryCatch #0 {all -> 0x023c, blocks: (B:24:0x00ee, B:26:0x0107, B:30:0x0117, B:33:0x011f, B:40:0x0162, B:42:0x0168, B:43:0x016b, B:47:0x0184, B:52:0x0199, B:55:0x01a5, B:57:0x01ac, B:62:0x01b6, B:63:0x01c8, B:64:0x01d8, B:67:0x01eb, B:68:0x01e9, B:70:0x01bf, B:71:0x01cd, B:72:0x01d2, B:73:0x01d3, B:74:0x01d6, B:76:0x0212, B:78:0x0232, B:81:0x013d, B:83:0x0150, B:84:0x015a, B:85:0x015f, B:88:0x0160), top: B:23:0x00ee }] */
            /* JADX WARN: Removed duplicated region for block: B:45:0x017f  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0184 A[Catch: all -> 0x023c, TryCatch #0 {all -> 0x023c, blocks: (B:24:0x00ee, B:26:0x0107, B:30:0x0117, B:33:0x011f, B:40:0x0162, B:42:0x0168, B:43:0x016b, B:47:0x0184, B:52:0x0199, B:55:0x01a5, B:57:0x01ac, B:62:0x01b6, B:63:0x01c8, B:64:0x01d8, B:67:0x01eb, B:68:0x01e9, B:70:0x01bf, B:71:0x01cd, B:72:0x01d2, B:73:0x01d3, B:74:0x01d6, B:76:0x0212, B:78:0x0232, B:81:0x013d, B:83:0x0150, B:84:0x015a, B:85:0x015f, B:88:0x0160), top: B:23:0x00ee }] */
            /* JADX WARN: Removed duplicated region for block: B:76:0x0212 A[Catch: all -> 0x023c, TryCatch #0 {all -> 0x023c, blocks: (B:24:0x00ee, B:26:0x0107, B:30:0x0117, B:33:0x011f, B:40:0x0162, B:42:0x0168, B:43:0x016b, B:47:0x0184, B:52:0x0199, B:55:0x01a5, B:57:0x01ac, B:62:0x01b6, B:63:0x01c8, B:64:0x01d8, B:67:0x01eb, B:68:0x01e9, B:70:0x01bf, B:71:0x01cd, B:72:0x01d2, B:73:0x01d3, B:74:0x01d6, B:76:0x0212, B:78:0x0232, B:81:0x013d, B:83:0x0150, B:84:0x015a, B:85:0x015f, B:88:0x0160), top: B:23:0x00ee }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x0232 A[Catch: all -> 0x023c, TRY_LEAVE, TryCatch #0 {all -> 0x023c, blocks: (B:24:0x00ee, B:26:0x0107, B:30:0x0117, B:33:0x011f, B:40:0x0162, B:42:0x0168, B:43:0x016b, B:47:0x0184, B:52:0x0199, B:55:0x01a5, B:57:0x01ac, B:62:0x01b6, B:63:0x01c8, B:64:0x01d8, B:67:0x01eb, B:68:0x01e9, B:70:0x01bf, B:71:0x01cd, B:72:0x01d2, B:73:0x01d3, B:74:0x01d6, B:76:0x0212, B:78:0x0232, B:81:0x013d, B:83:0x0150, B:84:0x015a, B:85:0x015f, B:88:0x0160), top: B:23:0x00ee }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x0181  */
            /* JADX WARN: Removed duplicated region for block: B:88:0x0160 A[Catch: all -> 0x023c, TryCatch #0 {all -> 0x023c, blocks: (B:24:0x00ee, B:26:0x0107, B:30:0x0117, B:33:0x011f, B:40:0x0162, B:42:0x0168, B:43:0x016b, B:47:0x0184, B:52:0x0199, B:55:0x01a5, B:57:0x01ac, B:62:0x01b6, B:63:0x01c8, B:64:0x01d8, B:67:0x01eb, B:68:0x01e9, B:70:0x01bf, B:71:0x01cd, B:72:0x01d2, B:73:0x01d3, B:74:0x01d6, B:76:0x0212, B:78:0x0232, B:81:0x013d, B:83:0x0150, B:84:0x015a, B:85:0x015f, B:88:0x0160), top: B:23:0x00ee }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                PreLoader preLoader;
                Object[] objArr;
                String str;
                byte[] provideBytes;
                JSONObject jSONObject;
                PreloadType preloadType;
                Map parseSubResourceConfig;
                preLoader = Forest.this.getPreLoader();
                String str2 = url;
                RequestParams requestParams = params;
                String str3 = containerId;
                if (str3 == null) {
                    str3 = "";
                }
                requestParams.setGroupId(str3);
                requestParams.setSessionId(sessionId);
                preLoader.preload$forest_release(str2, requestParams);
                PreloadConfig preloadConfig = null;
                ForestPipelineContext forestPipelineContext = new ForestPipelineContext(Forest.this.getApplication(), null, 2, null);
                if (!withSubResources) {
                    ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 3, "PreloadAPI", false, null, null, new Function0<String>() { // from class: com.bytedance.forest.Forest$preload$task$1.2
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "Url:" + url + " not need sub-resources preload, withSubResources=" + withSubResources + ", disableOffline=" + params.getDisableOffline();
                        }
                    }, 28, null);
                    return;
                }
                Request buildRequest = RequestFactory.INSTANCE.buildRequest(url, Forest.this, params, false, forestPipelineContext);
                if (buildRequest.getGeckoModel().isChannelOrBundleBlank()) {
                    ForestLogger.printOptimize$default(forestPipelineContext.getLogger(), 6, "PreloadAPI", false, null, null, new Function0<String>() { // from class: com.bytedance.forest.Forest$preload$task$1.3
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "Can not parse ak/channel/bundle from " + url;
                        }
                    }, 28, null);
                }
                Forest forest = Forest.this;
                RequestParams requestParams2 = new RequestParams(Scene.PRELOAD_CONFIG);
                String str4 = containerId;
                if (str4 == null) {
                    str4 = "";
                }
                requestParams2.setGroupId(str4);
                requestParams2.setSessionId(sessionId);
                requestParams2.getCustomParams().put("rl_container_uuid", requestParams2.getGroupId());
                requestParams2.setChannel(buildRequest.getGeckoModel().getChannel());
                requestParams2.setBundle("preload.json");
                requestParams2.setAccessKey(buildRequest.getGeckoModel().getAccessKey());
                boolean z = true;
                requestParams2.setDisableBuiltin(true);
                requestParams2.setDisableCdn(true);
                requestParams2.setOnlyLocal(true);
                RequestOperation createSyncRequest = forest.createSyncRequest("", requestParams2);
                if (createSyncRequest == null) {
                    ForestLogger.print$default(forestPipelineContext.getLogger(), 6, "PreloadAPI", "Can not build RequestOperation for preload.json", false, null, null, 56, null);
                    return;
                }
                Response execute = createSyncRequest.execute();
                if (execute == null || !execute.getIsSucceed()) {
                    ForestLogger.print$default(forestPipelineContext.getLogger(), 6, "PreloadAPI", "Getting preload.json failed, msg: " + (execute != null ? execute.getErrorInfo() : null), false, null, null, 56, null);
                    return;
                }
                try {
                    Uri parse = Uri.parse(url);
                    Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
                    if (!Intrinsics.areEqual(parse.getScheme(), "http") && !Intrinsics.areEqual(parse.getScheme(), "https")) {
                        objArr = false;
                        Map<String, String> envParameters = UriParserKt.getEnvParameters(parse);
                        if (objArr == false) {
                            str = url;
                            if ((StringsKt.indexOf$default(str, "?", 0, false, 6, (Object) null) == -1) == false) {
                                str = null;
                            }
                            if (str == null) {
                                String str5 = url;
                                int indexOf$default = StringsKt.indexOf$default(str5, "?", 0, false, 6, (Object) null);
                                if (str5 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                str = str5.substring(0, indexOf$default);
                                Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                        } else {
                            str = url;
                        }
                        provideBytes = execute.provideBytes();
                        if (provideBytes == null) {
                            Intrinsics.throwNpe();
                        }
                        JSONObject jSONObject2 = new JSONObject(new String(provideBytes, Charsets.UTF_8)).getJSONObject(str);
                        jSONObject = jSONObject2 instanceof JSONObject ? null : jSONObject2;
                        if (jSONObject != null) {
                            int i = Forest.WhenMappings.$EnumSwitchMapping$1[params.getResourceScene().ordinal()];
                            if (i == 1 || i == 2) {
                                preloadType = PreloadType.WEB;
                            } else if (i == 3) {
                                preloadType = PreloadType.LYNX;
                            } else {
                                Object remove = jSONObject.remove("type");
                                if (!(remove instanceof String)) {
                                    remove = null;
                                }
                                String str6 = (String) remove;
                                String str7 = str6;
                                if (str7 != null && str7.length() != 0) {
                                    z = false;
                                }
                                if (str6 == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                String upperCase = str6.toUpperCase();
                                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
                                preloadType = PreloadType.valueOf(upperCase);
                            }
                            Forest forest2 = Forest.this;
                            boolean disableCdn = params.getDisableCdn();
                            NetWorker netWorker = params.getNetWorker();
                            if (netWorker == null) {
                                netWorker = NetWorker.Downloader;
                            }
                            parseSubResourceConfig = forest2.parseSubResourceConfig(jSONObject, envParameters, disableCdn, netWorker, params.getCustomHttpMaxAge(), postProcessorBuilder);
                            PreloadConfig preloadConfig2 = new PreloadConfig((String) null, preloadType, (Map<String, ? extends List<ResourceConfig>>) parseSubResourceConfig);
                            preloadConfig2.setFrom(params.getPreloadFrom());
                            preloadConfig2.setInjectUserAgent(params.getInjectedUserAgent());
                            preloadConfig = preloadConfig2;
                        }
                        if (preloadConfig != null) {
                            LogUtils.e$default(LogUtils.INSTANCE, "PreloadAPI", "Building PreloadConfig for " + url + " failed, no matched item in preload.json", null, 4, null);
                            return;
                        } else {
                            Forest.this.preload(preloadConfig, containerId, sessionId);
                            return;
                        }
                    }
                    objArr = true;
                    Map<String, String> envParameters2 = UriParserKt.getEnvParameters(parse);
                    if (objArr == false) {
                    }
                    provideBytes = execute.provideBytes();
                    if (provideBytes == null) {
                    }
                    JSONObject jSONObject22 = new JSONObject(new String(provideBytes, Charsets.UTF_8)).getJSONObject(str);
                    if (jSONObject22 instanceof JSONObject) {
                    }
                    if (jSONObject != null) {
                    }
                    if (preloadConfig != null) {
                    }
                } catch (Throwable th) {
                    LogUtils.e$default(LogUtils.INSTANCE, "PreloadAPI", "Building PreloadConfig for " + url + " failed, " + th, null, 4, null);
                }
            }
        });
    }
}
