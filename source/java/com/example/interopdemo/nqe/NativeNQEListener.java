package com.example.interopdemo.nqe;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* compiled from: NativeNQEListener.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016J0\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/example/interopdemo/nqe/NativeNQEListener;", "", "onRTTOrThroughputEstimatesComputed", "", "httpRttMs", "", "transportRttMs", "downstreamThroughputKbps", "onEffectiveConnectionTypeChanged", "type", "onPacketLossComputed", MonitorConstants.PROTOCOL, "upstreamLossRate", "", "upstreamLossRateVariance", "downstreamLossRate", "downstreamLossRateVariance", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface NativeNQEListener {

    /* compiled from: NativeNQEListener.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static void onEffectiveConnectionTypeChanged(NativeNQEListener nativeNQEListener, int i) {
        }

        public static void onPacketLossComputed(NativeNQEListener nativeNQEListener, int i, double d, double d2, double d3, double d4) {
        }

        public static void onRTTOrThroughputEstimatesComputed(NativeNQEListener nativeNQEListener, int i, int i2, int i3) {
        }
    }

    void onEffectiveConnectionTypeChanged(int type);

    void onPacketLossComputed(int protocol, double upstreamLossRate, double upstreamLossRateVariance, double downstreamLossRate, double downstreamLossRateVariance);

    void onRTTOrThroughputEstimatesComputed(int httpRttMs, int transportRttMs, int downstreamThroughputKbps);
}
