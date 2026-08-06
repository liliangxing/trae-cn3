package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class SingScoringConfig {
    public String lyricsFilepath;
    public String midiFilepath;
    public MulDimSingScoringMode mode;
    public AudioSampleRate sampleRate;

    public SingScoringConfig(AudioSampleRate sampleRate, MulDimSingScoringMode mode, String lyricsFilepath, String midiFilepath) {
        this.sampleRate = sampleRate;
        this.mode = mode;
        this.lyricsFilepath = lyricsFilepath;
        this.midiFilepath = midiFilepath;
    }
}
