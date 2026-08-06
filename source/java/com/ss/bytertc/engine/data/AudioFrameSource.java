package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioFrameSource {
    AUDIO_FRAME_SOURCE_MIC(0),
    AUDIO_FRAME_SOURCE_PLAYBACK(1),
    AUDIO_FRAME_SOURCE_MIXED(2);

    private int value;

    AudioFrameSource(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioFrameSource$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource;

        static {
            int[] iArr = new int[AudioFrameSource.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource = iArr;
            try {
                iArr[AudioFrameSource.AUDIO_FRAME_SOURCE_MIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource[AudioFrameSource.AUDIO_FRAME_SOURCE_PLAYBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource[AudioFrameSource.AUDIO_FRAME_SOURCE_MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioFrameSource[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : "kAudioFrameSourceMixed" : "kAudioFrameSourcePlayback" : "kAudioFrameSourceMic";
    }

    public static AudioFrameSource fromId(int id) {
        for (AudioFrameSource audioFrameSource : values()) {
            if (audioFrameSource.value() == id) {
                return audioFrameSource;
            }
        }
        return null;
    }
}
