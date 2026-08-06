package com.bytedance.realx.video;

/* loaded from: classes4.dex */
public enum RXColorSpace {
    kUnknown(0),
    kYCbCrBT601LimitedRange(1),
    kYCbCrBT601FullRange(2),
    kYCbCrBT709LimitedRange(3),
    kYCbCrBT709FullRange(4);

    private int colorSpace;

    RXColorSpace(int colorSpace) {
        this.colorSpace = colorSpace;
    }

    public int getColorSpace() {
        return this.colorSpace;
    }

    private int value() {
        return this.colorSpace;
    }

    /* renamed from: com.bytedance.realx.video.RXColorSpace$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXColorSpace;

        static {
            int[] iArr = new int[RXColorSpace.values().length];
            $SwitchMap$com$bytedance$realx$video$RXColorSpace = iArr;
            try {
                iArr[RXColorSpace.kUnknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT601LimitedRange.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT601FullRange.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT709LimitedRange.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXColorSpace[RXColorSpace.kYCbCrBT709FullRange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$bytedance$realx$video$RXColorSpace[ordinal()];
        return i != 2 ? i != 3 ? i != 4 ? i != 5 ? "kUnknown" : "kYCbCrBT709FullRange" : "kYCbCrBT709LimitedRange" : "kYCbCrBT601FullRange" : "kYCbCrBT601LimitedRange";
    }

    public static RXColorSpace fromId(int id) {
        for (RXColorSpace rXColorSpace : values()) {
            if (rXColorSpace.value() == id) {
                return rXColorSpace;
            }
        }
        return null;
    }
}
