package com.ss.android.agilelogger.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* loaded from: classes7.dex */
public class StackTraceUtils {
    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "ALOG:UnknownHostException";
            }
        }
        LengthLimitStringWriter lengthLimitStringWriter = new LengthLimitStringWriter();
        PrintWriter printWriter = new PrintWriter(lengthLimitStringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (Throwable unused) {
        }
        printWriter.flush();
        return lengthLimitStringWriter.toString();
    }

    /* loaded from: classes7.dex */
    private static class LengthLimitStringWriter extends StringWriter {
        private static final int MAX_STACK_TRACE_STRING_LEN = 4000;
        private int mLength = 0;
        private boolean mIgnore = false;

        @Override // java.io.StringWriter, java.io.Writer
        public void write(String str, int i, int i2) {
            if (this.mIgnore) {
                return;
            }
            int i3 = this.mLength;
            if (i3 + i2 > 4000) {
                this.mIgnore = true;
            } else {
                this.mLength = i3 + i2;
                super.write(str, i, i2);
            }
        }
    }
}
