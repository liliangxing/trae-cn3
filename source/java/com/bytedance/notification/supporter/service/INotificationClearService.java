package com.bytedance.notification.supporter.service;

import android.service.notification.StatusBarNotification;

/* loaded from: classes4.dex */
public interface INotificationClearService {
    void clearSomeNotifications();

    boolean isRankerNotification(StatusBarNotification statusBarNotification);
}
