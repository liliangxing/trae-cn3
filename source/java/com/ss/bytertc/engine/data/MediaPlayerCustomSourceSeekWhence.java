package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MediaPlayerCustomSourceSeekWhence {
    SET(0),
    CUR(1),
    END(2),
    SIZE(3);

    private int value;

    MediaPlayerCustomSourceSeekWhence(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence;

        static {
            int[] iArr = new int[MediaPlayerCustomSourceSeekWhence.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence = iArr;
            try {
                iArr[MediaPlayerCustomSourceSeekWhence.SET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[MediaPlayerCustomSourceSeekWhence.CUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[MediaPlayerCustomSourceSeekWhence.END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[MediaPlayerCustomSourceSeekWhence.SIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceSeekWhence[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "SIZE" : "END" : "CUR" : "SET";
    }

    public static MediaPlayerCustomSourceSeekWhence fromId(int id) {
        for (MediaPlayerCustomSourceSeekWhence mediaPlayerCustomSourceSeekWhence : values()) {
            if (mediaPlayerCustomSourceSeekWhence.value() == id) {
                return mediaPlayerCustomSourceSeekWhence;
            }
        }
        return null;
    }
}
