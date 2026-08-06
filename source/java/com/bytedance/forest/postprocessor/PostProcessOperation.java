package com.bytedance.forest.postprocessor;

import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.ResourceFetcherChain;
import com.bytedance.forest.model.RequestOperation;
import com.bytedance.forest.model.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: request.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B9\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/forest/postprocessor/PostProcessOperation;", "T", "", "Lcom/bytedance/forest/model/RequestOperation;", "requestParams", "Lcom/bytedance/forest/postprocessor/PostProcessParams;", "url", "", "forest", "Lcom/bytedance/forest/Forest;", "chain", "Lcom/bytedance/forest/chain/ResourceFetcherChain;", "status", "Lcom/bytedance/forest/model/Status;", "(Lcom/bytedance/forest/postprocessor/PostProcessParams;Ljava/lang/String;Lcom/bytedance/forest/Forest;Lcom/bytedance/forest/chain/ResourceFetcherChain;Lcom/bytedance/forest/model/Status;)V", "execute", "Lcom/bytedance/forest/postprocessor/ProcessedResponse;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PostProcessOperation<T> extends RequestOperation {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PostProcessOperation(PostProcessParams postProcessParams, String str, Forest forest, ResourceFetcherChain resourceFetcherChain, Status status, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(postProcessParams, str, forest, resourceFetcherChain, (i & 16) != 0 ? Status.PENDING : status);
        if ((i & 8) != 0) {
            resourceFetcherChain = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessOperation(PostProcessParams<T> postProcessParams, String str, Forest forest, ResourceFetcherChain resourceFetcherChain, Status status) {
        super(postProcessParams, str, forest, resourceFetcherChain, status);
        Intrinsics.checkParameterIsNotNull(postProcessParams, "requestParams");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(status, "status");
    }

    @Override // com.bytedance.forest.model.RequestOperation
    public ProcessedResponse<T> execute() {
        if (getStatus() != Status.PENDING) {
            return null;
        }
        setStatus(Status.FETCHING);
        return getForest().fetchSyncWithProcessor$forest_release(this);
    }
}
