package com.ss.android.agilelogger.formatter.stacktrace;

import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes7.dex */
public class DefaultStackTraceFormatter implements StackTraceFormatter {
    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder(256);
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        if (stackTraceElementArr.length == 1) {
            return "\t─ " + stackTraceElementArr[0].toString();
        }
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append(UpdateDialogNewBase.TYPE);
            }
            if (i != length - 1) {
                sb.append("\t├ ");
                sb.append(stackTraceElementArr[i].toString());
                sb.append(UpdateDialogNewBase.TYPE);
            } else {
                sb.append("\t└ ");
                sb.append(stackTraceElementArr[i].toString());
            }
        }
        return sb.toString();
    }
}
