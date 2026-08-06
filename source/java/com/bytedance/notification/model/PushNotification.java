package com.bytedance.notification.model;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.service.manager.push.notification.IPushNotification;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.notification.R;
import com.bytedance.notification.NotificationDeleteBroadcastReceiver;
import com.bytedance.notification.banner.BannerNotificationStyle;
import com.bytedance.notification.extra.ProxyNotificationExtra;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.helper.NotificationGroupHelper;
import com.bytedance.notification.interfaze.INotificationShowListener;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.notification.utils.NotificationUtils;
import com.bytedance.push.Configuration;
import com.bytedance.push.interfaze.IPushNotificationManagerService;
import com.bytedance.push.utils.DoubleReflectUtils;
import com.bytedance.push.utils.Logger;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushNotification implements IPushNotification {
    public final BannerNotificationStyle mBannerNotification;
    private Context mContext;
    public final Notification mNotification;
    public final NotificationBody mNotificationBody;
    public PushNotificationExtra mPushNotificationExtra;
    public final Intent mTargetIntent;
    private final String TAG = "PushNotification";
    private final String APP_NOTIFY_TAG = "app_notify";

    public PushNotification(Context context, Notification notification, PushNotificationExtra pushNotificationExtra, BannerNotificationStyle bannerNotificationStyle, NotificationBody notificationBody, Intent intent) {
        this.mContext = context;
        this.mNotification = notification;
        this.mPushNotificationExtra = pushNotificationExtra;
        this.mBannerNotification = bannerNotificationStyle;
        this.mNotificationBody = notificationBody;
        this.mTargetIntent = intent;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public void show() {
        show("app_notify", (int) (this.mNotificationBody.id % 2147483647L));
    }

    public void show(final String str, final int i) {
        PendingIntent fullScreenIntent;
        final Notification notification = this.mNotification;
        if (notification == null) {
            return;
        }
        if (notification.contentIntent == null) {
            notification.contentIntent = PendingIntent.getActivity(this.mContext, i, this.mTargetIntent, 67108864);
        }
        final NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        PushNotificationExtra pushNotificationExtra = this.mPushNotificationExtra;
        if (pushNotificationExtra != null) {
            if (pushNotificationExtra.mProxyNotificationExtra != null && pushNotificationExtra.mProxyNotificationExtra.mProxyType == 2) {
                ProxyNotificationExtra proxyNotificationExtra = pushNotificationExtra.mProxyNotificationExtra;
                Iterator<String> keys = proxyNotificationExtra.mExtras.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = proxyNotificationExtra.mExtras.opt(next);
                    if (opt != null) {
                        if (opt instanceof Boolean) {
                            notification.extras.putBoolean(next, ((Boolean) opt).booleanValue());
                        } else if (opt instanceof String) {
                            notification.extras.putString(next, (String) opt);
                        }
                    }
                }
                ApplicationInfo applicationInfo = new ApplicationInfo();
                applicationInfo.packageName = proxyNotificationExtra.mTargetPkg;
                notification.extras.putParcelable("android.appInfo", applicationInfo);
                Object notificationService = PushNotificationSupporter.get().getSystemService().getNotificationService();
                int curUid = PushNotificationSupporter.get().getSystemService().getCurUid(this.mContext);
                if (notificationService == null || curUid == -1) {
                    return;
                }
                DoubleReflectUtils.callInstanceMethod(notificationService, IPushNotificationManagerService.METHOD_NAME_NOTIFY_NOTIFICATION, proxyNotificationExtra.mPkg, proxyNotificationExtra.mOpPkg, null, Integer.valueOf(i), notification, Integer.valueOf(curUid));
                return;
            }
            if (this.mBannerNotification != null && pushNotificationExtra.mBannerType == 1 && (fullScreenIntent = this.mBannerNotification.getFullScreenIntent(this.mContext)) != null) {
                notification.priority = 2;
                notification.category = "call";
                notification.fullScreenIntent = fullScreenIntent;
                notification.flags |= 128;
            }
        }
        if (pushNotificationExtra != null && pushNotificationExtra.flags > 0) {
            Logger.m268d("PushNotification", "pushNotificationExtra.flags is :" + pushNotificationExtra.flags);
            notification.flags |= pushNotificationExtra.flags;
        }
        if (pushNotificationExtra != null && pushNotificationExtra.useSelfReminder()) {
            PushNotificationSupporter.get().getNotificationReminderService(this.mContext).showNotificationWithReminder(this.mNotificationBody.id, pushNotificationExtra, notification, new INotificationShowListener() { // from class: com.bytedance.notification.model.PushNotification.1
                @Override // com.bytedance.notification.interfaze.INotificationShowListener
                public void show() {
                    PushNotification.this.showNotificationInternal(notificationManager, str, i, notification);
                }
            });
        } else {
            showNotificationInternal(notificationManager, str, i, notification);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotificationInternal(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
        Logger.m268d("PushNotification", "show  notification , notificationId is " + i);
        BannerNotificationStyle bannerNotificationStyle = this.mBannerNotification;
        if (bannerNotificationStyle != null) {
            bannerNotificationStyle.showBannerNotification(str, i);
        }
        if (TextUtils.isEmpty(this.mNotificationBody.androidGroup)) {
            return;
        }
        NotificationGroupHelper.getInstance().onNotificationShow(this.mNotificationBody.androidGroup);
        if (NotificationGroupHelper.getInstance().shouldShowGroupSummaryNotification(this.mNotificationBody.androidGroup, this.mNotificationBody.groupFoldNum)) {
            int currentTimeMillis = (int) ((System.currentTimeMillis() + i) % 2147483647L);
            Logger.m268d("PushNotification", "show groupSummary notification :" + this.mNotificationBody.androidGroup + " notificationId is " + currentTimeMillis);
            String str2 = this.mNotificationBody.channelId;
            if (!NotificationUtils.checkChannelExists(this.mContext, str2)) {
                str2 = Configuration.NOTIFICATION_ID;
            }
            Notification buildGroupSummaryNotification = buildGroupSummaryNotification(this.mContext, str2, this.mNotificationBody.androidGroup, notification, currentTimeMillis);
            if (buildGroupSummaryNotification != null) {
                notificationManager.notify(str, currentTimeMillis, buildGroupSummaryNotification);
            }
        }
    }

    private Notification buildGroupSummaryNotification(Context context, String str, String str2, Notification notification, int i) {
        Intent intent = new Intent(context, (Class<?>) NotificationDeleteBroadcastReceiver.getDeleteBroadCastReceiverClass());
        intent.setAction(context.getPackageName() + NotificationDeleteBroadcastReceiver.getDeleteAction());
        intent.putExtra(NotificationDeleteBroadcastReceiver.KEY_MSG_TYPE, NotificationDeleteBroadcastReceiver.VALUE_MSG_TYPE_SUMMARY);
        intent.putExtra("group", str2);
        NotificationCompat.Builder groupSummary = new NotificationCompat.Builder(context, str).setContentText("").setContentTitle("").setGroup(str2).setSmallIcon(R.drawable.status_icon).setAutoCancel(false).setDeleteIntent(PendingIntent.getBroadcast(context, i, intent, 67108864)).setGroupSummary(true);
        if (notification.when > System.currentTimeMillis()) {
            groupSummary.setWhen(notification.when + 1);
            groupSummary.setShowWhen(false);
        }
        return groupSummary.build();
    }
}
