package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioPropertiesMode {
    AUDIO_PROPERTIES_MODE_MICROPHONE(0),
    AUDIO_PROPERTIES_MODE_AUDIOMIXING(1);

    private int value;

    AudioPropertiesMode(int vaule) {
        this.value = vaule;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioPropertiesMode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode;

        static {
            int[] iArr = new int[AudioPropertiesMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode = iArr;
            try {
                iArr[AudioPropertiesMode.AUDIO_PROPERTIES_MODE_MICROPHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode[AudioPropertiesMode.AUDIO_PROPERTIES_MODE_AUDIOMIXING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioPropertiesMode[ordinal()];
        return (i == 1 || i != 2) ? "AUDIO_PROPERTIES_MODE_MICROPHONE" : "AUDIO_PROPERTIES_MODE_AUDIOMIXING";
    }

    public static AudioPropertiesMode fromId(int id) {
        for (AudioPropertiesMode audioPropertiesMode : values()) {
            if (audioPropertiesMode.value() == id) {
                return audioPropertiesMode;
            }
        }
        return null;
    }
}
