package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DownloadConstants {
    public static final String ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY = "com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY";
    public static final String ACTION_DOWNLOAD_PROCESS_NOTIFY = "com.ss.android.downloader.action.PROCESS_NOTIFY";
    public static final String ACTION_RETRY = "com.ss.android.downloader.action.DOWNLOAD_WAKEUP";
    public static final String AUTO_INSTALL_WITHOUT_NOTIFICATION = "auto_install_without_notification";
    public static final long DAY = 86400000;
    public static final JSONObject EMPTY_JSON = new JSONObject();
    public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
    public static final String EXTRA_HEADER_DOWNLOAD_ID = "extra_download_id";
    public static final String EXTRA_REQUEST_HOST_IP = "ss_d_request_host_ip_114";
    public static final String EXTRA_THROTTLE_NET_SPEED = "extra_throttle_net_speed";
    public static final String EXTRA_TTNET_BACK_HOST = "extra_ttnet_back_host";
    public static final String EXTRA_TTNET_CHANGE_IP = "extra_ttnet_change_ip";
    public static final String EXTRA_TTNET_CONNECT_TIMEOUT = "extra_ttnet_connect_timeout";
    public static final String EXTRA_TTNET_IO_TIMEOUT = "extra_ttnet_io_timeout";
    public static final String EXTRA_TTNET_PROTECT_TIMEOUT = "extra_ttnet_protect_timeout";
    public static final String EXTRA_TTNET_SAVE_REDIRECT_PARTIAL_URL = "extra_ttnet_save_redirect_partial_url";
    public static final String EXTRA_TTNET_TTNET_COMMON_PARAMS = "extra_ttnet_common_param";
    public static final long GB = 1073741824;
    public static final String HOST = "Host";
    public static final long HOUR = 3600000;
    public static final int HTTP_PRECON_FAILED = 412;
    public static final int HTTP_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    public static final long KB = 1024;
    public static final String KEY_PAUSED_RESUME_COUNT = "paused_resume_count";
    public static long LIMIT_SPEED_EVERTS_ECOND = 512000;
    public static volatile String LOWER_OPPO = "";
    public static final long MB = 1048576;
    public static volatile String MIME_APK = "";
    public static final String MIME_PLG = "mime_type_plg";
    public static final String MIME_PLUGIN = "mime_type_plugin";
    public static final long MK_DIR_MIN_SPACE = 16384;
    public static int OKHTTP_SEGMENT_SIZE = 8192;
    public static final String PATH_KEY = "path";
    public static final String PAUSE_BY_NOTIFICATION = "pause_by_notification";
    public static final String QUERY_KEY = "query";
    public static final int SECOND_TO_MILLS = 1000;
    public static final String SP_ANTI_HIJACK_CONFIG = "sp_ah_config";
    public static final String SP_DOWNLOAD_CACHE = "sp_download_cache";
    public static final String SP_DOWNLOAD_INFO = "sp_download_info";
    public static final String SP_DOWNLOAD_SETTING_CACHE = "sp_download_setting_cache";
    public static final long TB = 1099511627776L;
    public static int TTNET_DEFAULT_BUFFER_SIZE = 32768;
    public static final String TTNET_REDIRECT_MSG = "ERR_TTNET_UNSUPPORTED_REDIRECT";
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_WIFI = 1;
    public static volatile String UPPER_OPPO = "";
    public static final String URL_KEY = "url";
    public static final String USER_AGENT = "User-Agent";
    public static final String VULNERABILITY_PATH = "..";

    public static void setMimeApk(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MIME_APK = str;
    }
}
