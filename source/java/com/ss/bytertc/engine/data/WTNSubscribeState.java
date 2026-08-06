package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum WTNSubscribeState {
    SUBSCRIBED(0),
    UNSUBSCRIBED(1);

    private int value;

    WTNSubscribeState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.WTNSubscribeState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState;

        static {
            int[] iArr = new int[WTNSubscribeState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState = iArr;
            try {
                iArr[WTNSubscribeState.SUBSCRIBED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState[WTNSubscribeState.UNSUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$WTNSubscribeState[ordinal()];
        return i != 1 ? i != 2 ? "" : "kWTNSubscribeStateUnsubscribed" : "kWTNSubscribeStateSubscribed";
    }

    public static WTNSubscribeState fromId(int id) {
        for (WTNSubscribeState wTNSubscribeState : values()) {
            if (wTNSubscribeState.value() == id) {
                return wTNSubscribeState;
            }
        }
        return null;
    }
}
