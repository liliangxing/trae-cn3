package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class SubChannelInfo {
    private String channelName;
    private double volumeScale;

    public SubChannelInfo(String name, double scale) {
        this.channelName = name;
        this.volumeScale = scale;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public double getVolumeScale() {
        return this.volumeScale;
    }
}
