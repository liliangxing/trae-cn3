package com.bytedance.trae.network;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SseConfig.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/network/SseConfig;", "", "heartbeatTimeoutMs", "", "reconnectBaseMs", "reconnectMaxMs", "reconnectJitterMs", "maxConsecutiveFailures", "", "<init>", "(JJJJI)V", "getHeartbeatTimeoutMs", "()J", "getReconnectBaseMs", "getReconnectMaxMs", "getReconnectJitterMs", "getMaxConsecutiveFailures", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SseConfig {
    private final long heartbeatTimeoutMs;
    private final int maxConsecutiveFailures;
    private final long reconnectBaseMs;
    private final long reconnectJitterMs;
    private final long reconnectMaxMs;

    public SseConfig() {
        this(0L, 0L, 0L, 0L, 0, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getHeartbeatTimeoutMs() {
        return this.heartbeatTimeoutMs;
    }

    /* renamed from: component2, reason: from getter */
    public final long getReconnectBaseMs() {
        return this.reconnectBaseMs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getReconnectMaxMs() {
        return this.reconnectMaxMs;
    }

    /* renamed from: component4, reason: from getter */
    public final long getReconnectJitterMs() {
        return this.reconnectJitterMs;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMaxConsecutiveFailures() {
        return this.maxConsecutiveFailures;
    }

    public final SseConfig copy(long heartbeatTimeoutMs, long reconnectBaseMs, long reconnectMaxMs, long reconnectJitterMs, int maxConsecutiveFailures) {
        return new SseConfig(heartbeatTimeoutMs, reconnectBaseMs, reconnectMaxMs, reconnectJitterMs, maxConsecutiveFailures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SseConfig)) {
            return false;
        }
        SseConfig sseConfig = (SseConfig) other;
        return this.heartbeatTimeoutMs == sseConfig.heartbeatTimeoutMs && this.reconnectBaseMs == sseConfig.reconnectBaseMs && this.reconnectMaxMs == sseConfig.reconnectMaxMs && this.reconnectJitterMs == sseConfig.reconnectJitterMs && this.maxConsecutiveFailures == sseConfig.maxConsecutiveFailures;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.heartbeatTimeoutMs) * 31) + Long.hashCode(this.reconnectBaseMs)) * 31) + Long.hashCode(this.reconnectMaxMs)) * 31) + Long.hashCode(this.reconnectJitterMs)) * 31) + Integer.hashCode(this.maxConsecutiveFailures);
    }

    public String toString() {
        return "SseConfig(heartbeatTimeoutMs=" + this.heartbeatTimeoutMs + ", reconnectBaseMs=" + this.reconnectBaseMs + ", reconnectMaxMs=" + this.reconnectMaxMs + ", reconnectJitterMs=" + this.reconnectJitterMs + ", maxConsecutiveFailures=" + this.maxConsecutiveFailures + ')';
    }

    public SseConfig(long j, long j2, long j3, long j4, int i) {
        this.heartbeatTimeoutMs = j;
        this.reconnectBaseMs = j2;
        this.reconnectMaxMs = j3;
        this.reconnectJitterMs = j4;
        this.maxConsecutiveFailures = i;
    }

    public /* synthetic */ SseConfig(long j, long j2, long j3, long j4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 30000L : j, (i2 & 2) != 0 ? 1000L : j2, (i2 & 4) == 0 ? j3 : 30000L, (i2 & 8) == 0 ? j4 : 1000L, (i2 & 16) != 0 ? 5 : i);
    }

    public final long getHeartbeatTimeoutMs() {
        return this.heartbeatTimeoutMs;
    }

    public final long getReconnectBaseMs() {
        return this.reconnectBaseMs;
    }

    public final long getReconnectMaxMs() {
        return this.reconnectMaxMs;
    }

    public final long getReconnectJitterMs() {
        return this.reconnectJitterMs;
    }

    public final int getMaxConsecutiveFailures() {
        return this.maxConsecutiveFailures;
    }
}
