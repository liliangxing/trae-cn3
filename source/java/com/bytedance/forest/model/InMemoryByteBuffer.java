package com.bytedance.forest.model;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InMemoryByteBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH ¢\u0006\u0002\b\u0010J\u001b\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bH ¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/bytedance/forest/model/InMemoryByteBuffer;", "Lcom/bytedance/forest/model/InMemoryBuffer;", "bytesProvider", "Lcom/bytedance/forest/model/BytesProvider;", "(Lcom/bytedance/forest/model/BytesProvider;)V", "getBytesProvider", "()Lcom/bytedance/forest/model/BytesProvider;", "getBytesAtRange", "", "index", "bytes", "", "off", "len", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "getBytesAtRange$forest_release", "initCache", "", "initialSize", "initCache$forest_release", "(Ljava/lang/Integer;)Z", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class InMemoryByteBuffer extends InMemoryBuffer {
    private final BytesProvider bytesProvider;

    public abstract int getBytesAtRange$forest_release(int index, byte[] bytes, int off, int len, Response response) throws IOException;

    public abstract boolean initCache$forest_release(Integer initialSize);

    public InMemoryByteBuffer(BytesProvider bytesProvider) {
        Intrinsics.checkParameterIsNotNull(bytesProvider, "bytesProvider");
        this.bytesProvider = bytesProvider;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BytesProvider getBytesProvider() {
        return this.bytesProvider;
    }

    public static /* synthetic */ boolean initCache$forest_release$default(InMemoryByteBuffer inMemoryByteBuffer, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initCache");
        }
        if ((i & 1) != 0) {
            num = null;
        }
        return inMemoryByteBuffer.initCache$forest_release(num);
    }
}
