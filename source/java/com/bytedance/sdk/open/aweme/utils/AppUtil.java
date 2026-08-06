package com.bytedance.sdk.open.aweme.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;

/* loaded from: classes5.dex */
public class AppUtil {
    private static final String TAG = "AppUtil";

    public static String buildComponentClassName(String str, String str2) {
        return str + LibrarianImpl.Constants.DOT + str2;
    }

    public static int getPlatformSDKVersion(Context context, String str, String str2) {
        if (context == null) {
            LogUtils.w(TAG, "getPlatformSDKVersion: context is null");
            return -1;
        }
        if (TextUtils.isEmpty(str)) {
            LogUtils.w(TAG, "getPlatformSDKVersion: platformPackageName is " + str);
            return -1;
        }
        if (!isAppInstalled(context, str)) {
            LogUtils.w(TAG, "getPlatformSDKVersion: app has not installed " + str);
            return -1;
        }
        try {
            ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(str, str2), 128);
            if (activityInfo == null) {
                LogUtils.w(TAG, "getPlatformSDKVersion: appInfo is null");
            } else {
                Bundle bundle = activityInfo.metaData;
                if (bundle != null) {
                    return bundle.getInt("BD_PLATFORM_SDK_VERSION", -1);
                }
                LogUtils.w(TAG, "getPlatformSDKVersion: appInfo.metaData is null");
            }
        } catch (PackageManager.NameNotFoundException e) {
            LogUtils.w(TAG, "getPlatformSDKVersion: fail to getActivityInfo", e);
        }
        return -1;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null) {
            LogUtils.w(TAG, "isAppInstalled: context is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            LogUtils.w(TAG, "isAppInstalled: platformPackageName is " + str);
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                    return true;
                }
                LogUtils.w(TAG, "isAppInstalled: packageInfo is null");
            } catch (Exception e) {
                LogUtils.w(TAG, "isAppInstalled: fail to getPackageInfo", e);
            }
        }
        return false;
    }

    public static boolean isAppSupportAPI(Context context, String str, String str2, int i) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !isAppInstalled(context, str)) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(context.getPackageManager(), 65536);
        return resolveActivityInfo != null && resolveActivityInfo.exported && getPlatformSDKVersion(context, str, str2) >= i;
    }
}
