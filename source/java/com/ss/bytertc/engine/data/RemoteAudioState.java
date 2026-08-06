package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum RemoteAudioState {
    REMOTE_AUDIO_STATE_STOPPED(0),
    REMOTE_AUDIO_STATE_STARTING(1),
    REMOTE_AUDIO_STATE_DECODING(2),
    REMOTE_AUDIO_STATE_FROZEN(3),
    REMOTE_AUDIO_STATE_FAILED(4);

    private int value;

    RemoteAudioState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.RemoteAudioState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState;

        static {
            int[] iArr = new int[RemoteAudioState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState = iArr;
            try {
                iArr[RemoteAudioState.REMOTE_AUDIO_STATE_STOPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_DECODING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_FROZEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[RemoteAudioState.REMOTE_AUDIO_STATE_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$RemoteAudioState[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "kRemoteAudioStateFailed" : "kRemoteAudioStateFrozen" : "kRemoteAudioStateDecoding" : "kRemoteAudioStateStarting" : "kRemoteAudioStateStopped";
    }

    public static RemoteAudioState fromId(int id) {
        for (RemoteAudioState remoteAudioState : values()) {
            if (remoteAudioState.value() == id) {
                return remoteAudioState;
            }
        }
        return null;
    }
}
