package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum SimulcastStreamType {
    SIMULCAST_STREAM_TYPE_WEAK(0),
    SIMULCAST_STREAM_TYPE_LOW(1),
    SIMULCAST_STREAM_TYPE_MID(2),
    SIMULCAST_STREAM_TYPE_HIGH(3);

    private int value;

    SimulcastStreamType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.SimulcastStreamType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType;

        static {
            int[] iArr = new int[SimulcastStreamType.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType = iArr;
            try {
                iArr[SimulcastStreamType.SIMULCAST_STREAM_TYPE_WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[SimulcastStreamType.SIMULCAST_STREAM_TYPE_LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[SimulcastStreamType.SIMULCAST_STREAM_TYPE_MID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[SimulcastStreamType.SIMULCAST_STREAM_TYPE_HIGH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$SimulcastStreamType[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "valid" : "kSimulcastStreamTypeHigh" : "kSimulcastStreamTypeMid" : "kSimulcastStreamTypeLow" : "kSimulcastStreamTypeWeak";
    }

    public static SimulcastStreamType fromId(int id) {
        for (SimulcastStreamType simulcastStreamType : values()) {
            if (simulcastStreamType.value() == id) {
                return simulcastStreamType;
            }
        }
        return null;
    }
}
