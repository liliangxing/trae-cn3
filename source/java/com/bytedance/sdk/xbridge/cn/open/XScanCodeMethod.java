package com.bytedance.sdk.xbridge.cn.open;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.open.AbsXScanCodeMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.sdk.xbridge.cn.utils.XBridgeInjectLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XScanCodeMethod.kt */
@XBridgeMethod(name = "x.scanCode")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/open/XScanCodeMethod;", "Lcom/bytedance/sdk/xbridge/cn/open/AbsXScanCodeMethodIDL;", "()V", "methodName", "", "getMethodName", "()Ljava/lang/String;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/open/AbsXScanCodeMethodIDL$XScanCodeParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/open/AbsXScanCodeMethodIDL$XScanCodeResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XScanCodeMethod extends AbsXScanCodeMethodIDL {
    private final String methodName = "x.scanCode";

    public final String getMethodName() {
        return this.methodName;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, AbsXScanCodeMethodIDL.XScanCodeParamModel params, final CompletionBlock<AbsXScanCodeMethodIDL.XScanCodeResultModel> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean cameraOnly = params.getCameraOnly();
        Boolean autoJump = params.getAutoJump();
        XBridgeInjectLogger.m174i(this.methodName, "cameraOnly:" + Boolean.valueOf(cameraOnly) + "|autoJump:" + (autoJump == null ? "null" : autoJump), "BridgeParam", bridgeContext.getContainerID());
        IHostOpenDepend openDependInstance = RuntimeHelper.INSTANCE.getOpenDependInstance(bridgeContext);
        if (openDependInstance != null) {
            openDependInstance.scanCode(bridgeContext, cameraOnly, autoJump, new IHostOpenDepend.IScanResultCallback() { // from class: com.bytedance.sdk.xbridge.cn.open.XScanCodeMethod$handle$1
                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend.IScanResultCallback
                public void onSuccess(String result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    CompletionBlock<AbsXScanCodeMethodIDL.XScanCodeResultModel> completionBlock = callback;
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXScanCodeMethodIDL.XScanCodeResultModel.class));
                    AbsXScanCodeMethodIDL.XScanCodeResultModel xScanCodeResultModel = (AbsXScanCodeMethodIDL.XScanCodeResultModel) createXModel;
                    XBridgeInjectLogger.m174i(this.getMethodName(), "success:true|result:" + result, "BridgeResult", bridgeContext.getContainerID());
                    if (result.length() == 0) {
                        result = "";
                    }
                    xScanCodeResultModel.setResult(result);
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                }

                @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend.IScanResultCallback
                public void onFailure(String msg) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    XBridgeInjectLogger.m174i(this.getMethodName(), "success:false", "BridgeResult", bridgeContext.getContainerID());
                    CompletionBlock.DefaultImpls.onFailure$default(callback, 0, msg, null, 4, null);
                }
            });
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, 0, "openDepend not implemented in host", null, 4, null);
        }
    }
}
