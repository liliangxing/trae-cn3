package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum MultiLinkEnhancementMode {
    MULTI_LINK_ENHANCEMENT_MODE_ADAPTIVE(0),
    MULTI_LINK_ENHANCEMENT_MODE_FORCE(1);

    private int value;

    MultiLinkEnhancementMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.MultiLinkEnhancementMode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode;

        static {
            int[] iArr = new int[MultiLinkEnhancementMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode = iArr;
            try {
                iArr[MultiLinkEnhancementMode.MULTI_LINK_ENHANCEMENT_MODE_ADAPTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode[MultiLinkEnhancementMode.MULTI_LINK_ENHANCEMENT_MODE_FORCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$MultiLinkEnhancementMode[ordinal()];
        return i != 1 ? i != 2 ? "" : "kMultiLinkEnhancementModeForce" : "kMultiLinkEnhancementModeAdaptive";
    }

    public static MultiLinkEnhancementMode fromId(int id) {
        for (MultiLinkEnhancementMode multiLinkEnhancementMode : values()) {
            if (multiLinkEnhancementMode.value() == id) {
                return multiLinkEnhancementMode;
            }
        }
        return null;
    }
}
