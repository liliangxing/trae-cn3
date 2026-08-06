package com.bytedance.sdk.xbridge.cn.system;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.idl.AbsXStopGyroscopeMethodIDL;
import com.bytedance.sdk.xbridge.cn.system.utils.HardwareGyroscope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XStopGyroscopeMethod.kt */
@XBridgeMethod(name = "x.stopGyroscope")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XStopGyroscopeMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXStopGyroscopeMethodIDL;", "()V", "TAG", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXStopGyroscopeMethodIDL$XStopGyroscopeParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXStopGyroscopeMethodIDL$XStopGyroscopeResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XStopGyroscopeMethod extends AbsXStopGyroscopeMethodIDL {
    private final String TAG = "XStopGyroscopeMethod";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXStopGyroscopeMethodIDL.XStopGyroscopeParamModel params, CompletionBlock<AbsXStopGyroscopeMethodIDL.XStopGyroscopeResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (bridgeContext.getOwnerActivity() == null) {
            XBridge.log("XStopGyroscopeMethod: obtaining context, but got a null.");
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context is null!!", null, 4, null);
        } else {
            HardwareGyroscope.INSTANCE.stopGyroscope();
            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXStopGyroscopeMethodIDL.XStopGyroscopeResultModel.class)), "stop gyroscope execute success.");
        }
    }
}
