package com.bytedance.forest.chain.fetchers;

import android.webkit.WebResourceResponse;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.PostProcessRequest;
import com.bytedance.forest.postprocessor.ProcessedData;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.forest.utils.CacheIdentifier;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.MemoryCacheItem;
import com.bytedance.forest.utils.OfflineUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/MemoryFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "TAG", "", "cancel", "", "fetchAsync", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchSync", "finishWithCallback", "recordFinish", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MemoryFetcher extends ResourceFetcher {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String TAG;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResourceFrom.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ResourceFrom.CDN.ordinal()] = 1;
            iArr[ResourceFrom.GECKO.ordinal()] = 2;
            iArr[ResourceFrom.BUILTIN.ordinal()] = 3;
        }
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
    }

    /* compiled from: MemoryFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/MemoryFetcher$Companion;", "", "()V", "checkExpired", "", "url", "", "httpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "file", "Ljava/io/File;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "customMaxAge", "", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean checkExpired(String url, ForestNetAPI.HttpResponse httpResponse, File file, ForestPipelineContext context, int customMaxAge) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(context, "context");
            if (file != null && !CDNFetchDepender.INSTANCE.checkExpired(url, file, context)) {
                return false;
            }
            Long expiredTime = OfflineUtil.INSTANCE.getExpiredTime(httpResponse);
            return System.currentTimeMillis() > Math.max(expiredTime != null ? expiredTime.longValue() : OfflineUtil.INSTANCE.getRequestTime$forest_release(httpResponse), OfflineUtil.INSTANCE.getCustomizedExpireTime(httpResponse, customMaxAge));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryFetcher(Forest forest) {
        super(forest);
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        this.TAG = "MemoryFetcher";
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request request, Response response) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        fetchAsync(request, response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.fetchers.MemoryFetcher$fetchSync$1
            public final void invoke(Response response2) {
                Intrinsics.checkParameterIsNotNull(response2, "it");
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ed, code lost:
    
        if (r33.getOnlyOnline() != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x00fd, code lost:
    
        if (r33.getOnlyOnline() != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x033c, code lost:
    
        if (r0 != null) goto L118;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0144  */
    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchAsync(final Request request, final Response response, Function1<? super Response, Unit> callback) {
        String str;
        InMemoryBuffer inMemoryBuffer;
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.MEMORY_START, "memory_get_cache_start"}, null, 2, null);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 4, this.TAG, "start to fetch from memory", true, null, Timing.MEMORY_START, 16, null);
        final CacheIdentifier cacheKey$forest_release = request.getCacheKey$forest_release();
        if (cacheKey$forest_release == null) {
            response.getErrorInfo().setError(ErrorInfo.Type.Memory, 1, "cannot build cache identifier");
            finishWithCallback(response, callback);
            return;
        }
        final MemoryCacheItem cache = getForest().getMemoryManager().getCache(cacheKey$forest_release, request.getEnableRequestReuse());
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{"memory_get_cache_finish"}, null, 2, null);
        if (cache == null) {
            response.getErrorInfo().setError(ErrorInfo.Type.Memory, 2, "could not found memory cache");
            finishWithCallback(response, callback);
            return;
        }
        final Response response2 = cache.getResponse();
        final InMemoryBuffer buffer = cache.getBuffer();
        String filePath = response2.getFilePath();
        File file = filePath != null ? new File(filePath) : null;
        if ((file == null || !file.isFile()) && buffer == null) {
            response.getErrorInfo().setError(ErrorInfo.Type.Memory, 5, "find cache but can not be consumed");
            getForest().getMemoryManager().removeCache(cacheKey$forest_release);
            finishWithCallback(response, callback);
            return;
        }
        ResourceFrom from = response2.getFrom();
        if (from != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[from.ordinal()];
            if (i != 1) {
                str = "[onlyOnline:1]";
                if (i != 2) {
                    if (i == 3) {
                        if (request.getDisableBuiltin()) {
                            str = "[disableBuiltin:1]";
                        }
                    }
                } else if (request.getDisableOffline()) {
                    str = "[disableOffline:1]";
                }
            } else if (request.getDisableCdn()) {
                str = "[disableCdn:1]";
            } else if (request.getOnlyLocal()) {
                str = "[onlyLocal:1]";
            } else if (!request.getEnableCDNCache() && response2.getIsCache()) {
                str = "[enableCDNCache:0, isCache:1]";
            }
            if (!LoaderUtils.INSTANCE.isNotNullOrEmpty(str)) {
                response.getErrorInfo().setError(ErrorInfo.Type.Memory, 5, "found cache but disabled by request config " + str);
                finishWithCallback(response, callback);
                return;
            }
            ResourceFrom from2 = response2.getFrom();
            if (!(from2 != ResourceFrom.MEMORY)) {
                from2 = null;
            }
            if (from2 == null) {
                from2 = response2.getOriginFrom();
            }
            if (from2 == ResourceFrom.CDN) {
                String originUrl = response2.getRequest().getOriginUrl();
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{"memory_check_cache_expired_start"}, null, 2, null);
                boolean checkExpired = INSTANCE.checkExpired(originUrl, response2.getAssembleHttpResponseIf304$forest_release(), file, getContext$forest_release(), response2.getRequest().getCustomHttpMaxAge());
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{"memory_check_cache_expired_finish"}, null, 2, null);
                if (checkExpired) {
                    getForest().getMemoryManager().removeCache(cacheKey$forest_release);
                    response.getErrorInfo().setError(ErrorInfo.Type.Memory, 3, "cdn cache expired");
                    finishWithCallback(response, callback);
                    return;
                }
            } else if (file != null && !file.isFile()) {
                response.getErrorInfo().setError(ErrorInfo.Type.Memory, 4, "from " + response2.getFrom() + " but " + file.getAbsoluteFile() + " not exists or a directory");
                getForest().getMemoryManager().removeCache(cacheKey$forest_release);
                finishWithCallback(response, callback);
                return;
            }
            if ((response2 instanceof ProcessedResponse) && ((ProcessedResponse) response2).getIsProcessSucceed()) {
                if (!(request instanceof PostProcessRequest)) {
                    response.getErrorInfo().setError(ErrorInfo.Type.Memory, 5, "cached response is an processed one and newly request no need to process");
                    finishWithCallback(response, callback);
                    return;
                }
                Request request2 = response2.getRequest();
                if (request2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.PostProcessRequest<*>");
                }
                ForestPostProcessor postProcessor$forest_release = ((PostProcessRequest) request2).getPostProcessor$forest_release();
                ForestPostProcessor postProcessor$forest_release2 = ((PostProcessRequest) request).getPostProcessor$forest_release();
                if (!Intrinsics.areEqual(postProcessor$forest_release.getClass(), postProcessor$forest_release2.getClass())) {
                    response.getErrorInfo().setError(ErrorInfo.Type.Memory, 5, "processor for cached response is " + postProcessor$forest_release.getClass() + ", required is " + postProcessor$forest_release2.getClass());
                    finishWithCallback(response, callback);
                    return;
                }
            }
            response.setSucceed(true);
            response.setFilePath(response2.getFilePath());
            response.setFrom(response2.getFrom());
            response.setOriginFrom(response2.getOriginFrom());
            response.setDataType$forest_release(response2.getDataType());
            response.setCharset$forest_release(response2.getCharset());
            response.setCache(true);
            response.setImageReference$forest_release(response2.getImageReference$forest_release());
            response.setVersion(response2.getVersion());
            response.setHttpResponse(response2.getHttpResponse());
            response.setHttpHeader(response2.getHttpHeader());
            response.setRedirection(response2.getIsRedirection());
            response.setNegotiation(response2.getIsNegotiation());
            response.setUseGkFS(response2.getUseGkFS());
            response.setGeckoOfflineFromCDN$forest_release(response2.getIsGeckoOfflineFromCDN());
            response.getErrorInfo().copyFrom(response2.getErrorInfo(), ErrorInfo.Type.Memory);
            if (buffer != null) {
                buffer.setContext$forest_release(getContext$forest_release());
                Unit unit = Unit.INSTANCE;
                inMemoryBuffer = buffer;
            } else {
                inMemoryBuffer = null;
            }
            response.setInMemoryBuffer$forest_release(inMemoryBuffer);
            if (buffer instanceof ForestBuffer) {
                WebResourceResponse webResourceResponseFromTTNet = response2.getWebResourceResponseFromTTNet();
                if (webResourceResponseFromTTNet != null) {
                    response.setWebResourceResponseFromTTNet(OfflineUtil.INSTANCE.generateWebResourceResponse(webResourceResponseFromTTNet.getMimeType(), webResourceResponseFromTTNet.getEncoding(), buffer.provideInputStream(response), request.getOriginUrl(), webResourceResponseFromTTNet.getResponseHeaders()));
                    Unit unit2 = Unit.INSTANCE;
                }
            } else if (buffer instanceof ProcessedData) {
                ProcessedResponse processedResponse = (ProcessedResponse) (!(response instanceof ProcessedResponse) ? null : response);
                if (processedResponse != null) {
                    if (buffer != null) {
                        processedResponse.setProcessedData$forest_release((ProcessedData) buffer);
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.ProcessedData<kotlin.Any>");
                    }
                }
                ForestLogger.printOptimize$default(getContext$forest_release().getLogger(), 6, "MemoryFetcher", true, null, null, new Function0<String>() { // from class: com.bytedance.forest.chain.fetchers.MemoryFetcher$fetchAsync$$inlined$apply$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public final String invoke() {
                        return "in-memory buffer from cache is " + buffer + ", but received a " + Response.this.toStringVM$forest_release();
                    }
                }, 24, null);
                Unit unit4 = Unit.INSTANCE;
            }
            InMemoryBuffer buffer2 = cache.getBuffer();
            if (buffer2 != null && buffer2.isCacheProvided$forest_release()) {
                response.setFrom(ResourceFrom.MEMORY);
                ResourceFrom from3 = response2.getFrom();
                ResourceFrom resourceFrom = from3 != ResourceFrom.MEMORY ? from3 : null;
                if (resourceFrom == null) {
                    resourceFrom = response2.getOriginFrom();
                }
                response.setOriginFrom(resourceFrom);
            }
            Unit unit5 = Unit.INSTANCE;
            finishWithCallback(response, callback);
            return;
        }
        str = null;
        if (!LoaderUtils.INSTANCE.isNotNullOrEmpty(str)) {
        }
    }

    private final void finishWithCallback(Response response, Function1<? super Response, Unit> callback) {
        recordFinish(response);
        callback.invoke(response);
    }

    private final void recordFinish(Response response) {
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.MEMORY_FINISH}, null, 2, null);
    }
}
