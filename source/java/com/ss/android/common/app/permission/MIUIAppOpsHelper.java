package com.ss.android.common.app.permission;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Process;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public final class MIUIAppOpsHelper {
    private static final int MODE_ALLOW = 0;
    private static final int MODE_ASK = 4;
    private static final int MODE_DEFAULT = -1;
    private static final int MODE_REJECT = 1;
    public static final int OPS_READ_APP_LIST = 10022;
    public static final int OPS_SHOW_UI_WHEN_BACKGROUND = 10021;
    public static final int OPS_SHOW_WHEN_LOCKED = 10020;

    public static boolean isRejected(int i, Context context) {
        return checkOps(i, context) == 1;
    }

    private static int checkOps(int i, Context context) {
        try {
            Class<?> cls = Class.forName("android.app.AppOpsManager");
            return ((Integer) cls.getMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(i), Integer.valueOf(Process.myUid()), context.getPackageName())).intValue();
        } catch (InvocationTargetException unused) {
            return 0;
        } catch (Exception unused2) {
            return -1;
        }
    }
}
