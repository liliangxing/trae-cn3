package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioVADType {
    NO_SPEECH(0),
    SPEECH(1);

    private int value;

    AudioVADType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.type.AudioVADType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$AudioVADType;

        static {
            int[] iArr = new int[AudioVADType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$AudioVADType = iArr;
            try {
                iArr[AudioVADType.NO_SPEECH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioVADType[AudioVADType.SPEECH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$AudioVADType[ordinal()];
        return i != 1 ? i != 2 ? "valid" : "kAudioVADTypeSpeech" : "kAudioVADTypeNoSpeech";
    }

    public static AudioVADType fromId(int id) {
        for (AudioVADType audioVADType : values()) {
            if (audioVADType.value() == id) {
                return audioVADType;
            }
        }
        return null;
    }
}
