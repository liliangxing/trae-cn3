package com.ss.android.socialbase.appdownloader.constants;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes7.dex */
public class Constants {
    public static final String ACTION_CLICK_BTN = "android.ss.intent.action.DOWNLOAD_CLICK_BTN";
    public static final String ACTION_CLICK_CONTENT = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
    public static final String ACTION_DELETE = "android.ss.intent.action.DOWNLOAD_DELETE";
    public static final String ACTION_HIDE = "android.ss.intent.action.DOWNLOAD_HIDE";
    public static final String ACTION_OPEN = "android.ss.intent.action.DOWNLOAD_OPEN";
    public static final String ACTION_REQUEST_NOTIFICATION_PERMISSION = "android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION";
    public static final String APK_SUFFIX = ".apk";
    public static final String APP_INSTALL_FINISH = "install_finish";
    public static final String APP_INSTALL_START = "install_start";
    public static final String APP_INSTALL_START_VIEW = "install_start_view";

    @Deprecated
    public static final String AUTO_INSTALL_WITH_NOTIFICATION = "auto_install_with_notification";
    public static final String DEFAULT_USER_AGENT;
    public static final String EXTRA_APK_PACKAGE_NAME = "extra_apk_package_name";
    public static final String EXTRA_APK_VERSION_CODE = "extra_apk_version_code";
    public static final String EXTRA_FROM_NOTIFICATION = "extra_from_notification";
    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
    public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_TYPE = "extra_click_download_type";
    public static final String EXTRA_NOTIFICATION_PID = "extra_notification_pid";
    public static final String EXTRA_SILENT_INSTALL_SUCCEED = "extra_silent_install_succeed";
    public static final String INTENT = "intent";
    public static final int MAX_REDIRECTS = 5;
    public static final int MAX_RETRIES = 5;
    public static final int MAX_RETRY_AFTER = 86400;
    public static final String MIME_APK = "application/vnd.android.package-archive";
    public static final String MIME_PATCH = "application/ttpatch";
    public static final int MIN_PROGRESS_TIME = 150;
    public static final int MIN_RETRY_AFTER = 30;
    public static final int RETRY_FIRST_DELAY = 30;
    public static final String SP_APP_DOWNLOADER = "sp_appdownloader";
    public static final int START_INSTALL_STATUS = 11;

    /* loaded from: classes7.dex */
    public interface AhConstants {
        public static final String AH_EXT_JSON = "ah_ext_json";
        public static final String ANTI_CONFIG = "anti_config";
    }

    /* loaded from: classes7.dex */
    public interface NotificationAction {
        public static final String BTN_CLICK = "";
    }

    static {
        StringBuilder sb = new StringBuilder("AppDownloader");
        boolean z = !TextUtils.isEmpty(Build.VERSION.RELEASE);
        boolean z2 = !TextUtils.isEmpty(Build.ID);
        boolean z3 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        if (z) {
            sb.append("/").append(Build.VERSION.RELEASE);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ").append(Build.VERSION.RELEASE);
        }
        if (z3 || z2) {
            sb.append(";");
            if (z3) {
                sb.append(" ").append(Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/").append(Build.ID);
            }
        }
        sb.append(")");
        DEFAULT_USER_AGENT = sb.toString();
    }
}
