package com.bytedance.platform.godzilla.anr.webview;

import android.app.Application;
import com.bytedance.platform.godzilla.common.ActivityThreadHelper;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class HookActivityThread {
    private static final String TAG = "HookActivityThreadSetInitialApplication";

    public boolean preSetApplication(Application application) {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            declaredField.set(ActivityThreadHelper.currentActivityThread(), application);
            return true;
        } catch (Exception unused) {
            Logger.e(TAG, "WebView hook fix ANR fail.");
            return false;
        }
    }
}
