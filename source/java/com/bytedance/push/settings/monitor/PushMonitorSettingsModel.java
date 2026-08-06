package com.bytedance.push.settings.monitor;

import com.bytedance.common.push.BaseJson;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PushMonitorSettingsModel extends BaseJson {

    @SerializedName("depths_process_start_monitor_model")
    public DepthsProcessStartMonitorModel depthsProcessStartMonitorModel;

    @SerializedName("enable_badge_apply_monitor")
    public boolean enableBadgeApplyMonitor;

    @SerializedName("enable_content_request_monitor")
    public boolean enableContentRequestMonitor;

    @SerializedName("enable_content_show_monitor")
    public boolean enableContentShowMonitor;

    @SerializedName("enable_dau_monitor")
    public boolean enableDauMonitor;

    @SerializedName("enable_keep_alive_from_monitor")
    public boolean enableKeepAliveFromMonitor;

    @SerializedName("enable_message_show_monitor")
    public boolean enableMessageShowMonitor;

    @SerializedName("enable_network_request_monitor")
    public boolean enableNetworkRequestMonitor;

    @SerializedName("enable_push_launch_monitor")
    public boolean enablePushLaunchMonitor;

    @SerializedName("enable_real_badge_set_monitor")
    public boolean enableRealBadgeNumSetResultMonitor;

    @SerializedName("enable_transmit_strategy_request_monitor")
    public boolean enableTransmitStrategyRequestMonitor;

    public PushMonitorSettingsModel() {
        init();
    }

    private void init() {
        this.enableBadgeApplyMonitor = false;
        this.depthsProcessStartMonitorModel = new DepthsProcessStartMonitorModel();
    }
}
