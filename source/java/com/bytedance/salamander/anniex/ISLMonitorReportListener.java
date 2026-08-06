package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: AnniexMonitorCoreISLMonitorReportListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\b2\u0006\u0010\t\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/ISLMonitorReportListener;", "", "onEventReport", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "params", "", "Lcom/bytedance/rts/foundation/RTSMap;", "eventStatus", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISLMonitorReportListener {
    void onEventReport(String eventName, Map<String, Object> params, String eventStatus);
}
