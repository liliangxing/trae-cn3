package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum SingleStreamTaskErrorCode {
    OK(0),
    BASE(1090),
    UNKNOWN_BY_SERVER(1091),
    SIGNAL_REQUEST_TIMEOUT(1092);

    private int value;

    SingleStreamTaskErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.live.SingleStreamTaskErrorCode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode;

        static {
            int[] iArr = new int[SingleStreamTaskErrorCode.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode = iArr;
            try {
                iArr[SingleStreamTaskErrorCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[SingleStreamTaskErrorCode.BASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[SingleStreamTaskErrorCode.UNKNOWN_BY_SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[SingleStreamTaskErrorCode.SIGNAL_REQUEST_TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskErrorCode[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "SIGNAL_REQUEST_TIMEOUT" : "UNKNOWN_BY_SERVER" : "BASE" : "OK";
    }

    public static SingleStreamTaskErrorCode fromId(int id) {
        for (SingleStreamTaskErrorCode singleStreamTaskErrorCode : values()) {
            if (singleStreamTaskErrorCode.value() == id) {
                return singleStreamTaskErrorCode;
            }
        }
        return null;
    }
}
