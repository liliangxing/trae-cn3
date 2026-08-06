package com.bytedance.forest.utils;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.Response;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: MemoryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/forest/utils/MemoryCacheItem;", "Ljava/io/Closeable;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "pool", "Lcom/bytedance/forest/utils/IResourcePool;", "(Lcom/bytedance/forest/model/Response;Lcom/bytedance/forest/utils/IResourcePool;)V", "buffer", "Lcom/bytedance/forest/model/InMemoryBuffer;", "getBuffer$forest_release", "()Lcom/bytedance/forest/model/InMemoryBuffer;", "observer", "Lcom/bytedance/forest/utils/GeckoChannelExpireObserver;", "getPool$forest_release", "()Lcom/bytedance/forest/utils/IResourcePool;", "setPool$forest_release", "(Lcom/bytedance/forest/utils/IResourcePool;)V", "getResponse", "()Lcom/bytedance/forest/model/Response;", "size", "", "getSize$forest_release", "()I", EventReport.DIALOG_CLOSE, "", "toString", "", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MemoryCacheItem implements Closeable {
    private final InMemoryBuffer buffer;
    private final GeckoChannelExpireObserver observer;
    private IResourcePool pool;
    private final Response response;

    /* renamed from: size, reason: from kotlin metadata and from toString */
    private final int cacheSize;

    public MemoryCacheItem(Response response, IResourcePool iResourcePool) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        this.response = response;
        this.pool = iResourcePool;
        InMemoryBuffer inMemoryBuffer$forest_release = response.getInMemoryBuffer$forest_release();
        this.buffer = inMemoryBuffer$forest_release;
        int i = 1;
        if (inMemoryBuffer$forest_release == null || !inMemoryBuffer$forest_release.isCacheProvided$forest_release()) {
            String filePath = response.getFilePath();
            if (filePath != null) {
                i = filePath.length();
            }
        } else {
            i = RangesKt.coerceAtLeast(inMemoryBuffer$forest_release.size(), 1);
        }
        this.cacheSize = i;
        this.observer = MemoryManager.INSTANCE.registerGeckoExpireObserver$forest_release(this);
    }

    public final Response getResponse() {
        return this.response;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MemoryCacheItem(Response response, IResourcePool iResourcePool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(response, iResourcePool);
        if ((i & 2) != 0) {
            iResourcePool = null;
        }
    }

    /* renamed from: getPool$forest_release, reason: from getter */
    public final IResourcePool getPool() {
        return this.pool;
    }

    public final void setPool$forest_release(IResourcePool iResourcePool) {
        this.pool = iResourcePool;
    }

    /* renamed from: getBuffer$forest_release, reason: from getter */
    public final InMemoryBuffer getBuffer() {
        return this.buffer;
    }

    /* renamed from: getSize$forest_release, reason: from getter */
    public final int getCacheSize() {
        return this.cacheSize;
    }

    public String toString() {
        return super.toString() + "(response=" + this.response.toStringVM$forest_release() + ", cacheSize=" + this.cacheSize + ", buffer=" + this.buffer + ", file=" + this.response.getFilePath() + ')';
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        GeckoChannelExpireObserver geckoChannelExpireObserver = this.observer;
        if (geckoChannelExpireObserver != null) {
            geckoChannelExpireObserver.close();
        }
    }
}
