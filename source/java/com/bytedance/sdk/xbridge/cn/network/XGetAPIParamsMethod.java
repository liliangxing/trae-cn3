package com.bytedance.sdk.xbridge.cn.network;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.MethodModelBean;
import com.bytedance.sdk.xbridge.cn.XBridgeDynamicModel;
import com.bytedance.sdk.xbridge.cn.network.AbsXGetAPIParamsMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XGetAPIParamsMethod.kt */
@XBridgeMethod(name = "x.getAPIParams")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/network/XGetAPIParamsMethod;", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXGetAPIParamsMethodIDL;", "()V", "getNetworkDependInstance", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostNetworkDepend;", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXGetAPIParamsMethodIDL$XGetAPIParamsParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/network/AbsXGetAPIParamsMethodIDL$XGetAPIParamsResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetAPIParamsMethod extends AbsXGetAPIParamsMethodIDL {
    /* JADX WARN: Multi-variable type inference failed */
    public XGetAPIParamsMethod() {
        XBridgeDynamicModel.INSTANCE.addMethodModelMap(getClass(), new MethodModelBean(AbsXGetAPIParamsMethodIDL.XGetAPIParamsParamModel.class, AbsXGetAPIParamsMethodIDL.XGetAPIParamsResultModel.class));
    }

    private final IHostNetworkDepend getNetworkDependInstance() {
        return XBaseRuntime.INSTANCE.getHostNetworkDepend();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXGetAPIParamsMethodIDL.XGetAPIParamsParamModel params, CompletionBlock<AbsXGetAPIParamsMethodIDL.XGetAPIParamsResultModel> callback) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetAPIParamsMethodIDL.XGetAPIParamsResultModel.class));
        AbsXGetAPIParamsMethodIDL.XGetAPIParamsResultModel xGetAPIParamsResultModel = (AbsXGetAPIParamsMethodIDL.XGetAPIParamsResultModel) createXModel;
        IHostNetworkDepend networkDependInstance = getNetworkDependInstance();
        if (networkDependInstance == null || (linkedHashMap = networkDependInstance.getAPIParams()) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        xGetAPIParamsResultModel.setApiParams(linkedHashMap);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
    }
}
