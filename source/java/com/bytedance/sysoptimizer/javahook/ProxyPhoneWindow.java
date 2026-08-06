package com.bytedance.sysoptimizer.javahook;

/* loaded from: classes5.dex */
public class ProxyPhoneWindow {
    private static final String TAG = "ProxyPhoneWindow";

    public void installDecor() throws Throwable {
        synchronized (this) {
            AHook.callOrigin(OriginMethodKey.KEY_PHONEWINDOW_INSTALLDECOR, this, new Object[0]);
        }
        AHook.getCallback().e(TAG, "installDecor() called this = [" + this + "", new Throwable());
    }
}
