package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum AVSyncState {
    AV_SYNC_STATE_STREAM_SYNC_BEGIN(0),
    AV_SYNC_STATE_AUDIO_STREAM_REMOVE(1),
    AV_SYNC_STATE_VIDEO_STREAM_REMOVE(2),
    AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID(3);

    private int value;

    AVSyncState(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.AVSyncState$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AVSyncState;

        static {
            int[] iArr = new int[AVSyncState.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AVSyncState = iArr;
            try {
                iArr[AVSyncState.AV_SYNC_STATE_STREAM_SYNC_BEGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AVSyncState[AVSyncState.AV_SYNC_STATE_AUDIO_STREAM_REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AVSyncState[AVSyncState.AV_SYNC_STATE_VIDEO_STREAM_REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$AVSyncState[AVSyncState.AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AVSyncState[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "AV_SYNC_STATE_SET_AV_SYNC_STRESM_ID" : "AV_SYNC_STATE_VIDEO_STREAM_REMOVE" : "AV_SYNC_STATE_AUDIO_STREAM_REMOVE" : "AV_SYNC_STATE_STREAM_SYNC_BEGIN";
    }

    public static AVSyncState fromId(int id) {
        for (AVSyncState aVSyncState : values()) {
            if (aVSyncState.value() == id) {
                return aVSyncState;
            }
        }
        return null;
    }
}
