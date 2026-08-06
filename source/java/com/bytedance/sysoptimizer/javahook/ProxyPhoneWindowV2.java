package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.policy.PhoneWindow;
import com.bytedance.sysoptimizer.proxyinstance.ProxyInstance;

/* loaded from: classes5.dex */
public class ProxyPhoneWindowV2 extends PhoneWindow {
    private static final String TAG = "ProxyPhoneWindowV2";
    private static boolean sLog;

    public ProxyPhoneWindowV2(Context context) {
        super(context);
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void setContentView(View view) {
        super.setContentView(view);
        if (sLog) {
            ProxyInstance.getCallback().e(TAG, "setContentView() called with: view = [" + view + "]", new Throwable());
        }
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void setContentView(int i) {
        super.setContentView(i);
        if (sLog) {
            ProxyInstance.getCallback().e(TAG, "setContentView() called with: layoutResID = [" + i + "]", new Throwable());
        }
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        if (sLog) {
            ProxyInstance.getCallback().e(TAG, "setContentView() called with: view = [" + view + "], params = [" + layoutParams + "]", new Throwable());
        }
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addContentView(view, layoutParams);
        if (sLog) {
            ProxyInstance.getCallback().e(TAG, "addContentView() called with: view = [" + view + "], params = [" + layoutParams + "]", new Throwable());
        }
    }

    @Override // com.android.internal.policy.PhoneWindow, android.view.Window
    public synchronized View getDecorView() {
        return super.getDecorView();
    }
}
