package com.bytedance.android.monitorV2;

import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.webview.HybridMonitorDefault;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;

@Deprecated
/* loaded from: classes3.dex */
public class CustomMonitor {
    private static final String TAG = "CustomMonitor";
    private IHybridMonitor defaultMonitor = new HybridMonitorDefault();

    @Deprecated
    public void setMonitor(IHybridMonitor iHybridMonitor) {
        this.defaultMonitor = iHybridMonitor;
        MonitorLog.e(TAG, "Deprecated method: use new Monitor: " + iHybridMonitor);
    }

    @Deprecated
    public IHybridMonitor getMonitor() {
        return this.defaultMonitor;
    }
}
