package com.bytedance.forest.postprocessor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.EventReport;
import com.bytedance.forest.model.InMemoryBuffer;
import com.bytedance.forest.model.Response;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: entity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0010¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0014H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0015\u0010#\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0010¢\u0006\u0002\b$R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, d2 = {"Lcom/bytedance/forest/postprocessor/ProcessedData;", "T", "", "Lcom/bytedance/forest/model/InMemoryBuffer;", "size", "", "data", "(ILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSize", "()I", EventReport.DIALOG_CLOSE, "", "fulfillListener", "onFulFilled", "Lkotlin/Function0;", "fulfillListener$forest_release", "isCacheClear", "", "isCacheClear$forest_release", "isCacheProvided", "isCacheProvided$forest_release", "isCacheReady", "isCacheReady$forest_release", "provideBytes", "", "provideInputStream", "Ljava/io/InputStream;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "supportReuse", "toString", "", "tryLoadToMemory", "tryLoadToMemory$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ProcessedData<T> extends InMemoryBuffer {
    private final T data;
    private final int size;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheClear$forest_release() {
        return false;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheProvided$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean isCacheReady$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public byte[] provideBytes() {
        return null;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public InputStream provideInputStream(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        return null;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public boolean supportReuse() {
        return true;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public void tryLoadToMemory$forest_release(Response response) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
    }

    public ProcessedData(int i, T t) {
        Intrinsics.checkParameterIsNotNull(t, "data");
        this.size = i;
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }

    public final int getSize() {
        return this.size;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public int size() {
        return this.size;
    }

    @Override // com.bytedance.forest.model.InMemoryBuffer
    public void fulfillListener$forest_release(Function0<Unit> onFulFilled) {
        Intrinsics.checkParameterIsNotNull(onFulFilled, "onFulFilled");
        onFulFilled.invoke();
    }

    public String toString() {
        return super.toString() + "{data=" + this.data.getClass().getCanonicalName() + ", size=" + this.size + '}';
    }
}
