package com.bytedance.android.anniex.worker;

import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.protocol.BDXBridge;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeCallInterceptor;
import com.bytedance.sdk.xbridge.cn.protocol.IBridgeInterceptorCallback;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSWorkerBDXBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u001cH\u0016J(\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"H\u0016J\u0015\u0010$\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b%R\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", "Lcom/bytedance/sdk/xbridge/cn/protocol/BDXBridge;", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "context", "Landroid/content/Context;", "containerID", "", "(Landroid/content/Context;Ljava/lang/String;)V", "bridgeHandler", "Lcom/bytedance/android/anniex/worker/WorkerReadableMapBridgeHandler;", "getBridgeHandler", "()Lcom/bytedance/android/anniex/worker/WorkerReadableMapBridgeHandler;", "bridgeHandler$delegate", "Lkotlin/Lazy;", "getContainerID", "()Ljava/lang/String;", "jsWorker", "Lcom/bytedance/android/anniex/worker/AnnieXJSWorker;", "workerBridgeContext", "Lcom/bytedance/android/anniex/worker/WorkerBridgeContext;", "getBridgeCallInterceptor", "Lcom/bytedance/sdk/xbridge/cn/protocol/IBridgeCallInterceptor;", "getThreadType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", NotificationCompat.CATEGORY_CALL, "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "init", "", "init$anniex_release", "onRelease", "sendJSEvent", "eventName", "params", "", "", "setAnnieXJSWorker", "setAnnieXJSWorker$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class JSWorkerBDXBridge extends BDXBridge<ReadableMap, ReadableMap> implements JSEventDelegate {

    /* renamed from: bridgeHandler$delegate, reason: from kotlin metadata */
    private final Lazy bridgeHandler;
    private final String containerID;
    private AnnieXJSWorker jsWorker;
    private WorkerBridgeContext workerBridgeContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSWorkerBDXBridge(Context context, String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "containerID");
        this.containerID = str;
        this.bridgeHandler = LazyKt.lazy(new Function0<WorkerReadableMapBridgeHandler>() { // from class: com.bytedance.android.anniex.worker.JSWorkerBDXBridge$bridgeHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WorkerReadableMapBridgeHandler m3466invoke() {
                return new WorkerReadableMapBridgeHandler();
            }
        });
        this.workerBridgeContext = new WorkerBridgeContext(str, new View(context), context, this, null, 16, null);
    }

    public final String getContainerID() {
        return this.containerID;
    }

    public final void setAnnieXJSWorker$anniex_release(AnnieXJSWorker jsWorker) {
        Intrinsics.checkNotNullParameter(jsWorker, "jsWorker");
        this.jsWorker = jsWorker;
    }

    public void sendJSEvent(String eventName, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        AnnieXJSWorker annieXJSWorker = this.jsWorker;
        if (annieXJSWorker != null) {
            annieXJSWorker.postMessage$anniex_release(eventName, params);
        }
    }

    /* renamed from: getBridgeHandler, reason: merged with bridge method [inline-methods] */
    public WorkerReadableMapBridgeHandler m3465getBridgeHandler() {
        return (WorkerReadableMapBridgeHandler) this.bridgeHandler.getValue();
    }

    public IDLXBridgeMethod.XBridgeThreadType getThreadType(BaseBridgeCall<ReadableMap> call) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        return IDLXBridgeMethod.XBridgeThreadType.ASYNC_THREAD;
    }

    public final void init$anniex_release() {
        super.initialize(this.workerBridgeContext);
    }

    public void onRelease() {
        this.workerBridgeContext.release();
    }

    public IBridgeCallInterceptor<ReadableMap, ReadableMap> getBridgeCallInterceptor() {
        return new IBridgeCallInterceptor<ReadableMap, ReadableMap>() { // from class: com.bytedance.android.anniex.worker.JSWorkerBDXBridge$getBridgeCallInterceptor$1
            public boolean intercept(BaseBridgeCall<ReadableMap> call, IBDXBridgeContext bridgeContext, IBridgeInterceptorCallback<ReadableMap> callBack) {
                Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
                Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
                return false;
            }
        };
    }
}
