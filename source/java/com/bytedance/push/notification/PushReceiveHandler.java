package com.bytedance.push.notification;

import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.img.ImageDownloader;
import com.bytedance.push.interfaze.ICustomNotificationBuilder;
import com.bytedance.push.interfaze.IPushMsgShowInterceptor;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushReceiveHandler extends AbsPushReceiveHandler {
    private final IPushMsgShowInterceptor mPushShowInterceptor;
    private final MsgRevoker msgRevoker;

    public PushReceiveHandler(ICustomNotificationBuilder iCustomNotificationBuilder, IPushMsgShowInterceptor iPushMsgShowInterceptor, ImageDownloader imageDownloader) {
        super(iCustomNotificationBuilder, new AsyncImageDownloadWrapper(imageDownloader));
        this.mPushShowInterceptor = iPushMsgShowInterceptor;
        this.msgRevoker = new MsgRevoker(iPushMsgShowInterceptor);
        PushServiceManager.get().getIPushNotificationService().setAsyncImageDownloader(this.mImageDownloader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.push.notification.AbsPushReceiveHandler
    public void onReceivePushMsg(Context context, int i, PushBody pushBody, boolean z, long j) {
        boolean tryRevoke = this.msgRevoker.tryRevoke(context, i, pushBody);
        if (!tryRevoke) {
            PushSupporter.get().getPushRedbadgeManager().onReceivePushRedbadge(pushBody.badge);
            if (PushServiceManager.get().getIPushNotificationService().tryShowPushNotification(context, getPushIntent(context, i, pushBody), pushBody.convertToNotificationBody())) {
                return;
            }
        }
        PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().onMessageShow(pushBody.f84id, j);
        IPushMsgShowInterceptor iPushMsgShowInterceptor = this.mPushShowInterceptor;
        if (iPushMsgShowInterceptor != null && !tryRevoke && !z) {
            tryRevoke = iPushMsgShowInterceptor.onReceivePassThoughMsg(context, i, pushBody);
        }
        if (tryRevoke) {
            return;
        }
        super.onReceivePushMsg(context, i, pushBody, z, j);
    }

    @Override // com.bytedance.push.notification.AbsPushReceiveHandler
    public Intent getPushIntent(Context context, int i, PushBody pushBody) {
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) (((PushOnlineSettings) SettingsManager.obtain(context.getApplicationContext(), PushOnlineSettings.class)).passThoughUseNewActivity() ? PassThoughActivity.class : PushActivity.class));
        intent.putExtra("push_body", pushBody.getOriginData());
        intent.putExtra("from_notification", true);
        intent.putExtra("message_from", i);
        intent.addFlags(268435456);
        return intent;
    }
}
