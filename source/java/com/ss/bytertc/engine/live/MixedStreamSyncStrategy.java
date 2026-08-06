package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum MixedStreamSyncStrategy {
    MIXED_STREAM_SYNC_STRATEGY_NO_SYNC(0),
    MIXED_STREAM_SYNC_STRATEGY_AUDIO_PRECISE_SYNC(1),
    MIXED_STREAM_SYNC_STRATEGY_SIMPLEX_MODE_SYNC(2);

    private int syncStrategy;

    MixedStreamSyncStrategy(int value) {
        this.syncStrategy = value;
    }

    public int getValue() {
        return this.syncStrategy;
    }
}
