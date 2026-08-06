package com.bytedance.upc.bridge.impl;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.upc.common.monitor.UpcMonitor;
import com.bytedance.upc.web.bridge.abs.AbsMonitorMethodIDL;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorMethodIDLImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/bridge/impl/MonitorMethodIDLImpl;", "Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL;", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$MonitorParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/upc/web/bridge/abs/AbsMonitorMethodIDL$MonitorResultModel;", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class MonitorMethodIDLImpl extends AbsMonitorMethodIDL {
    public /* bridge */ /* synthetic */ void handle(IBDXBridgeContext iBDXBridgeContext, XBaseParamModel xBaseParamModel, CompletionBlock completionBlock) {
        handle(iBDXBridgeContext, (AbsMonitorMethodIDL.MonitorParamModel) xBaseParamModel, (CompletionBlock<AbsMonitorMethodIDL.MonitorResultModel>) completionBlock);
    }

    public void handle(IBDXBridgeContext bridgeContext, AbsMonitorMethodIDL.MonitorParamModel params, CompletionBlock<AbsMonitorMethodIDL.MonitorResultModel> callback) {
        Intrinsics.checkParameterIsNotNull(bridgeContext, "bridgeContext");
        Intrinsics.checkParameterIsNotNull(params, "params");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        String serviceName = params.getServiceName();
        Object category = params.getCategory();
        if (category == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        JSONObject jSONObject = (JSONObject) category;
        Object metric = params.getMetric();
        if (metric == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        JSONObject jSONObject2 = (JSONObject) metric;
        Object logExtra = params.getLogExtra();
        if (logExtra == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
        }
        UpcMonitor.monitor(serviceName, jSONObject, jSONObject2, (JSONObject) logExtra);
    }
}
