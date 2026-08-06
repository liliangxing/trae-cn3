package com.bytedance.push.settings.permission.boot;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class ItemBusinessCustomSysDialogConfig {
    public static final long DEFAULT_LOOP_DETECT_USER_CLICK_INTERVAL_IN_MILL = 20;
    public static int DIALOG_MODE_ACTIVITY = 1;
    public static int DIALOG_MODE_TOAST = 2;
    public static final int USER_CLICK_DETECT_MODE_ACTIVITY_RESULT = 2;
    public static final int USER_CLICK_DETECT_MODE_ACTIVITY_TASK = 1;

    @SerializedName("dialog_mode")
    public int dialogMode = DIALOG_MODE_ACTIVITY;

    @SerializedName("agree_button_text")
    public String agreeButtonText = "允许";

    @SerializedName("reject_button_text")
    public String rejectButtonText = "禁止";

    @SerializedName("expand_bottom_empty_area")
    public boolean expandBottomEmptyArea = true;

    @SerializedName("use_new_window_flag")
    public boolean useNewWindowFlag = true;

    @SerializedName("sys_dialog_enter_anim_duration")
    public long sysDialogEnterAnimDuration = 250;

    @SerializedName("user_click_detect_mode")
    public int userClickDetectMode = 1;

    @SerializedName("loop_detect_user_click_interval_in_mill")
    public long loopDetectUserClickIntervalInMill = 20;

    @SerializedName("allow_downgrade_dialog")
    public boolean downgradeDialog = false;

    @SerializedName("toast_duration")
    public long toastDuration = 15000;
}
