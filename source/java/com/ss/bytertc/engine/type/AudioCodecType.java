package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum AudioCodecType {
    NONE(0),
    OPUS(1),
    AAC(2),
    AACLC(3),
    AACHEV1(4),
    AACHEV2(5),
    AACLCADTS(6);

    private int value;

    AudioCodecType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.type.AudioCodecType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType;

        static {
            int[] iArr = new int[AudioCodecType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType = iArr;
            try {
                iArr[AudioCodecType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.OPUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AAC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACLC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACHEV1.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACHEV2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACLCADTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[ordinal()]) {
            case 1:
                return "kAudioCodecTypeNone";
            case 2:
                return "kAudioCodecTypeOpus";
            case 3:
                return "kAudioCodecTypeAAC";
            case 4:
                return "kAudioCodecTypeAACLC";
            case 5:
                return "kAudioCodecTypeAACHEv1";
            case 6:
                return "kAudioCodecTypeAACHEv2";
            case 7:
                return "kAudioCodecTypeAACLCadts";
            default:
                return "";
        }
    }

    public static AudioCodecType fromId(int id) {
        for (AudioCodecType audioCodecType : values()) {
            if (audioCodecType.value() == id) {
                return audioCodecType;
            }
        }
        return null;
    }
}
