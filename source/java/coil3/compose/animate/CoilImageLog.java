package coil3.compose.animate;

import kotlin.ExceptionsKt;
import kotlin.Metadata;

/* compiled from: CoilImageLog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcoil3/compose/animate/CoilImageLog;", "", "<init>", "()V", "LOG_LEVEL_DEBUG", "", "LOG_LEVEL_INFO", "LOG_LEVEL_ERROR", "logLevel", "getLogLevel", "()I", "setLogLevel", "(I)V", "debug", "", "msg", "", "info", "error", "err", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CoilImageLog {
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 2;
    public static final CoilImageLog INSTANCE = new CoilImageLog();
    private static int logLevel = 3;
    public static final int $stable = 8;

    private CoilImageLog() {
    }

    public final int getLogLevel() {
        return logLevel;
    }

    public final void setLogLevel(int i) {
        logLevel = i;
    }

    public final void debug(String msg) {
        if (logLevel <= 1) {
            AnimatedImageLog_androidKt.printLog(msg);
        }
    }

    public final void info(String msg) {
        if (logLevel <= 2) {
            AnimatedImageLog_androidKt.printLog(msg);
        }
    }

    public final void error(String msg, Throwable err) {
        if (logLevel <= 3) {
            AnimatedImageLog_androidKt.printLog(msg + '\n' + (err != null ? ExceptionsKt.stackTraceToString(err) : null));
        }
    }
}
