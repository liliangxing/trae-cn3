package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum PlayerEvent {
    SELECT_AUDIO_TRACK_BEGIN(0),
    SELECT_AUDIO_TRACK_COMPLETED(1),
    SELECT_AUDIO_TRACK_FAILED(2),
    SEEK_BEGIN(3),
    SEEK_COMPLETED(4),
    SEEK_FAILED(5);

    private int value;

    PlayerEvent(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.PlayerEvent$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent;

        static {
            int[] iArr = new int[PlayerEvent.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent = iArr;
            try {
                iArr[PlayerEvent.SELECT_AUDIO_TRACK_BEGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SELECT_AUDIO_TRACK_COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SELECT_AUDIO_TRACK_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SEEK_BEGIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SEEK_COMPLETED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[PlayerEvent.SEEK_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$PlayerEvent[ordinal()]) {
            case 1:
                return "SELECT_AUDIO_TRACK_BEGIN";
            case 2:
                return "SELECT_AUDIO_TRACK_COMPLETED";
            case 3:
                return "SELECT_AUDIO_TRACK_FAILED";
            case 4:
                return "SEEK_BEGIN";
            case 5:
                return "SEEK_COMPLETED";
            case 6:
                return "SEEK_FAILED";
            default:
                return "";
        }
    }

    public static PlayerEvent fromId(int id) {
        for (PlayerEvent playerEvent : values()) {
            if (playerEvent.value() == id) {
                return playerEvent;
            }
        }
        return null;
    }
}
