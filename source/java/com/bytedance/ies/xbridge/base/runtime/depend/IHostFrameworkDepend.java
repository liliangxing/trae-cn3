package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IHostFrameworkDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostFrameworkDepend;", "", "addObserverEvent", "", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", ReportConstant.COMMON_ACTION_TYPE, "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "params", "Lorg/json/JSONObject;", "getContainerID", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IHostFrameworkDepend {

    /* compiled from: IHostFrameworkDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void addObserverEvent(IHostFrameworkDepend iHostFrameworkDepend, XContextProviderFactory xContextProviderFactory, String actionType, List<String> eventName, List<? extends JSONObject> params) {
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(params, "params");
        }

        public static String getContainerID(IHostFrameworkDepend iHostFrameworkDepend, XContextProviderFactory xContextProviderFactory) {
            return null;
        }
    }

    void addObserverEvent(XContextProviderFactory contextProviderFactory, String actionType, List<String> eventName, List<? extends JSONObject> params);

    String getContainerID(XContextProviderFactory contextProviderFactory);
}
