package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRTCStats;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RTCRoomStats {
    public double cpuAppUsage;
    public double cpuTotalUsage;
    public int rtt;
    public int rxAudioKBitRate;
    public long rxBytes;
    public int rxCellularKBitrate;
    public int rxJitter;
    public int rxKBitRate;
    public double rxLostrate;
    public int rxScreenKBitRate;
    public int rxVideoKBitRate;
    public int totalDuration;
    public int txAudioKBitRate;
    public long txBytes;
    public int txCellularKBitrate;
    public int txJitter;
    public int txKBitRate;
    public double txLostrate;
    public int txScreenKBitRate;
    public int txVideoKBitRate;
    public int users;

    public RTCRoomStats() {
    }

    public RTCRoomStats(InternalRTCStats internalStats) {
        this.totalDuration = internalStats.totalDuration;
        this.txBytes = internalStats.txBytes;
        this.rxBytes = internalStats.rxBytes;
        this.txKBitRate = internalStats.txKBitRate;
        this.rxKBitRate = internalStats.rxKBitRate;
        this.txAudioKBitRate = internalStats.txAudioKBitRate;
        this.rxAudioKBitRate = internalStats.rxAudioKBitRate;
        this.txVideoKBitRate = internalStats.txVideoKBitRate;
        this.rxVideoKBitRate = internalStats.rxVideoKBitRate;
        this.txScreenKBitRate = internalStats.txScreenKBitRate;
        this.rxScreenKBitRate = internalStats.rxScreenKBitRate;
        this.users = internalStats.users;
        this.cpuTotalUsage = internalStats.cpuTotalUsage;
        this.cpuAppUsage = internalStats.cpuAppUsage;
        this.txLostrate = internalStats.txLostrate;
        this.rxLostrate = internalStats.rxLostrate;
        this.rtt = internalStats.rtt;
        this.txJitter = internalStats.txJitter;
        this.rxJitter = internalStats.rxJitter;
        this.txCellularKBitrate = internalStats.txCellularKBitrate;
        this.rxCellularKBitrate = internalStats.rxCellularKBitrate;
    }

    public void reset() {
        this.totalDuration = 0;
        this.txBytes = 0L;
        this.rxBytes = 0L;
        this.txKBitRate = 0;
        this.rxKBitRate = 0;
        this.txAudioKBitRate = 0;
        this.rxAudioKBitRate = 0;
        this.txVideoKBitRate = 0;
        this.rxVideoKBitRate = 0;
        this.txScreenKBitRate = 0;
        this.rxScreenKBitRate = 0;
        this.users = 0;
        this.cpuTotalUsage = 0.0d;
        this.cpuAppUsage = 0.0d;
        this.txJitter = 0;
        this.rxJitter = 0;
        this.txLostrate = 0.0d;
        this.rxLostrate = 0.0d;
        this.rtt = 0;
        this.txCellularKBitrate = 0;
        this.rxCellularKBitrate = 0;
    }

    public String toString() {
        return "RtcStats{totalDuration=" + this.totalDuration + ", txBytes=" + this.txBytes + ", rxBytes=" + this.rxBytes + ", txKBitRate=" + this.txKBitRate + ", rxKBitRate=" + this.rxKBitRate + ", txAudioKBitRate=" + this.txAudioKBitRate + ", rxAudioKBitRate=" + this.rxAudioKBitRate + ", txVideoKBitRate=" + this.txVideoKBitRate + ", rxVideoKBitRate=" + this.rxVideoKBitRate + ", txScreenKBitRate=" + this.txScreenKBitRate + ", rxScreenKBitRate=" + this.rxScreenKBitRate + ", users=" + this.users + ", cpuTotalUsage=" + this.cpuTotalUsage + ", cpuAppUsage=" + this.cpuAppUsage + ", txLostrate=" + this.txLostrate + ", rxLostrate=" + this.rxLostrate + ", rtt=" + this.rtt + ", txJitter=" + this.txJitter + ", rxJitter=" + this.rxJitter + ", txCellularKBitRate=" + this.txCellularKBitrate + ", rxCellularKBitRate=" + this.rxCellularKBitrate + AbstractJsonLexerKt.END_OBJ;
    }
}
