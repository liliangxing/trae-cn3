package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum PublishState {
    PUBLISHED(0),
    UNPUBLISHED(1);

    private int value;

    PublishState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.PublishState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PublishState;

        static {
            int[] iArr = new int[PublishState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PublishState = iArr;
            try {
                iArr[PublishState.PUBLISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$PublishState[PublishState.UNPUBLISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PublishState[ordinal()];
        return i != 1 ? i != 2 ? "" : "kPublishStateUnpublished" : "kPublishStatePublished";
    }

    public static PublishState fromId(int id) {
        for (PublishState publishState : values()) {
            if (publishState.value() == id) {
                return publishState;
            }
        }
        return null;
    }
}
