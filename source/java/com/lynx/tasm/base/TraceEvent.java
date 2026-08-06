package com.lynx.tasm.base;

import android.os.Trace;
import java.util.Map;
import java.util.Random;

/* loaded from: classes6.dex */
public class TraceEvent {
    public static final long CATEGORY_DEFAULT = 0;
    public static final long CATEGORY_FPS = 3;
    public static final long CATEGORY_SCREENSHOTS = 2;
    public static final long CATEGORY_VITALS = 1;
    public static final String DEFAULT_INSTANT_COLOR = "#FF0000";
    public static final String[] defualt_categories = {"lynx", "vitals", "screenshot", "fps"};
    private static boolean sTraceEnvInited = false;
    private static boolean sDebugModeEnabled = false;
    private static boolean sPerfettoTraceEnabled = false;
    private static boolean sSystemTraceEnabled = false;

    private static native void nativeBeginSection(String str, String str2);

    private static native void nativeBeginSectionWithProps(String str, String str2, Map<String, String> map);

    private static native boolean nativeCategoryEnabled(String str);

    private static native void nativeCounter(String str, String str2, long j);

    private static native void nativeEndSection(String str, String str2);

    private static native void nativeEndSectionWithProps(String str, String str2, Map<String, String> map);

    private static native void nativeInstant(String str, String str2, long j, String str3);

    private static native void nativeInstantWithProps(String str, String str2, long j, Map<String, String> map);

    private static native boolean nativePerfettoTraceEnabled();

    private static native boolean nativeSystemTraceEnabled();

    @Deprecated
    public static boolean registerTraceBackend(long j) {
        return false;
    }

    private static String getRandomColor() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append('#');
            for (int i = 0; i < 6; i++) {
                sb.append(Integer.toHexString(new Random().nextInt(16)));
            }
            return sb.toString().toUpperCase();
        } catch (Exception unused) {
            return DEFAULT_INSTANT_COLOR;
        }
    }

    public static void markTraceEnvInited(boolean z) {
        sTraceEnvInited = z;
    }

    public static void markTraceDebugMode(boolean z) {
        sDebugModeEnabled = z;
    }

    public static void beginSection(String str) {
        beginSection(0L, str);
    }

    public static void endSection(String str) {
        endSection(0L, str);
    }

    @Deprecated
    public static void beginSection(long j, String str) {
        beginSection(defualt_categories[(int) j], str);
    }

    public static void beginSection(String str, String str2) {
        if (!TraceController.isNativeTracingOnly() && enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                nativeBeginSection(str, str2);
            } else {
                Trace.beginSection(str2);
            }
        }
    }

    @Deprecated
    public static void endSection(long j, String str) {
        endSection(defualt_categories[(int) j], str);
    }

    public static void endSection(String str, String str2) {
        if (!TraceController.isNativeTracingOnly() && enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                nativeEndSection(str, str2);
            } else {
                Trace.endSection();
            }
        }
    }

    public static void beginSection(String str, Map<String, String> map) {
        beginSection(0L, str, map);
    }

    @Deprecated
    public static void beginSection(long j, String str, Map<String, String> map) {
        beginSection(defualt_categories[(int) j], str, map);
    }

    public static void beginSection(String str, String str2, Map<String, String> map) {
        if (!TraceController.isNativeTracingOnly() && enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                nativeBeginSectionWithProps(str, str2, map);
            } else {
                Trace.beginSection(str2);
            }
        }
    }

    @Deprecated
    public static void endSection(long j, String str, Map<String, String> map) {
        endSection(defualt_categories[(int) j], str, map);
    }

    public static void endSection(String str, String str2, Map<String, String> map) {
        if (!TraceController.isNativeTracingOnly() && enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                nativeEndSectionWithProps(str, str2, map);
            } else {
                Trace.endSection();
            }
        }
    }

    @Deprecated
    public static void instant(long j, String str) {
        instant(defualt_categories[(int) j], str, System.nanoTime() / 1000);
    }

    public static void instant(String str, String str2) {
        instant(str, str2, System.nanoTime() / 1000);
    }

    @Deprecated
    public static void instant(long j, String str, long j2) {
        instant(defualt_categories[(int) j], str, j2, getRandomColor());
    }

    public static void instant(String str, String str2, long j) {
        instant(str, str2, j, getRandomColor());
    }

    @Deprecated
    public static void instant(long j, String str, String str2) {
        instant(defualt_categories[(int) j], str, System.nanoTime() / 1000, str2);
    }

    public static void instant(String str, String str2, String str3) {
        instant(str, str2, System.nanoTime() / 1000, str3);
    }

    @Deprecated
    public static void instant(long j, String str, Map<String, String> map) {
        instant(defualt_categories[(int) j], str, map);
    }

    public static void instant(String str, String str2, Map<String, String> map) {
        if (enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                nativeInstantWithProps(str, str2, System.nanoTime() / 1000, map);
            } else {
                Trace.beginSection(str2);
                Trace.endSection();
            }
        }
    }

    @Deprecated
    public static void counter(long j, String str, long j2) {
        counter(defualt_categories[(int) j], str, j2);
    }

    public static void counter(String str, String str2, long j) {
        if (!TraceController.isNativeTracingOnly() && enableTrace() && isTracingStarted()) {
            nativeCounter(str, str2, j);
        }
    }

    @Deprecated
    public static boolean categoryEnabled(long j) {
        return categoryEnabled(defualt_categories[(int) j]);
    }

    public static boolean categoryEnabled(String str) {
        return enableTrace() && nativeCategoryEnabled(str);
    }

    public static boolean enableTrace() {
        return sDebugModeEnabled;
    }

    public static boolean enableSystemTrace() {
        if (!sSystemTraceEnabled && sTraceEnvInited) {
            sSystemTraceEnabled = nativeSystemTraceEnabled();
        }
        return sSystemTraceEnabled;
    }

    public static boolean enablePerfettoTrace() {
        if (!sPerfettoTraceEnabled && sTraceEnvInited) {
            sPerfettoTraceEnabled = nativePerfettoTraceEnabled();
        }
        return sPerfettoTraceEnabled;
    }

    public static boolean isTracingStarted() {
        return TraceController.isTracingStarted();
    }

    private static void instant(String str, String str2, long j, String str3) {
        if (enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                nativeInstant(str, str2, j, str3);
            } else {
                Trace.beginSection(str2);
                Trace.endSection();
            }
        }
    }

    private static void instant(String str, String str2, long j, Map<String, String> map) {
        if (enableTrace()) {
            if (enablePerfettoTrace() && isTracingStarted()) {
                if (j <= 0) {
                    j = System.nanoTime() / 1000;
                }
                nativeInstantWithProps(str, str2, j, map);
            } else {
                Trace.beginSection(str2);
                Trace.endSection();
            }
        }
    }
}
