package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioProfileType {
    AUDIO_PROFILE_DEFAULT(0),
    AUDIO_PROFILE_FLUENT(1),
    AUDIO_PROFILE_STANDARD(2),
    AUDIO_PROFILE_HD(3),
    AUDIO_PROFILE_STANDARD_STEREO(4),
    AUDIO_PROFILE_HD_MONO(5);

    private final int value;

    public static AudioProfileType fromId(int profile) {
        for (AudioProfileType audioProfileType : values()) {
            if (audioProfileType.value() == profile) {
                return audioProfileType;
            }
        }
        return AUDIO_PROFILE_DEFAULT;
    }

    public int value() {
        return this.value;
    }

    AudioProfileType(int value) {
        this.value = value;
    }
}
