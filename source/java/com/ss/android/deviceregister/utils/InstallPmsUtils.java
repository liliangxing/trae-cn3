package com.ss.android.deviceregister.utils;

import android.content.Context;

/* loaded from: classes7.dex */
class InstallPmsUtils {
    InstallPmsUtils() {
    }

    public static boolean checkReadPhoneStatePermission(Context context) {
        return checkPermission(context, "android.permission.READ_PHONE_STATE");
    }

    private static boolean checkPermission(Context context, String str) {
        try {
            return context.checkSelfPermission(str) == 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
