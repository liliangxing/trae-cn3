package com.bytedance.android.monitor.webview;

import com.bytedance.android.monitor.util.ExceptionUtil;
import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTLiveWebViewMonitorDefault implements ITTLiveWebViewMonitor {
    private static final String TAG = "WebViewMonitorDefault";

    public TTLiveWebViewMonitorDefault() {
    }

    @Deprecated
    public TTLiveWebViewMonitorDefault(String str) {
    }

    @Override // com.bytedance.android.monitor.webview.ITTLiveWebViewMonitor
    public void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            ApmAgent.monitorEvent(str, null, null, jSONObject2);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }
}
