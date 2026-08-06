package com.bytedance.monitor.collector;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes4.dex */
public class Util {
    private static final String INVALID_STACK = "Invalid Stack\n";
    public static boolean enable;
    public static boolean enableLooperObserver;
    public static boolean enableLooperOpt;

    private Util() {
    }

    public static String parseMessageKey(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "unknown message";
        }
        try {
            String[] split = str.split(Constants.COLON_SEPARATOR);
            String str3 = split.length == 2 ? split[1] : "";
            if (str.contains("{") && str.contains("}")) {
                str2 = str.split("\\{")[0];
                try {
                    str = str2 + str.split("\\}")[1];
                } catch (Throwable unused) {
                    return str2;
                }
            } else {
                str2 = str;
            }
            if (str.contains("@")) {
                String[] split2 = str.split("@");
                if (split2.length > 1) {
                    str = split2[0];
                }
            }
            if (str.contains("(") && str.contains(")") && !str.endsWith(" null")) {
                String[] split3 = str.split("\\(");
                if (split3.length > 1) {
                    str = split3[1];
                }
                str = str.replace(")", "");
            }
            if (str.startsWith(" ")) {
                str = str.replace(" ", "");
            }
            return str + str3;
        } catch (Throwable unused2) {
            return str;
        }
    }

    public static String stackToString(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return INVALID_STACK;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            i++;
            sb.append("\tat " + stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\n");
            if (i > 40) {
                break;
            }
        }
        return sb.toString();
    }

    public static String stackToString(StackTraceElement[] stackTraceElementArr, String str) {
        if (stackTraceElementArr == null) {
            return INVALID_STACK;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            i++;
            if (!z) {
                if (stackTraceElement.getMethodName().equals(str)) {
                    z = true;
                }
            } else {
                sb.append("at " + stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\n");
                if (i > 40) {
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String getTopMethodName(String str) {
        int indexOf;
        int indexOf2;
        return (TextUtils.isEmpty(str) || (indexOf = str.indexOf("at ") + 3) >= (indexOf2 = str.indexOf(40))) ? "unknownMethodName" : str.substring(indexOf, indexOf2);
    }

    public static String stackToStringWithESC(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return INVALID_STACK;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            i++;
            sb.append("\\tat " + stackTraceElement.getClassName()).append(LibrarianImpl.Constants.DOT).append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(Constants.COLON_SEPARATOR).append(stackTraceElement.getLineNumber()).append(")\\n");
            if (i > 40) {
                break;
            }
        }
        return sb.toString();
    }
}
