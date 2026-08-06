package com.bytedance.forest.model;

import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.ResourceFetcherChain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestOperation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/forest/model/RequestOperation;", "", "requestParams", "Lcom/bytedance/forest/model/RequestParams;", "url", "", "forest", "Lcom/bytedance/forest/Forest;", "chain", "Lcom/bytedance/forest/chain/ResourceFetcherChain;", "status", "Lcom/bytedance/forest/model/Status;", "(Lcom/bytedance/forest/model/RequestParams;Ljava/lang/String;Lcom/bytedance/forest/Forest;Lcom/bytedance/forest/chain/ResourceFetcherChain;Lcom/bytedance/forest/model/Status;)V", "getChain$forest_release", "()Lcom/bytedance/forest/chain/ResourceFetcherChain;", "setChain$forest_release", "(Lcom/bytedance/forest/chain/ResourceFetcherChain;)V", "getForest$forest_release", "()Lcom/bytedance/forest/Forest;", "getRequestParams$forest_release", "()Lcom/bytedance/forest/model/RequestParams;", "getStatus", "()Lcom/bytedance/forest/model/Status;", "setStatus", "(Lcom/bytedance/forest/model/Status;)V", "getUrl$forest_release", "()Ljava/lang/String;", "cancel", "", "execute", "Lcom/bytedance/forest/model/Response;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RequestOperation {
    private volatile ResourceFetcherChain chain;
    private final Forest forest;
    private final RequestParams requestParams;
    private volatile Status status;
    private final String url;

    public RequestOperation(RequestParams requestParams, String str, Forest forest, ResourceFetcherChain resourceFetcherChain, Status status) {
        Intrinsics.checkParameterIsNotNull(requestParams, "requestParams");
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(status, "status");
        this.requestParams = requestParams;
        this.url = str;
        this.forest = forest;
        this.chain = resourceFetcherChain;
        this.status = status;
    }

    /* renamed from: getRequestParams$forest_release, reason: from getter */
    public final RequestParams getRequestParams() {
        return this.requestParams;
    }

    /* renamed from: getUrl$forest_release, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: getForest$forest_release, reason: from getter */
    public final Forest getForest() {
        return this.forest;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RequestOperation(RequestParams requestParams, String str, Forest forest, ResourceFetcherChain resourceFetcherChain, Status status, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestParams, str, forest, resourceFetcherChain, (i & 16) != 0 ? Status.PENDING : status);
        if ((i & 8) != 0) {
            resourceFetcherChain = null;
        }
    }

    /* renamed from: getChain$forest_release, reason: from getter */
    public final ResourceFetcherChain getChain() {
        return this.chain;
    }

    public final void setChain$forest_release(ResourceFetcherChain resourceFetcherChain) {
        this.chain = resourceFetcherChain;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setStatus(Status status) {
        Intrinsics.checkParameterIsNotNull(status, "<set-?>");
        this.status = status;
    }

    public Response execute() {
        if (this.status != Status.PENDING) {
            return null;
        }
        this.status = Status.FETCHING;
        return this.forest.fetchSync$forest_release(this);
    }

    public final void cancel() {
        if (this.status == Status.FETCHING || this.status == Status.PENDING) {
            this.status = Status.CANCELED;
            ResourceFetcherChain resourceFetcherChain = this.chain;
            if (resourceFetcherChain != null) {
                resourceFetcherChain.cancel();
            }
        }
    }
}
