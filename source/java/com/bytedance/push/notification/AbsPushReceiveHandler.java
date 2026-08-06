package com.bytedance.push.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.IPushNotification;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.push.BDPush;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.img.Request;
import com.bytedance.push.interfaze.ICustomNotificationBuilder;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.utils.CustomSoundUtils;
import com.bytedance.push.utils.Logger;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsPushReceiveHandler {
    static final String APP_NOTIFY_TAG = "app_notify";
    private final String TAG = "AbsPushReceiveHandler";
    protected final AsyncImageDownloadWrapper mImageDownloader;
    protected final ICustomNotificationBuilder mOnPushReceiveHandler;

    public static String getAppNotifyTag() {
        return APP_NOTIFY_TAG;
    }

    public abstract Intent getPushIntent(Context context, int i, PushBody pushBody);

    public AbsPushReceiveHandler(ICustomNotificationBuilder iCustomNotificationBuilder, AsyncImageDownloadWrapper asyncImageDownloadWrapper) {
        this.mOnPushReceiveHandler = iCustomNotificationBuilder;
        this.mImageDownloader = asyncImageDownloadWrapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onReceivePushMsg(Context context, int i, PushBody pushBody, boolean z, long j) {
        if (pushBody == null) {
            return;
        }
        PushSupporter.logger().mo245d(IPushService.TAG_PUSH_SHOW, "show message :" + pushBody);
        showNotification(context, pushBody.mIsPassThough, i, getPushIntent(context, i, pushBody), pushBody);
    }

    private void showNotification(Context context, boolean z, int i, Intent intent, PushBody pushBody) {
        try {
            if (z) {
                showNotification(context, intent, i, pushBody);
            } else {
                context.startActivity(intent);
            }
        } catch (Exception e) {
            Logger.m272e("AbsPushReceiveHandler", "error when show notification ", e);
            e.printStackTrace();
        }
    }

    private void showNotification(Context context, Intent intent, int i, PushBody pushBody) {
        Bitmap downloadImage = !TextUtils.isEmpty(pushBody.imageUrl) ? this.mImageDownloader.downloadImage(new Request(Uri.parse(pushBody.imageUrl), 0, 0, null)) : null;
        ICustomNotificationBuilder iCustomNotificationBuilder = this.mOnPushReceiveHandler;
        Notification buildNotification = iCustomNotificationBuilder != null ? iCustomNotificationBuilder.buildNotification(context, i, pushBody, downloadImage) : null;
        NotificationBody convertToNotificationBody = pushBody.convertToNotificationBody();
        if (Build.VERSION.SDK_INT < 26) {
            try {
                String remoteSoundFilePath = CustomSoundUtils.getRemoteSoundFilePath(context, convertToNotificationBody.channelId);
                if (new File(remoteSoundFilePath).exists()) {
                    convertToNotificationBody.sound = CustomSoundUtils.getRemoteSoundUri(context, remoteSoundFilePath);
                } else {
                    Configuration configuration = PushSupporter.get().getConfiguration();
                    int localSoundResourceId = configuration != null ? CustomSoundUtils.getLocalSoundResourceId(convertToNotificationBody.channelId, configuration.mNotificationSoundsRes, null) : -1;
                    if (localSoundResourceId != -1) {
                        convertToNotificationBody.sound = CustomSoundUtils.getLocalSoundUri(context, localSoundResourceId);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        IPushNotification buildNotification2 = PushServiceManager.get().getIPushNotificationService().buildNotification(context, intent, convertToNotificationBody, buildNotification);
        if (buildNotification2 != null) {
            PendingIntent notificationDeleteIntent = BDPush.getPushService().getNotificationDeleteIntent(convertToNotificationBody.id, null);
            if (notificationDeleteIntent != null) {
                buildNotification2.getNotification().deleteIntent = notificationDeleteIntent;
            }
            buildNotification2.show();
        }
    }
}
