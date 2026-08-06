package com.bytedance.notification.helper;

import android.app.Application;
import android.app.Notification;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.notification.R;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.utils.RedBadgeUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.BitmapUtils;
import com.ss.android.message.util.DpUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImNotificationHelper {

    /* renamed from: S */
    private static final int f67S = 31;
    private static final String TAG = "ImNotificationHelper";

    public static Notification.Builder buildImNotificationBuilder(Notification.Builder builder, String str, String str2, Bitmap bitmap, boolean z, NotificationBody notificationBody) throws PackageManager.NameNotFoundException {
        boolean z2;
        Application app = AppProvider.getApp();
        Bitmap decodeResource = BitmapFactory.decodeResource(app.getResources(), app.getApplicationInfo().icon);
        PushNotificationExtra pushNotificationExtra = new PushNotificationExtra(notificationBody.bdPushStr);
        FrameLayout frameLayout = (FrameLayout) ((LayoutInflater) app.getSystemService("layout_inflater")).inflate(R.layout.im_notification_style_layout, (ViewGroup) null);
        int i = app.getResources().getDisplayMetrics().widthPixels;
        frameLayout.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE));
        frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
        Logger.m268d(TAG, "[buildImNotificationBuilder]notification_w:" + frameLayout.getWidth() + " notification_h:" + frameLayout.getHeight());
        if (frameLayout.getHeight() == i) {
            Logger.m278w(TAG, "[buildImNotificationBuilder]failed to get notification_h");
            throw new RuntimeException("failed to get notification_h");
        }
        RemoteViews remoteViews = new RemoteViews(app.getPackageName(), R.layout.im_notification_style_layout);
        Bitmap roundedCornerBitmap = BitmapUtils.getRoundedCornerBitmap(bitmap);
        if (!pushNotificationExtra.mIsEmptyExtra && pushNotificationExtra.mNotificationRedbadgeNumber != 0) {
            roundedCornerBitmap = RedBadgeUtils.getRedBadgeBitmapForImNotification(roundedCornerBitmap, pushNotificationExtra.mNotificationRedbadgeNumber);
        }
        remoteViews.setBitmap(R.id.push_notification_small_picture, "setImageBitmap", roundedCornerBitmap);
        remoteViews.setBitmap(R.id.push_notification_app_icon, "setImageBitmap", decodeResource);
        remoteViews.setTextViewText(R.id.push_notification_title, str);
        remoteViews.setTextViewText(R.id.push_notification_content, str2);
        ApplicationInfo applicationInfo = app.getPackageManager().getApplicationInfo(app.getPackageName(), 0);
        int i2 = applicationInfo.targetSdkVersion;
        int i3 = Build.VERSION.SDK_INT;
        Logger.m268d(TAG, "[buildImNotificationBuilder]targetSdkVersion:" + i2 + " deviceSdkVersion:" + i3);
        if (i2 < 31 || i3 < 31) {
            z2 = z;
        } else {
            Logger.m268d(TAG, "[buildImNotificationBuilder]set showHeader to false because cur device has sys header");
            Logger.m268d(TAG, "[buildImNotificationBuilder]set left padding to 0");
            remoteViews.setViewPadding(R.id.im_notification_container, 0, DpUtils.dp2px(app, 5.0f), DpUtils.dp2px(app, 15.0f), DpUtils.dp2px(app, 5.0f));
            Logger.m268d(TAG, "[buildImNotificationBuilder]set app icon not visible,forceSameWithIos:" + notificationBody.forceSameWithIos);
            if (!notificationBody.forceSameWithIos) {
                remoteViews.setViewVisibility(R.id.push_notification_app_icon, 8);
            }
            z2 = false;
        }
        if (z2) {
            remoteViews.setViewVisibility(R.id.push_notification_header, 0);
            remoteViews.setBitmap(R.id.push_notification_header_icon, "setImageBitmap", decodeResource);
            remoteViews.setTextViewText(R.id.push_notification_header_app_name, (String) app.getPackageManager().getApplicationLabel(applicationInfo));
        }
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setCustomContentView(remoteViews);
        builder.setCustomBigContentView(remoteViews);
        return builder;
    }
}
