package com.bytedance.forest.chain;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.ResourceFetcher;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.forest.postprocessor.ResourceProcessChain;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceFetcherChain.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J!\u0010!\u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0#H\u0000¢\u0006\u0002\b$J\u001c\u0010%\u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0#H\u0002J\u001c\u0010&\u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0#H\u0002R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/forest/chain/ResourceFetcherChain;", "", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "fetchers", "Ljava/util/LinkedList;", "Ljava/lang/Class;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "processorChain", "Lcom/bytedance/forest/postprocessor/ResourceProcessChain;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/model/Response;Ljava/util/LinkedList;Lcom/bytedance/forest/postprocessor/ResourceProcessChain;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "getContext$forest_release", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", PerfConsts.KEY_CURRENT_GALVANIC, "getCurrent", "()Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "setCurrent", "(Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;)V", "hasCanceled", "", "getHasCanceled", "()Z", "setHasCanceled", "(Z)V", "cancel", "", "createFetcher", "fetch", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetch$forest_release", "fetchAsync", "fetchSync", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResourceFetcherChain {
    private static final String TAG = "ResourceFetcherChain";
    private ForestPipelineContext context;
    private ResourceFetcher current;
    private final LinkedList<Class<? extends ResourceFetcher>> fetchers;
    private volatile boolean hasCanceled;
    private final ResourceProcessChain processorChain;
    private final Request request;
    private final Response response;

    public ResourceFetcherChain(Request request, Response response, LinkedList<Class<? extends ResourceFetcher>> linkedList, ResourceProcessChain resourceProcessChain, ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(linkedList, "fetchers");
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        this.request = request;
        this.response = response;
        this.fetchers = linkedList;
        this.processorChain = resourceProcessChain;
        this.context = forestPipelineContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResourceFetcherChain(Request request, Response response, LinkedList linkedList, ResourceProcessChain resourceProcessChain, ForestPipelineContext forestPipelineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, response, linkedList, resourceProcessChain, forestPipelineContext);
        if ((i & 8) != 0) {
            resourceProcessChain = null;
        }
    }

    /* renamed from: getContext$forest_release, reason: from getter */
    public final ForestPipelineContext getContext() {
        return this.context;
    }

    public final void setContext$forest_release(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "<set-?>");
        this.context = forestPipelineContext;
    }

    public final ResourceFetcher getCurrent() {
        return this.current;
    }

    public final void setCurrent(ResourceFetcher resourceFetcher) {
        this.current = resourceFetcher;
    }

    public final boolean getHasCanceled() {
        return this.hasCanceled;
    }

    public final void setHasCanceled(boolean z) {
        this.hasCanceled = z;
    }

    public final void fetch$forest_release(final Function1<? super Response, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestLogger.printOptimize$default(this.context.getLogger(), 4, TAG, true, null, Timing.RES_PIPELINE, new Function0<String>() { // from class: com.bytedance.forest.chain.ResourceFetcherChain$fetch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                Request request;
                StringBuilder sb = new StringBuilder("fetch, request = ");
                request = ResourceFetcherChain.this.request;
                return sb.append(request).append('}').toString();
            }
        }, 8, null);
        if (!this.request.getFetcherSequence().contains(FetcherType.GECKO)) {
            this.response.getErrorInfo().setError(ErrorInfo.Type.Gecko, 1, "disabled_by_config");
        }
        if (this.fetchers.isEmpty()) {
            this.response.getErrorInfo().setError(ErrorInfo.Type.Pipeline, 1, "ResourceFetcherChain# no fetcher for url:" + this.request.getOriginUrl() + " geckoModel:" + this.request.getGeckoModel());
            callback.invoke(this.response);
            return;
        }
        Function1<? super Response, Unit> function1 = this.processorChain == null ? callback : null;
        if (function1 == null) {
            function1 = new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.ResourceFetcherChain$fetch$callbackWithProcessors$2
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
                    ResourceProcessChain resourceProcessChain;
                    Response response2;
                    Intrinsics.checkParameterIsNotNull(response, "resp");
                    boolean z = response instanceof ProcessedResponse;
                    ProcessedResponse processedResponse = (ProcessedResponse) (!z ? null : response);
                    if ((processedResponse == null || !processedResponse.isProcessSucceed()) && (z || response.getFrom() != ResourceFrom.MEMORY)) {
                        resourceProcessChain = ResourceFetcherChain.this.processorChain;
                        if (resourceProcessChain == null) {
                            Intrinsics.throwNpe();
                        }
                        resourceProcessChain.process$forest_release(response, callback);
                        return;
                    }
                    ForestLogger logger = ResourceFetcherChain.this.getContext().getLogger();
                    StringBuilder sb = new StringBuilder("A succeed processed response from ");
                    response2 = ResourceFetcherChain.this.response;
                    ForestLogger.print$default(logger, 4, "ResourceFetcherChain", sb.append(response2.getFrom()).append(" do not need goes processor pipe through").toString(), true, null, null, 48, null);
                    callback.invoke(response);
                }
            };
        }
        if (this.request.getIsASync()) {
            fetchAsync(function1);
        } else {
            fetchSync(function1);
        }
    }

    private final void fetchSync(Function1<? super Response, Unit> callback) {
        Class<?> cls;
        while (true) {
            if (!(!this.fetchers.isEmpty())) {
                break;
            }
            try {
                ResourceFetcher createFetcher = createFetcher(this.request);
                createFetcher.fetchSync(this.request, this.response);
                if (this.response.getIsSucceed()) {
                    Response response = this.response;
                    String simpleName = createFetcher.getClass().getSimpleName();
                    Intrinsics.checkExpressionValueIsNotNull(simpleName, "fetcher.javaClass.simpleName");
                    response.setSuccessFetcher(simpleName);
                    callback.invoke(this.response);
                    return;
                }
            } catch (Throwable th) {
                if (this.fetchers.isEmpty()) {
                    ErrorInfo errorInfo = this.response.getErrorInfo();
                    ErrorInfo.Type type = ErrorInfo.Type.Pipeline;
                    StringBuilder sb = new StringBuilder("catch error on ");
                    ResourceFetcher resourceFetcher = this.current;
                    StringBuilder append = sb.append((resourceFetcher == null || (cls = resourceFetcher.getClass()) == null) ? null : cls.getSimpleName()).append(", error:").append(th.getMessage()).append(' ');
                    Throwable cause = th.getCause();
                    errorInfo.setError(type, 3, append.append(cause != null ? cause.getMessage() : null).toString());
                } else {
                    this.context.getLogger().printOptimize(6, TAG, true, th, LogReportNode.FETCHER_LOAD_ERROR, new Function0<String>() { // from class: com.bytedance.forest.chain.ResourceFetcherChain$fetchSync$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "fetchSync catch error:" + th.getMessage();
                        }
                    });
                }
            }
            if (this.hasCanceled) {
                this.response.setCanceled(true);
                this.response.getErrorInfo().setError(ErrorInfo.Type.Pipeline, 2, "ResourceFetcherChain# on cancel load");
                break;
            }
        }
        callback.invoke(this.response);
    }

    private final ResourceFetcher createFetcher(Request request) {
        Class<? extends ResourceFetcher> pop = this.fetchers.pop();
        ForestLogger logger = this.context.getLogger();
        StringBuilder sb = new StringBuilder("try to create fetcher by class ");
        Intrinsics.checkExpressionValueIsNotNull(pop, "fetcherClz");
        ForestLogger.print$default(logger, 4, TAG, sb.append(pop.getSimpleName()).toString(), true, null, Timing.CREATE_FETCHER, 16, null);
        try {
            try {
                ForestPipelineContext forestPipelineContext = this.context;
                String[] strArr = new String[1];
                StringBuilder sb2 = new StringBuilder();
                String simpleName = pop.getSimpleName();
                Intrinsics.checkExpressionValueIsNotNull(simpleName, "fetcherClz.simpleName");
                Locale locale = Locale.ENGLISH;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
                if (simpleName == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = simpleName.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                strArr[0] = sb2.append(lowerCase).append("_create_start").toString();
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext, strArr, null, 2, null);
                ResourceFetcher newInstance = pop.getConstructor(Forest.class).newInstance(request.getForest());
                newInstance.setContext$forest_release(this.context);
                this.current = newInstance;
                Intrinsics.checkExpressionValueIsNotNull(newInstance, "fetcher");
                ForestPipelineContext forestPipelineContext2 = this.context;
                String[] strArr2 = new String[1];
                StringBuilder sb3 = new StringBuilder();
                String simpleName2 = pop.getSimpleName();
                Intrinsics.checkExpressionValueIsNotNull(simpleName2, "fetcherClz.simpleName");
                Locale locale2 = Locale.ENGLISH;
                Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ENGLISH");
                if (simpleName2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = simpleName2.toLowerCase(locale2);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                strArr2[0] = sb3.append(lowerCase2).append("_create_finish").toString();
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext2, strArr2, null, 2, null);
                return newInstance;
            } catch (Exception e) {
                throw new IllegalStateException("create fetcher failed", e);
            }
        } catch (Throwable th) {
            ForestPipelineContext forestPipelineContext3 = this.context;
            String[] strArr3 = new String[1];
            StringBuilder sb4 = new StringBuilder();
            String simpleName3 = pop.getSimpleName();
            Intrinsics.checkExpressionValueIsNotNull(simpleName3, "fetcherClz.simpleName");
            Locale locale3 = Locale.ENGLISH;
            Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.ENGLISH");
            if (simpleName3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase3 = simpleName3.toLowerCase(locale3);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
            strArr3[0] = sb4.append(lowerCase3).append("_create_finish").toString();
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(forestPipelineContext3, strArr3, null, 2, null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchAsync(final Function1<? super Response, Unit> callback) {
        try {
            final ResourceFetcher createFetcher = createFetcher(this.request);
            createFetcher.fetchAsync(this.request, this.response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.ResourceFetcherChain$fetchAsync$1
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
                    LinkedList linkedList;
                    Response response2;
                    Response response3;
                    Response response4;
                    Response response5;
                    Intrinsics.checkParameterIsNotNull(response, "it");
                    if (ResourceFetcherChain.this.getHasCanceled()) {
                        response3 = ResourceFetcherChain.this.response;
                        response3.setCanceled(true);
                        response4 = ResourceFetcherChain.this.response;
                        response4.getErrorInfo().setError(ErrorInfo.Type.Pipeline, 2, "ResourceLoaderChain# on cancel load");
                        ForestLogger.print$default(ResourceFetcherChain.this.getContext().getLogger(), 3, "ResourceFetcherChain", "ResourceLoaderChain# on cancel load", false, null, null, 56, null);
                        Function1 function1 = callback;
                        response5 = ResourceFetcherChain.this.response;
                        function1.invoke(response5);
                        return;
                    }
                    if (response.getIsSucceed()) {
                        String simpleName = createFetcher.getClass().getSimpleName();
                        Intrinsics.checkExpressionValueIsNotNull(simpleName, "fetcher.javaClass.simpleName");
                        response.setSuccessFetcher(simpleName);
                        Function1 function12 = callback;
                        response2 = ResourceFetcherChain.this.response;
                        function12.invoke(response2);
                        return;
                    }
                    ForestLogger.print$default(ResourceFetcherChain.this.getContext().getLogger(), 6, "ResourceFetcherChain", "fetchAsync error:" + response.getErrorInfo(), true, null, LogReportNode.FETCHER_LOAD_ERROR, 16, null);
                    linkedList = ResourceFetcherChain.this.fetchers;
                    if (!linkedList.isEmpty()) {
                        ResourceFetcherChain.this.fetchAsync(callback);
                    } else {
                        callback.invoke(response);
                    }
                }
            });
        } catch (Throwable th) {
            ForestLogger.print$default(this.context.getLogger(), 6, TAG, " onException ", false, th, null, 40, null);
            if (!this.fetchers.isEmpty()) {
                fetchAsync(callback);
                return;
            }
            Response response = this.response;
            response.getErrorInfo().setError(ErrorInfo.Type.Pipeline, 3, "ResourceFetcherChain# " + th.getMessage());
            callback.invoke(response);
        }
    }

    public final void cancel() {
        if (this.hasCanceled) {
            return;
        }
        this.hasCanceled = true;
        ResourceFetcher resourceFetcher = this.current;
        if (resourceFetcher != null) {
            resourceFetcher.cancel();
        }
    }
}
