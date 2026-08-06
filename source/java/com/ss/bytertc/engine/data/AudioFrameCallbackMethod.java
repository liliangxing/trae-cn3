package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioFrameCallbackMethod {
    AUDIO_FRAME_CALLBACK_RECORD(0),
    AUDIO_FRAME_CALLBACK_PLAYBACK(1),
    AUDIO_FRAME_CALLBACK_MIXED(2),
    AUDIO_FRAME_CALLBACK_REMOTE_USER(3),
    AUDIO_FRAME_CALLBACK_CAPTURE_MIXED(5);

    private int value;

    AudioFrameCallbackMethod(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static AudioFrameCallbackMethod fromId(int id) {
        for (AudioFrameCallbackMethod audioFrameCallbackMethod : values()) {
            if (audioFrameCallbackMethod.value() == id) {
                return audioFrameCallbackMethod;
            }
        }
        return null;
    }
}
