package com.bytedance.sdk.xbridge.cn.route;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.route.idl.AbsXCloseMethodIDL;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: XCloseMethod.kt */
@XBridgeMethod(name = "x.close")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/route/XCloseMethod;", "Lcom/bytedance/sdk/xbridge/cn/route/idl/AbsXCloseMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/route/idl/AbsXCloseMethodIDL$XCloseParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/route/idl/AbsXCloseMethodIDL$XCloseResultModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XCloseMethod extends AbsXCloseMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXCloseMethodIDL.XCloseParamModel params, CompletionBlock<AbsXCloseMethodIDL.XCloseResultModel> callback) {
        Object valueOf;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String containerID = params.getContainerID();
        List<String> containerIDs = params.getContainerIDs();
        boolean animated = params.getAnimated();
        String containerID2 = bridgeContext.getContainerID();
        LoggerContext loggerContext = new LoggerContext();
        loggerContext.pushStage("session_id", containerID2);
        HybridLogger hybridLogger = HybridLogger.INSTANCE;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("method", getName());
        pairArr[1] = TuplesKt.to("containerID", containerID == null ? "null" : containerID);
        pairArr[2] = TuplesKt.to("containerIDs", containerIDs != null ? containerIDs : "null");
        pairArr[3] = TuplesKt.to("animated", Boolean.valueOf(animated));
        pairArr[4] = TuplesKt.to("curSession", containerID2);
        hybridLogger.i("BridgeParam", "x.closeParam", MapsKt.mapOf(pairArr), loggerContext);
        if (containerIDs == null || !(!containerIDs.isEmpty())) {
            IHostRouterDepend routerDependInstance = RuntimeHelper.INSTANCE.getRouterDependInstance();
            valueOf = routerDependInstance != null ? Boolean.valueOf(routerDependInstance.closeView(bridgeContext, containerID, animated)) : null;
        } else {
            loop0: while (true) {
                for (String str : containerIDs) {
                    IHostRouterDepend routerDependInstance2 = RuntimeHelper.INSTANCE.getRouterDependInstance();
                    valueOf = routerDependInstance2 != null ? Boolean.valueOf(routerDependInstance2.closeView(bridgeContext, str, animated)) : null;
                }
            }
        }
        AbsXCloseMethodIDL.XCloseResultModel xCloseResultModel = (AbsXCloseMethodIDL.XCloseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXCloseMethodIDL.XCloseResultModel.class));
        HybridLogger hybridLogger2 = HybridLogger.INSTANCE;
        Pair[] pairArr2 = new Pair[3];
        pairArr2[0] = TuplesKt.to("method", getName());
        if (valueOf == null) {
            valueOf = "unknown";
        }
        pairArr2[1] = TuplesKt.to("closeSuccess", valueOf);
        pairArr2[2] = TuplesKt.to("callback", String.valueOf(xCloseResultModel.convert()));
        hybridLogger2.i("BridgeResult", "x.closeResult", MapsKt.mapOf(pairArr2), loggerContext);
        CompletionBlock.DefaultImpls.onSuccess$default(callback, xCloseResultModel, null, 2, null);
    }
}
