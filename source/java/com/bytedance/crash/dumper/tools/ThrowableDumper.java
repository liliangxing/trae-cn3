package com.bytedance.crash.dumper.tools;

import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ThrowableDumper {
    private static final String FILE_NAME = "throwable.txt";
    private static final int MAX_LINES = 256;
    private static final char[] CAUSE_CAPTION = {'C', 'a', 'u', 's', 'e', 'd', ' ', 'b', 'y', ':', ' '};
    private static final char[] SUPPRESSED_CAPTION = {'S', 'u', 'p', 'p', 'r', 'e', 's', 's', 'e', 'd', ':', ' '};
    private static final char[] TAB_AT_SPACE = {'\t', 'a', 't', ' '};
    private static final char[] TAB_3_DOT_SPACE = {'\t', '.', '.', '.', ' '};

    /* renamed from: CR */
    private static final char f140CR = '\n';
    private static final char[] SPACE_MORE_CR = {' ', 'm', 'o', 'r', 'e', f140CR};
    private static final char[] SPACE_SKIP_CR = {' ', 's', 'k', 'i', 'p', f140CR};
    private static final boolean mHasSuppressed = true;

    public static String load(File file) {
        return FileSystemUtils.readUtf8File(new File(file, FILE_NAME));
    }

    public static void dump(File file, Throwable th) {
        try {
            StringDumper stringDumper = new StringDumper(file.getAbsolutePath() + "/throwable.txt");
            walkStackTrace(new StackBuilder(stringDumper), th);
            stringDumper.release();
        } catch (Throwable th2) {
            NpthMonitor.directReportInnerException("NPTH_DUMP", th2);
        }
    }

    private static void appendStackTraceElements(StackBuilder stackBuilder, StackTraceElement[] stackTraceElementArr, int i) {
        int i2 = 0;
        if (i <= 256) {
            while (i2 < i) {
                stackBuilder.append(TAB_AT_SPACE).append(stackTraceElementArr[i2]).append(f140CR);
                i2++;
            }
            return;
        }
        while (i2 < 128) {
            stackBuilder.append(TAB_AT_SPACE).append(stackTraceElementArr[i2]).append(f140CR);
            i2++;
        }
        stackBuilder.append(TAB_3_DOT_SPACE).append(i - 256).append(SPACE_SKIP_CR);
        for (int i3 = i - 128; i3 < i; i3++) {
            stackBuilder.append(TAB_AT_SPACE).append(stackTraceElementArr[i3]).append(f140CR);
        }
    }

    private static void walkStackTrace(StackBuilder stackBuilder, Throwable th) {
        stackBuilder.append(th).append(f140CR);
        StackTraceElement[] stackTrace = th.getStackTrace();
        appendStackTraceElements(stackBuilder, stackTrace, stackTrace.length);
        if (mHasSuppressed) {
            for (Throwable th2 : th.getSuppressed()) {
                walkEnclosedStackTrace(stackBuilder, SUPPRESSED_CAPTION, 1, th2, th);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            walkEnclosedStackTrace(stackBuilder, CAUSE_CAPTION, 0, cause, th);
        }
    }

    private static void walkEnclosedStackTrace(StackBuilder stackBuilder, char[] cArr, int i, Throwable th, Throwable th2) {
        StackTraceElement[] stackTrace = th2.getStackTrace();
        StackTraceElement[] stackTrace2 = th.getStackTrace();
        int length = stackTrace2.length - 1;
        for (int length2 = stackTrace.length - 1; length >= 0 && length2 >= 0 && stackTrace2[length].equals(stackTrace[length2]); length2--) {
            length--;
        }
        int length3 = (stackTrace2.length - 1) - length;
        stackBuilder.appendTabs(i).append(cArr).append(th).append(f140CR);
        appendStackTraceElements(stackBuilder, stackTrace2, stackTrace2.length - length3);
        if (length3 != 0) {
            stackBuilder.appendTabs(i).append(TAB_3_DOT_SPACE).append(length3).append(SPACE_MORE_CR);
        }
        if (mHasSuppressed) {
            for (Throwable th3 : th.getSuppressed()) {
                walkEnclosedStackTrace(stackBuilder, SUPPRESSED_CAPTION, i + 1, th3, th);
            }
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            walkEnclosedStackTrace(stackBuilder, CAUSE_CAPTION, i, cause, th);
        }
    }
}
