package com.bytedance.notification.interfaze;

import android.content.Context;
import com.bytedance.notification.supporter.service.IIconFileService;
import com.bytedance.notification.supporter.service.IImageDownloadService;
import com.bytedance.notification.supporter.service.INotificationClearService;
import com.bytedance.notification.supporter.service.INotificationClickService;
import com.bytedance.notification.supporter.service.INotificationCompliance;
import com.bytedance.notification.supporter.service.INotificationReminderService;
import com.bytedance.notification.supporter.service.INotificationStyleService;
import com.bytedance.notification.supporter.service.ISystemService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ISupporter {
    IIconFileService getIconFileService(Context context);

    IImageDownloadService getImageDownloadService();

    INotificationClearService getNotificationClearService();

    INotificationClickService getNotificationClickService();

    INotificationCompliance getNotificationCompliance();

    INotificationReminderService getNotificationReminderService(Context context);

    INotificationStyleService getNotificationStyleService();

    ISystemService getSystemService();

    void onBannerNotificationShow(long j, boolean z, String str, String str2);
}
