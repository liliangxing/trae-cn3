package com.ss.bytertc.base.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes7.dex */
public class ExceptionUtils {
    public static String stackTrace(Throwable t) {
        t.printStackTrace(new PrintWriter(new StringWriter()));
        return t.toString();
    }

    public static String cause(Throwable t) {
        String str = null;
        while (t != null && t.getCause() != null) {
            str = t.getCause().toString();
            t = t.getCause();
        }
        return str;
    }
}
