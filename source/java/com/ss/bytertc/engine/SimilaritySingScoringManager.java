package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISimilaritySingScoringManager;
import com.ss.bytertc.engine.data.SimilaritySingScoringConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class SimilaritySingScoringManager extends ISimilaritySingScoringManager {
    private static final String TAG = "SimilaritySingScoringManager";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeSimilaritySingScoringManager;
    private final ReentrantReadWriteLock mReadWriteLock;

    public SimilaritySingScoringManager(long nativeSingScoringManager) {
        this.mNativeSimilaritySingScoringManager = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeSimilaritySingScoringManager = nativeSingScoringManager;
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int startSingScoring(SimilaritySingScoringConfig config) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeSimilaritySingScoringManager == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, startSingScoring failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            if (config != null && config.refStream != null && config.mode != null) {
                return NativeSimilaritySingScoringManagerFunctions.nativeStartSimilaritySingScoring(this.mNativeSimilaritySingScoringManager, config.calculateIntervalMs, config.mode.value(), config.refStream.roomId, config.refStream.userId, config.refStream.streamIndex.value());
            }
            LogUtil.m216e(TAG, "native SingScoringManager is invalid, invalid param.");
            this.mJniReadLock.unlock();
            return -2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int stopSingScoring() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSimilaritySingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, stopSingScoring failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSimilaritySingScoringManagerFunctions.nativeStopSimilaritySingScoring(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int getLastScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSimilaritySingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getLastSentenceScore failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSimilaritySingScoringManagerFunctions.nativeGetLastSimilarityScore(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int getTotalScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSimilaritySingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getTotalScore failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSimilaritySingScoringManagerFunctions.nativeGetTotalSimilarityScore(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int getAverageScore() {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeSimilaritySingScoringManager;
            if (j == 0) {
                LogUtil.m216e(TAG, "native SingScoringManager is invalid, getAverageScore failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            return NativeSimilaritySingScoringManagerFunctions.nativeGetAverageSimilarityScore(j);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            this.mNativeSimilaritySingScoringManager = 0L;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
