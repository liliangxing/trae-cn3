package com.bytedance.apm.util;

import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes3.dex */
public class StackUtils {
    private static final int MAX_STACKTRACE_DEPTH = 40;

    public static String getThrowableStack(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        Throwable cause = th.getCause();
        if (cause != null) {
            cause.printStackTrace(printWriter);
            Throwable cause2 = cause.getCause();
            if (cause2 != null) {
                cause2.printStackTrace(printWriter);
            }
        }
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2.length() > 1024 ? stringWriter2.substring(0, 1024) : stringWriter2;
    }

    public static String getStack(Throwable th) {
        return getStackLimit(th, 30);
    }

    public static String getStackLimit(Throwable th, int i) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            i2++;
            sb.append("\tat " + stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\n");
            if (i2 > i) {
                break;
            }
        }
        return sb.toString();
    }

    public static String getStackTraces(StackTraceElement[] stackTraceElementArr) throws IllegalArgumentException {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            throw new IllegalArgumentException("stackTraceElements must not be null or empty");
        }
        StringBuilder sb = new StringBuilder(stackTraceElementArr.length * 30);
        for (int i = 0; i < stackTraceElementArr.length && i <= 40; i++) {
            if ((i != 0 || !"getThreadStackTrace".equals(stackTraceElementArr[0].getMethodName())) && (i != 1 || !"getStackTrace".equals(stackTraceElementArr[1].getMethodName()))) {
                sb.append("\tat " + stackTraceElementArr[i].getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElementArr[i].getMethodName()).append("(").append(stackTraceElementArr[i].getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElementArr[i].getLineNumber()).append(")\n");
            }
        }
        return sb.toString();
    }
}
