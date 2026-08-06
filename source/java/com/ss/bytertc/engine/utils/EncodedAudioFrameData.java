package com.ss.bytertc.engine.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;
import com.ss.bytertc.engine.type.AudioCodecType;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class EncodedAudioFrameData {
    public AudioChannel channelNum;
    public AudioCodecType codecType;
    public ByteBuffer data;
    public ByteBuffer extraInfo;
    public int frameSizeMs;
    public AudioSampleRate sampleRate;
    public int size;
    public long timestampUs;

    public EncodedAudioFrameData(AudioCodecType codec_type, ByteBuffer data, int size, long timestampUs, AudioSampleRate sampleRate, AudioChannel channel, int frameSizeMs) {
        this.codecType = codec_type;
        this.data = data;
        this.size = size;
        this.timestampUs = timestampUs;
        this.sampleRate = sampleRate;
        this.channelNum = channel;
        this.frameSizeMs = frameSizeMs;
        this.extraInfo = null;
    }

    public EncodedAudioFrameData(AudioCodecType codec_type, ByteBuffer data, int size, long timestampUs, AudioSampleRate sampleRate, AudioChannel channel, int frameSizeMs, ByteBuffer extraInfo) {
        this.codecType = codec_type;
        this.data = data;
        this.size = size;
        this.timestampUs = timestampUs;
        this.sampleRate = sampleRate;
        this.channelNum = channel;
        this.frameSizeMs = frameSizeMs;
        this.extraInfo = extraInfo;
    }
}
