package com.ss.android.deviceregister.utils;

import android.text.TextUtils;

/* loaded from: classes7.dex */
public class DeviceRegistrationUtils {
    public static boolean isValidUDID(String str) {
        int length;
        if (str == null || (length = str.length()) < 13 || length > 160) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInValidId(String str) {
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("unknown") || str.equalsIgnoreCase("None")) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
}
