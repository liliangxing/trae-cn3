package com.bytedance.article.common.monitor.stack;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Stack {
    private static final String CAUSE_CAPTION = "Caused by: ";
    private static final int END_STACK_COUNT = 128;
    private static final int MAX_STACK_COUNT = 256;
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";

    private Stack() {
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static String getExceptionStack(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            printStackTrace(th, printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    private static void printStackTrace(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        printWriter.println(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                printWriter.println("\t... skip " + ((stackTrace.length - i2) - 128) + " lines");
                break;
            } else {
                printWriter.println("\tat " + stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            printEnclosedStackTrace(th2, printWriter, stackTrace, SUPPRESSED_CAPTION, "\t", newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            printEnclosedStackTrace(cause, printWriter, stackTrace, CAUSE_CAPTION, "", newSetFromMap, 128);
        }
    }

    private static void printEnclosedStackTrace(Throwable th, PrintWriter printWriter, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            printWriter.println("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        printWriter.println(str2 + str + th);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                printWriter.println("\t... skip " + ((stackTrace.length - i3) - (i / 2)) + " lines");
                break;
            } else {
                printWriter.println("\tat " + stackTraceElement);
                i3++;
                i2++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            int i4 = i / 2;
            printEnclosedStackTrace(th2, printWriter, stackTrace, SUPPRESSED_CAPTION, str2 + "\t", set, i4 > 10 ? i4 : 10);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            printEnclosedStackTrace(cause, printWriter, stackTrace, CAUSE_CAPTION, str2, set, i5 > 10 ? i5 : 10);
        }
    }

    private static boolean isStackOverFlowError(Throwable th) {
        int i = 0;
        while (th != null) {
            if (th instanceof StackOverflowError) {
                return true;
            }
            if (i > 20) {
                return false;
            }
            th = th.getCause();
            i++;
        }
        return false;
    }
}
