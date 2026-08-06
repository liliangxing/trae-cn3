package com.bytedance.apm.block;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class NpthApmBlockApi {
    private static BlockInfoCallback blockInfoCallback;
    private static Runnable sAnrListener;
    private static Runnable sSigQuitEndListener;
    private static Runnable sSigQuitListener;

    /* loaded from: classes3.dex */
    public interface BlockInfoCallback {
        JSONObject getRecentBlockInfo();
    }

    public static void notifySigQuit() {
    }

    public static void notifySigQuitEnd() {
    }

    public static void setBlockInfoCallback(BlockInfoCallback blockInfoCallback2) {
        if (blockInfoCallback == null) {
            blockInfoCallback = blockInfoCallback2;
        }
    }

    public static JSONObject getRecentBlockInfoWhenANR() {
        BlockInfoCallback blockInfoCallback2 = blockInfoCallback;
        if (blockInfoCallback2 != null) {
            return blockInfoCallback2.getRecentBlockInfo();
        }
        return null;
    }

    public static void notifyANR() {
        Runnable runnable = sAnrListener;
        if (runnable != null) {
            runnable.run();
        }
    }

    static void setAnrListener(Runnable runnable) {
        sAnrListener = runnable;
    }

    static void setSigQuitListener(Runnable runnable) {
        sSigQuitListener = runnable;
    }

    static void setSigQuitEndListener(Runnable runnable) {
        sSigQuitEndListener = runnable;
    }
}
