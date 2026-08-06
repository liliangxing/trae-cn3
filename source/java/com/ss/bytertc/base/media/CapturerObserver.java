package com.ss.bytertc.base.media;

import com.bytedance.realx.video.VideoFrame;

/* loaded from: classes7.dex */
public interface CapturerObserver {
    void onCapturerError(String errorMsg);

    void onCapturerFormatSelected(int width, int height, int minFramerate, int maxFramerate, int pixelFormat);

    void onCapturerStarted(boolean success);

    void onCapturerStopped();

    void onFrameCaptured(VideoFrame frame);
}
