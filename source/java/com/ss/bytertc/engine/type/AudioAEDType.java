package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioAEDType {
    NO_MUSIC(0),
    MUSIC(1);

    private int value;

    AudioAEDType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.type.AudioAEDType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$AudioAEDType;

        static {
            int[] iArr = new int[AudioAEDType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$AudioAEDType = iArr;
            try {
                iArr[AudioAEDType.NO_MUSIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioAEDType[AudioAEDType.MUSIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$AudioAEDType[ordinal()];
        return i != 1 ? i != 2 ? "" : "kAudioAEDTypeMusic" : "kAudioAEDTypeNoMusic";
    }

    public static AudioAEDType fromId(int id) {
        for (AudioAEDType audioAEDType : values()) {
            if (audioAEDType.value() == id) {
                return audioAEDType;
            }
        }
        return null;
    }
}
