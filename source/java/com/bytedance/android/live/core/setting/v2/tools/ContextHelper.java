package com.bytedance.android.live.core.setting.v2.tools;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.core.setting.LiveSettingOldContext;

/* loaded from: classes2.dex */
public class ContextHelper {
    public static Context getContext() {
        if (LiveSettingOldContext.getApplication() == null) {
            return getApplicationUsingReflection();
        }
        return LiveSettingOldContext.getApplication();
    }

    private static Application getApplicationUsingReflection() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Exception e) {
            SettingReportMonitor.INSTANCE.printELog(e);
            return null;
        }
    }
}
