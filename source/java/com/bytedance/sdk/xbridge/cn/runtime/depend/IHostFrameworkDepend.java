package com.bytedance.sdk.xbridge.cn.runtime.depend;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IHostFrameworkDepend.kt */
@Deprecated(message = "No need to inject", replaceWith = @ReplaceWith(expression = "this depend is no need to inject", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostFrameworkDepend;", "", "addObserverEvent", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", ReportConstant.COMMON_ACTION_TYPE, "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "params", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostFrameworkDepend {

    /* compiled from: IHostFrameworkDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void addObserverEvent(IHostFrameworkDepend iHostFrameworkDepend, IBDXBridgeContext iBDXBridgeContext, String actionType, List<String> eventName, List<? extends JSONObject> params) {
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
        }
    }

    void addObserverEvent(IBDXBridgeContext bridgeContext, String actionType, List<String> eventName, List<? extends JSONObject> params);
}
