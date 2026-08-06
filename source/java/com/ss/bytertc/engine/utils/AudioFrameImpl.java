package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioFrameType;
import com.ss.bytertc.engine.data.AudioSampleRate;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class AudioFrameImpl implements IAudioFrame {
    private ByteBuffer byteBuffer;
    private long captureTimestampMs;
    private AudioChannel channel;
    private ByteBuffer extraBuffer;
    private AudioFrameType frameType;
    private AudioSampleRate sampleRate;
    private int samplesPerChannel;
    private long timestamp;

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public void release() {
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public long timestamp_us() {
        return this.timestamp;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public long captureTimestampMs() {
        return this.captureTimestampMs;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioSampleRate sample_rate() {
        return this.sampleRate;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioChannel channel() {
        return this.channel;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public ByteBuffer getDataBuffer() {
        return this.byteBuffer;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int data_size() {
        return this.samplesPerChannel * this.channel.value() * 2;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public AudioFrameType frame_type() {
        return this.frameType;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public ByteBuffer getExtraInfo() {
        return this.extraBuffer;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int setExtraInfo(ByteBuffer extraInfo) {
        this.extraBuffer = extraInfo;
        return 0;
    }

    @Override // com.ss.bytertc.engine.utils.IAudioFrame
    public int extraInfoSize() {
        ByteBuffer byteBuffer = this.extraBuffer;
        if (byteBuffer != null) {
            return byteBuffer.capacity();
        }
        return 0;
    }

    public AudioFrameImpl() {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0L;
        this.extraBuffer = null;
        this.captureTimestampMs = 0L;
    }

    public AudioFrameImpl(byte[] buffer, int samplesPerChannel, AudioSampleRate sampleRate, AudioChannel channel, byte[] extraBuffer) {
        this(ByteBuffer.wrap(buffer), samplesPerChannel, sampleRate, channel, ByteBuffer.wrap(extraBuffer));
    }

    public AudioFrameImpl(ByteBuffer buffer, int samplesPerChannel, AudioSampleRate sampleRate, AudioChannel channel, ByteBuffer extraBuffer) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0L;
        this.captureTimestampMs = 0L;
        this.byteBuffer = buffer;
        this.samplesPerChannel = samplesPerChannel;
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.extraBuffer = extraBuffer;
    }

    public AudioFrameImpl(ByteBuffer buffer, int samplesPerChannel, AudioSampleRate sampleRate, AudioChannel channel) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.timestamp = 0L;
        this.captureTimestampMs = 0L;
        this.byteBuffer = buffer;
        this.samplesPerChannel = samplesPerChannel;
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.extraBuffer = null;
    }

    public AudioFrameImpl(ByteBuffer buffer, int samplesPerChannel, AudioSampleRate sampleRate, AudioChannel channel, ByteBuffer extraBuffer, long timeStamp, long captureTimestampMs) {
        this.byteBuffer = null;
        this.samplesPerChannel = 0;
        this.frameType = AudioFrameType.FRAME_TYPE_PCM16;
        this.byteBuffer = buffer;
        this.samplesPerChannel = samplesPerChannel;
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.extraBuffer = extraBuffer;
        this.timestamp = timeStamp;
        this.captureTimestampMs = captureTimestampMs;
    }
}
