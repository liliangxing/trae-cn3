package com.bytedance.kmp.network.nqe;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NQEListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J0\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/kmp/network/nqe/NQEListener;", "", "onEffectiveConnectionTypeChanged", "", "type", "Lcom/bytedance/kmp/network/nqe/EffectiveConnectionType;", "onPacketLossComputed", MonitorConstants.PROTOCOL, "", "upstreamLossRate", "", "upstreamLossRateVariance", "downstreamLossRate", "downstreamLossRateVariance", "onRTTOrThroughputEstimatesComputed", "httpRttMs", "transportRttMs", "downstreamThroughputKbps", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface NQEListener {

    /* compiled from: NQEListener.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onEffectiveConnectionTypeChanged(NQEListener nQEListener, EffectiveConnectionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
        }

        public static void onPacketLossComputed(NQEListener nQEListener, int i, double d, double d2, double d3, double d4) {
        }

        public static void onRTTOrThroughputEstimatesComputed(NQEListener nQEListener, int i, int i2, int i3) {
        }
    }

    void onEffectiveConnectionTypeChanged(EffectiveConnectionType type);

    void onPacketLossComputed(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance);

    void onRTTOrThroughputEstimatesComputed(int httpRttMs, int transportRttMs, int downstreamThroughputKbps);
}
