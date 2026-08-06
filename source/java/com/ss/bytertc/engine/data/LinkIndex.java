package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum LinkIndex {
    LINK_INDEX_MAIN(0),
    LINK_INDEX_STANDBY(1);

    private int value;

    LinkIndex(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.LinkIndex$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$LinkIndex;

        static {
            int[] iArr = new int[LinkIndex.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$LinkIndex = iArr;
            try {
                iArr[LinkIndex.LINK_INDEX_MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$LinkIndex[LinkIndex.LINK_INDEX_STANDBY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$LinkIndex[ordinal()];
        return i != 1 ? i != 2 ? "valid" : "kLinkIndexStandby" : "kLinkIndexMain";
    }

    public static LinkIndex fromId(int id) {
        for (LinkIndex linkIndex : values()) {
            if (linkIndex.value() == id) {
                return linkIndex;
            }
        }
        return null;
    }
}
