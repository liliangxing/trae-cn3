package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Scene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: request.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tB\u001d\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0002\u0010\rR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/forest/postprocessor/PostProcessParams;", "T", "", "Lcom/bytedance/forest/model/RequestParams;", "origin", "isPreload", "", "processor", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "(Lcom/bytedance/forest/model/RequestParams;ZLcom/bytedance/forest/postprocessor/ForestPostProcessor;)V", "scene", "Lcom/bytedance/forest/model/Scene;", "(Lcom/bytedance/forest/postprocessor/ForestPostProcessor;Lcom/bytedance/forest/model/Scene;)V", "(Lcom/bytedance/forest/postprocessor/PostProcessParams;)V", "getProcessor$forest_release", "()Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PostProcessParams<T> extends RequestParams {
    private final ForestPostProcessor<T> processor;

    public /* synthetic */ PostProcessParams(RequestParams requestParams, boolean z, ForestPostProcessor forestPostProcessor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestParams, (i & 2) != 0 ? requestParams.getIsPreload() : z, forestPostProcessor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessParams(RequestParams requestParams, boolean z, ForestPostProcessor<T> forestPostProcessor) {
        super(requestParams, z);
        Intrinsics.checkParameterIsNotNull(requestParams, "origin");
        Intrinsics.checkParameterIsNotNull(forestPostProcessor, "processor");
        this.processor = forestPostProcessor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessParams(ForestPostProcessor<T> forestPostProcessor, Scene scene) {
        super(scene);
        Intrinsics.checkParameterIsNotNull(forestPostProcessor, "processor");
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        this.processor = forestPostProcessor;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostProcessParams(PostProcessParams<T> postProcessParams) {
        super(postProcessParams, false, 2, null);
        Intrinsics.checkParameterIsNotNull(postProcessParams, "origin");
        this.processor = postProcessParams.processor;
    }

    public final ForestPostProcessor<T> getProcessor$forest_release() {
        return this.processor;
    }
}
