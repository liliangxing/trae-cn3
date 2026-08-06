package com.bytedance.push.settings.monitor;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class DepthsProcessStartMonitorModel {

    @SerializedName("enable_monitor_all_process")
    public boolean enableMonitorAllProcess;

    @SerializedName("enable_monitor_foreground_process")
    public boolean enableMonitorForegroundProcess;

    @SerializedName("enable_process_start_monitor")
    public boolean enableProcessStartMonitor;
}
