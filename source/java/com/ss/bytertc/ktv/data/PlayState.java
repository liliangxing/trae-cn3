package com.ss.bytertc.ktv.data;

/* loaded from: classes7.dex */
public enum PlayState {
    PLAYING(1),
    PAUSED(2),
    STOPPED(3),
    FAILED(4),
    FINISHED(5);

    private int value;

    PlayState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.ktv.data.PlayState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$PlayState;

        static {
            int[] iArr = new int[PlayState.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$PlayState = iArr;
            try {
                iArr[PlayState.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$PlayState[PlayState.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$PlayState[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "PLAY_STATE_FINISHED" : "PLAY_STATE_FAILED" : "PLAY_STATE_STOPPED" : "PLAY_STATE_PAUSED" : "PLAY_STATE_PLAYING";
    }

    public static PlayState fromId(int id) {
        for (PlayState playState : values()) {
            if (playState.value() == id) {
                return playState;
            }
        }
        return null;
    }
}
