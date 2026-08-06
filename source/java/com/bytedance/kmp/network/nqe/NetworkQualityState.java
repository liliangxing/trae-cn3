package com.bytedance.kmp.network.nqe;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NQEListenerManager.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/kmp/network/nqe/NetworkQualityState;", "", "effectiveConnectionType", "Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "rttAndThroughput", "Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "tcpPacketLoss", "Lcom/bytedance/kmp/network/nqe/PacketLoss;", "quicPacketLoss", "(Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;Lcom/bytedance/kmp/network/nqe/RttAndThroughput;Lcom/bytedance/kmp/network/nqe/PacketLoss;Lcom/bytedance/kmp/network/nqe/PacketLoss;)V", "getEffectiveConnectionType", "()Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "getQuicPacketLoss", "()Lcom/bytedance/kmp/network/nqe/PacketLoss;", "getRttAndThroughput", "()Lcom/bytedance/kmp/network/nqe/RttAndThroughput;", "getTcpPacketLoss", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NetworkQualityState {
    private final EffectiveConnectionType effectiveConnectionType;
    private final PacketLoss quicPacketLoss;
    private final RttAndThroughput rttAndThroughput;
    private final PacketLoss tcpPacketLoss;

    public NetworkQualityState() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ NetworkQualityState copy$default(NetworkQualityState networkQualityState, EffectiveConnectionType effectiveConnectionType, RttAndThroughput rttAndThroughput, PacketLoss packetLoss, PacketLoss packetLoss2, int i, Object obj) {
        if ((i & 1) != 0) {
            effectiveConnectionType = networkQualityState.effectiveConnectionType;
        }
        if ((i & 2) != 0) {
            rttAndThroughput = networkQualityState.rttAndThroughput;
        }
        if ((i & 4) != 0) {
            packetLoss = networkQualityState.tcpPacketLoss;
        }
        if ((i & 8) != 0) {
            packetLoss2 = networkQualityState.quicPacketLoss;
        }
        return networkQualityState.copy(effectiveConnectionType, rttAndThroughput, packetLoss, packetLoss2);
    }

    /* renamed from: component1, reason: from getter */
    public final EffectiveConnectionType getEffectiveConnectionType() {
        return this.effectiveConnectionType;
    }

    /* renamed from: component2, reason: from getter */
    public final RttAndThroughput getRttAndThroughput() {
        return this.rttAndThroughput;
    }

    /* renamed from: component3, reason: from getter */
    public final PacketLoss getTcpPacketLoss() {
        return this.tcpPacketLoss;
    }

    /* renamed from: component4, reason: from getter */
    public final PacketLoss getQuicPacketLoss() {
        return this.quicPacketLoss;
    }

    public final NetworkQualityState copy(EffectiveConnectionType effectiveConnectionType, RttAndThroughput rttAndThroughput, PacketLoss tcpPacketLoss, PacketLoss quicPacketLoss) {
        Intrinsics.checkNotNullParameter(effectiveConnectionType, "effectiveConnectionType");
        Intrinsics.checkNotNullParameter(rttAndThroughput, "rttAndThroughput");
        Intrinsics.checkNotNullParameter(tcpPacketLoss, "tcpPacketLoss");
        Intrinsics.checkNotNullParameter(quicPacketLoss, "quicPacketLoss");
        return new NetworkQualityState(effectiveConnectionType, rttAndThroughput, tcpPacketLoss, quicPacketLoss);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkQualityState)) {
            return false;
        }
        NetworkQualityState networkQualityState = (NetworkQualityState) other;
        return this.effectiveConnectionType == networkQualityState.effectiveConnectionType && Intrinsics.areEqual(this.rttAndThroughput, networkQualityState.rttAndThroughput) && Intrinsics.areEqual(this.tcpPacketLoss, networkQualityState.tcpPacketLoss) && Intrinsics.areEqual(this.quicPacketLoss, networkQualityState.quicPacketLoss);
    }

    public int hashCode() {
        return (((((this.effectiveConnectionType.hashCode() * 31) + this.rttAndThroughput.hashCode()) * 31) + this.tcpPacketLoss.hashCode()) * 31) + this.quicPacketLoss.hashCode();
    }

    public String toString() {
        return "NetworkQualityState(effectiveConnectionType=" + this.effectiveConnectionType + ", rttAndThroughput=" + this.rttAndThroughput + ", tcpPacketLoss=" + this.tcpPacketLoss + ", quicPacketLoss=" + this.quicPacketLoss + ')';
    }

    public NetworkQualityState(EffectiveConnectionType effectiveConnectionType, RttAndThroughput rttAndThroughput, PacketLoss tcpPacketLoss, PacketLoss quicPacketLoss) {
        Intrinsics.checkNotNullParameter(effectiveConnectionType, "effectiveConnectionType");
        Intrinsics.checkNotNullParameter(rttAndThroughput, "rttAndThroughput");
        Intrinsics.checkNotNullParameter(tcpPacketLoss, "tcpPacketLoss");
        Intrinsics.checkNotNullParameter(quicPacketLoss, "quicPacketLoss");
        this.effectiveConnectionType = effectiveConnectionType;
        this.rttAndThroughput = rttAndThroughput;
        this.tcpPacketLoss = tcpPacketLoss;
        this.quicPacketLoss = quicPacketLoss;
    }

    public /* synthetic */ NetworkQualityState(EffectiveConnectionType effectiveConnectionType, RttAndThroughput rttAndThroughput, PacketLoss packetLoss, PacketLoss packetLoss2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EffectiveConnectionType.UNKNOWN : effectiveConnectionType, (i & 2) != 0 ? RttAndThroughput.INSTANCE.getINVALID() : rttAndThroughput, (i & 4) != 0 ? PacketLoss.INSTANCE.getINVALID() : packetLoss, (i & 8) != 0 ? PacketLoss.INSTANCE.getINVALID() : packetLoss2);
    }

    public final EffectiveConnectionType getEffectiveConnectionType() {
        return this.effectiveConnectionType;
    }

    public final RttAndThroughput getRttAndThroughput() {
        return this.rttAndThroughput;
    }

    public final PacketLoss getTcpPacketLoss() {
        return this.tcpPacketLoss;
    }

    public final PacketLoss getQuicPacketLoss() {
        return this.quicPacketLoss;
    }
}
