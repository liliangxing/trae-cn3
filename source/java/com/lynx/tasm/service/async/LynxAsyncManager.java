package com.lynx.tasm.service.async;

import android.content.Context;
import android.util.LruCache;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.async.IPreLayoutContainer;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAsyncManager<T extends IPreLayoutContainer> {
    private static final int LYNX_ASYNC_LOAD_SLIDING_WINDOWS_DEFAULT_SIZE = 5;
    private static final int LYNX_ASYNC_PRE_LAYOUT_ASYNC_LRU_SIZE = 10;
    private static final String TAG = "LynxAsyncManager";
    private static final Object sLoadListLock = new Object();
    private volatile boolean isDestroyed;
    private Executor mContainerCreateExecutor;
    private int mCurrentSlidingWindowSize;
    private final boolean mEnableUseCreateExecutor;
    private final boolean mEnableUseLoadExecutor;
    private final LruCache<String, Future<T>> mFutureTaskCache;
    private ExecutorService mLoadExecutor;
    private final LinkedList<Runnable> mPendingLoadTask;
    private final LruCache<String, T> mPreLayoutCache;
    private final int mSlidingWindowMaxSize;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum AsyncCallbackCode {
        ASYNC_MANAGER_LOAD_FAIL,
        ASYNC_MANAGER_TIMEOUT
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ILynxAsyncLayoutCallback<T> {
        void onLayoutFinish(String str, T t);

        void onPreLayoutError(AsyncCallbackCode asyncCallbackCode, LynxError lynxError);
    }

    private LynxAsyncManager(Builder builder) {
        LLog.i(TAG, "Create LynxAsyncManager, address:" + this);
        int i = builder.slidingWindowsSize;
        this.mSlidingWindowMaxSize = i;
        this.mEnableUseCreateExecutor = builder.enableUseCreateExecutor;
        this.mEnableUseLoadExecutor = builder.enableUseLoadExecutor;
        this.mPreLayoutCache = new LruCache<>(builder.lruSize);
        this.mFutureTaskCache = new LruCache<>(builder.lruSize);
        this.mPendingLoadTask = new LinkedList<>();
        this.mCurrentSlidingWindowSize = i;
    }

    public void setLoadExecutor(ExecutorService executorService) {
        if (this.mLoadExecutor == null) {
            this.mLoadExecutor = executorService;
        } else {
            LLog.e(TAG, "mLoadExecutor has been set.");
        }
    }

    public void setContainerCreateExecutor(Executor executor) {
        if (this.mContainerCreateExecutor == null) {
            this.mContainerCreateExecutor = executor;
        } else {
            LLog.e(TAG, "mContainerCreateExecutor has been set.");
        }
    }

    public ExecutorService getLoadExecutor() {
        if (this.mLoadExecutor == null) {
            this.mLoadExecutor = LynxAsyncService.getInstance().getGlobalDefaultExecutor();
        }
        return this.mLoadExecutor;
    }

    public void preLayout(final String str, final Context context, final IPreLayoutContainerCreator<T> iPreLayoutContainerCreator, final LynxAsyncLoadRunnable<T> lynxAsyncLoadRunnable, final ILynxAsyncLayoutCallback<T> iLynxAsyncLayoutCallback, final HashMap<String, Object> hashMap) {
        Executor executor;
        if (this.isDestroyed) {
            LLog.i(TAG, "LynxAsyncManager is destroyed, cancel all task here.");
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.lynx.tasm.service.async.LynxAsyncManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LynxAsyncManager.this.m4138lambda$preLayout$0$comlynxtasmserviceasyncLynxAsyncManager(iPreLayoutContainerCreator, context, hashMap, str, lynxAsyncLoadRunnable, iLynxAsyncLayoutCallback);
            }
        };
        if (this.mEnableUseCreateExecutor && (executor = this.mContainerCreateExecutor) != null) {
            executor.execute(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$preLayout$0$com-lynx-tasm-service-async-LynxAsyncManager, reason: not valid java name */
    public /* synthetic */ void m4138lambda$preLayout$0$comlynxtasmserviceasyncLynxAsyncManager(IPreLayoutContainerCreator iPreLayoutContainerCreator, Context context, HashMap hashMap, String str, LynxAsyncLoadRunnable lynxAsyncLoadRunnable, ILynxAsyncLayoutCallback iLynxAsyncLayoutCallback) {
        TraceEvent.beginSection("LynxAsyncManager.createContainer");
        IPreLayoutContainer createContainer = iPreLayoutContainerCreator.createContainer(context, hashMap);
        TraceEvent.endSection("LynxAsyncManager.createContainer");
        preLayout(str, createContainer, lynxAsyncLoadRunnable, iLynxAsyncLayoutCallback);
    }

    public void preLayout(final String str, final T t, final LynxAsyncLoadRunnable<T> lynxAsyncLoadRunnable, final ILynxAsyncLayoutCallback<T> iLynxAsyncLayoutCallback) {
        if (this.isDestroyed) {
            lynxAsyncLoadRunnable.managerDestroyOnPreLayout();
            LLog.e(TAG, "LynxAsyncManager is destroyed, return on pre-layout task begin.");
            return;
        }
        final boolean enablePreLayoutViewCache = lynxAsyncLoadRunnable.enablePreLayoutViewCache();
        final boolean enablePreLayoutFutureCache = lynxAsyncLoadRunnable.enablePreLayoutFutureCache();
        boolean enableUIFlush = lynxAsyncLoadRunnable.enableUIFlush();
        final long waitLayoutFinishedTimeout = lynxAsyncLoadRunnable.getWaitLayoutFinishedTimeout();
        if (t == null) {
            LLog.e(TAG, "ContainView is null, in LynxAsyncManager:" + this);
            return;
        }
        final LynxView lynxView = t.getLynxView();
        if (lynxView == null) {
            LLog.e(TAG, "ContainerView getLynxView is null, in LynxAsyncManager:" + this);
            return;
        }
        lynxAsyncLoadRunnable.setContainerView(t);
        lynxView.setEnableUIFlush(enableUIFlush);
        if (lynxView.getThreadStrategyForRendering() == ThreadStrategyForRendering.ALL_ON_UI) {
            LLog.e(TAG, "lynxView preLayout ThreadStrategy can't be ThreadStrategyForRendering.ALL_ON_UI. identify:" + str);
            return;
        }
        lynxView.addLynxViewClient(new LynxViewClient() { // from class: com.lynx.tasm.service.async.LynxAsyncManager.1
            public void onTASMFinishedByNative() {
                if (LynxAsyncManager.this.isDestroyed) {
                    lynxAsyncLoadRunnable.managerDestroyOnPreLayout();
                    return;
                }
                if (enablePreLayoutViewCache) {
                    LynxAsyncManager.this.mPreLayoutCache.put(str, t);
                }
                LLog.d(LynxAsyncManager.TAG, "onLayoutFinished callback for " + str);
                lynxView.removeLynxViewClient(this);
                LynxAsyncManager.this.increaseSlidingWindowSize();
                if (iLynxAsyncLayoutCallback != null) {
                    TraceEvent.beginSection("LynxAsyncLayoutCallback.onLayoutFinished");
                    iLynxAsyncLayoutCallback.onLayoutFinish(str, t);
                    TraceEvent.endSection("LynxAsyncLayoutCallback.onLayoutFinished");
                }
            }

            public void onReceivedError(LynxError lynxError) {
                if (LynxAsyncManager.this.isDestroyed) {
                    lynxAsyncLoadRunnable.managerDestroyOnPreLayout();
                    return;
                }
                if (lynxError.getErrorCode() == 102) {
                    LLog.e(LynxAsyncManager.TAG, "onPreLayoutError callback for " + str);
                    lynxView.removeLynxViewClient(this);
                    LynxAsyncManager.this.increaseSlidingWindowSize();
                    ILynxAsyncLayoutCallback iLynxAsyncLayoutCallback2 = iLynxAsyncLayoutCallback;
                    if (iLynxAsyncLayoutCallback2 != null) {
                        iLynxAsyncLayoutCallback2.onPreLayoutError(AsyncCallbackCode.ASYNC_MANAGER_LOAD_FAIL, lynxError);
                    }
                }
            }
        });
        Runnable runnable = new Runnable() { // from class: com.lynx.tasm.service.async.LynxAsyncManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LynxAsyncManager.this.m4139lambda$preLayout$1$comlynxtasmserviceasyncLynxAsyncManager(enablePreLayoutFutureCache, str, t, lynxAsyncLoadRunnable, iLynxAsyncLayoutCallback, waitLayoutFinishedTimeout, lynxView);
            }
        };
        if (decreaseSlidingWindowSize()) {
            runnable.run();
            return;
        }
        synchronized (sLoadListLock) {
            this.mPendingLoadTask.add(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$preLayout$1$com-lynx-tasm-service-async-LynxAsyncManager, reason: not valid java name */
    public /* synthetic */ void m4139lambda$preLayout$1$comlynxtasmserviceasyncLynxAsyncManager(boolean z, String str, IPreLayoutContainer iPreLayoutContainer, LynxAsyncLoadRunnable lynxAsyncLoadRunnable, ILynxAsyncLayoutCallback iLynxAsyncLayoutCallback, long j, LynxView lynxView) {
        if (!this.mEnableUseLoadExecutor || this.mLoadExecutor == null) {
            UIThreadUtils.runOnUiThreadImmediately(lynxAsyncLoadRunnable);
        } else {
            if (z) {
                FutureTask<T> preLayoutFutureTask = getPreLayoutFutureTask(str, iPreLayoutContainer, lynxAsyncLoadRunnable, iLynxAsyncLayoutCallback, j, lynxView);
                this.mFutureTaskCache.put(str, preLayoutFutureTask);
                getLoadExecutor().submit(preLayoutFutureTask);
                return;
            }
            getLoadExecutor().execute(lynxAsyncLoadRunnable);
        }
    }

    private synchronized boolean decreaseSlidingWindowSize() {
        int i = this.mCurrentSlidingWindowSize;
        if (i <= 0) {
            return false;
        }
        this.mCurrentSlidingWindowSize = i - 1;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void increaseSlidingWindowSize() {
        Runnable poll;
        if (this.mCurrentSlidingWindowSize < this.mSlidingWindowMaxSize) {
            synchronized (sLoadListLock) {
                poll = this.mPendingLoadTask.poll();
            }
            if (poll != null) {
                UIThreadUtils.runOnUiThread(poll);
            } else {
                this.mCurrentSlidingWindowSize++;
            }
        }
    }

    private FutureTask<T> getPreLayoutFutureTask(final String str, final T t, final LynxAsyncLoadRunnable<T> lynxAsyncLoadRunnable, final ILynxAsyncLayoutCallback<T> iLynxAsyncLayoutCallback, final long j, final LynxView lynxView) {
        return new FutureTask<>(new Callable() { // from class: com.lynx.tasm.service.async.LynxAsyncManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LynxAsyncManager.this.m21x76208ee7(lynxAsyncLoadRunnable, lynxView, j, str, iLynxAsyncLayoutCallback, t);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getPreLayoutFutureTask$2$com-lynx-tasm-service-async-LynxAsyncManager */
    public /* synthetic */ IPreLayoutContainer m21x76208ee7(LynxAsyncLoadRunnable lynxAsyncLoadRunnable, LynxView lynxView, long j, String str, ILynxAsyncLayoutCallback iLynxAsyncLayoutCallback, IPreLayoutContainer iPreLayoutContainer) throws Exception {
        final Semaphore semaphore = new Semaphore(0);
        lynxAsyncLoadRunnable.run();
        lynxView.runOnTasmThread(new Runnable() { // from class: com.lynx.tasm.service.async.LynxAsyncManager.2
            @Override // java.lang.Runnable
            public void run() {
                semaphore.release();
            }
        });
        try {
            if (j == 0) {
                semaphore.acquire();
            } else if (!semaphore.tryAcquire(j, TimeUnit.MILLISECONDS)) {
                LLog.e(TAG, "Timeout on waiting tasm layout finished. " + str);
                if (iLynxAsyncLayoutCallback != null) {
                    iLynxAsyncLayoutCallback.onPreLayoutError(AsyncCallbackCode.ASYNC_MANAGER_TIMEOUT, null);
                }
                return null;
            }
        } catch (InterruptedException e) {
            LLog.e(TAG, e.toString());
        }
        return iPreLayoutContainer;
    }

    public T removeLynxViewFromLayoutCache(String str) {
        T remove = this.mPreLayoutCache.remove(str);
        if (remove != null) {
            LLog.i(TAG, remove + ", hit the PreLayoutCache identify:" + str);
        }
        return remove;
    }

    public T processRenderFromLayoutCache(String str) {
        T removeLynxViewFromLayoutCache = removeLynxViewFromLayoutCache(str);
        if (removeLynxViewFromLayoutCache == null || removeLynxViewFromLayoutCache.getLynxView() == null) {
            return null;
        }
        removeLynxViewFromLayoutCache.getLynxView().processRender();
        return removeLynxViewFromLayoutCache;
    }

    public T getContainerFromFuture(String str) {
        return getContainerFromFuture(str, -1L);
    }

    public T getContainerFromFuture(String str, long j) {
        Future<T> remove = this.mFutureTaskCache.remove(str);
        if (remove == null) {
            return null;
        }
        try {
            if (j < 0) {
                return remove.get();
            }
            return remove.get(j, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            LLog.e(TAG, "getContainerFromFuture is failed, " + e.toString());
            return null;
        }
    }

    public void clearFutureTaskCache() {
        this.mFutureTaskCache.evictAll();
    }

    public void clearLayoutCache() {
        this.mPreLayoutCache.evictAll();
    }

    public void clearAll() {
        synchronized (sLoadListLock) {
            this.mPendingLoadTask.clear();
        }
        clearLayoutCache();
        clearFutureTaskCache();
    }

    public void destroy() {
        this.isDestroyed = true;
        clearAll();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class LynxAsyncLoadRunnable<T extends IPreLayoutContainer> implements Runnable {
        private static final String TAG = "LynxAsyncLoadRunnable";
        T mContainer;

        protected boolean enablePreLayoutFutureCache() {
            return false;
        }

        protected boolean enablePreLayoutViewCache() {
            return true;
        }

        protected boolean enableUIFlush() {
            return false;
        }

        protected long getWaitLayoutFinishedTimeout() {
            return 0L;
        }

        public abstract void load(T t);

        /* JADX INFO: Access modifiers changed from: private */
        public void setContainerView(T t) {
            this.mContainer = t;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TraceEvent.beginSection("LynxAsyncLoadRunnable.run");
            load(this.mContainer);
            TraceEvent.endSection("LynxAsyncLoadRunnable.run");
        }

        protected LynxView getLynxView() {
            T t = this.mContainer;
            if (t == null || t.getLynxView() == null) {
                LLog.e(TAG, "mContainer/getLynxView return null, you must call buildLynxView before get it.");
                return null;
            }
            return this.mContainer.getLynxView();
        }

        protected T getContainer() {
            return this.mContainer;
        }

        protected void managerDestroyOnPreLayout() {
            T t = this.mContainer;
            if (t == null || t.getLynxView() == null) {
                return;
            }
            this.mContainer.getLynxView().destroy();
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Builder<T extends IPreLayoutContainer> {
        private int lruSize = 10;
        private boolean enableUseCreateExecutor = true;
        private boolean enableUseLoadExecutor = true;
        private int slidingWindowsSize = 5;

        public Builder setLruSize(int i) {
            this.lruSize = i;
            return this;
        }

        public Builder setEnableUseCreateExecutor(boolean z) {
            this.enableUseCreateExecutor = z;
            return this;
        }

        public Builder setEnableUseLoadExecutor(boolean z) {
            this.enableUseLoadExecutor = z;
            return this;
        }

        public Builder setSlidingWindowsSize(int i) {
            this.slidingWindowsSize = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LynxAsyncManager<T> build() {
            LLog.d(LynxAsyncManager.TAG, toString());
            return new LynxAsyncManager<>(this);
        }

        public String toString() {
            return "Builder{lruSize=" + this.lruSize + ", enableUseCreateExecutor=" + this.enableUseCreateExecutor + ", enableUseLoadExecutor=" + this.enableUseLoadExecutor + ", slidingWindowsSize=" + this.slidingWindowsSize + '}';
        }
    }
}
