package com.bytedance.forest.chain.fetchers;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.forest.pollyfill.FetchTask;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.ThreadUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CDNFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u000fH\u0002J,\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/CDNFetcher;", "Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "fetchTask", "Lcom/bytedance/forest/pollyfill/FetchTask;", "cancel", "", "doFetch", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchAsync", "fetchSync", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CDNFetcher extends ResourceFetcher {
    public static final String DIR_NAME = "rl_resource_offline";
    public static final String TAG = "CDNFetcher";
    private FetchTask fetchTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CDNFetcher(Forest forest) {
        super(forest);
        Intrinsics.checkParameterIsNotNull(forest, "forest");
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchSync(Request request, Response response) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 4, TAG, "start to fetchSync from cdn", true, null, Timing.CDN_TOTAL_START, 16, null);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.CDN_TOTAL_START}, null, 2, null);
        doFetch(request, response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.fetchers.CDNFetcher$fetchSync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Response response2) {
                Intrinsics.checkParameterIsNotNull(response2, "it");
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(CDNFetcher.this.getContext$forest_release(), new String[]{Timing.CDN_TOTAL_FINISH}, null, 2, null);
            }
        });
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void fetchAsync(final Request request, final Response response, final Function1<? super Response, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        ForestLogger.print$default(getContext$forest_release().getLogger(), 4, TAG, "start to fetchAsync from cdn", true, null, Timing.CDN_TOTAL_START, 16, null);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.CDN_TOTAL_START, "cdn_switch_thread_start"}, null, 2, null);
        ThreadUtils.INSTANCE.runInBackground(new Function0<Unit>() { // from class: com.bytedance.forest.chain.fetchers.CDNFetcher$fetchAsync$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m469invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m469invoke() {
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(CDNFetcher.this.getContext$forest_release(), new String[]{"cdn_switch_thread_finish"}, null, 2, null);
                CDNFetcher.this.doFetch(request, response, new Function1<Response, Unit>() { // from class: com.bytedance.forest.chain.fetchers.CDNFetcher$fetchAsync$1.1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Response) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Response response2) {
                        Intrinsics.checkParameterIsNotNull(response2, "it");
                        ForestPipelineContext.recordPerformanceTiming$forest_release$default(CDNFetcher.this.getContext$forest_release(), new String[]{Timing.CDN_TOTAL_FINISH}, null, 2, null);
                        callback.invoke(response);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doFetch(Request request, final Response response, final Function1<? super Response, Unit> callback) {
        if (StringsKt.isBlank(request.getUrl())) {
            response.getErrorInfo().setError(ErrorInfo.Type.CDN, 1, "CDN Url Blank");
            callback.invoke(response);
            return;
        }
        File file = new File(getForest().getApplication().getCacheDir(), DIR_NAME);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!request.getUri().isHierarchical()) {
            response.getErrorInfo().setError(ErrorInfo.Type.CDN, 2, "cdn Url is not Hierarchical");
            callback.invoke(response);
        } else {
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext$forest_release(), new String[]{Timing.CDN_START}, null, 2, null);
            this.fetchTask = CDNFetchDepender.INSTANCE.fetchResourceFile(getForest(), response, getContext$forest_release(), request.getNetDepender$forest_release(), new Function1<Boolean, Unit>() { // from class: com.bytedance.forest.chain.fetchers.CDNFetcher$doFetch$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    Response.this.setFrom(ResourceFrom.CDN);
                    if (Response.this.getIsCanceled()) {
                        return;
                    }
                    callback.invoke(Response.this);
                }
            });
        }
    }

    @Override // com.bytedance.forest.chain.fetchers.ResourceFetcher
    public void cancel() {
        FetchTask fetchTask = this.fetchTask;
        if (fetchTask != null) {
            fetchTask.cancel$forest_release();
        }
    }
}
