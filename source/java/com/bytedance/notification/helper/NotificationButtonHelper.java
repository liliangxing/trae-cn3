package com.bytedance.notification.helper;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import android.os.Parcelable;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.notification.Constants;
import com.bytedance.notification.NotificationButtonClickBroadcastReceiver;
import com.bytedance.notification.utils.RichTextUtils;
import com.bytedance.push.notification.PassThoughActivity;
import com.bytedance.push.notification.PushActivity;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationButtonHelper {
    private static String TAG = "NotificationButtonHelper";

    public static Notification.Builder setNotificationButton(Notification.Builder builder, NotificationBody notificationBody, PushNotificationButtonInfo pushNotificationButtonInfo, int i, String str) {
        PendingIntent activity;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Logger.m271e(TAG, "Don't call time-consuming methods on the main thread.");
            return builder;
        }
        if (i == 0) {
            Logger.m271e(TAG, "Notification id is empty");
            return builder;
        }
        if (pushNotificationButtonInfo == null) {
            Logger.m271e(TAG, "PushNotificationButtonInfo is null");
            return builder;
        }
        Application app = AppProvider.getApp();
        Logger.m268d(TAG, "buttonInfo open_url: " + pushNotificationButtonInfo.mButtonOpenUrl + "\n notificationBody open_url: " + notificationBody.openUrl);
        if (pushNotificationButtonInfo.mButtonAction.equals(Constants.NOTIFICATION_OPEN_APP) && pushNotificationButtonInfo.mButtonOpenUrl.isEmpty()) {
            pushNotificationButtonInfo.mButtonOpenUrl = notificationBody.openUrl;
        }
        if (pushNotificationButtonInfo.mButtonOpenUrl.isEmpty()) {
            Logger.m268d(TAG, "To NotificationButtonClickBroadcastReceiver");
            Intent intent = new Intent(app, (Class<?>) NotificationButtonClickBroadcastReceiver.class);
            intent.putExtra("id", i);
            intent.putExtra(Constants.NOTIFICATION_TAG, str);
            intent.putExtra(Constants.NOTIFICATION_BUTTON_INFO, (Parcelable) pushNotificationButtonInfo);
            activity = PendingIntent.getBroadcast(app, (int) (System.currentTimeMillis() % 2147483647L), intent, 201326592);
        } else {
            Logger.m268d(TAG, "To PushActivity");
            Intent intent2 = new Intent(app, (Class<?>) (((PushOnlineSettings) SettingsManager.obtain(app.getApplicationContext(), PushOnlineSettings.class)).passThoughUseNewActivity() ? PassThoughActivity.class : PushActivity.class));
            intent2.addFlags(268435456);
            if (notificationBody.msgData != null) {
                intent2.putExtra("push_body", notificationBody.msgData.toString());
            }
            intent2.putExtra("id", i);
            intent2.putExtra(Constants.NOTIFICATION_TAG, str);
            intent2.putExtra("from_notification", true);
            intent2.putExtra(Constants.NOTIFICATION_BUTTON_INFO, (Parcelable) pushNotificationButtonInfo);
            activity = PendingIntent.getActivity(app, (int) (System.currentTimeMillis() % 2147483647L), intent2, 201326592);
        }
        builder.addAction(0, RichTextUtils.getRichTextFromRawText(pushNotificationButtonInfo.mButtonRawText), activity);
        return builder;
    }
}
