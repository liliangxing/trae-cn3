package com.ss.android;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.ss.android.account.TTAccountInit;
import com.ss.android.update.UpdateDialogNewBase;

/* loaded from: classes7.dex */
public class LogHelper {
    public static void v(String str, String str2) {
        log(2, str, str2, null);
    }

    public static void d(String str, String str2) {
        log(3, str, str2, null);
    }

    public static void i(String str, String str2) {
        log(4, str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void w(String str, String str2, Throwable th) {
        log(5, str, str2, th);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void e(String str, String str2, Throwable th) {
        log(6, str, str2, th);
    }

    public static void log(int i, String str, String str2, Throwable th) {
        if (th != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = Log.getStackTraceString(th);
            } else {
                str2 = str2 + UpdateDialogNewBase.TYPE + Log.getStackTraceString(th);
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (TTAccountInit.getLogger() != null) {
            TTAccountInit.getLogger().log(i, str, str2);
            return;
        }
        switch (i) {
            case 2:
                Logger.v(str, str2);
                return;
            case 3:
                Logger.d(str, str2);
                return;
            case 4:
                Logger.i(str, str2);
                return;
            case 5:
                Logger.w(str, str2);
                return;
            case 6:
            case 7:
                Logger.e(str, str2);
                return;
            default:
                return;
        }
    }
}
