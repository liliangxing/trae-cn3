package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.utils.AudioFrameImpl;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes7.dex */
public class NativeWTNAudioFrameObserver {
    private static IAudioFrame createAudioFrameImpl(ByteBuffer buffer, int samples_per_channel, int sampleRate, int channel) {
        buffer.order(ByteOrder.nativeOrder());
        return new AudioFrameImpl(buffer, samples_per_channel, AudioSampleRate.fromId(sampleRate), AudioChannel.fromId(channel));
    }
}
