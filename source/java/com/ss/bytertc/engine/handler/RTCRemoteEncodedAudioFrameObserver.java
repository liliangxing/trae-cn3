package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.type.AudioCodecType;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes7.dex */
public class RTCRemoteEncodedAudioFrameObserver {
    private static EncodedAudioFrameData createEncodedAudioFrameImpl(int codecType, ByteBuffer buffer, int size, long timestampUs, int sampleRate, int channel, int frameSizeMs, ByteBuffer extraBuffer) {
        buffer.order(ByteOrder.nativeOrder());
        if (extraBuffer != null) {
            extraBuffer.order(ByteOrder.nativeOrder());
        }
        return new EncodedAudioFrameData(AudioCodecType.fromId(codecType), buffer, size, timestampUs, AudioSampleRate.fromId(sampleRate), AudioChannel.fromId(channel), frameSizeMs, extraBuffer);
    }

    private static RemoteStreamKey createRemoteStreamKey(String room_id, String user_id, int stream_index) {
        return new RemoteStreamKey(room_id, user_id, StreamIndex.fromId(stream_index));
    }
}
