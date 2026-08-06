package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class AudioRecordingConfig {
    public String absoluteFileName;
    public AudioChannel channel;
    public AudioFrameSource frameSource;
    public AudioQuality quality;
    public AudioSampleRate sampleRate;

    public AudioRecordingConfig(String absoluteFileName, AudioSampleRate sampleRate, AudioChannel channel, AudioFrameSource frameSource, AudioQuality quality) {
        this.absoluteFileName = absoluteFileName;
        this.sampleRate = sampleRate;
        this.channel = channel;
        this.frameSource = frameSource;
        this.quality = quality;
    }

    public AudioRecordingConfig() {
        this.absoluteFileName = null;
        this.sampleRate = AudioSampleRate.AUDIO_SAMPLE_RATE_AUTO;
        this.channel = AudioChannel.AUDIO_CHANNEL_AUTO;
        this.frameSource = AudioFrameSource.AUDIO_FRAME_SOURCE_MIXED;
        this.quality = AudioQuality.AUDIO_QUALITY_MEDIUM;
    }
}
