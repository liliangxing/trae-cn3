package com.ss.ttm.player;

/* loaded from: classes7.dex */
public abstract class LoadControl extends NativeObject {
    protected abstract int onCodecStackSelected(int trackType);

    protected abstract int onFilterStackSelected(int trackType);

    protected abstract int onTrackSelected(int trackType);

    protected abstract boolean shouldStartPlayback(long bufferedDurationMs, float playbackSpeed, boolean rebuffering);
}
