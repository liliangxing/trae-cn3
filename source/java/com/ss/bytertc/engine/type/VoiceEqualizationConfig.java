package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public class VoiceEqualizationConfig {
    public VoiceEqualizationBandFrequency frequency;
    public int gain;

    public VoiceEqualizationConfig(VoiceEqualizationBandFrequency frequency, int gain) {
        this.frequency = frequency;
        this.gain = gain;
    }

    public String toString() {
        return "the frequency: " + this.frequency + ", the gain: " + this.gain;
    }
}
