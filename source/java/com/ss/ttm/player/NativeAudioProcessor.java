package com.ss.ttm.player;

import android.util.AndroidRuntimeException;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class NativeAudioProcessor extends AudioProcessor {
    protected long mNativeWrapper = 0;

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioOpen(int samplerate, int channels, int duration, int format) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioProcess(ByteBuffer[] inout, int samples, long timestamp) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioClose() {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public void audioRelease(int reason) {
        throw new AndroidRuntimeException("Should not be here");
    }

    public static boolean isNativeAudioProcessor(AudioProcessor processor) {
        return processor instanceof NativeAudioProcessor;
    }

    public void setNativeWrapper(long nativeWrapper) {
        this.mNativeWrapper = nativeWrapper;
    }

    private long getNativeWrapper() {
        return this.mNativeWrapper;
    }
}
