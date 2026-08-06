package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IRangeAudio;
import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.data.ReceiveRange;
import com.ss.bytertc.engine.type.AttenuationType;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes7.dex */
public class NativeRangeAudio implements IRangeAudio {
    private static final String TAG = "NativeRangeAudio";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNaiveInstance;
    private final ReentrantReadWriteLock mReadWriteLock;

    public static native void nativeEnableRangeAudio(long rangeAudioPtr, boolean enable);

    public static native int nativeSetAttenuationType(long rangeAudioPtr, int type, float coefficient);

    public static native void nativeSetNoAttenuationFlags(long rangeAudioPtr, String[] flags);

    public static native int nativeUpdatePosition(long rangeAudioPtr, float x, float y, float z);

    public static native int nativeUpdateReceiveRange(long rangeAudioPtr, int min, int max);

    public NativeRangeAudio(long instance) {
        this.mNaiveInstance = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNaiveInstance = instance;
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public void enableRangeAudio(boolean enable) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native RangeAudio is invalid, enableRangeAudio failed.");
            } else {
                nativeEnableRangeAudio(j, enable);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public int updatePosition(Position pos) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native RangeAudio is invalid, updatePosition failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeUpdatePosition(j, pos.x, pos.y, pos.z);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public int updateReceiveRange(ReceiveRange range) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native RangeAudio is invalid, updateReceiveRange failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeUpdateReceiveRange(j, range.min, range.max);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public int setAttenuationModel(AttenuationType type, float coefficient) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNaiveInstance;
            if (j == 0) {
                LogUtil.e(TAG, "native range audio is invalid, setAttenuationModel failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return nativeSetAttenuationType(j, type.value(), coefficient);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public void setNoAttenuationFlags(List<String> flags) {
        this.mJniReadLock.lock();
        try {
            if (this.mNaiveInstance == 0) {
                LogUtil.e(TAG, "native range audio is invalid, setNoAttenuationFlags failed.");
                return;
            }
            String[] strArr = new String[flags.size()];
            flags.toArray(strArr);
            nativeSetNoAttenuationFlags(this.mNaiveInstance, strArr);
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
