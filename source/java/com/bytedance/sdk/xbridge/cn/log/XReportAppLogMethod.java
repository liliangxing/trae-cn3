package com.bytedance.sdk.xbridge.cn.log;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.log.AbsXReportAppLogMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: XReportAppLogMethod.kt */
@XBridgeMethod(name = "x.reportAppLog")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/log/XReportAppLogMethod;", "Lcom/bytedance/sdk/xbridge/cn/log/AbsXReportAppLogMethodIDL;", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/log/AbsXReportAppLogMethodIDL$XReportAppLogParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/log/AbsXReportAppLogMethodIDL$XReportAppLogResultModel;", "toStringOrJson", "", "data", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XReportAppLogMethod extends AbsXReportAppLogMethodIDL {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    public final String toStringOrJson(Object data) {
        if (data == null) {
            return "";
        }
        if (data instanceof Map) {
            String jSONObject = new JSONObject((Map) data).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(data).toString()");
            return jSONObject;
        }
        if (!(data instanceof List)) {
            return data.toString();
        }
        String jSONArray = new JSONArray((Collection) data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "JSONArray(data).toString()");
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[Catch: NullPointerException -> 0x0090, TRY_LEAVE, TryCatch #0 {NullPointerException -> 0x0090, blocks: (B:3:0x000f, B:5:0x0017, B:10:0x0023), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handle(IBDXBridgeContext bridgeContext, AbsXReportAppLogMethodIDL.XReportAppLogParamModel params, CompletionBlock<AbsXReportAppLogMethodIDL.XReportAppLogResultModel> callback) {
        boolean z;
        Iterator<Map.Entry<String, Object>> it;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            String eventName = params.getEventName();
            if (eventName != null && eventName.length() != 0) {
                z = false;
                if (!z) {
                    CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                    return;
                }
                String eventName2 = params.getEventName();
                Map<String, Object> params2 = params.getParams();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (params2 != null && (it = params2.entrySet().iterator()) != null) {
                    while (it.hasNext()) {
                        String key = it.next().getKey();
                    }
                }
                IHostLogDepend logDependInstance = RuntimeHelper.INSTANCE.getLogDependInstance(bridgeContext);
                if (logDependInstance != null) {
                    if (logDependInstance instanceof IHostLogDependV2) {
                        ((IHostLogDependV2) logDependInstance).onEventV3Map(eventName2, linkedHashMap, bridgeContext);
                    } else {
                        logDependInstance.onEventV3Map(eventName2, linkedHashMap);
                    }
                }
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXReportAppLogMethodIDL.XReportAppLogResultModel.class)), null, 2, null);
                return;
            }
            z = true;
            if (!z) {
            }
        } catch (NullPointerException unused) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
        }
    }
}
