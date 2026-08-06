package com.lynx.canvas;

import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public abstract class KryptonLiveModule extends KryptonModule {

    /* loaded from: classes6.dex */
    public interface IAudioSampleListener {
        void onAudioSample(ByteBuffer byteBuffer, int i);
    }

    /* loaded from: classes6.dex */
    public interface IVideoFrameListener {
        void onVideoFrame(ByteBuffer byteBuffer, int i, int i2);
    }

    static String moduleName() {
        return "live";
    }

    public abstract void flushCapture(IVideoFrameListener iVideoFrameListener, IAudioSampleListener iAudioSampleListener);

    public abstract void setBackgroundVolume(float f);

    public abstract void setEnableCaptureMicrophone(boolean z);

    public abstract void setMicrophoneVolume(float f);

    public abstract boolean startCapture(int i, int i2, int i3, String str, int i4, boolean z);

    public abstract void stopCapture();
}
