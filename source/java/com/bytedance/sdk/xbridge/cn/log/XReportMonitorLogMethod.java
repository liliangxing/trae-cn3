package com.bytedance.sdk.xbridge.cn.log;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.log.AbsXReportMonitorLogMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.internal.TracingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: XReportMonitorLogMethod.kt */
@XBridgeMethod(name = "x.reportMonitorLog")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\"\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/log/XReportMonitorLogMethod;", "Lcom/bytedance/sdk/xbridge/cn/log/AbsXReportMonitorLogMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/log/AbsXReportMonitorLogMethodIDL$XReportMonitorLogParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/log/AbsXReportMonitorLogMethodIDL$XReportMonitorLogResultModel;", "monitorCommonLog", "logType", "", "serviceName", "logExtra", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XReportMonitorLogMethod extends AbsXReportMonitorLogMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXReportMonitorLogMethodIDL.XReportMonitorLogParamModel params, CompletionBlock<AbsXReportMonitorLogMethodIDL.XReportMonitorLogResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            if ((params.getLogType().length() == 0) || params.getStatus() == null || params.getValue() == null) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            }
            String logType = params.getLogType();
            String service = params.getService();
            if (service == null) {
                service = "";
            }
            Number status = params.getStatus();
            Integer valueOf = status != null ? Integer.valueOf(status.intValue()) : null;
            if (Intrinsics.areEqual("service_monitor", logType)) {
                if (service.length() == 0) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, -3, "service is required while log_type=" + logType, null, 4, null);
                    return;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PageDataManager.EXTRA_STATUS, valueOf);
            jSONObject.put("value", new JSONObject(params.getValue()));
            monitorCommonLog(logType, service, jSONObject);
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXReportMonitorLogMethodIDL.XReportMonitorLogResultModel.class)), null, 2, null);
        } catch (NullPointerException unused) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
        }
    }

    private final void monitorCommonLog(String logType, String serviceName, JSONObject logExtra) {
        try {
            if (serviceName.length() > 0) {
                logExtra.put(TracingConstants.KEY_TRACE_NAME, serviceName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MonitorUtils.monitorCommonLog(logType, logExtra);
    }
}
