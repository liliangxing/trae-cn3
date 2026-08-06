package com.bytedance.ies.utility;

import android.os.Build;
import com.bytedance.common.utility.StringUtils;
import java.io.Closeable;
import java.lang.reflect.Method;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class MiscUtils {
    private static Boolean isEmui;

    public static boolean nullEquals(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }

    public static int[] extractIntArrayFromJsonStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return extractIntArrayFromJsonArray(new JSONArray(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int[] extractIntArrayFromJsonArray(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                int length = jSONArray.length();
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = jSONArray.getInt(i);
                }
                return iArr;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static long[] extractLongArray(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            try {
                int length = jSONArray.length();
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = jSONArray.getLong(i);
                }
                return jArr;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static long parseLong(String str, long j) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return Long.parseLong(str);
                }
            } catch (Exception unused) {
            }
        }
        return j;
    }

    public static int parseInt(String str, int i) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    return Integer.parseInt(str);
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public static boolean isEmui() {
        Boolean bool = isEmui;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, "ro.build.version.emui");
            if ((invoke instanceof String) && !StringUtils.isEmpty((String) invoke)) {
                if (!"unknown".equals((String) invoke)) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        isEmui = Boolean.valueOf(z);
        return z;
    }
}
