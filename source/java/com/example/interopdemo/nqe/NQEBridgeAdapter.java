package com.example.interopdemo.nqe;

import com.example.kmp.shared.sha.NQEListenerBridge;
import com.example.kmp.shared.sha.PacketLostStatsBridge;
import com.example.kmp.shared.sha.RTTAndThroughputBridge;
import com.example.kmp.shared.sha.TTNQEBridge;
import com.example.kmp.shared.sha.TTNQEBridge_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NQEBridgeAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J0\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/example/interopdemo/nqe/NQEBridgeAdapter;", "Lcom/example/kmp/shared/sha/NQEListenerBridge;", "<init>", "()V", "nqeBridge", "Lcom/example/kmp/shared/sha/TTNQEBridge;", "nativeListener", "Lcom/example/interopdemo/nqe/NativeNQEListener;", "register", "", "stopAndDestroy", "onEffectiveConnectionTypeChanged", "type", "", "onRTTOrThroughputEstimatesComputed", "httpRttMs", "transportRttMs", "downstreamThroughputKbps", "onPacketLossComputed", "protocol", "upstreamLossRate", "", "upstreamLossRateVariance", "downstreamLossRate", "downstreamLossRateVariance", "getRTTAndThroughput", "Lcom/example/interopdemo/nqe/NativeRTTAndThroughput;", "getPacketLostStats", "Lcom/example/interopdemo/nqe/NativePacketLostStats;", "getEffectiveConnectionType", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class NQEBridgeAdapter implements NQEListenerBridge {
    private NativeNQEListener nativeListener;
    private final TTNQEBridge nqeBridge = TTNQEBridge_androidKt.getTTNQEBridge();

    public final void register(NativeNQEListener nativeListener) {
        Intrinsics.checkNotNullParameter(nativeListener, "nativeListener");
        System.out.println((Object) ("registerNQEListener " + nativeListener));
        this.nativeListener = nativeListener;
        this.nqeBridge.register(this);
    }

    public final void stopAndDestroy() {
        this.nqeBridge.destroy();
    }

    @Override // com.example.kmp.shared.sha.NQEListenerBridge
    public void onEffectiveConnectionTypeChanged(int type) {
        NativeNQEListener nativeNQEListener = this.nativeListener;
        if (nativeNQEListener != null) {
            nativeNQEListener.onEffectiveConnectionTypeChanged(type);
        }
    }

    @Override // com.example.kmp.shared.sha.NQEListenerBridge
    public void onRTTOrThroughputEstimatesComputed(int httpRttMs, int transportRttMs, int downstreamThroughputKbps) {
        NativeNQEListener nativeNQEListener = this.nativeListener;
        if (nativeNQEListener != null) {
            nativeNQEListener.onRTTOrThroughputEstimatesComputed(httpRttMs, transportRttMs, downstreamThroughputKbps);
        }
    }

    @Override // com.example.kmp.shared.sha.NQEListenerBridge
    public void onPacketLossComputed(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance) {
        NativeNQEListener nativeNQEListener = this.nativeListener;
        if (nativeNQEListener != null) {
            nativeNQEListener.onPacketLossComputed(protocol, upstreamLossRate, upstreamLossRateVariance, downstreamLossRate, downstreamLossRateVariance);
        }
    }

    public final NativeRTTAndThroughput getRTTAndThroughput() {
        RTTAndThroughputBridge rTTAndThroughput = this.nqeBridge.getRTTAndThroughput();
        if (rTTAndThroughput != null) {
            return NQEBridgeAdapterKt.toNative(rTTAndThroughput);
        }
        return null;
    }

    public final NativePacketLostStats getPacketLostStats() {
        PacketLostStatsBridge packetLostStats = this.nqeBridge.getPacketLostStats();
        if (packetLostStats != null) {
            return NQEBridgeAdapterKt.toNative(packetLostStats);
        }
        return null;
    }

    public final int getEffectiveConnectionType() {
        return this.nqeBridge.getEffectiveConnectionType();
    }
}
