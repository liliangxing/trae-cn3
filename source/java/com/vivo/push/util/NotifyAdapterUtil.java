package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.ttm.player.MediaFormat;
import com.vivo.push.C1306m;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.p010b.C1219p;
import com.vivo.push.p017h.C1295u;
import com.vivo.push.restructure.C1313a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotifyAdapterUtil {
    private static final String EXTRA_VPUSH_TYPE = "extra_vpush_type";
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static final String USER_ID = "sysUserId";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    public static void pushNotification(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, NotifyArriveCallbackByUser notifyArriveCallbackByUser, C1295u.a aVar) {
        C1393t.m1048d(TAG, "pushNotification");
        initAdapter(context);
        int notifyMode = NotifyUtil.getNotifyDataAdapter(context).getNotifyMode(insideNotificationItem);
        if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl()) && list != null && list.size() > 1 && list.get(1) != null) {
            notifyMode = 1;
        }
        if (notifyMode == 2) {
            pushNotificationBySystem(context, list, insideNotificationItem, j, i, notifyArriveCallbackByUser, aVar);
        } else if (notifyMode == 1) {
            pushNotificationByCustom(context, list, insideNotificationItem, j, notifyArriveCallbackByUser, aVar);
        }
    }

    private static synchronized void initAdapter(Context context) {
        NotificationManager notificationManager;
        synchronized (NotifyAdapterUtil.class) {
            if (sNotificationManager == null) {
                sNotificationManager = (NotificationManager) context.getSystemService("notification");
            }
            if (Build.VERSION.SDK_INT >= 26 && (notificationManager = sNotificationManager) != null) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel(DownloadSettingKeys.BugFix.DEFAULT);
                if (notificationChannel != null) {
                    CharSequence name = notificationChannel.getName();
                    if (PUSH_ZH.equals(name) || PUSH_EN.equals(name)) {
                        sNotificationManager.deleteNotificationChannel(DownloadSettingKeys.BugFix.DEFAULT);
                    }
                }
                NotificationChannel notificationChannel2 = sNotificationManager.getNotificationChannel(PRIMARY_CHANNEL);
                C1393t.m1046c(TAG, "initAdapter PRIMARY_CHANNEL yi exist ？= " + (notificationChannel2 == null) + " 是否支持创建推送通知渠道= " + C1313a.m810a().m817g().m646e());
                if (!C1313a.m810a().m817g().m646e() || notificationChannel2 == null) {
                    NotificationChannel notificationChannel3 = new NotificationChannel(PRIMARY_CHANNEL, isZh(context) ? PUSH_ZH : PUSH_EN, 4);
                    notificationChannel3.setLightColor(-16711936);
                    notificationChannel3.enableVibration(true);
                    notificationChannel3.setLockscreenVisibility(1);
                    sNotificationManager.createNotificationChannel(notificationChannel3);
                }
            }
        }
    }

    private static void pushNotificationByCustom(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, NotifyArriveCallbackByUser notifyArriveCallbackByUser, C1295u.a aVar) {
        Notification build;
        Bitmap bitmap;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        int i = context.getApplicationInfo().icon;
        Bundle bundle = new Bundle();
        bundle.putLong(PUSH_ID, j);
        if (C1313a.m810a().m815e().mo873m().isOpenMultiUser()) {
            bundle.putInt(USER_ID, C1395v.m1053a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            builder.setExtras(bundle);
            build = builder.build();
        } else {
            Notification.Builder builder2 = new Notification.Builder(context);
            builder2.setExtras(bundle);
            build = builder2.build();
        }
        Notification notification = build;
        notification.priority = 2;
        notification.flags = 16;
        notification.tickerText = title;
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId <= 0) {
            defaultSmallIconId = i;
        }
        notification.icon = defaultSmallIconId;
        RemoteViews remoteViews = new RemoteViews(packageName, NotifyUtil.getNotifyLayoutAdapter(context).getNotificationLayout());
        remoteViews.setTextViewText(resources.getIdentifier("notify_title", "id", packageName), title);
        remoteViews.setTextColor(resources.getIdentifier("notify_title", "id", packageName), NotifyUtil.getNotifyLayoutAdapter(context).getTitleColor());
        remoteViews.setTextViewText(resources.getIdentifier("notify_msg", "id", packageName), insideNotificationItem.getContent());
        if (insideNotificationItem.isShowTime()) {
            remoteViews.setTextViewText(resources.getIdentifier("notify_when", "id", packageName), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 0);
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_when", "id", packageName), 8);
        }
        int suitIconId = NotifyUtil.getNotifyLayoutAdapter(context).getSuitIconId();
        remoteViews.setViewVisibility(suitIconId, 0);
        if (list != null && !list.isEmpty() && (bitmap = list.get(0)) != null) {
            remoteViews.setImageViewBitmap(suitIconId, bitmap);
        } else {
            if (defaultNotifyIcon <= 0) {
                defaultNotifyIcon = i;
            }
            remoteViews.setImageViewResource(suitIconId, defaultNotifyIcon);
        }
        Bitmap bitmap2 = (list == null || list.size() <= 1) ? null : list.get(1);
        if (bitmap2 != null) {
            if (!TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_content", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
                remoteViews.setViewVisibility(resources.getIdentifier("notify_pure_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_pure_cover", "id", packageName), bitmap2);
            } else {
                remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 0);
                remoteViews.setImageViewBitmap(resources.getIdentifier("notify_cover", "id", packageName), bitmap2);
            }
        } else {
            remoteViews.setViewVisibility(resources.getIdentifier("notify_cover", "id", packageName), 8);
        }
        notification.contentView = remoteViews;
        if (TextUtils.isEmpty(insideNotificationItem.getPurePicUrl())) {
            notification.bigContentView = remoteViews;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        int ringerMode = audioManager.getRingerMode();
        int vibrateSetting = audioManager.getVibrateSetting(0);
        C1393t.m1048d(TAG, "ringMode=" + ringerMode + " callVibrateSetting=" + vibrateSetting);
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        notification.defaults = 1;
                    }
                    if (vibrateSetting == 1) {
                        notification.defaults |= 2;
                        notification.vibrate = new long[]{0, 100, 200, 300};
                    }
                }
            } else if (vibrateSetting == 1) {
                notification.defaults = 2;
                notification.vibrate = new long[]{0, 100, 200, 300};
            }
        } else if (ringerMode == 2) {
            notification.defaults = 1;
        }
        C1382i c1382i = new C1382i();
        Intent m977a = c1382i.m977a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
        if (m977a != null) {
            if (isPullService()) {
                notification.contentIntent = PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), AbstractC1375b.m972a(context, packageName, j, m977a, insideNotificationItem), 201326592);
            } else {
                new C1219p(packageName, j, insideNotificationItem).m1068b(m977a);
                notification.contentIntent = c1382i.mo975a(context, m977a);
            }
            if (sNotificationManager != null) {
                int m795j = C1306m.m762a().m795j();
                try {
                    if (m795j == 0) {
                        sNotificationManager.notify(sNotifyId, notification);
                        if (aVar != null) {
                            aVar.mo735a();
                            return;
                        }
                        return;
                    }
                    if (m795j == 1) {
                        sNotificationManager.notify((int) j, notification);
                        if (aVar != null) {
                            aVar.mo735a();
                            return;
                        }
                        return;
                    }
                    C1393t.m1034a(TAG, "unknow notify style ".concat(String.valueOf(m795j)));
                    return;
                } catch (Exception e) {
                    C1393t.m1036a(TAG, e);
                    if (aVar != null) {
                        aVar.mo736b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        C1393t.m1034a(TAG, "make notify intent error  ");
    }

    private static void pushNotificationBySystem(Context context, List<Bitmap> list, InsideNotificationItem insideNotificationItem, long j, int i, NotifyArriveCallbackByUser notifyArriveCallbackByUser, C1295u.a aVar) {
        Bitmap bitmap;
        Notification.Builder builder;
        int i2;
        int i3;
        Bitmap bitmap2;
        Bitmap decodeResource;
        String packageName = context.getPackageName();
        String title = insideNotificationItem.getTitle();
        String content = insideNotificationItem.getContent();
        int i4 = context.getApplicationInfo().icon;
        boolean isShowTime = insideNotificationItem.isShowTime();
        AudioManager audioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        int defaultNotifyIcon = NotifyUtil.getNotifyDataAdapter(context).getDefaultNotifyIcon();
        if (list == null || list.isEmpty()) {
            bitmap = null;
        } else {
            bitmap = list.get(0);
            if (bitmap != null && defaultNotifyIcon > 0 && (decodeResource = BitmapFactory.decodeResource(context.getResources(), defaultNotifyIcon)) != null) {
                int width = decodeResource.getWidth();
                int height = decodeResource.getHeight();
                decodeResource.recycle();
                bitmap = C1377d.m993a(bitmap, width, height);
            }
        }
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new Notification.Builder(context, PRIMARY_CHANNEL);
            if (defaultNotifyIcon > 0) {
                bundle.putInt("vivo.summaryIconRes", defaultNotifyIcon);
            }
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        } else {
            builder = new Notification.Builder(context);
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
        }
        if (C1313a.m810a().m815e().mo873m().isOpenMultiUser()) {
            bundle.putInt(USER_ID, C1395v.m1053a());
        }
        bundle.putInt(EXTRA_VPUSH_TYPE, 1);
        bundle.putLong(PUSH_ID, j);
        builder.setExtras(bundle);
        int defaultSmallIconId = NotifyUtil.getNotifyDataAdapter(context).getDefaultSmallIconId();
        if (defaultSmallIconId > 0) {
            i4 = defaultSmallIconId;
        }
        builder.setSmallIcon(i4);
        if (insideNotificationItem.getCompatibleType() != 1) {
            builder.setContentTitle(title);
        }
        builder.setPriority(2);
        builder.setContentText(content);
        builder.setWhen(isShowTime ? System.currentTimeMillis() : 0L);
        builder.setShowWhen(isShowTime);
        builder.setTicker(title);
        int ringerMode = audioManager.getRingerMode();
        int notifyType = insideNotificationItem.getNotifyType();
        if (notifyType != 2) {
            if (notifyType != 3) {
                if (notifyType == 4) {
                    if (ringerMode == 2) {
                        builder.setDefaults(3);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else if (ringerMode == 1) {
                        builder.setDefaults(2);
                        builder.setVibrate(new long[]{0, 100, 200, 300});
                    } else {
                        i2 = 1;
                    }
                }
            } else if (ringerMode == 2) {
                builder.setDefaults(2);
                builder.setVibrate(new long[]{0, 100, 200, 300});
            }
            i2 = 1;
        } else {
            if (ringerMode == 2) {
                i2 = 1;
                builder.setDefaults(1);
            }
            i2 = 1;
        }
        if (list == null || list.size() <= i2) {
            i3 = i;
            bitmap2 = null;
        } else {
            bitmap2 = list.get(i2);
            i3 = i;
        }
        if (i3 != i2) {
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(title);
            bigTextStyle.bigText(content);
            builder.setStyle(bigTextStyle);
        }
        if (bitmap2 != null) {
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
            bigPictureStyle.setBigContentTitle(title);
            bigPictureStyle.setSummaryText(content);
            bigPictureStyle.bigPicture(bitmap2);
            builder.setStyle(bigPictureStyle);
        }
        builder.setAutoCancel(true);
        C1382i c1382i = new C1382i();
        Intent m977a = c1382i.m977a(context, packageName, j, insideNotificationItem, notifyArriveCallbackByUser);
        if (m977a != null) {
            if (isPullService()) {
                builder.setContentIntent(PendingIntent.getService(context, (int) SystemClock.uptimeMillis(), AbstractC1375b.m972a(context, packageName, j, m977a, insideNotificationItem), 201326592));
            } else {
                new C1219p(packageName, j, insideNotificationItem).m1068b(m977a);
                builder.setContentIntent(c1382i.mo975a(context, m977a));
            }
            Notification build = builder.build();
            int m795j = C1306m.m762a().m795j();
            NotificationManager notificationManager = sNotificationManager;
            if (notificationManager != null) {
                try {
                    if (m795j == 0) {
                        notificationManager.notify(sNotifyId, build);
                        if (aVar != null) {
                            aVar.mo735a();
                            return;
                        }
                        return;
                    }
                    if (m795j == 1) {
                        notificationManager.notify((int) j, build);
                        if (aVar != null) {
                            aVar.mo735a();
                            return;
                        }
                        return;
                    }
                    C1393t.m1034a(TAG, "unknow notify style ".concat(String.valueOf(m795j)));
                    return;
                } catch (Exception e) {
                    C1393t.m1036a(TAG, e);
                    if (aVar != null) {
                        aVar.mo736b();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        C1393t.m1034a(TAG, "make notify intent error  ");
    }

    public static boolean repealNotifyById(Context context, long j) {
        int m795j = C1306m.m762a().m795j();
        if (m795j != 0) {
            if (m795j == 1) {
                return cancelNotify(context, (int) j);
            }
            C1393t.m1034a(TAG, "unknow cancle notify style ".concat(String.valueOf(m795j)));
            return false;
        }
        long m988b = C1369ad.m941c().m988b("com.vivo.push.notify_key", -1L);
        if (m988b == j) {
            C1393t.m1048d(TAG, "undo showed message ".concat(String.valueOf(j)));
            C1393t.m1038a(context, "回收已展示的通知： ".concat(String.valueOf(j)));
            return cancelNotify(context, sNotifyId);
        }
        C1393t.m1048d(TAG, "current showing message id " + m988b + " not match " + j);
        C1393t.m1038a(context, "与已展示的通知" + m988b + "与待回收的通知" + j + "不匹配");
        return false;
    }

    private static boolean cancelNotify(Context context, int i) {
        initAdapter(context);
        NotificationManager notificationManager = sNotificationManager;
        if (notificationManager == null) {
            return false;
        }
        notificationManager.cancel(i);
        return true;
    }

    public static void cancelNotify(Context context) {
        cancelNotify(context, sNotifyId);
    }

    public static void setNotifyId(int i) {
        sNotifyId = i;
    }

    private static boolean isZh(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    private static boolean isPullService() {
        return C1386m.f703a ? Build.VERSION.SDK_INT < 31 : Build.VERSION.SDK_INT < 28;
    }
}
