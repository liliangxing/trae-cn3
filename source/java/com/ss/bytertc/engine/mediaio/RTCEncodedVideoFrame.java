package com.ss.bytertc.engine.mediaio;

import com.ss.bytertc.engine.data.VideoCodecType;
import com.ss.bytertc.engine.data.VideoPictureType;
import com.ss.bytertc.engine.data.VideoRotation;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class RTCEncodedVideoFrame {
    public final ByteBuffer buffer;
    public int height;
    public ByteBuffer seiData;
    public long timestampDtsUs;
    public long timestampUs;
    public VideoCodecType videoCodecType;
    public VideoPictureType videoPictureType;
    public VideoRotation videoRotation;
    public int width;

    public RTCEncodedVideoFrame(ByteBuffer buffer, long timestampUs, long timestampDtsUs, int width, int height, VideoCodecType videoCodecType, VideoPictureType videoPictureType, VideoRotation videoRotation) {
        this.buffer = buffer;
        this.timestampUs = timestampUs;
        this.timestampDtsUs = timestampDtsUs;
        this.width = width;
        this.height = height;
        this.videoCodecType = videoCodecType;
        this.videoPictureType = videoPictureType;
        this.videoRotation = videoRotation;
    }
}
