package com.bytedance.android.live.core.setting.v2.helper;

import androidx.collection.SieveCacheKt;
import com.bytedance.android.live.core.setting.LiveSettingOldContext;
import com.bytedance.ies.bullet.service.router.RouterConstants;

/* loaded from: classes2.dex */
public class ConvertHelper {
    private static final String TAG = "ConvertHelper";

    public static boolean convertBoolean(Object obj, boolean z) {
        if (obj != null) {
            Boolean bool = toBoolean(obj);
            if (bool != null) {
                return bool.booleanValue();
            }
            Integer integer = toInteger(obj);
            if (integer != null) {
                return integer.intValue() != 0;
            }
        }
        return z;
    }

    public static double safeConvertDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            LiveSettingOldContext.e(TAG, e);
            return d;
        }
    }

    public static int safeConvertInt(long j, int i) {
        if (j <= SieveCacheKt.NodeLinkMask && j >= SieveCacheKt.NodeMetaAndPreviousMask) {
            try {
                return Integer.parseInt(String.valueOf(j));
            } catch (Exception e) {
                LiveSettingOldContext.e(TAG, e);
            }
        }
        return i;
    }

    public static float safeConvertFloat(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            LiveSettingOldContext.e(TAG, e);
            return f;
        }
    }

    private static Boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (RouterConstants.TRUE.equalsIgnoreCase(str)) {
            return true;
        }
        return "false".equalsIgnoreCase(str) ? false : null;
    }

    private static Integer toInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf((int) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
