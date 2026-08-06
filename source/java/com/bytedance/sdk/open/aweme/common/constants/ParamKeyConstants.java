package com.bytedance.sdk.open.aweme.common.constants;

/* loaded from: classes5.dex */
public interface ParamKeyConstants {
    public static final int AUTH_REQUEST_CODE = 100;
    public static final String AWEME_EXTRA_LUNA_MUSIC_ID = "AWEME_EXTRA_LUNA_MUSIC_ID";
    public static final String AWEME_EXTRA_MEDIA_MESSAGE_IMAGE_PATH = "AWEME_EXTRA_IMAGE_MESSAGE_PATH";
    public static final String AWEME_EXTRA_MEDIA_MESSAGE_MIX_PATH = "AWEME_EXTRA_MIX_MESSAGE_PATH";
    public static final String AWEME_EXTRA_MEDIA_MESSAGE_VIDEO_PATH = "AWEME_EXTRA_VIDEO_MESSAGE_PATH";
    public static final int COMMON_ABILITY_CODE = 104;
    public static final String DOUYIN_HOTSOON_PACKAGE_NAME = "com.ss.android.ugc.live";
    public static final String DOUYIN_LITE_PACKAGE_NAME = "com.ss.android.ugc.aweme.lite";
    public static final String DOUYIN_PACKAGE_NAME = "com.ss.android.ugc.aweme";
    public static final String META_PLATFORM_SDK_VERSION = "BD_PLATFORM_SDK_VERSION";
    public static final int META_PLATFORM_SDK_VERSION_ERROR = -1;
    public static final String OAUTH_PATH = "/oauth/authorize/";
    public static final int OPEN_RECORD_CODE = 102;
    public static final String REDIRECT_URL_PATH = "/oauth/authorize/callback/";
    public static final int SHARE_CODE = 103;
    public static final int SHARE_TO_IM_CODE = 101;

    /* loaded from: classes5.dex */
    public interface AuthParams {
        public static final String AUTH_CODE = "_bytedance_params_authcode";
        public static final String AUTH_COMMENT_ID = "_bytedance_params_auth_comment_id";
        public static final String AUTH_MASK_PHONE = "_bytedance_params_auth_mask_phone";
        public static final String AUTH_THIRD_APP_TICKET = "_bytedance_params_auth_ticket";
        public static final String CLIENT_KEY = "_bytedance_params_client_key";
        public static final String EXTRA_AUTH_NOT_SKIP_CONFIRM = "not_skip_confirm";
        public static final String EXTRA_AUTH_SHOW_SWITCH_ACCOUNT_DIALOG = "show_switch_account_dialog";
        public static final String GRANTED_PERMISSION = "_bytedance_params_granted_permission";
        public static final String IS_OTHER_ACCOUNT_AUTH = "is_other_account_auth";
        public static final String IS_SKIP_UI_IN_THIRD_AUTH = "_bytedance_params_is_skip_ui_in_third_auth";
        public static final String OPTIONAL_SCOPE0 = "_bytedance_params_optional_scope0";
        public static final String OPTIONAL_SCOPE1 = "_bytedance_params_optional_scope1";
        public static final String REDIRECT_URI = "_bytedance_params_redirect_uri";
        public static final String SCOPE = "_bytedance_params_scope";
        public static final String STATE = "_bytedance_params_state";
        public static final String THIRD_AUTH_NOT_SHOW_LOADING = "third_auth_not_show_loading";
        public static final String THIRD_AUTH_SCENE = "_bytedance_params_third_auth_scene";
        public static final String VERIFY_SCOPE = "_aweme_params_verify_scope";
        public static final String WAP_REQUESETED_ORIENTATION = "wap_requested_orientation";
    }

