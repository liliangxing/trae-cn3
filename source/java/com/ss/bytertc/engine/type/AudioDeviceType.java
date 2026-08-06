package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioDeviceType {
    AUDIO_DEVICE_TYPE_UNKNOWN(-1),
    AUDIO_DEVICE_TYPE_RENDER_DEVICE(0),
    AUDIO_DEVICE_TYPE_CAPTURE_DEVICE(1),
    AUDIO_DEVICE_TYPE_SCREEN_CAPTURE_DEVICE(2);

    private final int value;

    AudioDeviceType() {
        this.value = 0;
    }

    public int value() {
        return this.value;
    }

    AudioDeviceType(int value) {
        this.value = value;
    }

    public static AudioDeviceType fromId(int id) {
        for (AudioDeviceType audioDeviceType : values()) {
            if (audioDeviceType.value() == id) {
                return audioDeviceType;
            }
        }
        return AUDIO_DEVICE_TYPE_UNKNOWN;
    }
}
