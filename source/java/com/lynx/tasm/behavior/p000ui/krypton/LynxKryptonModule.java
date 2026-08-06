package com.lynx.tasm.behavior.p000ui.krypton;

import com.lynx.jsbridge.LynxExtensionModule;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxKryptonModule extends LynxExtensionModule {
    public static final String TAG = "LynxKryptonModule";
    private LynxKryptonHelper mKryptonHelper;
    private long mNativePtr;

    private native long nativeCreate();

    private native void nativeDestroy(long j);

    private native long nativeGetExtensionDelegatePtr(long j, long j2);

    public LynxKryptonModule(LynxContext lynxContext, LynxGroup lynxGroup, BehaviorRegistry behaviorRegistry) {
        super(lynxContext, lynxGroup, behaviorRegistry);
        this.mNativePtr = 0L;
        this.mKryptonHelper = new LynxKryptonHelper(behaviorRegistry);
        this.mNativePtr = nativeCreate();
        LLog.i(TAG, "LynxKryptonModule create");
    }

    public long getExtensionDelegatePtr() {
        if (this.mNativePtr == 0) {
            LLog.e(TAG, "native ptr is 0");
            return 0L;
        }
        CanvasRuntimeMediator canvasRuntimeMediator = new CanvasRuntimeMediator(this.mContext);
        this.mKryptonHelper.registerCanvasRuntimeMediator(canvasRuntimeMediator);
        long nativePtr = canvasRuntimeMediator.getNativePtr();
        if (nativePtr == 0) {
            LLog.e(TAG, "mediator ptr is 0");
            return 0L;
        }
        long nativeGetExtensionDelegatePtr = nativeGetExtensionDelegatePtr(this.mNativePtr, nativePtr);
        canvasRuntimeMediator.resetNativePtr(nativePtr);
        return nativeGetExtensionDelegatePtr;
    }

    public void setUp() {
        LLog.i(TAG, "LynxKryptonModule setup");
        if (this.mGroup == null || !this.mGroup.enableCanvas()) {
            return;
        }
        this.mKryptonHelper.setupCanvasIfEnableCanvas();
    }

    public void destroy() {
        this.mKryptonHelper.deInit();
        nativeDestroy(this.mNativePtr);
        this.mNativePtr = 0L;
    }

    public LynxKryptonHelper getLynxKryptonHelper() {
        return this.mKryptonHelper;
    }
}
