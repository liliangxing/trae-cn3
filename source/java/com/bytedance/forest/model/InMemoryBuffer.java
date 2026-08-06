package com.bytedance.forest.model;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.utils.ForestPipelineContext;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InMemoryBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0010¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u0012H ¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0012H ¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0012H ¢\u0006\u0002\b\u0017J\b\u0010\u000f\u001a\u00020\fH\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\u0012H&J\u0015\u0010!\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH ¢\u0006\u0002\b\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0090.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/forest/model/InMemoryBuffer;", "Ljava/io/Closeable;", "()V", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "getContext$forest_release", "()Lcom/bytedance/forest/utils/ForestPipelineContext;", "setContext$forest_release", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "fulfillListeners", "Ljava/util/HashSet;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashSet;", "fulfillListener", "onFulFilled", "fulfillListener$forest_release", "isCacheClear", "", "isCacheClear$forest_release", "isCacheProvided", "isCacheProvided$forest_release", "isCacheReady", "isCacheReady$forest_release", "provideBytes", "", "provideInputStream", "Ljava/io/InputStream;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "size", "", "supportReuse", "tryLoadToMemory", "tryLoadToMemory$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class InMemoryBuffer implements Closeable {
    public ForestPipelineContext context;
    private final HashSet<Function0<Unit>> fulfillListeners = new HashSet<>();

    public abstract boolean isCacheClear$forest_release();

    public abstract boolean isCacheProvided$forest_release();

    public abstract boolean isCacheReady$forest_release();

    public abstract byte[] provideBytes();

    public abstract InputStream provideInputStream(Response response);

    public abstract int size();

    public abstract boolean supportReuse();

    public abstract void tryLoadToMemory$forest_release(Response response) throws Throwable;

    /* renamed from: getContext$forest_release */
    public ForestPipelineContext getContext() {
        ForestPipelineContext forestPipelineContext = this.context;
        if (forestPipelineContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        }
        return forestPipelineContext;
    }

    public void setContext$forest_release(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "<set-?>");
        this.context = forestPipelineContext;
    }

    public void fulfillListener$forest_release(Function0<Unit> onFulFilled) {
        Intrinsics.checkParameterIsNotNull(onFulFilled, "onFulFilled");
        synchronized (this.fulfillListeners) {
            if (isCacheReady$forest_release()) {
                onFulFilled.invoke();
            } else {
                Boolean.valueOf(this.fulfillListeners.add(onFulFilled));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onFulFilled() {
        synchronized (this.fulfillListeners) {
            Iterator<T> it = this.fulfillListeners.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
            this.fulfillListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
