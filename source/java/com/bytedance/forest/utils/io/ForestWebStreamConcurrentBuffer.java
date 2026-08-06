package com.bytedance.forest.utils.io;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.utils.ForestPipelineContext;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: batch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/forest/utils/io/ForestWebStreamConcurrentBuffer;", "Lcom/bytedance/forest/utils/io/ForestConcurrentBuffer;", "bytesProvider", "Lcom/bytedance/forest/model/BytesProvider;", "ctx", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/model/BytesProvider;Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "provideInputStream", "Ljava/io/InputStream;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForestWebStreamConcurrentBuffer extends ForestConcurrentBuffer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForestWebStreamConcurrentBuffer(BytesProvider bytesProvider, ForestPipelineContext forestPipelineContext) {
        super(bytesProvider, forestPipelineContext);
        Intrinsics.checkParameterIsNotNull(bytesProvider, "bytesProvider");
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "ctx");
    }

    @Override // com.bytedance.forest.utils.io.ForestConcurrentBuffer, com.bytedance.forest.model.InMemoryBuffer
    public InputStream provideInputStream(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (response.getRequest().getScene() == Scene.WEB_MAIN_DOCUMENT && response.getRequest().getStreamingLoad() && !isCacheReady$forest_release() && InMemoryByteBuffer.initCache$forest_release$default(this, null, 1, null)) {
            response.setStreamLoaded(true);
            traceInputStreamProvide();
            return new ForestWebStreamingInputStream(this, response);
        }
        return super.provideInputStream(response);
    }
}
