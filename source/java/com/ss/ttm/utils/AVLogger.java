package com.ss.ttm.utils;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttm.player.TTPlayerConfiger;
import com.ss.vcbkit.VLog;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class AVLogger {
    public static final boolean DEBUG = false;
    public static final String FORMAT = "<%s,%x>%s";
    public static final int LEVEL_LOG_ALL = 0;
    public static final int LEVEL_LOG_DEBUG = 16777216;
    public static final int LEVEL_LOG_ERROR = 67108864;
    public static final int LEVEL_LOG_FATAL = 83886080;
    public static final int LEVEL_LOG_INFO = 33554432;
    public static final int LEVEL_LOG_INFO_KILL = 34603008;
    public static final int LEVEL_LOG_INFO_TRACK_FUNC = 42860544;
    public static final int LEVEL_LOG_INFO_TRACK_LIFE = 42926080;
    public static final int LEVEL_LOG_SILENT = 100663296;
    public static final int LEVEL_LOG_VERBOSE = 0;
    public static final int LEVEL_LOG_WARN = 50331648;
    private static final String TAG = "ttmj";
    private static final String TTVideoEngineLog = "com.ss.ttvideoengine.utils.TTVideoEngineLog";
    private static int gLogLevel = 33554432;
    private static Method methodLogD;
    private static Method methodLogE;
    private static Method methodLogI;
    private static Method methodLogW;
    private static Class<?> objectTTVideoEngineLog;

    public static void Debug(String tag, Object ob, String msg) {
    }

    public static void Verbose(String tag, Object ob, String msg) {
    }

    public static void setLogLevel(int logLevel) {
        gLogLevel = logLevel;
    }

    public static void v(String tag, String msg) {
        Verbose(tag, null, msg);
    }

    public static void d(String tag, String msg) {
        Debug(tag, null, msg);
    }

    public static void i(String tag, String msg) {
        Info(tag, null, msg);
    }

    public static void k(String tag, String msg) {
        InfoKill(tag, null, msg);
    }

    public static void w(String tag, String msg) {
        Warn(tag, null, msg);
    }

    public static void e(String tag, String msg) {
        Error(tag, null, msg);
    }

    public static void Info(String tag, Object ob, String msg) {
        log(LEVEL_LOG_INFO, tag, ob, msg);
    }

    public static void InfoKill(String tag, Object ob, String msg) {
        log(LEVEL_LOG_INFO_KILL, tag, ob, msg);
    }

    public static void InfoTrackFunc(String tag, Object ob, String msg) {
        log(LEVEL_LOG_INFO_TRACK_FUNC, tag, ob, msg);
    }

    public static void InfoTrackLife(String tag, Object ob, String msg) {
        log(LEVEL_LOG_INFO_TRACK_LIFE, tag, ob, msg);
    }

    public static void Warn(String tag, Object ob, String msg) {
        log(LEVEL_LOG_WARN, tag, ob, msg);
    }

    public static void Error(String tag, Object ob, String msg) {
        log(67108864, tag, ob, msg);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0111 A[Catch: Exception -> 0x0123, TryCatch #1 {Exception -> 0x0123, blocks: (B:41:0x00cf, B:45:0x00d3, B:48:0x00e3, B:49:0x00e7, B:51:0x00f7, B:52:0x00fb, B:54:0x0111, B:55:0x0115, B:57:0x010b), top: B:24:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0115 A[Catch: Exception -> 0x0123, TRY_LEAVE, TryCatch #1 {Exception -> 0x0123, blocks: (B:41:0x00cf, B:45:0x00d3, B:48:0x00e3, B:49:0x00e7, B:51:0x00f7, B:52:0x00fb, B:54:0x0111, B:55:0x0115, B:57:0x010b), top: B:24:0x00ad }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void log(int level, String tag, Object ob, String message) {
        if (level < (gLogLevel & SupportMenu.CATEGORY_MASK)) {
            return;
        }
        boolean z = TTPlayerConfiger.getValue(75, 0) == 1;
        if (!z && objectTTVideoEngineLog == null) {
            try {
                Class<?> cls = Class.forName(TTVideoEngineLog);
                objectTTVideoEngineLog = cls;
                if (cls != null) {
                    methodLogD = cls.getMethod(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, String.class, String.class);
                    methodLogI = objectTTVideoEngineLog.getMethod(RXScreenCaptureService.KEY_INDEX, String.class, String.class);
                    methodLogW = objectTTVideoEngineLog.getMethod("w", String.class, String.class);
                    methodLogE = objectTTVideoEngineLog.getMethod("e", String.class, String.class);
                }
            } catch (Exception e) {
                objectTTVideoEngineLog = null;
                Log.e(TAG, "reflect failed! e:" + e);
                return;
            }
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[3];
        objArr[0] = tag;
        objArr[1] = Integer.valueOf(ob == null ? 0 : ob.hashCode());
        objArr[2] = message;
        String format = String.format(locale, FORMAT, objArr);
        try {
            if (level == 0) {
                if (z) {
                    VLog.v(TAG, format);
                }
                if (!z) {
                }
            }
            if (level != 16777216) {
                if (level == 33554432 || level == 34603008 || level == 42860544 || level == 42926080) {
                    if (z) {
                        VLog.i(TAG, format);
                    } else {
                        methodLogI.invoke(objectTTVideoEngineLog, TAG, format);
                    }
                } else if (level != 50331648) {
                    if (level != 67108864) {
                        return;
                    }
                    if (z) {
                        VLog.e(TAG, format);
                    } else {
                        methodLogE.invoke(objectTTVideoEngineLog, TAG, format);
                    }
                } else if (z) {
                    VLog.w(TAG, format);
                } else {
                    methodLogW.invoke(objectTTVideoEngineLog, TAG, format);
                }
            }
            if (!z) {
                VLog.d(TAG, format);
            } else {
                methodLogD.invoke(objectTTVideoEngineLog, TAG, format);
            }
        } catch (Exception e2) {
            Log.e(TAG, "invoke failed! e:" + e2);
        }
    }
}
