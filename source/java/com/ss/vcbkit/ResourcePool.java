package com.ss.vcbkit;

import java.io.Closeable;

/* loaded from: classes7.dex */
public abstract class ResourcePool implements Closeable {
    public static final int kExpireMs = 1002;
    public static final int kFillSize = 1003;
    public static final int kPoolSize = 1001;
    public static final int kShrinkSize = 1004;
    private long mNativeHandle = nativeCreate();

    /* loaded from: classes7.dex */
    public static final class PoolMetric {
        public int deltaMs;
        public int freeTime;
        public int hitCnt;
        public int totalCnt;
        public int totalTime;
    }

    /* loaded from: classes7.dex */
    public static final class PoolStatus {
        public int busyCount;
        public int capSize;
        public int freeCount;
    }

    /* loaded from: classes7.dex */
    public static class Type {
        public static int MdlThread = 1;
        public static int TTmpThread = 2;
        public static int Unknown = 0;
        public static int VcbThread = 3;
        public static int Voice = 4;
    }

    private native long nativeCreate();

    private native void nativeDelete(long j);

    private native int nativeGetMetric(long j, PoolMetric poolMetric);

    private native int nativeGetStatus(long j, PoolStatus poolStatus);

    private native void nativeOnAcquire(long j, long j2);

    private native void nativeOnCreate(long j, long j2);

    private native void nativeOnDestroy(long j, long j2);

    private native void nativeOnRecycle(long j, long j2);

    private native void nativeSetMaxSize(long j, int i);

    public abstract long getId();

    public abstract boolean setPoolConfig(int i, int i2, Object obj);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeDelete(j);
            this.mNativeHandle = 0L;
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    private static long getId(ResourcePool resourcePool) {
        if (resourcePool != null) {
            return resourcePool.getId();
        }
        return 0L;
    }

    private static boolean setPoolConfig(ResourcePool resourcePool, int i, int i2, Object obj) {
        if (resourcePool != null) {
            return resourcePool.setPoolConfig(i, i2, obj);
        }
        return false;
    }

    public int getPoolStatus(PoolStatus poolStatus) {
        if (poolStatus == null) {
            return 0;
        }
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return nativeGetStatus(j, poolStatus);
    }

    public int getPoolMetric(PoolMetric poolMetric) {
        if (poolMetric == null) {
            return 0;
        }
        long j = this.mNativeHandle;
        if (j == 0) {
            return 0;
        }
        return nativeGetMetric(j, poolMetric);
    }

    public void onItemCreate(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeOnCreate(j2, j);
        }
    }

    public void onItemAcquire(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeOnAcquire(j2, j);
        }
    }

    public void onItemRecycle(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeOnRecycle(j2, j);
        }
    }

    public void onItemDestroy(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeOnDestroy(j2, j);
        }
    }

    public void setMaxSize(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetMaxSize(j, i);
        }
    }
}
