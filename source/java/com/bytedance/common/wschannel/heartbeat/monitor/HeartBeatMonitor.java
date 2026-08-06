package com.bytedance.common.wschannel.heartbeat.monitor;

/* loaded from: classes3.dex */
public class HeartBeatMonitor implements IHeartBeatMonitor {
    private IHeartBeatMonitor heartBeatMonitor;

    private HeartBeatMonitor() {
    }

    /* loaded from: classes3.dex */
    private static final class SingletonHolder {
        private static final HeartBeatMonitor instance = new HeartBeatMonitor();

        private SingletonHolder() {
        }
    }

    public static HeartBeatMonitor getInstance() {
        return SingletonHolder.instance;
    }

    public void setHeartBeatMonitor(IHeartBeatMonitor iHeartBeatMonitor) {
        this.heartBeatMonitor = iHeartBeatMonitor;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingSuccess() {
        IHeartBeatMonitor iHeartBeatMonitor = this.heartBeatMonitor;
        if (iHeartBeatMonitor != null) {
            iHeartBeatMonitor.onPingSuccess();
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingTimeout() {
        IHeartBeatMonitor iHeartBeatMonitor = this.heartBeatMonitor;
        if (iHeartBeatMonitor != null) {
            iHeartBeatMonitor.onPingTimeout();
        }
    }

    @Override // com.bytedance.common.wschannel.heartbeat.monitor.IHeartBeatMonitor
    public void onPingFail(Throwable th) {
        IHeartBeatMonitor iHeartBeatMonitor = this.heartBeatMonitor;
        if (iHeartBeatMonitor != null) {
            iHeartBeatMonitor.onPingFail(th);
        }
    }
}
