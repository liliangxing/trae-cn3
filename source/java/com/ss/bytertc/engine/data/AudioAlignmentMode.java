package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioAlignmentMode {
    AUDIO_ALIGNMENT_MODE_OFF(0),
    AUDIO_ALIGNMENT_MODE_AUDIOMIXING(1);

    private int value;

    AudioAlignmentMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioAlignmentMode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode;

        static {
            int[] iArr = new int[AudioAlignmentMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode = iArr;
            try {
                iArr[AudioAlignmentMode.AUDIO_ALIGNMENT_MODE_OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode[AudioAlignmentMode.AUDIO_ALIGNMENT_MODE_AUDIOMIXING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioAlignmentMode[ordinal()];
        return (i == 1 || i != 2) ? "kAudioAlignmentModeOff" : "kAudioAlignmentModeAudioMixing";
    }

    public static AudioAlignmentMode fromId(int id) {
        for (AudioAlignmentMode audioAlignmentMode : values()) {
            if (audioAlignmentMode.value() == id) {
                return audioAlignmentMode;
            }
        }
        return null;
    }
}
