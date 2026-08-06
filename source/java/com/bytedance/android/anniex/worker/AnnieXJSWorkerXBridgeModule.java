package com.bytedance.android.anniex.worker;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.cn.protocol.BridgeResultCallback;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXJSWorkerXBridgeModule.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerXBridgeModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", "context", "Landroid/content/Context;", "params", "", "(Landroid/content/Context;Ljava/lang/Object;)V", "jsWorkerBridge", "Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", NotificationCompat.CATEGORY_CALL, "", "functionName", "", "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "callback", "Lcom/bytedance/vmsdk/jsbridge/utils/Callback;", "Params", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXJSWorkerXBridgeModule extends JSModule {
    private final JSWorkerBDXBridge jsWorkerBridge;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXJSWorkerXBridgeModule(Context context, Object obj) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(obj, "params");
        this.jsWorkerBridge = ((Params) obj).getJsWorkerBridge();
    }

    /* compiled from: AnnieXJSWorkerXBridgeModule.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/worker/AnnieXJSWorkerXBridgeModule$Params;", "", "jsWorkerBridge", "Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", "(Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;)V", "getJsWorkerBridge", "()Lcom/bytedance/android/anniex/worker/JSWorkerBDXBridge;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Params {
        private final JSWorkerBDXBridge jsWorkerBridge;

        public Params(JSWorkerBDXBridge jSWorkerBDXBridge) {
            Intrinsics.checkNotNullParameter(jSWorkerBDXBridge, "jsWorkerBridge");
            this.jsWorkerBridge = jSWorkerBDXBridge;
        }

        public final JSWorkerBDXBridge getJsWorkerBridge() {
            return this.jsWorkerBridge;
        }
    }

    @JSMethod
    public final void call(final String functionName, ReadableMap params, final Callback callback) {
        Object obj;
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Result.Companion companion = Result.Companion;
            AnnieXJSWorkerXBridgeModule annieXJSWorkerXBridgeModule = this;
            final WorkerBridgeCall workerBridgeCall = new WorkerBridgeCall(functionName, params);
            try {
                Result.Companion companion2 = Result.Companion;
                this.jsWorkerBridge.handleCall(workerBridgeCall, new BridgeResultCallback<ReadableMap>(workerBridgeCall, callback, functionName) { // from class: com.bytedance.android.anniex.worker.AnnieXJSWorkerXBridgeModule$call$1$1$1
                    final /* synthetic */ Callback $callback;
                    final /* synthetic */ String $functionName;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(workerBridgeCall);
                        this.$callback = callback;
                        this.$functionName = functionName;
                        Intrinsics.checkNotNull(workerBridgeCall, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<com.bytedance.vmsdk.jsbridge.utils.ReadableMap>");
                    }

                    public void dispatchPlatformInvoke(ReadableMap data) {
                        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
                        try {
                            this.$callback.invoke(new Object[]{data});
                        } catch (Exception e) {
                            HybridLogger.e$default(HybridLogger.INSTANCE, "JSWorkerBDXBridgeHandler", "dispatchPlatformInvoke  " + this.$functionName + " exception:. " + e, (Map) null, (LoggerContext) null, 12, (Object) null);
                        }
                    }
                });
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "JSWorkerBDXBridgeHandler", "handle " + functionName + " exception:. " + th2, (Map) null, (LoggerContext) null, 12, (Object) null);
            }
            Result.constructor-impl(Result.box-impl(obj));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th3));
        }
    }
}
