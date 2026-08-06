package com.bytedance.ies.tools.prefetch;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.ies.tools.prefetch.INetworkExecutor;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchMethodStub.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", "", "onFailed", "", LynxError.LYNX_THROWABLE, "", "onSucceed", "result", "Lorg/json/JSONObject;", "Stub", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public interface IPrefetchResultListener {
    void onFailed(Throwable throwable);

    void onSucceed(JSONObject result);

    /* compiled from: PrefetchMethodStub.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener$Stub;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", "()V", "onFailed", "", LynxError.LYNX_THROWABLE, "", "onSucceed", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor$HttpResponse;", "result", "Lorg/json/JSONObject;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public static class Stub implements IPrefetchResultListener {
        @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
        public void onFailed(Throwable throwable) {
            Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
        public void onSucceed(JSONObject result) {
            Intrinsics.checkParameterIsNotNull(result, "result");
        }

        public void onSucceed(INetworkExecutor.HttpResponse response) {
            Intrinsics.checkParameterIsNotNull(response, "response");
            onSucceed(response.getFormattedJSONObject(false));
        }
    }
}
