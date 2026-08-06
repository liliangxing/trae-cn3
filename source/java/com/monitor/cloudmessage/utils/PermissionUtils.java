package com.monitor.cloudmessage.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class PermissionUtils {
    public static boolean checkSelfPermission(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkPermission(str, Process.myPid(), Process.myUid()) != 0) ? false : true;
    }
}
