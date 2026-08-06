package com.bytedance.push.settings.notification;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class ClearNotificationSettingsModel {

    @SerializedName("enable_notification_clear")
    public boolean enableNotificationClear = false;

    @SerializedName("clear_all_notification_after_launch")
    public boolean clearAllNotificationAfterLaunch = false;
}
