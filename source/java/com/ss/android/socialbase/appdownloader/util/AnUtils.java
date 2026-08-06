package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.AppUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AnUtils {
    private static final HashMap<String, AppUtils.AppInfo> sInstalledPackage = new HashMap<>();

    public static boolean enableAmPlan(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && str.equals(optJSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE)) && checkAnConfig(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkAnConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return checkOsApiLevel(jSONObject) && checkRequirements(jSONObject.optJSONArray(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_REQUIREMENTS)) && checkSecure(jSONObject) && checkShouldOpenAH(jSONObject);
    }

    public static boolean checkOsApiLevel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_ALLOW_OS_API_RANGE);
        int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_MIN_OS_API, -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                int parseInt = Integer.parseInt(split[i2]);
                int parseInt2 = Integer.parseInt(split[i2 + 1]);
                if (i >= parseInt && i <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkSecure(JSONObject jSONObject) {
        return jSONObject == null || SecurityUtils.isSecure() || jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SECURITY_MODE) != 1;
    }

    public static boolean checkShouldOpenAH(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_DYNAMIC_MODE, 0) == 0 || !RomUtils.isVivo()) {
            return true;
        }
        return VIVOUtils.shouldInsertInstallPassword();
    }

    public static boolean checkDeviceRomMatch(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_ROM);
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        String name = RomUtils.getName();
        return !TextUtils.isEmpty(name) && optString.toLowerCase().contains(name.toLowerCase());
    }

    public static boolean checkRequirements(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_PACKAGE_NAMES);
                JSONArray optJSONArray = optJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_ALLOW);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ANTI_HIJACK_VERSION_BLOCK);
                String optString2 = optJSONObject.optString(DownloadSettingKeys.AhPlans.DeviceRequirements.KEY_ALLOW_VERSION_RANGE);
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if ("market".equals(str)) {
                        str = RomUtils.getMarketPackageName();
                    }
                    AppUtils.AppInfo packageInfo = getPackageInfo(str);
                    if (packageInfo != null && !(z = isVersionFit(optJSONArray, optJSONArray2, optString2, packageInfo))) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    private static boolean isVersionFit(JSONArray jSONArray, JSONArray jSONArray2, String str, AppUtils.AppInfo appInfo) {
        String versionName = appInfo.getVersionName();
        int versionCode = appInfo.getVersionCode();
        String str2 = versionCode + com.ss.android.deviceregister.utils.RomUtils.SEPARATOR + versionName;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i = 0; i < split.length; i += 2) {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split[i + 1]);
                    if (versionCode >= parseInt && versionCode <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (jsonArrayContain(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !jsonArrayContain(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    private static boolean jsonArrayContain(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static AppUtils.AppInfo getPackageInfo(String str) {
        HashMap<String, AppUtils.AppInfo> hashMap = sInstalledPackage;
        if (hashMap.containsKey(str)) {
            AppUtils.AppInfo appInfo = hashMap.get(str);
            if (appInfo != null) {
                return appInfo;
            }
            return null;
        }
        AppUtils.AppInfo appInfo2 = AppUtils.getAppInfo(str);
        hashMap.put(str, appInfo2);
        if (appInfo2 != null) {
            return appInfo2;
        }
        return null;
    }

    public static AppUtils.AppInfo queryPackageInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                AppUtils.AppInfo packageInfo = getPackageInfo(str);
                if (packageInfo != null) {
                    return packageInfo;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean modifyPackageName(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null && Build.VERSION.SDK_INT < 30 && (!RomUtils.aboveMiuiV12() || RomUtils.isMiuiV12())) {
            String optString = jSONObject.optString("s");
            try {
                String decrypt = DecryptUtils.decrypt(jSONObject.optString("az"), optString);
                String decrypt2 = DecryptUtils.decrypt(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(decrypt);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(decrypt2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
