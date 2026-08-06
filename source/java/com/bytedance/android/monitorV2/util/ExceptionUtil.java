package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.base.IExceptionHandler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ExceptionUtil {
    public static final String DEFAULT_HANDLE = "default_handle";
    public static final String STARTUP_HANDLE = "startup_handle";

    public static void handleException(String str, Throwable th) {
        HashMap hashMap = new HashMap();
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        hashMap.put(InternalWatcher.PARAM_SPEC_ERROR_MSG, stringWriter.toString());
        hashMap.put(InternalWatcher.PARAM_SPEC_ERROR_DESC, str);
        InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_INTERNAL_ERROR, hashMap, null);
        IExceptionHandler exceptionHandler = HybridMultiMonitor.getInstance().getExceptionHandler();
        if (exceptionHandler != null) {
            exceptionHandler.handleException(th);
        }
    }

    public static void handleException(Throwable th) {
        handleException(DEFAULT_HANDLE, th);
    }
}
