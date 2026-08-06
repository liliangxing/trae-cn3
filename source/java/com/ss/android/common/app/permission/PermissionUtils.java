package com.ss.android.common.app.permission;

import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.DeviceUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttm.player.C;

/* loaded from: classes7.dex */
public class PermissionUtils {
    private static final String TAG = "PermissionUtils";

    public static boolean checkPopupWindowPermission(Context context) {
        return checkOp(context, 24);
    }

    private static boolean checkOp(Context context, int i) {
        try {
            return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v9, types: [boolean] */
    public static boolean tryStartSysPermissionActivity(Context context) {
        if (DeviceUtils.isOppo()) {
            return startPermissionActivity(context, "com.coloros.safecenter", "com.coloros.privacypermissionsentry.PermissionTopActivity");
        }
        if (DeviceUtils.isVivo()) {
            return startPermissionActivity(context, "com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.PurviewTabActivity");
        }
        if (DeviceUtils.isMiui()) {
            if (DeviceUtils.isMiuiV6() || DeviceUtils.isMiuiV7()) {
                return startPermissionActivity(context, "com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity", "miui.intent.action.APP_PERM_EDITOR");
            }
            if (DeviceUtils.isMiuiV8() || DeviceUtils.isMiuiV9()) {
                return startPermissionActivity(context, "com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity", "miui.intent.action.APP_PERM_EDITOR");
            }
        } else if (DeviceUtils.isEmui()) {
            try {
                if (DeviceUtils.getEmuiVersion() == 3.1d) {
                    context = startPermissionActivity(context, "com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
                } else {
                    context = startPermissionActivity(context, "com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
                }
                return context;
            } catch (ActivityNotFoundException unused) {
                return startPermissionActivity(context, "com.Android.settings", "com.android.settings.permission.TabItem");
            } catch (SecurityException unused2) {
                return startPermissionActivity(context, "com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            } catch (Exception e) {
                Log.e(TAG, "Open PermissionActivity Failed : " + e);
            }
        } else {
            if (DeviceUtils.isFlyme()) {
                return startPermissionActivity(context, "com.meizu.safe", "com.meizu.safe.security.AppSecActivity", "com.meizu.safe.security.SHOW_APPSEC");
            }
            if (DeviceUtils.isQiku()) {
                return startPermissionActivity(context, "com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
            }
            if (DeviceUtils.isSmartisan()) {
                return startPermissionActivity(context, "com.smartisanos.security", "com.smartisanos.security.PermissionsActivity");
            }
        }
        return false;
    }

    public static boolean startPermissionActivity(Context context, String str, String str2) {
        return startPermissionActivity(context, str, str2, "");
    }

    public static boolean startPermissionActivity(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Intent intent = TextUtils.isEmpty(str3) ? new Intent() : new Intent(str3);
        intent.setClassName(str, str2);
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        intent.putExtra(DBDefinition.PACKAGE_NAME, context.getPackageName());
        intent.putExtra("package", context.getPackageName());
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (isIntentAvailable(intent, context)) {
            context.startActivity(intent);
            return true;
        }
        Log.e(TAG, "Intent is not available!");
        return false;
    }

    public static boolean isIntentAvailable(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
