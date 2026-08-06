package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.db;
import com.xiaomi.push.dc;
import java.io.File;

/* loaded from: classes7.dex */
public class Logger {
    private static boolean sDisablePushLog;
    private static LoggerInterface sUserLogger;

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    public static void setPushLog(Context context) {
        boolean z = sUserLogger != null;
        boolean z2 = sDisablePushLog;
        com.xiaomi.channel.commonutils.logger.b.a(new db(z2 ? false : z ? sUserLogger : null, z2 ^ true ? dc.a(context) : null));
    }
}
