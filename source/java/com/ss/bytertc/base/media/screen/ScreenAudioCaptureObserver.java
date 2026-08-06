package com.ss.bytertc.base.media.screen;

/* loaded from: classes7.dex */
public interface ScreenAudioCaptureObserver {
    void onAudioFrameCapture(byte[] audioFrame, int samples, int sampleRate, int channel);

    void onCapturerStarted();

    void onCapturerStopped();
}
