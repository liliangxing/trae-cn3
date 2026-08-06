package com.bytedance.android.monitor.util;

import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.base.IExceptionHandler;

/* loaded from: classes3.dex */
public class ExceptionUtil {
    public static void handleException(Throwable th) {
        IExceptionHandler exceptionHandler = HybridMonitor.getInstance().getExceptionHandler();
        if (exceptionHandler != null) {
            exceptionHandler.handleException(th);
        }
    }
}
