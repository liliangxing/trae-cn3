package com.lynx.canvas;

import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.lynx.tasm.service.ILynxTrailService;
import com.lynx.tasm.service.LynxServiceCenter;

/* loaded from: classes6.dex */
public final class LynxSettingsUtils {
    private static final String TAG = "LynxSettingsUtils";

    public static boolean booleanValueForKey(String str, boolean z) {
        Object objectValueForKey = objectValueForKey(str, null);
        if (objectValueForKey == null) {
            return z;
        }
        if (objectValueForKey instanceof Boolean) {
            return ((Boolean) objectValueForKey).booleanValue();
        }
        if (objectValueForKey instanceof Number) {
            return ((Number) objectValueForKey).doubleValue() != 0.0d;
        }
        if (objectValueForKey instanceof String) {
            String str2 = (String) objectValueForKey;
            if (str2.equalsIgnoreCase(RouterConstants.TRUE) || str2.equals("1")) {
                return true;
            }
            if (str2.equalsIgnoreCase("false") || str2.equals("0")) {
                return false;
            }
        }
        return z;
    }

    public static int integerValueForKey(String str, int i) {
        Object objectValueForKey = objectValueForKey(str, null);
        if (objectValueForKey == null) {
            return i;
        }
        if (objectValueForKey instanceof Number) {
            return ((Number) objectValueForKey).intValue();
        }
        if (objectValueForKey instanceof Boolean) {
            return ((Boolean) objectValueForKey).booleanValue() ? 1 : 0;
        }
        if (objectValueForKey instanceof String) {
            try {
                return Integer.parseInt((String) objectValueForKey);
            } catch (NumberFormatException e) {
                KryptonLLog.w(TAG, e.toString());
            }
        }
        return i;
    }

    public static double doubleValueForKey(String str, double d) {
        Object objectValueForKey = objectValueForKey(str, null);
        if (objectValueForKey == null) {
            return d;
        }
        if (objectValueForKey instanceof Number) {
            return ((Number) objectValueForKey).doubleValue();
        }
        if (objectValueForKey instanceof Boolean) {
            return ((Boolean) objectValueForKey).booleanValue() ? 1.0d : 0.0d;
        }
        if (objectValueForKey instanceof String) {
            try {
                return Double.parseDouble((String) objectValueForKey);
            } catch (NumberFormatException e) {
                KryptonLLog.w(TAG, e.toString());
            }
        }
        return d;
    }

    public static String stringValueForKey(String str, String str2) {
        Object objectValueForKey = objectValueForKey(str, null);
        return (objectValueForKey == null || !(objectValueForKey instanceof String)) ? str2 : (String) objectValueForKey;
    }

    public static Object objectValueForKey(String str, Object obj) {
        Object objectValueForTrailKey;
        ILynxTrailService iLynxTrailService = (ILynxTrailService) LynxServiceCenter.inst().getService(ILynxTrailService.class);
        return (iLynxTrailService == null || (objectValueForTrailKey = iLynxTrailService.objectValueForTrailKey(str)) == null) ? obj : objectValueForTrailKey;
    }
}
