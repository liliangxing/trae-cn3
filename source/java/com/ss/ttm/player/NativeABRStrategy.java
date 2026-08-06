package com.ss.ttm.player;

import android.util.AndroidRuntimeException;

/* loaded from: classes7.dex */
public class NativeABRStrategy extends ABRStrategy {
    public NativeABRStrategy(long nativeObj) {
        setWeakNativeObj(nativeObj);
    }

    @Override // com.ss.ttm.player.ABRStrategy
    protected int probeBitrate(int type) {
        throw new AndroidRuntimeException("Should not be here");
    }

    @Override // com.ss.ttm.player.ABRStrategy
    protected String probeBitrate(String params) {
        throw new AndroidRuntimeException("Should not be here");
    }

    public static boolean isNativeABRStrategy(ABRStrategy abrStrategy) {
        return abrStrategy instanceof NativeABRStrategy;
    }
}
