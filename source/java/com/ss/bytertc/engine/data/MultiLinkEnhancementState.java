package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MultiLinkEnhancementState {
    MULTI_LINK_ENHANCEMENT_STATE_CONNECTED(0),
    MULTI_LINK_ENHANCEMENT_STATE_DISCONNECTED(1);

    private int value;

    MultiLinkEnhancementState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.MultiLinkEnhancementState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState;

        static {
            int[] iArr = new int[MultiLinkEnhancementState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState = iArr;
            try {
                iArr[MultiLinkEnhancementState.MULTI_LINK_ENHANCEMENT_STATE_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState[MultiLinkEnhancementState.MULTI_LINK_ENHANCEMENT_STATE_DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementState[ordinal()];
        return i != 1 ? i != 2 ? "" : "kMultiLinkEnhancementStateDisconnected" : "kMultiLinkEnhancementStateConnected";
    }

    public static MultiLinkEnhancementState fromId(int id) {
        for (MultiLinkEnhancementState multiLinkEnhancementState : values()) {
            if (multiLinkEnhancementState.value() == id) {
                return multiLinkEnhancementState;
            }
        }
        return null;
    }
}
