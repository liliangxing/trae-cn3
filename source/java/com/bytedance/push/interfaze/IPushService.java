package com.bytedance.push.interfaze;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.bytedance.android.service.manager.alliance.SmpProcessInitCallback;
import com.bytedance.android.service.manager.permission.boot.BusinessCustomSysAlertDialogStatus;
import com.bytedance.android.service.manager.permission.boot.GoogleCustomSysAlertDialogStatus;
import com.bytedance.android.service.manager.permission.boot.ISysPermissionPageCallback;
import com.bytedance.android.service.manager.permission.boot.LottieAnimatorModel;
import com.bytedance.android.service.manager.permission.boot.PermissionBootRequestParam;
import com.bytedance.android.service.manager.permission.boot.PushPermissionBootShowResult;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.Configuration;
import com.bytedance.push.Keep;
import com.bytedance.push.PushBody;
import com.bytedance.push.configuration.AbsBDPushConfiguration;
import com.bytedance.push.event.sync.ISignalReportApi;
import com.bytedance.push.model.SwitcherStatus;
import com.bytedance.push.pull.PullScene;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPushService extends Keep {
    public static final String EVENT_NAME_CREATE_NOTIFICATION_CHANNEL_EVENT = "create_notification_channel_event";
    public static final String EVENT_NAME_PUSH_INIT_EVENT = "push_init_event";
    public static final String TAG = "BDPush";
    public static final String TAG_PUSH_CLICK = "Click";
    public static final String TAG_PUSH_MONITOR = "Monitor";
    public static final String TAG_PUSH_SHOW = "Show";
    public static final String TAG_PUSH_START = "Start";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface PushTokenCallback {
        void onTokenReceived(String str);
    }

    BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog(Context context);

    void getChildrenSwitcherStatus(Context context, OnSwitcherServerListener onSwitcherServerListener);

    void getChildrenSwitcherStatus(Context context, boolean z, OnSwitcherServerListener onSwitcherServerListener);

    PendingIntent getNotificationDeleteIntent(long j, JSONObject jSONObject);

    IPushNotificationManagerService getPushNotificationManagerService();

    ISignalReportApi getSignalReportApi();

    ISupport getSupportService();

    @Deprecated
    void initOnApplication(Configuration configuration);

    void initOnApplication(AbsBDPushConfiguration absBDPushConfiguration);

    void initOnApplicationDelay();

    boolean isPushInit();

    boolean isPushStarted();

    void notifyChildrenSwitcherChange(Context context, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener) throws IllegalArgumentException;

    void notifyChildrenSwitcherChange(Context context, boolean z, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener) throws IllegalArgumentException;

    void notifyInAppSwitchChange(Context context, boolean z);

    void onActivityResult(int i, int i2, Intent intent);

    void onAttachBaseContext(Application application);

    void onHostNotificationPermissionDialogClickResult(String str, boolean z, String str2);

    void onHostNotificationPermissionDialogRequestResult(String str, boolean z, String str2);

    void onNotificationDelete(long j);

    void onNotificationDelete(long j, JSONObject jSONObject);

    void onSmpProcessStart(Context context, Object obj, String str, SmpProcessInitCallback smpProcessInitCallback);

    boolean openSysPushSettingsPage(String str, Activity activity, ISysPermissionPageCallback iSysPermissionPageCallback);

    boolean openSysPushSettingsPage(String str, Activity activity, LottieAnimatorModel lottieAnimatorModel, ISysPermissionPageCallback iSysPermissionPageCallback);

    GoogleCustomSysAlertDialogStatus preCheckGoogleCustomSysAlertDialogStatus(Context context);

    void requestAndShowContent(String str);

    @Deprecated
    void requestHwNotificationPermission(String str, RequestResultCallback requestResultCallback);

    boolean requestMiRemoveVoipNotification(Context context);

    boolean requestNotificationPermission();

    boolean requestNotificationPermission(IRequestNotificationPermissionCallback iRequestNotificationPermissionCallback);

    void requestNotificationPermissionByBusinessAlert(String str, View view, boolean z, RequestResultCallback requestResultCallback);

    void requestNotificationPermissionByBusinessAlert(String str, RequestResultCallback requestResultCallback);

    void requestNotificationPermissionByGoogleAlert(String str, View view, boolean z, boolean z2, boolean z3, RequestResultCallback requestResultCallback);

    boolean requestOpNotificationPermission();

    void resetPushChannels();

    void setBadgeNumberToPushSdk(Context context, int i, PullScene pullScene);

    void setPushTokenListener(PushTokenCallback pushTokenCallback, PushType pushType);

    boolean shouldOpenSysPushSettingsByPushSdk(Context context);

    boolean showNotification(Context context, Intent intent, NotificationBody notificationBody);

    void start(String str, String str2, String str3);

    void start(String str, String str2, String str3, String str4);

    void start(Map<String, String> map, boolean z);

    void start(Map<String, String> map, boolean z, boolean z2);

    void startNonMainProcess();

    void synNotifySwitchStatus(Context context);

    boolean syncEventToPushServer(List<String> list, Map<String, String> map);

    @Deprecated
    void trackClickPush(Context context, long j, String str, String str2, boolean z, JSONObject jSONObject);

    @Deprecated
    void trackClickPush(Context context, Intent intent, String str, JSONObject jSONObject);

    void trackClickPush(Context context, PushBody pushBody, boolean z, JSONObject jSONObject);

    PushPermissionBootShowResult tryShowPushPermissionBoot(PermissionBootRequestParam permissionBootRequestParam);

    void trySupplyIntentData(Intent intent);

    void updateSettings(Context context, JSONObject jSONObject);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum PushType {
        OPPO(10);

        private final int type;

        PushType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }
}
