package com.bytedance.common.wschannel.heartbeat.smart;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.smart.state.StateType;

/* loaded from: classes3.dex */
public class SmartHeartBeatMeta implements IHeartBeatMeta<SmartHeartBeatMeta> {
    private long currentPingInterval;
    private int maxPingFailCount;
    private long maxPingInterval;
    private long minPingInterval;
    private int netStableTestCount;
    private long pingStep;
    private long pingTimeOut;
    private long plumbPingInterval;
    private StateType previousState;
    private long successStep;

    public SmartHeartBeatMeta() {
    }

    public SmartHeartBeatMeta(long j, long j2, int i, int i2, long j3, long j4, long j5) {
        this.minPingInterval = j;
        this.maxPingInterval = j2;
        this.maxPingFailCount = i;
        this.netStableTestCount = i2;
        this.pingStep = j3;
        this.successStep = j4;
        this.pingTimeOut = j5;
        this.plumbPingInterval = j;
        this.currentPingInterval = j;
    }

    public long getMinPingInterval() {
        return this.minPingInterval;
    }

    public long getMaxPingInterval() {
        return this.maxPingInterval;
    }

    public int getMaxPingFailCount() {
        return this.maxPingFailCount;
    }

    public int getNetStableTestCount() {
        return this.netStableTestCount;
    }

    public long getPingStep() {
        return this.pingStep;
    }

    public long getSuccessStep() {
        return this.successStep;
    }

    public long getPingTimeOut() {
        return this.pingTimeOut;
    }

    public long getPlumbPingInterval() {
        return this.plumbPingInterval;
    }

    public void setPlumbPingInterval(long j) {
        this.plumbPingInterval = j;
    }

    public StateType getPreviousState() {
        return this.previousState;
    }

    public void setPreviousState(StateType stateType) {
        this.previousState = stateType;
    }

    public long getCurrentPingInterval() {
        return this.currentPingInterval;
    }

    public void setCurrentPingInterval(long j) {
        this.currentPingInterval = j;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public SmartHeartBeatMeta provideDefaultMeta() {
        return new DefaultSmartHeartBeatMeta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DefaultSmartHeartBeatMeta extends SmartHeartBeatMeta {
        private static final int MAX_PING_FAIL_COUNT = 2;
        private static final long MAX_PING_INTERVAL = 600000;
        private static final long MIN_PING_INTERVAL = 210000;
        private static final int NET_STABLE_TEST_COUNT = 3;
        private static final long PING_STEP = 60000;
        private static final long PING_TIMEOUT = 5000;
        private static final long SUCCESS_STEP = 20000;

        @Override // com.bytedance.common.wschannel.heartbeat.smart.SmartHeartBeatMeta, com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
        public /* bridge */ /* synthetic */ SmartHeartBeatMeta provideDefaultMeta() {
            return super.provideDefaultMeta();
        }

        public DefaultSmartHeartBeatMeta() {
            super(MIN_PING_INTERVAL, 600000L, 2, 3, 60000L, 20000L, 5000L);
        }
    }
}
