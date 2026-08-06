package com.bytedance.news.common.settings.internal;

import android.app.Application;
import android.content.Context;

/* loaded from: classes4.dex */
public class GlobalConfig {
    private static volatile Context sContext;

    private GlobalConfig() {
    }

    public static synchronized void init(Context context) {
        synchronized (GlobalConfig.class) {
            if (sContext == null) {
                if (context instanceof Application) {
                    sContext = context;
                } else {
                    sContext = context.getApplicationContext();
                }
            }
        }
    }

    public static void checkConfig() {
        if (sContext == null) {
            synchronized (GlobalConfig.class) {
                if (sContext == null) {
                    throw new IllegalStateException("SettingsManager尚未被配置");
                }
            }
        }
    }

    public static Context getContext() {
        checkConfig();
        return sContext;
    }
}
