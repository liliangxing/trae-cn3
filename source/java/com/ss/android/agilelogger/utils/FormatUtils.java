package com.ss.android.agilelogger.utils;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.agilelogger.formatter.Formatter;
import com.ss.android.agilelogger.formatter.border.DefaultBorderFormatter;
import com.ss.android.agilelogger.formatter.message.DefaultDateFormatter;
import com.ss.android.agilelogger.formatter.message.json.DefaultJsonFormatter;
import com.ss.android.agilelogger.formatter.message.object.BundleFormatter;
import com.ss.android.agilelogger.formatter.message.object.IntentFormatter;
import com.ss.android.agilelogger.formatter.message.throwable.DefaultThrowableFormatter;
import com.ss.android.agilelogger.formatter.stacktrace.DefaultStackTraceFormatter;
import com.ss.android.agilelogger.formatter.thread.DefaultThreadFormatter;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FormatUtils {
    private static ConcurrentHashMap<TYPE, Formatter> formatterHashMap;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum TYPE {
        MSG,
        JSON,
        BUNDLE,
        INTENT,
        THROWABLE,
        BORDER,
        STACKTRACE,
        THREAD,
        STACKTRACE_STR
    }

    static {
        ConcurrentHashMap<TYPE, Formatter> concurrentHashMap = new ConcurrentHashMap<>();
        formatterHashMap = concurrentHashMap;
        concurrentHashMap.put(TYPE.MSG, new DefaultDateFormatter());
        formatterHashMap.put(TYPE.JSON, new DefaultJsonFormatter());
        formatterHashMap.put(TYPE.BUNDLE, new BundleFormatter());
        formatterHashMap.put(TYPE.INTENT, new IntentFormatter());
        formatterHashMap.put(TYPE.BORDER, new DefaultBorderFormatter());
        formatterHashMap.put(TYPE.STACKTRACE, new DefaultStackTraceFormatter());
        formatterHashMap.put(TYPE.THREAD, new DefaultThreadFormatter());
        formatterHashMap.put(TYPE.THROWABLE, new DefaultThrowableFormatter());
    }

    public static String format(TYPE type, String str) {
        Formatter formatter = formatterHashMap.get(type);
        if (formatter == null) {
            return str;
        }
        if (type == TYPE.BORDER) {
            return formatter.format(new String[]{str});
        }
        return formatter.format(str);
    }

    public static String format(TYPE type, StackTraceElement[] stackTraceElementArr) {
        return formatterHashMap.get(type).format(stackTraceElementArr);
    }

    public static String format(TYPE type, Bundle bundle) {
        return ((BundleFormatter) formatterHashMap.get(type)).format(bundle);
    }

    public static String format(TYPE type, Intent intent) {
        return ((IntentFormatter) formatterHashMap.get(type)).format(intent);
    }

    public static String format(TYPE type, Throwable th) {
        return formatterHashMap.get(type).format(th);
    }

    public static String format(TYPE type, Thread thread) {
        return formatterHashMap.get(type).format(thread);
    }
}
