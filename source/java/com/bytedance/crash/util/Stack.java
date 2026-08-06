package com.bytedance.crash.util;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.xiaomi.mipush.sdk.Constants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Stack {
    private static final String CAUSE_CAPTION = "Caused by: ";
    public static final String DIED_PROCESS_STACK = "DiedProcess.unknownReason: App was killed, please see logcat.\n";
    private static final StackTraceElement EMPTY = new StackTraceElement("", "", "", 0);
    private static final int END_STACK_COUNT = 128;
    private static final int MAX_STACK_COUNT = 256;
    public static final String NO_STACK = "InvalidStack.NoStackAvailable: Not OOM.\n";
    public static final String NO_STACK_ANR = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    public static final String NO_STACK_OOM = "InvalidStack.NoStackAvailable: Is OOM.\n";
    private static final String SUPPRESSED_CAPTION = "Suppressed: ";

    private Stack() {
    }

    public static String getStackInfo(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            getStackTraceElementInfo(stackTraceElement, sb);
        }
        return sb.toString();
    }

    public static StringBuilder getStackTraceElementInfo(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    public static String getStackTraceElementInfo(StackTraceElement stackTraceElement) {
        return getStackTraceElementInfo(stackTraceElement, new StringBuilder()).toString();
    }

    public static String getExceptionStackStart(Throwable th, int i) {
        if (th == null) {
            return null;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return getExceptionStackStartEnd(th, stackTrace, i, stackTrace.length);
    }

    private static String getExceptionStackStartEnd(Throwable th, StackTraceElement[] stackTraceElementArr, int i, int i2) {
        if (i < 0 || i >= stackTraceElementArr.length || i2 <= i || i2 > stackTraceElementArr.length) {
            return null;
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTraceElementArr, i, i2));
        String exceptionStack = getExceptionStack(th);
        th.setStackTrace(stackTraceElementArr);
        return exceptionStack;
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

    public static StackTraceElement[] getExceptionTraceElement(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            printStackTrace(th, arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject getAllStackTraces(String str) {
        boolean z;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str))) {
                    jSONObject2.put(CrashHianalyticsData.THREAD_NAME, key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + LibrarianImpl.Constants.DOT + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() <= 0) {
                            z = false;
                            if (!z) {
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void printStackTrace(Throwable th, List<StackTraceElement> list) {
        if (th == null || list == null) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        list.add(EMPTY);
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
                list.add(EMPTY);
                break;
            } else {
                list.add(stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            printEnclosedStackTrace(th2, list, stackTrace, SUPPRESSED_CAPTION, "\t", (Set<Throwable>) newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            printEnclosedStackTrace(cause, list, stackTrace, CAUSE_CAPTION, "", (Set<Throwable>) newSetFromMap, 128);
        }
    }

    private static void printEnclosedStackTrace(Throwable th, List<StackTraceElement> list, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            list.add(EMPTY);
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        list.add(EMPTY);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                list.add(EMPTY);
                break;
            } else {
                list.add(stackTraceElement);
                i3++;
                i2++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            int i4 = i / 2;
            printEnclosedStackTrace(th2, list, stackTrace, SUPPRESSED_CAPTION, str2 + "\t", set, i4 > 10 ? i4 : 10);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            printEnclosedStackTrace(cause, list, stackTrace, CAUSE_CAPTION, str2, set, i5 > 10 ? i5 : 10);
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
            printEnclosedStackTrace(th2, printWriter, stackTrace, SUPPRESSED_CAPTION, "\t", (Set<Throwable>) newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            printEnclosedStackTrace(cause, printWriter, stackTrace, CAUSE_CAPTION, "", (Set<Throwable>) newSetFromMap, 128);
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

    /* loaded from: classes3.dex */
    public static class StackLines {
        public int end;
        public int start;

        public StackLines(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.start);
                jSONObject.put("end", this.end);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public static JSONArray getMatchLines(StackTraceElement[] stackTraceElementArr, String str) {
        StackLines stackLines = new StackLines(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (stackLines.start == -1) {
                if (stackTraceElementArr[i].getClassName().contains(str)) {
                    stackLines.start = i;
                    stackLines.end = i;
                }
            } else if (!stackTraceElementArr[i].getClassName().contains(str)) {
                stackLines.end = i;
                jSONArray.put(stackLines.toJson());
                stackLines = new StackLines(-1, -1);
            }
        }
        if (stackLines.start != -1) {
            stackLines.end = stackTraceElementArr.length;
            jSONArray.put(stackLines.toJson());
        }
        return jSONArray;
    }

    public static JSONArray getMatchLines(String[] strArr, String str) {
        StackLines stackLines = new StackLines(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (stackLines.start == -1) {
                if (strArr[i].contains(str)) {
                    stackLines.start = i;
                    stackLines.end = i;
                }
            } else if (!strArr[i].contains(str)) {
                stackLines.end = i;
                jSONArray.put(stackLines.toJson());
                stackLines = new StackLines(-1, -1);
            }
        }
        if (stackLines.start != -1) {
            stackLines.end = strArr.length;
            jSONArray.put(stackLines.toJson());
        }
        return jSONArray;
    }

    public static JSONArray getMatchLines(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        StackLines stackLines = new StackLines(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (stackLines.start == -1) {
                if (stringContains(stackTraceElementArr[i].getClassName(), strArr)) {
                    stackLines.start = i;
                    stackLines.end = i;
                }
            } else if (!stringContains(stackTraceElementArr[i].getClassName(), strArr)) {
                stackLines.end = i;
                jSONArray.put(stackLines.toJson());
                stackLines = new StackLines(-1, -1);
            }
        }
        if (stackLines.start != -1) {
            stackLines.end = stackTraceElementArr.length;
            jSONArray.put(stackLines.toJson());
        }
        return jSONArray;
    }

    public static boolean stringContains(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
