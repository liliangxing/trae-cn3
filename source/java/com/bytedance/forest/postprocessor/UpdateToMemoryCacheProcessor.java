package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.utils.MemoryCacheItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: builtin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/forest/postprocessor/UpdateToMemoryCacheProcessor;", "Lcom/bytedance/forest/postprocessor/BuiltinProcessor;", "()V", "onBuiltinProcess", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UpdateToMemoryCacheProcessor extends BuiltinProcessor {
    public UpdateToMemoryCacheProcessor() {
        super(false, 1, null);
    }

    @Override // com.bytedance.forest.postprocessor.BuiltinProcessor
    public void onBuiltinProcess(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        boolean z = (response instanceof ProcessedResponse) && ((ProcessedResponse) response).getIsProcessSucceed();
        if (response.getFrom() != ResourceFrom.BUILTIN) {
            if (z || response.getFrom() != ResourceFrom.MEMORY) {
                ForestNetAPI.HttpResponse assembleHttpResponseIf304$forest_release = response.getAssembleHttpResponseIf304$forest_release();
                if (assembleHttpResponseIf304$forest_release == null || assembleHttpResponseIf304$forest_release.supportCache() || response.getRequest().getCustomHttpMaxAge() > 0) {
                    response.getRequest().getForest().getMemoryManager().updateCache(new MemoryCacheItem(response, null, 2, null));
                }
            }
        }
    }
}
