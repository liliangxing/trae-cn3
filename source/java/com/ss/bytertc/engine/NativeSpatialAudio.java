package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.PositionInfo;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes7.dex */
public class NativeSpatialAudio implements ISpatialAudio {
    private static final String TAG = "NativeSpatialAudio";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNaiveInstance;
    private final ReentrantReadWriteLock mReadWriteLock;

    public static native void nativeDisableRemoteOrientation(long instance);

    public static native void nativeEnableSpatialAudio(long instance, boolean enable);

    public static native int nativeRemoveAllRemotePosition(long instance);

    public static native int nativeRemoveRemotePosition(long instance, String uid);

    public static native int nativeUpdateRemotePosition(long instance, String uid, PositionInfo positionInfo);

    public static native int nativeUpdateSelfPosition(long instance, PositionInfo positionInfo);

    public NativeSpatialAudio(long instance) {
        this.mNaiveInstance = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNaiveInstance = instance;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public void enableSpatialAudio(boolean enable) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, enableSpatialAudio failed.");
            } else {
                nativeEnableSpatialAudio(j, enable);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public void disableRemoteOrientation() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, disableRemoteOrientation failed.");
            } else {
                nativeDisableRemoteOrientation(j);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateSelfPosition(PositionInfo positionInfo) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeUpdateSelfPosition(j, positionInfo);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateRemotePosition(String uid, PositionInfo positionInfo) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeUpdateRemotePosition(j, uid, positionInfo);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int removeRemotePosition(String uid) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeRemoveRemotePosition(j, uid);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int removeAllRemotePosition() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeRemoveAllRemotePosition(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            this.mNaiveInstance = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
