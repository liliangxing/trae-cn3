package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISingScoringManager;
import com.ss.bytertc.engine.data.SingScoringConfig;
import com.ss.bytertc.engine.data.StandardPitchInfo;
import com.ss.bytertc.engine.handler.NativeSingScoringEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SingScoringManager extends ISingScoringManager {
    private static final String TAG = "SingScoringManager";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    NativeSingScoringEventHandler mNativeHandler;
    private long mNativeRTCVideoEngine;
    private long mNativeSingScoringManager;
    private final ReentrantReadWriteLock mReadWriteLock;
    private WeakReference<ISingScoringEventHandler> mSingScoringEventHandler;

    public SingScoringManager(long nativeRTCVideoEngine, long nativeSingScoringManager) {
        this.mNativeSingScoringManager = 0L;
        this.mNativeRTCVideoEngine = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeRTCVideoEngine = nativeRTCVideoEngine;
        this.mNativeSingScoringManager = nativeSingScoringManager;
        this.mNativeHandler = new NativeSingScoringEventHandler(this);
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int initSingScoring(String singScoringAppkey, String singAcoringToken, ISingScoringEventHandler handler) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeSingScoringManager == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, initSingScoring failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            this.mSingScoringEventHandler = new WeakReference<>(handler);
            if (handler == null) {
                return NativeSingScoringManagerFunctions.nativeInitSingScoring(this.mNativeRTCVideoEngine, this.mNativeSingScoringManager, singScoringAppkey, singAcoringToken, null);
            }
            return NativeSingScoringManagerFunctions.nativeInitSingScoring(this.mNativeRTCVideoEngine, this.mNativeSingScoringManager, singScoringAppkey, singAcoringToken, this.mNativeHandler);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int setSingScoringConfig(SingScoringConfig config) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, setSingScoringConfig failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSingScoringManagerFunctions.nativeSetSingScoringConfig(j, config.sampleRate.value(), config.mode.value(), config.lyricsFilepath, config.midiFilepath);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public List<StandardPitchInfo> getStandardPitchInfo(String midiFilepath) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getStandardPitchInfo failed.");
                this.mJniReadLock.unlock();
                return null;
            }
            return Arrays.asList(NativeSingScoringManagerFunctions.nativeGetStandardPitchInfo(j, midiFilepath));
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int startSingScoring(int position, int scoringInfoInterval) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, startSingScoring failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSingScoringManagerFunctions.nativeStartSingScoring(j, position, scoringInfoInterval);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int stopSingScoring() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, stopSingScoring failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSingScoringManagerFunctions.nativeStopSingScoring(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getLastSentenceScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getLastSentenceScore failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSingScoringManagerFunctions.nativeGetLastSentenceScore(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getTotalScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getTotalScore failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSingScoringManagerFunctions.nativeGetTotalScore(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getAverageScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getAverageScore failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSingScoringManagerFunctions.nativeGetAverageScore(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public ISingScoringEventHandler getSingScoringEventHandler() {
        return this.mSingScoringEventHandler.get();
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            this.mNativeSingScoringManager = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
