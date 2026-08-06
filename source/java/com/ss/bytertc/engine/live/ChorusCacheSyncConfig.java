package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public class ChorusCacheSyncConfig {
    private int maxCacheTimeMs = 2000;
    private ChorusCacheSyncMode mode = ChorusCacheSyncMode.CHORUS_CACHE_SYNC_MODE_RETRANSMITTER;
    private int videoFps = 15;

    public int getMaxCacheTimeMs() {
        return this.maxCacheTimeMs;
    }

    public ChorusCacheSyncConfig setMaxCacheTimeMs(int maxCacheTimeMs) {
        this.maxCacheTimeMs = maxCacheTimeMs;
        return this;
    }

    public ChorusCacheSyncConfig setMode(ChorusCacheSyncMode mode) {
        this.mode = mode;
        return this;
    }

    public ChorusCacheSyncMode getMode() {
        return this.mode;
    }

    public ChorusCacheSyncConfig setVideoFps(int videoFps) {
        this.videoFps = videoFps;
        return this;
    }

    public int getVideoFps() {
        return this.videoFps;
    }

    public int getChorusCacheSyncConfigMode() {
        return this.mode.value();
    }

    public int getChorusCacheSyncConfigMaxCacheTimeMs() {
        return this.maxCacheTimeMs;
    }

    public int getChorusCacheSyncConfigVideoFps() {
        return this.videoFps;
    }
}
