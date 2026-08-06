package com.bytedance.vmsdk.jsbridge;

import android.util.Log;
import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.JavaOnlyArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;

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

    @Override // com.bytedance.vmsdk.jsbridge.utils.Callback
    public void invoke(Object... objArr) {
        if (this.mInvoked) {
            Log.d("VmsdkModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
            return;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            Log.e("VmsdkModule", "callback invoke failed: mNativePtr is NULL");
        } else {
            nativeInvoke(j, JavaOnlyArray.m13of(objArr));
            this.mInvoked = true;
        }
    }

    public void invokeCallback(Object... objArr) {
        if (this.mInvoked) {
            Log.d("VmsdkModule", "Illegal callback invocation from native module. This callback type only permits a single invocation from native code.");
            return;
        }
        long j = this.mNativePtr;
        if (j == 0) {
            Log.e("VmsdkModule", "callback invoke failed: mNativePtr is NULL");
        } else {
            nativeInvoke(j, JavaOnlyArray.m13of(objArr));
            this.mInvoked = true;
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
