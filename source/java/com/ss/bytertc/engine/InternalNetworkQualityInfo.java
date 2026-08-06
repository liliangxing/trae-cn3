package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalNetworkQualityInfo {
    public double fractionLost;
    public int rtt;
    public int rxNetQuality;
    public int totalBandwidth;
    public int txNetQuality;
    public String uid;

    public InternalNetworkQualityInfo(double lost, int rtt, int bandwidth, int txNetQuality, int rxNetQuality) {
        this.uid = "";
        this.fractionLost = lost;
        this.rtt = rtt;
        this.totalBandwidth = bandwidth;
        this.txNetQuality = txNetQuality;
        this.rxNetQuality = rxNetQuality;
    }

    public InternalNetworkQualityInfo(String uid, double lost, int rtt, int bandwidth, int txNetQuality, int rxNetQuality) {
        this.uid = uid;
        this.fractionLost = lost;
        this.rtt = rtt;
        this.totalBandwidth = bandwidth;
        this.txNetQuality = txNetQuality;
        this.rxNetQuality = rxNetQuality;
    }

    public String toString() {
        return "uid=" + this.uid + ",fractionLost=" + this.fractionLost + ",rtt=" + this.rtt + ",totalBandwidth=" + this.totalBandwidth + ",txNetQuality=" + this.txNetQuality + ",rxNetQuality=" + this.rxNetQuality;
    }

    private static InternalNetworkQualityInfo create(String uid, double lost, int rtt, int bandwidth, int txNetQuality, int rxNetQuality) {
        return new InternalNetworkQualityInfo(uid, lost, rtt, bandwidth, txNetQuality, rxNetQuality);
    }
}
