package com.lynx.tasm.utils;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes7.dex */
public class CallStackUtil {
    private static final int MAX_CAUSE_NUM_IN_MESSAGE = 5;
    private static final int MAX_LENGTH = 900;
    private static final int MAX_LINE_LENGTH = 9;

    public static String getMessageOfCauseChain(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            int i = 5;
            for (Throwable cause = th.getCause(); cause != null && i > 0; cause = cause.getCause()) {
                i--;
                sb.append(": ").append(cause);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return th.toString();
        }
    }

    public static String getStackTraceStringTrimmed(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 900 ? stackTraceString.substring(0, 900) : stackTraceString;
    }

    public static String getStackTraceStringWithLineTrimmed(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            printStackTraceWithLineTrimmed(th, printWriter);
            printWriter.flush();
            return stringWriter.toString();
        } catch (Throwable unused) {
            return getStackTraceStringTrimmed(th);
        }
    }

    private static void printStackTraceWithLineTrimmed(Throwable th, PrintWriter printWriter) {
        printStackTraceWithLineTrimmed(th, Collections.newSetFromMap(new IdentityHashMap()), printWriter);
    }

    private static void printStackTraceWithLineTrimmed(Throwable th, Set<Throwable> set, PrintWriter printWriter) {
        if (th == null || printWriter == null || set == null || set.contains(th)) {
            return;
        }
        if (!set.isEmpty()) {
            printWriter.print("Caused by: ");
        }
        printWriter.println(th);
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length < 9 ? stackTrace.length : 9;
        for (int i = 0; i < length; i++) {
            printWriter.println("\tat " + stackTrace[i]);
        }
        printStackTraceWithLineTrimmed(th.getCause(), set, printWriter);
    }
}
