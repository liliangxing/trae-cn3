package com.lynx.animax.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.service.IAnimaXSettingService;
import com.lynx.animax.setting.AnimaXSettingValue;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DeviceUtil {
    private static final String TAG = "DeviceUtil";
    private static final String sDeviceType;
    private static int sEglVersion = 0;
    private static boolean sHasInitAppBit = false;
    private static boolean sHasInitLowDensity = false;
    private static boolean sIs32BitApp = false;
    private static boolean sIsLowDensity = false;
    private static final String sSettingBlockListName = "ANIMAX_MODEL_BLOCK_LIST_ANDROID";
    private static final String sSettingDisableShowEventLogbox = "ANIMAX_DISABLE_SHOW_EVENT_LOGBOX";
    private static final String sSettingLegacyFetcher = "ANIMAX_USE_LEGACY_FETCHER";
    private static final String sSettingSkipCountDownEvent = "ANIMAX_SKIP_COUNT_DOWN_EVENT";
    private static final String sSettingSoftwareListName = "ANIMAX_MODEL_SOFTWARE_LIST_ANDROID";
    private static final String sSettingSyncSurfaceDestroyName = "ANIMAX_SYNC_SURFACE_DESTROY";
    private static final String sSettingUseImageViewPrefix = "ANIMAX_USE_IMAGE_VIEW_";
    private static final String sSettingVideoSurfaceDestroyTimeout = "ANIMAX_VIDEO_SURFACE_DESTROY_TIMEOUT";
    private static final boolean sTextureDestroyWorkaround;
    private static final String sUpdateTextureWhenVisible = "ANIMAX_UPDATE_TEXTURE_WHEN_VISIBLE";

    public static boolean needAutoDestroyEGLContext() {
        return false;
    }

    static {
        String lowerCase = Build.MODEL.toLowerCase();
        sDeviceType = lowerCase;
        sEglVersion = -1;
        sTextureDestroyWorkaround = Arrays.asList("m6 note", "m721c").contains(lowerCase);
        sHasInitAppBit = false;
        sIs32BitApp = false;
        sHasInitLowDensity = false;
        sIsLowDensity = false;
    }

    public static boolean updateTextureWhenVisible(BaseAbility baseAbility) {
        return isPositiveConfigValue(getStringFromExternalEnv(sUpdateTextureWhenVisible, baseAbility));
    }

    public static boolean useSoftwareRender(Context context, BaseAbility baseAbility) {
        return !supportHardwareRender(context) || isInSettingList(sSettingSoftwareListName, baseAbility);
    }

    private static boolean isInSettingList(String str, BaseAbility baseAbility) {
        AnimaXSettingValue valueByKey;
        String str2;
        IAnimaXSettingService iAnimaXSettingService = (IAnimaXSettingService) baseAbility.getService(IAnimaXSettingService.class);
        if (iAnimaXSettingService == null) {
            return false;
        }
        try {
            valueByKey = iAnimaXSettingService.getValueByKey(str);
        } catch (Throwable th) {
            AnimaXLog.m2540e(TAG, "isInSettingList fail, message" + th.getMessage());
        }
        if (valueByKey == null) {
            return false;
        }
        if (valueByKey.isString()) {
            return isPositiveConfigValue(valueByKey.getStringOrEmpty());
        }
        if (valueByKey.isCollection()) {
            Collection<String> collectionOrEmpty = valueByKey.getCollectionOrEmpty();
            return (collectionOrEmpty.isEmpty() || (str2 = sDeviceType) == null || str2.isEmpty() || !collectionOrEmpty.contains(str2)) ? false : true;
        }
        return false;
    }

    private static boolean supportHardwareRender(Context context) {
        if (sEglVersion < 0) {
            try {
                sEglVersion = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion;
            } catch (Throwable th) {
                AnimaXLog.m2540e(TAG, "isES3Supported fail, message" + th.getMessage());
            }
        }
        return sEglVersion >= 196608;
    }

    public static boolean checkCapability(BaseAbility baseAbility) {
        return !isInSettingList(sSettingBlockListName, baseAbility);
    }

    public static boolean needTextureDestroyWorkaround() {
        return sTextureDestroyWorkaround;
    }

    public static boolean needAlphaWorkaround() {
        return Build.VERSION.SDK_INT <= 28;
    }

    private static boolean is64BitProcess() {
        try {
            return Process.is64Bit();
        } catch (Exception unused) {
            return true;
        }
    }

    private static boolean is32BitApp() {
        if (!sHasInitAppBit) {
            sIs32BitApp = !is64BitProcess();
            sHasInitAppBit = true;
        }
        return sIs32BitApp;
    }

    public static boolean needLimitFrameRate() {
        return Build.VERSION.SDK_INT < 26 || is32BitApp();
    }

    public static void initDeviceLowDensity(float f) {
        if (sHasInitLowDensity) {
            return;
        }
        sIsLowDensity = f < 2.0f && f > 0.01f;
        sHasInitLowDensity = true;
    }

    public static boolean needSampleImage(int i, int i2) {
        if (i < 32 || i2 < 32) {
            return false;
        }
        return is32BitApp() || sIsLowDensity;
    }

    public static long getVideoSurfaceDestroyTimeout(BaseAbility baseAbility) {
        String stringFromExternalEnv = getStringFromExternalEnv(sSettingVideoSurfaceDestroyTimeout, baseAbility);
        try {
            if (TextUtils.isEmpty(stringFromExternalEnv)) {
                return 0L;
            }
            return Long.parseLong(stringFromExternalEnv);
        } catch (NumberFormatException e) {
            AnimaXLog.m2540e(TAG, "getVideoSurfaceDestroyTimeout fail, message" + e.getMessage());
            return 0L;
        }
    }

    public static boolean useLegacyFetcher(BaseAbility baseAbility) {
        return isPositiveConfigValue(getStringFromExternalEnv(sSettingLegacyFetcher, baseAbility));
    }

    public static boolean needSkipCountDownEvent(BaseAbility baseAbility) {
        return isPositiveConfigValue(getStringFromExternalEnv(sSettingSkipCountDownEvent, baseAbility));
    }

    public static boolean disableShowEventLogbox(BaseAbility baseAbility) {
        return isPositiveConfigValue(getStringFromExternalEnv(sSettingDisableShowEventLogbox, baseAbility));
    }

    public static boolean shouldUseImageViewByTag(BaseAbility baseAbility, String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return isPositiveConfigValue(getStringFromExternalEnv(sSettingUseImageViewPrefix + str, baseAbility));
    }

    private static String getStringFromExternalEnv(String str, BaseAbility baseAbility) {
        AnimaXSettingValue valueByKey;
        IAnimaXSettingService iAnimaXSettingService = (IAnimaXSettingService) baseAbility.getService(IAnimaXSettingService.class);
        return (iAnimaXSettingService == null || (valueByKey = iAnimaXSettingService.getValueByKey(str)) == null) ? "" : valueByKey.getStringOrEmpty();
    }

    public static boolean needScreenLockWorkaround() {
        return Build.VERSION.SDK_INT <= 29;
    }

    private static boolean isPositiveConfigValue(String str) {
        return (str == null || str.isEmpty() || (!"1".equals(str) && !"true".equalsIgnoreCase(str))) ? false : true;
    }
}
