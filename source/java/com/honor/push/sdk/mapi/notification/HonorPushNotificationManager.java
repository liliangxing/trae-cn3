package com.honor.push.sdk.mapi.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.bdinstall.Api;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import defpackage.a;

/* loaded from: classes6.dex */
public class HonorPushNotificationManager {
    public static HonorPushNotificationManager a = new HonorPushNotificationManager();

    public static HonorPushNotificationManager getInstance() {
        return a;
    }

    public void enableNotification(Activity activity, ResultCallback<NotificationStatus> resultCallback) {
        Bundle bundle;
        if (activity == null || resultCallback == null) {
            return;
        }
        if (((NotificationManager) activity.getSystemService("notification")).areNotificationsEnabled()) {
            resultCallback.onCallback(new NotificationStatus(10000, 0, a.SUCCESS.b));
            return;
        }
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putString(MonitorConstants.PKG_NAME, activity.getPackageName());
            bundle2.putString(Api.KEY_APP_NAME, activity.getPackageManager().getApplicationLabel(activity.getApplicationInfo()).toString());
            bundle2.putInt("uid", activity.getApplicationInfo().uid);
            bundle = activity.getContentResolver().call(Uri.parse("content://com.hihonor.android.pushagent.provider.MessageBoxProvider/"), "request_notification_permission", "", bundle2);
        } catch (Exception e) {
            Log.e("MAPI", "queryEnableShowNotification error = " + e.getMessage());
            bundle = null;
        }
        if (bundle == null) {
            resultCallback.onCallback(new NotificationStatus(10002, 8002012, a.ERROR_VERSION_NOT_SUPPORT.b));
        } else {
            resultCallback.onCallback(new NotificationStatus(bundle));
        }
    }
}
