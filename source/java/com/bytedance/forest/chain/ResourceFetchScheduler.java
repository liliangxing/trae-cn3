package com.bytedance.forest.chain;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.chain.fetchers.BuiltinFetcher;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.chain.fetchers.MemoryFetcher;
import com.bytedance.forest.chain.fetchers.NewlyBuiltinFetcher;
import com.bytedance.forest.model.DefaultConfig;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.postprocessor.ResourceProcessChain;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceFetchScheduler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/forest/chain/ResourceFetchScheduler;", "", "()V", "TAG", "", "createFetcherChain", "Lcom/bytedance/forest/chain/ResourceFetcherChain;", "request", "Lcom/bytedance/forest/model/Request;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "processorChain", "Lcom/bytedance/forest/postprocessor/ResourceProcessChain;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "createFetcherChain$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResourceFetchScheduler {
    public static final ResourceFetchScheduler INSTANCE = new ResourceFetchScheduler();
    public static final String TAG = "ResourceFetchScheduler";

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FetcherType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[FetcherType.GECKO.ordinal()] = 1;
            iArr[FetcherType.MEMORY.ordinal()] = 2;
            iArr[FetcherType.BUILTIN.ordinal()] = 3;
            iArr[FetcherType.CDN.ordinal()] = 4;
        }
    }

    private ResourceFetchScheduler() {
    }

    public static /* synthetic */ ResourceFetcherChain createFetcherChain$forest_release$default(ResourceFetchScheduler resourceFetchScheduler, Request request, Response response, ResourceProcessChain resourceProcessChain, ForestPipelineContext forestPipelineContext, int i, Object obj) {
        if ((i & 4) != 0) {
            resourceProcessChain = null;
        }
        return resourceFetchScheduler.createFetcherChain$forest_release(request, response, resourceProcessChain, forestPipelineContext);
    }

    public final ResourceFetcherChain createFetcherChain$forest_release(Request request, Response response, ResourceProcessChain processorChain, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(context, "context");
        LinkedList linkedList = new LinkedList();
        if (request.getOnlyOnline()) {
            request.setFetcherSequence(CollectionsKt.mutableListOf(new FetcherType[]{FetcherType.CDN}));
        } else if (request.getEnableMemoryCache()) {
            request.getFetcherSequence().add(0, FetcherType.MEMORY);
        }
        if (request.getFetcherSequence().isEmpty()) {
            ForestLogger.print$default(context.getLogger(), 6, TAG, "Fetcher sequence is empty", true, null, LogReportNode.FETCHER_SEQUENCE_EMPTY_ERROR, 16, null);
            request.setFetcherSequence(CollectionsKt.toMutableList(DefaultConfig.INSTANCE.getFETCHER_SEQUENCE()));
        }
        if (request.getDisableBuiltin()) {
            request.getFetcherSequence().remove(FetcherType.BUILTIN);
        }
        if (request.getDisableCdn()) {
            request.getFetcherSequence().remove(FetcherType.CDN);
        }
        if (request.getDisableOffline()) {
            request.getFetcherSequence().remove(FetcherType.GECKO);
        }
        Iterator<FetcherType> it = request.getFetcherSequence().iterator();
        while (it.hasNext()) {
            int i = WhenMappings.$EnumSwitchMapping$0[it.next().ordinal()];
            if (i == 1) {
                linkedList.add(GeckoFetcher.class);
            } else if (i == 2) {
                linkedList.add(MemoryFetcher.class);
            } else if (i == 3) {
                linkedList.add(request.getUseGeckoNewlyBuiltin() ? NewlyBuiltinFetcher.class : BuiltinFetcher.class);
            } else if (i == 4) {
                linkedList.add(CDNFetcher.class);
            }
        }
        return new ResourceFetcherChain(request, response, linkedList, processorChain, context);
    }
}
