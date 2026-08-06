package com.ss.android.agilelogger.formatter.message.throwable;

import com.ss.android.agilelogger.utils.StackTraceUtils;

/* loaded from: classes7.dex */
public class DefaultThrowableFormatter implements ThrowableFormatter {
    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(Throwable th) {
        return StackTraceUtils.getStackTraceString(th);
    }
}
