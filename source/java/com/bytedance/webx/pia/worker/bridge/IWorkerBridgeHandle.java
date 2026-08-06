package com.bytedance.webx.pia.worker.bridge;

import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IWorkerBridgeHandle.kt */
@Deprecated(message = "legacy usage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J4\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/webx/pia/worker/bridge/IWorkerBridgeHandle;", "", WebViewContainer.EVENT_destroy, "", "initialize", "worker", "Lcom/bytedance/pia/core/worker/Worker;", "onWorkerBridgeCall", "url", "", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "params", "Lorg/json/JSONObject;", "callback", "Lkotlin/Function1;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IWorkerBridgeHandle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: IWorkerBridgeHandle.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class DefaultImpls {
        public static void destroy(IWorkerBridgeHandle iWorkerBridgeHandle) {
        }

        public static void initialize(IWorkerBridgeHandle iWorkerBridgeHandle, Worker worker) {
        }
    }

    void destroy();

    void initialize(Worker worker);

    void onWorkerBridgeCall(String url, String name, JSONObject params, Function1<? super JSONObject, Unit> callback);

    /* compiled from: IWorkerBridgeHandle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/webx/pia/worker/bridge/IWorkerBridgeHandle$Companion;", "", "()V", "DefaultInstance", "Lcom/bytedance/webx/pia/worker/bridge/IWorkerBridgeHandle;", "getDefaultInstance", "()Lcom/bytedance/webx/pia/worker/bridge/IWorkerBridgeHandle;", "DefaultHandle", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IWorkerBridgeHandle DefaultInstance = new DefaultHandle();

        /* compiled from: IWorkerBridgeHandle.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/webx/pia/worker/bridge/IWorkerBridgeHandle$Companion$DefaultHandle;", "Lcom/bytedance/webx/pia/worker/bridge/IWorkerBridgeHandle;", "()V", "onWorkerBridgeCall", "", "url", "", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "params", "Lorg/json/JSONObject;", "callback", "Lkotlin/Function1;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        private static final class DefaultHandle implements IWorkerBridgeHandle {
            @Override // com.bytedance.webx.pia.worker.bridge.IWorkerBridgeHandle
            public void destroy() {
                DefaultImpls.destroy(this);
            }

            @Override // com.bytedance.webx.pia.worker.bridge.IWorkerBridgeHandle
            public void initialize(Worker worker) {
                DefaultImpls.initialize(this, worker);
            }

            @Override // com.bytedance.webx.pia.worker.bridge.IWorkerBridgeHandle
            public void onWorkerBridgeCall(String url, String name, JSONObject params, Function1<? super JSONObject, Unit> callback) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
                Intrinsics.checkNotNullParameter(params, "params");
                Intrinsics.checkNotNullParameter(callback, "callback");
                Logger.w$default("A not-implemented bridge was called: " + name, (Throwable) null, (String) null, 6, (Object) null);
                callback.invoke(new JSONObject());
            }
        }

        private Companion() {
        }

        public final IWorkerBridgeHandle getDefaultInstance() {
            return DefaultInstance;
        }
    }
}
