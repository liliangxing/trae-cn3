package com.bytedance.push.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;

/* loaded from: classes4.dex */
public class PushUtils {
    public static boolean isLollipopMr1() {
        return false;
    }

    public static void printStackTrace(Exception exc) {
        if (Logger.debug()) {
            exc.printStackTrace();
        }
    }

    public static boolean isBadDeviceId(String str) {
        if (StringUtils.isEmpty(str) || str.equalsIgnoreCase("unknown")) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean isVivo() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("vivo")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (!TextUtils.isEmpty(str2) && str2.toLowerCase().contains("vivo")) {
            return true;
        }
        String str3 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str3) && str3.toLowerCase().contains("vivo");
    }
}
