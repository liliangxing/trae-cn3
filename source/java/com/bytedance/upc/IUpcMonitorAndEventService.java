package com.bytedance.upc;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IUpcMonitorAndEventService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J4\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007H&¨\u0006\r"}, d2 = {"Lcom/bytedance/upc/IUpcMonitorAndEventService;", "", "event", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", RemoteMessageConst.MessageBody.PARAM, "Lorg/json/JSONObject;", "monitor", "serviceName", "category", "metric", "logExtra", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcMonitorAndEventService {
    void event(String eventName, JSONObject param);

    void monitor(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra);

    /* compiled from: IUpcMonitorAndEventService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void monitor$default(IUpcMonitorAndEventService iUpcMonitorAndEventService, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
            }
            if ((i & 2) != 0) {
                jSONObject = null;
            }
            if ((i & 4) != 0) {
                jSONObject2 = null;
            }
            if ((i & 8) != 0) {
                jSONObject3 = null;
            }
            iUpcMonitorAndEventService.monitor(str, jSONObject, jSONObject2, jSONObject3);
        }
    }
}
