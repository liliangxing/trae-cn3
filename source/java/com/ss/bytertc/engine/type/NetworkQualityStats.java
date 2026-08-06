package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalNetworkQualityInfo;

/* loaded from: classes7.dex */
public class NetworkQualityStats {
    public double fractionLost;
    public int rtt;
    public int rxQuality;
    public int totalBandwidth;
    public int txQuality;
    public String uid;

    public NetworkQualityStats(String uid, double lost, int rtt, int bandwidth, int txQuality, int rxQuality) {
        this.uid = uid;
        this.fractionLost = lost;
        this.rtt = rtt;
        this.totalBandwidth = bandwidth;
        this.txQuality = txQuality;
        this.rxQuality = rxQuality;
    }

    public NetworkQualityStats(InternalNetworkQualityInfo internalInfo) {
        this.uid = internalInfo.uid;
        this.fractionLost = internalInfo.fractionLost;
        this.rtt = internalInfo.rtt;
        this.totalBandwidth = internalInfo.totalBandwidth;
        this.txQuality = internalInfo.txNetQuality;
        this.rxQuality = internalInfo.rxNetQuality;
    }

    public String toString() {
        return "uid=" + this.uid + ",fractionLost=" + this.fractionLost + ",rtt=" + this.rtt + ",totalBandwidth=" + this.totalBandwidth + ",txQuality=" + this.txQuality + ",rxQuality=" + this.rxQuality;
    }
}
