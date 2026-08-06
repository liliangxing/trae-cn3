package com.example.kmp.shared.sha;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* compiled from: TTNQEBridge.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/example/kmp/shared/sha/PacketLostStatsBridge;", "", MonitorConstants.PROTOCOL, "", "upstreamLossRate", "", "upstreamLossRateVariance", "downstreamLossRate", "downstreamLossRateVariance", "<init>", "(IDDDD)V", "getProtocol", "()I", "getUpstreamLossRate", "()D", "getUpstreamLossRateVariance", "getDownstreamLossRate", "getDownstreamLossRateVariance", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "kmpNativeBridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class PacketLostStatsBridge {
    private final double downstreamLossRate;
    private final double downstreamLossRateVariance;
    private final int protocol;
    private final double upstreamLossRate;
    private final double upstreamLossRateVariance;

    /* renamed from: component1, reason: from getter */
    public final int getProtocol() {
        return this.protocol;
    }

    /* renamed from: component2, reason: from getter */
    public final double getUpstreamLossRate() {
        return this.upstreamLossRate;
    }

    /* renamed from: component3, reason: from getter */
    public final double getUpstreamLossRateVariance() {
        return this.upstreamLossRateVariance;
    }

    /* renamed from: component4, reason: from getter */
    public final double getDownstreamLossRate() {
        return this.downstreamLossRate;
    }

    /* renamed from: component5, reason: from getter */
    public final double getDownstreamLossRateVariance() {
        return this.downstreamLossRateVariance;
    }

    public final PacketLostStatsBridge copy(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance) {
        return new PacketLostStatsBridge(protocol, upstreamLossRate, upstreamLossRateVariance, downstreamLossRate, downstreamLossRateVariance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketLostStatsBridge)) {
            return false;
        }
        PacketLostStatsBridge packetLostStatsBridge = (PacketLostStatsBridge) other;
        return this.protocol == packetLostStatsBridge.protocol && Double.compare(this.upstreamLossRate, packetLostStatsBridge.upstreamLossRate) == 0 && Double.compare(this.upstreamLossRateVariance, packetLostStatsBridge.upstreamLossRateVariance) == 0 && Double.compare(this.downstreamLossRate, packetLostStatsBridge.downstreamLossRate) == 0 && Double.compare(this.downstreamLossRateVariance, packetLostStatsBridge.downstreamLossRateVariance) == 0;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.protocol) * 31) + Double.hashCode(this.upstreamLossRate)) * 31) + Double.hashCode(this.upstreamLossRateVariance)) * 31) + Double.hashCode(this.downstreamLossRate)) * 31) + Double.hashCode(this.downstreamLossRateVariance);
    }

    public String toString() {
        return "PacketLostStatsBridge(protocol=" + this.protocol + ", upstreamLossRate=" + this.upstreamLossRate + ", upstreamLossRateVariance=" + this.upstreamLossRateVariance + ", downstreamLossRate=" + this.downstreamLossRate + ", downstreamLossRateVariance=" + this.downstreamLossRateVariance + ')';
    }

    public PacketLostStatsBridge(int i, double d, double d2, double d3, double d4) {
        this.protocol = i;
        this.upstreamLossRate = d;
        this.upstreamLossRateVariance = d2;
        this.downstreamLossRate = d3;
        this.downstreamLossRateVariance = d4;
    }

    public final int getProtocol() {
        return this.protocol;
    }

    public final double getUpstreamLossRate() {
        return this.upstreamLossRate;
    }

    public final double getUpstreamLossRateVariance() {
        return this.upstreamLossRateVariance;
    }

    public final double getDownstreamLossRate() {
        return this.downstreamLossRate;
    }

    public final double getDownstreamLossRateVariance() {
        return this.downstreamLossRateVariance;
    }
}
