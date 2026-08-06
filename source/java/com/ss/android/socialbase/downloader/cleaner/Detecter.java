package com.ss.android.socialbase.downloader.cleaner;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/* loaded from: classes7.dex */
public class Detecter {
    private static final int COUNT_INIT = 0;
    private static final int DETECT_COUNT_MAX = 3;
    private static final int SMOOTH_COUNT_MAX = 15;
    private static final String TAG = "Detecter";
    private static final int THREAD_STUCK_MAX = 200;
    private static final int THREAD_STUCK_MIN = 50;
    private volatile IDetecterEventCallback mEventCallback;
    private volatile DetecterState mState = DetecterState.DETECTER_INIT;
    private volatile Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private volatile Semaphore mMainThreadResponseSem = new Semaphore(0);
    private ExecutorService mDetecterThreadPool = Executors.newCachedThreadPool();
    private volatile boolean mIsStop = false;
    private int mSmoothHitCount = 0;
    private int mStuckHitCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum DetecterState {
        DETECTER_INIT,
        DETECTER_STUCK,
        DETECTER_SMOOTH
    }

    /* loaded from: classes7.dex */
    interface IDetecterEventCallback {
        void onSmooth();

        void onStuck();
    }

    public Detecter(IDetecterEventCallback iDetecterEventCallback) {
        this.mEventCallback = iDetecterEventCallback;
    }

    public void start() {
        synchronized (this) {
            if (this.mState == DetecterState.DETECTER_INIT) {
                this.mState = DetecterState.DETECTER_SMOOTH;
                this.mDetecterThreadPool.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.cleaner.Detecter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        while (true) {
                            Detecter.this.mMainThreadHandler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.cleaner.Detecter.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Detecter.this.mMainThreadResponseSem.release();
                                }
                            });
                            long currentTimeMillis = System.currentTimeMillis();
                            try {
                                Detecter.this.mMainThreadResponseSem.acquire();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (Detecter.this.mIsStop) {
                                Detecter.this.mIsStop = false;
                                return;
                            } else {
                                Detecter.this.checkStuck(currentTimeMillis, System.currentTimeMillis());
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public void stop() {
        this.mIsStop = true;
        this.mEventCallback = null;
        this.mMainThreadResponseSem.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkStuck(long j, long j2) {
        long j3 = j2 - j;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "CheckStuck", "ping main thread duration=" + j3);
        }
        tryUpdateState(j3);
    }

    private void tryUpdateState(long j) {
        if (j >= 200) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "tryUpdateState", ">200ms enter real stuck");
            }
            this.mSmoothHitCount = 0;
            if (isStuck()) {
                return;
            }
            this.mStuckHitCount = 0;
            transToNewState(DetecterState.DETECTER_STUCK);
            return;
        }
        if (j >= 50) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "tryUpdateState", "50ms<=duration<=200ms enter maybe stuck");
            }
            this.mSmoothHitCount = 0;
            if (isStuck()) {
                return;
            }
            int i = this.mStuckHitCount + 1;
            this.mStuckHitCount = i;
            if (i >= 3) {
                this.mStuckHitCount = 0;
                transToNewState(DetecterState.DETECTER_STUCK);
                return;
            }
            return;
        }
        this.mStuckHitCount = 0;
        if (isSmooth()) {
            return;
        }
        int i2 = this.mSmoothHitCount;
        if (i2 == 15) {
            transToNewState(DetecterState.DETECTER_SMOOTH);
            this.mSmoothHitCount++;
        } else if (i2 < 15) {
            this.mSmoothHitCount = i2 + 1;
        }
    }

    boolean isStuck() {
        return DetecterState.DETECTER_STUCK == this.mState;
    }

    boolean isSmooth() {
        return DetecterState.DETECTER_SMOOTH == this.mState;
    }

    void transToNewState(final DetecterState detecterState) {
        this.mState = detecterState;
        this.mDetecterThreadPool.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.cleaner.Detecter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (DetecterState.DETECTER_STUCK == detecterState) {
                        if (Logger.debug()) {
                            Logger.globalDebug(Detecter.TAG, "transToNewState", "transToNewState to stuck");
                        }
                        if (Detecter.this.mEventCallback != null) {
                            Detecter.this.mEventCallback.onStuck();
                            return;
                        }
                        return;
                    }
                    if (DetecterState.DETECTER_SMOOTH == detecterState) {
                        if (Logger.debug()) {
                            Logger.globalDebug(Detecter.TAG, "transToNewState", "transToNewState to smooth");
                        }
                        if (Detecter.this.mEventCallback != null) {
                            Detecter.this.mEventCallback.onSmooth();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
