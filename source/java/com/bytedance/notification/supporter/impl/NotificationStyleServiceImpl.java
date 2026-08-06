package com.bytedance.notification.supporter.impl;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioManager;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.banner.BannerNotificationStyle;
import com.bytedance.notification.extra.ProxyNotificationExtra;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.helper.NotificationButtonHelper;
import com.bytedance.notification.helper.NotificationRedBadgeHelper;
import com.bytedance.notification.model.PushNotification;
import com.bytedance.notification.style.BackGroundNotificationStyle;
import com.bytedance.notification.style.BaseNotificationStyle;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.notification.supporter.service.INotificationStyleService;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.BitmapUtils;
import com.ss.android.message.util.DpUtils;
import com.ss.android.message.util.IntentSecurityUtils;
import java.net.URISyntaxException;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationStyleServiceImpl implements INotificationStyleService {
    private final String TAG = "NotificationStyleService";
    boolean mUseColorIcon;

    public NotificationStyleServiceImpl() {
        this.mUseColorIcon = ((PushOnlineSettings) SettingsManager.obtain(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication, PushOnlineSettings.class)).notificationSmallIconStyle() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0192  */
    @Override // com.bytedance.notification.supporter.service.INotificationStyleService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PushNotification buildCustomNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z, int i, String str) {
        Intent intent2;
        Intent intent3;
        Bitmap bitmap;
        Bitmap downloadImage;
        Notification.Builder buildBaseNotification = new BaseNotificationStyle(this.mUseColorIcon).buildBaseNotification(context, builder, notificationBody, z);
        PushNotificationExtra pushNotificationExtra = new PushNotificationExtra(notificationBody.bdPushStr);
        if (pushNotificationExtra.mIsEmptyExtra) {
            intent2 = intent;
        } else {
            ProxyNotificationExtra proxyNotificationExtra = pushNotificationExtra.mProxyNotificationExtra;
            if (proxyNotificationExtra == null || proxyNotificationExtra.mProxyType != 2) {
                intent3 = intent;
            } else {
                pushNotificationExtra.mEnableNotificationHighLight = true;
                if (TextUtils.isEmpty(proxyNotificationExtra.mProxyIconUrl)) {
                    return null;
                }
                notificationBody.iconBitmap = PushNotificationSupporter.get().getImageDownloadService().downloadImage(proxyNotificationExtra.mProxyIconUrl);
                if (notificationBody.iconBitmap == null || TextUtils.isEmpty(notificationBody.openUrl)) {
                    return null;
                }
                try {
                    intent3 = Intent.parseUri(notificationBody.openUrl, 0);
                    intent3.setPackage(AppProvider.getApp().getPackageName());
                    if (!IntentSecurityUtils.isSafeIntent(intent3)) {
                        Logger.m278w("NotificationStyleService", "[buildCustomNotification]return null because intent is not safe");
                        return null;
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (!TextUtils.isEmpty(pushNotificationExtra.mNotificationBackgroundImage) && (downloadImage = PushNotificationSupporter.get().getImageDownloadService().downloadImage(pushNotificationExtra.mNotificationBackgroundImage)) != null) {
                pushNotificationExtra.mNotificationBackgroundBitmap = downloadImage;
            }
            if (!TextUtils.isEmpty(pushNotificationExtra.mBannerBackgroundImage)) {
                if (TextUtils.equals(pushNotificationExtra.mBannerBackgroundImage, pushNotificationExtra.mNotificationBackgroundImage)) {
                    pushNotificationExtra.mBannerBackgroundBitmap = pushNotificationExtra.mNotificationBackgroundBitmap;
                } else {
                    Bitmap downloadImage2 = PushNotificationSupporter.get().getImageDownloadService().downloadImage(pushNotificationExtra.mBannerBackgroundImage);
                    if (downloadImage2 != null) {
                        pushNotificationExtra.mBannerBackgroundBitmap = downloadImage2;
                    }
                }
            }
            if (pushNotificationExtra.mNotificationBackgroundBitmap == null) {
                if (pushNotificationExtra.mEnableNotificationHighLight && pushNotificationExtra.mNotificationColor != -1) {
                    Paint paint = new Paint();
                    paint.setColor(pushNotificationExtra.mNotificationColor);
                    Bitmap createBitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565);
                    Canvas canvas = new Canvas(createBitmap);
                    float f = 200;
                    canvas.drawRect(0.0f, 0.0f, f, f, paint);
                    canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
                    pushNotificationExtra.mNotificationBackgroundBitmap = createBitmap;
                    bitmap = createBitmap;
                    if (pushNotificationExtra.mBannerBackgroundBitmap != null) {
                        if (!pushNotificationExtra.mEnableBannerHighLight || pushNotificationExtra.mBannerColor == -1) {
                            pushNotificationExtra.mEnableBannerHighLight = true;
                            pushNotificationExtra.mBannerColor = -1;
                        }
                        if (pushNotificationExtra.mBannerColor == pushNotificationExtra.mNotificationColor && bitmap != null) {
                            pushNotificationExtra.mBannerBackgroundBitmap = bitmap;
                        } else {
                            Paint paint2 = new Paint();
                            paint2.setColor(pushNotificationExtra.mBannerColor);
                            Bitmap createBitmap2 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            float f2 = 200;
                            canvas2.drawRect(0.0f, 0.0f, f2, f2, paint2);
                            canvas2.drawBitmap(createBitmap2, 0.0f, 0.0f, paint2);
                            pushNotificationExtra.mBannerBackgroundBitmap = createBitmap2;
                        }
                    } else {
                        pushNotificationExtra.mBannerBackgroundBitmap = BitmapUtils.zoomImg(pushNotificationExtra.mBannerBackgroundBitmap, pushNotificationExtra.mBannerBackgroundBitmap.getWidth(), DpUtils.dp2px(context, 64.0f));
                    }
                    if (notificationBody.imageType <= 2 && pushNotificationExtra.mNotificationRedbadgeNumber != 0) {
                        Logger.m268d("NotificationStyleService", "setNotificationRedBadge: " + pushNotificationExtra.mNotificationRedbadgeNumber);
                        NotificationRedBadgeHelper.setNotificationRedBadge(buildBaseNotification, notificationBody.imageBitmap, pushNotificationExtra.mNotificationRedbadgeNumber);
                    }
                    if (pushNotificationExtra.mPushNotificationButtonInfoList != null) {
                        for (PushNotificationButtonInfo pushNotificationButtonInfo : pushNotificationExtra.mPushNotificationButtonInfoList) {
                            NotificationButtonHelper.setNotificationButton(buildBaseNotification, notificationBody, pushNotificationButtonInfo, i, str);
                            Logger.m268d("NotificationStyleService", "setNotificationButton: " + pushNotificationButtonInfo);
                        }
                    }
                    intent2 = intent3;
                }
            } else {
                pushNotificationExtra.mNotificationBackgroundBitmap = BitmapUtils.zoomImg(pushNotificationExtra.mNotificationBackgroundBitmap, pushNotificationExtra.mNotificationBackgroundBitmap.getWidth(), DpUtils.dp2px(context, 64.0f));
            }
            bitmap = null;
            if (pushNotificationExtra.mBannerBackgroundBitmap != null) {
            }
            if (notificationBody.imageType <= 2) {
                Logger.m268d("NotificationStyleService", "setNotificationRedBadge: " + pushNotificationExtra.mNotificationRedbadgeNumber);
                NotificationRedBadgeHelper.setNotificationRedBadge(buildBaseNotification, notificationBody.imageBitmap, pushNotificationExtra.mNotificationRedbadgeNumber);
            }
            if (pushNotificationExtra.mPushNotificationButtonInfoList != null) {
            }
            intent2 = intent3;
        }
        BannerNotificationStyle bannerNotificationStyle = pushNotificationExtra.mEnableBannerShow ? new BannerNotificationStyle(context, buildBaseNotification, intent2, pushNotificationExtra, notificationBody) : null;
        if (!pushNotificationExtra.mIsEmptyExtra) {
            buildBaseNotification = new BackGroundNotificationStyle(context, pushNotificationExtra, notificationBody).buildBackGroundNotification(buildBaseNotification);
        }
        Notification build = buildBaseNotification.build();
        addSoundAndVibrator(context, build, notificationBody);
        if (pushNotificationExtra.mExtras != null) {
            Iterator<String> keys = pushNotificationExtra.mExtras.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = pushNotificationExtra.mExtras.opt(next);
                if (opt != null) {
                    if (opt instanceof Boolean) {
                        build.extras.putBoolean(next, ((Boolean) opt).booleanValue());
                    } else if (opt instanceof String) {
                        build.extras.putString(next, (String) opt);
                    }
                }
            }
        }
        return new PushNotification(context, build, pushNotificationExtra, bannerNotificationStyle, notificationBody, intent2);
    }

    @Override // com.bytedance.notification.supporter.service.INotificationStyleService
    public PushNotification buildCustomNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody) {
        return buildCustomNotification(context, intent, builder, notificationBody, true);
    }

    @Override // com.bytedance.notification.supporter.service.INotificationStyleService
    public PushNotification buildCustomNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z) {
        return buildCustomNotification(context, intent, builder, notificationBody, z, 0, "");
    }

    @Override // com.bytedance.notification.supporter.service.INotificationStyleService
    public void addSoundAndVibrator(Context context, Notification notification, NotificationBody notificationBody) {
        if (notification == null) {
            return;
        }
        if (notificationBody.useSound) {
            notification.defaults |= 1;
        }
        if (notificationBody.useVibrator) {
            try {
                int ringerMode = ((AudioManager) context.getSystemService("audio")).getRingerMode();
                if (ringerMode == 1 || ringerMode == 2) {
                    notification.defaults |= 2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (notificationBody.sound != null) {
            notification.sound = notificationBody.sound;
        }
    }
}
