package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.cleaner.Detecter;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CleanerImpl {
    private static final String TAG = "CleanerImpl";
    private Semaphore mCleanCompletedSem = new Semaphore(0);
    private volatile boolean mIsStop = false;
    private List<CleanerHandler> mCleaners = new CopyOnWriteArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface CleanerHandler {
        void start();
    }

    public CleanerImpl(CleanerConfig cleanerConfig) {
        if (CacheKeyCleaner.isEnabled(cleanerConfig)) {
            this.mCleaners.add(new CacheKeyCleaner(this, cleanerConfig));
        }
        if (DirectoryCleaner.isEnabled()) {
            this.mCleaners.add(new DirectoryCleaner(this, cleanerConfig));
        }
    }

    public void startSync() throws InterruptedException {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "startSync", "Run");
        }
        if (this.mCleaners.isEmpty()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Detecter detecter = new Detecter(new Detecter.IDetecterEventCallback() { // from class: com.ss.android.socialbase.downloader.cleaner.CleanerImpl.1
            @Override // com.ss.android.socialbase.downloader.cleaner.Detecter.IDetecterEventCallback
            public void onStuck() {
                if (Logger.debug()) {
                    Logger.globalDebug(CleanerImpl.TAG, "startSync", "enter onStuck");
                }
                CleanerImpl.this.mIsStop = true;
            }

            @Override // com.ss.android.socialbase.downloader.cleaner.Detecter.IDetecterEventCallback
            public void onSmooth() {
                if (Logger.debug()) {
                    Logger.globalDebug(CleanerImpl.TAG, "startSync", "enter onSmooth");
                }
                CleanerImpl.this.startClean();
            }
        });
        detecter.start();
        startClean();
        this.mCleanCompletedSem.acquire();
        detecter.stop();
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "startSync", "clear all cache end---cost time=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startClean() {
        if (this.mIsStop) {
            return;
        }
        Iterator<CleanerHandler> it = this.mCleaners.iterator();
        while (it.hasNext()) {
            it.next().start();
            if (this.mIsStop) {
                this.mIsStop = false;
                return;
            }
        }
        this.mCleanCompletedSem.release();
    }

    public boolean isStop() {
        return this.mIsStop;
    }
}
