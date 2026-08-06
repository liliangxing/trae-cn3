package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.utils.AudioFrameImpl;
import com.ss.bytertc.engine.utils.IAudioFrame;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCAudioFrameObserver {
    private static IAudioFrame createAudioFrameImpl(ByteBuffer buffer, int samples_per_channel, int sampleRate, int channel, ByteBuffer extraBuffer) {
        buffer.order(ByteOrder.nativeOrder());
        if (extraBuffer != null) {
            extraBuffer.order(ByteOrder.nativeOrder());
        }
        return new AudioFrameImpl(buffer, samples_per_channel, AudioSampleRate.fromId(sampleRate), AudioChannel.fromId(channel), extraBuffer);
    }

    private static RemoteStreamKey createRemoteStreamKey(String room_id, String user_id, int stream_index) {
        return new RemoteStreamKey(room_id, user_id, StreamIndex.fromId(stream_index));
    }
}
