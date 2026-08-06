package com.bytedance.push.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.push.log.DefaultLogger;
import com.bytedance.push.log.ILogger;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;

/* loaded from: classes4.dex */
public class Logger {
    private static volatile ALog.LogInstance aLogInstance = null;
    private static boolean sDebuggable = false;
    private static boolean sEnableALog = false;
    private static int sLogLevel = 3;
    private static ILogger sLogger = new DefaultLogger();
    private static String TAG = "";
    private static boolean sAllowLog = false;

    public static void setPushAlogInstanceName(final Context context, final String str) {
        if (TextUtils.isEmpty(str) || aLogInstance != null) {
            return;
        }
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.utils.Logger.1
            @Override // java.lang.Runnable
            public void run() {
                if (Logger.aLogInstance == null) {
                    ALog.LogInstance unused = Logger.aLogInstance = ALog.createInstance(str, new ALogConfig.Builder(context).build());
                }
            }
        });
    }

    public static void setLogger(ILogger iLogger) {
        sLogger = iLogger;
        if (iLogger instanceof DefaultLogger) {
            return;
        }
        sAllowLog = true;
    }

    public static void setAllowLog(boolean z) {
        sAllowLog = z;
    }

    public static String getTag() {
        return TAG;
    }

    public static void openALog(Context context, boolean z, String str) {
        sEnableALog = z;
        setPushAlogInstanceName(context, str);
        if (TextUtils.isEmpty(TAG)) {
            TAG = "BDPush-" + ToolUtils.getCurProcessNameSuffix(context);
        }
    }

    public static void setLogLevel(int i) {
        sLogLevel = i;
    }

    public static void setDebuggable(boolean z) {
        sDebuggable = z;
    }

    public static void d(String str) {
        d("", str);
    }

    public static void d(String str, String str2) {
        if (sEnableALog) {
            if (aLogInstance != null) {
                aLogInstance.i(TAG, str + "\t>>>\t" + str2);
                return;
            } else {
                ALog.i(TAG, str + "\t>>>\t" + str2);
                return;
            }
        }
        if (sLogLevel <= 3) {
            if (sAllowLog || sDebuggable) {
                sLogger.d(TAG, str + "\t>>>\t" + str2);
            }
        }
    }

    public static void d(String str, String str2, Throwable th) {
        d(TAG, str + "\t>>>\t" + str2 + th.getMessage());
    }

    public static void e(String str) {
        e("", str);
    }

    public static void e(String str, String str2) {
        if (sEnableALog) {
            if (aLogInstance != null) {
                aLogInstance.e(TAG, str + "\t>>>\t" + str2);
                return;
            } else {
                ALog.e(TAG, str + "\t>>>\t" + str2);
                return;
            }
        }
        if (sLogLevel <= 6) {
            if (sAllowLog || sDebuggable) {
                sLogger.e(TAG, str + "\t>>> " + str2);
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        e(TAG, str + "\t>>>\t" + str2 + th.getMessage());
    }

    public static boolean debug() {
        return sDebuggable;
    }

    public static void i(String str) {
        i("", str);
    }

    public static void i(String str, String str2) {
        if (sEnableALog) {
            if (aLogInstance != null) {
                aLogInstance.i(TAG, str + "\t>>>\t" + str2);
                return;
            } else {
                ALog.i(TAG, str + "\t>>>\t" + str2);
                return;
            }
        }
        if (sLogLevel <= 4) {
            if (sAllowLog || sDebuggable) {
                sLogger.i(TAG, str + "\t>>>\t" + str2);
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        i(TAG, str + "\t>>>\t" + str2 + "\t>>>\t" + (th == null ? "null" : th.getMessage()));
    }

    public static void v(String str) {
        v("", str);
    }

    public static void v(String str, String str2) {
        if (sEnableALog) {
            if (aLogInstance != null) {
                aLogInstance.i(TAG, str + "\t>>>\t" + str2);
                return;
            } else {
                ALog.i(TAG, str + "\t>>>\t" + str2);
                return;
            }
        }
        if (sLogLevel <= 2) {
            if (sAllowLog || sDebuggable) {
                sLogger.v(TAG, str + "\t>>>\t" + str2);
            }
        }
    }

    public static void w(String str, String str2) {
        if (sEnableALog) {
            if (aLogInstance != null) {
                aLogInstance.w(TAG, str + "\t>>>\t" + str2);
                return;
            } else {
                ALog.w(TAG, str + "\t>>>\t" + str2);
                return;
            }
        }
        if (sLogLevel <= 5) {
            if (sAllowLog || sDebuggable) {
                sLogger.w(TAG, str + "\t>>>\t" + str2);
            }
        }
    }
}
