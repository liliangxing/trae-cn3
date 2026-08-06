package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DeviceClickAcceptanceGate;", "", "minIntervalMillis", "", "<init>", "(J)V", "lastAcceptedAtMillis", "Ljava/lang/Long;", "tryAcquire", "", "nowMillis", "release", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeviceClickAcceptanceGate {
    private Long lastAcceptedAtMillis;
    private final long minIntervalMillis;

    public DeviceClickAcceptanceGate(long j) {
        this.minIntervalMillis = j;
    }

    public final synchronized boolean tryAcquire(long nowMillis) {
        Long l = this.lastAcceptedAtMillis;
        if (l != null && nowMillis >= l.longValue() && nowMillis - l.longValue() < this.minIntervalMillis) {
            return false;
        }
        this.lastAcceptedAtMillis = Long.valueOf(nowMillis);
        return true;
    }

    public final synchronized void release() {
        this.lastAcceptedAtMillis = null;
    }
}
