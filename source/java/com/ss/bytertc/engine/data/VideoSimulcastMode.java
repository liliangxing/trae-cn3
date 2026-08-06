package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum VideoSimulcastMode {
    VIDEO_SIMULCAST_MODE_ONLY_ONE(0),
    VIDEO_SIMULCAST_MODE_ON_DEMAND(1),
    VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST(2);

    private int value;

    VideoSimulcastMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.VideoSimulcastMode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode;

        static {
            int[] iArr = new int[VideoSimulcastMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode = iArr;
            try {
                iArr[VideoSimulcastMode.VIDEO_SIMULCAST_MODE_ONLY_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode[VideoSimulcastMode.VIDEO_SIMULCAST_MODE_ON_DEMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode[VideoSimulcastMode.VIDEO_SIMULCAST_MODE_ALWAYS_SIMULCAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$VideoSimulcastMode[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "valid" : "kVideoSimulcastModeAlwaysSimulcast" : "kVideoSimulcastModeOnDemand" : "kVideoSimulcastModeOnlyOne";
    }

    public static VideoSimulcastMode fromId(int id) {
        for (VideoSimulcastMode videoSimulcastMode : values()) {
            if (videoSimulcastMode.value() == id) {
                return videoSimulcastMode;
            }
        }
        return null;
    }
}
