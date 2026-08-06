package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.data.VideoPixelFormat;

/* loaded from: classes7.dex */
public class RemoteVideoSinkConfig {
    public RemoteVideoSinkPosition position = RemoteVideoSinkPosition.AFTER_POST_PROCESS;
    public VideoPixelFormat pixelFormat = VideoPixelFormat.UNKNOWN;
    public VideoApplyRotation applyRotation = VideoApplyRotation.DEFAULT;
    public VideoSinkMirrorType mirrorType = VideoSinkMirrorType.OFF;
}
