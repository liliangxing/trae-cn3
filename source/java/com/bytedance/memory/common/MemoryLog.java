package com.bytedance.memory.common;

import android.util.Log;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes4.dex */
public final class MemoryLog {
    public static final String TAG = "memory";
    private static boolean sForcePrint;
    private static volatile Logger sLogger = new DefaultLogger();

    /* loaded from: classes4.dex */
    public interface Logger {
        void d(Throwable th, String str, Object... objArr);

        void i(String str, Object... objArr);
    }

    public static void forcePrint(boolean z) {
        sForcePrint = z;
    }

    private MemoryLog() {
        throw new AssertionError();
    }

    /* loaded from: classes4.dex */
    private static class DefaultLogger implements Logger {
        DefaultLogger() {
        }

        @Override // com.bytedance.memory.common.MemoryLog.Logger
        public void i(String str, Object... objArr) {
            if (MemoryWidgetGlobal.DEBUG || MemoryLog.sForcePrint) {
                String format = String.format(str, objArr);
                if (format.length() < 4000) {
                    Log.d("memory", format);
                    return;
                }
                for (String str2 : format.split(UpdateDialogNewBase.TYPE, -1)) {
                    Log.d("memory", str2);
                }
            }
        }

        @Override // com.bytedance.memory.common.MemoryLog.Logger
        public void d(Throwable th, String str, Object... objArr) {
            i(String.format(str, objArr) + '\n' + Log.getStackTraceString(th), new Object[0]);
        }
    }

    public static void setLogger(Logger logger) {
        sLogger = logger;
    }

    public static void i(String str, Object... objArr) {
        Logger logger = sLogger;
        if (logger == null) {
            return;
        }
        logger.i(str, objArr);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Logger logger = sLogger;
        if (logger == null) {
            return;
        }
        logger.d(th, str, objArr);
    }
}
