package com.bytedance.android.live.setting;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import kotlin.Metadata;

/* compiled from: LiveAppContextHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/setting/LiveAppContextHelper;", "", "()V", "getApplicationUsingReflection", "Landroid/content/Context;", "getContext", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LiveAppContextHelper {
    public static final LiveAppContextHelper INSTANCE = new LiveAppContextHelper();

    private LiveAppContextHelper() {
    }

    public final Context getContext() {
        Context context = LiveSettingManager.INSTANCE.getContext();
        if (context != null) {
            return context;
        }
        Log.e("AppContextHelper", "AppContextHelper context is not inject.", new Throwable());
        return getApplicationUsingReflection();
    }

    private final Context getApplicationUsingReflection() {
        try {
            Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            if (!(invoke instanceof Application)) {
                invoke = null;
            }
            return (Application) invoke;
        } catch (Throwable unused) {
            Log.e("AppContextHelper", "AppContextHelper getApplicationUsingReflection error.", new Throwable());
            return null;
        }
    }
}
