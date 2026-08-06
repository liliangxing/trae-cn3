package com.bytedance.push.settings.permission.boot;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.UiAdaptationUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GifSysPermissionPageSettingsModel {
    public static final int DISABLE = -1;
    public static final int DISABLE_WINDOW_TOUCHABLE_MODE_DISABLE_BY_FLAG = 1;
    public static final int DISABLE_WINDOW_TOUCHABLE_MODE_DISABLE_BY_PROXY = 2;
    public static final int ENABLE = 1;
    public static final int GIF_MODE_SHOW_HAND = 1;
    public static final int GIF_MODE_SHOW_TEXT = 2;
    public static final int SETTINGS_PAGE_OPEN_MODE_ACTIVITY_TASK = 2;
    public static final int SETTINGS_PAGE_OPEN_MODE_START_ACTIVITIES = 1;
    public static final int UNKNOWN = 0;
    public static final int WINDOW_SIZE_MODE_FULL_SCREEN = 2;
    public static final int WINDOW_SIZE_MODE_LOWER_HALF_SCREEN = 3;
    public static final int WINDOW_SIZE_MODE_WRAP_CONTENT = 1;

    @SerializedName("miui_config")
    public MiuiGifConfig miuiGifConfig;

    @SerializedName("notification_settings_uri")
    public List<String> notificationSettingsUri;
    private final long DEFAULT_MAX_DISPLAY_DURATION = 2000;
    private final long DEFAULT_DETECT_SWITCH_STATUS_INTERVAL = 300;
    private final long DEFAULT_WAIT_SYSTEM_SETTINGS_RESUME = 200;

    @SerializedName("enable_gif_permission_page")
    public int enableGifPermissionPage = 0;

    @SerializedName("wait_system_settings_resume")
    public long waitSystemSettingsResume = 200;

    @SerializedName("max_display_duration")
    public long maxDisplayDuration = 2000;

    @SerializedName("auto_dismiss_after_user_touch_screen")
    public boolean autoDismissAfterUserTouchScreen = true;

    @SerializedName("disable_window_touchable_mode")
    public int disableWindowTouchableMode = 1;

    @SerializedName("gif_mode")
    public int gifMode = 1;

    @SerializedName("window_size_mode")
    public int windowSizeMode = 1;

    @SerializedName("enable_in_landscape_mode")
    public boolean enableInLandscapeMode = false;

    @SerializedName("auto_back_after_user_open_switch")
    public boolean autoBackAfterUserOpenSwitch = false;

    @SerializedName("auto_dismiss_after_user_open_switch")
    public boolean autoDismissAfterUserOpenSwitch = false;

    @SerializedName("detect_switch_status_interval")
    public long detectSwitchStatusInterval = 300;

    @SerializedName("override_pending_transition")
    public boolean overridePendingTransition = false;

    @SerializedName("verify_window_size")
    public boolean verifyWindowSize = false;

    @SerializedName("settings_page_open_mode")
    public int notificationSettingsPageOpenMode = 1;

    public boolean isValid(Activity activity) {
        Logger.m268d("GifSysPermissionPageSettingsModel", "[isValid]");
        if (this.enableGifPermissionPage != 1) {
            Logger.m278w("GifSysPermissionPageSettingsModel", "[isValid]not valid because enableGifPermissionPage:" + this.enableGifPermissionPage);
            return false;
        }
        MiuiGifConfig miuiGifConfig = this.miuiGifConfig;
        if (miuiGifConfig == null) {
            Logger.m278w("GifSysPermissionPageSettingsModel", "[isValid]not valid because miuiGifConfig is null");
            return false;
        }
        if (!miuiGifConfig.isValid()) {
            Logger.m278w("GifSysPermissionPageSettingsModel", "[isValid]not valid because miuiGifConfig is not valid:" + GsonUtils.toJson(this.miuiGifConfig));
            return false;
        }
        if (this.verifyWindowSize) {
            Rect realRect = UiAdaptationUtils.getRealRect(activity);
            if (realRect == null) {
                Logger.m278w("GifSysPermissionPageSettingsModel", "[isValid]not valid because verifyWindowSize is true but realRect is null");
                return false;
            }
            int i = realRect.right - realRect.left;
            int i2 = realRect.bottom - realRect.top;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i3 = displayMetrics.widthPixels;
            Logger.m274i("GifSysPermissionPageSettingsModel", "[isValid]screenWidth:" + i3 + " realScreenWidth:" + i + " screenHeight:" + displayMetrics.heightPixels + " realScreenHeight:" + i2);
            if (i != i3) {
                return false;
            }
        }
        return true;
    }
}
