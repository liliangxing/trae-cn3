package com.bytedance.common.wschannel.heartbeat.normal;

import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* loaded from: classes3.dex */
public class NormalHeartBeatMeta implements IHeartBeatMeta<NormalHeartBeatMeta> {
    public static final long DEFAULT_PING_INTERVAL = 270000;
    private long pingInterval;
    private long timeout;

    public NormalHeartBeatMeta() {
    }

    public NormalHeartBeatMeta(long j, long j2) {
        this.pingInterval = j;
        this.timeout = j2;
    }

    public long getPingInterval() {
        return this.pingInterval;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPingInterval(long j) {
        this.pingInterval = j;
    }

    public long getTimeout() {
        return this.timeout;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
    public NormalHeartBeatMeta provideDefaultMeta() {
        return new DefaultNormalHeartBeatMeta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DefaultNormalHeartBeatMeta extends NormalHeartBeatMeta {
        private static final long DEFAULT_PING_INTERVAL = -1;
        private static final long DEFAULT_TIMEOUT = 5000;

        @Override // com.bytedance.common.wschannel.heartbeat.normal.NormalHeartBeatMeta, com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta
        public /* bridge */ /* synthetic */ NormalHeartBeatMeta provideDefaultMeta() {
            return super.provideDefaultMeta();
        }

        private DefaultNormalHeartBeatMeta() {
            super(-1L, 5000L);
        }
    }
}
