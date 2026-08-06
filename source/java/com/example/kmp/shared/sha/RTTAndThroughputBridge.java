package com.example.kmp.shared.sha;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: TTNQEBridge.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/example/kmp/shared/sha/RTTAndThroughputBridge;", "", "httpRttMs", "", "transportRttMs", "downstreamThroughputKbps", "<init>", "(III)V", "getHttpRttMs", "()I", "getTransportRttMs", "getDownstreamThroughputKbps", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class RTTAndThroughputBridge {
    private final int downstreamThroughputKbps;
    private final int httpRttMs;
    private final int transportRttMs;

    public static /* synthetic */ RTTAndThroughputBridge copy$default(RTTAndThroughputBridge rTTAndThroughputBridge, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rTTAndThroughputBridge.httpRttMs;
        }
        if ((i4 & 2) != 0) {
            i2 = rTTAndThroughputBridge.transportRttMs;
        }
        if ((i4 & 4) != 0) {
            i3 = rTTAndThroughputBridge.downstreamThroughputKbps;
        }
        return rTTAndThroughputBridge.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getHttpRttMs() {
        return this.httpRttMs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTransportRttMs() {
        return this.transportRttMs;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDownstreamThroughputKbps() {
        return this.downstreamThroughputKbps;
    }

    public final RTTAndThroughputBridge copy(int httpRttMs, int transportRttMs, int downstreamThroughputKbps) {
        return new RTTAndThroughputBridge(httpRttMs, transportRttMs, downstreamThroughputKbps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RTTAndThroughputBridge)) {
            return false;
        }
        RTTAndThroughputBridge rTTAndThroughputBridge = (RTTAndThroughputBridge) other;
        return this.httpRttMs == rTTAndThroughputBridge.httpRttMs && this.transportRttMs == rTTAndThroughputBridge.transportRttMs && this.downstreamThroughputKbps == rTTAndThroughputBridge.downstreamThroughputKbps;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.httpRttMs) * 31) + Integer.hashCode(this.transportRttMs)) * 31) + Integer.hashCode(this.downstreamThroughputKbps);
    }

    public String toString() {
        return "RTTAndThroughputBridge(httpRttMs=" + this.httpRttMs + ", transportRttMs=" + this.transportRttMs + ", downstreamThroughputKbps=" + this.downstreamThroughputKbps + ')';
    }

    public RTTAndThroughputBridge(int i, int i2, int i3) {
        this.httpRttMs = i;
        this.transportRttMs = i2;
        this.downstreamThroughputKbps = i3;
    }

    public final int getHttpRttMs() {
        return this.httpRttMs;
    }

    public final int getTransportRttMs() {
        return this.transportRttMs;
    }

    public final int getDownstreamThroughputKbps() {
        return this.downstreamThroughputKbps;
    }
}
