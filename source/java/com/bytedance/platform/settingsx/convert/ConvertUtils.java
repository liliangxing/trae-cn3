package com.bytedance.platform.settingsx.convert;

import com.bytedance.ies.bullet.service.router.RouterConstants;

/* loaded from: classes4.dex */
public class ConvertUtils {
    public static int convertValueToList(CharSequence charSequence, String[] strArr, int i) {
        if (charSequence != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (charSequence.equals(strArr[i2])) {
                    return i2;
                }
            }
        }
        return i;
    }

    public static boolean convertValueToBoolean(CharSequence charSequence, boolean z) {
        return charSequence == null ? z : charSequence.equals("1") || charSequence.equals(RouterConstants.TRUE) || charSequence.equals("TRUE");
    }

    public static int convertValueToInt(CharSequence charSequence, int i) {
        int i2;
        int i3;
        if (charSequence == null) {
            return i;
        }
        String obj = charSequence.toString();
        int length = obj.length();
        if ('-' == obj.charAt(0)) {
            i3 = -1;
            i2 = 1;
        } else {
            i2 = 0;
            i3 = 1;
        }
        int i4 = 16;
        if ('0' == obj.charAt(i2)) {
            if (i2 == length - 1) {
                return 0;
            }
            int i5 = i2 + 1;
            char charAt = obj.charAt(i5);
            if ('x' == charAt || 'X' == charAt) {
                i2 += 2;
            } else {
                i2 = i5;
                i4 = 8;
            }
        } else if ('#' == obj.charAt(i2)) {
            i2++;
        } else {
            i4 = 10;
        }
        return Integer.parseInt(obj.substring(i2), i4) * i3;
    }

    public static int convertValueToUnsignedInt(String str, int i) {
        return str == null ? i : parseUnsignedIntAttribute(str);
    }

    public static int parseUnsignedIntAttribute(CharSequence charSequence) {
        String obj = charSequence.toString();
        int length = obj.length();
        int i = 0;
        int i2 = 16;
        if ('0' != obj.charAt(0)) {
            if ('#' != obj.charAt(0)) {
                i2 = 10;
                return (int) Long.parseLong(obj.substring(i), i2);
            }
            i = 1;
            return (int) Long.parseLong(obj.substring(i), i2);
        }
        if (length - 1 == 0) {
            return 0;
        }
        char charAt = obj.charAt(1);
        if ('x' == charAt || 'X' == charAt) {
            i = 2;
            return (int) Long.parseLong(obj.substring(i), i2);
        }
        i2 = 8;
        i = 1;
        return (int) Long.parseLong(obj.substring(i), i2);
    }
}
