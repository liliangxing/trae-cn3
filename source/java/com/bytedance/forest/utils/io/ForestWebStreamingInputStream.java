package com.bytedance.forest.utils.io;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.InMemoryByteBuffer;
import com.bytedance.forest.model.Response;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: batch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/forest/utils/io/ForestWebStreamingInputStream;", "Lcom/bytedance/forest/utils/io/ForestBatchInputStream;", "provider", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "(Lcom/bytedance/forest/model/InMemoryByteBuffer;Lcom/bytedance/forest/model/Response;)V", "available", "", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class ForestWebStreamingInputStream extends ForestBatchInputStream {
    private static final int DEFAULT_BATCH_SIZE = 1024;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForestWebStreamingInputStream(InMemoryByteBuffer inMemoryByteBuffer, Response response) {
        super(inMemoryByteBuffer, response, 1024);
        Intrinsics.checkParameterIsNotNull(inMemoryByteBuffer, "provider");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
    }

    @Override // com.bytedance.forest.utils.io.ForestBatchInputStream, java.io.InputStream
    public int available() {
        return Math.max(super.available(), 2);
    }
}
