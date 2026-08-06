package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.u0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0524u0 extends Throwable {
    @Override // java.lang.Throwable
    public void printStackTrace() {
        String stackTraceElement;
        IAppLogLogger global = LoggerImpl.global();
        StringBuilder m252a = C0380a.m252a("AppLog assert failed: ");
        Throwable cause = getCause();
        if (cause == null || (stackTraceElement = cause.getMessage()) == null) {
            StackTraceElement[] stackTrace = getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(stackTrace, "stackTrace");
            stackTraceElement = (stackTrace.length == 0) ^ true ? getStackTrace()[0].toString() : "function interrupt";
        }
        global.ast(m252a.append((Object) stackTraceElement).toString(), getCause(), new Object[0]);
    }
}
