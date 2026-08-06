package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: classes7.dex */
public class NativeMaskInfo extends MaskInfo {
    @Override // com.ss.ttm.player.MaskInfo
    protected void onMaskInfoCallback(int code, int pts, String info) {
        throw new AndroidRuntimeException("Should not be here");
    }

    private static boolean isNativeMaskInfo(MaskInfo maskInfo) {
        return maskInfo instanceof NativeMaskInfo;
    }
}
