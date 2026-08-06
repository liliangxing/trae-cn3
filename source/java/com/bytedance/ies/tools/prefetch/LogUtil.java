package com.bytedance.ies.tools.prefetch;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u001a\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/LogUtil;", "", "()V", "LOG_TAG", "", "logger", "Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;", "getLogger", "()Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;", "setLogger", "(Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;)V", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "message", "e", LynxError.LYNX_THROWABLE, "", RXScreenCaptureService.KEY_INDEX, "w", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public final class LogUtil {
    public static final String LOG_TAG = "IESPrefetch";
    public static final LogUtil INSTANCE = new LogUtil();
    private static IPrefetchLogger logger = new IPrefetchLogger() { // from class: com.bytedance.ies.tools.prefetch.LogUtil$logger$1
        @Override // com.bytedance.ies.tools.prefetch.IPrefetchLogger
        public void onLog(int level, String message) {
            Intrinsics.checkParameterIsNotNull(message, "message");
            if (level == 0) {
                Log.d(LogUtil.LOG_TAG, message);
                return;
            }
            if (level == 1) {
                Log.i(LogUtil.LOG_TAG, message);
            } else if (level == 2) {
                Log.w(LogUtil.LOG_TAG, message);
            } else {
                if (level != 3) {
                    return;
                }
                Log.e(LogUtil.LOG_TAG, message);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchLogger
        public void onLog(int level, String message, Throwable throwable) {
            Intrinsics.checkParameterIsNotNull(message, "message");
            Intrinsics.checkParameterIsNotNull(throwable, "throwable");
            if (level == 2) {
                Log.w(LogUtil.LOG_TAG, message, throwable);
            } else if (level == 3) {
                Log.e(LogUtil.LOG_TAG, message, throwable);
            }
            throwable.printStackTrace();
        }
    };

    private LogUtil() {
    }

    public final IPrefetchLogger getLogger() {
        return logger;
    }

    public final void setLogger(IPrefetchLogger iPrefetchLogger) {
        Intrinsics.checkParameterIsNotNull(iPrefetchLogger, "<set-?>");
        logger = iPrefetchLogger;
    }

    public final void i(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        logger.onLog(1, message);
    }

    public final void d(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        logger.onLog(0, message);
    }

    public static /* synthetic */ void w$default(LogUtil logUtil, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logUtil.w(str, th);
    }

    public final void w(String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (throwable == null) {
            logger.onLog(2, message);
        } else {
            logger.onLog(2, message, throwable);
        }
    }

    public static /* synthetic */ void e$default(LogUtil logUtil, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logUtil.e(str, th);
    }

    public final void e(String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (throwable == null) {
            logger.onLog(3, message);
        } else {
            logger.onLog(3, message, throwable);
        }
    }
}
