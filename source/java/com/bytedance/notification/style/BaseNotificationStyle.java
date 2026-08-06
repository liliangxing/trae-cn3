package com.bytedance.notification.style;

import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.notification.R;
import com.bytedance.ies.uikit.toast.CustomToast;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.notification.NotificationDeleteBroadcastReceiver;
import com.bytedance.notification.helper.GifNotificationHelper;
import com.bytedance.notification.helper.ImNotificationHelper;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.notification.utils.NotificationUtils;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.NotificationSettings;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseNotificationStyle {
    private boolean mUseColorIcon;
    private final String TAG = "BaseNotificationStyle";
    private final String SUCCESS = "success";

    public BaseNotificationStyle(boolean z) {
        this.mUseColorIcon = z;
    }

    public Notification.Builder buildBaseNotification(Context context, NotificationBody notificationBody) {
        return buildBaseNotification(context, initBuilder(context, notificationBody), notificationBody, true);
    }

    private Notification.Builder initBuilder(Context context, NotificationBody notificationBody) {
        if (!NotificationUtils.checkChannelExists(context, notificationBody.channelId)) {
            notificationBody.channelId = Configuration.NOTIFICATION_ID;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return handleNotificationCompliance(context, notificationBody);
        }
        return new Notification.Builder(context);
    }

    public Notification.Builder handleNotificationCompliance(Context context, NotificationBody notificationBody) {
        Notification.Builder builder = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(context, notificationBody.channelId) : null;
        try {
            NotificationSettings notificationSettings = ((PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class)).getNotificationSettings();
            if (notificationSettings.enableHarmonyOs4ImportanceAndCategory && RomVersionParamHelper.isGreaterThanHarmonyOs4() && Build.VERSION.SDK_INT >= 26) {
                int check = PushNotificationSupporter.get().getNotificationCompliance().check(context, notificationBody);
                PushSupporter.monitor().monitorHarmonyOs4Compliance(check != 0, check);
                if (check != 0) {
                    try {
                        if (notificationSettings.harmonyOs4ImportanceAndCategoryInterceptStrategy == 1) {
                            builder = new Notification.Builder(context, "custom_silent");
                        } else if (notificationSettings.harmonyOs4ImportanceAndCategoryInterceptStrategy == 2) {
                            Bundle extras = builder.getExtras();
                            if (extras == null) {
                                extras = new Bundle();
                            }
                            extras.putInt("push_sdk_harmony_os4_channel_importance_expectation", notificationBody.channelImportance);
                        }
                    } catch (Throwable unused) {
                    }
                    builder.setCategory(notificationBody.notificationCategory);
                } else {
                    builder.setCategory(notificationBody.notificationCategory);
                }
            }
        } catch (Throwable unused2) {
        }
        return builder;
    }

    public Notification.Builder buildBaseNotification(Context context, NotificationCompat.Builder builder, NotificationBody notificationBody) {
        if (builder == null) {
            return buildBaseNotification(context, notificationBody);
        }
        return buildBaseNotification(context, Notification.Builder.recoverBuilder(context, builder.build()), notificationBody, true);
    }

    private String getAppName(Context context) {
        try {
            return context.getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Throwable th) {
            Logger.m272e("BaseNotificationStyle", "failed get labelRes! ", th);
            try {
                return String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).loadLabel(context.getPackageManager()));
            } catch (Throwable th2) {
                th2.printStackTrace();
                Logger.m272e("BaseNotificationStyle", "failed get app label! ", th2);
                return "";
            }
        }
    }

    public Notification.Builder buildBaseNotification(Context context, Notification.Builder builder, NotificationBody notificationBody, boolean z) {
        if (builder == null) {
            builder = initBuilder(context, notificationBody);
        }
        if (TextUtils.isEmpty(notificationBody.title)) {
            String appName = getAppName(context);
            if (TextUtils.isEmpty(appName)) {
                Logger.m268d("BaseNotificationStyle", "failed to show notification because message.title is empty and failed to get app name");
                return null;
            }
            notificationBody.title = appName;
        }
        long currentTimeMillis = System.currentTimeMillis();
        builder.setTicker(notificationBody.title);
        builder.setWhen(currentTimeMillis);
        builder.setShowWhen(notificationBody.showWhen);
        if (z) {
            if (Build.VERSION.SDK_INT >= 29 && Build.MANUFACTURER.equalsIgnoreCase("oppo")) {
                builder.setSmallIcon(R.drawable.status_icon);
            } else {
                builder.setSmallIcon(R.drawable.status_icon_l);
            }
            if (this.mUseColorIcon) {
                builder.setSmallIcon(R.drawable.status_icon);
            }
        }
        if (notificationBody.useLED) {
            builder.setLights(-16711936, BytePatchException.ErrorCode.paramsError, CustomToast.LENGTH_SHORT);
        }
        builder.setPriority(1);
        builder.setVibrate(new long[0]);
        Bundle bundle = new Bundle();
        bundle.putString(NotificationDeleteBroadcastReceiver.KEY_MSG_TYPE, "notification");
        bundle.putLong(NotificationDeleteBroadcastReceiver.KEY_MSG_ID, notificationBody.id);
        if (!TextUtils.isEmpty(notificationBody.androidGroup)) {
            Logger.m268d("BaseNotificationStyle", "setGroup:" + notificationBody.androidGroup);
            builder.setGroup(notificationBody.androidGroup);
            bundle.putString("group", notificationBody.androidGroup);
        }
        builder.setAutoCancel(true);
        JSONObject jSONObject = new JSONObject();
        if (notificationBody.eventExtra != null) {
            try {
                jSONObject.put("ttpush_event_extra", notificationBody.eventExtra);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        NotificationDeleteBroadcastReceiver.register();
        builder.setDeleteIntent(PushServiceManager.get().getIPushNotificationService().getNotificationDeleteIntent(notificationBody.id, bundle, jSONObject));
        return getStyleNotification(builder, context, notificationBody);
    }

    private Notification.Builder getStyleNotification(Notification.Builder builder, Context context, NotificationBody notificationBody) {
        String str;
        Notification.Builder builder2 = null;
        if (builder == null || context == null || notificationBody == null) {
            return null;
        }
        if (notificationBody.imageBitmap == null || notificationBody.imageBitmap.isRecycled()) {
            notificationBody.imageType = 0;
        }
        Logger.m268d("BaseNotificationStyle", "[getStyleNotification]imageType:" + notificationBody.imageType);
        int i = notificationBody.imageType;
        if (i == 0) {
            onBuildNotificationResult(0, notificationBody);
            return getNotificationStyle_00(builder, context, notificationBody.title, notificationBody.content);
        }
        if (i == 1) {
            onBuildNotificationResult(1, notificationBody);
            return getNotificationStyle_01(builder, context, notificationBody.title, notificationBody.content, notificationBody.imageBitmap);
        }
        int i2 = 2;
        if (i == 2) {
            onBuildNotificationResult(2, notificationBody);
            return getNotificationStyle_02(builder, notificationBody.title, notificationBody.content, notificationBody.imageBitmap);
        }
        if (i != 7) {
            if (i == 8) {
                return getNotificationStyle_04(builder, notificationBody);
            }
            return getNotificationStyle_00(builder, context, notificationBody.title, notificationBody.content);
        }
        try {
            builder2 = getNotificationStyle_03(builder, notificationBody.title, notificationBody.content, notificationBody.imageBitmap, notificationBody.avatarDisplayMode == 1, notificationBody);
            str = builder2 == null ? "empty notification" : "success";
        } catch (Throwable th) {
            str = "exception:" + th.getLocalizedMessage();
        }
        int i3 = notificationBody.imageType;
        if (TextUtils.equals(str, "success")) {
            i2 = i3;
        } else {
            builder2 = getNotificationStyle_02(builder, notificationBody.title, notificationBody.content, notificationBody.imageBitmap);
        }
        onBuildNotificationResult(i2, str, notificationBody);
        return builder2;
    }

    private void onBuildNotificationResult(int i, NotificationBody notificationBody) {
        onBuildNotificationResult(i, "success", notificationBody);
    }

    private void onBuildNotificationResult(int i, String str, NotificationBody notificationBody) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("origin_notification_type", notificationBody.imageType);
            jSONObject.put("final_notification_type", i);
            jSONObject.put("msg", str);
            jSONObject.put("android_group", notificationBody.androidGroup);
        } catch (Throwable th) {
            Logger.m272e("BaseNotificationStyle", "error when build params ", th);
        }
        PushSupporter.get().getMultiProcessEventSenderService().onEventV3(false, "notification_build_event", jSONObject);
    }

    private Notification.Builder getNotificationStyle_00(Notification.Builder builder, Context context, String str, String str2) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeResource(context.getResources(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon);
        } catch (Exception unused) {
            bitmap = null;
        }
        Notification.Builder contentText = builder.setContentTitle(str).setContentText(str2);
        contentText.setStyle(new Notification.BigTextStyle().bigText(str2));
        return (bitmap == null || bitmap.isRecycled()) ? contentText : contentText.setLargeIcon(bitmap);
    }

    private Notification.Builder getNotificationStyle_01(Notification.Builder builder, Context context, String str, String str2, Bitmap bitmap) {
        Bitmap bitmap2;
        try {
            bitmap2 = BitmapFactory.decodeResource(context.getResources(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon);
        } catch (Exception unused) {
            bitmap2 = null;
        }
        Notification.Builder contentText = builder.setContentTitle(str).setContentText(str2);
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle().bigPicture(bitmap).setSummaryText(str2).setBigContentTitle(str);
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            bigContentTitle = bigContentTitle.bigLargeIcon(bitmap2);
        }
        contentText.setStyle(bigContentTitle).setLargeIcon(bitmap);
        return contentText;
    }

    private Notification.Builder getNotificationStyle_02(Notification.Builder builder, String str, String str2, Bitmap bitmap) {
        builder.setContentTitle(str).setContentText(str2).setLargeIcon(bitmap);
        return builder;
    }

    private Notification.Builder getNotificationStyle_03(Notification.Builder builder, String str, String str2, Bitmap bitmap, boolean z, NotificationBody notificationBody) throws PackageManager.NameNotFoundException {
        return ImNotificationHelper.buildImNotificationBuilder(builder, str, str2, bitmap, z, notificationBody);
    }

    private Notification.Builder getNotificationStyle_04(Notification.Builder builder, NotificationBody notificationBody) {
        return GifNotificationHelper.buildGifNotificationHelper(builder, notificationBody);
    }
}
