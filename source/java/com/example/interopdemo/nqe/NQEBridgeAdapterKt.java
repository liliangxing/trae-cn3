package com.example.interopdemo.nqe;

import com.example.kmp.shared.sha.PacketLostStatsBridge;
import com.example.kmp.shared.sha.RTTAndThroughputBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NQEBridgeAdapter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004¨\u0006\u0005"}, d2 = {"toNative", "Lcom/example/interopdemo/nqe/NativeRTTAndThroughput;", "Lcom/example/kmp/shared/sha/RTTAndThroughputBridge;", "Lcom/example/interopdemo/nqe/NativePacketLostStats;", "Lcom/example/kmp/shared/sha/PacketLostStatsBridge;", "kmpNativeInterface_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NQEBridgeAdapterKt {
    public static final NativeRTTAndThroughput toNative(RTTAndThroughputBridge rTTAndThroughputBridge) {
        Intrinsics.checkNotNullParameter(rTTAndThroughputBridge, "<this>");
        return new NativeRTTAndThroughput(rTTAndThroughputBridge.getHttpRttMs(), rTTAndThroughputBridge.getTransportRttMs(), rTTAndThroughputBridge.getDownstreamThroughputKbps());
    }

    public static final NativePacketLostStats toNative(PacketLostStatsBridge packetLostStatsBridge) {
        Intrinsics.checkNotNullParameter(packetLostStatsBridge, "<this>");
        return new NativePacketLostStats(packetLostStatsBridge.getProtocol(), packetLostStatsBridge.getUpstreamLossRate(), packetLostStatsBridge.getUpstreamLossRateVariance(), packetLostStatsBridge.getDownstreamLossRate(), packetLostStatsBridge.getDownstreamLossRateVariance());
    }
}
