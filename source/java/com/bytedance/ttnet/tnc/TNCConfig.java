package com.bytedance.ttnet.tnc;

import java.util.Map;

/* loaded from: classes4.dex */
public class TNCConfig {
    public boolean localEnable = false;
    public boolean probeEnable = true;
    public Map<String, Integer> localHostFilterList = null;
    public int reqToCnt = 10;
    public int reqToApiCnt = 3;
    public int reqToIpCnt = 3;
    public int reqErrCnt = 10;
    public int reqErrApiCnt = 3;
    public int reqErrIpCnt = 3;
    public int updateInterval = 900;
    public int updateRandomRange = 120;
    public String httpCodeBlack = null;
    public int probeCmd = 0;
    public long probeVersion = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder(" localEnable: ");
        sb.append(this.localEnable);
        sb.append(" probeEnable: ").append(this.probeEnable);
        StringBuilder append = sb.append(" hostFilter: ");
        Map<String, Integer> map = this.localHostFilterList;
        append.append(map != null ? map.size() : 0);
        sb.append(" reqTo: ").append(this.reqToCnt).append("#").append(this.reqToApiCnt).append("#").append(this.reqToIpCnt);
        sb.append(" reqErr: ").append(this.reqErrCnt).append("#").append(this.reqErrApiCnt).append("#").append(this.reqErrIpCnt);
        sb.append(" updateInterval: ").append(this.updateInterval);
        sb.append(" updateRandom: ").append(this.updateRandomRange);
        sb.append(" httpBlack: ").append(this.httpCodeBlack);
        return sb.toString();
    }
}
