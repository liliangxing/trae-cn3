package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: classes7.dex */
public class NativeLoadControl extends LoadControl {
    @Override // com.ss.ttm.player.LoadControl
    protected int onTrackSelected(int trackType) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.LoadControl
    protected int onCodecStackSelected(int trackType) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.LoadControl
    protected int onFilterStackSelected(int trackType) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.LoadControl
    protected boolean shouldStartPlayback(long bufferedDurationMs, float playbackSpeed, boolean rebuffering) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeLoadControl(LoadControl loadControl) {
        return loadControl instanceof NativeLoadControl;
    }
}
