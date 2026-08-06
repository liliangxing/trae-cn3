package com.bytedance.ug.sdk.share.impl.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WindowFocusUtils {
    private static final String TAG = "WindowFocusUtils";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface WindowFocusCallback {
        void onGrantFocus();
    }

    public static void ensureGrantWindowFocus(final WindowFocusCallback windowFocusCallback) {
        MainThreadUtils.runOnMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.utils.WindowFocusUtils.1
            @Override // java.lang.Runnable
            public void run() {
                WindowFocusUtils.ensureGrantWindowFocusInner(WindowFocusCallback.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003d A[Catch: Exception -> 0x0016, TRY_LEAVE, TryCatch #0 {Exception -> 0x0016, blocks: (B:22:0x000e, B:6:0x001d, B:8:0x0023, B:10:0x003d), top: B:21:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void ensureGrantWindowFocusInner(final WindowFocusCallback windowFocusCallback) {
        boolean z;
        final View decorView;
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity != null) {
            try {
            } catch (Exception e) {
                Logger.m469i(TAG, "error on handle focus e = " + e.getLocalizedMessage());
            }
            if (topActivity.hasWindowFocus()) {
                z = true;
                if (topActivity != null && !z && Build.VERSION.SDK_INT >= 29) {
                    Logger.m469i(TAG, "has no focus! topActivity = " + topActivity);
                    decorView = topActivity.getWindow().getDecorView();
                    if (decorView != null) {
                        decorView.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.ug.sdk.share.impl.utils.WindowFocusUtils.2
                            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                            public void onWindowFocusChanged(boolean z2) {
                                Logger.m469i(WindowFocusUtils.TAG, "onWindowFocusChanged hasFocus = " + z2);
                                if (z2) {
                                    WindowFocusCallback windowFocusCallback2 = WindowFocusCallback.this;
                                    if (windowFocusCallback2 != null) {
                                        windowFocusCallback2.onGrantFocus();
                                    }
                                    decorView.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
                                }
                            }
                        });
                        return;
                    }
                }
                if (windowFocusCallback == null) {
                    windowFocusCallback.onGrantFocus();
                    return;
                }
                return;
            }
        }
        z = false;
        if (topActivity != null) {
            Logger.m469i(TAG, "has no focus! topActivity = " + topActivity);
            decorView = topActivity.getWindow().getDecorView();
            if (decorView != null) {
            }
        }
        if (windowFocusCallback == null) {
        }
    }
}
