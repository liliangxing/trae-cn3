package com.lynx.tasm.core.resource;

import com.lynx.tasm.base.LLog;

/* loaded from: classes7.dex */
abstract class GuardedResourceCallback {
    public static final String DOUBLE_INVOKE_ERROR_MSG = "Illegal callback invocation from native. The loaded callback can only be invoked once! The url is ";
    private volatile boolean mInvoked = false;
    protected final String mUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuardedResourceCallback(String str) {
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean EnsureInvokedOnce() {
        synchronized (this) {
            if (this.mInvoked) {
                LLog.e("LynxResourceLoader", DOUBLE_INVOKE_ERROR_MSG + this.mUrl);
                return false;
            }
            this.mInvoked = true;
            return true;
        }
    }
}
