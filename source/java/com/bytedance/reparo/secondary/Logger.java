package com.bytedance.reparo.secondary;

import android.app.Application;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.common.utils.ThrowableUtils;
import com.bytedance.reparo.core.log.TLog;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes4.dex */
public class Logger {
    private static final String TAG_PREFIX = "Reparo/";
    private static final PatchLogger.ILogger logger = new DefaultLoggerImpl();
    private static final HashSet<String> LOG_PKGS = new HashSet<>();

    public static void init(Application application) {
        HashSet<String> hashSet = LOG_PKGS;
        hashSet.add(Logger.class.getName());
        hashSet.add(PatchLogger.class.getName());
        hashSet.add(TLog.class.getName());
        hashSet.add(DefaultLoggerImpl.class.getName());
        if (PatchLogger.getLogger() instanceof DefaultLoggerImpl) {
            return;
        }
        PatchLogger.setLogger(logger);
    }

    public static void d(String str, String str2) {
        logger.d(str, str2);
    }

    public static void i(String str, String str2) {
        logger.i(str, str2);
    }

    public static void w(String str, String str2) {
        logger.w(str, str2);
    }

    public static void e(String str, String str2) {
        try {
            logger.e(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void e(String str, String str2, Throwable th) {
        try {
            logger.e(str, str2, th);
        } catch (Throwable unused) {
        }
    }

    /* loaded from: classes4.dex */
    public static class DefaultLoggerImpl implements PatchLogger.ILogger {
        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void d(String str, String str2) {
            Log.d(Logger.TAG_PREFIX + str, str2);
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void i(String str, String str2) {
            Log.i(Logger.TAG_PREFIX + str, str2);
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void w(String str, String str2) {
            Log.w(Logger.TAG_PREFIX + str, str2);
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void w(String str, String str2, Throwable th) {
            Log.w(Logger.TAG_PREFIX + str, str2, th);
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void e(String str, String str2) {
            Log.e(Logger.TAG_PREFIX + str, str2);
            NpthService.reportError(Logger.TAG_PREFIX, "errorlog", Logger.removeLoggerStack(new RuntimeException("\"" + str2 + "\"")));
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void e(String str, String str2, Throwable th) {
            Log.e(Logger.TAG_PREFIX + str, th != null ? (str2 + UpdateDialogNewBase.TYPE) + ThrowableUtils.getThrowableStack(th) : str2);
            NpthService.reportError(Logger.TAG_PREFIX, Logger.shouldIgnoredException(th) ? "ignored" : "catched", Logger.removeLoggerStack(new RuntimeException("\"" + str2 + "\"", th)));
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void logForCollideMethod(String str, String str2) {
            Log.e(Logger.TAG_PREFIX, "check for collide method " + str2);
            NpthService.reportError(Logger.TAG_PREFIX, "collide", new CollideMethodException(str, str2).refillStack());
        }

        @Override // com.bytedance.reparo.core.PatchLogger.ILogger
        public void logForSymbolNotFound(String str) {
            Log.e(Logger.TAG_PREFIX, "logForSymbolNotFound " + str);
            NpthService.reportError(Logger.TAG_PREFIX, "symbol", new SymbolNotFoundException(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Throwable removeLoggerStack(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i = 0;
        int i2 = 0;
        while (true) {
            HashSet<String> hashSet = LOG_PKGS;
            if (i >= hashSet.size() || i >= stackTrace.length) {
                break;
            }
            if (!hashSet.contains(stackTrace[i].getClassName())) {
                i2 = i;
            }
            i++;
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2, stackTrace.length));
        return th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldIgnoredException(Throwable th) {
        Throwable th2 = th;
        for (int i = 0; i < 10 && th2 != null; i++) {
            if (th2 instanceof IOException) {
                return true;
            }
            if (th2.getCause() == th2) {
                break;
            }
            th2 = th.getCause();
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public static class CollideMethodException extends RuntimeException {
        private String mCollideMethod;

        public CollideMethodException(String str, String str2) {
            super("on " + str + " " + str2);
            this.mCollideMethod = str2;
        }

        public CollideMethodException refillStack() {
            try {
                int indexOf = this.mCollideMethod.indexOf(40);
                String str = this.mCollideMethod;
                String substring = str.substring(str.indexOf(32) + 1, this.mCollideMethod.lastIndexOf(LibrarianImpl.Constants.DOT, indexOf));
                String str2 = this.mCollideMethod;
                setStackTrace(new StackTraceElement[]{new StackTraceElement(substring, str2.substring(str2.lastIndexOf(LibrarianImpl.Constants.DOT, indexOf) + 1, indexOf), "SourceFile", 1)});
            } catch (Throwable unused) {
            }
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public static class SymbolNotFoundException extends RuntimeException {
        public SymbolNotFoundException(String str) {
            super("NotFoundSymbol " + str);
            setStackTrace(new StackTraceElement[]{new StackTraceElement("SymbolNotFoundException", str, "SourceFile", 1)});
        }
    }
}
