package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: classes7.dex */
public class NativeSubInfo extends SubInfo {
    @Override // com.ss.ttm.player.SubInfo
    protected void onSubInfoCallback(int code, int pts, String info) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubInfoCallback2(int code, String info) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubSwitchCompleted(int success, int subId) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubLoadFinished(int code) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.SubInfo
    protected void onSubLoadFinished2(int code, String info) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeSubInfo(SubInfo subInfo) {
        return subInfo instanceof NativeSubInfo;
    }
}
