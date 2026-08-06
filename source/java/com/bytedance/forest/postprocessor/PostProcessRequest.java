package com.bytedance.forest.postprocessor;

import com.bytedance.forest.Forest;
import com.bytedance.forest.model.Request;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: request.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B9\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\r\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u000eB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\tH\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/forest/postprocessor/PostProcessRequest;", "T", "", "Lcom/bytedance/forest/model/Request;", "request", "postProcessor", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "(Lcom/bytedance/forest/model/Request;Lcom/bytedance/forest/postprocessor/ForestPostProcessor;)V", "originUrl", "", "forest", "Lcom/bytedance/forest/Forest;", "customParams", "", "(Ljava/lang/String;Lcom/bytedance/forest/Forest;Ljava/util/Map;Lcom/bytedance/forest/postprocessor/ForestPostProcessor;)V", "(Lcom/bytedance/forest/postprocessor/PostProcessRequest;)V", "getPostProcessor$forest_release", "()Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PostProcessRequest<T> extends Request {
    private final ForestPostProcessor<T> postProcessor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessRequest(Request request, ForestPostProcessor<T> forestPostProcessor) {
        super(request);
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(forestPostProcessor, "postProcessor");
        this.postProcessor = forestPostProcessor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessRequest(String str, Forest forest, Map<String, Object> map, ForestPostProcessor<T> forestPostProcessor) {
        super(str, forest, map, null, false, false, false, false, false, false, false, false, false, false, 0, null, false, null, false, false, false, null, false, false, false, null, null, false, false, 0, false, null, null, false, false, null, -8, 15, null);
        Intrinsics.checkParameterIsNotNull(str, "originUrl");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(map, "customParams");
        Intrinsics.checkParameterIsNotNull(forestPostProcessor, "postProcessor");
        this.postProcessor = forestPostProcessor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessRequest(PostProcessRequest<T> postProcessRequest) {
        super(postProcessRequest);
        Intrinsics.checkParameterIsNotNull(postProcessRequest, "request");
        this.postProcessor = postProcessRequest.postProcessor;
    }

    public final ForestPostProcessor<T> getPostProcessor$forest_release() {
        return this.postProcessor;
    }

    @Override // com.bytedance.forest.model.Request
    public String toString() {
        return "{request: " + super.toString() + ", processor: " + this.postProcessor + '}';
    }
}
