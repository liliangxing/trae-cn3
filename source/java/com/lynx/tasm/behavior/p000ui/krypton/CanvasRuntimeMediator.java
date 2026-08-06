package com.lynx.tasm.behavior.p000ui.krypton;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CanvasRuntimeMediator {
    private static final String TAG = "KryptonCanvasRuntimeMediator";
    private static Class<?> mCanvasManagerClass;
    private static Constructor<?> mCanvasManagerConstructor;
    private ICanvasManager mICanvasManagerInstance;
    private final WeakReference<LynxContext> mLynxContextWeak;
    private long mNativeRuntimeMediatorWeakPtr;
    private String mTemporaryDirectory;
    private final Map<Class<?>, Object> mCachedServiceMap = new ConcurrentHashMap();
    private volatile boolean mIsCanvasEnvReady = false;
    private final ReadWriteLock mTemporaryDirectoryLock = new ReentrantReadWriteLock(true);
    private final ReadWriteLock mRuntimeMediatorLock = new ReentrantReadWriteLock(true);
    private volatile boolean mHasInitCanvasManager = false;

    private native long nativeCreate();

    private native void nativeNotifyCanvasInitializeSuccess(long j);

    private native void nativeReleaseRuntimeMediatorWeakPtr(long j);

    private native long nativeResetToWeakPtr(long j);

    public CanvasRuntimeMediator(LynxContext lynxContext) {
        this.mLynxContextWeak = new WeakReference<>(lynxContext);
    }

    public long getNativePtr() {
        return nativeCreate();
    }

    public void resetNativePtr(long j) {
        this.mNativeRuntimeMediatorWeakPtr = nativeResetToWeakPtr(j);
    }

    public void setupCanvasFromUI() {
        LLog.i(TAG, "[Krypton] setupCanvasFromUI");
        setupCanvasEnvInternal();
    }

    private void setupCanvasFromJS() {
        LLog.i(TAG, "[Krypton] setupCanvasFromJS");
        setupCanvasEnvInternal();
    }

    private void onRuntimeCreate(long j) {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onRuntimeMediatorReady(j);
        }
    }

    private void onRuntimeInit(long j) {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onRuntimeInit(j);
        }
        onCanvasEnvPrepared();
    }

    private void onAppEnterBackground() {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onAppEnterBackground();
        }
    }

    private void onAppEnterForeground() {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onAppEnterForeground();
        }
    }

    private void onRuntimeAttach(long j) {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onNapiEnvReady(j);
        }
    }

    private void onRuntimeDetach() {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onRuntimeDetach();
        }
    }

    public ICanvasManager getCanvasManager() {
        return this.mICanvasManagerInstance;
    }

    public void registerService(Class<?> cls, Object obj) {
        this.mCachedServiceMap.put(cls, obj);
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.registerService(cls, obj);
        }
    }

    public void setTemporaryDirectory(String str) {
        this.mTemporaryDirectoryLock.writeLock().lock();
        this.mTemporaryDirectory = str;
        this.mTemporaryDirectoryLock.writeLock().unlock();
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.setTemporaryDirectory(str);
        }
    }

    public void deInit() {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.deInit();
        }
    }

    public void registerCanvasBehavior(BehaviorRegistry behaviorRegistry) {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.registerCanvasBehavior(behaviorRegistry);
        }
    }

    private synchronized void setupCanvasEnvInternal() {
        TraceEvent.beginSection("CanvasRuntimeMediator.setupCanvas");
        if (this.mHasInitCanvasManager) {
            return;
        }
        if (this.mICanvasManagerInstance == null) {
            LLog.i(TAG, "[Krypton] Create and init canvas manager");
            tryCreateCanvasManager();
            if (initCanvasManager() && !this.mIsCanvasEnvReady) {
                notifyCanvasInitializeSuccess();
            }
        }
        this.mHasInitCanvasManager = true;
        TraceEvent.endSection("CanvasRuntimeMediator.setupCanvas");
    }

    private boolean initCanvasManager() {
        LLog.i(TAG, "[Krypton] Init CanvasManager, load so and create KryptonApp");
        if (this.mICanvasManagerInstance == null) {
            return false;
        }
        if (!this.mICanvasManagerInstance.init(this.mLynxContextWeak.get())) {
            return false;
        }
        this.mTemporaryDirectoryLock.readLock().lock();
        String str = this.mTemporaryDirectory;
        if (str != null && !str.isEmpty()) {
            this.mICanvasManagerInstance.setTemporaryDirectory(this.mTemporaryDirectory);
        }
        this.mTemporaryDirectoryLock.readLock().unlock();
        for (Map.Entry<Class<?>, Object> entry : this.mCachedServiceMap.entrySet()) {
            this.mICanvasManagerInstance.registerService(entry.getKey(), entry.getValue());
        }
        return true;
    }

    private void notifyCanvasInitializeSuccess() {
        LLog.i(TAG, "[Krypton] TriggerCanvasEnvReady to execute cached tasks");
        this.mRuntimeMediatorLock.readLock().lock();
        long j = this.mNativeRuntimeMediatorWeakPtr;
        if (j != 0) {
            nativeNotifyCanvasInitializeSuccess(j);
        }
        this.mRuntimeMediatorLock.readLock().unlock();
    }

    private void tryCreateCanvasManager() {
        try {
            if (mCanvasManagerClass == null) {
                mCanvasManagerClass = Class.forName("com.lynx.canvas.CanvasManager");
            }
            if (mCanvasManagerConstructor == null) {
                mCanvasManagerConstructor = mCanvasManagerClass.getConstructor(new Class[0]);
            }
            Object newInstance = mCanvasManagerConstructor.newInstance(new Object[0]);
            if (newInstance instanceof ICanvasManager) {
                LLog.e(TAG, "[Krypton]  create canvasManager success.");
                this.mICanvasManagerInstance = (ICanvasManager) newInstance;
            } else {
                LLog.e(TAG, "[Krypton]  create canvasManager error");
            }
        } catch (Exception e) {
            LLog.e(TAG, "[Krypton]  create canvasManager error" + e.toString());
        }
    }

    private void setTaskRunner(long j) {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.setTaskRunner(j);
        }
    }

    private void onRuntimeMediatorDestroy() {
        ICanvasManager iCanvasManager = this.mICanvasManagerInstance;
        if (iCanvasManager != null) {
            iCanvasManager.onRuntimeMediatorDestroy();
            this.mRuntimeMediatorLock.writeLock().lock();
            nativeReleaseRuntimeMediatorWeakPtr(this.mNativeRuntimeMediatorWeakPtr);
            this.mNativeRuntimeMediatorWeakPtr = 0L;
            this.mRuntimeMediatorLock.writeLock().unlock();
        }
    }

    private void onCanvasEnvPrepared() {
        this.mIsCanvasEnvReady = true;
    }
}
