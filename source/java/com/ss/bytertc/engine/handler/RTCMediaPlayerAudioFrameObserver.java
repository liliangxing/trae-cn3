package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.utils.AudioFrameImpl;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCMediaPlayerAudioFrameObserver {
    private IMediaPlayerAudioFrameObserver mAudioFrameObserver;

    public void setAudioFrameObserver(IMediaPlayerAudioFrameObserver observer) {
        this.mAudioFrameObserver = observer;
    }

    void onFrame(int playerId, IAudioFrame audioFrame) {
        IMediaPlayerAudioFrameObserver iMediaPlayerAudioFrameObserver = this.mAudioFrameObserver;
        if (iMediaPlayerAudioFrameObserver != null) {
            iMediaPlayerAudioFrameObserver.onFrame(playerId, audioFrame);
        }
    }

    private static IAudioFrame createAudioFrameImpl(ByteBuffer buffer, int samplesPerChannel, int sampleRate, int channel) {
        buffer.order(ByteOrder.nativeOrder());
        return new AudioFrameImpl(buffer, samplesPerChannel, AudioSampleRate.fromId(sampleRate), AudioChannel.fromId(channel));
    }
}
