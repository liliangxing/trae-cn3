package com.bytedance.apm.perf.traffic;

/* loaded from: classes3.dex */
public interface ITrafficStatistics {
    long getBackBytes();

    long getBackPackets();

    long getFrontBytes();

    long getFrontPackets();

    long getMobileBackBytes();

    long getMobileBytes();

    long getMobileFrontBytes();

    long getTotalBytes();

    long getWifiBackBytes();

    long getWifiBytes();

    long getWifiFrontBytes();

    void init();

    void onStatusChange(boolean z);
}
