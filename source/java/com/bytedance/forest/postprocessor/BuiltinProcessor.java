package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: builtin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H&J\u0015\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\u000f"}, d2 = {"Lcom/bytedance/forest/postprocessor/BuiltinProcessor;", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "Lcom/bytedance/forest/model/Response;", "allowOnMainThread", "", "(Z)V", "onBuiltinProcess", "", ApmTrafficStats.TTNET_RESPONSE, "onPostProcess", "data", "Lcom/bytedance/forest/postprocessor/ProcessableData;", "onPostProcess$forest_release", "onProcess", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BuiltinProcessor extends ForestPostProcessor<Response> {
    public BuiltinProcessor() {
        this(false, 1, null);
    }

    public abstract void onBuiltinProcess(Response response);

    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public void onPostProcess$forest_release(ProcessableData data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
    }

    public /* synthetic */ BuiltinProcessor(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public BuiltinProcessor(boolean z) {
        super(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.forest.postprocessor.ForestPostProcessor
    public ProcessedData<Response> onProcess(ProcessableData data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Response response$forest_release = data.getResponse$forest_release();
        onBuiltinProcess(response$forest_release);
        InMemoryBuffer inMemoryBuffer$forest_release = response$forest_release.getInMemoryBuffer$forest_release();
        return new ProcessedData<>(inMemoryBuffer$forest_release != null ? RangesKt.coerceAtLeast(inMemoryBuffer$forest_release.size(), 1) : 1, response$forest_release);
    }
}
