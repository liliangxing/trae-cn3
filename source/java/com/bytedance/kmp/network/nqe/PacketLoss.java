package com.bytedance.kmp.network.nqe;

import com.bytedance.forest.model.PreloadConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NQEListenerManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/kmp/network/nqe/PacketLoss;", "", MonitorConstants.PROTOCOL, "", "upstreamLossRate", "", "upstreamLossRateVariance", "downstreamLossRate", "downstreamLossRateVariance", "(IDDDD)V", "getDownstreamLossRate", "()D", "getDownstreamLossRateVariance", "getProtocol", "()I", "getUpstreamLossRate", "getUpstreamLossRateVariance", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "Companion", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PacketLoss {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PacketLoss INVALID = new PacketLoss(0, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);
    private final double downstreamLossRate;
    private final double downstreamLossRateVariance;
    private final int protocol;
    private final double upstreamLossRate;
    private final double upstreamLossRateVariance;

    public PacketLoss() {
        this(0, 0.0d, 0.0d, 0.0d, 0.0d, 31, null);
    }

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

    public final PacketLoss copy(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance) {
        return new PacketLoss(protocol, upstreamLossRate, upstreamLossRateVariance, downstreamLossRate, downstreamLossRateVariance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PacketLoss)) {
            return false;
        }
        PacketLoss packetLoss = (PacketLoss) other;
        return this.protocol == packetLoss.protocol && Double.compare(this.upstreamLossRate, packetLoss.upstreamLossRate) == 0 && Double.compare(this.upstreamLossRateVariance, packetLoss.upstreamLossRateVariance) == 0 && Double.compare(this.downstreamLossRate, packetLoss.downstreamLossRate) == 0 && Double.compare(this.downstreamLossRateVariance, packetLoss.downstreamLossRateVariance) == 0;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.protocol) * 31) + Double.hashCode(this.upstreamLossRate)) * 31) + Double.hashCode(this.upstreamLossRateVariance)) * 31) + Double.hashCode(this.downstreamLossRate)) * 31) + Double.hashCode(this.downstreamLossRateVariance);
    }

    public String toString() {
        return "PacketLoss(protocol=" + this.protocol + ", upstreamLossRate=" + this.upstreamLossRate + ", upstreamLossRateVariance=" + this.upstreamLossRateVariance + ", downstreamLossRate=" + this.downstreamLossRate + ", downstreamLossRateVariance=" + this.downstreamLossRateVariance + ')';
    }

    public PacketLoss(int i, double d, double d2, double d3, double d4) {
        this.protocol = i;
        this.upstreamLossRate = d;
        this.upstreamLossRateVariance = d2;
        this.downstreamLossRate = d3;
        this.downstreamLossRateVariance = d4;
    }

    public /* synthetic */ PacketLoss(int i, double d, double d2, double d3, double d4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? -1.0d : d, (i2 & 4) != 0 ? -1.0d : d2, (i2 & 8) != 0 ? -1.0d : d3, (i2 & 16) == 0 ? d4 : -1.0d);
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

    /* compiled from: NQEListenerManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/kmp/network/nqe/PacketLoss$Companion;", "", "()V", "INVALID", "Lcom/bytedance/kmp/network/nqe/PacketLoss;", "getINVALID", "()Lcom/bytedance/kmp/network/nqe/PacketLoss;", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PacketLoss getINVALID() {
            return PacketLoss.INVALID;
        }
    }
}
