package com.ss.bytertc.ktv.data;

/* loaded from: classes7.dex */
public enum AudioTrackType {
    ORIGINAL(1),
    ACCOMPANY(2);

    private int value;

    AudioTrackType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.ktv.data.AudioTrackType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType;

        static {
            int[] iArr = new int[AudioTrackType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType = iArr;
            try {
                iArr[AudioTrackType.ACCOMPANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType[AudioTrackType.ORIGINAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType[ordinal()];
        return i != 1 ? i != 2 ? "" : "AUDIO_TRACK_TYPE_ORIGINAL" : "AUDIO_TRACK_TYPE_ACCOMPANY";
    }

    public static AudioTrackType fromId(int id) {
        for (AudioTrackType audioTrackType : values()) {
            if (audioTrackType.value() == id) {
                return audioTrackType;
            }
        }
        return null;
    }
}
