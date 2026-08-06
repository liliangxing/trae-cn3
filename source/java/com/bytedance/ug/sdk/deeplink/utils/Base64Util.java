package com.bytedance.ug.sdk.deeplink.utils;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes4.dex */
public class Base64Util {
    private static final String TAG = "Base64Util";

    public static String decode(String str, String str2) {
        String str3;
        Logger.d(TAG, "Base64Util decode before decode:" + str);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() > str2.length()) {
            try {
                str3 = new String(Base64.decode(str.substring(str2.length()), 0));
            } catch (Throwable th) {
                Logger.e(TAG, "Base64Util decode decode error", th);
            }
            Logger.d(TAG, "Base64Util decode after decode:".concat(str3));
            return str3;
        }
        str3 = "";
        Logger.d(TAG, "Base64Util decode after decode:".concat(str3));
        return str3;
    }
}
