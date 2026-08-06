package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum SubscribeState {
    SUBSCRIBED(0),
    UNSUBSCRIBED(1);

    private int value;

    SubscribeState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.SubscribeState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$SubscribeState;

        static {
            int[] iArr = new int[SubscribeState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$SubscribeState = iArr;
            try {
                iArr[SubscribeState.SUBSCRIBED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$SubscribeState[SubscribeState.UNSUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$SubscribeState[ordinal()];
        return i != 1 ? i != 2 ? "" : "kSubscribeStateUnsubscribed" : "kSubscribeStateSubscribed";
    }

    public static SubscribeState fromId(int id) {
        for (SubscribeState subscribeState : values()) {
            if (subscribeState.value() == id) {
                return subscribeState;
            }
        }
        return null;
    }
}
