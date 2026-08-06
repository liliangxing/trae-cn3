package com.bytedance.platform.godzilla.common;

import android.util.Log;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes4.dex */
public final class Logger {
    private static Level sLevel = Level.INFO;
    public static boolean isDebug = false;
    private static ILog sLogImpl = new ILog() { // from class: com.bytedance.platform.godzilla.common.Logger.1
        @Override // com.bytedance.platform.godzilla.common.ILog
        public void println(String str, String str2, Level level) {
            Log.println(convertLevel(level), str, str2);
        }

        private int convertLevel(Level level) {
            int i = AnonymousClass2.$SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[level.ordinal()];
            if (i == 1) {
                return 3;
            }
            if (i == 2) {
                return 6;
            }
            if (i != 3) {
                return i != 4 ? 2 : 4;
            }
            return 5;
        }
    };

    /* loaded from: classes4.dex */
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        NONE
    }

    private Logger() {
    }

    public static boolean debug() {
        return isDebug;
    }

    public static void setLogLevel(Level level) {
        sLevel = level;
        if (level == Level.DEBUG) {
            isDebug = true;
        }
    }

    public static void setLog(ILog iLog) {
        sLogImpl = iLog;
    }

    public static void e(String str, String str2, Object... objArr) {
        println(str, String.format(str2, objArr), Level.ERROR);
    }

    public static void e(String str, String str2) {
        println(str, str2, Level.ERROR);
    }

    public static void w(String str, String str2, Object... objArr) {
        println(str, String.format(str2, objArr), Level.WARNING);
    }

    public static void w(String str, String str2) {
        println(str, str2, Level.WARNING);
    }

    public static void i(String str, String str2, Object... objArr) {
        println(str, String.format(str2, objArr), Level.INFO);
    }

    public static void i(String str, String str2) {
        println(str, str2, Level.INFO);
    }

    public static void d(String str, String str2, Object... objArr) {
        println(str, String.format(str2, objArr), Level.DEBUG);
    }

    public static void d(String str, String str2) {
        println(str, str2, Level.DEBUG);
    }

    public static void println(String str, String str2, Level level) {
        if (level.ordinal() >= sLevel.ordinal()) {
            sLogImpl.println(str, str2, level);
        }
    }

    public static void printStackTrace(String str, Throwable th) {
        printStackTrace(str, th, null);
    }

    public static void printStackTrace(String str, Throwable th, String str2) {
        println(str, (str2 == null ? "" : str2 + UpdateDialogNewBase.TYPE) + th.getMessage() + UpdateDialogNewBase.TYPE + getStackTraceString(th), Level.ERROR);
    }

    private static String getStackTraceString(Throwable th) {
        String str = "";
        if (th == null) {
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                str = str + stackTraceElement.toString() + UpdateDialogNewBase.TYPE;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.platform.godzilla.common.Logger$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level = iArr;
            try {
                iArr[Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[Level.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[Level.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[Level.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
