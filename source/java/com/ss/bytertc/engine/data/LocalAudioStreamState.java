package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum LocalAudioStreamState {
    LOCAL_AUDIO_STREAM_STATE_STOPPED(0),
    LOCAL_AUDIO_STREAM_STATE_RECORDING(1),
    LOCAL_AUDIO_STREAM_STATE_ENCODING(2),
    LOCAL_AUDIO_STREAM_STATE_FAILED(3);

    private int value;

    LocalAudioStreamState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.LocalAudioStreamState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState;

        static {
            int[] iArr = new int[LocalAudioStreamState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState = iArr;
            try {
                iArr[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_RECORDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_ENCODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[LocalAudioStreamState.LOCAL_AUDIO_STREAM_STATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$LocalAudioStreamState[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "kLocalAudioStreamStateFailed" : "kLocalAudioStreamStateEncoding" : "kLocalAudioStreamStateRecording" : "kLocalAudioStreamStateStopped";
    }

    public static LocalAudioStreamState fromId(int id) {
        for (LocalAudioStreamState localAudioStreamState : values()) {
            if (localAudioStreamState.value() == id) {
                return localAudioStreamState;
            }
        }
        return null;
    }
}
