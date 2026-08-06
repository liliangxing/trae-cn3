package com.bytedance.notification.supporter;

import android.content.Context;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.interfaze.ISupporter;
import com.bytedance.notification.supporter.impl.IconFileServiceImpl;
import com.bytedance.notification.supporter.impl.ImageDownloadServiceImpl;
import com.bytedance.notification.supporter.impl.NotificationClearServiceImpl;
import com.bytedance.notification.supporter.impl.NotificationClickServiceImpl;
import com.bytedance.notification.supporter.impl.NotificationCompliance;
import com.bytedance.notification.supporter.impl.NotificationReminderServiceImpl;
import com.bytedance.notification.supporter.impl.NotificationStyleServiceImpl;
import com.bytedance.notification.supporter.impl.SystemServiceImpl;
import com.bytedance.notification.supporter.service.IIconFileService;
import com.bytedance.notification.supporter.service.IImageDownloadService;
import com.bytedance.notification.supporter.service.INotificationClearService;
import com.bytedance.notification.supporter.service.INotificationClickService;
import com.bytedance.notification.supporter.service.INotificationCompliance;
import com.bytedance.notification.supporter.service.INotificationReminderService;
import com.bytedance.notification.supporter.service.INotificationStyleService;
import com.bytedance.notification.supporter.service.ISystemService;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushNotificationSupporter extends BaseJson implements ISupporter {
    private static volatile ISupporter iSupporter;
    private volatile IIconFileService mIIconFileService;
    private volatile IImageDownloadService mIImageDownloadService;
    private volatile INotificationClearService mINotificationClearService;
    private volatile INotificationClickService mINotificationClickService;
    private volatile INotificationCompliance mINotificationCompliance;
    private volatile INotificationReminderService mINotificationReminderService;
    private volatile INotificationStyleService mINotificationStyleService;
    private volatile ISystemService mISystemService;

    private PushNotificationSupporter() {
    }

    public static ISupporter get() {
        if (iSupporter == null) {
            synchronized (PushNotificationSupporter.class) {
                if (iSupporter == null) {
                    iSupporter = new PushNotificationSupporter();
                }
            }
        }
        return iSupporter;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public IIconFileService getIconFileService(Context context) {
        if (this.mIIconFileService == null) {
            synchronized (this) {
                if (this.mIIconFileService == null) {
                    this.mIIconFileService = new IconFileServiceImpl(context);
                }
            }
        }
        return this.mIIconFileService;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public IImageDownloadService getImageDownloadService() {
        if (this.mIImageDownloadService == null) {
            synchronized (this) {
                if (this.mIImageDownloadService == null) {
                    this.mIImageDownloadService = new ImageDownloadServiceImpl();
                }
            }
        }
        return this.mIImageDownloadService;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public INotificationStyleService getNotificationStyleService() {
        if (this.mINotificationStyleService == null) {
            synchronized (this) {
                if (this.mINotificationStyleService == null) {
                    this.mINotificationStyleService = new NotificationStyleServiceImpl();
                }
            }
        }
        return this.mINotificationStyleService;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public ISystemService getSystemService() {
        if (this.mISystemService == null) {
            synchronized (this) {
                if (this.mISystemService == null) {
                    this.mISystemService = new SystemServiceImpl(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
                }
            }
        }
        return this.mISystemService;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public INotificationClickService getNotificationClickService() {
        if (this.mINotificationClickService == null) {
            synchronized (this) {
                if (this.mINotificationClickService == null) {
                    this.mINotificationClickService = new NotificationClickServiceImpl();
                }
            }
        }
        return this.mINotificationClickService;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public void onBannerNotificationShow(long j, boolean z, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "id", j);
        add(jSONObject, "result", z);
        add(jSONObject, ISignalReportConstants.KEY_REASON, str);
        add(jSONObject, "type", str2);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication));
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_banner_show", jSONObject);
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public INotificationReminderService getNotificationReminderService(Context context) {
        if (this.mINotificationReminderService == null) {
            synchronized (this) {
                if (this.mINotificationReminderService == null) {
                    this.mINotificationReminderService = new NotificationReminderServiceImpl(context);
                }
            }
        }
        return this.mINotificationReminderService;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public INotificationCompliance getNotificationCompliance() {
        if (this.mINotificationCompliance == null) {
            synchronized (this) {
                if (this.mINotificationCompliance == null) {
                    this.mINotificationCompliance = new NotificationCompliance();
                }
            }
        }
        return this.mINotificationCompliance;
    }

    @Override // com.bytedance.notification.interfaze.ISupporter
    public INotificationClearService getNotificationClearService() {
        if (this.mINotificationClearService == null) {
            synchronized (this) {
                if (this.mINotificationClearService == null) {
                    this.mINotificationClearService = new NotificationClearServiceImpl();
                }
            }
        }
        return this.mINotificationClearService;
    }
}
