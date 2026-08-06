package com.p032hw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.third.BasePushAdapter;
import com.bytedance.push.third.IPushAdapter;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.webx.addr.AddressParam;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.GetTokenAndUploadRunnable;
import com.huawei.HMSUtils;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.push.HmsProfile;
import com.huawei.hms.push.plugin.notification.HmsNotificationManagerEx;
import com.huawei.hms.push.plugin.notification.NotificationStatus;
import com.huawei.hms.utils.Util;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HWPushAdapter extends BasePushAdapter implements IPushAdapter {
    private static int HW_PUSH = -1;
    public static final String TAG = "HWPush";
    private boolean hasShown = false;
    private int dialogRequestPushType = -1;
    private volatile boolean appStatusHasChanged = false;

    public int getPushType() {
        return 7;
    }

    public boolean requestRemoveVoipNotification(Context context, int i) {
        return false;
    }

    public void trackPush(Context context, int i, Object obj) {
    }

    public static int getHwPush() {
        if (HW_PUSH == -1) {
            HW_PUSH = PushChannelHelper.inst(AppProvider.getApp()).getChannelId(HWPushAdapter.class.getName());
        }
        return HW_PUSH;
    }

    public boolean isPushAvailable(final Context context, int i) {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.hw.HWPushAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                LocalSettings localSettings = (LocalSettings) SettingsManager.obtain(context, LocalSettings.class);
                if (localSettings.getLastHwDialogShowTime() == 0) {
                    Logger.i(HWPushAdapter.TAG, "update LastHwDialogShowTime to cur time because app first launch");
                    localSettings.setLastHwDialogShowTime(System.currentTimeMillis());
                }
            }
        });
        return HMSUtils.isHMSAvailable(context);
    }

    public void registerPush(Context context, int i) {
        if (context == null || i != getHwPush()) {
            PushSupporter.monitor().monitorRegisterSenderFailed(i, 101, AddressParam.TYPE_DISAPPROVE, context == null ? "context is null" : "register channel error");
            return;
        }
        if (PushSupporter.logger().debug()) {
            PushSupporter.logger().d(TAG, "registerHWPush");
        }
        ThreadPlus.submitRunnable(new GetTokenAndUploadRunnable(context));
    }

    public void setAlias(Context context, String str, int i) {
        if (context != null && i == getHwPush() && PushSupporter.logger().debug()) {
            PushSupporter.logger().d(TAG, "setAlias");
        }
    }

    public void unregisterPush(Context context, int i) {
        if (PushSupporter.logger().debug()) {
            PushSupporter.logger().d(TAG, "unregisterPush");
        }
        if (DeviceUtils.isEmui()) {
            try {
                if (TextUtils.isEmpty(PushSupporter.thirdService().getToken(context, i))) {
                    return;
                }
                HmsInstanceId.getInstance(context).deleteToken(Util.getAppId(context), HmsMessaging.DEFAULT_TOKEN_SCOPE);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean checkThirdPushConfig(String str, Context context) throws Exception {
        return ManifestChecker.checkManifest(str, context);
    }

    public boolean requestNotificationPermission(String str, int i, int i2, RequestResultCallback requestResultCallback) {
        Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
        if (topActivity == null) {
            Logger.e(TAG, "can't requestNotificationPermission on hw device because topActivity is null");
            onGuideRequestResult(str, i, "hms", false, "topActivity is null,app is not in the foreground!", requestResultCallback);
            return false;
        }
        if (this.hasShown) {
            Logger.e(TAG, "can't requestNotificationPermission because cur has showing");
            onGuideRequestResult(str, i, "hms", false, "cur has showing", requestResultCallback);
            return false;
        }
        this.hasShown = true;
        this.hasCallbackShowResult = false;
        this.hasCallbackClickResult = false;
        this.dialogRequestPushType = i;
        requestNotificationPermissionInternal(str, i, topActivity, requestResultCallback, i2, requestResultCallback);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.hw.HWPushAdapter$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC13162 implements Runnable {
        final /* synthetic */ int val$push_type;
        final /* synthetic */ RequestResultCallback val$requestResultCallback;
        final /* synthetic */ String val$scenes;
        final /* synthetic */ int val$sysAlertStyle;
        final /* synthetic */ Activity val$topActivity;

        RunnableC13162(Activity activity, RequestResultCallback requestResultCallback, String str, int i, int i2) {
            this.val$topActivity = activity;
            this.val$requestResultCallback = requestResultCallback;
            this.val$scenes = str;
            this.val$sysAlertStyle = i;
            this.val$push_type = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HmsNotificationManagerEx.getInstance(this.val$topActivity).enableNotification().addOnSuccessListener(new OnSuccessListener<NotificationStatus>() { // from class: com.hw.HWPushAdapter.2.2
                    @Override // com.huawei.hmf.tasks.OnSuccessListener
                    public void onSuccess(NotificationStatus notificationStatus) {
                        Logger.i(HWPushAdapter.TAG, "[huaweiPushPermissionDialog] onSuccess ,notificationStatus.getStatus: " + notificationStatus.getStatus());
                        HWPushAdapter.this.hasShown = false;
                        try {
                            Logger.i(HWPushAdapter.TAG, "enable notification status success,topActivity:" + RunnableC13162.this.val$topActivity);
                            HWPushAdapter.this.mRequestResultCallback = RunnableC13162.this.val$requestResultCallback;
                            HWPushAdapter.this.mCurScenes = RunnableC13162.this.val$scenes;
                            final int i = RunnableC13162.this.val$sysAlertStyle == 0 ? 61520 : 61521;
                            ActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.hw.HWPushAdapter.2.2.1
                                @Override // java.util.Observer
                                public void update(Observable observable, Object obj) {
                                    if (((Boolean) obj).booleanValue()) {
                                        Logger.i(HWPushAdapter.TAG, "enable notification status failed because app to background");
                                        ActivityLifecycleObserver.getIns().deleteObserver(this);
                                        HWPushAdapter.this.onUserClickResult(false, RunnableC13162.this.val$sysAlertStyle, i, RunnableC13162.this.val$requestResultCallback);
                                    }
                                }
                            });
                            notificationStatus.startResolutionForResult(RunnableC13162.this.val$topActivity, i);
                            HWPushAdapter.this.onGuideRequestResult(RunnableC13162.this.val$scenes, RunnableC13162.this.val$push_type, "hms", true, "success", RunnableC13162.this.val$sysAlertStyle, RunnableC13162.this.val$requestResultCallback);
                            ((LocalSettings) SettingsManager.obtain(AppProvider.getApp(), LocalSettings.class)).setLastHwDialogShowTime(System.currentTimeMillis());
                        } catch (Throwable th) {
                            Logger.e(HWPushAdapter.TAG, "enable notification catch exception: " + th.getMessage());
                            HWPushAdapter.this.onGuideRequestResult(RunnableC13162.this.val$scenes, RunnableC13162.this.val$push_type, "hms", false, "error when startResolutionForResult:" + th.getLocalizedMessage(), RunnableC13162.this.val$sysAlertStyle, RunnableC13162.this.val$requestResultCallback);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.hw.HWPushAdapter.2.1
                    @Override // com.huawei.hmf.tasks.OnFailureListener
                    public void onFailure(Exception exc) {
                        Logger.e(HWPushAdapter.TAG, "[huaweiPushPermissionDialog] onFailure:" + exc.getLocalizedMessage());
                        HWPushAdapter.this.hasShown = false;
                        HWPushAdapter.this.onGuideRequestResult(RunnableC13162.this.val$scenes, RunnableC13162.this.val$push_type, "hms", false, "onError:" + exc.getLocalizedMessage(), RunnableC13162.this.val$sysAlertStyle, RunnableC13162.this.val$requestResultCallback);
                    }
                });
            } catch (Throwable th) {
                Logger.e(HWPushAdapter.TAG, "[requestNotificationPermissionInternal] exception:" + th.getLocalizedMessage());
                HWPushAdapter.this.hasShown = false;
                HWPushAdapter.this.onGuideRequestResult(this.val$scenes, this.val$push_type, "hms", false, "exception:" + th.getLocalizedMessage(), this.val$sysAlertStyle, this.val$requestResultCallback);
            }
        }
    }

    private void requestNotificationPermissionInternal(String str, int i, Activity activity, RequestResultCallback requestResultCallback, int i2, RequestResultCallback requestResultCallback2) {
        PushThreadHandlerManager.inst().postRunnable(new RunnableC13162(activity, requestResultCallback, str, i2, i));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 61520 || i == 61521) {
            Logger.i(TAG, "on request hw notification permission result,resultCode is " + i2);
            onUserClickResult(i2 == -1, i == 61521 ? 1 : 0, i, this.mRequestResultCallback);
        }
    }

    public String isBusinessAlertDialogAvailable(Context context, boolean z) {
        if (!isPushAvailable(context, HW_PUSH)) {
            Logger.i(TAG, "[isBusinessAlertDialogAvailable]return false because push is not available");
            return "push is not available";
        }
        PushOnlineSettings pushOnLineSettings = PushSetting.getInstance().getPushOnLineSettings();
        if (!pushOnLineSettings.enableHmsBusinessNotificationDialog()) {
            Logger.i(TAG, "[isBusinessAlertDialogAvailable]return false because enableHmsBusinessNotificationDialog is false");
            return "enableHmsBusinessNotificationDialog is false";
        }
        if (z) {
            LocalSettings localSettings = (LocalSettings) SettingsManager.obtain(context, LocalSettings.class);
            if (localSettings.getLastHwDialogShowTime() == 0) {
                Logger.w(TAG, "[isBusinessAlertDialogAvailable]return false  because lastHwDialogShowTime is 0");
                localSettings.setLastHwDialogShowTime(System.currentTimeMillis());
                return "lastHwDialogShowTime is 0";
            }
            if (System.currentTimeMillis() - localSettings.getLastHwDialogShowTime() < pushOnLineSettings.minHmsBusinessNotificationDialogInterval()) {
                Logger.w(TAG, "[isBusinessAlertDialogAvailable]return false because frequency control");
                return "frequency control";
            }
        }
        Logger.i(TAG, "[isBusinessAlertDialogAvailable]return true");
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUserClickResult(final boolean z, final int i, int i2, final RequestResultCallback requestResultCallback) {
        Logger.i(TAG, "[onUserClickResult]on request hw notification permission result,report click event,hasAgree:" + z + " sysAlertStyle:" + i);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.hw.HWPushAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.i(HWPushAdapter.TAG, "[onUserClickResultInternal]hasCallbackClickResult:" + HWPushAdapter.this.hasCallbackClickResult);
                if (HWPushAdapter.this.hasCallbackClickResult) {
                    return;
                }
                HWPushAdapter.this.hasCallbackClickResult = true;
                try {
                    if (i == 0) {
                        PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(HWPushAdapter.this.mCurScenes, "hms", HWPushAdapter.getHwPush(), i, z, "", ToolUtils.areNotificationsEnabled(AppProvider.getApp()), (JSONObject) null);
                    }
                    RequestResultCallback requestResultCallback2 = requestResultCallback;
                    if (requestResultCallback2 != null) {
                        if (z) {
                            requestResultCallback2.onUserAgree(true);
                        } else {
                            requestResultCallback2.onUserReject();
                        }
                    }
                } catch (Throwable th) {
                    Logger.e(HWPushAdapter.TAG, "onUserClickResult error ", th);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean setProfileId(Context context, String str) {
        String localizedMessage;
        int i;
        int i2;
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            i2 = 2;
        } catch (Throwable th) {
            th = th;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                Logger.e(TAG, "error when trySetProfileId:" + th.getLocalizedMessage());
                localizedMessage = th.getLocalizedMessage();
                i = 5;
                onSetProfileIdResult(getHwPush(), currentTimeMillis, i, localizedMessage);
                if (i == 1) {
                }
            }
            if (HmsProfile.getInstance(context).isSupportProfile()) {
                Logger.i(TAG, "cur device support profile id,set profile id,profileId is " + str);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Task[] taskArr = {null};
                HmsProfile.getInstance(context).addProfile(2, str).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.hw.HWPushAdapter.4
                    @Override // com.huawei.hmf.tasks.OnCompleteListener
                    public void onComplete(Task<Void> task) {
                        Logger.i(HWPushAdapter.TAG, "onComplete add profile id,task is :" + task.isSuccessful());
                        taskArr[0] = task;
                        countDownLatch.countDown();
                    }
                });
                try {
                    countDownLatch.await(C0878a.f531q, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Task task = taskArr[0];
                Logger.i(TAG, "finished add profile id,task is :" + task);
                if (task != null) {
                    Logger.i(TAG, "finished add profile id,success:" + task.isSuccessful());
                    if (!task.isSuccessful()) {
                        Logger.i(TAG, "error msg is :" + task.getException().getLocalizedMessage());
                        str2 = task.getException().getLocalizedMessage();
                        i2 = 6;
                        i = i2;
                        localizedMessage = str2;
                        onSetProfileIdResult(getHwPush(), currentTimeMillis, i, localizedMessage);
                        return i == 1;
                    }
                    i2 = 1;
                } else {
                    i2 = 4;
                }
            } else {
                Logger.i(TAG, "cur device not support profile id set,can't set profile id");
                i2 = 3;
            }
        }
        str2 = null;
        i = i2;
        localizedMessage = str2;
        onSetProfileIdResult(getHwPush(), currentTimeMillis, i, localizedMessage);
        if (i == 1) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean deleteProfileId(Context context, String str) {
        int i;
        String localizedMessage;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            boolean isSupportProfile = HmsProfile.getInstance(context).isSupportProfile();
            PushSupporter.logger().d(TAG, "[deleteProfileId]supportProfile:" + isSupportProfile);
            String str2 = null;
            if (isSupportProfile) {
                Logger.i(TAG, "cur device support profile id,delete profile id,profileId is " + str);
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final Task[] taskArr = {null};
                try {
                    HmsProfile.getInstance(context).deleteProfile(str).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.hw.HWPushAdapter.5
                        @Override // com.huawei.hmf.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            Logger.i(HWPushAdapter.TAG, "onComplete delete profile id,task is :" + task.isSuccessful());
                            taskArr[0] = task;
                            countDownLatch.countDown();
                        }
                    });
                    try {
                        countDownLatch.await(C0878a.f531q, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Task task = taskArr[0];
                    Logger.i(TAG, "finished delete profile id,task is :" + task);
                    if (task != null) {
                        Logger.i(TAG, "finished delete profile id,success:" + task.isSuccessful());
                        if (task.isSuccessful()) {
                            i = 1;
                        } else {
                            Logger.i(TAG, "delete profile id error msg is :" + task.getException().getLocalizedMessage());
                            i = 6;
                            str2 = task.getException().getLocalizedMessage();
                        }
                    } else {
                        i = 4;
                    }
                } catch (Throwable th) {
                    th = th;
                    i = 5;
                    localizedMessage = th.getLocalizedMessage();
                    onDeleteProfileIdResult(getHwPush(), currentTimeMillis, i, localizedMessage);
                    if (i != 1) {
                    }
                }
            } else {
                i = 3;
            }
            localizedMessage = str2;
        } catch (Throwable th2) {
            th = th2;
        }
        onDeleteProfileIdResult(getHwPush(), currentTimeMillis, i, localizedMessage);
        return i != 1;
    }
}
