package com.bytedance.notification.supporter.impl;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.notification.Constants;
import com.bytedance.notification.supporter.service.INotificationClearService;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.ClearNotificationSettingsModel;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationClearServiceImpl extends BaseJson implements INotificationClearService {
    private final String TAG = "NotificationClearServiceImpl";
    private final String NOTIFICATION_ID = "nid";
    private final String PLATFORM_ID = LynxMonitorService.KEY_PID;
    private final String GROUP_KEY = "group_key";
    private final String TAG_KEY = Constants.NOTIFICATION_TAG;
    private final String NEED_CLEAR_NID_LIST = "need_clear_nid_list";
    private final String EVENT_NAME_BDPUSH_CLEAR_NOTIFICATION = "bdpush_clear_notification";
    private final String CLEAR_REASON_SERVER = "server";
    private final String CLEAR_REASON_CLIENT = "client";

    private StatusBarNotification[] getAllStatusBarNotification() {
        StatusBarNotification[] statusBarNotificationArr = new StatusBarNotification[0];
        StatusBarNotification[] activeNotifications = ((NotificationManager) AppProvider.getApp().getSystemService("notification")).getActiveNotifications();
        Logger.m268d("NotificationClearServiceImpl", "[getAllStatusBarNotification]activeNotifications size:" + activeNotifications.length);
        return activeNotifications;
    }

    private void clearItemNotification(final String str, final String str2, final int i) {
        Logger.m268d("NotificationClearServiceImpl", "[clearItemNotification]notificationId:" + i + " tag:" + str2);
        final NotificationManager notificationManager = (NotificationManager) AppProvider.getApp().getSystemService("notification");
        final JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str2)) {
            add(jSONObject, Constants.NOTIFICATION_TAG, str2);
            notificationManager.cancel(str2, i);
        } else {
            notificationManager.cancel(i);
        }
        try {
            Method declaredMethod = notificationManager.getClass().getDeclaredMethod("cancelAsPackage", String.class, String.class, Integer.TYPE);
            if (declaredMethod != null) {
                Logger.m268d("NotificationClearServiceImpl", "[clearItemNotification]invoke cancelAsPackage");
                Object[] objArr = new Object[3];
                objArr[0] = AppProvider.getApp().getPackageName();
                objArr[1] = TextUtils.isEmpty(str2) ? "" : str2;
                objArr[2] = Integer.valueOf(i);
                declaredMethod.invoke(notificationManager, objArr);
            }
        } catch (Throwable th) {
            Logger.m271e("NotificationClearServiceImpl", "[clearItemNotification]exception:" + th.getLocalizedMessage());
        }
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.notification.supporter.impl.NotificationClearServiceImpl.1
            /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
            
                r2 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
            
                if (r7.this$0.isRankerNotification(r4) == false) goto L13;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
                int length = activeNotifications.length;
                boolean z = false;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StatusBarNotification statusBarNotification = activeNotifications[i2];
                    if (statusBarNotification.getId() != i || !TextUtils.equals(statusBarNotification.getTag(), str2)) {
                        i2++;
                    }
                }
                NotificationClearServiceImpl.this.add(jSONObject, "id", i);
                NotificationClearServiceImpl.this.add(jSONObject, Constants.NOTIFICATION_TAG, str2);
                NotificationClearServiceImpl.this.add(jSONObject, "clear_reason", str);
                NotificationClearServiceImpl.this.add(jSONObject, "clear_result", z);
                PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_clear_notification", jSONObject);
            }
        }, 2000L);
    }

    @Override // com.bytedance.notification.supporter.service.INotificationClearService
    public void clearSomeNotifications() {
        Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotifications]");
        ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.notification.supporter.impl.NotificationClearServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                NotificationClearServiceImpl.this.clearSomeNotificationsInternal();
            }
        });
    }

    @Override // com.bytedance.notification.supporter.service.INotificationClearService
    public boolean isRankerNotification(StatusBarNotification statusBarNotification) {
        String tag = statusBarNotification.getTag();
        if (!TextUtils.isEmpty(tag) && tag.contains("ranker_group")) {
            return true;
        }
        Notification notification = statusBarNotification.getNotification();
        if (notification != null) {
            String group = notification.getGroup();
            if (!TextUtils.isEmpty(group) && group.contains("ranker_group")) {
                return true;
            }
        }
        Bundle bundle = statusBarNotification.getNotification().extras;
        if (bundle != null) {
            return TextUtils.equals(bundle.getString("android.title"), "GroupSummary") || TextUtils.equals(bundle.getString("android.text"), "GroupSummary");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSomeNotificationsInternal() {
        ClearNotificationSettingsModel clearNotificationConfig = ((PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class)).getClearNotificationConfig();
        boolean z = clearNotificationConfig.enableNotificationClear;
        Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]enableNotificationClear:" + z);
        if (!z) {
            Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]do nothing because enableNotificationClear is false");
            return;
        }
        StatusBarNotification[] allStatusBarNotification = getAllStatusBarNotification();
        if (allStatusBarNotification.length == 0) {
            Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]do nothing because allStatusBarNotificationList len is 0");
            return;
        }
        boolean z2 = clearNotificationConfig.clearAllNotificationAfterLaunch;
        Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]needClearNotificationAfterLaunch:" + z2);
        JSONArray jSONArray = new JSONArray();
        HashMap hashMap = new HashMap();
        for (StatusBarNotification statusBarNotification : allStatusBarNotification) {
            Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]itemNotification:" + statusBarNotificationToStr(statusBarNotification));
            statusBarNotification.getTag();
            if (isRankerNotification(statusBarNotification)) {
                Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]do nothing because cur statusBarNotification is ranker");
            } else if (z2) {
                clearItemNotification("client", statusBarNotification.getTag(), statusBarNotification.getId());
            } else {
                jSONArray.put(convertToNotificationObj(statusBarNotification));
                String tag = statusBarNotification.getTag();
                if (!TextUtils.isEmpty(tag)) {
                    hashMap.put(Integer.valueOf(statusBarNotification.getId()), tag);
                }
            }
        }
        if (z2) {
            Logger.m274i("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]clearNotificationAfterLaunch is true so not request server");
            return;
        }
        JSONArray requestNeedClearNotificationList = requestNeedClearNotificationList(jSONArray);
        if (requestNeedClearNotificationList != null) {
            for (int i = 0; i < requestNeedClearNotificationList.length(); i++) {
                try {
                    int i2 = requestNeedClearNotificationList.getInt(i);
                    clearItemNotification("server", (String) hashMap.get(Integer.valueOf(i2)), i2);
                } catch (JSONException e) {
                    Logger.m271e("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]error when parse needClearNotificationList:" + e.getLocalizedMessage());
                }
            }
        }
    }

    private JSONArray requestNeedClearNotificationList(JSONArray jSONArray) {
        Map httpCommonParams = PushCommonSupport.getInstance().getPushCommonParamService().getHttpCommonParams();
        String clearNotificationUrl = MessageConstants.getClearNotificationUrl();
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = false;
        String addUrlParam = ToolUtils.addUrlParam(clearNotificationUrl, httpCommonParams);
        try {
            ArrayList arrayList = new ArrayList();
            Logger.m268d("NotificationClearServiceImpl", "[requestNeedClearNotificationList]request failed because server return empty");
            arrayList.add(new Pair("notification_list", jSONArray.toString()));
            String post = PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext);
            if (TextUtils.isEmpty(post)) {
                Logger.m271e("NotificationClearServiceImpl", "[requestNeedClearNotificationList]request failed because server return empty");
                return null;
            }
            JSONObject jSONObject = new JSONObject(post);
            if (!TextUtils.equals("success", jSONObject.optString("message"))) {
                Logger.m271e("NotificationClearServiceImpl", "[requestNeedClearNotificationList]request failed because server response is not success");
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("need_clear_nid_list");
            Logger.m268d("NotificationClearServiceImpl", "[requestNeedClearNotificationList]request success,needClearList:" + optJSONArray);
            return optJSONArray;
        } catch (Throwable th) {
            Logger.m271e("NotificationClearServiceImpl", String.format("[requestNeedClearNotificationList]request failed,errorCode: %s errorMsg: %s", Integer.valueOf(th instanceof CommonHttpException ? th.getResponseCode() : -100), th.getMessage()));
            return null;
        }
    }

    private JSONObject convertToNotificationObj(StatusBarNotification statusBarNotification) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "nid", statusBarNotification.getId());
        add(jSONObject, "group_key", statusBarNotification.getGroupKey());
        add(jSONObject, Constants.NOTIFICATION_TAG, statusBarNotification.getTag());
        String string = statusBarNotification.getNotification().extras.getString(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID);
        if (!TextUtils.isEmpty(string)) {
            add(jSONObject, LynxMonitorService.KEY_PID, string);
        }
        String string2 = statusBarNotification.getNotification().extras.getString("msgId");
        if (!TextUtils.isEmpty(string2)) {
            add(jSONObject, LynxMonitorService.KEY_PID, string2);
        }
        long j = statusBarNotification.getNotification().extras.getLong("pushId", -1L);
        if (j != -1) {
            add(jSONObject, LynxMonitorService.KEY_PID, String.valueOf(j));
        }
        return jSONObject;
    }

    private String statusBarNotificationToStr(StatusBarNotification statusBarNotification) {
        JSONObject jSONObject = new JSONObject();
        try {
            add(jSONObject, "id", String.valueOf(statusBarNotification.getId()));
            String string = statusBarNotification.getNotification().extras.getString(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID);
            if (!TextUtils.isEmpty(string)) {
                add(jSONObject, LynxMonitorService.KEY_PID, string);
            }
            String string2 = statusBarNotification.getNotification().extras.getString("msgId");
            if (!TextUtils.isEmpty(string2)) {
                add(jSONObject, LynxMonitorService.KEY_PID, string2);
            }
            long j = statusBarNotification.getNotification().extras.getLong("pushId", -1L);
            if (j != -1) {
                add(jSONObject, LynxMonitorService.KEY_PID, String.valueOf(j));
            }
            add(jSONObject, "group_key", statusBarNotification.getNotification().getGroup());
            add(jSONObject, Constants.NOTIFICATION_TAG, statusBarNotification.getTag());
            add(jSONObject, "str", statusBarNotification.toString());
            add(jSONObject, bundleToObj(statusBarNotification.getNotification().extras));
        } catch (Throwable th) {
            Logger.m271e("NotificationClearServiceImpl", "[clearSomeNotificationsInternal]error:" + th.getLocalizedMessage());
        }
        return jSONObject.toString();
    }

    private JSONObject bundleToObj(Bundle bundle) {
        Set<String> keySet;
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            for (String str : keySet) {
                Object obj = bundle.get(str);
                if (obj instanceof Intent) {
                    add(jSONObject, str, bundleToObj(((Intent) obj).getExtras()));
                } else {
                    add(jSONObject, str, String.valueOf(obj));
                }
            }
        }
        return jSONObject;
    }
}
