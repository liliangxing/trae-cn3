package com.bytedance.salamander.anniex;

import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsHybridSettingsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Lcom/bytedance/salamander/anniex/HybridSettingsResponse;", "", "()V", "allEventSample", "", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getAllEventSample", "()Ljava/util/Map;", "setAllEventSample", "(Ljava/util/Map;)V", "bidInfo", "Lcom/bytedance/salamander/anniex/BidInfo;", "getBidInfo", "()Lcom/bytedance/salamander/anniex/BidInfo;", "setBidInfo", "(Lcom/bytedance/salamander/anniex/BidInfo;)V", LynxTimingPerformanceReportProcessor.KEY_DURATION, "getDuration", "()I", "setDuration", "(I)V", "hostWhiteMap", "getHostWhiteMap", "setHostWhiteMap", "settingId", "", "getSettingId", "()J", "setSettingId", "(J)V", "switchConfig", "getSwitchConfig", "setSwitchConfig", "updateTime", "getUpdateTime", "setUpdateTime", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HybridSettingsResponse {
    private int duration;
    private long settingId;
    private long switchConfig;
    private long updateTime;
    private BidInfo bidInfo = new BidInfo();
    private Map<String, Integer> allEventSample = RTSMapKt.RTSMap();
    private Map<String, Object> hostWhiteMap = RTSMapKt.RTSMap();

    public BidInfo getBidInfo() {
        return this.bidInfo;
    }

    public void setBidInfo(BidInfo bidInfo) {
        Intrinsics.checkNotNullParameter(bidInfo, "<set-?>");
        this.bidInfo = bidInfo;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }

    public long getSettingId() {
        return this.settingId;
    }

    public void setSettingId(long j) {
        this.settingId = j;
    }

    public long getSwitchConfig() {
        return this.switchConfig;
    }

    public void setSwitchConfig(long j) {
        this.switchConfig = j;
    }

    public Map<String, Integer> getAllEventSample() {
        return this.allEventSample;
    }

    public void setAllEventSample(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.allEventSample = map;
    }

    public Map<String, Object> getHostWhiteMap() {
        return this.hostWhiteMap;
    }

    public void setHostWhiteMap(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.hostWhiteMap = map;
    }
}
