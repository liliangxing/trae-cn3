package com.bytedance.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.bytedance.android.push.service.manager.annotation.ServiceProvider;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.AsyncImageDownloader;
import com.bytedance.android.service.manager.push.notification.IPushNotification;
import com.bytedance.android.service.manager.push.notification.IPushNotificationService;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.extra.ProxyNotificationExtra;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.model.PushNotification;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.push.utils.Logger;
import com.bytedance.rts.foundation.Int32;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;

@ServiceProvider
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushNotificationService implements IPushNotificationService {
    private final String TAG = "PushNotificationService";
    private final String NOTIFICATION_TAG = "app_notify";

    public boolean isSupportProxyNotification() {
        return true;
    }

    public void setAsyncImageDownloader(final AsyncImageDownloader asyncImageDownloader) {
        if (ToolUtils.isSmpProcess(AppProvider.getApp())) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.notification.PushNotificationService.1
                @Override // java.lang.Runnable
                public void run() {
                    PushNotificationSupporter.get().getImageDownloadService().setAsyncImageDownloader(asyncImageDownloader);
                }
            });
        } else {
            PushNotificationSupporter.get().getImageDownloadService().setAsyncImageDownloader(asyncImageDownloader);
        }
    }

    public Bitmap downloadImage(String str) {
        return PushNotificationSupporter.get().getImageDownloadService().downloadImage(str);
    }

    public void showNotification(final Context context, final Intent intent, final NotificationBody notificationBody) {
        if (context == null || intent == null || notificationBody == null) {
            return;
        }
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.notification.PushNotificationService.2
            @Override // java.lang.Runnable
            public void run() {
                if (notificationBody.imageType != 0 && notificationBody.imageBitmap == null) {
                    notificationBody.imageBitmap = PushNotificationSupporter.get().getImageDownloadService().downloadImage(notificationBody.imageUrl);
                }
                PushNotificationService.this.showNotificationInternal(context, intent, notificationBody);
            }
        });
    }

    public IPushNotification buildNotification(Context context, Intent intent, NotificationBody notificationBody, Notification notification) {
        return buildNotification(context, intent, (Notification.Builder) null, notificationBody, notification, true);
    }

    public IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody) {
        return buildNotification(context, intent, builder, notificationBody, true);
    }

    public IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z) {
        return buildNotification(context, intent, builder, notificationBody, (Notification) null, z);
    }

    public IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, Notification notification, boolean z) {
        return buildNotification(context, intent, builder, notificationBody, notification, z, 0, "");
    }

    public IPushNotification buildNotification(Context context, Intent intent, NotificationBody notificationBody, Notification notification, int i, String str) {
        return buildNotification(context, intent, null, notificationBody, notification, true, i, str);
    }

    public IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, int i, String str) {
        return buildNotification(context, intent, builder, notificationBody, true, i, str);
    }

    public IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z, int i, String str) {
        return buildNotification(context, intent, builder, notificationBody, null, z, i, str);
    }

    public IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, Notification notification, boolean z, int i, String str) {
        if (notification != null) {
            PushNotificationSupporter.get().getNotificationStyleService().addSoundAndVibrator(context, notification, notificationBody);
            return new PushNotification(context, notification, null, null, notificationBody, intent);
        }
        if (context == null || intent == null || notificationBody == null) {
            return null;
        }
        if (notificationBody.imageType != 0 && notificationBody.imageBitmap == null) {
            notificationBody.imageBitmap = PushNotificationSupporter.get().getImageDownloadService().downloadImage(notificationBody.imageUrl);
        }
        return PushNotificationSupporter.get().getNotificationStyleService().buildCustomNotification(context, intent, builder, notificationBody, z, i, str);
    }

    public PendingIntent getNotificationDeleteIntent(long j, JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        bundle.putString(NotificationDeleteBroadcastReceiver.KEY_MSG_TYPE, "notification");
        bundle.putLong(NotificationDeleteBroadcastReceiver.KEY_MSG_ID, j);
        return getNotificationDeleteIntent(j, bundle, jSONObject);
    }

    public PendingIntent getNotificationDeleteIntent(long j, Bundle bundle, JSONObject jSONObject) {
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        Intent intent = new Intent(pushCommonConfiguration.mApplication, (Class<?>) NotificationDeleteBroadcastReceiver.getDeleteBroadCastReceiverClass());
        intent.setAction(pushCommonConfiguration.mApplication.getPackageName() + NotificationDeleteBroadcastReceiver.getDeleteAction());
        if (jSONObject != null) {
            bundle.putString("extra", jSONObject.toString());
        }
        intent.putExtras(bundle);
        return PendingIntent.getBroadcast(pushCommonConfiguration.mApplication, (int) (j % 2147483647L), intent, 1140850688);
    }

    public PendingIntent getNotificationDeleteIntent(long j) {
        return getNotificationDeleteIntent(j, null);
    }

    public boolean tryShowPushNotification(Context context, Intent intent, NotificationBody notificationBody) {
        if (notificationBody == null) {
            return false;
        }
        PushNotificationExtra pushNotificationExtra = new PushNotificationExtra(notificationBody.bdPushStr);
        if (!pushNotificationExtra.mHandleBySdk) {
            return false;
        }
        ProxyNotificationExtra proxyNotificationExtra = pushNotificationExtra.mProxyNotificationExtra;
        if (proxyNotificationExtra != null) {
            if (proxyNotificationExtra.mProxyType == 1) {
                return wakeUpAndComposeMessage(proxyNotificationExtra);
            }
            if (proxyNotificationExtra.mProxyType != 2) {
                return false;
            }
        }
        if (intent == null) {
            return false;
        }
        showNotification(context, intent, notificationBody);
        return true;
    }

    public boolean isClickByBanner(long j) {
        return PushNotificationSupporter.get().getNotificationClickService().isClickByBanner(j);
    }

    public int getNotificationNum(Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager == null) {
                return -1;
            }
            int i = 0;
            for (StatusBarNotification statusBarNotification : notificationManager.getActiveNotifications()) {
                if (!PushNotificationSupporter.get().getNotificationClearService().isRankerNotification(statusBarNotification)) {
                    i++;
                }
            }
            return i;
        } catch (Throwable th) {
            Logger.m271e("PushNotificationService", "error when getNotificationNum:" + th.getLocalizedMessage());
            return -1;
        }
    }

    public void tryClearSomeNotification() {
        Logger.m274i("PushNotificationService", "[tryClearSomeNotification]");
        ActivityLifecycleObserver.getIns().runAfterUserLaunch(new Runnable() { // from class: com.bytedance.notification.PushNotificationService.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.m274i("PushNotificationService", "[tryClearSomeNotification]runAfterUserLaunch");
                ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.notification.PushNotificationService.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PushNotificationSupporter.get().getNotificationClearService().clearSomeNotifications();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotificationInternal(Context context, Intent intent, NotificationBody notificationBody) {
        int i = ((int) notificationBody.id) % Int32.MAX_VALUE;
        IPushNotification buildNotification = buildNotification(context, intent, notificationBody, (Notification) null, i, "app_notify");
        if (buildNotification == null) {
            Logger.m271e("PushNotificationService", "failed show notification because pushNotificationModel is null");
        } else {
            buildNotification.show("app_notify", i);
        }
    }

    private boolean wakeUpAndComposeMessage(ProxyNotificationExtra proxyNotificationExtra) {
        Logger.m267d("wake up for proxy push");
        if (!proxyNotificationExtra.isValidWakeUpProxyMessage()) {
            return false;
        }
        PushServiceManager.get().getIAllianceService().wakeUpTargetPartner(proxyNotificationExtra.partnerInfo);
        return true;
    }
}
