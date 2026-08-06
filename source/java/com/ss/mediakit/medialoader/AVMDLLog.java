package com.ss.mediakit.medialoader;

import android.util.Log;
import java.util.Locale;

/* loaded from: classes7.dex */
public class AVMDLLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "AVMDLLog";
    public static int enableLogOptimization;

    @FunctionalInterface
    /* loaded from: classes7.dex */
    public interface LogMessageSupplier {
        String get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$d$0(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$e$2(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$kill$5(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$track$4(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$v$3(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$w$1(String str) {
        return str;
    }

    public static final void turnOn(int i, int i2) {
        LogTurnOn = (i2 << i) | ((~(1 << i)) & LogTurnOn);
    }

    public static boolean isLogLevelEnabled(int i) {
        return i >= 0 && i <= 6 && ((LogTurnOn >> i) & 1) == 1;
    }

    private static void log(int i, String str, LogMessageSupplier logMessageSupplier) {
        String str2;
        int i2 = enableLogOptimization;
        if (i2 == 0) {
            str2 = logMessageSupplier.get();
        } else if (i2 == 2) {
            return;
        } else {
            str2 = null;
        }
        if (isLogLevelEnabled(i)) {
            if (str2 == null) {
                str2 = logMessageSupplier.get();
            }
            printLog(i, str, str2);
        }
    }

    private static void printLog(int i, String str, String str2) {
        String format = String.format(Locale.US, "<%s>%s", str, str2);
        switch (i) {
            case 0:
                Log.v(TAG, format);
                return;
            case 1:
                Log.d(TAG, format);
                return;
            case 2:
                Log.i(TAG, format);
                return;
            case 3:
                Log.i(TAG, "[TRACK] " + format);
                return;
            case 4:
                Log.wtf(TAG, "[KILL] " + format);
                return;
            case 5:
                Log.w(TAG, format);
                return;
            case 6:
                Log.e(TAG, format);
                return;
            default:
                Log.w(TAG, "[UNKNOWN LEVEL] " + format);
                return;
        }
    }

    public static void d(String str, final String str2) {
        log(1, str, new LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLLog$$ExternalSyntheticLambda3
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLLog.lambda$d$0(str2);
            }
        });
    }

    public static void d(String str, LogMessageSupplier logMessageSupplier) {
        log(1, str, logMessageSupplier);
    }

    public static void i(String str, LogMessageSupplier logMessageSupplier) {
        log(2, str, logMessageSupplier);
    }

    public static void w(String str, final String str2) {
        log(5, str, new LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLLog$$ExternalSyntheticLambda1
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLLog.lambda$w$1(str2);
            }
        });
    }

    public static void w(String str, LogMessageSupplier logMessageSupplier) {
        log(5, str, logMessageSupplier);
    }

    public static void e(String str, final String str2) {
        log(6, str, new LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLLog$$ExternalSyntheticLambda0
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLLog.lambda$e$2(str2);
            }
        });
    }

    public static void e(String str, LogMessageSupplier logMessageSupplier) {
        log(6, str, logMessageSupplier);
    }

    public static void v(String str, final String str2) {
        log(0, str, new LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLLog$$ExternalSyntheticLambda4
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLLog.lambda$v$3(str2);
            }
        });
    }

    public static void v(String str, LogMessageSupplier logMessageSupplier) {
        log(0, str, logMessageSupplier);
    }

    public static void track(String str, final String str2) {
        log(3, str, new LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLLog$$ExternalSyntheticLambda2
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLLog.lambda$track$4(str2);
            }
        });
    }

    public static void track(String str, LogMessageSupplier logMessageSupplier) {
        log(3, str, logMessageSupplier);
    }

    public static void kill(String str, final String str2) {
        log(4, str, new LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLLog$$ExternalSyntheticLambda5
            @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
            public final String get() {
                return AVMDLLog.lambda$kill$5(str2);
            }
        });
    }

    public static void kill(String str, LogMessageSupplier logMessageSupplier) {
        log(4, str, logMessageSupplier);
    }
}
