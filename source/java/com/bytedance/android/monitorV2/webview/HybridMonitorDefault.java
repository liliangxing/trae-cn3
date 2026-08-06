package com.bytedance.android.monitorV2.webview;

import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes3.dex */
public class HybridMonitorDefault implements IHybridMonitor {
    private static final String TAG = "WebViewMonitorDefault";

    public HybridMonitorDefault() {
    }

    @Deprecated
    public HybridMonitorDefault(String str) {
    }

    @Override // com.bytedance.android.monitorV2.webview.IHybridMonitor
    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            ApmAgent.monitorEvent(str, null, null, jSONObject2);
            MonitorLog.i(TAG, "apm upload: " + str);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }
}
