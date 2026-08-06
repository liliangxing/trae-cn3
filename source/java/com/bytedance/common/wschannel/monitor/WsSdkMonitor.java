package com.bytedance.common.wschannel.monitor;

import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;

/* loaded from: classes3.dex */
public class WsSdkMonitor {
    public WsSdkMonitor(IWsSdkMonitor iWsSdkMonitor) {
        HeartBeatMonitor.getInstance().setHeartBeatMonitor(iWsSdkMonitor);
    }
}
