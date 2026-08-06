package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class RecordingInfo {
    public String filePath;
    public int height;
    public VideoCodecType videoCodecType;
    public int width;

    public RecordingInfo(String filePath, VideoCodecType videoCodecType, int width, int height) {
        this.filePath = filePath;
        this.videoCodecType = videoCodecType;
        this.width = width;
        this.height = height;
    }

    public static RecordingInfo create(String filePath, VideoCodecType videoCodecType, int width, int height) {
        return new RecordingInfo(filePath, videoCodecType, width, height);
    }
}
