package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: builtin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/postprocessor/LoadToMemoryProcessor;", "Lcom/bytedance/forest/postprocessor/BuiltinProcessor;", "allowIOOnMainThread", "", "(Z)V", "onBuiltinProcess", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class LoadToMemoryProcessor extends BuiltinProcessor {
    public LoadToMemoryProcessor(boolean z) {
        super(z);
    }

    @Override // com.bytedance.forest.postprocessor.BuiltinProcessor
    public void onBuiltinProcess(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        response.getRequest().getIsASync();
        if (ThreadUtils.INSTANCE.isMainThread()) {
            ForestLogger.print$default(getContext().getLogger(), 5, "FOREST", "IO operation in UI thread", false, null, null, 56, null);
        }
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext(), new String[]{Timing.LOAD_TO_MEMORY_START}, null, 2, null);
        response.loadToMemory();
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(getContext(), new String[]{Timing.LOAD_TO_MEMORY_FINISH}, null, 2, null);
    }
}
