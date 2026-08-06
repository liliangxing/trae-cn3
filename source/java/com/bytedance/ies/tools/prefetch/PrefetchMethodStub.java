package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.tools.prefetch.INetworkExecutor;
import com.bytedance.ies.tools.prefetch.IPrefetchResultListener;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchMethodStub.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00050\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchMethodStub;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchMethodStub;", "prefetchProcessor", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "resultListener", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", "(Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;)V", "process", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "resultListenerRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "invoke", "", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "params", "Lorg/json/JSONObject;", "invokeForceFallback", "onFailed", "throwable", "", "onSucceed", "response", "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;", "onTerminate", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchMethodStub implements IPrefetchMethodStub {
    private final IPrefetchProcessor prefetchProcessor;
    private PrefetchProcess process;
    private final WeakReference<IPrefetchResultListener> resultListenerRef;

    public PrefetchMethodStub(IPrefetchProcessor iPrefetchProcessor, IPrefetchResultListener iPrefetchResultListener) {
        Intrinsics.checkParameterIsNotNull(iPrefetchProcessor, "prefetchProcessor");
        Intrinsics.checkParameterIsNotNull(iPrefetchResultListener, "resultListener");
        this.prefetchProcessor = iPrefetchProcessor;
        this.resultListenerRef = new WeakReference<>(iPrefetchResultListener);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchMethodStub
    public void invoke(JSONObject params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        invoke(new PrefetchRequest(params));
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchMethodStub
    public void invoke(PrefetchRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        PrefetchMethodStub prefetchMethodStub = this;
        PrefetchProcess prefetchProcess = this.prefetchProcessor.get(request, prefetchMethodStub);
        this.process = prefetchProcess;
        if (prefetchProcess != null) {
            prefetchProcess.attachListener(prefetchMethodStub);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchMethodStub
    public void invokeForceFallback(JSONObject params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        invokeForceFallback(new PrefetchRequest(params));
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchMethodStub
    public void invokeForceFallback(PrefetchRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        PrefetchMethodStub prefetchMethodStub = this;
        PrefetchProcess ignoreCache = this.prefetchProcessor.getIgnoreCache(request, prefetchMethodStub);
        this.process = ignoreCache;
        if (ignoreCache != null) {
            ignoreCache.attachListener(prefetchMethodStub);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchMethodStub
    public void onTerminate() {
        PrefetchProcess prefetchProcess = this.process;
        if (prefetchProcess != null) {
            prefetchProcess.detachListener(this);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.ProcessListener
    public void onSucceed(INetworkExecutor.HttpResponse response) {
        PrefetchProcess.HitState hitState;
        Intrinsics.checkParameterIsNotNull(response, "response");
        PrefetchProcess prefetchProcess = this.process;
        if (prefetchProcess == null || (hitState = prefetchProcess.getHitState()) == null) {
            hitState = PrefetchProcess.HitState.FALLBACK;
        }
        response.setCached(hitState.ordinal());
        IPrefetchResultListener iPrefetchResultListener = this.resultListenerRef.get();
        if (iPrefetchResultListener != null) {
            if (iPrefetchResultListener instanceof IPrefetchResultListener.Stub) {
                ((IPrefetchResultListener.Stub) iPrefetchResultListener).onSucceed(response);
            } else {
                iPrefetchResultListener.onSucceed(response.getFormattedJSONObject(false));
            }
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.ProcessListener
    public void onFailed(Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        IPrefetchResultListener iPrefetchResultListener = this.resultListenerRef.get();
        if (iPrefetchResultListener != null) {
            iPrefetchResultListener.onFailed(throwable);
        }
    }
}
