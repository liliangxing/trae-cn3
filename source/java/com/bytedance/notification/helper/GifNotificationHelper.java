package com.bytedance.notification.helper;

import android.app.Application;
import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.RemoteViews;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.notification.R;
import com.bytedance.notification.Constants;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.utils.GifUtils;
import com.bytedance.push.settings.notification.NotificationParamsModel;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GifNotificationHelper {
    private static String TAG = "GifNotificationHelper";

    public static Notification.Builder buildGifNotificationHelper(Notification.Builder builder, NotificationBody notificationBody) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            Logger.m271e(TAG, "Don't call time-consuming methods on the main thread.");
            return builder;
        }
        Application app = AppProvider.getApp();
        RemoteViews remoteViews = new RemoteViews(app.getPackageName(), R.layout.gif_notification_content_layout);
        RemoteViews remoteViews2 = new RemoteViews(app.getPackageName(), getBigContentLayout());
        String gifVideoPath = getGifVideoPath(notificationBody);
        remoteViews.setTextViewText(R.id.notification_title, notificationBody.title);
        remoteViews.setTextViewText(R.id.notification_content, notificationBody.content);
        remoteViews2.setTextViewText(R.id.notification_title, notificationBody.title);
        remoteViews2.setTextViewText(R.id.notification_content, notificationBody.content);
        Logger.m268d(TAG, "getAllFramesForGif: " + gifVideoPath);
        List<Bitmap> allFramesForGif = GifUtils.getAllFramesForGif(gifVideoPath, getGifFrameInterval(), getGifMaxPixelSize());
        Logger.m268d(TAG, "frames: " + allFramesForGif.size());
        if (allFramesForGif.size() > 0) {
            int matchBigImageLayout = matchBigImageLayout(allFramesForGif);
            for (Bitmap bitmap : allFramesForGif) {
                remoteViews.addView(R.id.notification_image, new RemoteViews(app.getPackageName(), R.layout.gif_notification_image_layout, bitmap) { // from class: com.bytedance.notification.helper.GifNotificationHelper.1
                    final /* synthetic */ Bitmap val$value;

                    {
                        this.val$value = bitmap;
                        setImageViewBitmap(R.id.gif_image, bitmap);
                    }
                });
                remoteViews2.addView(R.id.notification_image, new RemoteViews(app.getPackageName(), matchBigImageLayout, bitmap) { // from class: com.bytedance.notification.helper.GifNotificationHelper.2
                    final /* synthetic */ Bitmap val$value;

                    {
                        this.val$value = bitmap;
                        setImageViewBitmap(R.id.gif_image, bitmap);
                    }
                });
            }
            builder.setStyle(new Notification.DecoratedCustomViewStyle());
            builder.setContentTitle(notificationBody.title);
            builder.setContentText(notificationBody.content);
            builder.setCustomContentView(remoteViews);
            if (getGifEnableExpansion()) {
                builder.setCustomBigContentView(remoteViews2);
            } else {
                builder.setCustomBigContentView(remoteViews);
            }
        } else {
            builder.setContentTitle(notificationBody.title).setContentText(notificationBody.content).setLargeIcon(notificationBody.imageBitmap);
        }
        return builder;
    }

    private static int matchBigImageLayout(List<Bitmap> list) {
        if (list == null || list.size() == 0) {
            return R.layout.gif_notification_big_image_1_1_layout;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(Float.valueOf(1.0f), Integer.valueOf(R.layout.gif_notification_big_image_1_1_layout));
        hashMap.put(Float.valueOf(0.5625f), Integer.valueOf(R.layout.gif_notification_big_image_9_16_layout));
        hashMap.put(Float.valueOf(1.7777778f), Integer.valueOf(R.layout.gif_notification_big_image_16_9_layout));
        hashMap.put(Float.valueOf(1.3333334f), Integer.valueOf(R.layout.gif_notification_big_image_4_3_layout));
        Bitmap bitmap = list.get(0);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height == 0) {
            return R.layout.gif_notification_big_image_1_1_layout;
        }
        float f = width / height;
        int i = R.layout.gif_notification_big_image_1_1_layout;
        float f2 = Float.MAX_VALUE;
        for (Map.Entry entry : hashMap.entrySet()) {
            float floatValue = ((Float) entry.getKey()).floatValue();
            int intValue = ((Integer) entry.getValue()).intValue();
            float abs = Math.abs(f - floatValue);
            if (abs < f2) {
                i = intValue;
                f2 = abs;
            }
        }
        return i;
    }

    private static int getBigContentLayout() {
        NotificationParamsModel notificationParamsModel = PushSetting.getInstance().getPushOnLineSettings().getNotificationParamsModel();
        if (notificationParamsModel != null && notificationParamsModel.notificationGifPosition.equals(Constants.NOTIFICATION_GIF_POSITION_BOTTOM)) {
            return R.layout.gif_notification_big_content_bottom_layout;
        }
        return R.layout.gif_notification_big_content_right_layout;
    }

    private static int getGifFrameInterval() {
        int i;
        NotificationParamsModel notificationParamsModel = PushSetting.getInstance().getPushOnLineSettings().getNotificationParamsModel();
        if (notificationParamsModel == null || (i = notificationParamsModel.notificationGifFrameInterval) <= 0) {
            return 200;
        }
        return i;
    }

    private static int getGifMaxPixelSize() {
        int i;
        NotificationParamsModel notificationParamsModel = PushSetting.getInstance().getPushOnLineSettings().getNotificationParamsModel();
        return (notificationParamsModel == null || (i = notificationParamsModel.notificationGifMaxPixelSize) <= 0) ? Constants.NOTIFICATION_STRIP_REMOTEVIEW_SIZE_BYTES : i;
    }

    private static boolean getGifEnableExpansion() {
        NotificationParamsModel notificationParamsModel = PushSetting.getInstance().getPushOnLineSettings().getNotificationParamsModel();
        if (notificationParamsModel != null) {
            return notificationParamsModel.notificationGifEnableExpansion;
        }
        return true;
    }

    private static String getGifVideoPath(NotificationBody notificationBody) {
        PushNotificationExtra pushNotificationExtra = new PushNotificationExtra(notificationBody.bdPushStr);
        return (pushNotificationExtra.mIsEmptyExtra || pushNotificationExtra.mNotificationVideoUrl.isEmpty()) ? "" : pushNotificationExtra.mNotificationVideoUrl;
    }
}