    /* loaded from: classes5.dex */
    public interface BaseParams {
        public static final String CALLER_BASE_OPEN_SDK_COMMON_NAME = "_aweme_params_caller_open_sdk_common_name";
        public static final String CALLER_BASE_OPEN_SDK_COMMON_VERSION = "_aweme_params_caller_open_sdk_common_version";
        public static final String CALLER_BASE_OPEN_SDK_NAME = "_aweme_params_caller_open_sdk_name";
        public static final String CALLER_BASE_OPEN_SDK_VERSION = "_aweme_params_caller_open_sdk_version";
        public static final String CALLER_BASE_OPEN_VERSION = "__bytedance_base_caller_version";
        public static final String CALLER_PKG = "_bytedance_params_type_caller_package";
        public static final String ERROR_CODE = "_bytedance_params_error_code";
        public static final String ERROR_MSG = "_bytedance_params_error_msg";
        public static final String EXTRA = "_bytedance_params_extra";
        public static final String FROM_ENTRY = "_bytedance_params_from_entry";
        public static final String MEDIA_CONTENT_TYPE = "_aweme_open_sdk_params_media_content_type";
        public static final String MEDIA_CONTENT_VERSION = "_aweme_open_sdk_params_media_content_version";
        public static final String SDK_LAUNCH_TIME = "_aweme_open_sdk_params_sdk_launch_time";
        public static final String TYPE = "_bytedance_params_type";
    }

    /* loaded from: classes5.dex */
    public interface CommonAbilityParam {
        public static final String CALLER_PKG = "_aweme_open_sdk_params_ability_caller_package";
        public static final String CALLER_SDK_VERSION = "_aweme_open_sdk_params__ability_caller_sdk_version";
        public static final String CLIENT_KEY = "_aweme_open_sdk_params_ability_client_key";
        public static final String DATA = "__aweme_open_sdk_params_ability_data";
        public static final String SCOPES = "__aweme_open_sdk_params_ability_scops";
        public static final String STATE = "_aweme_open_sdk_params_ability_state";
        public static final String TYPE = "__aweme_open_sdk_params_ability_type";
    }

    /* loaded from: classes5.dex */
    public interface REQUIRED_API_VERSION {
        public static final int MIN_SDK_NEW_VERSION_API = 3;
    }

    /* loaded from: classes5.dex */
    public interface SdkVersion {
        public static final String VERSION = "1";
    }

    /* loaded from: classes5.dex */
    public interface ShareParams {
        public static final String CALLER_LOCAL_ENTRY = "_aweme_open_sdk_params_caller_local_entry";
        public static final String CALLER_PKG = "_aweme_open_sdk_params_caller_package";
        public static final String CALLER_SDK_VERSION = "_aweme_open_sdk_params_caller_sdk_version";
        public static final String CLIENT_KEY = "_aweme_open_sdk_params_client_key";
        public static final String ERROR_CODE = "_aweme_open_sdk_params_error_code";
        public static final String ERROR_MSG = "_aweme_open_sdk_params_error_msg";
        public static final String SHARE_ANCHOR_INFO = "_aweme_open_sdk_params_anchor_info";
        public static final String SHARE_AWEME_VIDEO_ID = "_aweme_open_sdk_params_share_aweme_video_id";
        public static final String SHARE_CUSTOM_STICKER_LIST = "_aweme_open_sdk_params_share_sticker_custom_list";
        public static final String SHARE_DAILY_BG_BASE_COLOR = "_aweme_open_sdk_params_share_dialy_bg_base_color";
        public static final String SHARE_DAILY_BG_COMPLEMENTARY_COLOR = "_aweme_open_sdk_params_share_dialy_bg_complementary_color";
        public static final String SHARE_DAILY_BG_URL = "_aweme_open_sdk_params_share_dialy_bg_url";
        public static final String SHARE_DAILY_H5_PATH = "_aweme_open_sdk_params_share_daily_h5_path";
        public static final String SHARE_DAILY_SCALE = "_aweme_open_sdk_params_daily_scale";
        public static final String SHARE_DEFAULT_HASHTAG = "_aweme_open_sdk_params_target_scene";
        public static final String SHARE_HASHTAG_LIST = "_aweme_open_sdk_params_hashtag_list";
        public static final String SHARE_HASHTAG_STICKER_LIST = "_aweme_open_sdk_params_share_sticker_hashtag_list";
        public static final String SHARE_IMAGE_ALBUM = "_aweme_open_sdk_params_image_album";
        public static final String SHARE_MENTION_STICKER_LIST = "_aweme_open_sdk_params_share_sticker_mention_list";
        public static final String SHARE_MICROAPP_INFO = "_aweme_open_sdk_params_micro_app_info";
        public static final String SHARE_MUSIC_ID = "_aweme_open_sdk_params_share_music_id";
        public static final String SHARE_MUSIC_START = "_aweme_open_sdk_params_share_music_start";
        public static final String SHARE_NEW_SAHRE = "_aweme_open_sdk_params_share_new_share";
        public static final String SHARE_POI_ID = "_aweme_open_sdk_params_share_poi_id";
        public static final String SHARE_POI_STICKER = "_aweme_open_sdk_params_share_sticker_poi";
        public static final String SHARE_QUICK_FLASH_STICKER = "_aweme_open_sdk_params_share_sticker_quick_flash";
        public static final String SHARE_SKIP_PRE_CHECK = "_aweme_open_sdk_params_skip_pre_check";
        public static final String SHARE_SUB_ERROR_CODE = "_aweme_open_sdk_params_sub_error_code";
        public static final String SHARE_TARGET_SCENE = "_aweme_open_sdk_params_target_landpage_scene";
        public static final String SHARE_TITLE = "_aweme_open_sdk_params_share_title";
        public static final String SHARE_TITLE_HASHTAG_LIST = "_aweme_open_sdk_params_share_title_hashtag_list";
        public static final String SHARE_TITLE_MENTION_LIST = "_aweme_open_sdk_params_share_title_mention_list";
        public static final String SHARE_TO_TYPE = "_aweme_open_sdk_params_share_to_type";
        public static final String STATE = "_aweme_open_sdk_params_state";
        public static final String TYPE = "_aweme_open_sdk_params_type";
    }

