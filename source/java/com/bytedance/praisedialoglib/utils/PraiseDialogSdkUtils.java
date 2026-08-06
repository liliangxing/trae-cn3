package com.bytedance.praisedialoglib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes4.dex */
public class PraiseDialogSdkUtils {
    private static final String TAG = "PraiseDialogSdkUtils";
    private static final int VIVO_MARKET_VERSION = 5020;

    public static boolean isInstalledApp(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            packageInfo = null;
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Exception unused) {
                return false;
            }
        }
        return packageInfo != null && packageInfo.applicationInfo.enabled;
    }

    public static boolean isViVoMarketVersionMatch(Context context) {
        long j;
        if (context == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.bbk.appstore", 0);
            int i = packageInfo.versionCode;
            String str = packageInfo.versionName;
            Log.d(TAG, "versionCode = " + packageInfo.versionCode);
            Log.d(TAG, "versionName = " + packageInfo.versionName);
            if (Build.VERSION.SDK_INT >= 28) {
                j = packageInfo.getLongVersionCode();
                Log.d(TAG, "longVersionCode = " + packageInfo.getLongVersionCode());
            } else {
                j = 0;
            }
            return i >= VIVO_MARKET_VERSION || ((int) j) >= VIVO_MARKET_VERSION;
        } catch (Exception unused) {
            return false;
        }
    }
}
