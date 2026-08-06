package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public class VoiceReverbConfig {
    public float damping;
    public float decayTime;
    public float dryGain;
    public float preDelay;
    public float roomSize;
    public float wetGain;

    public VoiceReverbConfig(float roomSize, float decayTime, float damping, float wetGain, float dryGain, float preDelay) {
        this.roomSize = roomSize;
        this.decayTime = decayTime;
        this.damping = damping;
        this.wetGain = wetGain;
        this.dryGain = dryGain;
        this.preDelay = preDelay;
    }

    public String toString() {
        return "VoiceReverbConfig, room_size: " + this.roomSize + ", decay_time: " + this.decayTime + ", damping: " + this.damping + ", wet_gain: " + this.wetGain + ", dry_gain: " + this.dryGain + ", pre_delay: " + this.preDelay;
    }
}
