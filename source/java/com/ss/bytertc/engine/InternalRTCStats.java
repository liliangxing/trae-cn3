package com.ss.bytertc.engine;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class InternalRTCStats {
    public double cpuAppUsage;
    public double cpuTotalUsage;
    public int rtt;
    public int rxAudioKBitRate;
    public int rxBytes;
    public int rxCellularKBitrate;
    public int rxJitter;
    public int rxKBitRate;
    public double rxLostrate;
    public int rxScreenKBitRate;
    public int rxVideoKBitRate;
    public int totalDuration;
    public int txAudioKBitRate;
    public int txBytes;
    public int txCellularKBitrate;
    public int txJitter;
    public int txKBitRate;
    public double txLostrate;
    public int txScreenKBitRate;
    public int txVideoKBitRate;
    public int users;

    public InternalRTCStats() {
    }

    public InternalRTCStats(int totalDuration, int txBytes, int rxBytes, int txKBitRate, int rxKBitRate, int txAudioKBitRate, int rxAudioKBitRate, int txVideoKBitRate, int rxVideoKBitRate, int txScreenKBitRate, int rxScreenKBitRate, int users, double cpuTotalUsage, double cpuAppUsage, double txLostrate, double rxLostrate, int rtt, int txJitter, int rxJitter, int txCellularKBitrate, int rxCellularKBitrate) {
        this.totalDuration = totalDuration;
        this.txBytes = txBytes;
        this.rxBytes = rxBytes;
        this.txKBitRate = txKBitRate;
        this.rxKBitRate = rxKBitRate;
        this.txAudioKBitRate = txAudioKBitRate;
        this.rxAudioKBitRate = rxAudioKBitRate;
        this.txVideoKBitRate = txVideoKBitRate;
        this.rxVideoKBitRate = rxVideoKBitRate;
        this.txScreenKBitRate = txScreenKBitRate;
        this.rxScreenKBitRate = rxScreenKBitRate;
        this.users = users;
        this.cpuTotalUsage = cpuTotalUsage;
        this.cpuAppUsage = cpuAppUsage;
        this.rxLostrate = rxLostrate;
        this.txLostrate = txLostrate;
        this.rtt = rtt;
        this.txJitter = txJitter;
        this.rxJitter = rxJitter;
        this.txCellularKBitrate = txCellularKBitrate;
        this.rxCellularKBitrate = rxCellularKBitrate;
    }

    public void reset() {
        this.totalDuration = 0;
        this.txBytes = 0;
        this.rxBytes = 0;
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
        this.rxLostrate = 0.0d;
        this.txLostrate = 0.0d;
        this.rtt = 0;
        this.txJitter = 0;
        this.rxJitter = 0;
        this.txCellularKBitrate = 0;
        this.rxCellularKBitrate = 0;
    }

    public String toString() {
        return "RtcStats{totalDuration=" + this.totalDuration + ", txBytes=" + this.txBytes + ", rxBytes=" + this.rxBytes + ", txKBitRate=" + this.txKBitRate + ", rxKBitRate=" + this.rxKBitRate + ", txAudioKBitRate=" + this.txAudioKBitRate + ", rxAudioKBitRate=" + this.rxAudioKBitRate + ", txVideoKBitRate=" + this.txVideoKBitRate + ", rxVideoKBitRate=" + this.rxVideoKBitRate + ", txScreenKBitRate=" + this.txScreenKBitRate + ", rxScreenKBitRate=" + this.rxScreenKBitRate + ", users=" + this.users + ", cpuTotalUsage=" + this.cpuTotalUsage + ", cpuAppUsage=" + this.cpuAppUsage + ", txLostrate=" + this.txLostrate + ", rxLostrate=" + this.rxLostrate + ", rtt=" + this.rtt + ", txJitter=" + this.txJitter + ", rxJitter=" + this.rxJitter + ", txCellularKBitrate=" + this.txCellularKBitrate + ", rxCellularKBitrate=" + this.rxCellularKBitrate + AbstractJsonLexerKt.END_OBJ;
    }

    private static InternalRTCStats create(int totalDuration, int txBytes, int rxBytes, int txKBitRate, int rxKBitRate, int txAudioKBitRate, int rxAudioKBitRate, int txVideoKBitRate, int rxVideoKBitRate, int txScreenKBitRate, int rxScreenKBitRate, int users, double cpuTotalUsage, double cpuAppUsage, double txLostrate, double rxLostrate, int rtt, int txJitter, int rxJitter, int txCellularKBitrate, int rxCellularKBitrate) {
        return new InternalRTCStats(totalDuration, txBytes, rxBytes, txKBitRate, rxKBitRate, txAudioKBitRate, rxAudioKBitRate, txVideoKBitRate, rxVideoKBitRate, txScreenKBitRate, rxScreenKBitRate, users, cpuTotalUsage, cpuAppUsage, txLostrate, rxLostrate, rtt, txJitter, rxJitter, txCellularKBitrate, rxCellularKBitrate);
    }
}
