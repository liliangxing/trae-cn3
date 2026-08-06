package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.os.Vibrator;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.AbsXStopVibrateMethodIDL;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XStopVibrateMethod.kt */
@XBridgeMethod(name = "x.stopVibrate")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XStopVibrateMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXStopVibrateMethodIDL;", "()V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXStopVibrateMethodIDL$XStopVibrateParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXStopVibrateMethodIDL$XStopVibrateResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XStopVibrateMethod extends AbsXStopVibrateMethodIDL {
    private final String methodName = "x.stopVibrate";

    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXStopVibrateMethodIDL.XStopVibrateParamModel params, CompletionBlock<AbsXStopVibrateMethodIDL.XStopVibrateResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String containerID = bridgeContext.getContainerID();
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        XBridgeInjectLogger.m174i(this.methodName, "context:" + (ownerActivity == null ? "null" : ownerActivity), "BridgeParam", containerID);
        if (ownerActivity == null) {
            XBridge.log("Context is null");
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Context is null.", null, 4, null);
            return;
        }
        try {
            Object systemService = ownerActivity.getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            ((Vibrator) systemService).cancel();
            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXStopVibrateMethodIDL.XStopVibrateResultModel.class)), "stop vibrate execute success.");
            XBridgeInjectLogger.m174i(this.methodName, "message:stop vibrate execute success", "BridgeResult", containerID);
        } catch (Exception e) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "Can not get vibrate service.", null, 4, null);
            XBridgeInjectLogger.m174i(this.methodName, "stop vibrate err:" + e.getMessage(), "BridgeResult", containerID);
        }
    }
}
