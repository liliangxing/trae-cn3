package com.ss.android.common.app.permission;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Process;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.common.utility.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MIUIPermissionUtils {
    private static final String TAG = "MIUIPermissionUtils";

    public static boolean checkPermission(Context context, String str) {
        return checkPermissionKITKAT(context, str);
    }

    private static boolean checkPermissionKITKAT(Context context, String str) {
        String replaceFirst;
        try {
            if ("android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
                replaceFirst = "COARSE_LOCATION";
            } else {
                replaceFirst = "android.permission.ACCESS_FINE_LOCATION".equals(str) ? "FINE_LOCATION" : str.replaceFirst("android.permission.", "");
            }
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            Field field = AppOpsManager.class.getField("OP_" + replaceFirst);
            Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
            declaredMethod.setAccessible(true);
            int intValue = ((Integer) declaredMethod.invoke(appOpsManager, Integer.valueOf(field.getInt(appOpsManager)), Integer.valueOf(packageInfo.applicationInfo.uid), packageInfo.packageName)).intValue();
            return (intValue == 2 || intValue == 1 || intValue == 4) ? false : true;
        } catch (Exception e) {
            Logger.e(TAG, "权限检查出错时默认返回有权限，异常代码：" + e);
            return true;
        }
    }

    private static boolean checkPermissionDefault(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static void startPermissionManager(Activity activity) {
        boolean z;
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        String packageName = activity.getPackageName();
        if (DeviceUtils.isMiui()) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.putExtra("extra_pkgname", packageName);
            intent.putExtra("extra_package_uid", Process.myUid());
            z = true;
        } else {
            resolveDefaultDetail(intent, packageName);
            z = false;
        }
        if (safeStartActivity(intent, activity)) {
            return;
        }
        if (z) {
            resolveDefaultDetail(intent, packageName);
            if (safeStartActivity(intent, activity)) {
                return;
            }
            resolveDefaultAll(intent);
            safeStartActivity(intent, activity);
            return;
        }
        resolveDefaultAll(intent);
        safeStartActivity(intent, activity);
    }

    private static void resolveDefaultAll(Intent intent) {
        intent.setAction("android.intent.action.MAIN");
        intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
    }

    private static void resolveDefaultDetail(Intent intent, String str) {
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package://" + str));
        intent.putExtra("package", str);
        intent.setClassName("com.android.settings", "com.android.settings..applications.InstalledAppDetails");
    }

    private static boolean safeStartActivity(Intent intent, Activity activity) {
        try {
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
