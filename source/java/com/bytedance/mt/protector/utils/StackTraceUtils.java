package com.bytedance.mt.protector.utils;

import com.bytedance.mt.protector.impl.EqualsProtectorUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class StackTraceUtils {
    public static Throwable removeStackTrace(Throwable th, Class cls) {
        if (cls != null && th != null && th.getStackTrace() != null && th.getStackTrace().length != 0) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            ArrayList arrayList = new ArrayList();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && !EqualsProtectorUtils.equals(stackTraceElement.getClassName(), cls.getName())) {
                    arrayList.add(stackTraceElement);
                }
            }
            th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
        }
        return th;
    }

    public static String getStackTrace(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        th.printStackTrace(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream.toString();
    }
}
