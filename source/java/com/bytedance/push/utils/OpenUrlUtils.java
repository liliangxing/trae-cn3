package com.bytedance.push.utils;

import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.notification.Constants;
import com.bytedance.push.PushBody;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class OpenUrlUtils {
    private static String TAG = "OpenUrlUtils";

    public static String getOpenUrl(PushNotificationButtonInfo pushNotificationButtonInfo, String str) {
        if (pushNotificationButtonInfo == null) {
            Logger.m268d(TAG, "buttonInfo is null");
            return getOpenUrl(str);
        }
        if (!pushNotificationButtonInfo.mButtonOpenUrl.isEmpty()) {
            Logger.m268d(TAG, "buttonInfo.open_url is not empty");
            return pushNotificationButtonInfo.mButtonOpenUrl;
        }
        if (pushNotificationButtonInfo.mButtonAction.equals(Constants.NOTIFICATION_OPEN_APP)) {
            Logger.m268d(TAG, "buttonInfo.action is open_app");
            return getOpenUrl(str);
        }
        Logger.m268d(TAG, "buttonInfo.open_url is empty, so open_url is empty");
        return pushNotificationButtonInfo.mButtonOpenUrl;
    }

    public static String getOpenUrl(String str) {
        try {
            return new PushBody(new JSONObject(str)).open_url;
        } catch (Exception e) {
            Logger.m271e(TAG, e.getMessage());
            return "";
        }
    }
}
