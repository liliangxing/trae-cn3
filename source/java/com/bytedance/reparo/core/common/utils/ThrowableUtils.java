package com.bytedance.reparo.core.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public class ThrowableUtils {
    public static String getThrowableStack(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
