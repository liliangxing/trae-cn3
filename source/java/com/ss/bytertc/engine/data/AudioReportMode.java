package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioReportMode {
    AUDIO_REPORT_MODE_NORMAL(0),
    AUDIO_REPORT_MODE_DISCONNECT(1),
    AUDIO_REPORT_MODE_RESET(2);

    private int value;

    AudioReportMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioReportMode$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode;

        static {
            int[] iArr = new int[AudioReportMode.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode = iArr;
            try {
                iArr[AudioReportMode.AUDIO_REPORT_MODE_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode[AudioReportMode.AUDIO_REPORT_MODE_DISCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioReportMode[AudioReportMode.AUDIO_REPORT_MODE_RESET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioReportMode[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "" : "AUDIO_REPORT_MODE_RESET" : "AUDIO_REPORT_MODE_DISCONNECT" : "AUDIO_REPORT_MODE_NORMAL";
    }

    public static AudioReportMode fromId(int id) {
        for (AudioReportMode audioReportMode : values()) {
            if (audioReportMode.value() == id) {
                return audioReportMode;
            }
        }
        return null;
    }
}
