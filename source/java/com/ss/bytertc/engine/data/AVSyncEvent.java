package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AVSyncEvent {
    INVALID_UID_REPEATED(0);

    private int value;

    AVSyncEvent(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AVSyncEvent$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AVSyncEvent;

        static {
            int[] iArr = new int[AVSyncEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncEvent = iArr;
            try {
                iArr[AVSyncEvent.INVALID_UID_REPEATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AVSyncEvent[ordinal()] != 1 ? "" : "kAVSyncEventInvalidUidRepeated";
    }

    public static AVSyncEvent fromId(int id) {
        for (AVSyncEvent aVSyncEvent : values()) {
            if (aVSyncEvent.value() == id) {
                return aVSyncEvent;
            }
        }
        return null;
    }
}
