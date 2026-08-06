package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum SingleStreamTaskEvent {
    BASE(0),
    START_SUCCESS(1),
    START_FAILED(2),
    STOP_SUCCESS(3),
    STOP_FAILED(4),
    WARNING(5);

    private int value;

    SingleStreamTaskEvent(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.live.SingleStreamTaskEvent$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent;

        static {
            int[] iArr = new int[SingleStreamTaskEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent = iArr;
            try {
                iArr[SingleStreamTaskEvent.BASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.START_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.START_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.STOP_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.STOP_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[SingleStreamTaskEvent.WARNING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$live$SingleStreamTaskEvent[ordinal()]) {
            case 1:
                return "BASE";
            case 2:
                return "START_SUCCESS";
            case 3:
                return "START_FAILED";
            case 4:
                return "STREAM_MIXING_STOP_SUCCESS";
            case 5:
                return "STREAM_MIXING_STOP_FAILED";
            case 6:
                return "WARNING";
            default:
                return "";
        }
    }

    public static SingleStreamTaskEvent fromId(int id) {
        for (SingleStreamTaskEvent singleStreamTaskEvent : values()) {
            if (singleStreamTaskEvent.value() == id) {
                return singleStreamTaskEvent;
            }
        }
        return null;
    }
}
