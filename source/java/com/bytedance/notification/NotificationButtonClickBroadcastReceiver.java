package com.bytedance.notification;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.push.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationButtonClickBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            PushNotificationButtonInfo pushNotificationButtonInfo = (PushNotificationButtonInfo) intent.getParcelableExtra(Constants.NOTIFICATION_BUTTON_INFO);
            int intExtra = intent.getIntExtra("id", 0);
            String stringExtra = intent.getStringExtra(Constants.NOTIFICATION_TAG);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null && Build.VERSION.SDK_INT >= 26) {
                notificationManager.cancel(stringExtra, intExtra);
            }
            if (pushNotificationButtonInfo == null) {
                reportClick(intExtra, "null");
                return;
            }
            Logger.m268d(getClass().getSimpleName(), "onReceive() id: " + intExtra + "Toast: " + pushNotificationButtonInfo.mButtonToast);
            String str = pushNotificationButtonInfo.mButtonToast;
            if (str != null && !str.isEmpty()) {
                Toast.makeText(context, str, 1).show();
            }
            reportClick(intExtra, pushNotificationButtonInfo);
        } catch (Exception e) {
            Logger.m271e(getClass().getSimpleName(), e.getMessage());
            reportClick(0, "error");
        }
    }

    private void reportClick(int i, PushNotificationButtonInfo pushNotificationButtonInfo) {
        if (pushNotificationButtonInfo == null) {
            reportClick(i, "null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            jSONObject.put(Constants.NOTIFICATION_BUTTON_INFO, pushNotificationButtonInfo.toJsonForEventV3());
        } catch (JSONException e) {
            Logger.m271e(getClass().getSimpleName(), e.getMessage());
        }
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3(Constants.NOTIFICATION_BUTTON_CLICK, jSONObject);
    }

    private void reportClick(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            jSONObject.put(Constants.NOTIFICATION_BUTTON_INFO, str);
        } catch (JSONException e) {
            Logger.m271e(getClass().getSimpleName(), e.getMessage());
        }
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3(Constants.NOTIFICATION_BUTTON_CLICK, jSONObject);
    }
}
