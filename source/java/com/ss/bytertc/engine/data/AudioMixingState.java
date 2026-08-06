package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioMixingState {
    AUDIO_MIXING_STATE_PRELOADED(0),
    AUDIO_MIXING_STATE_PLAYING(1),
    AUDIO_MIXING_STATE_PAUSED(2),
    AUDIO_MIXING_STATE_STOPPED(3),
    AUDIO_MIXING_STATE_FAILED(4),
    AUDIO_MIXING_STATE_FINISHED(5),
    AUDIO_MIXING_STATE_PCM_ENABLED(6),
    AUDIO_MIXING_STATE_PCM_DISABLED(7);

    private int value;

    AudioMixingState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioMixingState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState;

        static {
            int[] iArr = new int[AudioMixingState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState = iArr;
            try {
                iArr[AudioMixingState.AUDIO_MIXING_STATE_PRELOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_STOPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_FINISHED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PCM_ENABLED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[AudioMixingState.AUDIO_MIXING_STATE_PCM_DISABLED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingState[ordinal()]) {
            case 1:
                return "AUDIO_MIXING_STATE_PRELOADED";
            case 2:
                return "AUDIO_MIXING_STATE_PLAYING";
            case 3:
                return "AUDIO_MIXING_STATE_PAUSED";
            case 4:
                return "AUDIO_MIXING_STATE_STOPPED";
            case 5:
                return "AUDIO_MIXING_STATE_FAILED";
            case 6:
                return "AUDIO_MIXING_STATE_FINISHED";
            case 7:
                return "AUDIO_MIXING_STATE_PCM_ENABLED";
            case 8:
                return "AUDIO_MIXING_STATE_PCM_DISABLED";
            default:
                return "";
        }
    }

    public static AudioMixingState fromId(int id) {
        for (AudioMixingState audioMixingState : values()) {
            if (audioMixingState.value() == id) {
                return audioMixingState;
            }
        }
        return null;
    }
}
