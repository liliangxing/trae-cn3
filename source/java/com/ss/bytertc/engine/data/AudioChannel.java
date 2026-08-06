package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioChannel {
    AUDIO_CHANNEL_AUTO(-1),
    AUDIO_CHANNEL_MONO(1),
    AUDIO_CHANNEL_STEREO(2);

    private int value;

    AudioChannel(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioChannel$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioChannel;

        static {
            int[] iArr = new int[AudioChannel.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioChannel = iArr;
            try {
                iArr[AudioChannel.AUDIO_CHANNEL_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioChannel[AudioChannel.AUDIO_CHANNEL_MONO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioChannel[AudioChannel.AUDIO_CHANNEL_STEREO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioChannel[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "kAudioChannelUnknown" : "kAudioChannelStereo" : "kAudioChannelMono" : "kAudioChannelAuto";
    }

    public static AudioChannel fromId(int id) {
        for (AudioChannel audioChannel : values()) {
            if (audioChannel.value() == id) {
                return audioChannel;
            }
        }
        return null;
    }
}
