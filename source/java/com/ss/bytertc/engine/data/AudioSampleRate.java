package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioSampleRate {
    AUDIO_SAMPLE_RATE_AUTO(-1),
    AUDIO_SAMPLE_RATE_8000(8000),
    AUDIO_SAMPLE_RATE_11025(11025),
    AUDIO_SAMPLE_RATE_16000(16000),
    AUDIO_SAMPLE_RATE_22050(22050),
    AUDIO_SAMPLE_RATE_24000(24000),
    AUDIO_SAMPLE_RATE_32000(32000),
    AUDIO_SAMPLE_RATE_44100(44100),
    AUDIO_SAMPLE_RATE_48000(48000);

    private int value;

    AudioSampleRate(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioSampleRate$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate;

        static {
            int[] iArr = new int[AudioSampleRate.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate = iArr;
            try {
                iArr[AudioSampleRate.AUDIO_SAMPLE_RATE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_8000.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_11025.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_16000.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_22050.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_24000.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_32000.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_44100.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[AudioSampleRate.AUDIO_SAMPLE_RATE_48000.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioSampleRate[ordinal()]) {
            case 1:
                return "kAudioSampleRateAuto";
            case 2:
                return "kAudioSampleRate8000";
            case 3:
                return "kAudioSampleRate11025";
            case 4:
                return "kAudioSampleRate16000";
            case 5:
                return "kAudioSampleRate22050";
            case 6:
                return "kAudioSampleRate24000";
            case 7:
                return "kAudioSampleRate32000";
            case 8:
                return "kAudioSampleRate44100";
            case 9:
                return "kAudioSampleRate48000";
            default:
                return "";
        }
    }

    public static AudioSampleRate fromId(int id) {
        for (AudioSampleRate audioSampleRate : values()) {
            if (audioSampleRate.value() == id) {
                return audioSampleRate;
            }
        }
        return null;
    }
}
