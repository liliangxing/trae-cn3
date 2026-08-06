package com.bytedance.notification.interfaze;

import android.app.PendingIntent;
import android.content.Context;

/* loaded from: classes4.dex */
public interface IBannerNotification {
    PendingIntent getFullScreenIntent(Context context);

    void showBannerNotification(String str, int i);
}
