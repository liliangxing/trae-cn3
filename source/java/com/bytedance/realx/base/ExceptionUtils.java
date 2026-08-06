package com.bytedance.realx.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public class ExceptionUtils {
    public static String stackTrace(Throwable t) {
        t.printStackTrace(new PrintWriter(new StringWriter()));
        return t.toString();
    }
}
