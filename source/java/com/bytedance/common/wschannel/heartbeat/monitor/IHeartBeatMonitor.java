package com.bytedance.common.wschannel.heartbeat.monitor;

/* loaded from: classes3.dex */
public interface IHeartBeatMonitor {
    void onPingFail(Throwable th);

    void onPingSuccess();

    void onPingTimeout();
}
