package com.bytedance.ug.sdk.deeplink.settings;

/* loaded from: classes4.dex */
public class SettingsConstant {
    static final String BASE_URL = "https://zlink.ugsdk.cn/";
    static final long DEFAULT_APP_LINK_INTERVAL = 1000;
    static final long DEFAULT_CLIPBOARD_VERIFY_TIMEOUT = 0;
    static final int DEFAULT_REQUEST_TIMEOUT = 60000;
    static final long DEFAULT_ROUTER_VALID_TIME = 0;
    static final long DEFAULT_UPDATE_SETTINGS_INTERVAL = 3600;
    static final String KEY_APP_ID = "aid";
    static final String KEY_CALLER_NAME = "caller_name";
    static final String KEY_CHECK_CLIPBOARD_SWITCH = "deeplink_forbid_check_clipboard";
    public static final String KEY_CLIPBOARD_VERIFY_TIMEOUT = "clipboard_verify_timeout";
    static final String KEY_DEVICE_PRINT_SWITCH = "deeplink_enable_device_print";
    static final String KEY_DEVICE_PRINT_VERIFY_SWITCH = "deeplink_device_fingerprint_ab";
    static final String KEY_DOMAINS = "deeplink_domains";
    static final String KEY_ENABLE_SDK_MONITOR = "enable_sdk_monitor";
    static final String KEY_FISSION_TOKEN_REGEX = "deeplink_fission_patterns";
    static final String KEY_MESSAGE = "message";
    static final String KEY_REQUEST_TIMEOUT = "deeplink_timeout";
    static final String KEY_ROUTER_INFO_LIST = "deeplink_router_info";
    static final String KEY_ROUTER_SCHEME = "deeplink_router_scheme";
    static final String KEY_ROUTER_VALID_TIME = "deeplink_router_valid_time";
    static final String KEY_SDK_VERSION = "zlink_sdk_version";
    static final String KEY_SETTINGS_APP_LINK_INTERVAL = "settings_app_link_interval";
    static final String KEY_SETTINGS_LASTEST_UPDATE_TIME = "key_settings_lastest_update_time";
    static final String KEY_SETTING_DATA = "deeplink_setting_data";
    static final String KEY_UPDATE_SETTINGS_INTERVAL = "update_settings_interval";
    static final String SETTINGS_PATH_V3 = "service/settings/v3/";
    static final String SETTING_ID = "deep_link_settings_id";
    static final String STATUS_DEMOTION = "demotion";
    static final String STATUS_SUCCESS = "success";
    static final int UPDATE_SETTING_MSG = 37;
    static final String UTF_8 = "UTF-8";
    static final String VALUE_CALLER_NAME = "zlink";

    private SettingsConstant() {
    }
}
