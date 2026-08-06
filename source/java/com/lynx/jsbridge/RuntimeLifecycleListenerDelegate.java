package com.lynx.jsbridge;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxSubErrorCode;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RuntimeLifecycleListenerDelegate implements RuntimeLifecycleListener {
    private static final String TAG = "RuntimeListenerDelegate";
    private RuntimeLifecycleListener mListener;
    private final WeakReference<LynxContext> mLynxContextWeak;

    public RuntimeLifecycleListenerDelegate(WeakReference<LynxContext> weakReference, RuntimeLifecycleListener runtimeLifecycleListener) {
        this.mLynxContextWeak = weakReference;
        this.mListener = runtimeLifecycleListener;
    }

    @Override // com.lynx.jsbridge.RuntimeLifecycleListener
    public void onRuntimeAttach(long j) {
        RuntimeLifecycleListener runtimeLifecycleListener = this.mListener;
        if (runtimeLifecycleListener != null) {
            try {
                runtimeLifecycleListener.onRuntimeAttach(j);
            } catch (Exception e) {
                onError(e);
            }
        }
    }

    @Override // com.lynx.jsbridge.RuntimeLifecycleListener
    public void onRuntimeDetach() {
        RuntimeLifecycleListener runtimeLifecycleListener = this.mListener;
        if (runtimeLifecycleListener != null) {
            try {
                runtimeLifecycleListener.onRuntimeDetach();
            } catch (Exception e) {
                onError(e);
            }
        }
    }

    private void onError(Exception exc) {
        LLog.m2577e(TAG, exc.toString());
        LynxContext lynxContext = this.mLynxContextWeak.get();
        if (lynxContext != null) {
            String stackTraceStringTrimmed = CallStackUtil.getStackTraceStringTrimmed(exc);
            LynxError lynxError = new LynxError(LynxSubErrorCode.E_BTS_LIFECYCLE_LISTENER_ERROR_EXCEPTION, exc.getMessage());
            lynxError.setCallStack(stackTraceStringTrimmed);
            lynxContext.handleLynxError(lynxError);
        }
    }
}
