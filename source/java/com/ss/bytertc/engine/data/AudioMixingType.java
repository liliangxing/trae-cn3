package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioMixingType {
    AUDIO_MIXING_TYPE_PLAYOUT(0),
    AUDIO_MIXING_TYPE_PUBLISH(1),
    AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH(2);

    private int value;

    AudioMixingType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioMixingType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType;

        static {
            int[] iArr = new int[AudioMixingType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType = iArr;
            try {
                iArr[AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType[AudioMixingType.AUDIO_MIXING_TYPE_PUBLISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioMixingType[AudioMixingType.AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioMixingType[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : "AUDIO_MIXING_TYPE_PLAYOUT_AND_PUBLISH" : "AUDIO_MIXING_TYPE_PUBLISH" : "AUDIO_MIXING_TYPE_PLAYOUT";
    }

    public static AudioMixingType fromId(int id) {
        for (AudioMixingType audioMixingType : values()) {
            if (audioMixingType.value() == id) {
                return audioMixingType;
            }
        }
        return null;
    }
}
