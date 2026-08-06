package com.bytedance.sdk.open.aweme;

/* loaded from: classes5.dex */
public interface CommonConstants {
    public static final String a = "com.aweme.opensdk.action.stay.in.dy";

    /* loaded from: classes5.dex */
    public interface AuthErrorCode {
        public static final int ERROR_AUTHORIZATION_NO_PERMISSION = 10011;
        public static final int ERROR_CODE_EXPIRED = 10007;
        public static final int ERROR_CONFIG = 10003;
        public static final int ERROR_NETWORK_CONNECT_TIMEOUT = -13;
        public static final int ERROR_NETWORK_IO = -15;
        public static final int ERROR_NETWORK_NO_CONNECTION = -12;
        public static final int ERROR_NETWORK_SSL = -21;
        public static final int ERROR_NETWORK_TIMEOUT = -14;
        public static final int ERROR_NETWORK_UNKNOWN_HOST_ERROR = -16;
        public static final int ERROR_N_PARAMS = 10005;
        public static final int ERROR_PARAM = 10002;
        public static final int ERROR_REDIRECT_URL = 10006;
        public static final int ERROR_REFRESH_TOKEN = 10010;
        public static final int ERROR_SCOPE = 10004;
        public static final int ERROR_SYSTEM = 10001;
        public static final int ERROR_TICKET = 10009;
        public static final int ERROR_TOKEN = 10008;
    }

    /* loaded from: classes5.dex */
    public interface BaseErrorCode {
        public static final int ERROR_CANCEL = -2;
        public static final int ERROR_NET = -3;
        public static final int ERROR_UNKNOW = -1;
        public static final int OK = 0;
    }

    /* loaded from: classes5.dex */
    public interface ExtraParams {
        public static final String AUTH_HOST_APP = "aweme_auth_host_app";
    }

    /* loaded from: classes5.dex */
    public enum InvokeStrategy {
        AUTO,
        DOUYIN_ONLY,
        LITE_ONLY,
        HOTSOON_ONLY,
        LITE_AND_HOTSOON,
        DOUYIN_AND_HOTSOON,
        DOUYIN_AND_LITE
    }

    /* loaded from: classes5.dex */
    public interface ModeType {
        public static final int OPEN_COMMON_ABILITY_REQUEST = 9;
        public static final int OPEN_COMMON_ABILITY_RESPONSE = 10;
        public static final int OPEN_RECORD_REQUEST = 7;
        public static final int OPEN_RECORD_RESPONSE = 8;
        public static final int SEND_AUTH_REQUEST = 1;
        public static final int SEND_AUTH_RESPONSE = 2;
        public static final int SHARE_CONTENT_TO_TT = 3;
        public static final int SHARE_CONTENT_TO_TT_RESP = 4;
        public static final int SHARE_TO_CONTACTS = 5;
        public static final int SHARE_TO_CONTACT_RESP = 6;
    }

    /* loaded from: classes5.dex */
    public interface SDKErrorCode {
        public static final int CLIENT_CODE_ERROR = 41001;
        public static final int CLIENT_TICKET_ERROR = 41002;
        public static final int NET_ERROR = 40005;
        public static final int NOT_IMPLEMENT_SERVICE = 40003;
        public static final int NOT_INIT_ERROR = 40002;
        public static final int PARAM_ERROR = 40004;
        public static final int UNKNOWN_ERROR = 40001;
    }

    /* loaded from: classes5.dex */
    public interface SUPPORT {
        public static final int AUTH = 1;
        public static final int COMMON_ABILITY = 5;
        public static final int OPEN_RECORD = 4;
        public static final int SHARE = 2;
        public static final int SHARE_IM = 3;

        /* loaded from: classes5.dex */
        public interface AUTH_API {
            public static final int AUTH_REQUIRE_API = 1;
            public static final int AUTH_SUPPORT_DOUYIN_HOT_SOON = Integer.MAX_VALUE;
            public static final int AUTH_SUPPORT_DOUYIN_LITE = 10;
            public static final int AUTH_SUPPORT_SWITCH_ACCOUNT = 9;
            public static final int VERIFY_REQUIRE_API = 6;
        }

        /* loaded from: classes5.dex */
        public interface COMMON_API {
            public static final int COMMON_TYPE_JUMP_IM = 1;
            public static final int COMMON_TYPE_JUMP_PRODUCTION = 2;
            public static final int COMMON_TYPE_JUMP_PROFILE = 1;
        }

        /* loaded from: classes5.dex */
        public interface CONTACT_API {
            public static final int CONTACT_SUPPORT_IMAGE_HTML = 1;
            public static final int CONTACT_SUPPORT_INVITE_BULLET_CARD = 4;
            public static final int CONTACT_SUPPORT_INVITE_CARD = 2;
            public static final int CONTACT_SUPPORT_MICRO_APP = 5;
            public static final int CONTACT_SUPPORT_UNIFIED_JOIN_GROUP = 3;
        }

        /* loaded from: classes5.dex */
        public interface OPEN_RECORD {
            public static final int OPEN_RECORD_API = 1;
        }

        /* loaded from: classes5.dex */
        public interface SHARE_API {
            public static final int SHARE_DAILY = 5;
            public static final int SHARE_DAILY_SET_BACKGROUND = 7;
            public static final int SHARE_MUSIC_TO_DAILY = 6;
            public static final int SHARE_REQUIRE_API = 10003;
            public static final int SHARE_SUPPORT_ALBUM = 2;
            public static final int SHARE_SUPPORT_FILEPROVIDER = 10007;
            public static final int SHARE_SUPPORT_LUNA_MUSIC = 3;
            public static final int SHARE_SUPPORT_MIX_CONTENT = 2;
            public static final int SHARE_SUPPORT_TO_PUBLISH = 10008;
            public static final int SHARE_SUPPORT_WITH_MUSIC = 4;
        }
    }

    /* loaded from: classes5.dex */
    public interface ShareErrorCode {
        public static final int CANCEL_LOGIN = 20004;
        public static final int CANCEL_PUBLISH = 20013;
        public static final int ERROR_CODE_AUTH_DENIED = -4;
        public static final int ERROR_CODE_SEND_FAIL = -3;
        public static final int ERROR_CODE_UNSUPPORT = -5;
        public static final int GALLERY_PERMISSION_ERROR = 20005;
        public static final int GRANT_NETWORK_ERR = 20006;
        public static final int INVALID_GRANT = 20003;
        public static final int INVALID_PHOTO = 20008;
        public static final int INVALID_VIDEO_LENGTH = 20007;
        public static final int INVALID_VIDEO_RESOLUTION = 22001;
        public static final int INVALID_VIDEO_SIZE_RATIO = 20011;
        public static final int INVALID_VIDEO_TYPE = 20012;
        public static final int LAST_PUBLISH_NOT_FINISH = 20014;
        public static final int PARSE_MEDIA_FAIL = 20010;
        public static final int PUBLISH_FAIL_UNKNOWN = 20016;
        public static final int SAVE_TO_DRAFT = 20015;
        public static final int TIME_STAMP_INVALID = 20009;
    }
}
