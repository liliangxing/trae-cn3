package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum ChorusCacheSyncMode {
    CHORUS_CACHE_SYNC_MODE_PRODUCER(0),
    CHORUS_CACHE_SYNC_MODE_RETRANSMITTER(1),
    CHORUS_CACHE_SYNC_MODE_CONSUMER(2);

    private int value;

    ChorusCacheSyncMode(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ChorusCacheSyncMode fromId(int id) {
        for (ChorusCacheSyncMode chorusCacheSyncMode : values()) {
            if (chorusCacheSyncMode.value() == id) {
                return chorusCacheSyncMode;
            }
        }
        return null;
    }
}
