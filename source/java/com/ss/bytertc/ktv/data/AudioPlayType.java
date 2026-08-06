package com.ss.bytertc.ktv.data;

/* loaded from: classes7.dex */
public enum AudioPlayType {
    LOCAL(0),
    REMOTE(1),
    LOCAL_AND_REMOTE(2);

    private int value;

    AudioPlayType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.ktv.data.AudioPlayType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType;

        static {
            int[] iArr = new int[AudioPlayType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType = iArr;
            try {
                iArr[AudioPlayType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[AudioPlayType.REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[AudioPlayType.LOCAL_AND_REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : "AUDIO_PLAY_TYPE_LOCAL_AND_REMOTE" : "AUDIO_PLAY_TYPE_REMOTE" : "AUDIO_PLAY_TYPE_LOCAL";
    }

    public static AudioPlayType fromId(int id) {
        for (AudioPlayType audioPlayType : values()) {
            if (audioPlayType.value() == id) {
                return audioPlayType;
            }
        }
        return null;
    }
}
