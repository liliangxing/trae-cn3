package com.bytedance.keva;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.bytedance.Interface.ICleanCacheMessage;
import com.bytedance.Interface.IKevaCacheClear;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class KevaCacheManager {
    public static boolean IS_LOW_MEMORY;
    private static KevaCacheManager kevaCacheManagerInstance;
    private Thread delayTimeClearCacheThread;
    private Long lastClearTime;
    private final int mCacheClearExpirationTime;
    private ICleanCacheMessage mICleanCacheMessage;
    private final int mIntervalMillisTime;
    private final boolean mIsNeedReleaseNativeMemory;
    private final boolean mIsOpenReleaseJavaMemory;
    private static final AtomicBoolean mStartClear = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<IKevaCacheClear> kevaImplListener = new ConcurrentLinkedQueue<>();

    public static KevaCacheManager getInstance() {
        return kevaCacheManagerInstance;
    }

    public void setICleanCacheMessage(ICleanCacheMessage iCleanCacheMessage) {
        if (this.mICleanCacheMessage == null) {
            this.mICleanCacheMessage = iCleanCacheMessage;
        }
    }

    void cleanCache(int i, boolean z) {
        Iterator<IKevaCacheClear> it = kevaImplListener.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            IKevaCacheClear next = it.next();
            String repoName = next.getRepoName();
            long clearCache = next.clearCache(i, z);
            ICleanCacheMessage iCleanCacheMessage = this.mICleanCacheMessage;
            if (iCleanCacheMessage != null) {
                iCleanCacheMessage.cleanCacheMessage(repoName, clearCache);
            }
            i2 = (int) (i2 + clearCache);
        }
        ICleanCacheMessage iCleanCacheMessage2 = this.mICleanCacheMessage;
        if (iCleanCacheMessage2 != null) {
            iCleanCacheMessage2.cleanCacheMessage(null, i2);
        }
    }

    public void startDelayClearCache() {
        if (this.mIsOpenReleaseJavaMemory && this.delayTimeClearCacheThread == null) {
            this.lastClearTime = Long.valueOf(System.currentTimeMillis());
            Thread thread = new Thread() { // from class: com.bytedance.keva.KevaCacheManager.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (KevaCacheManager.mStartClear.compareAndSet(false, true)) {
                            if (currentTimeMillis - KevaCacheManager.this.lastClearTime.longValue() <= KevaCacheManager.this.mIntervalMillisTime) {
                                KevaCacheManager.mStartClear.set(false);
                            } else {
                                KevaCacheManager.IS_LOW_MEMORY = false;
                                KevaCacheManager kevaCacheManager = KevaCacheManager.this;
                                kevaCacheManager.cleanCache(kevaCacheManager.mCacheClearExpirationTime, KevaCacheManager.this.mIsNeedReleaseNativeMemory);
                                KevaCacheManager.mStartClear.set(false);
                                return;
                            }
                        }
                        try {
                            sleep(KevaCacheManager.this.mIntervalMillisTime);
                            Log.d("KevaCacheManage", "delayTimeClearCacheThread wakeup");
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            };
            this.delayTimeClearCacheThread = thread;
            thread.start();
        }
    }

    private KevaCacheManager(boolean z, int i, int i2, boolean z2) {
        this.mICleanCacheMessage = null;
        this.mIntervalMillisTime = i;
        this.mCacheClearExpirationTime = i2;
        this.mIsNeedReleaseNativeMemory = z2;
        this.mIsOpenReleaseJavaMemory = z;
    }

    public static KevaCacheManager init(Context context, boolean z, int i, int i2, boolean z2) {
        KevaCacheManager kevaCacheManager = kevaCacheManagerInstance;
        return kevaCacheManager != null ? kevaCacheManager : new KevaCacheManager(context, z, i, i2, z2);
    }

    private KevaCacheManager(Context context, boolean z, int i, int i2, boolean z2) {
        this(z, i, i2, z2);
        InitLowMemoryListener(context);
        kevaCacheManagerInstance = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerClearListener(IKevaCacheClear iKevaCacheClear) {
        kevaImplListener.add(iKevaCacheClear);
    }

    private void InitLowMemoryListener(Context context) {
        if (this.mIsOpenReleaseJavaMemory) {
            if (context instanceof Activity) {
                context = context.getApplicationContext();
            } else if (!(context instanceof Application)) {
                return;
            }
            ((Application) context).registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.bytedance.keva.KevaCacheManager.2
                private final Runnable realTimeClearCacheThread = new Runnable() { // from class: com.bytedance.keva.KevaCacheManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        KevaCacheManager.IS_LOW_MEMORY = true;
                        KevaCacheManager kevaCacheManager = KevaCacheManager.getInstance();
                        if (kevaCacheManager != null) {
                            kevaCacheManager.cleanCache(10000, false);
                        }
                        KevaCacheManager.mStartClear.set(false);
                    }
                };

                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i) {
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                    if (KevaCacheManager.mStartClear.compareAndSet(false, true)) {
                        new Thread(this.realTimeClearCacheThread).start();
                    }
                }
            });
        }
    }
}
