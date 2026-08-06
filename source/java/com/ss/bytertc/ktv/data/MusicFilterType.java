package com.ss.bytertc.ktv.data;

/* loaded from: classes7.dex */
public enum MusicFilterType {
    NONE(0),
    WITHOUT_LYRIC(1),
    UNSUPPORTED_SCORE(2),
    UNSUPPORTED_ACCOMPANY(4),
    UNSUPPORTED_CLIMAX(8);

    private int value;

    MusicFilterType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.ktv.data.MusicFilterType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType;

        static {
            int[] iArr = new int[MusicFilterType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType = iArr;
            try {
                iArr[MusicFilterType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.WITHOUT_LYRIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.UNSUPPORTED_SCORE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.UNSUPPORTED_ACCOMPANY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[MusicFilterType.UNSUPPORTED_CLIMAX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$MusicFilterType[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "MUSIC_FILTER_TYPE_UNSUPPORTED_CLIMAX" : "MUSIC_FILTER_TYPE_UNSUPPORTED_ACCOMPANY" : "MUSIC_FILTER_TYPE_UNSUPPORTED_SCORE" : "MUSIC_FILTER_TYPE_WITHOUT_LYRIC" : "MUSIC_FILTER_TYPE_NONE";
    }

    public static MusicFilterType fromId(int id) {
        for (MusicFilterType musicFilterType : values()) {
            if (musicFilterType.value() == id) {
                return musicFilterType;
            }
        }
        return null;
    }
}
