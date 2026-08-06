package com.bytedance.apm.perf.traffic;

import android.os.Build;

/* loaded from: classes3.dex */
public class TrafficStatisticWrapper {
    private ITrafficStatistics mTrafficStatistics;

    private TrafficStatisticWrapper() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mTrafficStatistics = new NewTrafficStatisticsImpl();
        } else {
            this.mTrafficStatistics = new OldTrafficStatisticsImpl();
        }
        this.mTrafficStatistics.init();
    }

    public static TrafficStatisticWrapper getInstance() {
        return Holder.sInstance;
    }

    public long getMobileBytes() {
        return this.mTrafficStatistics.getMobileBytes();
    }

    public long getWifiBytes() {
        return this.mTrafficStatistics.getWifiBytes();
    }

    public long getBackBytes() {
        return this.mTrafficStatistics.getBackBytes();
    }

    public long getBackPackets() {
        return this.mTrafficStatistics.getBackPackets();
    }

    public long getFrontBytes() {
        return this.mTrafficStatistics.getFrontBytes();
    }

    public long getFrontPackets() {
        return this.mTrafficStatistics.getFrontPackets();
    }

    public long getMobileFrontBytes() {
        return this.mTrafficStatistics.getMobileFrontBytes();
    }

    public long getMobileBackBytes() {
        return this.mTrafficStatistics.getMobileBackBytes();
    }

    public long getWifiFrontBytes() {
        return this.mTrafficStatistics.getWifiFrontBytes();
    }

    public long getWifiBackBytes() {
        return this.mTrafficStatistics.getWifiBackBytes();
    }

    public long getTotalBytes() {
        return this.mTrafficStatistics.getTotalBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStatusChange(boolean z) {
        this.mTrafficStatistics.onStatusChange(z);
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static TrafficStatisticWrapper sInstance = new TrafficStatisticWrapper();

        private Holder() {
        }
    }
}
