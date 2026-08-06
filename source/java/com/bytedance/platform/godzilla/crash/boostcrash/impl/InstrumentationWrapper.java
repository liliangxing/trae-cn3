package com.bytedance.platform.godzilla.crash.boostcrash.impl;

import android.app.Instrumentation;
import android.os.Looper;
import com.bytedance.platform.godzilla.common.ActivityThreadHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class InstrumentationWrapper extends Instrumentation {
    private static final String TAG = "InstrumentationWrapper";
    private static List<ExceptionCatcher> sExceptionCatchers = new ArrayList();
    private static boolean sIsFixed;

    public static void startFix() {
        if (sIsFixed) {
            return;
        }
        try {
            Object currentActivityThread = ActivityThreadHelper.currentActivityThread();
            Field declaredField = currentActivityThread.getClass().getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            if (declaredField.get(currentActivityThread) instanceof InstrumentationWrapper) {
                return;
            }
            declaredField.set(currentActivityThread, new InstrumentationWrapper());
            Logger.d(TAG, "Fix success.");
            sIsFixed = true;
        } catch (Exception e) {
            Logger.d(TAG, e.getMessage());
        }
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object obj, Throwable th) {
        Iterator<ExceptionCatcher> it = sExceptionCatchers.iterator();
        while (it.hasNext()) {
            if (it.next().analysis(obj, th)) {
                return true;
            }
        }
        return super.onException(obj, th);
    }

    public static void registerExceptionCatcher(ExceptionCatcher exceptionCatcher) {
        if (Logger.debug() && Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("register only in UI thread.");
        }
        if (exceptionCatcher == null || !exceptionCatcher.registerCondition() || sExceptionCatchers.contains(exceptionCatcher)) {
            return;
        }
        sExceptionCatchers.add(exceptionCatcher);
    }

    public static void unRegisterExceptionCatcher(ExceptionCatcher exceptionCatcher) {
        if (Logger.debug() && Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("unRegister only in UI thread.");
        }
        if (exceptionCatcher == null) {
            return;
        }
        sExceptionCatchers.remove(exceptionCatcher);
    }
}
