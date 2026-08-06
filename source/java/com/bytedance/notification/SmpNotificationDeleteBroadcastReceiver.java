package com.bytedance.notification;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class SmpNotificationDeleteBroadcastReceiver extends NotificationDeleteBroadcastReceiver {
    @Override // com.bytedance.notification.NotificationDeleteBroadcastReceiver
    public boolean isDeleteAction(String str, Context context) {
        return TextUtils.equals(str, context.getPackageName() + NotificationDeleteBroadcastReceiver.SMP_DELETE_ACTION);
    }
}
