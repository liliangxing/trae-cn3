package com.bytedance.platform.settingsx.internal;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes4.dex */
public class HandlerUtils {
    private static final Handler handler;
    private static final HandlerThread handlerThread;

    static {
        HandlerThread handlerThread2 = new HandlerThread("SettingX-Handler");
        handlerThread = handlerThread2;
        handlerThread2.start();
        handler = new Handler(handlerThread2.getLooper());
    }

    public static Handler getHandler() {
        return handler;
    }
}
