package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum ChorusCacheSyncError {
    CHORUS_CACHE_SYNC_ERROR_OK(0),
    CHORUS_CACHE_SYNC_ERROR_WRONG_STATE(1),
    CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING(2);

    private int value;

    ChorusCacheSyncError(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ChorusCacheSyncError fromId(int id) {
        for (ChorusCacheSyncError chorusCacheSyncError : values()) {
            if (chorusCacheSyncError.value() == id) {
                return chorusCacheSyncError;
            }
        }
        return null;
    }
}
