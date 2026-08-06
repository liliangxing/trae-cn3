package com.bytedance.crash.config;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class NpthBuildConfig {
    public static String VERSION_NAME;

    static {
        String reviseVersionName = reviseVersionName("4.2.2-rc.10", "cnNoasanInnerFull".toLowerCase());
        if (!TextUtils.isEmpty(reviseVersionName)) {
            VERSION_NAME = reviseVersionName;
        } else {
            VERSION_NAME = "4.2.2-rc.10";
        }
    }

    public static String reviseVersionName(String str, String str2) {
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            String str3 = split.length == 2 ? str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1] : "";
            String extractVersionNumber = extractVersionNumber(split[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(extractVersionNumber);
            if (str2.contains("oversea")) {
                sb.append(".oversea");
            }
            if (str2.contains("lite")) {
                sb.append(".lite");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(str3);
            }
            return sb.toString();
        } catch (Throwable th) {
            Log.e("NpthBuildConfig", th.toString(), th);
            return null;
        }
    }

    public static String extractVersionNumber(String str) {
        if (str == null) {
            return null;
        }
        int i = 1;
        if (Character.isDigit(str.charAt(str.length() - 1))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        while (i < str.length()) {
            char charAt2 = str.charAt(i);
            if (!Character.isDigit(str.charAt(i)) && charAt2 != '.') {
                break;
            }
            sb.append(charAt);
            i++;
            charAt = charAt2;
        }
        return sb.toString();
    }
}
