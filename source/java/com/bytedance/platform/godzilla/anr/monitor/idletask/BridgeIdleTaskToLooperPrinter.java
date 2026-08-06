package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.Looper;
import android.util.Printer;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
final class BridgeIdleTaskToLooperPrinter {
    private static Field sLoggingField;

    private BridgeIdleTaskToLooperPrinter() {
    }

    private static Printer getLooperPrinter() {
        if (sLoggingField == null) {
            try {
                sLoggingField = DoubleReflectHelper.getField(Looper.class, "mLogging");
            } catch (Throwable unused) {
            }
        }
        try {
            return (Printer) sLoggingField.get(Looper.getMainLooper());
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void println(String str) {
        Printer looperPrinter = getLooperPrinter();
        if (looperPrinter != null) {
            looperPrinter.println(str);
        }
    }
}
