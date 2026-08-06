package com.lynx.canvas;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class Settings {
    public static boolean booleanValueForKey(KryptonApp kryptonApp, String str, boolean z) {
        KryptonSettingsService settingsService = getSettingsService(kryptonApp);
        return settingsService == null ? z : settingsService.booleanValueForKey(str, z);
    }

    public static int integerValueForKey(KryptonApp kryptonApp, String str, int i) {
        KryptonSettingsService settingsService = getSettingsService(kryptonApp);
        return settingsService == null ? i : settingsService.integerValueForKey(str, i);
    }

    public static double doubleValueForKey(KryptonApp kryptonApp, String str, double d) {
        KryptonSettingsService settingsService = getSettingsService(kryptonApp);
        return settingsService == null ? d : settingsService.doubleValueForKey(str, d);
    }

    public static String stringValueForKey(KryptonApp kryptonApp, String str, String str2) {
        KryptonSettingsService settingsService = getSettingsService(kryptonApp);
        return settingsService == null ? str2 : settingsService.stringValueForKey(str, str2);
    }

    private static KryptonSettingsService getSettingsService(KryptonApp kryptonApp) {
        if (kryptonApp != null) {
            return (KryptonSettingsService) kryptonApp.getService(KryptonSettingsService.class);
        }
        return null;
    }
}
