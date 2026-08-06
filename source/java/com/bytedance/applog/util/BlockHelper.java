package com.bytedance.applog.util;

import android.os.SystemClock;
import com.bytedance.applog.log.LoggerImpl;

/* loaded from: classes3.dex */
public class BlockHelper {
    private static long blockInterval = 100;
    private static volatile long blockStartTs = -1;
    private static final long maxBlockInterval = 10000;
    private static volatile boolean sBlock;

    public static void setBlockInterval(long j) {
        blockInterval = Math.max(j, 1L);
    }

    public static long getBlockInterval() {
        return blockInterval;
    }

    public static void beginBlock() {
        sBlock = true;
        blockStartTs = SystemClock.elapsedRealtime();
    }

    public static void endBlock() {
        sBlock = false;
        blockStartTs = -1L;
    }

    public static void tryBlock() {
        while (sBlock) {
            block();
        }
    }

    private static void block() {
        if (sBlock) {
            try {
                if (Math.abs(SystemClock.elapsedRealtime() - blockStartTs) < 10000) {
                    Thread.sleep(blockInterval);
                } else {
                    endBlock();
                }
            } catch (InterruptedException e) {
                LoggerImpl.global().error("BlockHelper: block interrupted!", e, new Object[0]);
            }
        }
    }
}
