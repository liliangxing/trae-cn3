package com.monitor.cloudmessage.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes7.dex */
public class ExceptionUtils {
    public static String getFullStacktrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
