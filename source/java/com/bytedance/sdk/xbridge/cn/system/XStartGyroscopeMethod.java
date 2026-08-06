package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.idl.AbsXStartGyroscopeMethodIDL;
import com.bytedance.sdk.xbridge.cn.system.utils.HardwareGyroscope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XStartGyroscopeMethod.kt */
@XBridgeMethod(name = "x.startGyroscope")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XStartGyroscopeMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXStartGyroscopeMethodIDL;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "()V", "TAG", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXStartGyroscopeMethodIDL$XStartGyroscopeParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/idl/AbsXStartGyroscopeMethodIDL$XStartGyroscopeResultModel;", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XStartGyroscopeMethod extends AbsXStartGyroscopeMethodIDL implements StatefulMethod {
    private final String TAG = "XStartGyroscopeMethod";

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXStartGyroscopeMethodIDL.XStartGyroscopeParamModel params, CompletionBlock<AbsXStartGyroscopeMethodIDL.XStartGyroscopeResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Number interval = params.getInterval();
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            XBridge.log("obtaining context, but got a null.");
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "context is null!!", null, 4, null);
        } else {
            HardwareGyroscope.INSTANCE.init(ownerActivity, interval.intValue(), bridgeContext, getName());
            callback.onSuccess((XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXStartGyroscopeMethodIDL.XStartGyroscopeResultModel.class)), "start gyroscope execute success.");
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod
    public void release() {
        HardwareGyroscope.INSTANCE.stopGyroscope();
    }
}
