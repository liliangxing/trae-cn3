package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class MultiLinkStats {
    public LinkIndex linkIndex;
    public int rttAvg;
    public int rttMax;
    public int rttMin;

    public MultiLinkStats(LinkIndex linkIndex, int rttMin, int rttMax, int rttAvg) {
        this.linkIndex = linkIndex;
        this.rttMin = rttMin;
        this.rttMax = rttMax;
        this.rttAvg = rttAvg;
    }

    private static MultiLinkStats create(int linkIndex, int rttMin, int rttMax, int rttAvg) {
        return new MultiLinkStats(LinkIndex.fromId(linkIndex), rttMin, rttMax, rttAvg);
    }
}
