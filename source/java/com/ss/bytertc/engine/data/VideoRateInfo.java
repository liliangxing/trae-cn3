package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class VideoRateInfo {
    public int bitrateKbps;
    public int fps;

    public VideoRateInfo(int fps, int bitrateKbps) {
        this.fps = fps;
        this.bitrateKbps = bitrateKbps;
    }

    public String toString() {
        return "VideoRateInfo{fps='" + this.fps + "', bitrateKbps='" + this.bitrateKbps + "'}";
    }
}