    /* loaded from: classes5.dex */
    public interface ShareTargetScene {
        public static final int LANDPAGE_SCENE_DEFAULT = 0;
        public static final int LANDPAGE_SCENE_EDIT = 1;
        public static final int LANDPAGE_SCENE_PUBLISH = 2;
    }

    /* loaded from: classes5.dex */
    public interface TargetSceneType {
        public static final int LANDPAGE_SCENE_CUT = 2;
        public static final int LANDPAGE_SCENE_DEFAULT = 0;
        public static final int LANDPAGE_SCENE_EDIT = 1;
    }

    /* loaded from: classes5.dex */
    public interface WebViewConstants {
        public static final String COMMENT_ID = "comment_id";
        public static final String ENTER_FROM = "enter_from";
        public static final String IS_OTHER_ACCOUNT_LOGIN = "is_other_account_auth";
        public static final String IS_WIFI = "is_wifi";
        public static final String LIVE_ENTER_FROM_KEY = "live_enter_from";
        public static final String QUERY_CLIENT_KEY = "client_key";
        public static final String QUERY_ENCRIPTION_PACKAGE = "app_identity";
        public static final String QUERY_FROM = "from";
        public static final String QUERY_OPTIONAL_SCOPE = "optionalScope";
        public static final String QUERY_PLATFORM = "device_platform";
        public static final String QUERY_REDIRECT_URI = "redirect_uri";
        public static final String QUERY_RESPONSE_TYPE = "response_type";
        public static final String QUERY_SCOPE = "scope";
        public static final String QUERY_SIGNATURE = "signature";
        public static final String QUERY_STATE = "state";
        public static final String REDIRECT_QUERY_CODE = "code";
        public static final String REDIRECT_QUERY_ERROR_CODE = "errCode";
        public static final String REDIRECT_QUERY_SCOPE = "scopes";
        public static final String REDIRECT_QUERY_STATE = "state";
        public static final String SCHEMA_HTTP = "http";
        public static final String SCHEMA_HTTPS = "https";
        public static final String VALUE_FROM_OPENSDK = "opensdk";
        public static final String VALUE_RESPONSE_TYPE_CODE = "code";
    }
}
