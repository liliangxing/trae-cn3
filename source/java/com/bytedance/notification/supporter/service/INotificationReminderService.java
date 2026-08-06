package com.bytedance.notification.supporter.service;

import android.app.Notification;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.interfaze.INotificationShowListener;

/* loaded from: classes4.dex */
public interface INotificationReminderService {
    void showNotificationWithReminder(long j, PushNotificationExtra pushNotificationExtra, Notification notification, INotificationShowListener iNotificationShowListener);
}
