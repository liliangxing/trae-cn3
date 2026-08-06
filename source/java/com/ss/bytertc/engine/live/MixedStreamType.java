package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamType {
    MIXED_STREAM_TYPE_BY_SERVER(0),
    MIXED_STREAM_TYPE_BY_CLIENT(1);

    private int value;

    MixedStreamType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.live.MixedStreamType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$MixedStreamType;

        static {
            int[] iArr = new int[MixedStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$MixedStreamType = iArr;
            try {
                iArr[MixedStreamType.MIXED_STREAM_TYPE_BY_SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$MixedStreamType[MixedStreamType.MIXED_STREAM_TYPE_BY_CLIENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$MixedStreamType[ordinal()];
        return i != 1 ? i != 2 ? "" : "MIXED_STREAM_TYPE_BY_CLIENT" : "MIXED_STREAM_TYPE_BY_SERVER";
    }

    public static MixedStreamType fromId(int id) {
        for (MixedStreamType mixedStreamType : values()) {
            if (mixedStreamType.value() == id) {
                return mixedStreamType;
            }
        }
        return null;
    }
}
