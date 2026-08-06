package com.bytedance.android.monitor.util;

import com.bytedance.android.monitor.logger.MonitorLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ALogUtil {
    private static Method method;

    public static void i(String str, String str2) {
        try {
            if (method == null) {
                method = ReflectUtils.getMethod(Class.forName("com.ss.android.agilelogger.ALog"), RXScreenCaptureService.KEY_INDEX, new Class[]{String.class, String.class});
            }
            Method method2 = method;
            if (method2 != null) {
                method2.invoke(null, str, str2);
            }
            MonitorLog.i(str, str2);
        } catch (Throwable th) {
            MonitorLog.i(str, str2);
            ExceptionUtil.handleException(th);
        }
    }
}
