package com.bytedance.notification.banner;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.notification.activity.BannerActivity;
import com.bytedance.notification.activity.PushBannerActivity;
import com.bytedance.notification.activity.SmpBannerActivity;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.helper.BannerActivityHelper;
import com.bytedance.notification.supporter.PushNotificationSupporter;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WindowBannerNotification extends AbsBannerNotification {
    private final long MIN_PROCESS_ALIVE_DURATION_FOR_BANNER_IN_MILL;

    @Override // com.bytedance.notification.banner.AbsBannerNotification
    public void handleMessage(Message message) {
    }

    public WindowBannerNotification(Context context, Notification.Builder builder, Intent intent, PushNotificationExtra pushNotificationExtra, NotificationBody notificationBody) {
        super(context, builder, intent, pushNotificationExtra, notificationBody);
        this.MIN_PROCESS_ALIVE_DURATION_FOR_BANNER_IN_MILL = OnlineTracing.DATA_TIMEOUT;
    }

    @Override // com.bytedance.notification.banner.AbsBannerNotification
    protected void dismissBanner(boolean z, int i) {
        Log.d("BannerActivityTag", "dismissBanner");
        WeakReference<BannerActivity> bannerActivityRef = BannerActivityHelper.getInstance().getBannerActivityRef();
        if (bannerActivityRef != null) {
            BannerActivity bannerActivity = bannerActivityRef.get();
            if (bannerActivity != null) {
                bannerActivity.finishSelf(z, i);
                return;
            } else {
                Log.d("BannerActivityTag", "bannerActivity is null, can't dismissBanner");
                return;
            }
        }
        Log.d("BannerActivityTag", "bannerActivityRef is null, can't dismissBanner");
    }

    @Override // com.bytedance.notification.banner.AbsBannerNotification, com.bytedance.notification.interfaze.IBannerNotification
    public void showBannerNotification(String str, int i) {
        super.showBannerNotification(str, i);
    }

    @Override // com.bytedance.notification.interfaze.IBannerNotification
    public PendingIntent getFullScreenIntent(Context context) {
        Class cls;
        if (!PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIsDebugMode) {
            if (System.currentTimeMillis() - PushCommonSupport.getInstance().getPushConfigurationService().getCurProcessStartTimeStamp() < OnlineTracing.DATA_TIMEOUT || !AppStatusObserverForChildProcess.sIsInBackGround()) {
                PushNotificationSupporter.get().onBannerNotificationShow(this.mNotificationBody.id, false, "background", "pre");
                Logger.m268d("WindowBannerNotification", "not show banner because cur is in foreground");
                return null;
            }
        } else {
            Logger.m268d("WindowBannerNotification", "cur is debug mode,not filter");
        }
        if (PushNotificationSupporter.get().getSystemService().curScreenIsOff()) {
            PushNotificationSupporter.get().onBannerNotificationShow(this.mNotificationBody.id, false, ISignalReportConstants.KEY_SCREEN_STATUS_SCREEN_OFF, "pre");
            Logger.m268d("WindowBannerNotification", "not show banner because cur screen is off");
            return null;
        }
        if (BannerActivityHelper.getInstance().isShowing()) {
            PushNotificationSupporter.get().onBannerNotificationShow(this.mNotificationBody.id, false, "is_showing", "pre");
            Logger.m268d("WindowBannerNotification", "not show banner because cur is showing");
            return null;
        }
        if (ToolUtils.isMainProcess(context)) {
            cls = BannerActivity.class;
            BannerActivity.setBannerView(this.mBannerView, this.mMarginTop, (long) (this.mPushNotificationExtra.mBannerShowDuration * 1000.0d), this.mNotificationBody.id);
        } else if (ToolUtils.isSmpProcess(context)) {
            cls = SmpBannerActivity.class;
            SmpBannerActivity.setBannerView(this.mBannerView, this.mMarginTop, (long) (this.mPushNotificationExtra.mBannerShowDuration * 1000.0d), this.mNotificationBody.id);
        } else if (ToolUtils.isMessageProcess(context)) {
            cls = PushBannerActivity.class;
            PushBannerActivity.setBannerView(this.mBannerView, this.mMarginTop, (long) (this.mPushNotificationExtra.mBannerShowDuration * 1000.0d), this.mNotificationBody.id);
        } else {
            cls = null;
        }
        Logger.m268d("WindowBannerNotification", "try show banner, cur process is " + ToolUtils.getCurProcessNameSuffix(context) + " targetClass is " + cls);
        if (cls == null) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) cls);
        intent.setFlags(268435456);
        PushNotificationSupporter.get().onBannerNotificationShow(this.mNotificationBody.id, true, "success", "pre");
        return PendingIntent.getActivity(context, 0, intent, 201326592);
    }
}
