package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.depths.RiskDeviceFilterConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class GoogleCustomSysDialogConfig {
    public static int ACTIVITY_DIALOG_MODE = 4;
    public static int ACTIVITY_TOAST_DIALOG_MODE = 8;
    public static int DIALOG_HALF_SCREEN_TOAST_DIALOG_MODE = 1;
    public static int PART_TOAST_DIALOG_MODE = 2;

    @SerializedName("add_top_padding_for_radius")
    public boolean addTopPaddingForRadius;

    @SerializedName("adjust_sys_dialog_background_color")
    public String adjustSysDialogBackgroundColor;

    @SerializedName("agree_button_is_in_vertical_bottom")
    public boolean agreeButtonIsInVerticalBottom;

    @SerializedName("agree_button_text")
    public Map<String, String> agreeButtonText;

    @SerializedName("agree_button_text_for_orientation")
    public Map<String, String> agreeButtonTextForOrientation;

    @SerializedName("color_os_dialog_style")
    public int colorOsDialogStyle;

    @SerializedName("detect_notification_status_interval")
    public long detectNotificationStatusInterval;

    @SerializedName("detect_notification_status_timeout")
    public long detectNotificationStatusTimeout;

    @SerializedName("dialog_ability_type")
    public String dialogAbilityType;

    @SerializedName("dim_amount")
    public float dimAmount;

    @SerializedName("disable_set_trusted_overlay")
    public boolean disableSetTrustedOverlay;

    @SerializedName("enable_agree_button_radius")
    public boolean enableAgreeButtonRadius;

    @SerializedName("expand_bottom_empty_area")
    public boolean expandBottomEmptyArea;

    @SerializedName("expand_top_empty_area")
    public boolean expandTopEmptyArea;

    @SerializedName("extra_config")
    public String extraConfig;

    @SerializedName("is_valid_settings")
    public boolean isValidSettings;

    @SerializedName("kill_sys_dialog_depend_notification_opened")
    public boolean killSysDialogDependNotificationOpened;

    @SerializedName("rs_config")
    public RiskDeviceFilterConfig mRiskConfig;

    @SerializedName("match_bottom_navigation_bar")
    public boolean matchBottomNavigationBar;

    @SerializedName("new_user_dialog_ability_config")
    public DialogAbilityConfig newUserDialogAbilityConfig;

    @SerializedName("old_user_dialog_ability_config")
    public DialogAbilityConfig oldUserDialogAbilityConfig;

    @SerializedName("reject_button_text")
    public Map<String, String> rejectButtonText;

    @SerializedName("reject_button_text_for_orientation")
    public Map<String, String> rejectButtonTextForOrientation;

    @SerializedName("support_dark_mode")
    public boolean supportDarkMode;

    @SerializedName("toast_max_security_patch")
    public String toastMaxSecurityPatch;
    public static int FULL_SCREEN_TOAST_DIALOG_MODE = 16;
    public static List<Integer> screenToastDialogMode = Arrays.asList(1, Integer.valueOf(FULL_SCREEN_TOAST_DIALOG_MODE));
    public static int DIALOG_MODE_TOAST = 27;
    public static int BACK_BY_FINISH_SELF = 1;
    public static int BACK_BY_HELPER_ACTIVITY = 2;

    @SerializedName("activity_state_update_timeout")
    public long activityStateUpdateTimeout = 300;

    @SerializedName("sys_dialog_enter_anim_duration")
    public long sysDialogEnterAnimDuration = 250;

    @SerializedName("sys_dialog_exit_anim_duration")
    public long sysDialogExitAnimDuration = 250;

    @SerializedName("toast_dialog_interval")
    public int toastDialogInterval = 30000;

    @SerializedName("dismiss_after_outside_click")
    public boolean dismissAfterOutSideClick = false;

    @SerializedName("ts_dialog_max_show_time")
    public long toastDialogMaxShowTime = 12000;

    @SerializedName("set_trusted_overlay_times")
    public long setTrustedOverlayTimes = 10;

    @SerializedName("tips_text")
    public String tipsText = "通知类型可前往App内通知设置页设置";

    @SerializedName("disable_custom_dialog_after_user_click_sys_reject")
    public boolean disableCustomDialogAfterUserClickSysReject = true;

    @SerializedName("disable_custom_dialog_after_sys_dialog_show_failed")
    public boolean disableCustomDialogAfterSysDialogShowFailed = true;

    /* loaded from: classes4.dex */
    public static class DialogAbilityConfig {

        @SerializedName("add_x_to_dialog")
        public boolean addXToDialog;

        @SerializedName("dialog_mode")
        public int dialogMode = GoogleCustomSysDialogConfig.PART_TOAST_DIALOG_MODE;

        @SerializedName("back_mode")
        public int backMode = GoogleCustomSysDialogConfig.BACK_BY_FINISH_SELF;
    }
}
