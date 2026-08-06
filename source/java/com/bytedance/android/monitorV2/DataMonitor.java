package com.bytedance.android.monitorV2;

import com.bytedance.android.monitorV2.base.IMonitor;
import com.bytedance.android.monitorV2.base.IReportData;
import com.bytedance.android.monitorV2.webview.IHybridMonitor;

@Deprecated
/* loaded from: classes3.dex */
public class DataMonitor implements IMonitor {
    public static final String SERVICE = "bd_hybrid_monitor_service_all_in_one";
    private static final String TAG = "DataMonitor";
    protected IHybridMonitor monitor;

    public static void monitor(IReportData iReportData, IHybridMonitor iHybridMonitor) {
    }

    @Override // com.bytedance.android.monitorV2.base.IMonitor
    public void monitor(IReportData iReportData) {
    }

    public DataMonitor(IHybridMonitor iHybridMonitor) {
        this.monitor = iHybridMonitor;
    }
}
