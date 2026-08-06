package com.bytedance.ies.bullet.service.prefetch;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.tools.prefetch.IPrefetchResultListener;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/bytedance/ies/bullet/service/prefetch/PrefetchBridge$handle$listener$1", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener$Stub;", "onFailed", "", "throwable", "", "onSucceed", "result", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchBridge$handle$listener$1 extends IPrefetchResultListener.Stub {
    final /* synthetic */ IBridgeMethod.ICallback $callback;
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ PrefetchService $prefetchService;
    final /* synthetic */ long $startTime;
    final /* synthetic */ PrefetchBridge this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PrefetchBridge$handle$listener$1(IBridgeMethod.ICallback iCallback, PrefetchBridge prefetchBridge, long j, PrefetchService prefetchService, JSONObject jSONObject) {
        this.$callback = iCallback;
        this.this$0 = prefetchBridge;
        this.$startTime = j;
        this.$prefetchService = prefetchService;
        this.$params = jSONObject;
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener.Stub, com.bytedance.ies.tools.prefetch.IPrefetchResultListener
    public void onSucceed(JSONObject result) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 1);
        jSONObject.put("data", result);
        this.$callback.onComplete(jSONObject);
        copyOnWriteArraySet = this.this$0.mStrongRefContainer;
        copyOnWriteArraySet.remove(this);
        long currentTimeMillis = System.currentTimeMillis() - this.$startTime;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "__prefetch success cost " + currentTimeMillis + " ms", null, "XPrefetch", 2, null);
        this.this$0.reportSuccess(this.$prefetchService, this.$params, result, currentTimeMillis);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener.Stub, com.bytedance.ies.tools.prefetch.IPrefetchResultListener
    public void onFailed(Throwable throwable) {
        CopyOnWriteArraySet copyOnWriteArraySet;
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            PrefetchBridge$handle$listener$1 prefetchBridge$handle$listener$1 = this;
            if (throwable instanceof HttpResponseException) {
                jSONObject.put("status", ((HttpResponseException) throwable).getStatusCode());
            } else if (throwable instanceof CronetIOException) {
                jSONObject.put("status", ((CronetIOException) throwable).getStatusCode());
            }
            Result.constructor-impl(jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, throwable instanceof NetworkNotAvailabeException ? -106 : 1001));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        IBridgeMethod.ICallback iCallback = this.$callback;
        String message = throwable.getMessage();
        if (message == null) {
            message = "";
        }
        iCallback.onError(4, message, jSONObject);
        copyOnWriteArraySet = this.this$0.mStrongRefContainer;
        copyOnWriteArraySet.remove(this);
        long currentTimeMillis = System.currentTimeMillis() - this.$startTime;
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "__prefetch failed cost " + currentTimeMillis + " ms", null, "XPrefetch", 2, null);
        this.this$0.reportFail(this.$prefetchService, this.$params, throwable, currentTimeMillis);
    }
}
