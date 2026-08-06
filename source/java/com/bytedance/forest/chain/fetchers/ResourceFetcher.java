package com.bytedance.forest.chain.fetchers;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestPipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH&J,\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\u0015H&J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/ResourceFetcher;", "", "forest", "Lcom/bytedance/forest/Forest;", "(Lcom/bytedance/forest/Forest;)V", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "getContext$forest_release", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "getForest", "()Lcom/bytedance/forest/Forest;", "cancel", "", "fetchAsync", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "fetchSync", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ResourceFetcher {
    public ForestPipelineContext context;
    private final Forest forest;

    public abstract void cancel();

    public abstract void fetchAsync(Request request, Response response, Function1<? super Response, Unit> callback);

    public abstract void fetchSync(Request request, Response response);

    public ResourceFetcher(Forest forest) {
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        this.forest = forest;
    }

    public final Forest getForest() {
        return this.forest;
    }

    public final ForestPipelineContext getContext$forest_release() {
        ForestPipelineContext forestPipelineContext = this.context;
        if (forestPipelineContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return forestPipelineContext;
    }

    public final void setContext$forest_release(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "<set-?>");
        this.context = forestPipelineContext;
    }
}
