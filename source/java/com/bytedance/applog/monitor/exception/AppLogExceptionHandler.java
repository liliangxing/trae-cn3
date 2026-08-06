package com.bytedance.applog.monitor.exception;

import java.util.Map;

/* loaded from: classes3.dex */
public interface AppLogExceptionHandler {
    void onException(ExceptionScene exceptionScene, ExceptionType exceptionType, ExceptionLevel exceptionLevel, String str, Map<String, ?> map);
}
