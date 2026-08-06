package com.bytedance.trae.push.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.keva.Keva;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.trae.keva.KevaRepos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushHelper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/push/impl/PushHelper;", "", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "KEY_HAS_REQUEST_NOTIFICATION_PERMISSION", "", "KEY_PUSH_PERMISSION_REQUEST_ST", "isNotificationEnabled", "", "context", "Landroid/content/Context;", "openSysPushSettingPage", "", "hasRequestNotificationPermission", "saveRequestNotificationPermission", "hasRequestPermission", "setLastRequestNotificationPermissionTimestamp", ReportConst.KEY_TIMESTAMP, "", "getLastRequestNotificationPermissionTimestamp", "KEY_NOTIFICATION_PERMISSION_PERMANENTLY_DENIED", "isNotificationPermissionPermanentlyDenied", "setNotificationPermissionPermanentlyDenied", "denied", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PushHelper {
    private static final String KEY_HAS_REQUEST_NOTIFICATION_PERMISSION = "has_request_push_permission";
    private static final String KEY_NOTIFICATION_PERMISSION_PERMANENTLY_DENIED = "notification_permission_permanently_denied";
    private static final String KEY_PUSH_PERMISSION_REQUEST_ST = "push_permission_request_st";
    public static final PushHelper INSTANCE = new PushHelper();
    private static final Keva keva = KevaRepos.INSTANCE.getDefaultRepo();

    private PushHelper() {
    }

    public final boolean isNotificationEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void openSysPushSettingPage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            intent.addFlags(268435456);
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", context.getPackageName());
            intent.putExtra("app_uid", context.getApplicationInfo().uid);
            intent.addFlags(268435456);
        }
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            try {
                PackageManager packageManager = context.getPackageManager();
                if ((packageManager != null ? packageManager.resolveActivity(intent, 0) : null) != null) {
                    context.startActivity(intent);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public final boolean hasRequestNotificationPermission() {
        return keva.getBoolean(KEY_HAS_REQUEST_NOTIFICATION_PERMISSION, false);
    }

    public final void saveRequestNotificationPermission(boolean hasRequestPermission) {
        keva.storeBoolean(KEY_HAS_REQUEST_NOTIFICATION_PERMISSION, hasRequestPermission);
    }

    public final void setLastRequestNotificationPermissionTimestamp(long timestamp) {
        keva.storeLong(KEY_PUSH_PERMISSION_REQUEST_ST, timestamp);
    }

    public final long getLastRequestNotificationPermissionTimestamp() {
        return keva.getLong(KEY_PUSH_PERMISSION_REQUEST_ST, 0L);
    }

    public final boolean isNotificationPermissionPermanentlyDenied() {
        return keva.getBoolean(KEY_NOTIFICATION_PERMISSION_PERMANENTLY_DENIED, false);
    }

    public final void setNotificationPermissionPermanentlyDenied(boolean denied) {
        keva.storeBoolean(KEY_NOTIFICATION_PERMISSION_PERMANENTLY_DENIED, denied);
    }
}
