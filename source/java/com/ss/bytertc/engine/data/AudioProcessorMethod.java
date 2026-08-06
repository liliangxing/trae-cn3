package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AudioProcessorMethod {
    AUDIO_FRAME_PROCESSOR_RECORD(0),
    AUDIO_FRAME_PROCESSOR_PLAYBACK(1),
    AUDIO_FRAME_PROCESSOR_REMOTE_USER(2),
    AUDIO_FRAME_PROCESSOR_EAR_MONITOR(3),
    AUDIO_FRAME_PROCESSOR_SCREEN(4),
    AUDIO_FRAME_PROCESSOR_RECORD_WITH_REF(5);

    private int value;

    AudioProcessorMethod(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AudioProcessorMethod$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod;

        static {
            int[] iArr = new int[AudioProcessorMethod.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod = iArr;
            try {
                iArr[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_RECORD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_PLAYBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_REMOTE_USER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_EAR_MONITOR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_SCREEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "AUDIO_FRAME_PROCESSOR_SCREEN" : "AUDIO_FRAME_PROCESSOR_EAR_MONITOR" : "AUDIO_FRAME_PROCESSOR_REMOTE_USER" : "AUDIO_FRAME_PROCESSOR_PLAYBACK" : "AUDIO_FRAME_PROCESSOR_RECORD";
    }

    public static AudioProcessorMethod fromId(int id) {
        for (AudioProcessorMethod audioProcessorMethod : values()) {
            if (audioProcessorMethod.value() == id) {
                return audioProcessorMethod;
            }
        }
        return null;
    }
}
