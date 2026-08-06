package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class AudioEncodeConfig {
    public int channelNum;
    public int codecType;
    public int encBitrate;
    public int encMode;
    public int packetSize;
    public int sampleRate;
    public int useDtx;
    public int useInbandfec;

    public AudioEncodeConfig() {
        this.codecType = -1;
        this.encMode = -1;
        this.channelNum = -1;
        this.encBitrate = -1;
        this.useDtx = -1;
        this.useInbandfec = -1;
        this.sampleRate = -1;
        this.packetSize = -1;
    }

    public AudioEncodeConfig(int codecType, int encMode, int channelNum, int encBitrate, int useDtx, int useInbandfec, int sampleRate, int packetSize) {
        this.codecType = codecType;
        this.encMode = encMode;
        this.channelNum = channelNum;
        this.encBitrate = encBitrate;
        this.useDtx = useDtx;
        this.useInbandfec = useInbandfec;
        this.sampleRate = sampleRate;
        this.packetSize = packetSize;
    }

    public String toString() {
        return "AudioEncodeConfig{codecType='" + this.codecType + "'encMode='" + this.encMode + "', channelNum='" + this.channelNum + "', encBitrate='" + this.encBitrate + "', useDtx='" + this.useDtx + "', useInbandfec='" + this.useInbandfec + "', sampleRate='" + this.sampleRate + "', packetSize='" + this.packetSize + "'}";
    }
}
