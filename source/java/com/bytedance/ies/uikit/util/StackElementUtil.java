package com.bytedance.ies.uikit.util;

import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes4.dex */
public class StackElementUtil {
    public static void getStackTraceElementInfo(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\n");
    }

    public static String getStackTraces(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i < stackTraceElementArr.length) {
            getStackTraceElementInfo(stackTraceElementArr[i], sb);
            i++;
        }
        return sb.toString();
    }
}
