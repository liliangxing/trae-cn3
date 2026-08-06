package com.bytedance.common.push.interfaze;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IEventReportListener {

    /* loaded from: classes3.dex */
    public interface IEventReportCallback {
        List<String> needMonitorEventList();

        void onEvent(String str, JSONObject jSONObject);
    }

    void registerEventReportCallback(IEventReportCallback iEventReportCallback);
}
