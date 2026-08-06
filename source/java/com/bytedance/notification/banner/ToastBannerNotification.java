package com.bytedance.notification.banner;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.common.utility.Logger;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.utils.Log;
import java.lang.reflect.Field;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ToastBannerNotification extends AbsBannerNotification {
    private final String TAG;
    private Toast mBannerToast;
    private boolean mSuccessInitToast;

    @Override // com.bytedance.notification.interfaze.IBannerNotification
    public PendingIntent getFullScreenIntent(Context context) {
        return null;
    }

    @Override // com.bytedance.notification.banner.AbsBannerNotification
    public void handleMessage(Message message) {
        Toast toast;
        if (message.what != 3111802 || (toast = this.mBannerToast) == null) {
            return;
        }
        toast.cancel();
    }

    public ToastBannerNotification(Context context, Notification.Builder builder, Intent intent, PushNotificationExtra pushNotificationExtra, NotificationBody notificationBody) {
        super(context, builder, intent, pushNotificationExtra, notificationBody);
        this.TAG = "ToastBannerNotification";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initToast() {
        try {
            this.mBannerToast.setGravity(49, 0, this.mMarginTop);
            this.mBannerToast.setView(this.mBannerView);
            try {
                Object field = getField(this.mBannerToast, "mTN");
                if (field != null) {
                    Object field2 = getField(field, "mParams");
                    if (field2 instanceof WindowManager.LayoutParams) {
                        ((WindowManager.LayoutParams) field2).flags = 136;
                    }
                }
            } catch (Throwable unused) {
                Log.m148d("ToastBannerNotification", "initToast: reflection failure");
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private Object getField(Object obj, String str) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    @Override // com.bytedance.notification.banner.AbsBannerNotification, com.bytedance.notification.interfaze.IBannerNotification
    public void showBannerNotification(String str, int i) {
        super.showBannerNotification(str, i);
        if (this.mBannerView == null) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.bytedance.notification.banner.ToastBannerNotification.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ToastBannerNotification.this.mBannerToast = new Toast(ToastBannerNotification.this.mContext);
                    ToastBannerNotification toastBannerNotification = ToastBannerNotification.this;
                    toastBannerNotification.mSuccessInitToast = toastBannerNotification.initToast();
                    if (ToastBannerNotification.this.mSuccessInitToast && ToastBannerNotification.this.mPushNotificationExtra.mBannerShowDuration > 0.0d) {
                        ToastBannerNotification.this.mBannerToast.setDuration(1);
                        ToastBannerNotification.this.mBannerToast.show();
                        ToastBannerNotification.this.mHandler.sendEmptyMessageDelayed(3111802, (long) (ToastBannerNotification.this.mPushNotificationExtra.mBannerShowDuration * 1000.0d));
                    }
                } catch (Throwable th) {
                    Logger.e("ToastBannerNotification", th.getMessage());
                }
            }
        });
    }

    @Override // com.bytedance.notification.banner.AbsBannerNotification
    public void dismissBanner(boolean z, int i) {
        Toast toast = this.mBannerToast;
        if (toast != null) {
            toast.cancel();
        }
    }
}
