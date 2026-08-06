package com.ss.android.common.app.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Process;

/* loaded from: classes7.dex */
public class PermissionActivityCompat {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        ActivityCompatApi23.requestPermissions(activity, strArr, i);
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
