package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MediaPlayerCustomSourceMode {
    PUSH(0),
    PULL(1);

    private int value;

    MediaPlayerCustomSourceMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceMode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode;

        static {
            int[] iArr = new int[MediaPlayerCustomSourceMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode = iArr;
            try {
                iArr[MediaPlayerCustomSourceMode.PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode[MediaPlayerCustomSourceMode.PULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceMode[ordinal()];
        return i != 1 ? i != 2 ? "" : "PULL" : "PUSH";
    }

    public static MediaPlayerCustomSourceMode fromId(int id) {
        for (MediaPlayerCustomSourceMode mediaPlayerCustomSourceMode : values()) {
            if (mediaPlayerCustomSourceMode.value() == id) {
                return mediaPlayerCustomSourceMode;
            }
        }
        return null;
    }
}
