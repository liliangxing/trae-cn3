package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import java.lang.ref.WeakReference;
import java.util.Deque;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxEngine {
    private static final String TAG = "LynxEngineWrapper";
    private WeakReference<Deque<LynxEngine>> mLynxEngineWrapperQueue;
    private WeakReference<LynxTemplateRender> mLynxTemplateRender;
    private ILynxUIRenderer mLynxUIRenderer;
    private PageConfig mPageConfig;
    private TasmPlatformInvoker mTasmPlatformInvoker;
    private TemplateBundle mTemplateBundle;
    private ThreadStrategyForRendering mThreadStrategy;
    private LynxEngineState mLynxEngineState = LynxEngineState.UN_LOADED;
    private long mNativePtr = nativeCreate();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum LynxEngineState {
        UN_LOADED,
        READY_BE_REUSED,
        ON_REUSING,
        FREEZED,
        DESTROYED
    }

    private native long nativeCreate();

    private native void nativeDestroyEngine(long j);

    private native long nativeDetachEngine(long j);

    public LynxEngine(TemplateBundle templateBundle, LynxTemplateRender lynxTemplateRender) {
        this.mLynxTemplateRender = new WeakReference<>(lynxTemplateRender);
        this.mTemplateBundle = templateBundle;
        this.mThreadStrategy = lynxTemplateRender.getThreadStrategyForRendering();
    }

    public ThreadStrategyForRendering getThreadStrategy() {
        return this.mThreadStrategy;
    }

    public void setThreadStrategy(ThreadStrategyForRendering threadStrategyForRendering) {
        this.mThreadStrategy = threadStrategyForRendering;
    }

    public TemplateBundle getTemplateBundle() {
        return this.mTemplateBundle;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public void setQueueRefFromPool(Deque<LynxEngine> deque) {
        this.mLynxEngineWrapperQueue = new WeakReference<>(deque);
    }

    public ILynxUIRenderer getLynxUIRenderer() {
        return this.mLynxUIRenderer;
    }

    public void setLynxUIRenderer(ILynxUIRenderer iLynxUIRenderer) {
        this.mLynxUIRenderer = iLynxUIRenderer;
    }

    public TasmPlatformInvoker getTasmPlatformInvoker() {
        return this.mTasmPlatformInvoker;
    }

    public void setTasmPlatformInvoker(TasmPlatformInvoker tasmPlatformInvoker) {
        this.mTasmPlatformInvoker = tasmPlatformInvoker;
    }

    public PageConfig getPageConfig() {
        return this.mPageConfig;
    }

    public void setPageConfig(PageConfig pageConfig) {
        this.mPageConfig = pageConfig;
    }

    public void detachFromLynxView() {
        LynxTemplateRender lynxTemplateRender = this.mLynxTemplateRender.get();
        if (this.mNativePtr == 0 || lynxTemplateRender == null) {
            return;
        }
        lynxTemplateRender.detachLynxEngineWrapper();
        this.mLynxTemplateRender.clear();
    }

    public synchronized void updateLynxEngineState(LynxEngineState lynxEngineState) {
        LLog.m2578i(TAG, this + "updateLynxEngineState:" + lynxEngineState.name());
        if (this.mLynxEngineState == LynxEngineState.DESTROYED) {
            if (lynxEngineState != LynxEngineState.DESTROYED) {
                LLog.m2577e(TAG, "lynxEngineState has been destroyed." + this);
            }
        } else {
            this.mLynxEngineState = lynxEngineState;
        }
    }

    public synchronized boolean hasLoaded() {
        return this.mLynxEngineState != LynxEngineState.UN_LOADED;
    }

    public synchronized boolean canReused() {
        return this.mLynxEngineState == LynxEngineState.READY_BE_REUSED;
    }

    public synchronized boolean tryBeReusing() {
        if (this.mLynxEngineState != LynxEngineState.READY_BE_REUSED) {
            return false;
        }
        updateLynxEngineState(LynxEngineState.ON_REUSING);
        return true;
    }

    public void attachCurrentTemplateRender(LynxTemplateRender lynxTemplateRender) {
        this.mLynxTemplateRender = new WeakReference<>(lynxTemplateRender);
    }

    public void registerLynxEngineReused() {
        updateLynxEngineState(LynxEngineState.READY_BE_REUSED);
        LynxEnginePool.getInstance().registerReuseEngineWrapper(this);
    }

    public void destroy() {
        updateLynxEngineState(LynxEngineState.DESTROYED);
        LynxEnginePool.getInstance().delete(this);
        long j = this.mNativePtr;
        if (j != 0) {
            this.mNativePtr = 0L;
            nativeDestroyEngine(j);
        }
    }

    public String toString() {
        return "LynxEngineWrapper{mNativePtr=" + this.mNativePtr + ", mLynxEngineState=" + this.mLynxEngineState + '}';
    }
}
