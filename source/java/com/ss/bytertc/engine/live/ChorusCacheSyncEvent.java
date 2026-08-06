package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public enum ChorusCacheSyncEvent {
    CHORUS_CACHE_SYNC_EVENT_START_SUCCESS(0),
    CHORUS_CACHE_SYNC_EVENT_START_FAILED(1);

    private int value;

    ChorusCacheSyncEvent(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static ChorusCacheSyncEvent fromId(int id) {
        for (ChorusCacheSyncEvent chorusCacheSyncEvent : values()) {
            if (chorusCacheSyncEvent.value() == id) {
                return chorusCacheSyncEvent;
            }
        }
        return null;
    }
}
