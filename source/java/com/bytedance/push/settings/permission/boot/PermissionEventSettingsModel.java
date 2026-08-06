package com.bytedance.push.settings.permission.boot;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PermissionEventSettingsModel {

    @SerializedName("sys_open_notification_max_time_cost")
    public final long sysOpenNotificationMaxTimeCost = 2000;

    @SerializedName("sys_dialog_show_timeout")
    public final long sysDialogShowTimeout = 2000;

    @SerializedName("jump_notification_settings_page_timeout")
    public final long jumpNotificationSettingsPageTimeout = 2000;

    @SerializedName("return_app_page_from_notification_settings_page_timeout")
    public final long returnAppPageFromNotificationSettingsPageTimeout = 10000;
}
