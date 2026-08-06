package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MonitorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/BulletMonitorIntercept;", "", "()V", "onReport", "", "info", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "serviceName", "", "eventType", "containerType", "data", "Lorg/json/JSONObject;", "shouldReportToTea", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "url", "originUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BulletMonitorIntercept {
    public void onReport(ReportInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }

    public void onReport(String serviceName, String eventType, String containerType, JSONObject data) {
    }

    public boolean shouldReportToTea(String eventName, String url, String originUrl) {
        return false;
    }
}
