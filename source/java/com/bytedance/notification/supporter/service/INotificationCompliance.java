package com.bytedance.notification.supporter.service;

import android.content.Context;
import com.bytedance.android.service.manager.push.notification.NotificationBody;

/* loaded from: classes4.dex */
public interface INotificationCompliance {
    int check(Context context, NotificationBody notificationBody);
}
