package com.honor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.third.BasePushAdapter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.hihonor.push.sdk.HonorPushClient;
import com.honor.push.sdk.mapi.notification.HonorPushNotificationManager;
import com.honor.push.sdk.mapi.notification.NotificationStatus;
import com.honor.push.sdk.mapi.notification.ResultCallback;
import com.honor.runable.GetTokenAndUploadRunnable;
import com.honor.runable.HonorUnRegisterRunnable;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HonorPushAdapter extends BasePushAdapter implements IPushAdapter {
    private static int HONOR_PUSH = -1;
    private static final String TAG = "HonorPush";
    private boolean hasShowing = false;

    public int getPushType() {
        return 22;
    }

    public boolean requestRemoveVoipNotification(Context context, int i) {
        return false;
    }

    public void setAlias(Context context, String str, int i) {
    }

    public void trackPush(Context context, int i, Object obj) {
    }

    public static int getHonorPush() {
        if (HONOR_PUSH == -1) {
            HONOR_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(HonorPushAdapter.class.getName());
        }
        return HONOR_PUSH;
    }

    public boolean isPushAvailable(Context context, int i) {
        try {
            return HonorPushClient.getInstance().checkSupportHonorPush(context);
        } catch (Throwable th) {
            Logger.e("HonorPushAdapter", "[isPushAvailable]exception ", th);
            return false;
        }
    }

    public void registerPush(Context context, int i) {
        HonorPushClient.getInstance().init(context, false);
        ThreadPlus.submitRunnable(new GetTokenAndUploadRunnable(context));
    }

    public void unregisterPush(Context context, int i) {
        ThreadPlus.submitRunnable(new HonorUnRegisterRunnable(context));
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        return ManifestChecker.checkManifest(str, context);
    }

    public boolean requestNotificationPermission(final String str, final int i, int i2, final RequestResultCallback requestResultCallback) {
        PushSupporter.logger().d("HonorPush", "[requestNotificationPermission]");
        if (i != getHonorPush()) {
            Logger.e("HonorPush", "invalid push_type:" + i);
            onGuideRequestResult(str, i, "honor", false, "invalid push_type:" + i, requestResultCallback);
            return false;
        }
        final Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
        if (topActivity == null) {
            Logger.e("HonorPush", "can't requestNotificationPermission on op device because topActivity is null");
            onGuideRequestResult(str, i, "honor", false, "topActivity is null,app is not in the foreground!", requestResultCallback);
            return false;
        }
        if (this.hasShowing) {
            Logger.e("HonorPush", "can't requestNotificationPermission because cur has showing");
            return false;
        }
        this.hasShowing = true;
        this.hasCallbackShowResult = false;
        this.hasCallbackClickResult = false;
        HonorPushNotificationManager.getInstance().enableNotification(topActivity, new ResultCallback<NotificationStatus>() { // from class: com.honor.HonorPushAdapter.1
            @Override // com.honor.push.sdk.mapi.notification.ResultCallback
            public void onCallback(NotificationStatus notificationStatus) {
                HonorPushAdapter.this.hasShowing = false;
                int statusCode = notificationStatus.getStatusCode();
                if (statusCode == 10000) {
                    Logger.i("HonorPush", "[requestNotificationPermission]statusCode is SUCCESS_CODE");
                    HonorPushAdapter.this.onGuideRequestResult(str, i, "honor", false, "notification is open status", requestResultCallback);
                    return;
                }
                if (statusCode == 10001) {
                    Logger.i("HonorPush", "[requestNotificationPermission]statusCode is RESOLUTION_REQUIRED_CODE");
                    try {
                        HonorPushAdapter.this.mRequestResultCallback = requestResultCallback;
                        HonorPushAdapter.this.mCurScenes = str;
                        notificationStatus.startResolutionForResult(topActivity, 61520);
                        HonorPushAdapter.this.onGuideRequestResult(str, i, "honor", true, "success", requestResultCallback);
                        return;
                    } catch (Throwable th) {
                        Logger.e("HonorPush", "[requestNotificationPermission]exception:" + th.getLocalizedMessage());
                        HonorPushAdapter.this.onGuideRequestResult(str, i, "honor", false, "error when startResolutionForResult:" + th.getLocalizedMessage(), requestResultCallback);
                        return;
                    }
                }
                Logger.e("HonorPush", "[requestNotificationPermission]invalid statusCode:" + statusCode + " errCode:" + notificationStatus.getErrCode() + " errMsg:" + notificationStatus.getErrMsg());
                HonorPushAdapter.this.onGuideRequestResult(str, i, "honor", false, "invalid statusCode:" + statusCode + " errMsg:" + notificationStatus.getErrMsg(), requestResultCallback);
            }
        });
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 61520) {
            Logger.i("HonorPush", "on request honor notification permission result,resultCode is " + i2);
            onUserClickResult(i2 == 10000, i, this.mRequestResultCallback);
        }
    }

    public String isBusinessAlertDialogAvailable(Context context, boolean z) {
        if (!isPushAvailable(context, HONOR_PUSH)) {
            Logger.i("HonorPush", "[isBusinessAlertDialogAvailable]return false because push is not available");
            return "push is not available";
        }
        if (!PushSetting.getInstance().getPushOnLineSettings().enableHonorBusinessNotificationDialog()) {
            Logger.i("HonorPush", "[isBusinessAlertDialogAvailable]return false because enableHonorBusinessNotificationDialog is false");
            return "enableHonorBusinessNotificationDialog is false";
        }
        Logger.i("HonorPush", "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    private void onUserClickResult(final boolean z, final int i, final RequestResultCallback requestResultCallback) {
        Logger.i("HonorPush", "[onUserClickResult]on request hw notification permission result,report click event,hasAgree:" + z);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.honor.HonorPushAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.i("HonorPush", "[onUserClickResultInternal]hasCallbackClickResult:" + HonorPushAdapter.this.hasCallbackClickResult);
                if (HonorPushAdapter.this.hasCallbackClickResult) {
                    return;
                }
                HonorPushAdapter.this.hasCallbackClickResult = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result_code", i);
                    PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(HonorPushAdapter.this.mCurScenes, "honor", HonorPushAdapter.getHonorPush(), 0, z, "", ToolUtils.areNotificationsEnabled(AppProvider.getApp()), jSONObject);
                    RequestResultCallback requestResultCallback2 = requestResultCallback;
                    if (requestResultCallback2 != null) {
                        if (z) {
                            requestResultCallback2.onUserAgree(true);
                        } else {
                            requestResultCallback2.onUserReject();
                        }
                    }
                } catch (Throwable th) {
                    Logger.e("HonorPush", "onUserClickResult error ", th);
                }
            }
        });
    }
}
