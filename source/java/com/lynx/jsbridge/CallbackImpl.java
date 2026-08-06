package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.WritableArray;
import com.lynx.tasm.base.LLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CallbackImpl implements Callback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean mInvoked = false;
    private long mNativePtr;

    private native void nativeInvoke(long j, WritableArray writableArray);

    private native void nativeReleaseNativePtr(long j);

    public CallbackImpl(long j) {
        this.mNativePtr = j;
    }

    @Override // com.lynx.react.bridge.Callback
    public void invoke(Object... objArr) {
        synchronized (this) {
            if (this.mInvoked) {
                LLog.report("LynxModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
                return;
            }
            this.mInvoked = true;
            long j = this.mNativePtr;
            if (j == 0) {
                LLog.m2577e("LynxModule", "callback invoke failed: mNativePtr is NULL");
            } else {
                nativeInvoke(j, JavaOnlyArray.m2566of(objArr));
            }
        }
    }

    public void invokeCallback(Object... objArr) {
        synchronized (this) {
            if (this.mInvoked) {
                LLog.report("LynxModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
                return;
            }
            this.mInvoked = true;
            long j = this.mNativePtr;
            if (j == 0) {
                LLog.m2577e("LynxModule", "callback invoke failed: mNativePtr is NULL");
            } else {
                nativeInvoke(j, JavaOnlyArray.m2566of(objArr));
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        nativeReleaseNativePtr(this.mNativePtr);
    }

    public void resetNativePtr() {
        this.mNativePtr = 0L;
    }
}
