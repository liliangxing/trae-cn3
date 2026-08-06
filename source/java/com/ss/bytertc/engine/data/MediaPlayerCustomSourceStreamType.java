package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MediaPlayerCustomSourceStreamType {
    RAW(0),
    ENCODED(1);

    private int value;

    MediaPlayerCustomSourceStreamType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.MediaPlayerCustomSourceStreamType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType;

        static {
            int[] iArr = new int[MediaPlayerCustomSourceStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType = iArr;
            try {
                iArr[MediaPlayerCustomSourceStreamType.RAW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType[MediaPlayerCustomSourceStreamType.ENCODED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MediaPlayerCustomSourceStreamType[ordinal()];
        return i != 1 ? i != 2 ? "" : "ENCODED" : "RAW";
    }

    public static MediaPlayerCustomSourceStreamType fromId(int id) {
        for (MediaPlayerCustomSourceStreamType mediaPlayerCustomSourceStreamType : values()) {
            if (mediaPlayerCustomSourceStreamType.value() == id) {
                return mediaPlayerCustomSourceStreamType;
            }
        }
        return null;
    }
}
