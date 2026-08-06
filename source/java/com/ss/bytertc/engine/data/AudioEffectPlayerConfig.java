package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class AudioEffectPlayerConfig {
    public int pitch;
    public int playCount;
    public int startPos;
    public AudioMixingType type;

    public AudioEffectPlayerConfig() {
        this.type = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH;
        this.playCount = 1;
        this.startPos = 0;
        this.pitch = 0;
    }

    public AudioEffectPlayerConfig(AudioMixingType type, int playCount, int startPos, int pitch) {
        AudioMixingType audioMixingType = AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH;
        this.type = type;
        this.playCount = playCount;
        this.startPos = startPos;
        this.pitch = pitch;
    }

    public String toString() {
        return "AudioEffectPlayerConfig{type='" + this.type + "', playCount='" + this.playCount + "', startPos='" + this.startPos + "', pitch='" + this.pitch + "'}";
    }
}
